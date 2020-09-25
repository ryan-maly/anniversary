package com.cdc.anniversary.service.impl;

import com.cdc.anniversary.dto.CommentDTO;
import com.cdc.anniversary.dto.ShareDTO;
import com.cdc.anniversary.mapper.ShareMapper;
import com.cdc.anniversary.mapper.UserMapper;
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
    public void addShare(ShareDTO shareDTO) {
        Integer user_id = shareDTO.getUser_id();
        String tag = shareDTO.getTag();
        String content = shareDTO.getContent();
        Integer favor_num = shareDTO.getFavor_num();
        Integer collect_num = shareDTO.getCollect_num();
        Integer comment_num = shareDTO.getComment_num();
        List<String> images = shareDTO.getImages();
        Date date = shareDTO.getPubdate();
        shareDTO.setUser_id(user_id);
        shareDTO.setTag(tag);
        shareDTO.setContent(content);
        shareDTO.setFavor_num(favor_num);
        shareDTO.setCollect_num(collect_num);
        shareDTO.setComment_num(comment_num);
        shareDTO.setPubdate(date);
        shareMapper.addShare(shareDTO);
        Integer shareid = shareDTO.getId();
        for (int i = 0; i < images.size(); i++){
            shareMapper.addImage(shareid, images.get(i));
        }
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
            //拼接状态和图片
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

            //拼接评论
            List<CommentDTO> commentDTOS = shareMapper.getComments(shareDTOList.get(i).getId());
            shareDTOList.get(i).setComments(commentDTOS);
        }
        return shareDTOList;
    }

}
