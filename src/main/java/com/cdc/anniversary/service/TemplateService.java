package com.cdc.anniversary.service;

import com.cdc.anniversary.model.Template;
import com.cdc.anniversary.util.CommonResult;

public interface TemplateService {
    Template sendMsg2User(String appid, String secret, String sessionid, Template template);
}
