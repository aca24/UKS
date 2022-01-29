package com.github.minigithub.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;

@Entity
@Table(name = "commits")
public class Commit implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "dateTime", unique = false, nullable = false)
   private Date dateTime;

   @Column(name = "logMessage", unique = false, nullable = false)
   private String logMessage;

   @Column(name = "hash", unique = true, nullable = false)
   private String hash;

   @ManyToOne
   @JoinColumn(name = "user_id", nullable = false, unique = false)
   public User commiter;

   @ManyToOne()
   public Branch branch;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public User getCommiter() {
	   return commiter;
}

   public void setCommiter(User newCommiter) {
	   if (this.commiter == null || !this.commiter.equals(newCommiter)) {
         if (this.commiter != null) {
            User oldUser = this.commiter;
            this.commiter = null;
            oldUser.removeCommit(this);
         }
         if (newCommiter != null) {
            this.commiter = newCommiter;
            this.commiter.addCommit(this);
         }
      }
	   this.commiter = commiter;
}
   

}