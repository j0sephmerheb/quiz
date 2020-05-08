package fr.epita.quiz.services.dao;

import java.util.Map;

import fr.epita.quiz.datamodel.Answer;

public class AnswerDAO extends GenericDAO<Answer, Long>{

	@Override
	public String getQuery() {
		return "from Answer";
	}
	
	@Override
	public String getQueryAll() {
		return "from Answer";
	}

	@Override
	public void setParameters(Map<String, Object> parameters, Answer criteria) {
		return;		
	}

	@Override
	public Class<Answer> getEntityClass() {
		return Answer.class;
	}


}
