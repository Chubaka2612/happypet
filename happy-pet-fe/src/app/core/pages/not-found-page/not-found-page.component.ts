import {Component, OnInit} from '@angular/core';
import { Location } from '@angular/common';
import {BreadcrumbService} from '../../../shared/services';

@Component({
  selector: 'app-not-found-page',
  templateUrl: './not-found-page.component.html',
  styleUrls: ['./not-found-page.component.scss']
})
export class NotFoundPageComponent implements OnInit {

  constructor(
    private location: Location,
    private breadcrumbService: BreadcrumbService) { }

  ngOnInit(): void {
    this.initBreadCrumbItems();
  }

  public goBack(): void {
    this.location.back();
  }

  private initBreadCrumbItems(): void {
    this.breadcrumbService.initBreadCrumbItems([
      {
        label: 'Home',
        url:'home'
      },
      {
        label: 'Page Not Found',
      },
    ]);
  }
}
