package com.cdc.anniversary.controller;

import com.cdc.anniversary.dto.ShareDTO;
import com.cdc.anniversary.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/share")
public class ShareController {
    @Autowired
    private ShareService shareService;

    @GetMapping("/all/{userid}")
    public List<ShareDTO> getAllShare(@PathVariable("userid")int userid){
        return shareService.getAllShare(userid);
    }
}
