import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/auth.service';
import { TokenStorageService } from '../service/token-storage.service';
import { ActivatedRoute, Router } from '@angular/router';
import * as decode from 'jwt-decode';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: String;

  password: String;
  // message:any;

  // loginUserData = {}

  // authRequest:any={
  //     "userName":"selam@g",
  //     "passWord":"1212"
  // }

  // response:any;

  form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];

  constructor(private authService: AuthService, private router:
    Router, private tokenStorage: TokenStorageService) { }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    }
  }

  login() {

    this.authService.login(this.form).subscribe(
      data => {
        this.tokenStorage.saveToken(data.jwt);
        this.tokenStorage.saveUser(data);
        const payload = decode(data.jwt)
        console.log(payload);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
        console.log(data.jwt);

        this.reloadPage();
      },
      err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }

  reloadPage() {
    // window.location.reload();
    this.router.navigate(['/house/list']);

  }

  //   public getAccessToken(authRequest){
  //     this._auth.generateToken(authRequest).subscribe(data=>{
  //       console.log("Token: "+ data);
  //       this.accessApi(data);
  //     });
  //   }

  // public accessApi(token){
  //   let resp=this._auth.welcome(token);
  //   resp.subscribe(data=>this.response=data);

  // }

}
