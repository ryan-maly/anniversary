package com.cdc.anniversary.controller;

import com.cdc.anniversary.model.Template;
import com.cdc.anniversary.service.TemplateService;
import com.cdc.anniversary.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/template")
public class SendMsg2UserController {
    @Autowired
    private TemplateService templateService;

    @GetMapping("/send")
    public CommonResult<Template> sendMsg2User(){
        return CommonResult.success(templateService.sendMsg2User());
    }
}
