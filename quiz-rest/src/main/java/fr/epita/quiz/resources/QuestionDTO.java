package fr.epita.quiz.resources;

import fr.epita.quiz.datamodel.Question;

public class QuestionDTO {
	private Long id;
	
	public String title;
	
	public QuestionDTO() {
		
	}

	public QuestionDTO(Question entity) {
		this.title = entity.getTitle();
	}
	
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	
}
