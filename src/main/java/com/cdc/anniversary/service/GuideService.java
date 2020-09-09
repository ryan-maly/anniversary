package com.cdc.anniversary.service;

import com.cdc.anniversary.dto.GuideDTO;
import com.cdc.anniversary.model.Guide;

import java.util.List;

public interface GuideService {
    List<Guide> getAllGuide();
    Guide getGuideByID(int id);
    GuideDTO isExchanged(int id,int user_id);
    void addExchange(int id,int user_id);
}
