package com.github.minigithub.dto;

import java.io.Serializable;
import java.util.*;

public class CommentDTO extends EventDTO implements Serializable {
    
    private Date dateCreated;

    private String content;

    public CommentDTO() {
    }

    public CommentDTO(Long id, Date dateTime) {
        super(id, dateTime);
    }

    public CommentDTO(Date dateCreated, String content) {
        this.dateCreated = dateCreated;
        this.content = content;
    }

    public CommentDTO(Long id, Date dateTime, Date dateCreated, String content) {
        super(id, dateTime);
        this.dateCreated = dateCreated;
        this.content = content;
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
