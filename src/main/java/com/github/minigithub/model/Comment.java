package com.github.minigithub.model;

import javax.persistence.*;
import java.util.Date;
import com.github.minigithub.dto.CommentDTO;

@Entity
@Table(name = "comments")
public class Comment extends Event {

   @Column(name = "content", unique = false, nullable = false)
   private String content;

   public Comment() {
   }

   public Comment(Long id, Date creationTime, Task task) {
      super(id, creationTime, task);
   }

   public Comment(Long id, Date creationTime, Task task, String content) {
      super(id, creationTime, task);
      this.content = content;
   }

   public Comment(CommentDTO comment) {
      super(comment.getId(), comment.getCreationTime(), new Task(comment.getTask()));
      this.content = comment.getContent();
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }
}