import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuizTeacherGetQuestionsComponent } from './quiz-teacher-get-questions.component';

describe('QuizTeacherGetQuestionsComponent', () => {
  let component: QuizTeacherGetQuestionsComponent;
  let fixture: ComponentFixture<QuizTeacherGetQuestionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuizTeacherGetQuestionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuizTeacherGetQuestionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
