package com.cdc.anniversary.mapper;

import com.cdc.anniversary.dto.ShareDTO;
import com.cdc.anniversary.model.Share;
import com.cdc.anniversary.model.Status;
import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface ShareMapper {
    List<ShareDTO> getAllShare(int userid);
    void addShare(Share share);
    List<ShareDTO> getShareByTag(String tag, int userid);
    List<ShareDTO> getShareById(int shareid, int userid);
    List<ShareDTO> getMyShare(int userId);
    int getFavorNum(int shareId);
    void updateFavorNum(int favorNum, int shareId);
    int getCollectNum(int shareId);
    void updateCollectNum(int favorNum, int shareId);
    int getCommentNum(int shareId);
    void updateCommentNum(int shareId, int commentId);
    List<String> getImages(int shareid);
    Status getStatus(int shareid, int userid);
}
