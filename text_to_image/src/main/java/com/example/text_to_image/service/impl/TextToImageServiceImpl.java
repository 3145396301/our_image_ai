package com.example.text_to_image.service.impl;

import com.example.text_to_image.service.TextToImageService;
import com.xiaoxve.entity.aireq.TextToImageReq;
import com.xiaoxve.entity.airesp.TextToImageResp;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TextToImageServiceImpl implements TextToImageService {
    @Resource
    private RestTemplate restTemplate;
    @Value("${text.to.image.url}")
    private String url;
    @Override
    public TextToImageResp synTextToImage(TextToImageReq req) {
        return restTemplate.postForObject(url,req, TextToImageResp.class);
    }

    @Override
    public boolean asynTextToImage(TextToImageReq req) {
        return false;
    }

    @Override
    public TextToImageResp getTextToImageResp(String taskId) {
        return null;
    }
}
