import {Component, Inject, OnInit} from '@angular/core';
import {CustomerService} from '../../service/customer.service';
import {CustomerType} from '../../model/customerType';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-customer-add',
  templateUrl: './customer-add.component.html',
  styleUrls: ['./customer-add.component.scss']
})
export class CustomerAddComponent implements OnInit {

  public customerType: CustomerType[];
  public createCustomer;
  public formControl = 'form-control';
  public valid = 'is-valid';
  public invalid = 'is-invalid';
  public maxDate = new Date();
  public minDate = new Date(1901, 1, 1);
  constructor(private customerService: CustomerService,
              private route: Router,
              public dialogRef: MatDialogRef<CustomerAddComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any) {
  }

  ngOnInit(): void {

    this.customerService.getAllTypeCustomer().subscribe(data => this.customerType = data);
    this.createCustomer = new FormGroup(
      {
        id: new FormControl(),
        name: new FormControl('', [Validators.required, Validators.pattern('([A-Z][a-z]+)(([ ][A-Z][a-z]+)+)$')]),
        customerType: new FormControl('', [Validators.required]),
        code: new FormControl('', [Validators.required, Validators.pattern('(KH-)[0-9]{4}')]),
        dateOfBirth: new FormControl('', [Validators.required]),
        cardId: new FormControl('', [Validators.required, Validators.pattern('([0-9]{9}|[0-9]{12})')]),
        phone: new FormControl('', [Validators.required, Validators.pattern('((09)|(84[+]09))(0|1)[0-9]{7}')]),
        email: new FormControl('', [Validators.required, Validators.pattern('^[a-z0-9]{6,}@[a-z]+\\.[a-z]+')]),
        address: new FormControl('', [Validators.required]),
      }
    );
  }

  getClass(property: string) {
    // tslint:disable-next-line:max-line-length
    if ((this.createCustomer.get(property).invalid && this.createCustomer.get(property).dirty) || this.createCustomer.get(property).touched) {
      return this.createCustomer.get(property).valid ? this.valid : this.invalid;
    } else {
      return '';
    }
  }

  create() {
    console.log(this.createCustomer.value);
    if (this.createCustomer.valid) {
      this.customerService.addNewCustomer(this.createCustomer.value).subscribe(data => {
        this.route.navigate(['customer']);
        this.dialogRef.close();
      });
    }
  }

  get code() {
    return this.createCustomer.get('code');
  }

  get name() {
    return this.createCustomer.get('name');
  }

  get customerTypeName() {
    return this.createCustomer.get('customerType');
  }

  get date() {
    return this.createCustomer.get('dateOfBirth');
  }

  get cardId() {
    return this.createCustomer.get('cardId');
  }

  get phone() {
    return this.createCustomer.get('phone');
  }

  get email() {
    return this.createCustomer.get('email');
  }

  get address() {
    return this.createCustomer.get('address');
  }

}
