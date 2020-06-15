import { Component, OnInit } from '@angular/core';
import { House } from '../model/House';
import { HouseService } from '../service/house.service'

@Component({
  selector: 'app-filtered-house-list',
  templateUrl: './filtered-house-list.component.html',
  styleUrls: ['./filtered-house-list.component.css']
})
export class FilteredHouseListComponent implements OnInit {
  houses: House[];
  constructor(private houseService:HouseService) { }

  ngOnInit(): void {
    // this.houseService.currentHouse.subscribe(message=>this.houses=message);
    // console.log("houses are"+this.houses);
    
  }




}
