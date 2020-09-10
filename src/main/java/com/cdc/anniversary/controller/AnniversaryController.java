package com.cdc.anniversary.controller;

import com.alibaba.fastjson.JSON;
import com.cdc.anniversary.model.Anniversary;
import com.cdc.anniversary.service.AnniversaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/anniversary")
public class AnniversaryController {
    @Autowired
    private AnniversaryService anniversaryService;

    @RequestMapping("/addAnniversary")
    public void addAnniversary(@RequestBody Anniversary anniversary){
        anniversaryService.addAnniversary(anniversary);
    }

    @GetMapping("/getAnniversaries/{userId}")
    public Object getAllAnniversary(@PathVariable int userId){
        return JSON.toJSONString(anniversaryService.getAnniversaries(userId));
    }

    @GetMapping("/getAnniversary/{anniversaryId}")
    @ResponseBody
    public Object getAnniversary(@PathVariable int anniversaryId){
        return JSON.toJSONString(anniversaryService.getAnniversary(anniversaryId));
    }
}
