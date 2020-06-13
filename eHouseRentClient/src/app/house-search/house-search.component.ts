import { Component, OnInit } from '@angular/core';

import { ActivatedRoute, Router } from '@angular/router';
import {House} from '../model/House'
import {HouseService} from '../service/house.service'


@Component({
  selector: 'app-house-search',
  templateUrl: './house-search.component.html',
  styleUrls: ['./house-search.component.css']
})
export class HouseSearchComponent implements OnInit {


  
  state:String;
  city:String;

  constructor(private route: ActivatedRoute, private router:Router,private houseService:HouseService) { }

  ngOnInit(): void {}


  
   
searchHouse() {
  
    this.houseService.getHouseByStateAndCity(this.state,this.city)
    .subscribe(result => this.gotoHouseList())
  

    }

    gotoHouseList(){
      this.router.navigate(['/house/list']);
    }
      
  
    }
  
  


  