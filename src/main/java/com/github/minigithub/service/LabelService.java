package com.github.minigithub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.minigithub.repository.LabelRepository;

@Service
public class LabelService {
	
	@Autowired
	private LabelRepository labelRepository;

}
