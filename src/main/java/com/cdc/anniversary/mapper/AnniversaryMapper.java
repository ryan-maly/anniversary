package com.cdc.anniversary.mapper;

import com.cdc.anniversary.model.Anniversary;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AnniversaryMapper {

    void addAnniversary(Anniversary anniversary);
    List<Anniversary> getAnniversaries(int userId);
}
