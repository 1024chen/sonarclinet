package com.chen01.sonarclient.service;

import com.chen01.sonarclient.model.request.languages.LanguageList;
import com.chen01.sonarclient.model.response.languages.LanguageListResponseBo;
import com.chen01.sonarclient.util.HttpRequestUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LanguageService {
    @Resource
    private HttpRequestUtil httpRequestUtil;

    public LanguageListResponseBo listLanguages(LanguageList languageList){
        String uri = "/api/languages/list";
        return (LanguageListResponseBo) httpRequestUtil.getTheSonarGetResponse(languageList, LanguageListResponseBo.class,uri);
    }
}
