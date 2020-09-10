package com.cdc.anniversary.service.impl;

import com.cdc.anniversary.mapper.AnniversaryMapper;
import com.cdc.anniversary.model.Anniversary;
import com.cdc.anniversary.service.AnniversaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AnniversaryServiceImpl implements AnniversaryService {
    @Autowired
    private AnniversaryMapper anniversaryMapper;

    @Override
    public void addAnniversary(Anniversary anniversary) {
        anniversaryMapper.addAnniversary(anniversary);
    }

    @Override
    public List<Map<String,Object>> getAnniversaries(int userId) {
        return anniversaryMapper.getAnniversaries(userId);
    }

    @Override
    public Anniversary getAnniversary(int anniversaryId) {
        return anniversaryMapper.getAnniversary(anniversaryId);
    }

}
