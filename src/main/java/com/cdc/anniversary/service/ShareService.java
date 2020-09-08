package com.cdc.anniversary.service;

import com.cdc.anniversary.dto.ShareDTO;
import com.cdc.anniversary.model.Share;

import java.util.List;

public interface ShareService {
    List<ShareDTO> getAllShare(int userid);
    void addShare(Share share);
}
