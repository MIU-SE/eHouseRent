import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Booking} from '../model/Booking'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  private baseURL:string;

  constructor(private http:HttpClient) {
    this.baseURL='http://localhost:8080/ehouserent/booking';
   }
   
   public findAll(): Observable<Booking[]> {
    console.log("find all method");
   return this.http.get<Booking[]>(this.baseURL+'/list');
 }

 get(id: number) {
   return this.http.get(this.baseURL+ '/get/' + id);
 }

 public save(booking: Booking) {
   return this.http.post<Booking>(this.baseURL+'/add', booking);
 }

 public delete(id: number) {
   return this.http.delete(this.baseURL+'/delete/'+id);
 }
}
