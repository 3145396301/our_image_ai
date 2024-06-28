package com.xiaoxve.user.service.impl;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.xiaoxve.exception.DefinitionException;
import com.xiaoxve.user.config.SMSConfig;
import com.xiaoxve.user.service.SMSService;
import jakarta.annotation.Resource;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

@Service
public class SMSServiceImpl implements SMSService {
    @Resource
    private Client smsClient;
    @Resource
    private SMSConfig smsConfig;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private RedissonClient redisson;

    @Override
    public void sendSMS(String phoneNumber, String code) {
        RLock lock = redisson.getLock("phone:"+phoneNumber);
        try {
            lock.lock();
            //判断计数
            sleep(50000);
            if ( redisTemplate.opsForValue().get("times:" + phoneNumber)!=null) {
                if ( redisTemplate.opsForValue().get("times:" + phoneNumber).equals(2)) {
                    throw new DefinitionException(400,"今日次数已达上限");
                }
            }
            // 次数
            if (redisTemplate.opsForValue().get("times:" + phoneNumber)!= null) {
                redisTemplate.opsForValue().set("times:"+phoneNumber,2,getNowToNextDaySeconds(),TimeUnit.SECONDS);
            } else {
                redisTemplate.opsForValue().set("times:"+phoneNumber,1,getNowToNextDaySeconds(),TimeUnit.SECONDS);
            }

            // 验证码
            redisTemplate.opsForValue().set("phone:"+phoneNumber, code, 120, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

        try {
            SendSmsRequest sendSmsRequest = smsConfig.getSendSmsRequest();
            sendSmsRequest.phoneNumbers = phoneNumber;
            sendSmsRequest.templateParam = "{\"code\":\"" + code + "\"}";
            SendSmsResponse sendSmsResponse = smsClient.sendSms(sendSmsRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取当前时间到凌晨的秒数
     * @author y1ng
     */
    public static Long getNowToNextDaySeconds() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000;
    }
}
