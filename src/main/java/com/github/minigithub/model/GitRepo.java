package com.github.minigithub.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
@Table(name = "gitRepos")
public class GitRepo implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name", unique = false, nullable = false)
   private String name;

  // @OneToMany(mappedBy = "gitRepo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   @OneToMany()
   public Collection<Branch> branches;

   @OneToMany()
   public Collection<Project> projects;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Collection<Branch> getBranch() {
      if (branches == null)
         branches = new HashSet<Branch>();
      return branches;
   }

   public Iterator getIteratorBranch() {
      if (branches == null)
         branches = new HashSet<Branch>();
      return branches.iterator();
   }

   public void setBranch(Collection<Branch> newBranch) {
      removeAllBranch();
      for (Iterator iter = newBranch.iterator(); iter.hasNext();)
         addBranch((Branch) iter.next());
   }

   public void addBranch(Branch newBranch) {
      if (newBranch == null)
         return;
      if (this.branches == null)
         this.branches = new HashSet<Branch>();
      if (!this.branches.contains(newBranch))
         this.branches.add(newBranch);
   }

   public void removeBranch(Branch oldBranch) {
      if (oldBranch == null)
         return;
      if (this.branches != null)
         if (this.branches.contains(oldBranch))
            this.branches.remove(oldBranch);
   }

   public void removeAllBranch() {
      if (branches != null)
         branches.clear();
   }
}