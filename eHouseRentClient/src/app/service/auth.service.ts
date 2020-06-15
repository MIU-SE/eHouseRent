import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaderResponse, HttpHeaders, HttpHandler } from '@angular/common/http'


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  // private _loginUrl = "http://localhost:8080/authenticate";

  private _basicUrl="http://localhost:8080/ehouserent/"

  constructor(private http: HttpClient) { }

  public login(credentials){
    // const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
   console.log("userName= "+credentials.username);
   
    return this.http.post<any>(this._basicUrl+"signin", {
      userName:credentials.username,
      passWord:credentials.password
    }, httpOptions);
    // this.http.get(this._basicUrl+'/hello',{headers,responseType:'text' as 'json'});
  }


  // getUsers() {
  //   const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa("selam@gh" + ':' + "1212") });
  //  return  this.http.get(this._basicUrl+'/welcome',{headers});
  // }


  // public generateToken(request){
  //   return this.http.post(this._loginUrl, request, {responseType:'text' as 'json'});
  // }

  // public welcome(token){
  //   let tokenStr='Bearer '+token;
  //   const headers=new HttpHeaders().set("Authorization", tokenStr)
  //   console.log(tokenStr);
    
  //   return this.http.get<String>(this._welcome,{headers,responseType:'text' as 'json'});
  // }


}
