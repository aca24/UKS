package com.github.minigithub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.minigithub.repository.MilestoneRepository;

@Service
public class MilestoneService {

	@Autowired
	private MilestoneRepository milestoneRepository;
}
