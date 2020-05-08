import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/datamodel/user';
import { ExamService } from 'src/app/services/exam.service';

@Component({
  selector: 'app-quiz-results',
  templateUrl: './quiz-results.component.html',
  styleUrls: ['./quiz-results.component.css']
})
export class QuizResultsComponent implements OnInit {
  retrievedUsers;

  constructor(private examService : ExamService) { }

  ngOnInit(): void {
    this.viewUsers();
  }

  viewUsers(){
    this.examService.viewUsers().subscribe( (data) => this.retrievedUsers = data)
  }

}
