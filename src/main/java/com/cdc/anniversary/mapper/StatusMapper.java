package com.cdc.anniversary.mapper;

import com.cdc.anniversary.model.Status;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StatusMapper {
    void addStatus(Status status);
    void updateStatus(Status status);
    Status getStatus(int shareid, int userid);
}
