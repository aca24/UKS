package com.github.minigithub.service.implementation;

import java.time.LocalDateTime;
import java.util.List;

import com.github.minigithub.dto.CommentDTO;
import com.github.minigithub.model.Comment;
import com.github.minigithub.repository.CommentRepository;
import com.github.minigithub.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImplementation implements CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImplementation(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment findOne(Long id) {
        return commentRepository.findById(id).orElseGet(null);
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public Page<Comment> findAll(Pageable page) {
        return commentRepository.findAll(page);
    }

    public Comment save(CommentDTO commentDTO) {
        Comment comment = new Comment();

        try {
            comment.setContent(commentDTO.getContent());
            comment.setCreationTime(LocalDateTime.now());
            // comment.setTask();
            comment = commentRepository.save(comment);
        } catch (Exception e) {
            return null;
        }

        return comment;
    }

    public void remove(Long id) {
        commentRepository.deleteById(id);
    }
}