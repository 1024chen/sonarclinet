package com.chen01.sonarclient.service;

import com.chen01.sonarclient.model.response.translator.TranslatorResponseBo;
import com.chen01.sonarclient.util.HttpRequestUtil;
import com.chen01.sonarclient.util.TranslatorUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TranslatorService {
    @Value("${translator.url}")
    private String translatorUrl;
    @Resource
    private TranslatorUtil translatorUtil;

    @Resource
    private HttpRequestUtil httpRequestUtil;

    public TranslatorResponseBo getTransResult(String sourceText){
        return httpRequestUtil.postTheTranslator(translatorUrl,
                translatorUtil.generatorEnglishRequestModel(sourceText));
    }
}
