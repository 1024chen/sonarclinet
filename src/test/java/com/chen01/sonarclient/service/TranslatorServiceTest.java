package com.chen01.sonarclient.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TranslatorServiceTest {

    @Resource
    private TranslatorService translatorService;

    @Test
    void getTransResult() {
        List<String> wordList = Arrays.asList("test","touch me","just kidding",
                "I use the java language to develop programs");
        System.out.println(translatorService.getTransResult(wordList.toString()));
    }
}