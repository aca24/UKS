package com.github.minigithub.dto;

import com.github.minigithub.model.History;

public class HistoryDTO {

	private Long id;
	private String comment;
	
	public HistoryDTO(Long id, String comment) {
		super();
		this.id = id;
		this.comment = comment;
	}
	public HistoryDTO() {
		super();
	}
	public HistoryDTO(History h) {
		this.id = h.getId();
		this.comment = h.getComment();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
