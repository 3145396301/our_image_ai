package com.xiaoxve.entity.airesp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@Data
public class TextToImageResp {

    @JsonProperty("images")
    private List<String> images;
    @JsonProperty("parameters")
    private HashMap<String, Object> parameters;
    @JsonProperty("info")
    private String info;
    @JsonProperty("detail")
    private List<DetailBean> detail;


    @NoArgsConstructor
    @Data
    public static class DetailBean {
        @JsonProperty("loc")
        private List<String> loc;
        @JsonProperty("msg")
        private String msg;
        @JsonProperty("type")
        private String type;
    }
}
