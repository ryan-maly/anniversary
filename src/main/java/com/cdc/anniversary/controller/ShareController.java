package com.cdc.anniversary.controller;

import com.alibaba.fastjson.JSON;
import com.cdc.anniversary.model.Share;
import com.cdc.anniversary.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/share")
public class ShareController {
    @Autowired
    private ShareService shareService;

    @GetMapping("/all/{userid}")
    public Object getAllShare(@PathVariable("userid") int userid){
        return JSON.toJSONString(shareService.getAllShare(userid));
    }

    @PostMapping("/add")
    public void addShare(@RequestBody Share share){
        shareService.addShare(share);
    }

    @GetMapping("/tag/{tag}/{userid}")
    public Object getShareByTag(@PathVariable("tag") String tag, @PathVariable("userid") int userid){
        return JSON.toJSONString(shareService.getShareByTag(tag, userid));
    }

    @GetMapping("/{shareid}/{userid}")
    public Object getShareById(@PathVariable("shareid") int shareid, @PathVariable("userid") int userid){
        return JSON.toJSONString(shareService.getShareById(shareid, userid));
    }

    @GetMapping("/getMyShare/{userId}")
    public Object getMyShare(@PathVariable int userId){
        return JSON.toJSONString(shareService.getMyShare(userId));
    }
}
