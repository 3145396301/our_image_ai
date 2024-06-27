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
public class ImageToImageReq {

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
    private Double denoisingStrength;
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
    @JsonProperty("init_images")
    private List<String> initImages;
    @JsonProperty("resize_mode")
    private Integer resizeMode;
    @JsonProperty("image_cfg_scale")
    private Integer imageCfgScale;
    @JsonProperty("mask")
    private String mask;
    @JsonProperty("mask_blur_x")
    private Integer maskBlurX;
    @JsonProperty("mask_blur_y")
    private Integer maskBlurY;
    @JsonProperty("mask_blur")
    private Integer maskBlur;
    @JsonProperty("mask_round")
    private Boolean maskRound;
    @JsonProperty("inpainting_fill")
    private Integer inpaintingFill;
    @JsonProperty("inpaint_full_res")
    private Boolean inpaintFullRes;
    @JsonProperty("inpaint_full_res_padding")
    private Integer inpaintFullResPadding;
    @JsonProperty("inpainting_mask_invert")
    private Integer inpaintingMaskInvert;
    @JsonProperty("initial_noise_multiplier")
    private Integer initialNoiseMultiplier;
    @JsonProperty("latent_mask")
    private String latentMask;
    @JsonProperty("force_task_id")
    private String forceTaskId;
    @JsonProperty("sampler_index")
    private String samplerIndex;
    @JsonProperty("include_init_images")
    private Boolean includeInitImages;
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
