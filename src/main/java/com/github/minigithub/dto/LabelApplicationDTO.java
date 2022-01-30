package com.github.minigithub.dto;

import java.time.LocalDateTime;
import java.util.*;

import com.github.minigithub.model.Label;
import com.github.minigithub.model.LabelApplication;

public class LabelApplicationDTO extends EventDTO {

    public Collection<LabelDTO> labels;

    public LabelApplicationDTO() {
    }

    public LabelApplicationDTO(Long id, LocalDateTime creationTime, TaskDTO task) {
        super(id, creationTime, task);
    }

    public LabelApplicationDTO(Collection<LabelDTO> labels) {
        this.labels = labels;
    }

    public LabelApplicationDTO(Long id, LocalDateTime creationTime, TaskDTO task, Collection<LabelDTO> labels) {
        super(id, creationTime, task);
        this.labels = labels;
    }

    public LabelApplicationDTO(LabelApplication labelApplication) {
        super(labelApplication.getId(), labelApplication.getCreationTime(), labelApplication.getTask());

        Collection<LabelDTO> labels = new ArrayList<LabelDTO>();
        for (Label label : labelApplication.getLabel()) {
            labels.add(new LabelDTO(label));
        }
        this.labels = labels;
    }

    public Collection<LabelDTO> getLabels() {
        return labels;
    }

    public void setLabels(Collection<LabelDTO> labels) {
        this.labels = labels;
    }
}
