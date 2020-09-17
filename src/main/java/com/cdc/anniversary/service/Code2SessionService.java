package com.cdc.anniversary.service;

import com.cdc.anniversary.model.Code2Session;

public interface Code2SessionService {
    Code2Session getSession(String appid, String appsecret, String code) throws Exception;
}
