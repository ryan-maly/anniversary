package com.cdc.anniversary.controller;

import com.cdc.anniversary.model.AccessToken;
import com.cdc.anniversary.service.AccessTokenService;
import com.cdc.anniversary.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/accesstoken")
public class AccessTokenController {
    @Autowired
    private AccessTokenService accessTokenService;

    @GetMapping("/get/{appid}/{appsecret}")
    public CommonResult<AccessToken> getAccessToken(@PathVariable String appid, @PathVariable String appsecret) throws Exception {
        return CommonResult.success(accessTokenService.getAccessToken(appid, appsecret));
    }

}
