package com.github.minigithub.mapper;

import com.github.minigithub.dto.LabelApplicationDTO;
import com.github.minigithub.model.LabelApplication;

public class LabelApplicationMapper {

    public static LabelApplicationDTO toDto(LabelApplication entity) {
        return new LabelApplicationDTO(entity);
    }

    public static LabelApplication toEntity(LabelApplicationDTO dto) {
        return new LabelApplication(dto);
    }
}
