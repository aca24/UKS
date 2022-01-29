package com.github.minigithub.dto;

import java.util.Collection;

import com.github.minigithub.model.*;

public class TaskDTO {
    private Long id;
    private Collection<EventDTO> events;
    private MilestoneDTO milestone;
    private User creator;

    public TaskDTO(){

    }

    public Long getId() {
		return id;
	}

    public void setId(Long id) {
		this.id = id;
	}

    public Collection<EventDTO> getEvents() {
		return events;
	}

	public void setEvents(Collection<EventDTO> events) {
		this.events = events;
	}

    public MilestoneDTO getMilestone() {
		return milestone;
	}

	public void setMilestone(MilestoneDTO milestone) {
		this.milestone = milestone;
	}

    public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

}
