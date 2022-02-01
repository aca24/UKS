package com.github.minigithub.service;

import java.util.List;

import com.github.minigithub.dto.MilestoneDTO;
import com.github.minigithub.model.Milestone;

public interface MilestoneService {

	List<MilestoneDTO> findAll();

	MilestoneDTO findById(Long id);

	MilestoneDTO create(MilestoneDTO milestone);

	MilestoneDTO update(MilestoneDTO milestone);
	
	void delete(Long id);
}
