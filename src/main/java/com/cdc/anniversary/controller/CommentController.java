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
    @GetMapping("getall")
    public CommonResult<List<Comment>> getComment(){
        return CommonResult.success(commentService.getComment());
    }

    @PostMapping("/add")
    public CommonResult<Object> addComment(@RequestBody Comment comment){
        commentService.addComment(comment);
        return CommonResult.success(null);
    }
}
