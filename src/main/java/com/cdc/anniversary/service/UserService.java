package com.cdc.anniversary.service;

import com.cdc.anniversary.model.User;

public interface UserService {
    void UseIntegration(int integration);

    User addUser(User user);

    User getUser(int userid);
}
