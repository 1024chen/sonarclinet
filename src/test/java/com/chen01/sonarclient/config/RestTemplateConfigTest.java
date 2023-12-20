package com.chen01.sonarclient.config;

import com.chen01.sonarclient.model.response.SystemResponseBo;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@SpringBootTest
class RestTemplateConfigTest {

    @Resource
    RestTemplate restTemplate;

    @Test
    void ping() {
        Assertions.assertEquals("pong",restTemplate.getForObject("/api/system/ping", String.class));
    }

    @Test
    void status() {
        System.out.println(Objects.requireNonNull(restTemplate.getForObject("/api/system/status", SystemResponseBo.class)));
    }
}