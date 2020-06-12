import { Component, OnInit } from '@angular/core';
import {House} from '../model/House'
import {HouseService} from '../service/house.service'

@Component({
  selector: 'app-house-list',
  templateUrl: './house-list.component.html',
  styleUrls: ['./house-list.component.css']
})
export class HouseListComponent implements OnInit {

  houses:House[];

  constructor(private houseService:HouseService) { }

  ngOnInit(): void {
    this.houseService.findAll().subscribe(data=>{
      this.houses=data;
    })
  }

  deleteHouse(id:number){
    if(confirm("Are you sure to delete "+name)) {
      this.houseService.delete(id).subscribe(data=>{
        console.log(data);
        this.houseService.findAll().subscribe(data =>{
          this.houses=data;
        })
      },
      error=>console.log(error));
    }

  }
}
