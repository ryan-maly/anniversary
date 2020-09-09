package com.cdc.anniversary.controller;

import com.cdc.anniversary.model.Comment;
import com.cdc.anniversary.model.Guide;
import com.cdc.anniversary.service.GuideService;
import com.cdc.anniversary.service.UserService;
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
    public List<Guide> getAllGuide(){
        return  guideService.getAllGuide();
    }

    @GetMapping("/{id}/{user_id}")
    public Guide getGuideByID(@PathVariable("id") int id,@PathVariable("user_id" )int user_id){
        boolean isExchange = false;
        if(guideService.isExchanged(id, user_id)!=null){
            isExchange=true;
            return guideService.isExchanged(id,user_id);

        }else return  guideService.getGuideByID(id);
    }

    @GetMapping("/addExchange/{id}/{user_id}/{integration}")
    public String getAllGuide(@PathVariable("id") int id,@PathVariable("user_id") int user_id,@PathVariable("integration") int integration){

        if(guideService.isExchanged(id,user_id)!=null){
            System.out.printf("已订阅，请勿重复操作");
            return "已订阅，请勿重复操作" ;
        }else guideService.addExchange(id,user_id);
        userService.UseIntegration(integration);


        return "订阅成功";
    }


}
