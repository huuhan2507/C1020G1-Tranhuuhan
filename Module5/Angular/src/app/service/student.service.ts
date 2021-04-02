import {Injectable} from '@angular/core';
import {studentDao} from '../model/StudentDao';
import {IStudent} from '../model/Student';


@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor() {
  }

  getStudents() {
    return studentDao;
  }

  deleteStudent(student: IStudent) {
    const index = studentDao.indexOf(student);
    studentDao.splice(index, 1);
  }

  saveStudent(student: IStudent) {
    const index = studentDao.indexOf(student);
    const stu = studentDao.find(e => e.id === student.id);
    if (stu === null) {
      studentDao.push(student);
    } else {
      studentDao.splice(index, 1, student);
    }
  }
}

