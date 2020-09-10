package com.cdc.anniversary.controller;

import com.cdc.anniversary.model.Anniversary;
import com.cdc.anniversary.service.AnniversaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public List<Map<String,Object>> getAllAnniversary(@PathVariable int userId){
        return anniversaryService.getAnniversaries(userId);
    }

    @GetMapping("/getAnniversary/{anniversaryId}")
    @ResponseBody
    public Anniversary getAnniversary(@PathVariable int anniversaryId){
        return anniversaryService.getAnniversary(anniversaryId);
    }
}
