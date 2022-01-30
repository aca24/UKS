package com.github.minigithub.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.github.minigithub.dto.LabelApplicationDTO;
import com.github.minigithub.model.LabelApplication;
import com.github.minigithub.mapper.LabelApplicationMapper;
import com.github.minigithub.service.LabelApplicationService;

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
@RequestMapping(value = "/api/labelApplication", produces = MediaType.APPLICATION_JSON_VALUE)
public class LabelApplicationController {

    private LabelApplicationService labelApplicationService;

    @Autowired
    public LabelApplicationController(LabelApplicationService labelApplicationService) {
        this.labelApplicationService = labelApplicationService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<LabelApplicationDTO>> getAllLabelApplications() {
        List<LabelApplication> labelApplications = labelApplicationService.findAll();

        List<LabelApplicationDTO> labelApplicationsDTO = new ArrayList<LabelApplicationDTO>();
        for (LabelApplication labelApplication : labelApplications) {
            labelApplicationsDTO.add(LabelApplicationMapper.toDto(labelApplication));
        }

        return new ResponseEntity<>(labelApplicationsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LabelApplicationDTO> getLabelApplication(@PathVariable Long id) {
        LabelApplication labelApplication;
        try {
            labelApplication = labelApplicationService.findOne(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (labelApplication == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(LabelApplicationMapper.toDto(labelApplication), HttpStatus.OK);
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Void> deleteLabelApplication(@PathVariable Long id) {
        LabelApplication labelApplication;
        try {
            labelApplication = labelApplicationService.findOne(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (labelApplication == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        labelApplicationService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<LabelApplicationDTO> saveLabelApplication(@RequestBody LabelApplicationDTO labelApplicationDTO) {
        LabelApplication labelApplication = new LabelApplication();
        try {
            labelApplication = labelApplicationService.save(labelApplicationDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(LabelApplicationMapper.toDto(labelApplication), HttpStatus.CREATED);
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<LabelApplicationDTO> updateLabelApplication(@PathVariable Long id, @RequestBody LabelApplicationDTO labelApplicationDTO) {
        LabelApplication labelApplication;
        try {
            labelApplication = labelApplicationService.findOne(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (labelApplication == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            labelApplication = labelApplicationService.save(labelApplicationDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(LabelApplicationMapper.toDto(labelApplication), HttpStatus.OK);
    }
}