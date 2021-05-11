import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PackageService {
  public API_PACKAGE = 'http://localhost:3000/package';
  public API_PRODUCT = 'http://localhost:3000/product';

  constructor(public http: HttpClient) {
  }

  getAllProduct(): Observable<any> {
    return this.http.get(this.API_PRODUCT);
  }

  getAllPackage(): Observable<any> {
    return this.http.get(this.API_PACKAGE);
  }

  deletePackage(packgage): Observable<any> {
    return this.http.delete(this.API_PACKAGE + '/' + packgage.id);
  }

  addNewPack(pack): Observable<any> {
    return this.http.post(this.API_PACKAGE, pack);
  }
}
