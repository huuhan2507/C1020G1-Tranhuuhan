import {Component, OnInit} from '@angular/core';
import {studentDao} from '../../model/StudentDao';

@Component({
  selector: 'app-list-student',
  templateUrl: './list-student.component.html',
  styleUrls: ['./list-student.component.scss']
})
export class ListStudentComponent implements OnInit {
  students = studentDao;
  student = null;

  constructor() {
  }

  ngOnInit(): void {
  }

  change(student) {
    this.student = student;
  }
}
