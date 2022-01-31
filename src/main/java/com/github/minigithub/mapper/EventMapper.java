package com.github.minigithub.mapper;

import com.github.minigithub.dto.EventDTO;
import com.github.minigithub.model.Event;

public class EventMapper {

	public static EventDTO toDto(Event entity) {
		return new EventDTO(entity);
	}

	public static Event toEntity(EventDTO dto) {
		return new Event(dto);
	}
}