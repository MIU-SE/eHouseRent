import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HouseListComponent } from './house-list/house-list.component';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HouseService } from './service/house.service';
import { HouseFormComponent } from './house-form/house-form.component';

@NgModule({
  declarations: [
    AppComponent,
    HouseListComponent,
    HouseFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [HouseService],
  bootstrap: [AppComponent]
})
export class AppModule { }
