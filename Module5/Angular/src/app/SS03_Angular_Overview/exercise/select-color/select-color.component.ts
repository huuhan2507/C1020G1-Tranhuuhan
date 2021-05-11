import {Component, OnInit} from '@angular/core';
import {WebcamInitError} from 'ngx-webcam';

@Component({
  selector: 'app-select-color',
  templateUrl: './select-color.component.html',
  styleUrls: ['./select-color.component.scss']
})
export class SelectColorComponent implements OnInit {
  color = 'background-color: white';

  constructor() {
  }

  ngOnInit(): void {
  }

  selectColor(value: string) {
    switch (value) {
      case 'red':
        this.color = 'background-color: red';
        break;
      case 'yellow':
        this.color = 'background-color: yellow';
        break;
      case 'cyan':
        this.color = 'background-color: cyan';
        break;
      case 'blue':
        this.color = 'background-color: blue';
        break;
      case 'green':
        this.color = 'background-color: green';
        break;
      case 'lime':
        this.color = 'background-color: lime';
        break;
      case 'pink':
        this.color = 'background-color: pink';
        break;
      case 'black':
        this.color = 'background-color: black';
        break;
      case 'orange':
        this.color = 'background-color: orange';
        break;
      case 'purple':
        this.color = 'background-color: purple';
        break;
      case 'gray':
        this.color = 'background-color: gray';
        break;
      default:
    }
  }

  handleInitError(error: WebcamInitError) {
    if (error.mediaStreamError && error.mediaStreamError.name === 'NotAllowedError') {
      console.warn('Camera access was not allowed by user!');
    }
  }
}
