package com.github.minigithub.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

   @Column(name = "user", unique = false, nullable = false)
   public User user;

   @ManyToOne()
   public Branch branch;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public User getUser() {
      return user;
   }

   public void setUser(User newUser) {
      if (this.user == null || !this.user.equals(newUser)) {
         if (this.user != null) {
            User oldUser = this.user;
            this.user = null;
            oldUser.removeCommit(this);
         }
         if (newUser != null) {
            this.user = newUser;
            this.user.addCommit(this);
         }
      }
   }
}