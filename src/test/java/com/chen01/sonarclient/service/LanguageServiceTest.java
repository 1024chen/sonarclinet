package com.chen01.sonarclient.service;

import com.chen01.sonarclient.model.request.languages.LanguageList;
import com.chen01.sonarclient.model.response.languages.LanguageListResponseBo;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LanguageServiceTest {

    @Resource
    LanguageService languageService;
    @Test
    void listLanguages() {
        LanguageListResponseBo listLanguages = languageService.listLanguages(
                LanguageList.builder().q("java").build());
        Assertions.assertNotNull(listLanguages);
        System.out.println(listLanguages);
    }
}