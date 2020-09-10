package com.cdc.anniversary.service;

import com.cdc.anniversary.model.Anniversary;

import java.util.List;

public interface AnniversaryService {
    void addAnniversary(Anniversary anniversary);
    List<Anniversary> getAnniversaries(int userId);
}

