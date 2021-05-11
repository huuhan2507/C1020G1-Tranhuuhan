import {Component, Inject, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Customer} from '../../model/customer';
import {CustomerService} from '../../service/customer.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerType} from '../../model/customerType';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.scss']
})
export class CustomerEditComponent implements OnInit {

  public customer: Customer;
  public customerId: number;
  public formControl = 'form-control';
  public valid = 'is-valid';
  public invalid = 'is-invalid';
  public customerType: CustomerType[];
  public maxDate = new Date();
  public minDate = new Date(1901, 1, 1);

  constructor(private customerService: CustomerService,
              private routeStudent: ActivatedRoute,
              private route: Router,
              public dialogRef: MatDialogRef<CustomerEditComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any) {
  }

  editCustomer = new FormGroup(
    {
      id: new FormControl(),
      name: new FormControl('', [Validators.required, Validators.pattern('([A-Z][a-z]+)(([ ][A-Z][a-z]+)+)$')]),
      customerType: new FormControl('', [Validators.required]),
      code: new FormControl('', [Validators.required, Validators.pattern('(KH-)[0-9]{4}')]),
      dateOfBirth: new FormControl('', [Validators.required]),
      cardId: new FormControl('', [Validators.required, Validators.pattern('([0-9]{9}|[0-9]{12})')]),
      phone: new FormControl('', [Validators.required, Validators.pattern('((09)|(84[+]09))(0|1)[0-9]{7}')]),
      email: new FormControl('', [Validators.required, Validators.email]),
      address: new FormControl('', [Validators.required]),
    }
  );

  getClass(property: string) {
    // tslint:disable-next-line:max-line-length
    if ((this.editCustomer.get(property).invalid && this.editCustomer.get(property).dirty) || this.editCustomer.get(property).touched) {
      return this.editCustomer.get(property).valid ? this.valid : this.invalid;
    } else {
      return '';
    }
  }

  ngOnInit(): void {
    this.customerService.getAllTypeCustomer().subscribe(data => this.customerType = data);
    this.routeStudent.paramMap.subscribe((param: ParamMap) => {
      this.customerId = parseFloat(param.get('id'));
    });
    this.editCustomer.patchValue(this.data.dataC);
  }

  get code() {
    return this.editCustomer.get('code');
  }

  get name() {
    return this.editCustomer.get('name');
  }

  get customerTypeName() {
    return this.editCustomer.get('customerType');
  }

  get date() {
    return this.editCustomer.get('dateOfBirth');
  }

  get cardId() {
    return this.editCustomer.get('cardId');
  }

  get phone() {
    return this.editCustomer.get('phone');
  }

  get email() {
    return this.editCustomer.get('email');
  }

  get address() {
    return this.editCustomer.get('address');
  }

  edit() {
    if (this.editCustomer.valid) {
      this.customerService.editCustomer(this.editCustomer.value).subscribe(data => {
        console.log('aaa');
        this.route.navigate(['customer']);
        this.dialogRef.close();
      });
    }
  }
}
