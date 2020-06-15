import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HouseListComponent} from './house-list/house-list.component';
import {HouseFormComponent} from './house-form/house-form.component';
import {HouseBookingComponent} from './house-booking/house-booking.component';
import {HouseSearchComponent} from './house-search/house-search.component';

import {SignUpComponent} from './sign-up/sign-up.component';
import {FilteredHouseListComponent} from './filtered-house-list/filtered-house-list.component';

const routes: Routes = [
  {path: 'house/list', component: HouseListComponent},
  {path: 'owner/house/add', component: HouseFormComponent},
  {path: 'search/state/city', component: HouseSearchComponent},
  {path: 'add/NewUser', component: SignUpComponent},
  {path: '', component: HouseSearchComponent},
  {path: 'booking/add', component: HouseBookingComponent},
  {path: 'owner/house/edit/:id', component: HouseFormComponent}
];

@NgModule({
  declarations: [],
  imports: [

    RouterModule.forRoot(routes)// {onSameUrlNavigation: 'reload'}
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
