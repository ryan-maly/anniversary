package com.cdc.anniversary.controller;

import com.cdc.anniversary.dto.ShareDTO;
import com.cdc.anniversary.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShareController {
    @Autowired
    private ShareService shareService;

    @GetMapping("/get/shares")
    public List<ShareDTO> getAllShare(){
        return shareService.getAllShare();
    }
}
