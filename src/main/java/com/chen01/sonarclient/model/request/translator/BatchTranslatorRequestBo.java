package com.chen01.sonarclient.model.request.translator;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BatchTranslatorRequestBo {
    //待翻译文本
    private List<String> q;
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
    //翻译结果音频格式，支持mp3
    private String ext;
    //翻译结果发音选择 0为女声，1为男声。默认为女声
    private String voice;
    //v3
    private String signType;
    //TimeStamp
    private String curtime;
    //用户上传的词典ID
    private String vocabId;
    //语言检测粒度描述。影响翻译时i字段的内容合并做语言检测，还是分别进行检测；取值为0或1，取值为0时合并检测，取值为1时分别检测
    private String detectLevel;
    //是否进行语种检测,当判定为非必要翻译时返回原文，true：进行过滤，false：不过滤
    private String detectFilter;
    //	是否对语言方向进行二次核实。当用户不确定传入的参数是否正确时，
    //	可将该参数置为true，表示需要进行二次核实，系统将额外返回一个检测到的核实结果.默认为false
    private String verifyLang;
}
