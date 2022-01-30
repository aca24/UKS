package com.github.minigithub.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "issues")
public class Issue extends Task implements Serializable {

   /**
	 * 
	 */
	private static final long serialVersionUID = -220503578596097473L;

   @Column(name = "title", unique = false, nullable = false)
   private String title;

   @Column(name = "description", unique = false, nullable = false)
   private String description;

   @Column(name = "dateCreated", unique = false, nullable = false)
   private Date dateCreated;

   @ManyToMany(mappedBy = "issues")
   public Collection<PullRequest> pullRequests;

   public Issue(String title, String description, Date dateCreated, Collection<PullRequest> pullRequests) {
      super();
      this.title = title;
      this.description = description;
      this.dateCreated = dateCreated;
      this.pullRequests = pullRequests;
   }
}