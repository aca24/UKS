package com.github.minigithub.controller;

import java.util.ArrayList;
import java.util.List;

import com.github.minigithub.dto.EventDTO;
import com.github.minigithub.model.Event;
import com.github.minigithub.mapper.EventMapper;
import com.github.minigithub.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/event", produces = MediaType.APPLICATION_JSON_VALUE)
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        List<Event> events = eventService.findAll();

        List<EventDTO> eventsDTO = new ArrayList<EventDTO>();
        for (Event event : events) {
            eventsDTO.add(EventMapper.toDto(event));
        }

        return new ResponseEntity<>(eventsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EventDTO> getEvent(@PathVariable Long id) {
        Event event;
        try {
            event = eventService.findOne(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (event == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(EventMapper.toDto(event), HttpStatus.OK);
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        Event event;
        try {
            event = eventService.findOne(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (event == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        eventService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}