package com.xiaoxve.entity.airesp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Base64;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class ProgressResp {

    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("queued")
    private Boolean queued;
    @JsonProperty("completed")
    private Boolean completed;
    @JsonProperty("progress")
    private Double progress;
    @JsonProperty("eta")
    private Double eta;
    @JsonProperty("live_preview")
    private String livePreview;
    @JsonProperty("id_live_preview")
    private Integer idLivePreview;
    @JsonProperty("textinfo")
    private String textinfo;

    public boolean hasLivePreview(){
        return livePreview != null&& !livePreview.isEmpty();
    }
    public String getBase64Str(){
        if (hasLivePreview()) {
            return livePreview.split(",")[1];
        }else{
            throw new RuntimeException("没有预览图片");
        }
    }
    public byte[] getBytes(){
        return Base64.getDecoder().decode(getBase64Str());
    }
}
