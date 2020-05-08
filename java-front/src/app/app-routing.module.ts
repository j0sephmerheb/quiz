import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { QuizSolveComponent } from './components/quiz-solve/quiz-solve.component';
import { QuizEditComponent } from './components/quiz-edit/quiz-edit.component';
import { QuizTeacherHomeComponent } from './components/quiz-teacher-home/quiz-teacher-home.component';
import { QuizTeacherGetQuestionsComponent } from './components/quiz-teacher-get-questions/quiz-teacher-get-questions.component';
import { QuizResultsComponent } from './components/quiz-results/quiz-results.component';


const routes: Routes = [
  { path: '', component: LandingPageComponent },
  { path: 'home', component: LandingPageComponent },
  { path: 'quiz-edit', component: QuizEditComponent },
  { path: 'quiz-solve', component: QuizSolveComponent },
  { path: 'quiz-teacher-home', component: QuizTeacherHomeComponent },
  { path: 'quiz-teacher-get-questions', component: QuizTeacherGetQuestionsComponent },
  { path: 'quiz-results', component: QuizResultsComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
