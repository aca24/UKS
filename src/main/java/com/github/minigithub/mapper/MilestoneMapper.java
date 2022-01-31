package com.github.minigithub.mapper;

import java.util.ArrayList;
import java.util.Collection;

import com.github.minigithub.dto.MilestoneDTO;
import com.github.minigithub.dto.TaskDTO;
import com.github.minigithub.model.Milestone;
import com.github.minigithub.model.Task;

public class MilestoneMapper {
	
	public static MilestoneDTO toDto (Milestone entity) {
		MilestoneDTO dto = new MilestoneDTO();
		dto.setId(entity.getId());
		dto.setDescription(entity.getDescription());
		dto.setDueDate(entity.getDueDate());
		dto.setTitle(entity.getTitle());
		dto.setState(entity.getState());
		
		Collection<TaskDTO> tasks = new ArrayList<TaskDTO>();
		for(Task tentity: entity.getTasks()) {
			tasks.add(TaskMapper.toDto(tentity));
		}
		dto.setTasks(tasks);
		return dto;
	}
	
	public static Milestone toEntity (MilestoneDTO dto) {
		Milestone entity = new Milestone();
		entity.setId(dto.getId());
		entity.setDescription(dto.getDescription());
		entity.setDueDate(dto.getDueDate());
		entity.setTitle(dto.getTitle());
		entity.setState(dto.getState());
		
		Collection<Task> tasks = new ArrayList<Task>();
		for(TaskDTO tdto: dto.getTasks()) {
			tasks.add(TaskMapper.toEntity(tdto));
		}
		entity.setTasks(tasks);
		return entity;
	}

}
