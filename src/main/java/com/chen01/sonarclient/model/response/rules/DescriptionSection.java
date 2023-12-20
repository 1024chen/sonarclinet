package com.chen01.sonarclient.model.response.rules;

import lombok.Data;

@Data
public class DescriptionSection {
    private String key;
    private String content;
    private DescriptionSectionContent context;
}
