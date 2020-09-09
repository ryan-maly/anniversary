package com.cdc.anniversary.service;

import com.cdc.anniversary.dto.ShareDTO;

import java.util.List;

public interface CollectionService {
    List<ShareDTO> getMyCollection(int id);
}
