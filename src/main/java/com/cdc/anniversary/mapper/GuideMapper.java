package com.cdc.anniversary.mapper;

import com.cdc.anniversary.dto.GuideDTO;
import com.cdc.anniversary.model.Exchange;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface GuideMapper {
    List<GuideDTO> getAllGuide();
    Exchange getExchangeById(int userid, int guideid);
    GuideDTO isExchanged(int id,int user_id);
    void addExchange(int id,int user_id);
}
