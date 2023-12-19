package com.chen01.sonarclient.model;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SonarTest {

    @Resource
    private Sonar sonar;

    @Test
    void testToString() {
        Assertions.assertNotNull(sonar.toString());
    }
}