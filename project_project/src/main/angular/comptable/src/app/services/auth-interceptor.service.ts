import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { LoginService } from './login.service';
import { Injectable } from '@angular/core';
import { tap } from 'rxjs/operators';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpResponse } from '@angular/common/http';
@Injectable()
export class AuthInterceptorService implements HttpInterceptor {

  constructor(private loginService: LoginService, private router: Router) { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let accessToken = localStorage.getItem('access_token');
    const tokenExpirationDate = parseInt(localStorage.getItem('expires_in'), 10);

    if (accessToken && this.loginService.isAuthenticated() && req.url != "/api/oauth/token") {
 
      let newReq = req.clone({
        setHeaders: {
          Authorization: 'Bearer ' + accessToken
        }
      });

      return next.handle(newReq)
        .pipe(
          tap(event => {
            if (event instanceof HttpResponse) {

              console.log(' all looks good');
              // http response status code
              console.log(event.status);
            }
          }, error => {
            // http response status code
            console.log('----response----');
            console.error('status code:');
            console.error(error.status);
            console.error(error.statusText);
            if (error.status === 400) { // refresh token has expired
              this.loginService.logout();
            }
            if (error.status === 401) { // token expired
              if (!this.loginService.isAuthenticated() && accessToken) {
                this.loginService.refreshToken();
                accessToken = localStorage.getItem('access_token');
                newReq = req.clone({
                  setHeaders: {
                    Authorization: 'Bearer ' + accessToken
                  }
                });
                return next.handle(newReq);
              }
            }
            if (error.status === 403) {
              this.loginService.logout();
            }
          })
        );
    } else {
      return next.handle(req);
    }
  }
}
