package com.github.minigithub.repository;

import com.github.minigithub.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    Event findOneById(Long id);
}