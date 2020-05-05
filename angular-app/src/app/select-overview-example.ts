import {Component, OnInit} from '@angular/core';
import { HttpService } from './http.service';


interface Food {
  value: string;
  viewValue: string;
}

interface Currency {
  exchange: number;
  symbol: string;
  date: string;
}

/**
 * @title Basic select
 */
@Component({
  selector: 'select-overview-example',
  templateUrl: 'select-overview-example.html',
  styleUrls: ['select-overview-example.css'],
})
export class SelectOverviewExample implements OnInit {

constructor(private _http: HttpService) { }

  selected1: number;
  selected2: number;

  amount1: number = 1;
  amount2: number = 1;

  currencies: Currency[];

  ngOnInit(){
    this._http.getCurrencies().subscribe(data=> {
      this.currencies = data;
      console.log(data);
    });

    this.currencies = [
    {
        "symbol": "CHF",
        "exchange": 1.0558,
        "date": "2020-04-30"
    },
    {
        "symbol": "HRK",
        "exchange": 7.579,
        "date": "2020-04-30"
    },
    {
        "symbol": "MXN",
        "exchange": 25.7953,
        "date": "2020-04-30"
    },
    {
        "symbol": "ZAR",
        "exchange": 19.6572,
        "date": "2020-04-30"
    },
    {
        "symbol": "INR",
        "exchange": 81.6108,
        "date": "2020-04-30"
    },
    {
        "symbol": "CNY",
        "exchange": 7.6665,
        "date": "2020-04-30"
    },
    {
        "symbol": "THB",
        "exchange": 35.216,
        "date": "2020-04-30"
    },
    {
        "symbol": "AUD",
        "exchange": 1.6598,
        "date": "2020-04-30"
    },
    {
        "symbol": "ILS",
        "exchange": 3.8069,
        "date": "2020-04-30"
    },
    {
        "symbol": "KRW",
        "exchange": 1313.09,
        "date": "2020-04-30"
    },
    {
        "symbol": "JPY",
        "exchange": 115.87,
        "date": "2020-04-30"
    },
    {
        "symbol": "PLN",
        "exchange": 4.5336,
        "date": "2020-04-30"
    },
    {
        "symbol": "GBP",
        "exchange": 0.86905,
        "date": "2020-04-30"
    },
    {
        "symbol": "IDR",
        "exchange": 16178.05,
        "date": "2020-04-30"
    },
    {
        "symbol": "HUF",
        "exchange": 352.72,
        "date": "2020-04-30"
    },
    {
        "symbol": "PHP",
        "exchange": 54.772,
        "date": "2020-04-30"
    },
    {
        "symbol": "TRY",
        "exchange": 7.5979,
        "date": "2020-04-30"
    },
    {
        "symbol": "RUB",
        "exchange": 79.892,
        "date": "2020-04-30"
    },
    {
        "symbol": "ISK",
        "exchange": 159.3,
        "date": "2020-04-30"
    },
    {
        "symbol": "HKD",
        "exchange": 8.43,
        "date": "2020-04-30"
    },
    {
        "symbol": "DKK",
        "exchange": 7.4584,
        "date": "2020-04-30"
    },
    {
        "symbol": "USD",
        "exchange": 1.0876,
        "date": "2020-04-30"
    },
    {
        "symbol": "CAD",
        "exchange": 1.5077,
        "date": "2020-04-30"
    },
    {
        "symbol": "MYR",
        "exchange": 4.6767,
        "date": "2020-04-30"
    },
    {
        "symbol": "BGN",
        "exchange": 1.9558,
        "date": "2020-04-30"
    },
    {
        "symbol": "NOK",
        "exchange": 11.184,
        "date": "2020-04-30"
    },
    {
        "symbol": "RON",
        "exchange": 4.8431,
        "date": "2020-04-30"
    },
    {
        "symbol": "SGD",
        "exchange": 1.5324,
        "date": "2020-04-30"
    },
    {
        "symbol": "CZK",
        "exchange": 27.097,
        "date": "2020-04-30"
    },
    {
        "symbol": "SEK",
        "exchange": 10.6639,
        "date": "2020-04-30"
    },
    {
        "symbol": "NZD",
        "exchange": 1.7705,
        "date": "2020-04-30"
    },
    {
        "symbol": "BRL",
        "exchange": 5.8565,
        "date": "2020-04-30"
    }
];
  }

  foods: Food[] = [
    {value: 'steak-0', viewValue: 'Steak'},
    {value: 'pizza-1', viewValue: 'Pizza'},
    {value: 'tacos-2', viewValue: 'Tacos'}
  ];

  calculate(am:number){
    if(am==1){
      this.amount2 = Math.round(this.amount1*(this.selected2/this.selected1) * 100) / 100;
    }else{
      this.amount1 =Math.round(this.amount2*(this.selected1/this.selected2) * 100) / 100;
    }
  }

}


/**  Copyright 2019 Google LLC. All Rights Reserved.
    Use of this source code is governed by an MIT-style license that
    can be found in the LICENSE file at http://angular.io/license */