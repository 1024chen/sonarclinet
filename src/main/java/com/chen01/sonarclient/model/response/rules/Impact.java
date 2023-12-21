package com.chen01.sonarclient.model.response.rules;

import lombok.Data;

@Data
public class Impact {
//    软件质量 安全、可靠性、可维护性
    private String softwareQuality;
//    严重性 高、中、低
    private String severity;
}
