package com.github.minigithub.dto;

import com.github.minigithub.model.Branch;

import lombok.Data;

@Data
public class BranchDTO {

    private Long id;
    private String name;
    
    public BranchDTO() {
        
    }

    public BranchDTO(Branch branch) {
        this.id = branch.getId();
        this.name = branch.getName();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
}
