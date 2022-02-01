package com.github.minigithub.mapper;

import com.github.minigithub.dto.BranchDTO;
import com.github.minigithub.model.Branch;

public class BranchMapper implements MapperInterface<Branch, BranchDTO> {

	@Override
	public Branch toEntity(BranchDTO dto) {
		Branch b = new Branch();
		b.setId(dto.getId());
		b.setName(dto.getName());
		
		return  b;
	}

	@Override
	public BranchDTO toDto(Branch entity) {
		BranchDTO b = new BranchDTO();
		b.setId(entity.getId());
		b.setName(entity.getName());
		
		return  b;
	}

}
