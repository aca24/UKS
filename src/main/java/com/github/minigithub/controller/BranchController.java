package com.github.minigithub.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.github.minigithub.dto.BranchDTO;
import com.github.minigithub.model.Branch;
import com.github.minigithub.service.BranchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    public BranchService branchService;

    public ResponseEntity<List<BranchDTO>> findAll() {
        return new ResponseEntity<List<BranchDTO>>(
                branchService.findAll().stream().map((branch) -> new BranchDTO(branch)).collect(Collectors.toList()),
                HttpStatus.OK);
    }

    public ResponseEntity<BranchDTO> findById(Long id) {
        Optional<Branch> branch = branchService.findById(id);
        if (branch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BranchDTO>(new BranchDTO(branch.get()), HttpStatus.OK);
    }

    public ResponseEntity<BranchDTO> findByHash(String name) {
        Optional<Branch> branch = branchService.findByName(name);
        if (branch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BranchDTO>(new BranchDTO(branch.get()), HttpStatus.OK);
    }

    public ResponseEntity<BranchDTO> update(Long id, BranchDTO branchDTO) {
        BranchDTO response;
        try {
            response = branchService.update(id, branchDTO);

        } catch (Exception x) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        if (response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BranchDTO>(response, HttpStatus.OK);
    }
}
