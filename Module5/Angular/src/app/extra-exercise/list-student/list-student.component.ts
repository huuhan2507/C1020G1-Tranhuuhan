import {Component, OnInit} from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FormGroup, FormControl, Validators} from '@angular/forms';
import {StudentService} from '../../service/student.service';
import {IStudent} from '../../model/Student';


@Component({
  selector: 'app-list-student',
  templateUrl: './list-student.component.html',
  styleUrls: ['./list-student.component.scss']
})
export class ListStudentComponent implements OnInit {
  constructor(private modalService: NgbModal, private studentService: StudentService) {
  }

  formControl = 'form-control';
  valid = 'is-valid';
  invalid = 'is-invalid';
  students = this.studentService.getStudents();
  student = null;

  createStudent = new FormGroup({
    id: new FormControl('', [Validators.required]),
    name: new FormControl('', [Validators.required, Validators.pattern('([A-Z][a-z]+)(([ ][A-Z][a-z]+)+)$')]),
    age: new FormControl('', [Validators.required, Validators.min(1), Validators.max(100)]),
    mark: new FormControl('', [Validators.required, Validators.min(0), Validators.max(10)]),
    image: new FormControl()
  });
  key = 'name';
  reverse = false;
  filter: string;
  p = 1;

  sort(key) {
    this.key = key;
    this.reverse = !this.reverse;
  }


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

  change(student: IStudent) {
    this.student = student;
  }

  delete(student: IStudent) {
    this.studentService.deleteStudent(student);
  }

  save() {
    this.studentService.saveStudent(this.createStudent.value);
  }

  getClass(property: string) {
    if ((this.createStudent.get(property).invalid && this.createStudent.get(property).dirty) || this.createStudent.get(property).touched) {
      return this.createStudent.get(property).valid ? this.valid : this.invalid;
    } else {
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
