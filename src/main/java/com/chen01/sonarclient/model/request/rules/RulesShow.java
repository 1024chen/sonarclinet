package com.chen01.sonarclient.model.request.rules;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RulesShow {
    private String actives;
    private String key;
}
