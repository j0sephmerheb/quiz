import { Component, OnInit } from '@angular/core';
import { Question } from 'src/app/datamodel/question';
import { Answer } from 'src/app/datamodel/answer';
import { ExamService } from 'src/app/services/exam.service';

@Component({
  selector: 'app-quiz-solve',
  templateUrl: './quiz-solve.component.html',
  styleUrls: ['./quiz-solve.component.css']
})
export class QuizSolveComponent implements OnInit {
  question : Question = new Question();
  answer : Answer = new Answer();
  retrievedQuestions;
  retrievedAnswers;

  constructor(private examService : ExamService) { }

  ngOnInit(): void {
    this.viewQuestions();
    this.viewAnswers();
  }

  submit(){
    alert("Quiz Submited");
  }
  
  viewQuestions(){
    this.examService.viewQuestions().subscribe( (data) => this.retrievedQuestions = data)
  }
  
  viewAnswers(){
    this.examService.viewAnswers().subscribe( (data) => this.retrievedAnswers = data)
  }

}
