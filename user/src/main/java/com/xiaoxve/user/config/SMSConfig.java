package com.xiaoxve.user.config;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.teaopenapi.models.Config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "sms")
@Data
public class SMSConfig {
    private String signName;
    private String templateCode;
    private String accessKeyId;
    private String accessKeySecret;
    // 创建一个Config Bean，用于存储accessKeyId和accessKeySecret
    @Bean
    public Config phConfig() {
        Config config = new Config();
        config.accessKeyId = accessKeyId;
        config.accessKeySecret = accessKeySecret;
        return config;
    }

    // 创建一个SendSmsRequest对象，用于发送短信
    public SendSmsRequest getSendSmsRequest() {
        SendSmsRequest sendSmsRequest = new SendSmsRequest();
        sendSmsRequest.signName = signName;
        sendSmsRequest.templateCode = templateCode;
        return sendSmsRequest;
    }

    // 创建一个Client Bean，用于发送短信
    @Bean
    public Client getClient(Config phConfig) throws Exception {
        return new Client(phConfig);
    }

}
