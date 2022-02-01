package com.github.minigithub.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pullRequests")
public class PullRequest extends Task implements Serializable {

   /**
	 * 
	 */
	private static final long serialVersionUID = -3786980603970889902L;

public PullRequest() {
		super();
	}

   


   @Column(name = "name", unique = false, nullable = false)
   private String name;

   @ManyToMany()
   @JoinTable(name = "issues_pull_requests", joinColumns = @JoinColumn(name = "pull_request_id"), inverseJoinColumns = @JoinColumn(name = "issue_id"))
   public Collection<Issue> issues;

   @ManyToOne()
   public Branch branch;
   
   public PullRequest(String name, Branch branch) {
	      super();
	      this.name = name;
	      this.branch = branch;
	   }

   public PullRequest(String name, Collection<Issue> issues, Branch branch) {
      super();
      this.name = name;
      this.issues = issues;
      this.branch = branch;
   }

   public Collection<Issue> getIssue() {
      if (issues == null)
         issues = new HashSet<Issue>();
      return issues;
   }

   public Iterator getIteratorIssue() {
      if (issues == null)
         issues = new HashSet<Issue>();
      return issues.iterator();
   }

   public void setIssue(Collection<Issue> newIssue) {
      removeAllIssue();
      for (Iterator iter = newIssue.iterator(); iter.hasNext();)
         addIssue((Issue) iter.next());
   }

   public void addIssue(Issue newIssue) {
      if (newIssue == null)
         return;
      if (this.issues == null)
         this.issues = new HashSet<Issue>();
      if (!this.issues.contains(newIssue))
         this.issues.add(newIssue);
   }

   public void removeIssue(Issue oldIssue) {
      if (oldIssue == null)
         return;
      if (this.issues != null)
         if (this.issues.contains(oldIssue))
            this.issues.remove(oldIssue);
   }

   public void removeAllIssue() {
      if (issues != null)
         issues.clear();
   }

   public Branch getBranch() {
      return branch;
   }

   public void setBranch(Branch newBranch) {
      if (this.branch == null || !this.branch.equals(newBranch)) {
         if (this.branch != null) {
            Branch oldBranch = this.branch;
            this.branch = null;
            oldBranch.removePullRequest(this);
         }
         if (newBranch != null) {
            this.branch = newBranch;
            this.branch.addPullRequest(this);
         }
      }
   }

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Collection<Issue> getIssues() {
	return issues;
}

public void setIssues(Collection<Issue> issues) {
	this.issues = issues;
}
}