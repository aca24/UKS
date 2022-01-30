package com.github.minigithub.repository;

import com.github.minigithub.model.StateChange;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateChangeRepository extends JpaRepository<StateChange, Long> {

    StateChange findOneById(Long id);

}
