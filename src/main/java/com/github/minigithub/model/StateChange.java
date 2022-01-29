package com.github.minigithub.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "stateChanges")
public class StateChange extends Event implements Serializable {

   @Column(name = "newState", unique = false, nullable = false)
   @Enumerated(EnumType.STRING)
   private State newState;

   public StateChange(State newState) {
      super();
      this.newState = newState;
   }
}