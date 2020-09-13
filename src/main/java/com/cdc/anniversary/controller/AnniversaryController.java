package com.cdc.anniversary.controller;

import com.alibaba.fastjson.JSON;
import com.cdc.anniversary.model.Anniversary;
import com.cdc.anniversary.service.AnniversaryService;
import com.cdc.anniversary.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/anniversary")
public class AnniversaryController {
    @Autowired
    private AnniversaryService anniversaryService;

    @RequestMapping("/addAnniversary")
    public CommonResult<Object> addAnniversary(@RequestBody Anniversary anniversary){
        anniversaryService.addAnniversary(anniversary);
        return CommonResult.success(null);
    }

    @GetMapping("/getAnniversaries/{userId}")
    public CommonResult<List<Anniversary>> getAllAnniversary(@PathVariable int userId){
        List<Anniversary> anniversaryList = anniversaryService.getAnniversaries(userId);
        Collections.reverse(anniversaryList);
        return CommonResult.success(anniversaryList);
    }
}
