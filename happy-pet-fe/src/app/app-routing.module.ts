import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomePageComponent} from './core/pages/home-page/home-page.component';
import {NotFoundPageComponent} from './core/pages/not-found-page/not-found-page.component';
import {PetsDetailsPageComponent, PetsMainPageComponent} from './pets/pages';

const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: '', redirectTo: '/home', pathMatch: 'full'
      },
      {
        path: 'home', component: HomePageComponent,
      },
      {
        path: 'pets', component: PetsMainPageComponent
      },
      {
        path: 'pets/:id', component: PetsDetailsPageComponent
      },
      {
        path: '**', component: NotFoundPageComponent,
      }
    ]
  }];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
