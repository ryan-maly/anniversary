package com.cdc.anniversary.service.impl;

import com.cdc.anniversary.dto.GuideDTO;
import com.cdc.anniversary.mapper.GuideMapper;
import com.cdc.anniversary.model.Guide;
import com.cdc.anniversary.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GuideServiceImpl implements GuideService {
    @Autowired
    GuideMapper guideMapper;

    @Override
    public List<Guide> getAllGuide() {
        return guideMapper.getAllGuide();
    }

    @Override
    public Guide getGuideByID(int id) {
        return guideMapper.getGuideByID(id);
    }

    @Override
    public GuideDTO isExchanged(int id,int user_id) {
        return guideMapper.isExchanged(id,user_id);
    }
}
