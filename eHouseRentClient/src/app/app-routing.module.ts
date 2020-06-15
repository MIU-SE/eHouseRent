import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HouseListComponent } from './house-list/house-list.component';
import { HouseFormComponent } from './house-form/house-form.component'
import { HouseBookingComponent } from './house-booking/house-booking.component';
import { HouseSearchComponent } from './house-search/house-search.component';
import { FilteredHouseListComponent } from './filtered-house-list/filtered-house-list.component';


const routes: Routes = [
  { path: 'house/list', component: HouseListComponent },
  { path: 'owner/house/add', component: HouseFormComponent },
  { path: 'owner/house/edit/:id', component: HouseFormComponent },
  { path: 'booking/add', component: HouseBookingComponent },
  { path: '', component: HouseSearchComponent },
  { path: 'search/state/city', component: FilteredHouseListComponent },
  { path: 'house/booking', component: HouseBookingComponent },
  { path: 'search/house', component: HouseSearchComponent }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
