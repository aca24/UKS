package com.github.minigithub.mapper;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.minigithub.dto.IssueDTO;
import com.github.minigithub.dto.PullRequestDTO;
import com.github.minigithub.model.Issue;
import com.github.minigithub.model.PullRequest;
import com.github.minigithub.model.User;

public class PullRequestMapper implements MapperInterface<PullRequest, PullRequestDTO> {
	
	BranchMapper branchMapper = new BranchMapper();
	
	@Autowired
	IssueMapper issuesMapper;
	
	
	

	public PullRequestMapper() {
		issuesMapper = new IssueMapper();
	}

	@Override
	public PullRequest toEntity(PullRequestDTO dto) {
		
		ArrayList<Issue> issues = new ArrayList<>();
		for (IssueDTO issueDTO : dto.getIssues()) {
			issues.add(issuesMapper.toEntity(issueDTO));
		}
		
		PullRequest pReq = new PullRequest(dto.getName(), issues, branchMapper.toEntity(dto.getBranch()));
		//privremeno zakucan
		User creator = new User();
		creator.setId(1L);
		pReq.setCreator(creator);
		//------
		//pReq.setCreator(userMapper.toEntity(dto.getCreator()));
		return pReq;
	}

	@Override
	public PullRequestDTO toDto(PullRequest entity) {

		ArrayList<IssueDTO> issuesDTO = new ArrayList<>();
		for (Issue issue : entity.getIssue()) {
			issuesDTO.add(issuesMapper.toDto(issue));
		}
		
		return new PullRequestDTO(entity.getId(),entity.getName(), branchMapper.toDto(entity.getBranch()), issuesDTO);
	}

}
