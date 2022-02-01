package com.github.minigithub.repository;

import java.util.Optional;

import com.github.minigithub.model.Branch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

    public Optional<Branch> findByName(String name);
}
