import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import * as decode from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private messageSource = new BehaviorSubject(this.getData());
  currentMessage = this.messageSource.asObservable();

  constructor() { }

  changeMessage(message: string) {
    this.messageSource.next(message)
  }

  getData(){
    // let d;
    // d=decode(this.tokenStorageService.getToken());
    let d=sessionStorage.getItem("auth-token");
    
    let decoded=decode(d)['sub']
    console.log("decodedd: "+decoded);
    console.log(decoded);
    
    // if(d!=null){
    //   return d;
    // else
    // return d!=null? d['sub']:"guest"
    return decoded;
    
  }
}
