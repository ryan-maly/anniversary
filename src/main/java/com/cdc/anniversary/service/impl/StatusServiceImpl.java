package com.cdc.anniversary.service.impl;

import com.cdc.anniversary.mapper.StatusMapper;
import com.cdc.anniversary.model.Status;
import com.cdc.anniversary.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusMapper statusMapper;

    @Override
    public void addStatus(Status status) {
        Integer shareid = status.getShare_id();
        Integer userid = status.getUser_id();
        boolean isFavor = status.isIs_favor();
        boolean isCollect = status.isIs_collect();
        status.setShare_id(shareid);
        status.setUser_id(userid);
        status.setIs_favor(isFavor);
        status.setIs_collect(isCollect);
        statusMapper.addStatus(status);
    }
}
