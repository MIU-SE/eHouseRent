import { Component, OnInit } from '@angular/core';
import { NgbDateStruct, NgbCalendar } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute, Router } from '@angular/router';
import { House } from '../model/House'
import { HouseService } from '../service/house.service'
import { BookingService } from '../service/booking.service'
import { Subscription } from 'rxjs';
import { Booking } from '../model/Booking';
import * as moment from 'moment';
import { TokenStorageService } from '../service/token-storage.service'
import * as decode from 'jwt-decode';


@Component({
  selector: 'app-house-search',
  templateUrl: './house-search.component.html',
  styleUrls: ['./house-search.component.css']
})
export class HouseSearchComponent implements OnInit {
  houses: House[];

  state: String;
  city: String;
  model1: NgbDateStruct;
  model2: NgbDateStruct;
  booking: Booking;
  houseLocal: House;
  sub: Subscription;
  date: { year: number, month: number };
  check_in_date: Date;
  check_out_date: Date;
  houseId: number;
  diffInDays:number;
  Guest:String;

  constructor(private route: ActivatedRoute, private router: Router, 
    private houseService: HouseService, private bookingService: BookingService, private tokenStorageService:TokenStorageService) {
    this.booking = new Booking();
    this.houseLocal = new House();

  }

  ngOnInit(): void {
    this.Guest=decode(this.tokenStorageService.getToken())['sub']
  }

  searchHouse() {

      let firstDate=this.model1;
      let secondDate=this.model2;
      this.diffInDays = Math.abs(moment(firstDate).diff(moment(secondDate), 'days'));
      console.log("difference in days= "+this.diffInDays);
  
      this.houseService.getHouseByStateAndCity(this.state, this.city)
        .subscribe(result => {
          this.houses = result;
          console.log("searching is on the way"+this.houses[1]+" eee");
        })

    
  }
  getHouse() {
    //  this.booking.house.houseId = this.houseLocal.houseId;
    
    this.houseService.get(this.houseId).subscribe(newhouse => {
      this.houseLocal = newhouse;
      console.log("searching is on the way");
    });
  }


  saveBooking() {
        if(this.Guest!=null){
    // this.booking.house = this.houseLocal;
    // console.log(this.booking.house.houseId)
    // console.log("bokking check date= "+moment(this.booking.checkInDate))

    console.log("checking date= "+this.model1.year);
    this.booking.checkInDate=new Date(this.model1.year+"-"+this.model1.month+"-"+this.model1.day);
    this.booking.checkOutDate=new Date(this.model2.year+"-"+this.model2.month+"-"+this.model2.day);
    // this.booking.totalPrice=3200;
    this.bookingService.save(this.booking).subscribe(result => {
      console.log("result: "+result);
      this.gotoSuccesfulPage();
    });
    console.log("booking is on the way")
    }
    else{
      alert("you have to sign in first");
      
    }
  }


  gotoSuccesfulPage() {
    this.router.navigate(['house/booking']);

  }

}




