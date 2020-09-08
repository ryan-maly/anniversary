package com.cdc.anniversary.controller;

import com.cdc.anniversary.dto.ShareDTO;
import com.cdc.anniversary.model.Share;
import com.cdc.anniversary.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/share")
public class ShareController {
    @Autowired
    private ShareService shareService;

    @GetMapping("/all/{userid}")
    public List<ShareDTO> getAllShare(@PathVariable("userid") int userid){
        return shareService.getAllShare(userid);
    }

    @PostMapping("/add")
    public void addShare(@RequestBody Share share){
        shareService.addShare(share);
    }
}
