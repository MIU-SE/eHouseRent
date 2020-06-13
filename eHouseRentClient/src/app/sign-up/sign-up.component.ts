import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {House} from '../model/House'
import{UserService}from '../service/user.service';
import { User } from '../model/user';
import { Subscription } from 'rxjs';




@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})

export class SignUpComponent implements OnInit {

user:User;
userservice:UserService;

 constructor(private route: ActivatedRoute, private router:  Router, userservice: UserService) {
     this.user = new User();
    this.userservice=userservice;
   }

   ngOnInit(): void {
    
   }
   onSubmit() {
     this.userservice.save(this.user).subscribe(result => this.getUserList())
    
       
}
getUserList(){
    this.router.navigate(['/list']);
  }
  
}


