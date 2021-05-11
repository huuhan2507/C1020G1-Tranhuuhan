import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CamareComponent } from './camare.component';

describe('CamareComponent', () => {
  let component: CamareComponent;
  let fixture: ComponentFixture<CamareComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CamareComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CamareComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
