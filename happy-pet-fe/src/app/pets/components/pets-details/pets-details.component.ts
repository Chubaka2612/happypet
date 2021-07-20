import {Component, Input, OnInit} from '@angular/core';
import {AnimalModel} from '../../../shared/models';
import {AwsS3Service} from '../../../shared/services/aws/aws-s3.service';

@Component({
  selector: 'app-pets-details',
  templateUrl: './pets-details.component.html',
  styleUrls: ['./pets-details.component.scss'],
})
export class PetsDetailsComponent implements OnInit {

  @Input ()  animal!: AnimalModel;

  constructor(
    private awsS3Service: AwsS3Service) {
  }

  retrieveAnimalAvatar(avatarUrl: string): string {
    return this.awsS3Service.retrieveAnimalAvatar(avatarUrl)
  }

  ngOnInit(): void {
  }
}
