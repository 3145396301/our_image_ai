package com.example.text_to_image.service;

import com.xiaoxve.entity.aireq.TextToImageReq;
import com.xiaoxve.entity.airesp.TextToImageResp;

public interface TextToImageService {
    // 同步文本生图片
    TextToImageResp synTextToImage(TextToImageReq req);
    // 异步文本生图片
    boolean asynTextToImage(TextToImageReq req);
    // 获取图片生成结果
    TextToImageResp getTextToImageResp(String taskId);

}
