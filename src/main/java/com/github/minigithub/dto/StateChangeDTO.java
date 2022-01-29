package com.github.minigithub.dto;

import com.github.minigithub.model.State;

public class StateChangeDTO {
    private Long id;
    private State newState;

    public StateChangeDTO(){

    }

    public Long getId() {
		return id;
	}

    public void setId(Long id) {
		this.id = id;
	}

    public State getNewState() {
		return newState;
    }

	public void setNewState(State state) {
		this.newState = state;
	}
}
