import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {CustomerListComponent} from './customer/customer-list/customer-list.component';
import {CustomerDetailComponent} from './customer/customer-detail/customer-detail.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'customer', component: CustomerListComponent},
  {path: 'customer/detail/:id', component: CustomerDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
