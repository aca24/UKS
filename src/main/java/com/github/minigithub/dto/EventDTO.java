package com.github.minigithub.dto;

import java.io.Serializable;
import java.util.Date;
import com.github.minigithub.model.Event;
import com.github.minigithub.model.Task;

public class EventDTO implements Serializable {

    private Long id;

    private Date creationTime;

    public TaskDTO task;

    public EventDTO() {
    }

    public EventDTO(Long id, Date creationTime, TaskDTO task) {
        this.id = id;
        this.creationTime = creationTime;
        this.task = task;
    }

    public EventDTO(Long id, Date creationTime, Task task) {
        this.id = id;
        this.creationTime = creationTime;
        this.task = new TaskDTO(task);
    }

    public EventDTO(Long id, Date creationTime) {
        this.id = id;
        this.creationTime = creationTime;
    }

    public EventDTO(Event event) {
        this.id = event.getId();
        this.creationTime = event.getCreationTime();
        this.task = new TaskDTO(event.getTask());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public TaskDTO getTask() {
        return task;
    }

    public void setTask(TaskDTO task) {
        this.task = task;
    }
}
