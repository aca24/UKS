package com.github.minigithub.mapper;


import com.github.minigithub.dto.LabelApplicationDTO;
import com.github.minigithub.dto.LabelDTO;
import com.github.minigithub.model.Label;
import com.github.minigithub.model.LabelApplication;

public class LabelMapper {

	
	public static LabelDTO toDto (Label entity) {
		
		return new LabelDTO(entity.getId(), entity.getName(), new LabelApplicationDTO(entity.getLabelApplication()));
	}
	
	public static Label toEntity (LabelDTO dto) {
		
		return new Label(dto.getId(), dto.getName(), new LabelApplication(dto.getLabelApplication()));
	}
	
}
