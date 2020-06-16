import { Component, Input } from '@angular/core';
import { TokenStorageService } from './service/token-storage.service'
import { ActivatedRoute, Router } from '@angular/router';
import { DataService} from './service/data.service'
import {Subscription} from 'rxjs'
import * as decode from 'jwt-decode';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'eHouseRentClient';
  Guest:String;
  sub:Subscription;
  
  constructor(private data: DataService ,private tokenStorageService:TokenStorageService, private router: 
    Router ){

   
  }
  ngOnInit() {
   this.sub=this.data.currentMessage.subscribe(item=>this.Guest=item);
    // this.data.currentMessage.subscribe(message=>this.Guest=message)
    // this.Guest=decode(this.tokenStorageService.getToken())['sub']
  }
  
  ngOnDestroy(){
    this.sub.unsubscribe();
  }
  signout(){
    this.tokenStorageService.signOut();
    // this.data.currentMessage.subscribe(message=>this.Guest="guest")
    this.data.changeMessage("guest");
    this.router.navigate(['/login']);
    // window.;
  }

}
