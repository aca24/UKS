package com.github.minigithub.mapper;

import java.util.ArrayList;

import com.github.minigithub.dto.LabelApplicationDTO;
import com.github.minigithub.dto.LabelDTO;
import com.github.minigithub.model.Label;

public class LabelMapper {

	
	public static LabelDTO toDto (Label entity) {
		return new LabelDTO(entity.getId(), entity.getName(), new LabelApplicationDTO());
		// TO DO 
		// setuj DTO objekat
	}
	
	public static Label toEntity (LabelDTO dto) {
		return new Label();
		// TO DO
	}
	
}
