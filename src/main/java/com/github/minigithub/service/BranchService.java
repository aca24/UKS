package com.github.minigithub.service;

import java.util.List;
import java.util.Optional;

import com.github.minigithub.dto.BranchDTO;
import com.github.minigithub.model.Branch;
import com.github.minigithub.repository.BranchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService {

    @Autowired
    public BranchRepository branchRepository;

    public List<Branch> findAll() {
        return branchRepository.findAll();
    }

    public Optional<Branch> findById(Long id) {
        return branchRepository.findById(id);
    }

    public Optional<Branch> findByName(String name) {
        return branchRepository.findByName(name);
    }

    public BranchDTO update(Long id, BranchDTO branchDTO) throws Exception {
        Optional<Branch> branchOrEmpty = findById(id);

        if (branchOrEmpty.isEmpty()) {
            return null;
        }

        if (findByName(branchDTO.getName()).isPresent()) {
            throw new Exception();
        }

        branchOrEmpty.get().setName(branchDTO.getName());

        branchRepository.save(branchOrEmpty.get());

        return branchDTO;
    }

    public boolean delete(Long id) {
        Optional<Branch> branchOrEmpty = findById(id);

        if (branchOrEmpty.isEmpty()) {
            return false;
        }

        branchRepository.delete(branchOrEmpty.get());

        return true;
    }
}
