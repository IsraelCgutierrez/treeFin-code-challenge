import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
   providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient) { }
  getCurrencies(){
    return this.http.get('http://localhost:8080/currencies/liefert');
  }
}