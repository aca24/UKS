package com.github.minigithub.controller;

import java.time.LocalDateTime;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(value = "/save")
    public ResponseEntity<EventDTO> saveEvent(@RequestBody EventDTO eventDTO) {  
        Event event = new Event();
        try {
            event = eventService.save(eventDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(EventMapper.toDto(event), HttpStatus.CREATED);
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable Long id, @RequestBody EventDTO eventDTO) {
        Event event;
        try {
            event = eventService.findOne(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (event == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            event = eventService.save(eventDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(EventMapper.toDto(event), HttpStatus.OK);
    }
}