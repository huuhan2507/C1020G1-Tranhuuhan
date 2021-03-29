import {Component, OnInit} from '@angular/core';
import {IStudent} from '../model/Student';

@Component({
  selector: 'app-extra-exercise',
  templateUrl: './extra-exercise.component.html',
  styleUrls: ['./extra-exercise.component.scss']
})
export class ExtraExerciseComponent implements OnInit {
  student: IStudent = {
    id: 1,
    name: 'Trần Hữu Hân',
    age: 19,
    mark: 100,
    image: 'https://www.w3schools.com/howto/img_avatar.png'
  };

  constructor() {
  }

  ngOnInit(): void {
  }

  changeMark(value: any) {
    this.student.mark = value;
  }
}
