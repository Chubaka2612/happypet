import { Injectable } from '@angular/core';
import {environment} from '../../../../environments/environment';

@Injectable()
export class AwsS3Service {

  constructor() { }

  retrieveAnimalAvatar(avatarUrl: string) : string{
    const { awsS3Bucket } = environment;

    const config = require('./aws_config.json');
    const AWS = require('aws-sdk');
    AWS.config.update({
      accessKeyId: config.accessKeyId,
      secretAccessKey: config.secretAccessKey,
      region: config.region
    });

     let s3 = new AWS.S3();
     const url = s3.getSignedUrl('getObject', {
        Bucket: awsS3Bucket,
        Key: avatarUrl
    })
   return url;
  }
}
