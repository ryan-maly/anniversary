package com.cdc.anniversary;

import com.alibaba.fastjson.JSON;
import com.cdc.anniversary.dto.ShareDTO;
import com.cdc.anniversary.mapper.ShareMapper;
import com.cdc.anniversary.model.Comment;
import com.cdc.anniversary.service.CommentService;
import com.cdc.anniversary.service.ShareService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

@SpringBootTest
class AnniversaryApplicationTests {
    @Autowired
    ShareMapper shareMapper;

    @Autowired
    CommentService commentService;

    @Test
    void getComment() {
        List<Comment> comments = commentService.getComment(1);
        for (int i = 0;i<comments.size();i++){
            System.out.printf(String.valueOf(comments.get(i)));

        }
    }
    @Test
    void addComment(){
        Comment comment = new Comment();
        comment.setContent("今天的你确实很香2");
        comment.setParent_id(1);
        comment.setShare_id(1);
        comment.setUser_id(1);
        Date a = new Date();
        a.setTime(2020-9-21);
        comment.setDate(a);

        commentService.addComment(comment);
        System.out.println(shareService.getShareByTag("share", 1));
    }

}
