package com.example.text_to_image.service.impl;

import com.example.text_to_image.service.TextToImageService;
import com.xiaoxve.entity.aireq.TextToImageReq;
import com.xiaoxve.entity.airesp.ProgressResp;
import com.xiaoxve.entity.airesp.TextToImageResp;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import static java.lang.Thread.sleep;

@SpringBootTest
public class TextToImageServiceImplTest {
    @Resource
    private TextToImageService textToImageService;

    @Test
    public void testSynTextToImage() throws IOException {
        String prompt = "a cat";
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

    @Test
    public void testAsynTextToImage() throws IOException, InterruptedException {
        String prompt = "a cat";
        String negativePrompt = "";
        int width = 1024;
        int height = 1024;
        int steps = 30;
        TextToImageReq textToImageReq = new TextToImageReq().setPrompt(prompt)
                .setNegativePrompt(negativePrompt)
                .setWidth(width)
                .setHeight(height)
                .setSteps(steps)
                .setForceTaskId("123456789");
        textToImageService.asynTextToImage(textToImageReq, (textToImageResp) -> {
            try {
                System.out.println("异步任务完成");
                FileOutputStream fileOutputStream = new FileOutputStream("textToIamgeTestIamge.png");
                fileOutputStream.write(Base64.getDecoder().decode(textToImageResp.getImages().get(0)));
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println("异步发送完成");
        sleep(100000);
    }

    @Test
    public void testGetTextToImageResp() throws IOException {
        String taskId = "123456789";
        ProgressResp textToImageProgress = textToImageService.getTextToImageProgress(taskId);
        if (textToImageProgress.hasLivePreview()) {
            FileOutputStream fileOutputStream = new FileOutputStream("progressTestImage.png");
            fileOutputStream.write(textToImageProgress.getBytes());
            fileOutputStream.close();
        }
        System.out.println(textToImageProgress);

    }


}
