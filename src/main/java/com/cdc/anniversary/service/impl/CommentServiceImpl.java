package com.cdc.anniversary.service.impl;

import com.cdc.anniversary.mapper.CommentMapper;
import com.cdc.anniversary.model.Comment;
import com.cdc.anniversary.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> getComment(int id) {
        return commentMapper.getComment(id);
    }

    @Override
    public void addComment(Comment comment) {
        commentMapper.addComment(comment);

    }
}
