package com.cdc.anniversary.controller;

import com.alibaba.fastjson.JSON;
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
    public Object getComment(@PathVariable("id") int id){
        return JSON.toJSONString(commentService.getComment(id));
    }

    @PostMapping("/add")
    public void addComment(@RequestBody  Comment comment){ commentService.addComment(comment); }
}
