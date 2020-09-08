package com.cdc.anniversary;

import com.cdc.anniversary.dto.ShareDTO;
import com.cdc.anniversary.mapper.ShareMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AnniversaryApplicationTests {
    @Autowired
    ShareMapper shareMapper;

    @Test
    void getAllShare() {
        List<ShareDTO> shareList = shareMapper.getAllShare();
        for (int i = 0; i < shareList.size(); i++){
            System.out.println(shareList.get(i));
        }
    }

}
