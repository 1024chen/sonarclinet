package com.chen01.sonarclient.model.response.translator;

import lombok.Data;

@Data
public class TranslateResult {
    private String query;
    private String translation;
    private String type;
    private String verifyResult;
}
