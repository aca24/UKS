package com.github.minigithub.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

@Entity
@Table(name = "branches")
public class Branch implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name", unique = true, nullable = false)
   private String name;

   @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
   public Collection<Commit> commits;

   @OneToMany(mappedBy = "branch", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   public Collection<PullRequest> pullRequests;

   @ManyToOne()
   public GitRepo gitRepo;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Collection<Commit> getCommit() {
      if (commits == null)
         commits = new HashSet<Commit>();
      return commits;
   }

   public Iterator getIteratorCommit() {
      if (commits == null)
         commits = new HashSet<Commit>();
      return commits.iterator();
   }

   public void setCommit(Collection<Commit> newCommit) {
      removeAllCommit();
      for (Iterator iter = newCommit.iterator(); iter.hasNext();)
         addCommit((Commit) iter.next());
   }

   public void addCommit(Commit newCommit) {
      if (newCommit == null)
         return;
      if (this.commits == null)
         this.commits = new HashSet<Commit>();
      if (!this.commits.contains(newCommit))
         this.commits.add(newCommit);
   }

   public void removeCommit(Commit oldCommit) {
      if (oldCommit == null)
         return;
      if (this.commits != null)
         if (this.commits.contains(oldCommit))
            this.commits.remove(oldCommit);
   }

   public void removeAllCommit() {
      if (commits != null)
         commits.clear();
   }

   public Collection<PullRequest> getPullRequest() {
      if (pullRequests == null)
         pullRequests = new HashSet<PullRequest>();
      return pullRequests;
   }

   public Iterator getIteratorPullRequest() {
      if (pullRequests == null)
         pullRequests = new HashSet<PullRequest>();
      return pullRequests.iterator();
   }

   public void setPullRequest(Collection<PullRequest> newPullRequest) {
      removeAllPullRequest();
      for (Iterator iter = newPullRequest.iterator(); iter.hasNext();)
         addPullRequest((PullRequest) iter.next());
   }

   public void addPullRequest(PullRequest newPullRequest) {
      if (newPullRequest == null)
         return;
      if (this.pullRequests == null)
         this.pullRequests = new HashSet<PullRequest>();
      if (!this.pullRequests.contains(newPullRequest)) {
         this.pullRequests.add(newPullRequest);
         newPullRequest.setBranch(this);
      }
   }

   public void removePullRequest(PullRequest oldPullRequest) {
      if (oldPullRequest == null)
         return;
      if (this.pullRequests != null)
         if (this.pullRequests.contains(oldPullRequest)) {
            this.pullRequests.remove(oldPullRequest);
            oldPullRequest.setBranch((Branch) null);
         }
   }

   public void removeAllPullRequest() {
      if (pullRequests != null) {
         PullRequest oldPullRequest;
         for (Iterator iter = getIteratorPullRequest(); iter.hasNext();) {
            oldPullRequest = (PullRequest) iter.next();
            iter.remove();
            oldPullRequest.setBranch((Branch) null);
         }
      }
   }
}