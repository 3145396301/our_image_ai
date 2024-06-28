package com.example.text_to_image.service;

import com.xiaoxve.entity.aireq.TextToImageReq;
import com.xiaoxve.entity.airesp.ProgressResp;
import com.xiaoxve.entity.airesp.TextToImageResp;
import org.springframework.scheduling.annotation.Async;

import java.util.function.Consumer;

public interface TextToImageService {
    // 同步文本生图片
    TextToImageResp synTextToImage(TextToImageReq req);
    // 异步文本生图片

    @Async
    void asynTextToImage(TextToImageReq req, Consumer<TextToImageResp> callbackTask);
    @Async
    void asynTextToImage(TextToImageReq req, String callbackUrl);

    // 获取图片生成结果
    ProgressResp getTextToImageProgress(String taskId);

}
