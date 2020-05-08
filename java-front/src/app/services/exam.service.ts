import { Injectable } from '@angular/core';
import { Answer } from '../datamodel/answer';
import { Question } from '../datamodel/question';
import { User } from '../datamodel/user';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class ExamService {
  url_answer: string = "http://localhost:8080/quiz-rest/rest/exam/answer";
  url_question: string = "http://localhost:8080/quiz-rest/rest/exam/question";
  url_user: string = "http://localhost:8080/quiz-rest/rest/exam/user";

  constructor(private httpClient: HttpClient) { }

  // Questions
  createQuestion(question : Question){
    this.httpClient.post(this.url_question, question).subscribe((data) => console.log(data));
  }

  deleteQuestion(question : Question){
    
  }

  updateQuestion(question : Question){
    this.httpClient.put(this.url_question, question).subscribe((data) => console.log(data));
  }

  viewQuestions(){
    return this.httpClient.get(this.url_question)
  }
 

  // Answers
  createAnswer(answer : Answer){
    this.httpClient.post(this.url_answer, answer).subscribe((data) => console.log(data));
  }
  viewAnswers(){
    return this.httpClient.get(this.url_answer)
  }


  // Users
  viewUsers(){
    return this.httpClient.get(this.url_user)
  }

}
