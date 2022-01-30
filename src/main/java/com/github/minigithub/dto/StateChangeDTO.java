package com.github.minigithub.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

import com.github.minigithub.model.State;
import com.github.minigithub.model.StateChange;

public class StateChangeDTO extends EventDTO implements Serializable {

  private State newState;

  public StateChangeDTO() {

  }

  public StateChangeDTO(Long id, LocalDateTime dateTime, TaskDTO task) {
    super(id, dateTime, task);
  }

  public StateChangeDTO(State newState) {
    this.newState = newState;
  }

  public StateChangeDTO(Long id, LocalDateTime dateTime, TaskDTO task, State newState) {
    super(id, dateTime, task);
    this.newState = newState;
  }

  public StateChangeDTO(StateChange stateChange) {
    super(stateChange.getId(), stateChange.getCreationTime(), stateChange.getTask());
    this.newState = stateChange.getNewState();
  }

  public State getNewState() {
    return newState;
  }

  public void setNewState(State state) {
    this.newState = state;
  }
}
