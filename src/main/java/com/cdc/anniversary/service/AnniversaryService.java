package com.cdc.anniversary.service;

import com.cdc.anniversary.model.Anniversary;

import java.util.List;
import java.util.Map;

public interface AnniversaryService {
    void addAnniversary(Anniversary anniversary);
    List<Map<String,Object>> getAnniversaries(int userId);
    Anniversary getAnniversary(int anniversaryId);
}

