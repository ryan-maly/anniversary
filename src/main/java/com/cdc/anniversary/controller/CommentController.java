package com.cdc.anniversary.controller;

import com.cdc.anniversary.model.Comment;
import com.cdc.anniversary.model.Share;
import com.cdc.anniversary.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @GetMapping("getall/{id}")
    public List<Comment> getComment(@PathVariable("id") int id){
        return  commentService.getComment(id);
    }

    @GetMapping("add/{comment}")
    public void addComment(@RequestBody  Comment comment){ commentService.addComment(comment); }
}
