import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ButtonModule } from 'primeng/button';
import {MenubarModule} from 'primeng/menubar';
import { InputTextModule } from "primeng/inputtext";
import { InputMaskModule } from "primeng/inputmask";
import {PanelModule} from 'primeng/panel';
import {TabViewModule} from 'primeng/tabview';
import {TagModule} from 'primeng/tag';
import {FlexLayoutModule} from '@angular/flex-layout';
import {PaginatorModule} from 'primeng/paginator';
import {CardModule} from 'primeng/card';
import {NgxPaginationModule} from 'ngx-pagination';
import {DropdownModule} from 'primeng/dropdown';
import {CheckboxModule} from 'primeng/checkbox';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
  ],
  exports: [
    ButtonModule,
    MenubarModule,
    InputTextModule,
    InputMaskModule,
    PanelModule,
    TabViewModule,
    TagModule,
    FlexLayoutModule,
    PaginatorModule,
    CardModule,
    NgxPaginationModule,
    DropdownModule,
    CheckboxModule
  ],
})
export class PrimengModule {}
