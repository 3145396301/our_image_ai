package com.example.text_to_image.service.impl;

import com.example.text_to_image.service.TextToImageService;
import com.xiaoxve.entity.aireq.ProgressReq;
import com.xiaoxve.entity.aireq.TextToImageReq;
import com.xiaoxve.entity.airesp.ProgressResp;
import com.xiaoxve.entity.airesp.TextToImageResp;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.function.Consumer;
@Slf4j
@Service
public class TextToImageServiceImpl implements TextToImageService {
    @Resource
    private RestTemplate restTemplate;
    @Value("${text.to.image.url}")
    private String txt2ImgUrl;
    @Value("${progress.url}")
    private String progressUrl;
    @Override
    public TextToImageResp synTextToImage(TextToImageReq req) {
        return restTemplate.postForObject(txt2ImgUrl,req, TextToImageResp.class);
    }
    @Async
    @Override
    public void asynTextToImage(TextToImageReq req, Consumer<TextToImageResp> callbackTask) {
        TextToImageResp textToImageResp = restTemplate.postForObject(txt2ImgUrl, req, TextToImageResp.class);
        callbackTask.accept(textToImageResp);
    }

    @Override
    @Async
    public void asynTextToImage(TextToImageReq req, String callbackUrl) {
        TextToImageResp textToImageResp = restTemplate.postForObject(txt2ImgUrl, req, TextToImageResp.class);
        log.debug("callbackUrl:{}",callbackUrl);
        restTemplate.postForObject(callbackUrl, textToImageResp, TextToImageResp.class);
    }

    @Override
    public ProgressResp getTextToImageProgress(String taskId) {
        ProgressReq progressReq = new ProgressReq();
        progressReq.setIdTask(taskId);
        progressReq.setLivePreview(true);
        return restTemplate.postForObject(progressUrl, progressReq, ProgressResp.class);
    }
}
