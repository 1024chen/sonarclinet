package com.chen01.sonarclient.model.response.rules;

import lombok.Data;

import java.util.List;

@Data
public class RulesSearchResponseBo {
    private int total;
    private int p;
    private int ps;
    private List<SignalRule> rules;
    private Paging paging;
}

