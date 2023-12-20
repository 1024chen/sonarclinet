package com.chen01.sonarclient.model.request.rules;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RulesSearch {
    private String activation;
    private String asc;
    private String available_since;
    private String cleanCodeAttributeCategories;
    private String cwe;
    private String f;
    private String facets;
    private String impactSeverities;
    private String impactSoftwareQualities;
    private String include_external;
    private String inheritance;
    private String is_template;
    private String languages;
    private String owaspTop10;
    private String p;
    private String ps;
    private String q;
    private String qprofile;
    private String repositories;
    private String rule_key;
    private String s;
    private String sonarsourceSecurity;
    private String statuses;
    private String tags;
    private String template_key;
}
