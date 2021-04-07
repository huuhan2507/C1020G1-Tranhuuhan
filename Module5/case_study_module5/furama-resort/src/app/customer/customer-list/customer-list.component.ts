import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../../service/customer.service';
import {Customer} from '../../model/customer';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {MatDialog} from '@angular/material/dialog';
import {CustomerAddComponent} from '../customer-add/customer-add.component';
import {CustomerEditComponent} from '../customer-edit/customer-edit.component';
import {CustomerDetailComponent} from '../customer-detail/customer-detail.component';


@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {
  customerList: Customer[];
  customer: Customer;
  disabled1 = 'disabled';
  disabled2 = '';
  keySearch = '';
  totalPage;
  page = 1;
  key = '';
  reverse = false;
  sort(key){
    this.key = key;
    this.reverse = !this.reverse;
  }
  constructor(
    private customerService: CustomerService,
    private modalService: NgbModal,
    public dialog: MatDialog,
  ) {
  }
  ngOnInit(): void {
    const limit = 5;
    this.customerService.pageCustomer(this.page, limit, this.keySearch).subscribe(data => this.customerList = data);
    this.customerService.getAllCustomer(this.keySearch).subscribe(data => {
      this.totalPage = parseFloat(((data.length - 1) / 5).toString().split('.')[0]) + 1;
      if (this.totalPage === 1) {
        this.disabled1 = 'disabled';
        this.disabled2 = 'disabled';
      }
    });
  }

  openWindowCustomClass(content) {
    this.modalService.open(content, {windowClass: 'dark-modal'});
  }

  deleteCustomer(id) {
    this.customerService.deleteCustomer(id).subscribe(data => {
      this.ngOnInit();
    });
  }


  change(customer: Customer) {
    this.customer = customer;
  }

  pageCusPre() {
    this.page--;
    this.disabled2 = '';
    this.disabled1 = this.page > 1 ? '' : 'disabled';
    this.ngOnInit();
  }

  pageCusNext() {
    this.page++;
    this.disabled1 = '';
    this.disabled2 = this.page === this.totalPage ? 'disabled' : '';
    this.ngOnInit();
  }

  pageCus(value: number) {
    this.page = value;
    this.disabled2 = this.page === this.totalPage ? 'disabled' : '';
    this.disabled1 = this.page > 1 ? '' : 'disabled';
    this.ngOnInit();
  }

  search(keySearch) {
    this.keySearch = keySearch;
    this.ngOnInit();
  }

  openAddNewCus() {
    const dialogRef = this.dialog.open(CustomerAddComponent, {
      width: '830px',
      height: '600px',
      disableClose: true
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.ngOnInit();
    });
  }
  openDialogEdit(customerId) {
    this.customerService.getCustomerById(customerId).subscribe(dataCustomer => {
      const dialogRef = this.dialog.open(CustomerEditComponent, {
        width: '830px',
        height: '600px',
        data: {dataC: dataCustomer},
        disableClose: true
      });
      dialogRef.afterClosed().subscribe(result => {
        this.ngOnInit();
      });
    });
  }
  openDialogView(customerId) {
    this.customerService.getCustomerById(customerId).subscribe(dataCustomer => {
      const dialogRef = this.dialog.open(CustomerDetailComponent, {
        width: '830px',
        height: '600px',
        data: {dataA: dataCustomer},
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }
}


