import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FontsizeComponent} from './SS03_Angular_Overview/practice/fontsize/fontsize.component';
import {RouterModule} from '@angular/router';
import {InfoPetComponent} from './SS03_Angular_Overview/practice/info-pet/info-pet.component';
import {CalculatorComponent} from './SS03_Angular_Overview/exercise/calculator/calculator.component';
import {SelectColorComponent} from './SS03_Angular_Overview/exercise/select-color/select-color.component';
import {ExtraExerciseComponent} from './extra-exercise/extra-exercise.component';
import {HackernewsComponent} from './SS04_Angular_Component&Template/practice/hackernews/hackernews.component';
import {LikesComponent} from './SS04_Angular_Component&Template/exercise/hackernews-exercise/likes/likes.component';
import {StudentComponent} from './extra-exercise/list-student/student/student.component';
import {ListStudentComponent} from './extra-exercise/list-student/list-student.component';
import {HackernewsExerciseComponent} from './SS04_Angular_Component&Template/exercise/hackernews-exercise/hackernews-exercise.component';
import {NameCardComponent} from './SS05_Components_Interaction/practice/card/name-card/name-card.component';
import {CardComponent} from './SS05_Components_Interaction/practice/card/card.component';
import {ProgressComponent} from './SS05_Components_Interaction/practice/progress/progress.component';
import {ProgressBarComponent} from './SS05_Components_Interaction/practice/progress/progress-bar/progress-bar.component';
import {RateComponent} from './SS05_Components_Interaction/exercise/rate/rate.component';
import {RatingBarComponent} from './SS05_Components_Interaction/exercise/rate/rating-bar/rating-bar.component';
import {CountdownComponent} from './SS05_Components_Interaction/exercise/countdown/countdown.component';
import {CountdownTimerComponent} from './SS05_Components_Interaction/exercise/countdown/countdown-timer/countdown-timer.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {TodoComponent} from './SS06_Angular_Form/practice/todo/todo.component';
import {RegisterComponent} from './SS06_Angular_Form/exercise/register/register.component';
import {LoginComponent} from './SS06_Angular_Form/exercise/login/login.component';
import {TimelinesComponent} from './SS07_Service_Router/practice/timelines/timelines.component';
import {DetailStudentComponent} from './extra-exercise/detail-student/detail-student.component';
import {CreateStudentComponent} from './extra-exercise/create-student/create-student.component';
import { YoutubePlayerComponent } from './SS07_Service_Router/practice/youtube-player/youtube-player.component';
import { YoutubePlaylistComponent } from './SS07_Service_Router/practice/youtube-playlist/youtube-playlist.component';
import {Ng2OrderModule} from 'ng2-order-pipe';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {NgxPaginationModule} from 'ngx-pagination';

@NgModule({
  declarations: [
    AppComponent,
    FontsizeComponent,
    InfoPetComponent,
    CalculatorComponent,
    SelectColorComponent,
    ExtraExerciseComponent,
    HackernewsComponent,
    LikesComponent,
    StudentComponent,
    ListStudentComponent,
    HackernewsExerciseComponent,
    NameCardComponent,
    CardComponent,
    ProgressComponent,
    ProgressBarComponent,
    RateComponent,
    RatingBarComponent,
    CountdownComponent,
    CountdownTimerComponent,
    TodoComponent,
    RegisterComponent,
    LoginComponent,
    TimelinesComponent,
    CreateStudentComponent,
    DetailStudentComponent,
    YoutubePlayerComponent,
    YoutubePlaylistComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    ReactiveFormsModule,
    [RouterModule.forRoot([
        {path: 'SS03_Angular_Overview/practice/fontsize', component: FontsizeComponent},
        {path: 'SS03_Angular_Overview/practice/info_pet', component: InfoPetComponent},
        {path: 'SS03_Angular_Overview/exercise/calculator', component: CalculatorComponent},
        {path: 'SS03_Angular_Overview/exercise/select_color', component: SelectColorComponent},
        {path: 'extra-exercise', component: ExtraExerciseComponent},
        {path: 'extra-exercise/student', component: StudentComponent},
        {path: 'SS04_Angular_Component&Template/practice/hackernews', component: HackernewsComponent},
        {path: 'SS04_Angular_Component&Template/exercise/hackernews-exercise', component: HackernewsExerciseComponent},
        {path: 'SS05_Components_Interaction/practice/card', component: CardComponent},
        {path: 'SS05_Components_Interaction/practice/progress', component: ProgressComponent},
        {path: 'SS05_Components_Interaction/exercise/rating', component: RatingBarComponent},
        {path: 'SS05_Components_Interaction/exercise/countdown', component: CountdownTimerComponent},
        {path: 'SS06_Angular_Form/practice/todo', component: TodoComponent},
        {path: 'SS06_Angular_Form/exercise/register', component: RegisterComponent},
        {path: 'SS06_Angular_Form/exercise/login', component: LoginComponent},
        {path: 'SS07_Service_Router/practice/timeline', component: TimelinesComponent},
        {path: 'youtube', component: YoutubePlaylistComponent},
        {path: 'SS07_Service_Router/practice/timeline', component: TimelinesComponent},
        {path: 'detail/:id', component: DetailStudentComponent}
      ]
    )],
    ReactiveFormsModule,
    Ng2OrderModule,
    Ng2SearchPipeModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
