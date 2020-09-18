package com.cdc.anniversary.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cdc.anniversary.model.Template;
import com.cdc.anniversary.model.TemplateParam;
import com.cdc.anniversary.service.TemplateService;
import com.cdc.anniversary.util.CommonUtil;
import com.cdc.anniversary.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Template sendMsg2User(String appid, String secret, String sessionid, Template template) {
        //获取ACCESS TOKEN
        String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                + appid + "&secret=" + secret;
        String accessTokenStr = HttpUtil.sendGet(accessTokenUrl);
        JSONObject accessTokenJson = JSONObject.parseObject(accessTokenStr);
        String accessToken = accessTokenJson.getString("access_token");

        //创建模板并发送
        Template newTemplate = new Template();
        newTemplate.setTemplate_id("jE0ppyWaasrVULxEVs019jzKfsm9mzPPABQv2A7-RR8");
        String session = stringRedisTemplate.opsForValue().get(sessionid);
        JSONObject sessionJson = JSONObject.parseObject(session);
        String openid = sessionJson.getString("openid");
        newTemplate.setTouser(openid);

        List<TemplateParam> paras = template.getTemplateParamList();
//        paras.add(new TemplateParam("thing1","张三的生日"));
//        paras.add(new TemplateParam("thing3","7天后"));
//        paras.add(new TemplateParam("date4","2020年12月9日"));
//        paras.add(new TemplateParam("thing5","别忘了买礼物"));
        System.out.println("paras:" + paras);
        newTemplate.setTemplateParamList(paras);
        String requestUrl="https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=ACCESS_TOKEN";
        requestUrl=requestUrl.replace("ACCESS_TOKEN", accessToken);
        System.out.println("请求的url：" + requestUrl);

        System.out.println(newTemplate.toJSON());
        JSONObject jsonResult= CommonUtil.httpsRequest(requestUrl, "POST", newTemplate.toJSON());
        if(jsonResult!=null){
            System.out.println(jsonResult);
            int errorCode=jsonResult.getInteger("errcode");
            String errorMessage=jsonResult.getString("errmsg");
            if(errorCode==0){
                System.out.println("Send Success");
            }else{
                System.out.println("订阅消息发送失败:"+errorCode+","+errorMessage);
            }
        }
        return newTemplate;
    }
}
