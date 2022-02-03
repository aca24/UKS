package com.github.minigithub.service;

import java.util.List;
import com.github.minigithub.dto.CommentDTO;
import com.github.minigithub.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {

    Comment findOne(Long id);

    List<Comment> findAll();

    Page<Comment> findAll(Pageable page);

    Comment save(CommentDTO comment);

    Comment update(CommentDTO comment);

    void remove(Long id);
}