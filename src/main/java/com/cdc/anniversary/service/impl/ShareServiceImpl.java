package com.cdc.anniversary.service.impl;

import com.cdc.anniversary.dto.ShareDTO;
import com.cdc.anniversary.mapper.ShareMapper;
import com.cdc.anniversary.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {
    @Autowired
    private ShareMapper shareMapper;

    @Override
    public List<ShareDTO> getAllShare(int userid) {
        return shareMapper.getAllShare(userid);
    }
}
