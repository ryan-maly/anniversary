package com.cdc.anniversary.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cdc.anniversary.model.AccessToken;
import com.cdc.anniversary.service.AccessTokenService;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Service
public class AccessTokenServiceImpl implements AccessTokenService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public AccessToken getAccessToken(String appid, String appsecret) throws Exception {
        AccessToken accessToken = null;
        String accessTokenStr = stringRedisTemplate.opsForValue().get("accesstoken");
        if (!StringUtil.isNullOrEmpty(accessTokenStr)){
            accessToken = JSONObject.parseObject(accessTokenStr, AccessToken.class);
        }else {
            accessToken = getAccessTokenFromWx(appid, appsecret);
            stringRedisTemplate.opsForValue().set("accesstoken", JSONObject.toJSONString(accessToken));
            stringRedisTemplate.expire("accesstoken", 1000*60*110, TimeUnit.MILLISECONDS);
        }
        return accessToken;
    }

    public AccessToken getAccessTokenFromWx(String appid, String appsecret) throws Exception {
        String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                + appid + "&secret=" + appsecret;
        System.out.println("URL for getting accessToken accessTokenUrl=" + accessTokenUrl);

        URL url = new URL(accessTokenUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.connect();

        //获取返回的字符
        InputStream inputStream = connection.getInputStream();
        int size =inputStream.available();
        byte[] bs =new byte[size];
        inputStream.read(bs);
        String message=new String(bs,"UTF-8");

        //获取access_token
        JSONObject jsonObject = JSONObject.parseObject(message);
        String accessTokenFromWx = jsonObject.getString("access_token");
        int expires_in = jsonObject.getInteger("expires_in");
        System.out.println("accessToken="+accessTokenFromWx);
        System.out.println("expires_in="+expires_in);

        AccessToken accessToken = new AccessToken();
        accessToken.setAccess_token(accessTokenFromWx);
        accessToken.setExpires_in(expires_in);
        return accessToken;
    }
}
