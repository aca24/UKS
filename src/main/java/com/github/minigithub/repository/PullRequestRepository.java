package com.github.minigithub.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.github.minigithub.model.PullRequest;

@Repository
public interface PullRequestRepository  extends JpaRepository<PullRequest, Long> {

	
}
