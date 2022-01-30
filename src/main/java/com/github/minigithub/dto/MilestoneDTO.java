package com.github.minigithub.dto;

import java.util.Collection;
import java.util.Date;

import com.github.minigithub.model.State;


public class MilestoneDTO {

	private Long id;
	private String description;
	private String title;
	private Date dueDate;
	private State state;
	private Collection<TaskDTO> tasks;
	


	public MilestoneDTO(Long id, String description, String title, Date dueDate, State state,
			Collection<TaskDTO> tasks) {
		super();
		this.id = id;
		this.description = description;
		this.title = title;
		this.dueDate = dueDate;
		this.state = state;
		this.tasks = tasks;
	}

	public MilestoneDTO() {
		super();
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Collection<TaskDTO> getTasks() {
		return tasks;
	}

	public void setTasks(Collection<TaskDTO> tasks) {
		this.tasks = tasks;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	
	
}
