package com.cdc.anniversary;

import com.alibaba.fastjson.JSON;
import com.cdc.anniversary.dto.ShareDTO;
import com.cdc.anniversary.service.ShareService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@SpringBootTest
class AnniversaryApplicationTests {
    @Autowired
    ShareService shareService;

    @Test
    void getShareByTag(){

    }

}
