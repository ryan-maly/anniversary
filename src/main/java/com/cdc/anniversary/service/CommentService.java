package com.cdc.anniversary.service;

import com.cdc.anniversary.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getComment();
    void addComment(Comment comment);
}
