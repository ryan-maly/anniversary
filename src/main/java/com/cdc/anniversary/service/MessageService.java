package com.cdc.anniversary.service;

import com.cdc.anniversary.model.Message;

import java.util.List;

public interface MessageService {
    List<Message> getMyMsg(int userid);
}
