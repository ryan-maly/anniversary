package com.cdc.anniversary.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cdc.anniversary.model.Code2Session;
import com.cdc.anniversary.service.Code2SessionService;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class Code2SessionServiceImpl implements Code2SessionService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Code2Session getSession(String appid, String appsecret, String code) throws Exception {
        Code2Session code2Session = null;
        String openidStr = stringRedisTemplate.opsForValue().get("session");
        if (!StringUtil.isNullOrEmpty(openidStr)){
            code2Session = JSONObject.parseObject(openidStr, Code2Session.class);
        }else {
            code2Session = getSessionFromWx(appid, appsecret, code);
            stringRedisTemplate.opsForValue().set("session", JSONObject.toJSONString(code2Session));
        }
        return code2Session;
    }

    public Code2Session getSessionFromWx(String appid, String appsecret, String code) throws Exception{
        String sessiondUrl = "https://api.weixin.qq.com/sns/jscode2session?appid="
                + appid + "&secret=" + appsecret + "&js_code=" + code + "&grant_type=authorization_code";
        System.out.println("URL for getting session =" + sessiondUrl);

        URL url = new URL(sessiondUrl);
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
        System.out.println("message" + message);

        //获取access_token
        JSONObject jsonObject = JSONObject.parseObject(message);
        String openIdFromWx = jsonObject.getString("openid");
        String session_key = jsonObject.getString("session_key");
        System.out.println("openid="+openIdFromWx);
        System.out.println("session_key="+session_key);

        Code2Session code2Session = new Code2Session();
        code2Session.setOpenid(openIdFromWx);
        code2Session.setSession_key(session_key);
        return code2Session;
    }
}
