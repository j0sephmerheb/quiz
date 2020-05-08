import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { QuizSolveComponent } from './components/quiz-solve/quiz-solve.component';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { QuizEditComponent } from './components/quiz-edit/quiz-edit.component';
import { QuizTeacherHomeComponent } from './components/quiz-teacher-home/quiz-teacher-home.component';
import { QuizTeacherGetQuestionsComponent } from './components/quiz-teacher-get-questions/quiz-teacher-get-questions.component';
import { QuizResultsComponent } from './components/quiz-results/quiz-results.component';

@NgModule({
  declarations: [
    AppComponent,
    QuizSolveComponent,
    LandingPageComponent,
    QuizEditComponent,
    QuizTeacherHomeComponent,
    QuizTeacherGetQuestionsComponent,
    QuizResultsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
