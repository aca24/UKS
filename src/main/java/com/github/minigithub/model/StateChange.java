package com.github.minigithub.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stateChanges")
public class StateChange extends Event implements Serializable {

   @Column(name = "newState", unique = false, nullable = false)
   private State newState;

   public StateChange(State newState) {
      super();
      this.newState = newState;
   }
}