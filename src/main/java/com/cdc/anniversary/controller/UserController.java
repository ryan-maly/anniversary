package com.cdc.anniversary.controller;

import com.cdc.anniversary.model.User;
import com.cdc.anniversary.service.UserService;
import com.cdc.anniversary.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    public CommonResult<User> addUser(@RequestBody User user){
        return CommonResult.success(userService.addUser(user));
    }

    @GetMapping("/get/{userid}")
    public CommonResult<User> getUser(@PathVariable int userid){
        return CommonResult.success(userService.getUser(userid));
    }

}
