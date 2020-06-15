import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/auth.service';
import { TokenStorageService } from '../service/token-storage.service';
import * as decode from 'jwt-decode';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService} from '../service/data.service'


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {

  username: String;

  password:String;
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
  myGuest:string;

  constructor(private d: DataService, private authService: AuthService, private router: 
    Router ,private tokenStorage: TokenStorageService) { }

  ngOnInit() {
    this.d.currentMessage.subscribe(m=>this.myGuest=m)
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

        const payload=decode(data.jwt)
        this.myGuest=payload['sub'];
        console.log("payloood: "+ this.myGuest);
        
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
    this.d.changeMessage(this.myGuest);
    // window.location.reload();
    this.router.navigate(['/search/house']);
  
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
