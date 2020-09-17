package com.cdc.anniversary.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cdc.anniversary.model.Template;
import com.cdc.anniversary.model.TemplateParam;
import com.cdc.anniversary.service.AccessTokenService;
import com.cdc.anniversary.service.TemplateService;
import com.cdc.anniversary.util.CommonResult;
import com.cdc.anniversary.util.CommonUtil;
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
    public Template sendMsg2User() {
        Template newTemplate = new Template();
        newTemplate.setTemplate_id("jE0ppyWaasrVULxEVs019iP0omQKfJ92hxY8jQUOiLo");
        newTemplate.setTouser("ocmbt4qkP6XrRZk8LMKLa0RrfUjk");
        List<TemplateParam> paras=new ArrayList<TemplateParam>();
        paras.add(new TemplateParam("thing1","张三的生日"));
        paras.add(new TemplateParam("name2","张三"));
        paras.add(new TemplateParam("thing3","7天后"));
        paras.add(new TemplateParam("date4","2020年12月9日"));
        paras.add(new TemplateParam("thing5","别忘了买礼物"));
        newTemplate.setTemplateParamList(paras);
        String requestUrl="https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=ACCESS_TOKEN";
        String token = "37_r-b5Mmi7p3CFo8qgWsXnPHr4dP_3mwQQFL_bF0dZsXw2iU1eyVWTy3PUdtneVBPlkwUKa4sCIJNKMTQeb97YOndGKZ_44SknXszmjfFz5uTr-Jn5O0tr8C0dpDmNwUg14DhrTOLGG_K-_zgiIHKbAIADCF";
        requestUrl=requestUrl.replace("ACCESS_TOKEN", token);
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
