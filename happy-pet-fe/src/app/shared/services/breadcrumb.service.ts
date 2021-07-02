import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import {BreadcrumbItem} from '../models';

@Injectable({
  providedIn: 'root',
})
export class BreadcrumbService {
  public breadcrumbItems$: Observable<BreadcrumbItem[]>;

  private breadcrumb = new BehaviorSubject<BreadcrumbItem[]>( []);

  constructor() {
    this.breadcrumbItems$ = this.breadcrumb.asObservable();
  }

  private get breadcrumbItems(): BreadcrumbItem[] {
    return [...this.breadcrumb.value];
  }

  public initBreadCrumbItems(items: BreadcrumbItem[]): void {
    this.breadcrumb.next(items);
  }

}
