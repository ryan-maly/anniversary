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
    public CommonResult<Object> addShare(@RequestBody ShareDTO shareDTO){
        shareService.addShare(shareDTO);
        return CommonResult.success(null);
    }

    @GetMapping("/tag/{tag}/{userid}")
    public CommonResult<List<ShareDTO>> getShareByTag(@PathVariable("tag") String tag, @PathVariable("userid") int userid){
        List<ShareDTO> shareList = shareService.getShareByTag(tag, userid);
        Collections.reverse(shareList);
        return CommonResult.success(shareList);
    }

    @GetMapping("/{shareid}/{userid}")
    public CommonResult<List<ShareDTO>> getShareById(@PathVariable("shareid") int shareid, @PathVariable("userid") int userid){
        List<ShareDTO> shareList = shareService.getShareById(shareid, userid);
        Collections.reverse(shareList);
        return CommonResult.success(shareList);
    }

    @GetMapping("/getMyShare/{userid}")
    public CommonResult<List<ShareDTO>> getMyShare(@PathVariable int userid){
        List<ShareDTO> shareList = shareService.getMyShare(userid);
        Collections.reverse(shareList);
        return CommonResult.success(shareList);
    }
}
