package com.github.minigithub.mapper;

import com.github.minigithub.dto.CommentDTO;
import com.github.minigithub.model.Comment;

public class CommentMapper {

    public static CommentDTO toDto(Comment entity) {
        return new CommentDTO(entity);
    }

    public static Comment toEntity(CommentDTO dto) {
        return new Comment(dto);
    }
}
