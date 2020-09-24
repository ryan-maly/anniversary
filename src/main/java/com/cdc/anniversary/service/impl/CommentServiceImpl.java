package com.cdc.anniversary.service.impl;

import com.cdc.anniversary.mapper.CommentMapper;
import com.cdc.anniversary.mapper.ShareMapper;
import com.cdc.anniversary.model.Comment;
import com.cdc.anniversary.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    ShareMapper shareMapper;

    @Override
    public List<Comment> getComment() {
        return commentMapper.getComment();
    }

    @Override
    public void addComment(Comment comment) {
        commentMapper.addComment(comment);
        int commentNum = shareMapper.getCommentNum(comment.getShare_id()) + 1;
        shareMapper.updateCommentNum(comment.getShare_id(), commentNum);
    }
}
