import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {PackageService} from '../service/package.service';

@Component({
  selector: 'app-package-add',
  templateUrl: './package-add.component.html',
  styleUrls: ['./package-add.component.scss']
})
export class PackageAddComponent implements OnInit {

  constructor(
    private route: Router,
    private packageService: PackageService) {
  }

  formCreatePack;
  product;
  ngOnInit(): void {
    this.packageService.getAllProduct().subscribe((data) => {
      this.product = data;
    });
    this.formCreatePack = new FormGroup(
      {
        id: new FormControl(),
        product: new FormControl('', [Validators.required]),
        code: new FormControl('', [Validators.required, Validators.pattern('(LH-)[0-9]{4}')]),
        amount: new FormControl('', [Validators.required, Validators.min(0)]),
        dateStart: new FormControl('', [Validators.required]),
        dateStartPro: new FormControl('' ),
        dateEndPro: new FormControl('' )
      }
    );
  }

  get code() {
    return this.formCreatePack.get('code');
  }

  get products() {
    return this.formCreatePack.get('product');
  }

  get dateStart() {
    return this.formCreatePack.get('dateStart');
  }

  get dateStartPro() {
    return this.formCreatePack.get('dateStartPro');
  }

  get dateEndPro() {
    return this.formCreatePack.get('dateEndPro');
  }
  get amount(){
    return this.formCreatePack.get('amount')
  }

  create() {
    if (this.formCreatePack.valid) {
      this.packageService.addNewPack(this.formCreatePack.value).subscribe(data => {
        this.route.navigate(['package']);
      });
    }
  }
}
