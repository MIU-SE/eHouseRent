import { Component, OnInit } from '@angular/core';
import {NgbDateStruct, NgbCalendar} from '@ng-bootstrap/ng-bootstrap';
import { Booking } from '../model/Booking';
import { Subscription } from 'rxjs';
import {BookingService} from '../service/booking.service';
import { ActivatedRoute, Router } from '@angular/router';
import { House } from '../model/House';

@Component({
  selector: 'app-house-booking',
  templateUrl: './house-booking.component.html',
  styleUrls: ['./house-booking.component.css']
})
export class HouseBookingComponent implements OnInit {
  model1: NgbDateStruct;
  model2: NgbDateStruct;
  booking:Booking;
  sub:Subscription;
  date: {year: number, month: number};

  constructor(private route:ActivatedRoute, private router:Router, private bookingService:BookingService) { 
    this.booking=new Booking();
    this.booking.house= new House();
    
  }

  ngOnInit(): void {
  }

  onSubmit(){
    console.log("on submit");
    this.bookingService.save(this.booking).subscribe(result => this.gotoHouseList())
  }

  gotoHouseList(){
    this.router.navigate(['/house/list']);
  }
  


}
