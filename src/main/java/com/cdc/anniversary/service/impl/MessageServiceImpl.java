package com.cdc.anniversary.service.impl;

import com.cdc.anniversary.mapper.MessageMapper;
import com.cdc.anniversary.model.Message;
import com.cdc.anniversary.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Message> getMyMsg(int userid) {
        return messageMapper.getMyMsg(userid);
    }

    @Override
    public void addMyMsg(Message message) {
        Integer user_id = message.getUser_id();
        String content = message.getContent();
        Date pubdate = message.getPubdate();
        message.setUser_id(user_id);
        message.setContent(content);
        message.setPubdate(pubdate);
        messageMapper.addMyMsg(message);
    }
}
