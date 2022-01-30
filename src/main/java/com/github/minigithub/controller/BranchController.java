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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/{id}")
    public ResponseEntity<BranchDTO> findById(Long id) {
        Optional<Branch> branch = branchService.findById(id);
        if (branch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BranchDTO>(new BranchDTO(branch.get()), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<BranchDTO> findByHash(String name) {
        Optional<Branch> branch = branchService.findByName(name);
        if (branch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BranchDTO>(new BranchDTO(branch.get()), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<BranchDTO> update(Long id, @RequestBody BranchDTO branchDTO) {
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        if (!branchService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
