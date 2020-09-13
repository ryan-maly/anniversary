package com.cdc.anniversary.controller;

import com.alibaba.fastjson.JSON;
import com.cdc.anniversary.dto.ShareDTO;
import com.cdc.anniversary.service.CollectionService;
import com.cdc.anniversary.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/collection")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    @RequestMapping("/get/{id}")
    public CommonResult<List<ShareDTO>> getMyCollection(@PathVariable int id){
        return CommonResult.success(collectionService.getMyCollection(id));
    }
}
