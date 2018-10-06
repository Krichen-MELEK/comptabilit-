import { isUndefined } from 'util';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '../../../node_modules/@angular/router';

const tokenHeader = new HttpHeaders({
  'Authorization': 'Basic Y2xpZW50OnNlY3JldA==', // this is the encoding of (clientId:secret)
  'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
});

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient,private router: Router) { }

  login(credentials: Object) {
    const body = 'username=' + credentials['email'] + '&password=' + credentials['password'] + '&grant_type=password';
    console.log(body, { headers: tokenHeader });
    return this.http.post('/api/oauth/token', body, { headers: tokenHeader });
  }
  refreshToken() {
    console.log('refresh token()');
    const refreshToken = localStorage.getItem('refresh_token');
    const body = 'refresh_token=' + refreshToken + '&grant_type=refresh_token';
    return this.http.post('/api/oauth/token', body, { headers: tokenHeader });
  }
  isAuthenticated(): boolean {
    const currentTime = new Date().getTime(); // getting the time in seconds since 1970
    const expiresAt = JSON.parse(localStorage.getItem('expires_in'));
    return expiresAt > currentTime;
  }
  logout() {
    return this.http.post('/api/logout', JSON.parse(localStorage.getItem('user'))['email'])
      .subscribe(result => {
        console.log(JSON.parse(localStorage.getItem('user'))['email']);
        localStorage.clear();
      });
  }
  storeTokenInfo = (accessToken: string, expiresIn: string, refreshToken?: string, user?: object) => {
    const expiration = new Date().getTime() + parseInt(expiresIn, 10) * 1000;
    console.log('expiration: ' + JSON.stringify(expiration));
    localStorage.setItem('access_token', accessToken);
    localStorage.setItem('expires_in', JSON.stringify(expiration));
    if (!isUndefined(refreshToken)) {
      localStorage.setItem('refresh_token', refreshToken);
    }
    if (!isUndefined(user)) {
      localStorage.setItem('role', user['role']['name']);
      localStorage.setItem('user', JSON.stringify(user));
    }
  }
  redirectUser = (role:string)=>{
    this.router.navigate(['/'+role.toLowerCase()]);
  }
}
