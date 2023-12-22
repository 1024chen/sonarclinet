package com.chen01.sonarclient.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JsonNodeTest {

    @Resource
    private ObjectMapper mapper;

    @Test
    public void arrayJsonNodeTest(){
        String json = "[{\"name\":\"Tom\",\"age\":20},{\"name\":\"Jerry\",\"age\":22}]";
        try {
            List<Object> users = mapper.readValue(json, new TypeReference<List<Object>>() {});
            System.out.println(users);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
