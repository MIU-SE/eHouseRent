import { Component, OnInit } from '@angular/core';
import { NgbDateStruct, NgbCalendar } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute, Router } from '@angular/router';
import { House } from '../model/House'
import { HouseService } from '../service/house.service'
import { BookingService } from '../service/booking.service'
import { Subscription } from 'rxjs';
import { Booking } from '../model/Booking';


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


  constructor(private route: ActivatedRoute, private router: Router, private houseService: HouseService, private bookingService: BookingService) {
    this.booking = new Booking();
    this.houseLocal = new House();


  }

  ngOnInit(): void {
  }
  searchHouse() {
    this.houseService.getHouseByStateAndCity(this.state, this.city)
      .subscribe(result => {
        this.houses = result;
      })
  }
  getHouse() {
    //  this.booking.house.houseId = this.houseLocal.houseId;
    this.houseService.get(this.houseId).subscribe(newhouse => {
      this.houseLocal = newhouse;
    });
  }


  saveBooking() {
    // this.booking.house = this.houseLocal;
    console.log(this.booking.house.houseId)
    // console.log(this.houseLocal)
    this.bookingService.save(this.booking).subscribe(result => this.gotoSuccesfulPage())
    console.log("bokinnggg is on the way")
    console.log(this.booking.check_in_date)
    console.log(this.booking.check_out_date)
    console.log(this.houseLocal)
  }


  gotoSuccesfulPage() {
    this.router.navigate(['house/booking']);

  }

}




