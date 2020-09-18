package com.cdc.anniversary.controller;

import com.cdc.anniversary.model.Code2Session;
import com.cdc.anniversary.service.LoginService;
import com.cdc.anniversary.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/{appid}/{secret}/{code}")
    public CommonResult<Code2Session> login(@PathVariable String appid, @PathVariable String secret, @PathVariable String code){
        return CommonResult.success(loginService.getSession(appid, secret, code));
    }
}
