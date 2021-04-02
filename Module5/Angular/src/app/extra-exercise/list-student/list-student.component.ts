import {Component, OnInit} from '@angular/core';
import {studentDao} from '../../model/StudentDao';
import {IStudent} from '../../model/StudentIn';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FormGroup, FormControl, Validators, AbstractControl} from '@angular/forms';


@Component({
  selector: 'app-list-student',
  templateUrl: './list-student.component.html',
  styleUrls: ['./list-student.component.scss']
})
export class ListStudentComponent implements OnInit {
  constructor(private modalService: NgbModal) {
  }
  formControl = 'form-control';
  valid = 'is-valid';
  invalid = 'is-invalid';
  students = studentDao;
  student = null;

  createStudent = new FormGroup({
    id: new FormControl('', [Validators.required]),
    name: new FormControl('', [Validators.required, Validators.pattern('([A-Z][a-z]+)(([ ][A-Z][a-z]+)+)$')]),
    age: new FormControl('', [Validators.required, Validators.min(1), Validators.max(100)]),
    mark: new FormControl('', [Validators.required, Validators.min(0), Validators.max(10)]),
    image: new FormControl()
  });

  openWindowCustomClass(content) {
    this.modalService.open(content, {windowClass: 'dark-modal'});
  }

  openWindowCustomClass1(content1) {
    this.modalService.open(content1, {windowClass: 'dark-modal'});
  }

  openWindowCustomClass2(content2) {
    this.modalService.open(content2, {windowClass: 'dark-modal'});
  }

  ngOnInit(): void {
  }

  change(student) {
    this.student = student;
  }

  delete(student: IStudent) {
    const index = studentDao.indexOf(student);
    studentDao.splice(index, 1);
  }

  create() {
    console.log(this.createStudent.value);
    studentDao.push(this.createStudent.value);
  }

  getClass(property: string) {
    if (this.createStudent.invalid && (this.createStudent.dirty || this.createStudent.touched)) {
      return this.createStudent.get(property).valid ? this.valid : this.invalid;
    }else {
      return '';
    }
  }

  get id() {
    return this.createStudent.get('id');
  }

  get name() {
    return this.createStudent.get('name');
  }

  get age() {
    return this.createStudent.get('age');
  }

  get mark() {
    return this.createStudent.get('mark');
  }
}
