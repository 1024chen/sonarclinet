package com.chen01.sonarclient.model.request.languages;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LanguageList {
    private String ps;
    private String q;
}
