package com.github.minigithub.controller;

import java.util.*;

import com.github.minigithub.dto.StateChangeDTO;
import com.github.minigithub.mapper.StateChangeMapper;
import com.github.minigithub.model.StateChange;
import com.github.minigithub.service.StateChangeService;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/stateChange", produces = MediaType.APPLICATION_JSON_VALUE)
public class StateChangeController {

    private StateChangeService stateChangeService;

    @Autowired
    public StateChangeController(StateChangeService stateChangeService) {
        this.stateChangeService = stateChangeService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<StateChangeDTO>> getAllStateChanges() {
        List<StateChange> stateChanges = stateChangeService.findAll();

        List<StateChangeDTO> stateChangesDTO = new ArrayList<StateChangeDTO>();
        for (StateChange stateChange : stateChanges) {
            stateChangesDTO.add(StateChangeMapper.toDto(stateChange));
        }

        return new ResponseEntity<>(stateChangesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StateChangeDTO> getStateChange(@PathVariable Long id) {
        StateChange stateChange;
        try {
            stateChange = stateChangeService.findOne(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (stateChange == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(StateChangeMapper.toDto(stateChange), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<StateChangeDTO> saveStateChange(@RequestBody StateChangeDTO stateChangeDTO) {
        StateChange stateChange = new StateChange();
        try {
            stateChange = stateChangeService.save(stateChangeDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(StateChangeMapper.toDto(stateChange), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<StateChangeDTO> updateStateChange(@PathVariable Long id,
            @RequestBody StateChangeDTO stateChangeDTO) {
        StateChange stateChange;
        try {
            stateChange = stateChangeService.findOne(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (stateChange == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            stateChange = stateChangeService.update(stateChangeDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(StateChangeMapper.toDto(stateChange), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteStateChange(@PathVariable Long id) {
        StateChange stateChange;
        try {
            stateChange = stateChangeService.findOne(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (stateChange == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        stateChangeService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
