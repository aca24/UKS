package com.github.minigithub.mapper;

import java.util.ArrayList;
import java.util.Collection;

import com.github.minigithub.dto.LabelDTO;
import com.github.minigithub.dto.MilestoneDTO;
import com.github.minigithub.dto.ProjectDTO;
import com.github.minigithub.dto.UserDTO;
import com.github.minigithub.model.Label;
import com.github.minigithub.model.Milestone;
import com.github.minigithub.model.Project;
import com.github.minigithub.model.User;

public class ProjectMapper {

	
	public static ProjectDTO toDto (Project entity) {
		ProjectDTO dto = new ProjectDTO();
		// TO DO 
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		//dto.setLeader(UserMapper.toEntity(entity.getLeader()));
		dto.setLeader(new UserDTO());
		
		Collection<MilestoneDTO> mlist = new ArrayList<MilestoneDTO>();
		Collection<UserDTO> userList = new ArrayList<UserDTO>();
		Collection<LabelDTO> labelList = new ArrayList<LabelDTO>();
		if(entity.getMilestones()!= null)
			for (Milestone mentity: entity.getMilestones()) {
				mlist.add(MilestoneMapper.toDto(mentity));
			}
		if(entity.getDevelopers()!= null)
			for (User uentity: entity.getDevelopers()) {
				// userList.add(UserMapper.toDto(uentity);
				userList.add(new UserDTO());
			}
		if(entity.getLabels()!= null)
			for (Label lentity: entity.getLabels()) {
				labelList.add(LabelMapper.toDto(lentity));
			}
		
		dto.setLabesls(labelList);
		dto.setDevelopers(userList);
		dto.setMilestones(mlist);
		
		return dto;
	}
	
	public static Project toEntity (ProjectDTO dto) {
		Project entity = new Project();
		// TO DO
		
		entity.setId(entity.getId());
		entity.setTitle(entity.getTitle());
		//dto.setLeader(UserMapper.toEntity(entity.getLeader()));
		User tempUser = new User();
		tempUser.setId(1L);
		entity.setLeader(tempUser);
		
		Collection<Milestone> mlist = new ArrayList<Milestone>();
		Collection<User> userList = new ArrayList<User>();
		Collection<Label> labelList = new ArrayList<Label>();
		if(dto.getMilestones()!= null)
			for (MilestoneDTO mdto: dto.getMilestones()) {
				mlist.add(MilestoneMapper.toEntity(mdto));
			}
		
		if(dto.getDevelopers()!= null)
			for (UserDTO udto: dto.getDevelopers()) {
				// userList.add(UserMapper.toEntity(udto);
				userList.add(new User());
			}
		if(dto.getLabesls()!= null)
			for (LabelDTO ldto: dto.getLabesls()) {
				labelList.add(LabelMapper.toEntity(ldto));
			}
		
		entity.setLabels(labelList);
		entity.setDevelopers(userList);
		entity.setMilestones(mlist);
		
		return entity;
	}
}
