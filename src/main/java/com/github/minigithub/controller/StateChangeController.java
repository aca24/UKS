package com.github.minigithub.controller;

import com.github.minigithub.service.StateChangeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/stateChange", produces = MediaType.APPLICATION_JSON_VALUE)
public class StateChangeController {

    @Autowired
	private StateChangeService stateChangeService;
}
