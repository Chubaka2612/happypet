import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpHeaders,
} from '@angular/common/http';

import { Observable } from 'rxjs';
import {environment} from '../../../environments/environment';

@Injectable()
export class ApiInterceptor implements HttpInterceptor {

  constructor() {}

  private static isAbsoluteUrl(urlString: string): boolean {
    const absoluteHttpUriPattern = /^https?:\/\//i;

    return absoluteHttpUriPattern.test(urlString);
  }

  public intercept(req: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    if (ApiInterceptor.isAbsoluteUrl(req.url)) {
      return next.handle(req);
    }
    const { apiURL } = environment;
    const clonedReq = req.clone({
      url: `${apiURL}${req.url}`,
      headers: new HttpHeaders({
      }),
    });
    return next.handle(clonedReq);
  }
}
