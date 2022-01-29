package com.github.minigithub.model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.github.minigithub.dto.CommentDTO;

@Entity
@Table(name = "comments")
public class Comment extends Event implements Serializable {

   @Column(name = "dateCreated", unique = false, nullable = false)
   private Date dateCreated;

   @Column(name = "content", unique = false, nullable = false)
   private String content;

   public Comment() {
   }

   public Comment(Long id, Date dateTime, Task task) {
      super(id, dateTime, task);
   }

   public Comment(Long id, Date dateTime, Task task, Date dateCreated, String content) {
      super(id, dateTime, task);
      this.dateCreated = dateCreated;
      this.content = content;
   }

   public Comment(CommentDTO comment) {
      super(comment.getId(), comment.getDateTime(), new Task(comment.getTask()));
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