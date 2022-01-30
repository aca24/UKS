package com.github.minigithub.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.github.minigithub.dto.MilestoneDTO;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
@Table(name = "milestones")
public class Milestone implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "description", unique = false, nullable = false)
   private String description;

   @Column(name = "title", unique = false, nullable = false)
   private String title;

   @Column(name = "dueDate", unique = false, nullable = false)
   private Date dueDate;

   @Column(name = "state", unique = false, nullable = false)
   @Enumerated(EnumType.STRING)
   private State state;

   @OneToMany(mappedBy = "milestone")
   public Collection<Task> tasks;

   public Milestone(){

   }
   
   public Milestone(MilestoneDTO milestone) {
		this.id = milestone.getId();
		this.description = milestone.getDescription();
		this.title = milestone.getTitle();
		this.state = milestone.getState();
	}

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public Date getDueDate() {
      return dueDate;
   }

   public void setDueDate(Date dueDate) {
      this.dueDate = dueDate;
   }

   public State getState() {
      return state;
   }

   public void setState(State state) {
      this.state = state;
   }

   public Collection<Task> getTasks() {
      return tasks;
   }

   public void setTasks(Collection<Task> tasks) {
      this.tasks = tasks;
   }

   public Collection<Task> getTask() {
      if (tasks == null)
         tasks = new HashSet<Task>();
      return tasks;
   }

   public Iterator getIteratorTask() {
      if (tasks == null)
         tasks = new HashSet<Task>();
      return tasks.iterator();
   }

   public void setTask(Collection<Task> newTask) {
      removeAllTask();
      for (Iterator iter = newTask.iterator(); iter.hasNext();)
         addTask((Task) iter.next());
   }

   public void addTask(Task newTask) {
      if (newTask == null)
         return;
      if (this.tasks == null)
         this.tasks = new HashSet<Task>();
      if (!this.tasks.contains(newTask)) {
         this.tasks.add(newTask);
         newTask.setMilestone(this);
      }
   }

   public void removeTask(Task oldTask) {
      if (oldTask == null)
         return;
      if (this.tasks != null)
         if (this.tasks.contains(oldTask)) {
            this.tasks.remove(oldTask);
            oldTask.setMilestone((Milestone) null);
         }
   }

   public void removeAllTask() {
      if (tasks != null) {
         Task oldTask;
         for (Iterator iter = getIteratorTask(); iter.hasNext();) {
            oldTask = (Task) iter.next();
            iter.remove();
            oldTask.setMilestone((Milestone) null);
         }
      }
   }
}