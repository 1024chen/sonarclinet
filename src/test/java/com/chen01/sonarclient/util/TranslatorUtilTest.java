package com.chen01.sonarclient.util;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TranslatorUtilTest {
    @Resource
    private TranslatorUtil translatorUtil;

    @Test
    void generatorEnglishRequestModel() {
        System.out.println(translatorUtil.generatorEnglishRequestModel("test source text"));
        Assertions.assertEquals("test source text", translatorUtil.generatorEnglishRequestModel("test source text").getQ());
    }
}