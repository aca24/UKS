package com.github.minigithub.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.github.minigithub.dto.LabelApplicationDTO;
import java.time.LocalDateTime;

@Entity
@Table(name = "labelApplications")
public class LabelApplication extends Event {

   public LabelApplication() {
   }

   public LabelApplication(Long id, LocalDateTime creationTime, Task task) {
      super(id, creationTime, task);
   }

   public LabelApplication(LabelApplicationDTO labelApplication) {
      super(labelApplication.getId(), labelApplication.getCreationTime(), new Task(labelApplication.getTask()));
   }
}