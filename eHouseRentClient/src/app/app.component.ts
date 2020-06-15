import { Component } from '@angular/core';
import { TokenStorageService } from './service/token-storage.service'
import * as decode from 'jwt-decode';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'eHouseRentClient';
  Guest='';
  constructor(private tokenStorageService:TokenStorageService){

   
  }
  ngOnInit() {
     this.Guest=decode(this.tokenStorageService.getToken())['sub']
  }
  

}
