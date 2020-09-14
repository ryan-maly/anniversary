package com.cdc.anniversary.service;

import com.cdc.anniversary.dto.ShareDTO;
import com.cdc.anniversary.model.Share;
import com.cdc.anniversary.model.Status;

import java.util.List;

public interface ShareService {
    List<ShareDTO> getAllShare(int userid);
    void addShare(ShareDTO shareDTO);
    List<ShareDTO> getShareByTag(String tag, int userid);
    List<ShareDTO> getShareById(int shareid, int userid);
    List<ShareDTO> getMyShare(int userid);
}
