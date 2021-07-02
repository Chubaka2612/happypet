import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {AnimalModel} from '../../shared/models/animal.model';
import {ItemsResponse} from '../../shared/models';
import {ItemResponse} from '../../shared/models/item-response.model';
import {OwnerModel} from '../../shared/models/owner.model';
import {AnimalStatisticsModel} from '../../shared/models/animal-statistics.model';

@Injectable({
  providedIn: 'root'
})
export class PetService {

  constructor(private httpClient: HttpClient) {
  }

  public getAnimals(params: any): Observable<ItemsResponse<AnimalModel>> {
    return this.httpClient.get<ItemsResponse<AnimalModel>>(`/animals/search`, { params });
  }

  public getStatistics(): Observable<ItemResponse<AnimalStatisticsModel>> {
    return this.httpClient.get<ItemResponse<AnimalStatisticsModel>>(`/animals/statistics`);
  }

  public getAnimal(id: number): Observable<ItemResponse<AnimalModel>> {
    return this.httpClient.get<ItemResponse<AnimalModel>>(`/animals/${id}`);
  }

  public bookAnimal(id: number, data: OwnerModel): Observable<ItemResponse<AnimalModel>> {
    return this.httpClient.patch<ItemResponse<AnimalModel>>(`/animals/${id}`, data);
  }
}
