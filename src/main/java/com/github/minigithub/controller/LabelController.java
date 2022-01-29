package com.github.minigithub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.minigithub.service.LabelService;

@RestController
@RequestMapping(value = "/api/label", produces = MediaType.APPLICATION_JSON_VALUE)
public class LabelController {

	@Autowired
	private LabelService labelService;
}
