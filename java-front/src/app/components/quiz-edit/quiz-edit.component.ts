import { Component, OnInit } from '@angular/core';
import { Question } from 'src/app/datamodel/question';
import { Answer } from 'src/app/datamodel/answer';
import { ExamService } from 'src/app/services/exam.service';

@Component({
  selector: 'app-quiz-edit',
  templateUrl: './quiz-edit.component.html',
  styleUrls: ['./quiz-edit.component.css']
})
export class QuizEditComponent implements OnInit {
  question : Question = new Question();
  answer : Answer = new Answer();

  constructor(private examService : ExamService) { }

  ngOnInit(): void {
  }

  createQuestion(){    
    this.examService.createQuestion(this.question);
    alert("Question Saved")
  }

}
