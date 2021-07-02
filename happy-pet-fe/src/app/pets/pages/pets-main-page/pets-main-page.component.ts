import {Component, OnInit} from '@angular/core';
import {BreadcrumbService} from '../../../shared/services';
import {CityModel} from '../../../shared/models/city.model';
import {CityService} from '../../services/city.service';

@Component({
  selector: 'app-main-page',
  templateUrl: './pets-main-page.component.html',
  styleUrls: ['./pets-main-page.component.scss'],
})
export class PetsMainPageComponent implements OnInit {

  //preset
  cities!: CityModel[] ;

  //boolean
  isVaccinated!: boolean

  //selected values to transfer
  selectedCity!: CityModel;

  constructor(private cityService: CityService,
              private breadcrumbService: BreadcrumbService

  ) { this.cities = []}

  ngOnInit(): void {
    this.initBreadCrumbItems()
    this.retrieveCities();
  }

  retrieveCities(): void {
    this.cityService.getCities()
      .subscribe(
        response => {
          const { items } = response;
          this.cities = items;
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
      },
    ]);
  }

  public show( ) {
    console.log("Main component- " + this.isVaccinated)
  }

}
