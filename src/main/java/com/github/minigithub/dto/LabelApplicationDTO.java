package com.github.minigithub.dto;

import java.time.LocalDateTime;
import com.github.minigithub.model.LabelApplication;

public class LabelApplicationDTO extends EventDTO {

    public LabelApplicationDTO() {
    }

    public LabelApplicationDTO(Long id, LocalDateTime creationTime, TaskDTO task) {
        super(id, creationTime, task);
    }

    public LabelApplicationDTO(LabelApplication labelApplication) {
        super(labelApplication.getId(), labelApplication.getCreationTime(), labelApplication.getTask());
    }
}
