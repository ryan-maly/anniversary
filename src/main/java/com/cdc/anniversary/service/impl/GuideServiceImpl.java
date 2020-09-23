package com.cdc.anniversary.service.impl;

import com.cdc.anniversary.dto.GuideDTO;
import com.cdc.anniversary.mapper.GuideMapper;
import com.cdc.anniversary.model.Exchange;
import com.cdc.anniversary.model.Guide;
import com.cdc.anniversary.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuideServiceImpl implements GuideService {
    @Autowired
    GuideMapper guideMapper;

    @Override
    public List<GuideDTO> getAllGuide(int userid) {
        List<GuideDTO> guideDTOList = guideMapper.getAllGuide();
        Exchange exchange = null;
        for (GuideDTO guideDTO : guideDTOList){
            guideDTO.setUser_id(userid);
            exchange = guideMapper.getExchangeById(userid, guideDTO.getId());
            if (exchange != null){
                guideDTO.setExchange(true);
            }else {
                guideDTO.setExchange(false);
            }
        }
        return guideDTOList;
    }

    @Override
    public GuideDTO isExchanged(int id,int user_id) {
        return guideMapper.isExchanged(id,user_id);
    }

    @Override
    public void addExchange(int id, int user_id) {
        guideMapper.addExchange(id,user_id);

    }
}
