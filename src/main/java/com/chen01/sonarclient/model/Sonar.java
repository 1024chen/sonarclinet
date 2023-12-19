package com.chen01.sonarclient.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Sonar {

    @Value("${sonar.url}")
    private String url;
    @Value("${sonar.username}")
    private String username;
    @Value("${sonar.password}")
    private String password;
}
