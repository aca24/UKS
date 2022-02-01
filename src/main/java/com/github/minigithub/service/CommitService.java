package com.github.minigithub.service;

import java.util.List;
import java.util.Optional;

import com.github.minigithub.dto.CommitDTO;
import com.github.minigithub.model.Branch;
import com.github.minigithub.model.Commit;
import com.github.minigithub.model.User;
import com.github.minigithub.repository.CommitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommitService {

    @Autowired
    public CommitRepository commitRepository;

    @Autowired
    public UserService userService;

    @Autowired
    public BranchService branchService;

    public List<Commit> findAll() {
        return commitRepository.findAll();
    }

    public Optional<Commit> findById(Long id) {
        return commitRepository.findById(id);
    }

    public Optional<Commit> findByHash(String hash) {
        return commitRepository.findByHash(hash);
    }

    public Commit insert(CommitDTO commitDTO) throws Exception {
        Commit commit = new Commit(commitDTO);

        if (findByHash(commitDTO.getHash()).isPresent()) {
            throw new Exception();
        }

        Optional<User> userOrEmpty = userService.findById(commitDTO.getCommiterId());

        if (userOrEmpty.isEmpty()) {
            return null;
        }

        commit.setCommiter(userOrEmpty.get());

        Optional<Branch> branchOrEmpty = branchService.findById(commitDTO.getBranchId());

        if (branchOrEmpty.isEmpty()) {
            return null;
        }

        commit.setBranch(branchOrEmpty.get());

        commitRepository.save(commit);

        commitDTO.setId(commit.getId());

        return commit;
    }
}
