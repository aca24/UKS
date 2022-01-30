package com.github.minigithub.mapper;

import com.github.minigithub.dto.TaskDTO;
import com.github.minigithub.model.Task;

public class TaskMapper {
    public static TaskDTO toDto(Task entity) {
        return new TaskDTO(entity);
    }

    public static Task toEntity(TaskDTO dto) {
        return new Task(dto);
    }
}
