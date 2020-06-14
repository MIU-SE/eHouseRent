import { Component, OnInit } from '@angular/core';
import {House} from '../model/House'
import {HouseService} from '../service/house.service'
import * as decode from 'jwt-decode';
import { TokenStorageService } from '../service/token-storage.service'

@Component({
  selector: 'app-house-list',
  templateUrl: './house-list.component.html',
  styleUrls: ['./house-list.component.css']
})
export class HouseListComponent implements OnInit {

  houses:House[];
  public Guest;
  constructor(private houseService:HouseService,private tokenStorageService:TokenStorageService) { }
public data;
  ngOnInit(): void {
    // this.data=sessionStorage.getItem("auth-token");
    // const payload=decode(this.data)
    // for(this.i in payload)
    //     console.log("role "+this.i);

    console.log(sessionStorage.getItem("auth-token"));
    this.Guest=decode(this.tokenStorageService.getToken())['sub']

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
