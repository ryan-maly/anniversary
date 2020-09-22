package com.cdc.anniversary.service.impl;

import com.cdc.anniversary.mapper.UserMapper;
import com.cdc.anniversary.model.User;
import com.cdc.anniversary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void UseIntegration(int integration) {
        userMapper.UseIntegration(integration);

    }

    @Override
    public User addUser(User user) {
        userMapper.addUser(user);
        return user;
    }

    @Override
    public User getUser(int userid) {
        return userMapper.getUser(userid);
    }
}
