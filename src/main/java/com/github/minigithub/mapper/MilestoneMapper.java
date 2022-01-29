package com.github.minigithub.mapper;

import com.github.minigithub.dto.MilestoneDTO;
import com.github.minigithub.model.Milestone;

public class MilestoneMapper {
	
	public static MilestoneDTO toDto (Milestone entity) {
		return new MilestoneDTO();
		// TO DO 
		// setuj DTO objekat
	}
	
	public static Milestone toEntity (MilestoneDTO dto) {
		return new Milestone();
		// TO DO
	}

}
