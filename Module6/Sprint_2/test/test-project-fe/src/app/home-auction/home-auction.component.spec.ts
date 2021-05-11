import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeAuctionComponent } from './home-auction.component';

describe('HomeAuctionComponent', () => {
  let component: HomeAuctionComponent;
  let fixture: ComponentFixture<HomeAuctionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeAuctionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeAuctionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
