package com.github.minigithub.dto;

import java.io.Serializable;
import java.util.*;

import com.github.minigithub.model.Comment;

public class CommentDTO extends EventDTO implements Serializable {

    private Date dateCreated;

    private String content;

    public CommentDTO() {
    }

    public CommentDTO(Long id, Date dateTime, TaskDTO task) {
        super(id, dateTime, task);
    }

    public CommentDTO(Date dateCreated, String content) {
        this.dateCreated = dateCreated;
        this.content = content;
    }

    public CommentDTO(Long id, Date dateTime, TaskDTO task, Date dateCreated, String content) {
        super(id, dateTime, task);
        this.dateCreated = dateCreated;
        this.content = content;
    }

    public CommentDTO(Comment comment) {
        super(comment.getId(), comment.getDateTime(), comment.getTask());
        this.dateCreated = comment.getDateCreated();
        this.content = comment.getContent();
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
