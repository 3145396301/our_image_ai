package com.example.text_to_image.controller;

import com.example.text_to_image.service.TextToImageService;
import com.xiaoxve.entity.aireq.TextToImageReq;
import com.xiaoxve.entity.airesp.TextToImageResp;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextToImageController {
    @Resource
    private TextToImageService textToImageService;
    @PostMapping("text-to-image")
    public TextToImageResp textToImage(@RequestParam(value ="prompt")String prompt,@RequestParam(value ="negativePrompt") String negativePrompt) {
        TextToImageReq textToImageReq = new TextToImageReq();
        textToImageReq.setPrompt(prompt)
                .setNegativePrompt(negativePrompt)
                .setSteps(20)
                .setWidth(512)
                .setHeight(768);
        return textToImageService.synTextToImage(textToImageReq);
    }
}
