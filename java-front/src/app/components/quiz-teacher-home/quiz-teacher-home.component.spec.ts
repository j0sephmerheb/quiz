import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuizTeacherHomeComponent } from './quiz-teacher-home.component';

describe('QuizTeacherHomeComponent', () => {
  let component: QuizTeacherHomeComponent;
  let fixture: ComponentFixture<QuizTeacherHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuizTeacherHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuizTeacherHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
