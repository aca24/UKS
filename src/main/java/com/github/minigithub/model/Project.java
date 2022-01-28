package com.github.minigithub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
@Table(name = "projects")
public class Project implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "title", unique = false, nullable = false)
   private String title;

   @ManyToOne()
   public GitRepo gitRepo;

   @OneToMany()
   public Collection<Milestone> milestones;

   @OneToMany()
   public Collection<Label> labels;

   @ManyToMany()
   @JoinTable(name = "developers_projects", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
   public Collection<User> developers;

   @Column(name = "leader", unique = false, nullable = false)
   public User leader;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Collection<Milestone> getMilestone() {
      if (milestones == null)
         milestones = new HashSet<Milestone>();
      return milestones;
   }

   public Iterator getIteratorMilestone() {
      if (milestones == null)
         milestones = new HashSet<Milestone>();
      return milestones.iterator();
   }

   public void setMilestone(Collection<Milestone> newMilestone) {
      removeAllMilestone();
      for (Iterator iter = newMilestone.iterator(); iter.hasNext();)
         addMilestone((Milestone) iter.next());
   }

   public void addMilestone(Milestone newMilestone) {
      if (newMilestone == null)
         return;
      if (this.milestones == null)
         this.milestones = new HashSet<Milestone>();
      if (!this.milestones.contains(newMilestone))
         this.milestones.add(newMilestone);
   }

   public void removeMilestone(Milestone oldMilestone) {
      if (oldMilestone == null)
         return;
      if (this.milestones != null)
         if (this.milestones.contains(oldMilestone))
            this.milestones.remove(oldMilestone);
   }

   public void removeAllMilestone() {
      if (milestones != null)
         milestones.clear();
   }

   public Collection<Label> getLabel() {
      if (labels == null)
         labels = new HashSet<Label>();
      return labels;
   }

   public Iterator getIteratorLabel() {
      if (labels == null)
         labels = new HashSet<Label>();
      return labels.iterator();
   }

   public void setLabel(Collection<Label> newLabel) {
      removeAllLabel();
      for (Iterator iter = newLabel.iterator(); iter.hasNext();)
         addLabel((Label) iter.next());
   }

   public void addLabel(Label newLabel) {
      if (newLabel == null)
         return;
      if (this.labels == null)
         this.labels = new HashSet<Label>();
      if (!this.labels.contains(newLabel))
         this.labels.add(newLabel);
   }

   public void removeLabel(Label oldLabel) {
      if (oldLabel == null)
         return;
      if (this.labels != null)
         if (this.labels.contains(oldLabel))
            this.labels.remove(oldLabel);
   }

   public void removeAllLabel() {
      if (labels != null)
         labels.clear();
   }
}