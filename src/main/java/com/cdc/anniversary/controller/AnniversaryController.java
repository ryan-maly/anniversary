package com.cdc.anniversary.controller;

import com.cdc.anniversary.model.Anniversary;
import com.cdc.anniversary.service.AnniversaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anniversary")
public class AnniversaryController {
    @Autowired
    private AnniversaryService anniversaryService;

    @RequestMapping("/addAnniversary")
    public void addAnniversary(Anniversary anniversary){
        anniversaryService.addAnniversary(anniversary);
    }
}
