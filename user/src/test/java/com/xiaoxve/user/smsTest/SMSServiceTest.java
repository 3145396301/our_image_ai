package com.xiaoxve.user.smsTest;

import com.xiaoxve.user.service.SMSService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
public class SMSServiceTest {
    @Resource
    SMSService smsService;

    @Test
    public void sendTest(){
        smsService.sendSMS("17749462822","1314");
    }

}
