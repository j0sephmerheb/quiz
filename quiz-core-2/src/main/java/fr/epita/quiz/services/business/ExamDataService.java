package fr.epita.quiz.services.business;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.User;
import fr.epita.quiz.services.dao.AnswerDAO;
import fr.epita.quiz.services.dao.QuestionDAO;
import fr.epita.quiz.services.dao.UserDAO;

public class ExamDataService {
	@Inject
	UserDAO userDAO;
	
	@Inject
	QuestionDAO questionDAO;

	@Inject
	AnswerDAO answerDAO;
	
	@Transactional(value = TxType.REQUIRED)
	public void answerToQuestion(User user, Question question, Answer answer) throws ExamBusinessException{
		answer.setUser(user);
		answer.setQuestion(question);
		
		answerDAO.create(answer);		
	}
	

	@Transactional(value = TxType.REQUIRED)
	public void deleteQuestion(Question question) throws ExamBusinessException{
		questionDAO.delete(question);						
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void createQuestion(Question question) throws ExamBusinessException{
		questionDAO.create(question);						
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void updateQuestion(Question question) throws ExamBusinessException{
		questionDAO.update(question);						
	}
	
	public List<Question> retrieveAllQuestion() {
		return questionDAO.searchAll();
	}
	
	public List<Answer> retrieveAllAnswer() {
		return answerDAO.searchAll();
	}
	
	
	public List<User> retrieveAllUser() {
		return userDAO.searchAll();
	}
	
}
