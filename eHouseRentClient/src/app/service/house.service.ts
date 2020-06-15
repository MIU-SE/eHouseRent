import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {House} from '../model/House'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HouseService {
  private baseURL:string;

  constructor(private http:HttpClient) {
    this.baseURL='http://localhost:8080/ehouserent/house';
   }
   
   public findAll(): Observable<House[]> {
    console.log("find all method");
   return this.http.get<House[]>(this.baseURL+'/list');
 }

 get(id: number) {
   return this.http.get(this.baseURL+ '/get/' + id);
 }

 public save(house: House) {
   return this.http.post<House>(this.baseURL+'/add', house);
 }

 public delete(id: number) {
   return this.http.delete(this.baseURL+'/delete/'+id);
 }
public getHouseByStateAndCity(state:String,city:String){
  console.log("jjjj");
  return this.http.get(this.baseURL+'/search/'+state+'/'+city);

}
 
}
