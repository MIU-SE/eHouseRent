import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HouseService} from '../service/house.service';
import {House} from '../model/House';
import { Subscription } from 'rxjs';
@Component({
  selector: 'app-house-form',
  templateUrl: './house-form.component.html',
  styleUrls: ['./house-form.component.css']
})

export class HouseFormComponent implements OnInit {

  house: House;
  sub: Subscription;

  constructor(private route: ActivatedRoute, private router: Router, private houseService: HouseService) {
    this.house = new House();
  }

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.houseService.get(id).subscribe((house: any) => {
          if (house) {
            this.house = house;
          } else {
            console.log(`House with id '${id}' not found, returning to list`);
            this.gotoHouseList();
          }
        });
      }
    });
  }

  onSubmit(){
    this.houseService.save(this.house).subscribe(result => this.gotoHouseList())
  }

  gotoHouseList(){
    this.router.navigate(['/house/list']);
  }

}
