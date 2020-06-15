import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HouseListComponent } from './house-list/house-list.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS  } from '@angular/common/http';

import { HouseService } from './service/house.service';
import { BookingService } from './service/booking.service';
import { AuthService } from './service/auth.service'

import { HouseFormComponent } from './house-form/house-form.component';

import { HouseSearchComponent } from './house-search/house-search.component';
import { HouseBookingComponent } from './house-booking/house-booking.component';
import {  NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { SignUpComponent } from './sign-up/sign-up.component';
import { LoginComponent } from './login/login.component';
import { FilteredHouseListComponent } from './filtered-house-list/filtered-house-list.component';
import { from } from 'rxjs';

import { AuthInterceptor } from './service/AuthInterceptor'
@NgModule({
  declarations: [
    AppComponent,
    HouseListComponent,
    HouseFormComponent,
    HouseSearchComponent,
    HouseBookingComponent,
    SignUpComponent,
    LoginComponent,
    FilteredHouseListComponent
  ],
  imports: [
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserModule,     // <========== Add this line!
    ReactiveFormsModule
  ],
  providers: [HouseService, BookingService, AuthService, AuthInterceptor,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }],
  bootstrap: [AppComponent]
})
export class AppModule { }
