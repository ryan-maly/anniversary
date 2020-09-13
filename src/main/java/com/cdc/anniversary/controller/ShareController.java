package com.cdc.anniversary.controller;

import com.alibaba.fastjson.JSON;
import com.cdc.anniversary.dto.ShareDTO;
import com.cdc.anniversary.model.Share;
import com.cdc.anniversary.service.ShareService;
import com.cdc.anniversary.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/share")
public class ShareController {
    @Autowired
    private ShareService shareService;

    @GetMapping("/all/{userid}")
    public CommonResult<List<ShareDTO>> getAllShare(@PathVariable("userid") int userid){
        List<ShareDTO> shareList = shareService.getAllShare(userid);
        Collections.reverse(shareList);
        return CommonResult.success(shareList);
    }

    @PostMapping("/add")
    public void addShare(@RequestBody Share share){
        shareService.addShare(share);
    }

    @GetMapping("/tag/{tag}/{userid}")
    public List<ShareDTO> getShareByTag(@PathVariable("tag") String tag, @PathVariable("userid") int userid){
        return shareService.getShareByTag(tag, userid);
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
