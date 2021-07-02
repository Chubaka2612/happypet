import {Component, Input, OnInit} from '@angular/core';
import {AnimalModel} from '../../../shared/models/animal.model';
import {PetService} from '../../services/pet.service';
import {BreadcrumbService} from '../../../shared/services';
import {ActivatedRoute} from '@angular/router';
import {switchMap} from 'rxjs/operators';

@Component({
  selector: 'app-pets-details-page',
  templateUrl: './pets-details-page.component.html',
  styleUrls: ['./pets-details-page.component.scss'],
})
export class PetsDetailsPageComponent implements OnInit {

 public animal!: AnimalModel;

  constructor( private petsService: PetService,
               private breadcrumbService: BreadcrumbService,
               private route: ActivatedRoute,


  ) { }

  ngOnInit(): void {

    this.route.paramMap.pipe(
      switchMap(params =>
        this.petsService.getAnimal(Number(params.get('id'))),
      )
    ).subscribe(response => {
        const item = response.item
        this.animal = item;
        this.initBreadCrumbItems();
        console.log(response);
      },
      error => {
        console.log(error);
      });
  }

  private initBreadCrumbItems(): void {
    this.breadcrumbService.initBreadCrumbItems([
      {
        label: 'Home',
        url:'home'
      },
      {
        label: 'Shelter Animal',
        url:'pets'
      },
      {
        label: `${this.animal.name}`,
      },
    ]);
  }
}
