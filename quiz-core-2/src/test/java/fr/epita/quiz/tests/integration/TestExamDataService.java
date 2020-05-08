package fr.epita.quiz.tests.integration;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.User;
import fr.epita.quiz.services.business.ExamBusinessException;
import fr.epita.quiz.services.business.ExamDataService;
import fr.epita.quiz.services.dao.AnswerDAO;
import fr.epita.quiz.services.dao.QuestionDAO;
import fr.epita.quiz.services.dao.UserDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestExamDataService {

	@Inject
	ExamDataService ds;
	
	@Inject
	AnswerDAO answerDao;
	
	@Inject
	QuestionDAO questionDao;
	
	@Inject
	UserDAO userDao;
	
	@Test
	public void testAnswerToQuestion() {
		//Given
		User user = new User();
		user.setLoginName("test");
		user.setEmail("test@test.com");
		userDao.create(user);
		
		Question question = new Question();
		question.setTitle("What is Java");
		questionDao.create(question);
		
		//When
		Answer answer = new Answer();
		answer.setContent("I don't know");
		
		try {
			ds.answerToQuestion(user, question, answer);
		} catch (ExamBusinessException e) {
			//log exception using logger
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Then
		Answer fetchedAnswer= answerDao.getById(answer.getId());
		
		assertEquals(fetchedAnswer.getUser().getLoginName(), user.getLoginName());
		
	}
	
	
}
