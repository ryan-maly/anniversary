package com.cdc.anniversary.mapper;

import com.cdc.anniversary.model.Anniversary;
import com.cdc.anniversary.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AnniversaryMapper {

    void addAnniversary(Anniversary anniversary);
    List<Map<String,Object>> getAnniversaries(int userId);
}
