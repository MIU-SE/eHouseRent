import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HouseListComponent } from './house-list/house-list.component';
import { HouseFormComponent} from './house-form/house-form.component'
import { HouseBookingComponent } from './house-booking/house-booking.component';
import { HouseSearchComponent} from './house-search/house-search.component';
import { LoginComponent} from './login/login.component'

const routes: Routes = [
  {path:'house/list',component:HouseListComponent},
  {path:'owner/house/add', component:HouseFormComponent},
  {path:'booking/add',component:HouseBookingComponent},
  {path:'search/state/city',component:HouseSearchComponent},
  {path:'login',component:LoginComponent},
  {path:'',redirectTo:'/search/state/city', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
