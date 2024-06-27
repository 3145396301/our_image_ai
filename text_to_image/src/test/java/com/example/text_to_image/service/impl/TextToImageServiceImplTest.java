package com.example.text_to_image.service.impl;

import com.example.text_to_image.service.TextToImageService;
import com.xiaoxve.entity.aireq.TextToImageReq;
import com.xiaoxve.entity.airesp.TextToImageResp;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

@SpringBootTest
public class TextToImageServiceImplTest {
    @Resource
    private TextToImageService textToImageService;
    @Test
    public void testSynTextToImage() throws IOException {
        String prompt = "一只猫";
        String negativePrompt = "";
        int width = 512;
        int height = 768;
        int steps = 20;
        TextToImageReq textToImageReq = new TextToImageReq().setPrompt(prompt)
                .setNegativePrompt(negativePrompt)
                .setWidth(width)
                .setHeight(height)
                .setSteps(steps);
        TextToImageResp textToImageResp = textToImageService.synTextToImage(textToImageReq);
        FileOutputStream fileOutputStream = new FileOutputStream("textToIamgeTestIamge.png");
        fileOutputStream.write(Base64.getDecoder().decode(textToImageResp.getImages().get(0)));
        fileOutputStream.close();
    }

}
