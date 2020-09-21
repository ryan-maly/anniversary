package com.cdc.anniversary.service.impl;

import com.cdc.anniversary.mapper.CollectionMapper;
import com.cdc.anniversary.mapper.ShareMapper;
import com.cdc.anniversary.mapper.StatusMapper;
import com.cdc.anniversary.model.Status;
import com.cdc.anniversary.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusMapper statusMapper;
    @Autowired
    private ShareMapper shareMapper;
    @Autowired
    private CollectionMapper collectionMapper;

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
        //dbStatus是在数据库中已经存在的，即用户已经点赞或者收藏过的
        Status dbStatus = statusMapper.getStatus(shareid, userid);
        if (dbStatus != null){
            statusMapper.updateStatus(status);
            updateStatusNum(status, dbStatus);
            Status latestStatus = statusMapper.getStatus(shareid, userid);
            if (dbStatus.isIs_collect() == false && latestStatus.isIs_collect() == true){
                collectionMapper.addCollection(userid, shareid);
            }
            if (dbStatus.isIs_collect() == true && latestStatus.isIs_collect() == false) {
                collectionMapper.delCollection(userid ,shareid);
            }
        }else {
            statusMapper.addStatus(status);
            addStatusNum(status);
            Status latestStatus = statusMapper.getStatus(shareid, userid);
            if (latestStatus.isIs_collect() == true){
                collectionMapper.addCollection(userid, shareid);
            }
        }
    }

    public void updateStatusNum(Status status, Status dbstatus){
        if (dbstatus.isIs_favor() == true && status.isIs_favor() == false){
            int favorNum = shareMapper.getFavorNum(status.getShare_id()) - 1;
            shareMapper.updateFavorNum(favorNum, status.getShare_id());
        }
        if (dbstatus.isIs_favor() == false && status.isIs_favor() == true){
            int favorNum = shareMapper.getFavorNum(status.getShare_id()) + 1;
            shareMapper.updateFavorNum(favorNum, status.getShare_id());
        }
        if (dbstatus.isIs_collect() == true && status.isIs_collect() == false){
            int collectNum = shareMapper.getCollectNum(status.getShare_id()) - 1;
            shareMapper.updateCollectNum(collectNum, status.getShare_id());
        }
        if (dbstatus.isIs_collect() == false && status.isIs_collect() == true){
            int collectNum = shareMapper.getFavorNum(status.getShare_id()) + 1;
            shareMapper.updateCollectNum(collectNum, status.getShare_id());
        }
    }

    public void addStatusNum(Status status){
        if (status.isIs_favor() == true){
            int favorNum = shareMapper.getFavorNum(status.getShare_id()) + 1;
            shareMapper.updateFavorNum(favorNum, status.getShare_id());
        }
        if (status.isIs_collect() == true){
            int collectNum = shareMapper.getCollectNum(status.getShare_id()) + 1;
            shareMapper.updateCollectNum(collectNum, status.getShare_id());
        }
    }
}
