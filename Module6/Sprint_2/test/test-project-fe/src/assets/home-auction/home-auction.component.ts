import {Component, OnInit} from '@angular/core';
import {HomeAuctionService} from '../service/home-auction.service';

@Component({
  selector: 'app-home-auction',
  templateUrl: './home-auction.component.html',
  styleUrls: ['./home-auction.component.css']
})
export class HomeAuctionComponent implements OnInit {

  constructor(private homeAuctionService: HomeAuctionService) {
  }

  public listProduct;
  p = 1;

  ngOnInit(): void {
    this.homeAuctionService.showAllProductAuction().subscribe((data) => {
      console.log(data);
      this.listProduct = data;
    });
  }

}
