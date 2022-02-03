package com.github.minigithub.controller;

import java.util.*;
import com.github.minigithub.dto.CommentDTO;
import com.github.minigithub.model.Comment;
import com.github.minigithub.mapper.CommentMapper;
import com.github.minigithub.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/comment", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CommentDTO>> getAllComments() {
        List<Comment> comments = commentService.findAll();

        List<CommentDTO> commentsDTO = new ArrayList<CommentDTO>();
        for (Comment comment : comments) {
            commentsDTO.add(CommentMapper.toDto(comment));
        }

        return new ResponseEntity<>(commentsDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
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

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CommentDTO> saveComment(@RequestBody CommentDTO commentDTO) {
        Comment comment = new Comment();
        try {
            comment = commentService.save(commentDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(CommentMapper.toDto(comment), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<CommentDTO> updateComment(@RequestBody CommentDTO commentDTO) {
        Comment comment;
        try {
            comment = commentService.findOne(commentDTO.getId());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (comment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            comment = commentService.update(commentDTO.getId(), commentDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(CommentMapper.toDto(comment), HttpStatus.OK);
    }
}