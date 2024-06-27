package com.xiaoxve.entity.aireq;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@NoArgsConstructor
@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TextToImageReq {

    @JsonProperty("prompt")
    private String prompt;
    @JsonProperty("negative_prompt")
    private String negativePrompt;
    @JsonProperty("styles")
    private List<String> styles;
    @JsonProperty("seed")
    private Integer seed;
    @JsonProperty("subseed")
    private Integer subseed;
    @JsonProperty("subseed_strength")
    private Integer subseedStrength;
    @JsonProperty("seed_resize_from_h")
    private Integer seedResizeFromH;
    @JsonProperty("seed_resize_from_w")
    private Integer seedResizeFromW;
    @JsonProperty("sampler_name")
    private String samplerName;
    @JsonProperty("scheduler")
    private String scheduler;
    @JsonProperty("batch_size")
    private Integer batchSize;
    @JsonProperty("n_iter")
    private Integer nIter;
    @JsonProperty("steps")
    private Integer steps;
    @JsonProperty("cfg_scale")
    private Integer cfgScale;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("restore_faces")
    private Boolean restoreFaces;
    @JsonProperty("tiling")
    private Boolean tiling;
    @JsonProperty("do_not_save_samples")
    private Boolean doNotSaveSamples;
    @JsonProperty("do_not_save_grid")
    private Boolean doNotSaveGrid;
    @JsonProperty("eta")
    private Integer eta;
    @JsonProperty("denoising_strength")
    private Integer denoisingStrength;
    @JsonProperty("s_min_uncond")
    private Integer sMinUncond;
    @JsonProperty("s_churn")
    private Integer sChurn;
    @JsonProperty("s_tmax")
    private Integer sTmax;
    @JsonProperty("s_tmin")
    private Integer sTmin;
    @JsonProperty("s_noise")
    private Integer sNoise;
    @JsonProperty("override_settings")
    private OverrideSettingsBean overrideSettings;
    @JsonProperty("override_settings_restore_afterwards")
    private Boolean overrideSettingsRestoreAfterwards;
    @JsonProperty("refiner_checkpoint")
    private String refinerCheckpoint;
    @JsonProperty("refiner_switch_at")
    private Integer refinerSwitchAt;
    @JsonProperty("disable_extra_networks")
    private Boolean disableExtraNetworks;
    @JsonProperty("firstpass_image")
    private String firstpassImage;
    @JsonProperty("comments")
    private CommentsBean comments;
    @JsonProperty("enable_hr")
    private Boolean enableHr;
    @JsonProperty("firstphase_width")
    private Integer firstphaseWidth;
    @JsonProperty("firstphase_height")
    private Integer firstphaseHeight;
    @JsonProperty("hr_scale")
    private Integer hrScale;
    @JsonProperty("hr_upscaler")
    private String hrUpscaler;
    @JsonProperty("hr_second_pass_steps")
    private Integer hrSecondPassSteps;
    @JsonProperty("hr_resize_x")
    private Integer hrResizeX;
    @JsonProperty("hr_resize_y")
    private Integer hrResizeY;
    @JsonProperty("hr_checkpoint_name")
    private String hrCheckpointName;
    @JsonProperty("hr_sampler_name")
    private String hrSamplerName;
    @JsonProperty("hr_scheduler")
    private String hrScheduler;
    @JsonProperty("hr_prompt")
    private String hrPrompt;
    @JsonProperty("hr_negative_prompt")
    private String hrNegativePrompt;
    @JsonProperty("force_task_id")
    private String forceTaskId;
    @JsonProperty("sampler_index")
    private String samplerIndex;
    @JsonProperty("script_name")
    private String scriptName;
    @JsonProperty("script_args")
    private List<?> scriptArgs;
    @JsonProperty("send_images")
    private Boolean sendImages;
    @JsonProperty("save_images")
    private Boolean saveImages;
    @JsonProperty("alwayson_scripts")
    private AlwaysonScriptsBean alwaysonScripts;
    @JsonProperty("infotext")
    private String infotext;

    @NoArgsConstructor
    @Data
    public static class OverrideSettingsBean {
    }

    @NoArgsConstructor
    @Data
    public static class CommentsBean {
    }

    @NoArgsConstructor
    @Data
    public static class AlwaysonScriptsBean {
    }
}
