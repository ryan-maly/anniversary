package com.cdc.anniversary;

import com.cdc.anniversary.service.ShareService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class AnniversaryApplicationTests {
    @Autowired
    ShareService shareService;

    @Test
    public void getAllShareTest() {
        System.out.println(shareService.getAllShare(1));

    }

}
