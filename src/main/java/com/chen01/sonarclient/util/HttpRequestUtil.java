package com.chen01.sonarclient.util;

import com.chen01.sonarclient.model.request.translator.TranslatorRequestBo;
import com.chen01.sonarclient.model.response.translator.TranslatorResponseBo;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@Slf4j
public class HttpRequestUtil {
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private ObjectMapper objectMapper;

    public Object getTheSonarGetResponse(Object object, Class<?> cls, String uri) {
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

    public TranslatorResponseBo postTheTranslator(String uri, TranslatorRequestBo data) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        Map<String, String> beforeFilterMap = objectMapper.convertValue(data, Map.class);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        beforeFilterMap.forEach((k, v) -> {if (v != null) {map.add(k, v);}});
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, httpHeaders);
        RestTemplate template = new RestTemplate();
        return template.postForObject(uri, request, TranslatorResponseBo.class);
    }
}