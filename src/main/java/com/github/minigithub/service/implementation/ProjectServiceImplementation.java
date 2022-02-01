package com.github.minigithub.service.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.minigithub.dto.LabelDTO;
import com.github.minigithub.dto.MilestoneDTO;
import com.github.minigithub.dto.ProjectDTO;
import com.github.minigithub.dto.UserDTO;
import com.github.minigithub.mapper.ProjectMapper;
import com.github.minigithub.model.Label;
import com.github.minigithub.model.Milestone;
import com.github.minigithub.model.Project;
import com.github.minigithub.model.User;
import com.github.minigithub.repository.LabelRepository;
import com.github.minigithub.repository.MilestoneRepository;
import com.github.minigithub.repository.ProjectRepository;
import com.github.minigithub.service.ProjectService;

@Service
public class ProjectServiceImplementation implements ProjectService{
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private MilestoneRepository milestoneRepository;
	
	@Autowired
	private LabelRepository labelRepository;
	
	
	public List<ProjectDTO> findAll() {
		List<Project> entities = projectRepository.findAll();

		return toDtoList(entities);
	}

	private List<ProjectDTO> toDtoList(List<Project> list){
		List<ProjectDTO> retVal = new ArrayList<ProjectDTO> ();
		for(Project entity: list) {
			ProjectDTO dto = ProjectMapper.toDto(entity);
			retVal.add(dto);
		}
		
		return retVal;
		
	}

	public ProjectDTO findById(Long id) {
		Project entity = projectRepository.findOneById(id);
		if (entity == null)
			return null;
		
		return ProjectMapper.toDto(entity);
	}

	//TO DO 
	public ProjectDTO create(ProjectDTO project) {
		
		System.out.println("********** CREATE NEW PROJECT");
		Project newProject = new Project();
		newProject.setTitle(project.getTitle());
		User tempUser = new User(1L, "maca", "maca", "maca", "maca");
		newProject.setLeader(tempUser);
		
		Collection<Milestone> mlist = new ArrayList<Milestone>();
		Collection<User> userList = new ArrayList<User>();
		Collection<Label> labelList = new ArrayList<Label>();
		if(project.getMilestones() != null)
			for (MilestoneDTO dto: project.getMilestones()) {
				System.out.println(dto.getId() + " milestpone id");
				mlist.add(milestoneRepository.findById(dto.getId()).orElse(null));
				
			}
		if(project.getDevelopers() != null)
			for (UserDTO udto: project.getDevelopers()) {
				// userList.add(userRepository.findById(udto.getId()).orElse(null));
				userList.add(tempUser);
			}
		if(project.getLabesls() != null)
			for (LabelDTO ldto: project.getLabesls()) {
				labelList.add(labelRepository.findById(ldto.getId()).orElse(null));
			}
		
		newProject.setLabel(labelList);
		newProject.setDevelopers(userList);
		newProject.setMilestone(mlist);

		try {
			newProject = projectRepository.save(newProject);
		}
		catch(Exception e){
			return null;
		}
		
		return ProjectMapper.toDto(newProject);
	}

	public ProjectDTO update(ProjectDTO project) {
		Project existing = projectRepository.findById(project.getId()).orElse(null);
		if(existing != null) {
			//TO DO
			
			existing.setTitle(project.getTitle());
			//existing.setLeader(UserMapper.toEntity(project.getLeader()));
			User tempUser = new User(1L, "maca", "maca", "maca", "maca");
			existing.setLeader(tempUser);
			
			Collection<Milestone> mlist = new ArrayList<Milestone>();
			Collection<User> userList = new ArrayList<User>();
			Collection<Label> labelList = new ArrayList<Label>();
			if(project.getMilestones() != null)
				for (MilestoneDTO dto: project.getMilestones()) {
					Milestone m = milestoneRepository.findById(dto.getId()).orElse(null);
					System.out.println(m.getDescription());
					mlist.add(milestoneRepository.findById(dto.getId()).orElse(null));
				}
			if(project.getDevelopers() != null)
				for (UserDTO udto: project.getDevelopers()) {
					// userList.add(userRepository.findById(udto.getId()).orElse(null));
					userList.add(tempUser);
				}
			if(project.getLabesls() != null)
				for (LabelDTO ldto: project.getLabesls()) {
					labelList.add(labelRepository.findById(ldto.getId()).orElse(null));
				}
			
			existing.setLabel(labelList);
			existing.setDevelopers(userList);
			existing.setMilestone(mlist);

			
			try {
				existing = projectRepository.save(existing);
			}
			catch(Exception e){
				return null;
			}
			return ProjectMapper.toDto(existing);
		}
		return null;
	}
	
	public void delete(Long id) {
		Project existing = projectRepository.findById(id).orElse(null);
		if(existing != null) {
			projectRepository.delete(existing);
		}
	}

}
