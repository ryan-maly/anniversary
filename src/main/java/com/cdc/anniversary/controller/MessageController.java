package com.cdc.anniversary.controller;

import com.alibaba.fastjson.JSON;
import com.cdc.anniversary.model.Message;
import com.cdc.anniversary.service.MessageService;
import com.cdc.anniversary.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/msg")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/get/{userid}")
    public CommonResult<List<Message>> getMyMsg(@PathVariable int userid){
        return CommonResult.success(messageService.getMyMsg(userid));
    }

    @PostMapping("/add")
    public CommonResult<Object> addMyMsg(@RequestBody Message message){
        messageService.addMyMsg(message);
        return CommonResult.success(null);
    }
}
