package com.github.minigithub.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.minigithub.dto.MilestoneDTO;
import com.github.minigithub.dto.TaskDTO;
import com.github.minigithub.mapper.MilestoneMapper;
import com.github.minigithub.model.Milestone;
import com.github.minigithub.model.Task;
import com.github.minigithub.repository.MilestoneRepository;
import com.github.minigithub.repository.TaskRepository;

@Service
public class MilestoneService {

	@Autowired
	private MilestoneRepository milestoneRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	
	public List<MilestoneDTO> findAll() {
		List<Milestone> entities = milestoneRepository.findAll();

		return toDtoList(entities);
	}

	private List<MilestoneDTO> toDtoList(List<Milestone> list){
		List<MilestoneDTO> retVal = new ArrayList<MilestoneDTO> ();
		for(Milestone entity: list) {
			MilestoneDTO dto = MilestoneMapper.toDto(entity);
			retVal.add(dto);
		}
		
		return retVal;
		
	}

	public MilestoneDTO findById(Long id) {
		Milestone entity = milestoneRepository.findOneById(id);
		if (entity == null)
			return null;
		
		return MilestoneMapper.toDto(entity);
	}

	public MilestoneDTO create(MilestoneDTO milestone) {
		
		Milestone newMilestone = new Milestone();
		newMilestone.setDescription(milestone.getDescription());
		newMilestone.setDueDate(milestone.getDueDate());
		newMilestone.setTitle(milestone.getTitle());
		newMilestone.setState(milestone.getState());
		
		Collection<Task> tasks = new ArrayList<Task>();
		for(TaskDTO dto: milestone.getTasks()) {
			tasks.add(taskRepository.findById(dto.getId()).orElse(null));
		}
		newMilestone.setTasks(tasks);

		try {
			newMilestone = milestoneRepository.save(newMilestone);
		}
		catch(Exception e){
			return null;
		}
		
		return MilestoneMapper.toDto(newMilestone);
	}

	public MilestoneDTO update(MilestoneDTO milestone) {
		Milestone existing = milestoneRepository.findById(milestone.getId()).orElse(null);
		if(existing != null) {
			existing.setDescription(milestone.getDescription());
			existing.setDueDate(milestone.getDueDate());
			existing.setTitle(milestone.getTitle());
			existing.setState(milestone.getState());
			
			Collection<Task> tasks = new ArrayList<Task>();
			for(TaskDTO dto: milestone.getTasks()) {
				tasks.add(taskRepository.findById(dto.getId()).orElse(null));
			}
			existing.setTasks(tasks);

			try {
				existing = milestoneRepository.save(existing);
				
				return MilestoneMapper.toDto(existing);
			}
			catch(Exception e){
				
				return null;
			}
		}
			
		return null;
	}
	
	public void delete(Long id) {
		Milestone existing = milestoneRepository.findById(id).orElse(null);
		if(existing != null) {
			milestoneRepository.delete(existing);
		}
	}
}
