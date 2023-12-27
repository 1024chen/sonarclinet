package com.chen01.sonarclient.model.request.translator;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignalTranslatorRequestBo {
    //待翻译文本
    private String q;
    //源语言
    private String from;
    //目标语言
    private String to;
    //应用ID
    private String appKey;
    //UUID
    private String salt;
    //签名 sha256(应用ID+input+salt+curtime+应用密钥)
    private String sign;
    //v3
    private String signType;
    //TimeStamp
    private String curtime;
    //翻译结果音频格式，支持mp3
    private String ext;
    //翻译结果发音选择 0为女声，1为男声。默认为女声
    private String voice;
    //是否严格按照指定from和to进行翻译：true/false
    private String strict;
    //用户上传的词典
    private String vocabId;
    //领域化翻译
    private String domain;
    //拒绝领域化翻译降级-当领域化翻译失败时改为通用翻译
    private String rejectFallback;
}
