package com.chen01.sonarclient.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@Slf4j
public class HttpUtil {
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private ObjectMapper objectMapper;

    public Object getTheUriResponse(Object object, Class<?> cls, String uri) {
        Map<String, String> map = objectMapper.convertValue(object, Map.class);
        StringBuilder stringBuilder = new StringBuilder(uri);
        stringBuilder.append("?");
        map.forEach((key, value) -> {
            if (StringUtils.isNotEmpty(value)) {
                stringBuilder.append(key)
                        .append("={")
                        .append(key)
                        .append("}&");
            }
        });
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return restTemplate.getForObject(stringBuilder.toString(), cls, map);
    }
}
