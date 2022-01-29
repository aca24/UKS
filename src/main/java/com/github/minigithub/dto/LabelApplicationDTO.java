package com.github.minigithub.dto;

import java.io.Serializable;
import java.util.*;

public class LabelApplicationDTO extends EventDTO implements Serializable {
    
    //public Collection<Label> labels;

    public LabelApplicationDTO() {
    }

    public LabelApplicationDTO(Long id, Date dateTime) {
        super(id, dateTime);
    }
}
