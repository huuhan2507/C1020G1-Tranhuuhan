import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-info-pet',
  templateUrl: './info-pet.component.html',
  styleUrls: ['./info-pet.component.scss']
})
export class InfoPetComponent implements OnInit {
  petName = 'puppie';
  petImage = 'https://huanluyenchothanhtai.com/wp-content/uploads/2019/07/mat-cho-husky.jpg';

  updateName(name) {
    this.petName = name;
  }

  updateImage(image) {
    if (image === '') {
      this.petImage = 'https://huanluyenchothanhtai.com/wp-content/uploads/2019/07/mat-cho-husky.jpg';
    } else if (image === 'cat') {
      this.petImage = 'https://i.pinimg.com/564x/49/78/21/497821b9f1c2ca692e696affb475fd84.jpg';
    } else if (image === 'lion') {
      this.petImage = 'https://www.goway.com/media/cache/aa/79/aa79264f49aae4d4b2d77f0abdeb16fc.jpg';
    } else if (image === 'tiger'){
      this.petImage = 'https://cdn.britannica.com/40/75640-050-F894DD85/tiger-Siberian.jpg';
    }else if (image === 'dog'){
      this.petImage = 'https://huanluyenchothanhtai.com/wp-content/uploads/2019/07/mat-cho-husky.jpg';
    }
  }

  constructor() {
  }

  ngOnInit(): void {
  }

}
