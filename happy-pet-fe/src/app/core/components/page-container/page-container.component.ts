import { Component, OnInit } from '@angular/core';

import {MenuItem} from 'primeng/api';
import {BreadcrumbService} from '../../../shared/services';
import {Observable} from 'rxjs';
import {BreadcrumbItem} from '../../../shared/models';

@Component({
  selector: 'app-page-container',
  templateUrl: './page-container.component.html',
  styleUrls: ['./page-container.component.scss'],

})

export class PageContainerComponent implements OnInit {
  public navigationItems: MenuItem[] = [];

  constructor(private breadcrumbService: BreadcrumbService) { }

  ngOnInit(): void {
    this.defineNavMenu();
  }

  public get breadcrumbItems$(): Observable<BreadcrumbItem[]> {
    return this.breadcrumbService.breadcrumbItems$;
  }

  private defineNavMenu(): void {
    this.navigationItems = [
      {
        label: 'Shelter Animal',
        routerLink: '/pets',
        icon: 'pi pi-fw pi-home'
      },
      {
        label: 'Put in Good Hands',
        routerLink: '/give-home-page',
        icon: 'pi pi-fw pi-heart'
      },
      {
        label: 'Organizations',
        routerLink: '/organizations',
        icon: 'pi pi-fw pi-phone'
      }
    ];
  }
}
