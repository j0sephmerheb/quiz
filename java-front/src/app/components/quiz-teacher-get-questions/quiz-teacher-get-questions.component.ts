import { Component, OnInit } from '@angular/core';
import { Question } from 'src/app/datamodel/question';
import { Answer } from 'src/app/datamodel/answer';
import { ExamService } from 'src/app/services/exam.service';

@Component({
  selector: 'app-quiz-teacher-get-questions',
  templateUrl: './quiz-teacher-get-questions.component.html',
  styleUrls: ['./quiz-teacher-get-questions.component.css']
})
export class QuizTeacherGetQuestionsComponent implements OnInit {
  question : Question = new Question();
  answer : Answer = new Answer();
  retrievedQuestions;
  retrievedAnswers;

  constructor(private examService : ExamService) { }

  ngOnInit(): void {
    this.viewQuestions();
    this.viewAnswers();
  }

  updateQuestion(){    
    this.examService.updateQuestion(this.question);
    alert("Question Saved")
  }
  deleteQuestion(){    
    this.examService.deleteQuestion(this.question);
    alert("Question Deleted")
  }
  viewQuestions(){
    this.examService.viewQuestions().subscribe( (data) => this.retrievedQuestions = data)
  }
  viewAnswers(){
    this.examService.viewAnswers().subscribe( (data) => this.retrievedAnswers = data)
  }
}
