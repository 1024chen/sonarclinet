package com.chen01.sonarclient.model.response.rules;

import lombok.Data;

import java.util.List;

@Data
public class SignalRule {
    private String key;
    private String repo;
    private String name;
    private String createdAt;
    private String htmlDesc;
    private String mdDesc;
    private String severity;
    private String status;
    private boolean isTemplate;
    private List<Object> tags;
    private List<String> sysTags;
    private String lang;
    private String langName;
    private List<Object> params;
    private String defaultDebtRemFnType;
    private String debtRemFnType;
    private String type;
    private String defaultRemFnType;
    private String defaultRemFnBaseEffort;
    private String remFnType;
    private String remFnBaseEffort;
    private boolean remFnOverloaded;
    private String scope;
    private boolean isExternal;
    private List<DescriptionSection> descriptionSections;
    private List<Object> educationPrinciples;
    private String updatedAt;
    private String cleanCodeAttribute;
    private String cleanCodeAttributeCategory;
    private List<Impact> impacts;
}
