import { LoginService } from './../../services/login.service';
import { FormControl, FormGroup } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router } from '../../../../node_modules/@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  wrongCredentials = false;
  isDataLoaded = true;
  isAuthenticated = () => this.loginService.isAuthenticated();

  constructor(private loginService: LoginService, private router: Router) {
    console.log(localStorage.getItem('refresh_token') !== null);
    if (localStorage.getItem('refresh_token')) {
      if (!this.loginService.isAuthenticated()) {// check whether the user's access token is expired or not
        console.log('going to refresh token');
        this.isDataLoaded = false;
        this.loginService.refreshToken().subscribe(result => {
          this.loginService.storeTokenInfo(result['access_token'], result['expires_in']);
          this.isAuthenticated();
          this.isDataLoaded = true;
        }, err => console.error('error from refreshToken(): ', err));
      }
    }
    this.loginForm = new FormGroup({
      email: new FormControl(),
      password: new FormControl()
    });
  }

  ngOnInit() {
  }

  onSubmit({ value, Valid }) {
    const userCredentials = { email: value.email, password: value.password };
    this.loginService.login(userCredentials).subscribe(result => { // store the user credentials TODO store full name & profile img
      this.loginService.storeTokenInfo(result['access_token'], result['expires_in'], result['refresh_token'], result['user']);
      this.isAuthenticated();
      console.log("login done ",result);
      this.loginService.redirectUser(localStorage.getItem('role'));
    }, err => {
      if (err.status === 400) {
        console.log('error 400');
        this.wrongCredentials = true;
        this.router.navigate(['/login']);
      }
    });
  }

}
