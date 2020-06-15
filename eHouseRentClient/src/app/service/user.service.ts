import { Injectable } from '@angular/core';
import{HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { ThrowStmt } from '@angular/compiler';
import { Role } from '../model/role';
import { userRole } from '../model/userRole';


@Injectable({
  providedIn: 'root'
})
export class UserService {


  private baseURL:string;
  
  constructor(private http:HttpClient) { 
  this.baseURL='http://localhost:8080/ehouserent/user';
  
  }

  public save(user: User) { 
    // console.log("hhhh "+user.role.roleId);
    return this.http.post<User>(this.baseURL+'/add', user);
    console.log("hhhh "+user.address.city);

  }

  public getAllRole(): Observable<Role[]> {
    console.log("user.role");
   return this.http.get<Role[]>(this.baseURL+'/role/list');
   
 }
}
