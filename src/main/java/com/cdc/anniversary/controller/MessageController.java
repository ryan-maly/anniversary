package com.cdc.anniversary.controller;

import com.cdc.anniversary.model.Message;
import com.cdc.anniversary.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/msg")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/get/{userid}")
    public List<Message> getMyMsg(@PathVariable int userid){
        return messageService.getMyMsg(userid);
    }
}
