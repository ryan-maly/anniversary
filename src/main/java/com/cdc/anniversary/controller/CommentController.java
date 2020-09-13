package com.cdc.anniversary.controller;

import com.alibaba.fastjson.JSON;
import com.cdc.anniversary.model.Comment;
import com.cdc.anniversary.model.Share;
import com.cdc.anniversary.service.CommentService;
import com.cdc.anniversary.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @GetMapping("getall/{id}")
    public CommonResult<List<Comment>> getComment(@PathVariable("id") int id){
        return CommonResult.success(commentService.getComment(id));
    }

    @PostMapping("/add")
    public CommonResult<Object> addComment(@RequestBody Comment comment){
        commentService.addComment(comment);
        return CommonResult.success(null);
    }
}
