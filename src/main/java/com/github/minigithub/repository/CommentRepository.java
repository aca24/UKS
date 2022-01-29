package com.github.minigithub.repository;

import com.github.minigithub.model.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    Comment findOneById(Long id);
}