import {StudentClass} from '../model/Student';

export class StudentService {
  public getStudents() {
    let students: StudentClass[];
    students = [
      new StudentClass(1, 'Trần Hữu Hân', 8, 19, ''),
      new StudentClass(2, 'Nguyễn Long Phin', 3, 20, ''),
      new StudentClass(3, 'Lê Quang Dương', 7, 23, ''),
      new StudentClass(4, 'Trần Hữu Kiên', 7, 30, ''),
      new StudentClass(5, 'Phạm Trường Phúc', 4, 29, ''),
    ];
    return students;
  }

  public deleteStudent(studentClass) {
    const index = this.getStudents().indexOf(studentClass);
    this.getStudents().splice(index, 1);
  }

  public saveStudent(studentClass) {
    const stu = this.getStudents().find(e => e.id === studentClass.id);
    if (stu === null) {
      this.getStudents().push(studentClass);
    } else {
    }
  }
}

