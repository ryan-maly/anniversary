package com.cdc.anniversary.service;

import com.cdc.anniversary.dto.GuideDTO;
import com.cdc.anniversary.model.Guide;

import java.util.List;

public interface GuideService {
    List<GuideDTO> getAllGuide(int userid);
    GuideDTO isExchanged(int id,int user_id);
    void addExchange(int id,int user_id);
}
