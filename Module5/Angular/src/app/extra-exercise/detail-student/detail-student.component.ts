import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {studentDao} from '../../model/StudentDao';
import {IStudent} from '../../model/Student';

@Component({
  selector: 'app-detail-student',
  templateUrl: './detail-student.component.html',
  styleUrls: ['./detail-student.component.scss']
})
export class DetailStudentComponent implements OnInit {

  constructor(private routeStudent: ActivatedRoute) {
  }

  studentDetail: IStudent;

  ngOnInit(): void {
    this.routeStudent.paramMap.subscribe((param: ParamMap) => {
      return this.studentDetail = studentDao.find(e => e.id === parseFloat(param.get('id')));
    });
  }

}
