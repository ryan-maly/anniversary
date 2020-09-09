package com.cdc.anniversary.mapper;

import com.cdc.anniversary.dto.ShareDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CollectionMapper {
    List<ShareDTO> getMyCollection(int id);
}
