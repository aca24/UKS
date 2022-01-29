package com.github.minigithub.dto;

import java.util.Collection;

import com.github.minigithub.model.*;

public class TaskDTO {
    private Long id;
    private Collection<Event> events;
    private Milestone milestone;
    private User creator;

    public TaskDTO(){

    }

    public Long getId() {
		return id;
	}

    public void setId(Long id) {
		this.id = id;
	}

    public Collection<Event> getEvents() {
		return events;
	}

	public void setEvents(Collection<Event> events) {
		this.events = events;
	}

    public Milestone getMilestone() {
		return milestone;
	}

	public void setMilestone(Milestone milestone) {
		this.milestone = milestone;
	}

    public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

}
