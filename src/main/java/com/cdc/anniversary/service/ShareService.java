package com.cdc.anniversary.service;

import com.cdc.anniversary.dto.ShareDTO;
import com.cdc.anniversary.model.Share;

import java.util.List;

public interface ShareService {
    List<ShareDTO> getAllShare(int userid);
    void addShare(Share share);
    List<ShareDTO> getShareByTag(String tag, int userid);
    List<ShareDTO> getShareById(int shareid, int userid);
    List<ShareDTO> getMyShare(int userId);
}
