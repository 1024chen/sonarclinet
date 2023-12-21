package com.chen01.sonarclient.service;

import com.chen01.sonarclient.model.request.languages.LanguageList;
import com.chen01.sonarclient.model.response.languages.LanguageListResponseBo;
import com.chen01.sonarclient.util.HttpUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LanguageService {
    @Resource
    private HttpUtil httpUtil;

    public LanguageListResponseBo listLanguages(LanguageList languageList){
        String uri = "/api/languages/list";
        return (LanguageListResponseBo) httpUtil.getTheUriResponse(languageList, LanguageListResponseBo.class,uri);
    }
}
