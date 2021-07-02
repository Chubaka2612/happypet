import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';

import {Observable} from 'rxjs';
import {ItemsResponse} from '../../shared/models';
import {CityModel} from '../../shared/models/city.model';

@Injectable({
  providedIn: 'root'
})
export class CityService {

  constructor(private httpClient: HttpClient) {
  }

  public getCities(): Observable<ItemsResponse<CityModel>> {
    return this.httpClient.get<ItemsResponse<CityModel>>(`/cities/list`);
  }

}
