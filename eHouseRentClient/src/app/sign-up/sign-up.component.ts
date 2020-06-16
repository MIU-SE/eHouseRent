import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {House} from '../model/House';
import {UserService} from '../service/user.service';
import { User } from '../model/user';
import { Subscription } from 'rxjs';
import { Address} from '../model/Address'
import { Role } from '../model/role';
import{} from '../model/userRole';




@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})

export class SignUpComponent implements OnInit {

user:User;
userservice:UserService;
roles:Role[];

 constructor(private route: ActivatedRoute, private router:  Router, userservice: UserService) {
     this.user = new User();
    this.userservice=userservice;
    this.user.address=new Address();
  
   }

   ngOnInit(): void {
    this.userservice.getAllRole().subscribe(result=>{
      // console.log("result"+result)
     this.roles=result;
    });
   }
   onSubmit() {
     console.log("l;lll");
    //  this.user.role=this.roles.find(x=>x.role="owner");
     this.userservice.save(this.user).subscribe(result => 
      this.getUserList())
    
     


}


getUserList(){
    this.router.navigate(['/house/list']);
  }

}


