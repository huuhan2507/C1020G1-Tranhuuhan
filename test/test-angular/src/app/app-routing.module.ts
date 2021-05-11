import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {AvatarComponent} from './avatar/avatar.component';
import {UpdateStatusComponent} from './update-status/update-status.component';
import {ChangePasswordComponent} from './change-password/change-password.component';


const routes: Routes = [
  {path: '', component: AvatarComponent},
  {path: 'status', component: UpdateStatusComponent},
  {path: 'changePassword', component: ChangePasswordComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
