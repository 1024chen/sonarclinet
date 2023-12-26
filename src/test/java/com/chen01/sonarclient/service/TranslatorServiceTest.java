package com.chen01.sonarclient.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TranslatorServiceTest {

    @Resource
    private TranslatorService translatorService;

    @Test
    void getTransResult() {
        System.out.println(translatorService.getTransResult("test"));
    }
}