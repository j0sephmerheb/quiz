package fr.epita.quiz.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestBody;

import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.User;
import fr.epita.quiz.services.business.ExamDataService;

@Path("/exam")
public class ExamResource {
	@Inject
	ExamDataService examDS;
	
	/**
	 * 
	 * Answers
	 * 
	 */
	@POST
	@Path("/answer")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response addAnswerToQuestion(@RequestBody AnswerDTO answerDTO) {		
		Answer answer = new Answer();
		answer.setContent(answerDTO.getContent());		
		System.out.println("Answer:" + answerDTO.getContent());
		
		try {
			return Response.created(new URI("/rest/exam/answer/" + answer.getId())).build();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return Response.serverError().build();
	}
	
	
	@GET
	@Path("/answer/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getAnswer(@PathParam("id") long answerId) {
		return null; 
	}
	
	@DELETE
	@Path("/answer/{id}")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response deleteAnswer(@RequestBody AnswerDTO answerDTO) {			
		return null;
	}
	
	@PUT
	@Path("/answer/{id}")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response updateAnswer(@RequestBody AnswerDTO answerDTO) {			
		return null;
	}
	

	@GET
	@Path("/answer")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response viewAnswers() {	
		List<Answer> answers = examDS.retrieveAllAnswer();
		try {
			return Response.ok(answers).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.serverError().build();
	}
	

	
	/**
	 * 
	 * Questions
	 * 
	 */
	@POST
	@Path("/question")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response createQuestion(@RequestBody QuestionDTO questionDTO) {		
		Question question = new Question();
		question.setTitle(questionDTO.getTitle());	

		System.out.println("New Question with title:" + questionDTO.getTitle());	
		
		try {
			return Response.created(new URI("/rest/exam/question/")).build();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return Response.serverError().build();
	}
	
	
	@DELETE
	@Path("/question/{id}")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response deleteQuestion(@PathParam("id") long questionId) {				
		return Response.serverError().build();
	}
	
	
	@GET
	@Path("/question")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response viewQuestions() {	
		List<Question> questions = examDS.retrieveAllQuestion();
		try {
			return Response.ok(questions).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.serverError().build();
	}
	
	
	/**
	 * 
	 * Users
	 * 
	 */
	
	@GET
	@Path("/user")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response viewUsers() {	
		List<User> user = examDS.retrieveAllUser();
		try {
			return Response.ok(user).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.serverError().build();
	}
	
}
