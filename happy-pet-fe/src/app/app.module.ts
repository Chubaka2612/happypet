import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './core/pages/home-page/home-page.component';
import { CoreModule } from './core/core.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PetsListComponent } from './pets/components/pets-list/pets-list.component';
import { HttpClientModule } from '@angular/common/http';
import { PetsMainPageComponent } from './pets/pages/pets-main-page/pets-main-page.component';
import { PetsDetailsComponent } from './pets/components/pets-details/pets-details.component';
import { BookingFormComponent } from './pets/components/booking-form/booking-form.component';
import { PetsDetailsPageComponent } from './pets/pages/pets-details-page/pets-details-page.component';
import { MessageService } from 'primeng/api';
import {ToastModule} from 'primeng/toast';
import {ToastService} from './shared/services';
import {AwsS3Service} from './shared/services/aws/aws-s3.service';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    PetsListComponent,
    PetsMainPageComponent,
    PetsDetailsComponent,
    BookingFormComponent,
    PetsDetailsPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CoreModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ToastModule,

  ],
  providers: [
    MessageService,
    ToastService,
    AwsS3Service,
    PetsListComponent //for binding with parent component
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
