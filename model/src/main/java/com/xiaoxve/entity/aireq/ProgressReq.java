package com.xiaoxve.entity.aireq;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProgressReq {
    @JsonProperty("id_task")
    private String idTask;
    @JsonProperty("id_live_preview")
    private Integer idLivePreview;
    @JsonProperty("live_preview")
    private Boolean livePreview;
}
