import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../../service/customer.service';
import {Customer} from '../../model/customer';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {
  customerList: Customer[];
  customer: Customer;

  constructor(
    private customerService: CustomerService,
    private modalService: NgbModal,
    public router: Router
  ) {
  }

  ngOnInit(): void {
    this.customerService.getAllCustomer().subscribe(data => this.customerList = data);
  }

  openWindowCustomClass(content) {
    this.modalService.open(content, {windowClass: 'dark-modal'});
  }

  deleteCustomer(id) {
    this.customerService.deleteCustomer(id).subscribe(data => {
      this.router.navigate(['customer']);
    }, error => {
      console.log(error);
    });
  }

  change(customer: Customer) {
    this.customer = customer;
  }
}


