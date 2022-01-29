package com.github.minigithub.service;

import java.util.List;
import com.github.minigithub.model.LabelApplication;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LabelApplicationService {

    LabelApplication findOne(Long id);

    List<LabelApplication> findAll();

    Page<LabelApplication> findAll(Pageable page);

    LabelApplication save(LabelApplication labelApplication);

    void remove(Long id);
}