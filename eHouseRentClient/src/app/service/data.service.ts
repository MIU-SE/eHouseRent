import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import * as decode from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private messageSource = new BehaviorSubject(this.getData());
  // private messageSource = new BehaviorSubject('guset');
  currentMessage = this.messageSource.asObservable();

  constructor() { }

  changeMessage(message: string) {
    this.messageSource.next(message)
  }

  getData(){
    // let d;
    // d=decode(this.tokenStorageService.getToken());
    try{
      let d=sessionStorage.getItem("auth-token");
    
      let decoded=decode(d)['sub']
      console.log("decodedd: "+decoded);
      return decoded;
    // console.log(decoded);
    }
    catch(e){
        console.log("error: "+e);
        return 'guest';
    }
    
    
    // if(d!=null){
    //   return d;
    // else
    // return d!=null? d['sub']:"guest"
    
    // if(decode!=null)
    //   return decoded;
    // return 'guest';
    
  }
}
