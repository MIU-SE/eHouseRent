import { Component, Input } from '@angular/core';
import { TokenStorageService } from './service/token-storage.service'
import { ActivatedRoute, Router } from '@angular/router';
import { DataService} from './service/data.service'
import * as decode from 'jwt-decode';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'eHouseRentClient';
  Guest:String;
  
  constructor(private data: DataService ,private tokenStorageService:TokenStorageService, private router: 
    Router ){

   
  }
  ngOnInit() {
   
    this.data.currentMessage.subscribe(message=>this.Guest=message)
    // this.Guest=decode(this.tokenStorageService.getToken())['sub']
  }
  
  signout(){
    this.tokenStorageService.signOut();
    this.data.currentMessage.subscribe(message=>this.Guest="Guset")
    this.router.navigate(['/login']);
    // window.;
  }

}
