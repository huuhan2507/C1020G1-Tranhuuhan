import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';

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
import {StudentComponent} from './extra-exercise/student/student.component';
import {ListStudentComponent} from './extra-exercise/list-student/list-student.component';
import {HackernewsExerciseComponent} from './SS04_Angular_Component&Template/exercise/hackernews-exercise/hackernews-exercise.component';

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
    HackernewsExerciseComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    [RouterModule.forRoot([
        {path: 'SS03_Angular_Overview/practice/fontsize', component: FontsizeComponent},
        {path: 'SS03_Angular_Overview/practice/info_pet', component: InfoPetComponent},
        {path: 'SS03_Angular_Overview/exercise/calculator', component: CalculatorComponent},
        {path: 'SS03_Angular_Overview/exercise/select_color', component: SelectColorComponent},
        {path: 'extra-exercise', component: ExtraExerciseComponent},
        {path: 'extra-exercise/student', component: StudentComponent},
        {path: 'SS04_Angular_Component&Template/practice/hackernews', component: HackernewsComponent},
        {path: 'SS04_Angular_Component&Template/exercise/hackernews-exercise', component: HackernewsExerciseComponent}
      ]
    )]
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
