import { NgModule } from '@angular/core';
import {NotFoundPageComponent} from './pages/not-found-page/not-found-page.component';
import {PageContainerComponent} from './components/page-container/page-container.component';
import {PrimengModule} from './primeng/primeng.module';
import {CommonModule} from '@angular/common';
import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {ApiInterceptor, ErrorInterceptor} from './interceptors';
import {ToastModule} from 'primeng/toast';

@NgModule({
  declarations: [NotFoundPageComponent, PageContainerComponent],
  imports: [
    PrimengModule,
    CommonModule,
    ToastModule
  ],
  exports: [
    PageContainerComponent,
    PrimengModule
  ],
  providers:[
    { provide: HTTP_INTERCEPTORS, useClass: ApiInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
  ]
})
export class CoreModule { }
