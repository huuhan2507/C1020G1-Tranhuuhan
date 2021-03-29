import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.scss']
})
export class CalculatorComponent implements OnInit {
  number1: number;
  number2: number;
  result ;

  setNumber1(firstNumber) {
    this.number1 = firstNumber;
  }

  setNumber2(secondNumber) {
    this.number2 = secondNumber;
  }

  calculation(opera) {
    switch (opera) {
      case 'Add':
        this.result = (this.number1 * 1) + (this.number2 * 1);
        break;
      case 'Sub':
        this.result = this.number1 - this.number2;
        break;
      case 'Mul':
        this.result = this.number1 * this.number2;
        break;
      case 'Div':
        this.result = this.number1 / this.number2;
        break;
      default:
    }
  }

  constructor() {
  }

  ngOnInit(): void {
  }

}
