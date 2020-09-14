package com.cdc.anniversary.service.impl;

import com.cdc.anniversary.dto.ShareDTO;
import com.cdc.anniversary.mapper.CollectionMapper;
import com.cdc.anniversary.service.CollectionService;
import com.cdc.anniversary.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;
    @Autowired
    private ShareServiceImpl shareServiceImpl;

    @Override
    public List<ShareDTO> getMyCollection(int id) {
        List<ShareDTO> shareList = collectionMapper.getMyCollection(id);
        shareServiceImpl.combine(shareList, id);
        return shareList;
    }
}
