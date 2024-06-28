package com.example.text_to_image.controller;

import com.example.text_to_image.service.TextToImageService;
import com.xiaoxve.entity.aireq.TextToImageReq;
import com.xiaoxve.entity.airesp.ProgressResp;
import com.xiaoxve.entity.airesp.TextToImageResp;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class TextToImageController {

    @Resource
    private TextToImageService textToImageService;
    @PostMapping("/syn/text-to-image")
    public TextToImageResp textToImage(@RequestBody TextToImageReq textToImageReq) {
        return textToImageService.synTextToImage(textToImageReq);
    }

    @PostMapping("/asyn/text-to-image/{callbackUrl}")
    public void asynTextToImage(@RequestBody TextToImageReq textToImageReq, @PathVariable("callbackUrl") String callbackUrl) {
        textToImageService.asynTextToImage(textToImageReq, callbackUrl);
    }

    @GetMapping("/progress/text-to-image/{taskId}")
    public ProgressResp progressTextToImage(@PathVariable("taskId") String taskId) {
        return textToImageService.getTextToImageProgress(taskId);
    }
}