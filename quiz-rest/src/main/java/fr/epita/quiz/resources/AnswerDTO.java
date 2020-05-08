package fr.epita.quiz.resources;

import fr.epita.quiz.datamodel.Answer;

public class AnswerDTO {
	private Long id;
	
	public String content;
	
	public AnswerDTO() {
		
	}
	
	public Long getId() {
		return id;
	}

	public AnswerDTO(Answer entity) {
		this.content = entity.getContent();
	}
	
	public String getContent() {
		return content;
	}
	
}
