import {Component, Inject, OnInit} from '@angular/core';
import {PetService} from '../../services/pet.service';
import {ActivatedRoute} from '@angular/router';
import {switchMap} from 'rxjs/operators';
import {OwnerModel} from '../../../shared/models';
import {ToastService} from '../../../shared/services';
import {PetsDetailsPageComponent} from '../../pages';

@Component({
  selector: 'app-booking-form',
  templateUrl: './booking-form.component.html',
  styleUrls: ['./booking-form.component.scss'],
})
export class BookingFormComponent implements OnInit {

  firstName: any ;
  lastName: any;
  phoneNumber: any;

  constructor(private petsService: PetService,
              private route: ActivatedRoute,
              private toastService: ToastService,
              @Inject(PetsDetailsPageComponent) private parent: PetsDetailsPageComponent) { }

  ngOnInit(): void {
  }

  public bookAnimal(): void {
    const data: OwnerModel = {
      firstName : this.firstName,
      lastName : this.lastName,
      phoneNumber : this.phoneNumber
    };

    this.route.paramMap.pipe(
      switchMap(params =>
        this.petsService.bookAnimal(Number(params.get('id')), data),
      )
    ).subscribe(
      (response) => {
        // to skip page refresh
        this.parent.animal = response.item;
        console.log(response)
        this.toastService.showSuccessMessage("Animal was bocked. Please wait for further details from our managers");
      },
      (error) => {
        console.error(error);
        this.toastService.showErrorMessage("Animal was not bocked. Please try again");
      }
    );
  }

  public confirmBooking() {
    this.toastService.showConfirm();
  }

  public onConfirm () {
    this.toastService.onConfirm();
    this.bookAnimal();
  }

  public onReject () {
    this.toastService.onReject();
  }
}
