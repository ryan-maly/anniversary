package com.cdc.anniversary.mapper;

import com.cdc.anniversary.model.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper {
    List<Message> getMyMsg(int userid);
}
