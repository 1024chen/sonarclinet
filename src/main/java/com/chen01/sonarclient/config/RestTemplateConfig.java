package com.chen01.sonarclient.config;

import com.chen01.sonarclient.model.Sonar;
import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Resource
    private RestTemplateBuilder restTemplateBuilder;

    @Resource
    private Sonar sonar;

    @ConditionalOnMissingBean(RestTemplate.class)
    @Bean
    public RestTemplate getRestTemplate() {
        return restTemplateBuilder
                .rootUri(sonar.getUrl()).basicAuthentication(sonar.getUsername(), sonar.getPassword())
                .build();
    }
}
