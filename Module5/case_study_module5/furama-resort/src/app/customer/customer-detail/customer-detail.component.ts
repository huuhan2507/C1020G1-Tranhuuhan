import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {Customer} from '../../model/customer';
import {CustomerService} from '../../service/customer.service';

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.scss']
})
export class CustomerDetailComponent implements OnInit {
  customerDetail: Customer;

  constructor(private customerService: CustomerService, private routeCustomer: ActivatedRoute) {
  }

  ngOnInit(): void {
    let id;
    this.routeCustomer.paramMap.subscribe((param: ParamMap) => id = parseFloat(param.get('id')));
    this.customerService.getCustomerById(id).subscribe(data => this.customerDetail = data);
  }

}
