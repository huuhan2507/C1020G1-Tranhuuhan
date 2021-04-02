import {Component, Input, OnInit} from '@angular/core';
import {IStudent} from '../../../model/StudentIn';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.scss']
})
export class StudentComponent implements OnInit {
  @Input()
  student: IStudent;

  changeMark(value: any) {
    this.student.mark = value;
  }

  constructor() {
  }

  ngOnInit(): void {
  }

}
