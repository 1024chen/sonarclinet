package com.chen01.sonarclient.model.request.rules;

import lombok.Data;

@Data
public class RulesCreate {
    private String customKey;
    private String markdownDescription;
    private String name;
    private String params;
    private String preventReactivation;
    private String severity;
    private String status;
    private String templateKey;
    private String type;
}
