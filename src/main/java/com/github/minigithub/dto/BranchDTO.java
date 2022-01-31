package com.github.minigithub.dto;

import com.github.minigithub.model.Branch;

import lombok.Data;

@Data
public class BranchDTO {

    private Long id;
    private String name;

    public BranchDTO(Branch branch) {
        this.id = branch.getId();
        this.name = branch.getName();
    }

    public String getName(){
        return name;
    }
}