package com.github.minigithub.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.github.minigithub.dto.CommitDTO;

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

   public Date getDateTime() {
      return dateTime;
   }

   public String getLogMessage() {
      return logMessage;
   }

   public String getHash() {
      return hash;
   }

   public User getCommiter() {
      return commiter;
   }

   public void setCommiter(User newCommiter) {
      this.commiter = newCommiter;
   }

   public Branch getBranch() {
      return branch;
   }

   public void setBranch(Branch branch) {
      this.branch = branch;
   }

   public Commit(CommitDTO commitDTO) {
      this.logMessage = commitDTO.getLogMessage();
      this.hash = commitDTO.getHash();
      this.dateTime = commitDTO.getDateTime();
   }

}