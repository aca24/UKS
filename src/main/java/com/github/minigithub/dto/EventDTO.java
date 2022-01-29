package com.github.minigithub.dto;

import java.io.Serializable;
import java.util.*;

import com.github.minigithub.model.Event;
import com.github.minigithub.model.Task;

public class EventDTO implements Serializable {

    private Long id;

    private Date dateTime;

    public TaskDTO task;

    public EventDTO() {
    }

    public EventDTO(Long id, Date dateTime, TaskDTO task) {
        this.id = id;
        this.dateTime = dateTime;
        this.task = task;
    }

    public EventDTO(Long id, Date dateTime, Task task) {
        this.id = id;
        this.dateTime = dateTime;
        this.task = new TaskDTO(task);
    }

    public EventDTO(Event event) {
        this.id = event.getId();
        this.dateTime = event.getDateTime();
        this.task = new TaskDTO(event.getTask());
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

    public TaskDTO getTask() {
        return task;
    }

    public void setTask(TaskDTO task) {
        this.task = task;
    }
}
