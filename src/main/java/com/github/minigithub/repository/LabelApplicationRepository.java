package com.github.minigithub.repository;

import com.github.minigithub.model.LabelApplication;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LabelApplicationRepository extends JpaRepository<LabelApplication,Long> {
    LabelApplication findOneById(Long id);
}