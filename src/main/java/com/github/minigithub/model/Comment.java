package com.github.minigithub.model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment extends Event implements Serializable {

   @Column(name = "dateCreated", unique = false, nullable = false)
   private Date dateCreated;

   @Column(name = "content", unique = false, nullable = false)
   private String content;

   public Comment(Date dateCreated, String content) {
      super();
      this.dateCreated = dateCreated;
      this.content = content;
   }
}