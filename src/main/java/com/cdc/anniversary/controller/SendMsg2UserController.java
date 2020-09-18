package com.cdc.anniversary.controller;

import com.cdc.anniversary.model.Template;
import com.cdc.anniversary.service.TemplateService;
import com.cdc.anniversary.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/template")
public class SendMsg2UserController {
    @Autowired
    private TemplateService templateService;

//    @GetMapping("/send/{appid}/{secret}/{sessionid}")
//    public CommonResult<Template> sendMsg2User(@PathVariable String appid, @PathVariable String secret,
//                                               @PathVariable String sessionid){
//        return CommonResult.success(templateService.sendMsg2User(appid, secret, sessionid));
//    }

    @PostMapping("/send/{appid}/{secret}/{sessionid}")
    public CommonResult<Template> sendMsg2User(@PathVariable String appid, @PathVariable String secret,
                                               @PathVariable String sessionid, @RequestBody Template template){
        return CommonResult.success(templateService.sendMsg2User(appid, secret, sessionid, template));
    }
}
