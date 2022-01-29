package com.github.minigithub.service.implementation;

import java.util.List;

import com.github.minigithub.model.StateChange;
import com.github.minigithub.repository.StateChangeRepository;
import com.github.minigithub.service.StateChangeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StateChangeServiceImplementation implements StateChangeService {

    private StateChangeRepository stateChangeRepository;

    @Autowired
    public StateChangeServiceImplementation(StateChangeRepository stateChangeRepository) {
        this.stateChangeRepository = stateChangeRepository;
    }

    @Override
    public StateChange findOne(Long id) {
        return stateChangeRepository.findById(id).orElseGet(null);
    }

    @Override
    public List<StateChange> findAll() {
        return stateChangeRepository.findAll();
    }

    @Override
    public Page<StateChange> findAll(Pageable page) {
        return stateChangeRepository.findAll(page);
    }

    @Override
    public StateChange save(StateChange stateChange) {
        return stateChangeRepository.save(stateChange);
    }

    @Override
    public void remove(Long id) {
        stateChangeRepository.deleteById(id);
    }
}
