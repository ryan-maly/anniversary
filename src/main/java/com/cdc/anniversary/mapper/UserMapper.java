package com.cdc.anniversary.mapper;

import com.cdc.anniversary.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    void addUser(User user);
}
