import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {PackageComponent} from './package/package.component';
import {PackageAddComponent} from './package-add/package-add.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'package', component: PackageComponent},
  {path: 'package/create', component: PackageAddComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
