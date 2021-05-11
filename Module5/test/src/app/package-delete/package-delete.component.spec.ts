import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PackageDeleteComponent } from './package-delete.component';

describe('PackageDeleteComponent', () => {
  let component: PackageDeleteComponent;
  let fixture: ComponentFixture<PackageDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PackageDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PackageDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
