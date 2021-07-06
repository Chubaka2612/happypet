import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {AnimalModel} from '../../../shared/models/animal.model';
import {PetService} from '../../services/pet.service';
import {CityModel} from '../../../shared/models/city.model';

@Component({
  selector: 'app-pets-list',
  templateUrl: './pets-list.component.html',
  styleUrls: ['./pets-list.component.scss'],
})
export class PetsListComponent implements OnInit, OnChanges {

  //list
  animals: AnimalModel[] = [];

  //received from parent
  @Input() selectedCity?: CityModel;
  @Input() isVaccinated?: boolean;

  // pagination
  page = 1;
  count = 0;
  pageSize = 3;
  pageSizes = [3, 6, 9];

  constructor(
    private petsService: PetService) {
  }

  ngOnChanges(changes: SimpleChanges): void {
    //track changes on parent component
    this.retrieveAnimals()
  }

  ngOnInit(): void {
    this.retrieveAnimals();
  }

  retrieveStatistics(): void {
    this.petsService.getStatistics()
      .subscribe(
        response => {
          //show only animals available for booking
          this.count = response.item.inShelters;
          console.log(response);
        },
        error => {
          console.log(error);
        });
  }

  private static getRequestParams(page: number,
                                  pageSize: number,
                                  cityId: number | undefined,
                                  isVac: boolean | undefined): any {
    let params: any = {};

    if (isVac) {
      params[`isVaccinated`] = isVac;
    }

    if (page) {
      params[`page`] = page - 1;
    }

    if (pageSize) {
      params[`size`] = pageSize;
    }

    if (cityId) {
      params[`cityId`] = cityId;
    }

    //show only animals available for booking
    params['isBooked'] = false;

    return params;
  }

  retrieveAnimals(): void {
    let params = PetsListComponent.getRequestParams(this.page, this.pageSize, this.selectedCity?.id, this?.isVaccinated)
    this.petsService.getAnimals(params)
      .subscribe(
        response => {
          const {items, totalItems} = response;
          this.animals = items;
          if (totalItems != null) {
            this.count = totalItems;
          }
          console.log(response);
        },
        error => {
          console.log(error);
        });
  }

  handlePageChange(event: number): void {
    this.page = event;
    this.retrieveAnimals();
  }

  handlePageSizeChange(event: any): void {
    this.pageSize = event.target.value;
    this.page = 1;
    this.retrieveAnimals()
  }
}
