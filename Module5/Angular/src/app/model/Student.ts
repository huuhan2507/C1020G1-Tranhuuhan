export class StudentClass {
  id: number;
  name: string;
  mark: number;
  age: number;
  image: string;

  constructor(id: number, name: string, mark: number, age: number, image: string) {
    this.id = id;
    this.name = name;
    this.mark = mark;
    this.age = age;
    this.image = image;
  }
}
