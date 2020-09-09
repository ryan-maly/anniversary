package com.cdc.anniversary.mapper;

import com.cdc.anniversary.dto.ShareDTO;
import com.cdc.anniversary.model.Share;
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
}
