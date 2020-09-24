package com.cdc.anniversary.mapper;

import com.cdc.anniversary.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    List<Comment> getComment();
    void addComment(Comment comment);
}
