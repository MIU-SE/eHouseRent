import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HouseListComponent } from './house-list/house-list.component';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HouseService } from './service/house.service';
import { BookingService } from './service/booking.service';

import { HouseFormComponent } from './house-form/house-form.component';

import { HouseSearchComponent } from './house-search/house-search.component';
import { HouseBookingComponent } from './house-booking/house-booking.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SignUpComponent } from './sign-up/sign-up.component';
import { FilteredHouseListComponent } from './filtered-house-list/filtered-house-list.component';


@NgModule({
  declarations: [
    AppComponent,
    HouseListComponent,
    HouseFormComponent,
    HouseSearchComponent,
    HouseBookingComponent,
    SignUpComponent,
    FilteredHouseListComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule
  ],
  providers: [HouseService,BookingService],
  bootstrap: [AppComponent]
})
export class AppModule { }
