import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HouseListComponent } from './house-list/house-list.component';
import { HouseFormComponent} from './house-form/house-form.component'

const routes: Routes = [
  {path:'house/list',component:HouseListComponent},
  {path:'owner/house/new', component:HouseFormComponent},
   {path:'owner/house/edit/:id',component:HouseFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
