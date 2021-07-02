import {Component, Input, OnInit} from '@angular/core';
import {AnimalModel} from '../../../shared/models';

@Component({
  selector: 'app-pets-details',
  templateUrl: './pets-details.component.html',
  styleUrls: ['./pets-details.component.scss'],
})
export class PetsDetailsComponent implements OnInit {

  @Input ()  animal!: AnimalModel;

  ngOnInit(): void {
  }
}
