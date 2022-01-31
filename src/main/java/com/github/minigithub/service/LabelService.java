package com.github.minigithub.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.minigithub.dto.LabelDTO;
import com.github.minigithub.mapper.LabelMapper;
import com.github.minigithub.model.Label;
import com.github.minigithub.repository.LabelApplicationRepository;
import com.github.minigithub.repository.LabelRepository;

@Service
public class LabelService {
	
	@Autowired
	private LabelRepository labelRepository;
	
	@Autowired
	private LabelApplicationRepository labelApplicationRepository;

	public List<LabelDTO> findAll() {
		List<Label> entities = labelRepository.findAll();

		return toDtoList(entities);
	}

	private List<LabelDTO> toDtoList(List<Label> list){
		List<LabelDTO> retVal = new ArrayList<LabelDTO> ();
		for(Label entity: list) {
			LabelDTO dto = LabelMapper.toDto(entity);
			retVal.add(dto);
		}
		
		return retVal;
		
	}

	public LabelDTO findById(Long id) {
		Label entity = labelRepository.findOneById(id);
		if (entity == null)
			return null;
		
		return LabelMapper.toDto(entity);
	}

	public LabelDTO create(LabelDTO label) {
		Label newLabel = new Label();
		newLabel.setName(label.getName());
		newLabel.setLabelApplication(labelApplicationRepository.findById(label.getLabelApplication().getId()).orElse(null));
		
		try {
			newLabel = labelRepository.save(newLabel);
		}
		catch(Exception e){
			return null;
		}
		
		return LabelMapper.toDto(newLabel);
	}

	public LabelDTO update(LabelDTO label) {
		Label existing = labelRepository.findById(label.getId()).orElse(null);
		if(existing != null) {
			// dobavi labelApplication iz baze
			existing.setLabelApplication(labelApplicationRepository.findById(label.getLabelApplication().getId()).orElse(null));
			existing.setName(label.getName());
			try {
				existing = labelRepository.save(existing);
			}
			catch(Exception e){
				return null;
			}
			return LabelMapper.toDto(existing);
		}
		return null;
	}
	
	public void delete(Long id) {
		Label existing = labelRepository.findById(id).orElse(null);
		if(existing != null) {
			labelRepository.delete(existing);
		}
	}
}
