package com.chen01.sonarclient.service;

import com.chen01.sonarclient.model.response.translator.TranslatorBatchResponseBo;
import com.chen01.sonarclient.model.response.translator.TranslatorSignalResponseBo;
import com.chen01.sonarclient.util.HttpRequestUtil;
import com.chen01.sonarclient.util.TranslatorUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranslatorService {
    @Value("${translator.signalUrl}")
    private String signalUrl;
    @Value("${translator.batchUrl}")
    private String batchUrl;
    @Resource
    private TranslatorUtil translatorUtil;

    @Resource
    private HttpRequestUtil httpRequestUtil;

    public TranslatorSignalResponseBo getSignalTransResult(String sourceText){
        return httpRequestUtil.postTheSignalTranslator(signalUrl,
                translatorUtil.generatorSignalEnglishRequestModel(sourceText));
    }

    public TranslatorBatchResponseBo getBatchTransResult(List<String> sourceTextList){
        return httpRequestUtil.postTheBatchTranslator(batchUrl,
                translatorUtil.generatorBatchEnglishRequestModel(sourceTextList));
    }

    public String translationSignalText(String sourceText){
        return getSignalTransResult(sourceText).getTranslation().get(0);
    }
}
