package com.github.minigithub.controller;

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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/labelApplication", produces = MediaType.APPLICATION_JSON_VALUE)
public class LabelApplicationController {

    private LabelApplicationService labelApplicationService;

    @Autowired
    public LabelApplicationController(LabelApplicationService labelApplicationService) {
        this.labelApplicationService = labelApplicationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<LabelApplicationDTO>> getAllLabelApplications() {
        List<LabelApplication> labelApplications = labelApplicationService.findAll();

        List<LabelApplicationDTO> labelApplicationsDTO = new ArrayList<LabelApplicationDTO>();
        for (LabelApplication labelApplication : labelApplications) {
            labelApplicationsDTO.add(LabelApplicationMapper.toDto(labelApplication));
        }

        return new ResponseEntity<>(labelApplicationsDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
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

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<LabelApplicationDTO> saveLabelApplication(
            @RequestBody LabelApplicationDTO labelApplicationDTO) {
        LabelApplication labelApplication = new LabelApplication();
        try {
            labelApplication = labelApplicationService.save(labelApplicationDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(LabelApplicationMapper.toDto(labelApplication), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<LabelApplicationDTO> updateLabelApplication(
            @RequestBody LabelApplicationDTO labelApplicationDTO) {
        LabelApplication labelApplication;
        try {
            labelApplication = labelApplicationService.findOne(labelApplicationDTO.getId());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (labelApplication == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            labelApplication = labelApplicationService.update(labelApplicationDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(LabelApplicationMapper.toDto(labelApplication), HttpStatus.OK);
    }
}