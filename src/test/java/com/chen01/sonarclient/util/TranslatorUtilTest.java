package com.chen01.sonarclient.util;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class TranslatorUtilTest {
    @Resource
    private TranslatorUtil translatorUtil;

    @Test
    void generatorEnglishRequestModel() {
        System.out.println(translatorUtil.generatorSignalEnglishRequestModel("test source text"));
        Assertions.assertEquals("test source text", translatorUtil.generatorSignalEnglishRequestModel("test source text").getQ());
    }

    @Test
    void generatorBatchEnglishRequestModel(){
        List<String> wordList = Arrays.asList("test","touch me","just kidding",
                "I use the java language to develop programs");
        System.out.println(translatorUtil.generatorBatchEnglishRequestModel(wordList));
    }
}