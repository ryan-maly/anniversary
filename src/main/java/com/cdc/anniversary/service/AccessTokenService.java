package com.cdc.anniversary.service;

import com.cdc.anniversary.model.AccessToken;

public interface AccessTokenService {
    AccessToken getAccessToken(String appid, String appsecret) throws Exception;
}
