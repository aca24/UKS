package com.github.minigithub.service;

import java.util.List;


import com.github.minigithub.dto.LabelDTO;
import com.github.minigithub.model.Label;



public interface LabelService {
	

	List<LabelDTO> findAll();

	LabelDTO findById(Long id);

	LabelDTO create(LabelDTO label);

	LabelDTO update(LabelDTO label);
	
	void delete(Long id) ;
}
