package com.cdc.anniversary.controller;

import com.alibaba.fastjson.JSON;
import com.cdc.anniversary.model.Message;
import com.cdc.anniversary.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/msg")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/get/{userid}")
    public Object getMyMsg(@PathVariable int userid){
        return JSON.toJSONString(messageService.getMyMsg(userid));
    }

    @PostMapping("/add")
    public void addMyMsg(@RequestBody Message message){
        messageService.addMyMsg(message);
    }
}
