package com.github.minigithub.dto;

import java.io.Serializable;
import java.util.*;

public class EventDTO implements Serializable {

    private Long id;

	private Date dateTime;

	//public TaskDTO task;  

    public EventDTO() {
    }

    public EventDTO(Long id, Date dateTime) {
        this.id = id;
        this.dateTime = dateTime;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
