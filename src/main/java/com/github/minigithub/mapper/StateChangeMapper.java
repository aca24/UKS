package com.github.minigithub.mapper;

import com.github.minigithub.dto.StateChangeDTO;
import com.github.minigithub.model.StateChange;

public class StateChangeMapper {

    public static StateChangeDTO toDto(StateChange entity) {
        return new StateChangeDTO(entity);
    }

    public static StateChange toEntity(StateChangeDTO dto) {
        return new StateChange(dto);
    }

}
