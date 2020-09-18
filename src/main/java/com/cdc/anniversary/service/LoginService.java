package com.cdc.anniversary.service;

import com.cdc.anniversary.model.Code2Session;

public interface LoginService {
    Code2Session getSession(String appid, String secret, String code);
}
