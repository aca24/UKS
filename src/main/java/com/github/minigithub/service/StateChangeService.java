package com.github.minigithub.service;

import com.github.minigithub.repository.StateChangeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateChangeService {

    @Autowired
	private StateChangeRepository stateChangeRepository;
}
