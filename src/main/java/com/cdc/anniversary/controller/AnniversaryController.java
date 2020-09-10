package com.cdc.anniversary.controller;

import com.cdc.anniversary.model.Anniversary;
import com.cdc.anniversary.service.AnniversaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/anniversary")
public class AnniversaryController {
    @Autowired
    private AnniversaryService anniversaryService;

    @RequestMapping("/addAnniversary")
    public void addAnniversary(Anniversary anniversary){
        anniversaryService.addAnniversary(anniversary);
    }

    @GetMapping("/getAnniversaries/{userId}")
    public List<Map<String,Object>> getAnniversaries(@PathVariable int userId){
        return anniversaryService.getAnniversaries(userId);
    }
}
