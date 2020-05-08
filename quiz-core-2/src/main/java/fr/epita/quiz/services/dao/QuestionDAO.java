package fr.epita.quiz.services.dao;

import java.util.Map;

import fr.epita.quiz.datamodel.Question;

public class QuestionDAO extends GenericDAO<Question, Long>{

	@Override
	public String getQuery() {
		return "from Question where title = :pTitle";
	}
	
	@Override
	public String getQueryAll() {
		return "from Question";
	}
	
	@Override
	public void setParameters(Map<String, Object> parameters, Question criteria) {
		parameters.put("pTitle", criteria.getTitle());		
	}

	@Override
	public Class<Question> getEntityClass() {
		return Question.class;
	}
	
}
