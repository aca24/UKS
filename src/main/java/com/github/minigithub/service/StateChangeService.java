package com.github.minigithub.service;

import java.util.List;

import com.github.minigithub.dto.StateChangeDTO;
import com.github.minigithub.model.StateChange;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StateChangeService {

    StateChange findOne(Long id);

    List<StateChange> findAll();

    Page<StateChange> findAll(Pageable page);

    StateChange save(StateChangeDTO stateChange);

    StateChange update(StateChangeDTO stateChange) throws Exception;

    void remove(Long id);
}
