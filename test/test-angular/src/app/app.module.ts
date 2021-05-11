import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {AngularFireModule} from '@angular/fire';
import {environment} from '../environments/environment';
import {
  AngularFireStorageModule,
} from '@angular/fire/storage';
import {AngularFireDatabaseModule} from '@angular/fire/database';
import {HttpClientModule} from '@angular/common/http';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {WebcamComponent} from './webcam/webcam.component';
import {AvatarComponent} from './avatar/avatar.component';
import {UpdateStatusComponent} from './update-status/update-status.component';
import {ChangePasswordComponent} from './change-password/change-password.component';
import {EditProfileComponent} from './edit-profile/edit-profile.component';
import {ReactiveFormsModule} from '@angular/forms';
import {FormsModule} from '@angular/forms';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {WebcamModule} from 'ngx-webcam';
import {MatDialogModule} from '@angular/material/dialog';
import { LoadingComponent } from './loading/loading.component';

@NgModule({
  declarations: [AppComponent, WebcamComponent, AvatarComponent, UpdateStatusComponent, ChangePasswordComponent, EditProfileComponent, LoadingComponent],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    AngularFireStorageModule,
    AngularFireModule.initializeApp(environment.firebaseConfig, 'cloud'),
    AngularFireDatabaseModule,
    ReactiveFormsModule,
    FormsModule,
    NgbModule,
    BrowserAnimationsModule,
    WebcamModule,
    MatDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule {
}
