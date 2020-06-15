import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private messageSource = new BehaviorSubject("default");
  currentMessage = this.messageSource.asObservable();

  constructor() { }

  changeMessage(message: string) {
    
    console.log("in serive= "+ message);
    
    this.messageSource.next(message)
  }

  // getData(){
  //   let d;
  //   d=decode(this.tokenStorageService.getToken());
  //   console.log(d);
    
  //   // if(d!=null){
  //   //   return d;
  //   // else
  //   return d!=null? d['sub']:"guest"
    
  // }
}
