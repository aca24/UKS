package com.github.minigithub.dto;

import java.util.Date;

public class IssueDTO extends TaskDTO {
	
	private String title;
	
	private String description;
	
	private Date dateCreated;
	
	public IssueDTO(String title, String description, Date dateCreated) {
		this.title = title;
		this.description = description;
		this.dateCreated = dateCreated;
		
	}

	public IssueDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	
	
	

}
