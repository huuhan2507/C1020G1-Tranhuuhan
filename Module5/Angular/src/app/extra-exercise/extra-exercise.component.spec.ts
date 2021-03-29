import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExtraExerciseComponent } from './extra-exercise.component';

describe('ExtraExerciseComponent', () => {
  let component: ExtraExerciseComponent;
  let fixture: ComponentFixture<ExtraExerciseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExtraExerciseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExtraExerciseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
