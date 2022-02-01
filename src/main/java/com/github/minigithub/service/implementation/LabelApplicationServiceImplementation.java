package com.github.minigithub.service.implementation;

import java.util.*;
import com.github.minigithub.dto.LabelApplicationDTO;
import com.github.minigithub.model.Label;
import com.github.minigithub.model.LabelApplication;
import com.github.minigithub.repository.LabelApplicationRepository;
import com.github.minigithub.repository.LabelRepository;
import com.github.minigithub.repository.TaskRepository;
import com.github.minigithub.service.LabelApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LabelApplicationServiceImplementation implements LabelApplicationService {

    private LabelApplicationRepository labelApplicationRepository;
    private TaskRepository taskRepository;
    private LabelRepository labelRepository;

    @Autowired
    public LabelApplicationServiceImplementation(LabelApplicationRepository labelApplicationRepository,
            TaskRepository taskRepository, LabelRepository labelRepository) {
        this.labelApplicationRepository = labelApplicationRepository;
        this.taskRepository = taskRepository;
        this.labelRepository = labelRepository;
    }

    public LabelApplication findOne(Long id) {
        return labelApplicationRepository.findById(id).orElseGet(null);
    }

    public List<LabelApplication> findAll() {
        return labelApplicationRepository.findAll();
    }

    public Page<LabelApplication> findAll(Pageable page) {
        return labelApplicationRepository.findAll(page);
    }

    public LabelApplication save(LabelApplicationDTO labelApplicationDTO) {
        LabelApplication labelApplication = new LabelApplication();

        try {
            labelApplication.setCreationTime(labelApplicationDTO.getCreationTime());
            labelApplication.setTask(taskRepository.findOneById(labelApplicationDTO.getTask().getId()));

            labelApplication = labelApplicationRepository.save(labelApplication);
        } catch (Exception e) {
            return null;
        }

        return labelApplication;
    }

    public LabelApplication update(Long id, LabelApplicationDTO labelApplicationDTO) {
        LabelApplication labelApplication = new LabelApplication();

        try {
            List<Label> labelApplications = labelRepository.findAll();
            List<Label> foundLabelApplications = new ArrayList<Label>();
            for (Label label : labelApplications) {
                if (label.labelApplication != null) {
                    if (label.labelApplication.getId() == id) {
                        foundLabelApplications.add(label);
                        label.setLabelApplication(null);
                        labelRepository.save(label);
                    }
                }
            }

            labelApplicationRepository.deleteById(id);

            labelApplication.setCreationTime(labelApplicationDTO.getCreationTime());
            labelApplication.setTask(taskRepository.findOneById(labelApplicationDTO.getTask().getId()));

            labelApplication = labelApplicationRepository.save(labelApplication);

            for (Label label : foundLabelApplications) {
                label.setLabelApplication(labelApplication);
                labelRepository.save(label);
            }
        } catch (Exception e) {
            return null;
        }

        return labelApplication;
    }

    public void remove(Long id) {
        List<Label> labelApplications = labelRepository.findAll();
        for (Label label : labelApplications) {
            if (label.labelApplication != null) {
                if (label.labelApplication.getId() == id) {
                    label.setLabelApplication(null);
                    labelRepository.save(label);
                }
            }
        }

        labelApplicationRepository.deleteById(id);
    }
}