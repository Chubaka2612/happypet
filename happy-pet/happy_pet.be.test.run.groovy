pipeline {

  tools {
    gradle "my_gradle"
  }

  agent any

  stages {

    stage('Run Unit Tests') {
      steps {
        dir('happy-pet') {
          script {
            try {
              bat "gradle clean test --tests com.epam.sdet.happypet.unit*"
            }
            finally {
              junit '**/build/test-results/test/*.xml'
            }
          }
        }
      }
    }
    stage('Run Integration Tests') {
      steps {
        dir('happy-pet') {
          script {
            try {
              bat "gradle clean test --tests com.epam.sdet.happypet.integration*"
            }
            finally {
              junit '**/build/test-results/test/*.xml'
            }
          }
        }
      }
    }

    stage('Build Docker Image') {
      steps {
        dir('happy-pet') {
          script {
            bat 'gradle clean build -x test'
            bat 'docker build -f Dockerfile .'
          }
        }
      }
    }
    stage('Deploy to Test env') {
      steps {
        dir('happy-pet') {
          bat "docker-compose up -d --force-recreate"
        }
      }
    }

    stage('Execute Automation Api Tests') {
      steps {
        dir('happy-pet-automation') {
          script {
            try {
              bat "gradle clean test --tests com.epam.sdet.happypet.tests.api*"
            }
            finally {
              junit '**/build/test-results/test/*.xml'
            }
          }
        }
      }
    }
  }
  post {
    always {
      script {
        echo "********** Post action started ********** "
        def buildStatus = currentBuild.currentResult
        if (buildStatus == 'UNSTABLE') {
          echo 'Some tests failed. See test result report'
        }
        cleanWs()
        echo "********** Post action completed ********** "
      }
    }
  }
}