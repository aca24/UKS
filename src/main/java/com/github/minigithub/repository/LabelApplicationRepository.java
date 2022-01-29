package com.github.minigithub.repository;

import com.github.minigithub.model.LabelApplication;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelApplicationRepository extends JpaRepository<LabelApplication,Long> {

    LabelApplication findOneById(Long id);
}