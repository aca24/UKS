package com.github.minigithub.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Project implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "title", unique = false, nullable = false)
   private String title;

   @ManyToOne
   public GitRepo gitRepo;

   @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
   public Collection<Milestone> milestones;

   @OneToMany(cascade = CascadeType.ALL)
   public Collection<Label> labels;

   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(name = "developers_projects", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
   public Collection<User> developers;

   //@Column(name = "leader", unique = false, nullable = false)
   @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
   @JoinColumn(name = "leader_id", unique = false, nullable = false)
   public User leader;

   
   public Project() {
	super();
   }

   public Project(Long id, String title, GitRepo gitRepo, Collection<Milestone> milestones, Collection<Label> labels,
		Collection<User> developers, User leader) {
		super();
		this.id = id;
		this.title = title;
		this.gitRepo = gitRepo;
		this.milestones = milestones;
		this.labels = labels;
		this.developers = developers;
		this.leader = leader;
   }
   
   

	public String getTitle() {
	return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public GitRepo getGitRepo() {
		return gitRepo;
	}
	
	public void setGitRepo(GitRepo gitRepo) {
		this.gitRepo = gitRepo;
	}
	
	public Collection<Milestone> getMilestones() {
		return milestones;
	}
	
	public void setMilestones(Collection<Milestone> milestones) {
		this.milestones = milestones;
	}
	
	public Collection<Label> getLabels() {
		return labels;
	}
	
	public void setLabels(Collection<Label> labels) {
		this.labels = labels;
	}
	
	public Collection<User> getDevelopers() {
		return developers;
	}
	
	public void setDevelopers(Collection<User> developers) {
		this.developers = developers;
	}
	
	public User getLeader() {
		return leader;
	}
	
	public void setLeader(User leader) {
		this.leader = leader;
	}

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