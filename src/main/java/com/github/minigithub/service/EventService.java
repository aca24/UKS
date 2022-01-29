package com.github.minigithub.service;

import java.util.List;

import com.github.minigithub.model.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EventService {

    Event findOne(Long id);

    List<Event> findAll();

    Page<Event> findAll(Pageable page);

    Event save(Event event);

    void remove(Long id);
}
