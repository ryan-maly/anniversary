package com.cdc.anniversary.controller;

import com.alibaba.fastjson.JSON;
import com.cdc.anniversary.dto.GuideDTO;
import com.cdc.anniversary.model.Comment;
import com.cdc.anniversary.model.Guide;
import com.cdc.anniversary.service.GuideService;
import com.cdc.anniversary.service.UserService;
import com.cdc.anniversary.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/guide")
public class GuideController {
    @Autowired
    GuideService guideService;
    @Autowired
    UserService userService;
    @GetMapping("/getAll")
    public CommonResult<List<Guide>> getAllGuide(){
        return CommonResult.success(guideService.getAllGuide());
    }

    @GetMapping("/{id}/{user_id}")
    public CommonResult<Object> getGuideByID(@PathVariable("id") int id, @PathVariable("user_id" )int user_id){
        boolean isExchange = false;
        if(guideService.isExchanged(id, user_id)!=null){
            isExchange=true;
            return CommonResult.success(guideService.isExchanged(id,user_id));
        }else return CommonResult.success(guideService.getGuideByID(id));
    }

    @GetMapping("/addExchange/{id}/{user_id}/{integration}")
    public CommonResult<Object> exchange(@PathVariable("id") int id,@PathVariable("user_id") int user_id,@PathVariable("integration") int integration){

        if(guideService.isExchanged(id,user_id)!=null){
            return CommonResult.success(null, "已订阅，请勿重复操作");
        }else {
            guideService.addExchange(id,user_id);
            userService.UseIntegration(integration);
            return CommonResult.success(null, "订阅成功");
        }
    }


}
