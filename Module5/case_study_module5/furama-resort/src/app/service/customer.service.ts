import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  public API_CUSTOMER = 'http://localhost:3000/customer';
  public API_TYPE_CUSTOMER = 'http://localhost:3000/customerType';

  constructor(public http: HttpClient) {
  }

  getAllTypeCustomer(): Observable<any> {
    return this.http.get(this.API_TYPE_CUSTOMER);
  }

  getAllCustomer(keySearch): Observable<any> {
    return this.http.get(this.API_CUSTOMER + '?name_like=' + keySearch);
  }

  addNewCustomer(customer): Observable<any> {
    return this.http.post(this.API_CUSTOMER, customer);
  }

  editCustomer(customer): Observable<any> {
    return this.http.put(this.API_CUSTOMER + '/' + customer.id, customer);
  }

  deleteCustomer(customerId): Observable<any> {
    return this.http.delete(this.API_CUSTOMER + '/' + customerId);
  }

  getCustomerById(customerId): Observable<any> {
    return this.http.get(this.API_CUSTOMER + '/' + customerId);
  }

  pageCustomer(page, limit, keySearch): Observable<any> {
    return this.http.get(this.API_CUSTOMER + '?_page=' + page + '&_limit=' + limit + '&name_like=' + keySearch);
  }
}

