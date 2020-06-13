import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HouseListComponent } from './house-list/house-list.component';
import { HouseFormComponent} from './house-form/house-form.component'
import { HouseBookingComponent } from './house-booking/house-booking.component';

const routes: Routes = [
  {path:'house/list',component:HouseListComponent},
  {path:'owner/house/add', component:HouseFormComponent},
  {path:'booking/add',component:HouseBookingComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
