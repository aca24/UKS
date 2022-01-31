package com.github.minigithub.mapper;

import com.github.minigithub.dto.IssueDTO;
import com.github.minigithub.model.Issue;
import com.github.minigithub.model.User;

public class IssueMapper implements MapperInterface<Issue, IssueDTO> {
	
	

	

	@Override
	public Issue toEntity(IssueDTO dto) {
		
		
		Issue issue = new Issue();
		issue.setTitle(dto.getTitle());
		issue.setDescription(dto.getDescription());
		issue.setDateCreated(dto.getDateCreated());
		issue.setId(dto.getId());
		//privremeno zakucan
		User creator = new User();
		creator.setId(1L);
		issue.setCreator(creator);
		//------
		//pReq.setCreator(userMapper.toEntity(dto.getCreator()));
		return issue;
	}

	@Override
	public IssueDTO toDto(Issue entity) {
		IssueDTO issue = new IssueDTO(entity.getTitle(), entity.getDescription(), entity.getDateCreated());
		issue.setId(entity.getId());
		return issue;
	
	}

}
