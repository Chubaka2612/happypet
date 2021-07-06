import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor, HttpErrorResponse,
} from '@angular/common/http';
import {Observable, of, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {Router} from '@angular/router';

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {

  constructor(
    private router: Router,
  ) {}

  public intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(req).pipe(
      catchError((error) => {
        let handled: boolean = false;
        console.error(error);
        if (error instanceof HttpErrorResponse) {
          switch (error.status) {
            case 404:
              this.router.navigateByUrl('404');
              console.log('Resource was not found. Redirect to 404');
              handled = true
              break
            case 400:
              console.log('Bad Request');
              break;
          }
        }
        if (handled) {
          return of(error); //return back
        } else {
          return throwError(error);//throw error back to to the subscriber
        }
      })
    )
  }
}
