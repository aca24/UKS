package com.github.minigithub.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;
import javax.persistence.InheritanceType;
import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

@Entity
@Table(name="tasks")
@Inheritance(strategy=TABLE_PER_CLASS)
public class Task implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private Long id;

   @OneToMany(mappedBy = "task")
   public Collection<Event> events;

   @ManyToOne()
   public Milestone milestone;

   @Column(name = "user", unique = false, nullable = false)
   public User user;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Collection<Event> getEvent() {
      if (events == null)
         events = new HashSet<Event>();
      return events;
   }

   public Iterator getIteratorEvent() {
      if (events == null)
         events = new HashSet<Event>();
      return events.iterator();
   }

   public void setEvent(Collection<Event> newEvent) {
      removeAllEvent();
      for (Iterator iter = newEvent.iterator(); iter.hasNext();)
         addEvent((Event) iter.next());
   }

   public void addEvent(Event newEvent) {
      if (newEvent == null)
         return;
      if (this.events == null)
         this.events = new HashSet<Event>();
      if (!this.events.contains(newEvent))
         this.events.add(newEvent);
   }

   public void removeEvent(Event oldEvent) {
      if (oldEvent == null)
         return;
      if (this.events != null)
         if (this.events.contains(oldEvent))
            this.events.remove(oldEvent);
   }

   public void removeAllEvent() {
      if (events != null)
         events.clear();
   }

   public Milestone getMilestone() {
      return milestone;
   }

   public void setMilestone(Milestone newMilestone) {
      if (this.milestone == null || !this.milestone.equals(newMilestone)) {
         if (this.milestone != null) {
            Milestone oldMilestone = this.milestone;
            this.milestone = null;
            oldMilestone.removeTask(this);
         }
         if (newMilestone != null) {
            this.milestone = newMilestone;
            this.milestone.addTask(this);
         }
      }
   }
}