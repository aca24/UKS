package com.github.minigithub.repository;

import com.github.minigithub.model.Event;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {

    Event findOneById(Long id);
}