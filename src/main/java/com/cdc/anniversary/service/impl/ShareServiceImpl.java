package com.cdc.anniversary.service.impl;

import com.cdc.anniversary.dto.ShareDTO;
import com.cdc.anniversary.mapper.ShareMapper;
import com.cdc.anniversary.model.Share;
import com.cdc.anniversary.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {
    @Autowired
    private ShareMapper shareMapper;

    @Override
    public List<ShareDTO> getAllShare(int userid) {
        List<ShareDTO> shareDTOList = shareMapper.getAllShare(userid);
        for (int i = 0; i < shareDTOList.size(); i++){
            List<String> imgList = shareMapper.getImages(shareDTOList.get(i).getId());
            shareDTOList.get(i).setImages(imgList);
        }
        return shareDTOList;
    }

    @Override
    public void addShare(Share share) {
        Integer user_id = share.getUser_id();
        String tag = share.getTag();
        String content = share.getContent();
        Integer favor_num = share.getFavor_num();
        Integer collect_num = share.getCollect_num();
        Integer comment_num = share.getComment_num();
        Date date = share.getPubdate();
        share.setUser_id(user_id);
        share.setTag(tag);
        share.setContent(content);
        share.setFavor_num(favor_num);
        share.setCollect_num(collect_num);
        share.setComment_num(comment_num);
        share.setPubdate(date);
        shareMapper.addShare(share);
    }

    @Override
    public List<ShareDTO> getShareByTag(String tag, int userid) {
        return shareMapper.getShareByTag(tag, userid);
    }

    @Override
    public List<ShareDTO> getShareById(int shareid, int userid) {
        return shareMapper.getShareById(shareid, userid);
    }

    @Override
    public List<ShareDTO> getMyShare(int userId) {
        return shareMapper.getMyShare(userId);
    }

    @Override
    public List<String> getImage(int shareid) {
        return null;
    }
}
