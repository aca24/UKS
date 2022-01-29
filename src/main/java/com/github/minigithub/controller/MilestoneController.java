package com.github.minigithub.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.minigithub.service.MilestoneService;

@RestController
@RequestMapping(value = "/api/milestone", produces = MediaType.APPLICATION_JSON_VALUE)
public class MilestoneController {

	@Autowired
	private MilestoneService milestoneService;
}
