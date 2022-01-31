package com.github.minigithub.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.github.minigithub.dto.CommitDTO;
import com.github.minigithub.model.Commit;
import com.github.minigithub.service.CommitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commit")
public class CommitController {

    @Autowired
    public CommitService commitService;

    @GetMapping
    public ResponseEntity<List<CommitDTO>> findAll() {
        return new ResponseEntity<>(
                commitService.findAll().stream().map((commit) -> new CommitDTO(commit)).collect(Collectors.toList()),
                HttpStatus.OK);
    }

    public ResponseEntity<CommitDTO> findById(Long id) {
        Optional<Commit> commit = commitService.findById(id);
        if (commit.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CommitDTO>(new CommitDTO(commit.get()), HttpStatus.OK);
    }

    public ResponseEntity<CommitDTO> findByHash(String hash) {
        Optional<Commit> commit = commitService.findByHash(hash);
        if (commit.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CommitDTO>(new CommitDTO(commit.get()), HttpStatus.OK);
    }

    public ResponseEntity<CommitDTO> insert(CommitDTO commitDTO) {
        Commit commit;
        try {
            commit = commitService.insert(commitDTO);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        if (commit == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<CommitDTO>(new CommitDTO(commit), HttpStatus.CREATED);
    }
}
