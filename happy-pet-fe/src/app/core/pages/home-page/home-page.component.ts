import { Component, OnInit } from '@angular/core';
import {BreadcrumbService} from '../../../shared/services';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {

  constructor(private breadcrumbService: BreadcrumbService) { }

  ngOnInit(): void {
    this.initBreadCrumbItems();
  }

  private initBreadCrumbItems(): void {
    this.breadcrumbService.initBreadCrumbItems([
      {
        label: '',
      },
    ]);
  }
}
