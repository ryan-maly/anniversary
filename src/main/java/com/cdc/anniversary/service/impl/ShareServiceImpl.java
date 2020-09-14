package com.cdc.anniversary.service.impl;

import com.cdc.anniversary.dto.ShareDTO;
import com.cdc.anniversary.mapper.ShareMapper;
import com.cdc.anniversary.mapper.UserMapper;
import com.cdc.anniversary.model.Share;
import com.cdc.anniversary.model.Status;
import com.cdc.anniversary.model.User;
import com.cdc.anniversary.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {
    @Autowired
    private ShareMapper shareMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<ShareDTO> getAllShare(int userid) {
        List<ShareDTO> shareDTOList = shareMapper.getAllShare();
        shareDTOList = combine(shareDTOList, userid);
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
        List<ShareDTO> shareDTOList = shareMapper.getShareByTag(tag);
        shareDTOList = combine(shareDTOList, userid);
        return shareDTOList;
    }

    @Override
    public List<ShareDTO> getShareById(int shareid, int userid) {
        List<ShareDTO> shareDTOList = shareMapper.getShareById(shareid);
        shareDTOList = combine(shareDTOList,userid);
        return shareDTOList;
    }

    @Override
    public List<ShareDTO> getMyShare(int userid) {
        List<ShareDTO> shareDTOList = shareMapper.getMyShare(userid);
        shareDTOList = combine(shareDTOList, userid);
        return shareDTOList;
    }

    public List<ShareDTO> combine(List<ShareDTO> shareDTOList, int userid){
        for (int i = 0; i < shareDTOList.size(); i++){
            List<String> imgList = shareMapper.getImages(shareDTOList.get(i).getId());
            Status status = shareMapper.getStatus(shareDTOList.get(i).getId(), userid);
            User user = userMapper.getUser(shareDTOList.get(i).getUser_id());
            if (status == null){
                status = new Status();
                status.setIs_favor(false);
                status.setIs_collect(false);
            }
            shareDTOList.get(i).setImages(imgList);
            shareDTOList.get(i).setIs_favor(status.isIs_favor());
            shareDTOList.get(i).setIs_collect(status.isIs_collect());
            shareDTOList.get(i).setUsername(user.getUsername());
            shareDTOList.get(i).setAvatar(user.getAvatar());
        }
        return shareDTOList;
    }

}
