package com.github.minigithub.model;

import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDateTime;

import com.github.minigithub.dto.StateChangeDTO;

@Entity
@Table(name = "stateChanges")
public class StateChange extends Event {

   @Column(name = "newState", unique = false, nullable = false)
   @Enumerated(EnumType.STRING)
   private State newState;

   public StateChange() {
   }

   public StateChange(Long id, Date dateTime, Task task) {
      super(id, dateTime, task);
   }

   public StateChange(Long id, Date dateTime, Task task, State newState) {
      super(id, dateTime, task);
      this.newState = newState;
   }

   public StateChange(StateChangeDTO stateChange) {
      super(stateChange.getId(), stateChange.getCreationTime(), new Task(stateChange.getTask()));
      this.newState = stateChange.getNewState();
   }

   public StateChange(State newState) {
      super();
      this.newState = newState;
   }

   public State getNewState() {
      return newState;
   }

   public void setNewState(State newState) {
      this.newState = newState;
   }
}