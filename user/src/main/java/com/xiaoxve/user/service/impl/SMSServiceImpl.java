package com.xiaoxve.user.service.impl;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.xiaoxve.user.config.SMSConfig;
import com.xiaoxve.user.service.SMSService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SMSServiceImpl implements SMSService {
    @Resource
    private Client smsClient;
    @Resource
    private SMSConfig smsConfig;

    public void sendSMS(String phoneNumber, String code) {
        try {
            SendSmsRequest sendSmsRequest = smsConfig.getSendSmsRequest();
            sendSmsRequest.phoneNumbers = phoneNumber;
            sendSmsRequest.templateParam = "{\"code\":\"" + code + "\"}";
            SendSmsResponse sendSmsResponse = smsClient.sendSms(sendSmsRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
