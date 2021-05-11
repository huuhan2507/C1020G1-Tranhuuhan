import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HomeAuctionService {
  public API_PRODUCT = 'http://localhost:8080/api/product';

  constructor(private http: HttpClient) {
  }

  public showAllProductAuction(): Observable<any> {
    return this.http.get(this.API_PRODUCT);
  }
}
