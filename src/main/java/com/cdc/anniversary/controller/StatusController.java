package com.cdc.anniversary.controller;

import com.cdc.anniversary.model.Status;
import com.cdc.anniversary.service.StatusService;
import com.cdc.anniversary.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {
    @Autowired
    private StatusService statusService;

    @PostMapping("/add")
    public CommonResult<Object> addStatus(@RequestBody Status status){
        statusService.addStatus(status);
        return CommonResult.success(null);
    }
}
