package com.github.minigithub.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.github.minigithub.dto.UserDTO;

import java.util.HashSet;
import java.util.Iterator;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;
import javax.persistence.DiscriminatorType;
import javax.persistence.InheritanceType;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User implements UserDetails, Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "username", unique = false, nullable = false)
   private String username;

   @Column(name = "password", unique = false, nullable = false)
   private String password;

   @Column(name = "firstName", unique = false, nullable = false)
   private String firstName;

   @Column(name = "lastName", unique = false, nullable = false)
   private String lastName;

   @ManyToOne()
   @JoinColumn(name = "role_id")
   public Role role;

   @ManyToMany(mappedBy = "developers", cascade = CascadeType.DETACH)
   public Collection<Project> projects;

   @OneToMany(cascade = CascadeType.ALL)
   public Collection<Commit> commits;

   @OneToMany(cascade = CascadeType.ALL)
   public Collection<Task> tasks;

   public User(Long id, String username, String password, String firstName, String lastName) {
      super();
      this.id = id;
      this.username = username;
      this.password = password;
      this.firstName = firstName;
      this.lastName = lastName;
   }

   public User(UserDTO user) {
      this.id = user.getId();
      this.firstName = user.getFirstName();
      this.lastName = user.getLastName();
      this.username = user.getUsername();
      this.password = user.getPassword();
   }

   public User() {
      super();
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
		return firstName;
	}

    public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
    public String getLastName() {
		return lastName;
	}

    public void setLastName(String lastName) {
		this.lastName = lastName;
	}

   public Collection<Project> getProject() {
      if (projects == null)
         projects = new HashSet<Project>();
      return projects;
   }

   public Iterator getIteratorProject() {
      if (projects == null)
         projects = new HashSet<Project>();
      return projects.iterator();
   }

   public void setProject(Collection<Project> newProject) {
      removeAllProject();
      for (Iterator iter = newProject.iterator(); iter.hasNext();)
         addProject((Project) iter.next());
   }

   public void addProject(Project newProject) {
      if (newProject == null)
         return;
      if (this.projects == null)
         this.projects = new HashSet<Project>();
      if (!this.projects.contains(newProject))
         this.projects.add(newProject);
   }

   public void removeProject(Project oldProject) {
      if (oldProject == null)
         return;
      if (this.projects != null)
         if (this.projects.contains(oldProject))
            this.projects.remove(oldProject);
   }

   public void removeAllProject() {
      if (projects != null)
         projects.clear();
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
      if (!this.commits.contains(newCommit)) {
         this.commits.add(newCommit);
         newCommit.setCommiter(this);
      }
   }

   public void removeCommit(Commit oldCommit) {
      if (oldCommit == null)
         return;
      if (this.commits != null)
         if (this.commits.contains(oldCommit)) {
            this.commits.remove(oldCommit);
            oldCommit.setCommiter((User) null);
         }
   }

   public void removeAllCommit() {
      if (commits != null) {
         Commit oldCommit;
         for (Iterator iter = getIteratorCommit(); iter.hasNext();) {
            oldCommit = (Commit) iter.next();
            iter.remove();
            oldCommit.setCommiter((User) null);
         }
      }
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
      if (!this.tasks.contains(newTask))
         this.tasks.add(newTask);
   }

   public void removeTask(Task oldTask) {
      if (oldTask == null)
         return;
      if (this.tasks != null)
         if (this.tasks.contains(oldTask))
            this.tasks.remove(oldTask);
   }

   public void removeAllTask() {
      if (tasks != null)
         tasks.clear();
   }

   @Override
   public String toString() {
      // TODO Auto-generated method stub
      return super.toString();
   }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public String getPassword() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public String getUsername() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public boolean isAccountNonExpired() {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public boolean isAccountNonLocked() {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public boolean isEnabled() {
      // TODO Auto-generated method stub
      return false;
   }
}