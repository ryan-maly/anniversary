package com.cdc.anniversary.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cdc.anniversary.model.Code2Session;
import com.cdc.anniversary.service.LoginService;
import com.cdc.anniversary.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Code2Session getSession(String appid, String secret, String code) {
        String getSessionUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid +
                "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
        System.out.println("请求的url: " + getSessionUrl);

        String sessionStr = HttpUtil.sendGet(getSessionUrl);
        System.out.println("取得的session: " + sessionStr);

        JSONObject sessionJson = JSONObject.parseObject(sessionStr);
        Code2Session code2Session = new Code2Session();
        String openid = sessionJson.getString("openid");
        String session_key = sessionJson.getString("session_key");
        code2Session.setOpenid(openid);
        code2Session.setSession_key(session_key);
        String sessionid = "session" + openid.substring(0, 10);
        code2Session.setSessionid(sessionid);
        stringRedisTemplate.opsForValue().set(sessionid, sessionStr);
        return code2Session;
    }
}
