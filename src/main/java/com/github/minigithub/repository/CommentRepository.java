package com.github.minigithub.repository;

import com.github.minigithub.model.Comment;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    Comment findOneById(Long id);
}