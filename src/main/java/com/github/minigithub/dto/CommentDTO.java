package com.github.minigithub.dto;

import java.util.Date;

import com.github.minigithub.model.Comment;

public class CommentDTO extends EventDTO {

    private String content;

    public CommentDTO() {
    }

    public CommentDTO(Long id, Date creationTime, TaskDTO task) {
        super(id, creationTime, task);
    }

    public CommentDTO(String content) {
        this.content = content;
    }

    public CommentDTO(Long id, Date creationTime, TaskDTO task, String content) {
        super(id, creationTime, task);
        this.content = content;
    }

    public CommentDTO(Comment comment) {
        super(comment.getId(), comment.getCreationTime(), comment.getTask());
        this.content = comment.getContent();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
