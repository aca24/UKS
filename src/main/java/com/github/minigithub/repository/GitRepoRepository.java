package com.github.minigithub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.minigithub.model.GitRepo;

@Repository
public interface GitRepoRepository extends JpaRepository<GitRepo, Long> {

}
