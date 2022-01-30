package com.github.minigithub.controller;

import java.util.*;

import java.time.LocalDateTime;

import com.github.minigithub.dto.CommentDTO;
import com.github.minigithub.model.Comment;
import com.github.minigithub.mapper.CommentMapper;
import com.github.minigithub.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/comment", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<CommentDTO>> getAllComments() {
        List<Comment> comments = commentService.findAll();

        List<CommentDTO> commentsDTO = new ArrayList<CommentDTO>();
        for (Comment comment : comments) {
            commentsDTO.add(CommentMapper.toDto(comment));
        }

        return new ResponseEntity<>(commentsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CommentDTO> getComment(@PathVariable Long id) {
        Comment comment;
        try {
            comment = commentService.findOne(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (comment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(CommentMapper.toDto(comment), HttpStatus.OK);
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        Comment comment;
        try {
            comment = commentService.findOne(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (comment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        commentService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<CommentDTO> saveComment(@RequestBody CommentDTO commentDTO) {
        Comment comment = new Comment();
        try {
            comment = commentService.save(commentDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(CommentMapper.toDto(comment), HttpStatus.CREATED);
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Long id, @RequestBody CommentDTO commentDTO) {
        Comment comment;
        try {
            comment = commentService.findOne(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (comment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            comment = commentService.save(commentDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(CommentMapper.toDto(comment), HttpStatus.OK);
    }
}