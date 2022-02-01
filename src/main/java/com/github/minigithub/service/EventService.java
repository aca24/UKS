package com.github.minigithub.service;

import java.util.List;
import com.github.minigithub.dto.EventDTO;
import com.github.minigithub.model.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EventService {

    Event findOne(Long id);

    List<Event> findAll();

    Page<Event> findAll(Pageable page);

    Event save(EventDTO event);

    Event update(Long id, EventDTO event);

    void remove(Long id);
}
