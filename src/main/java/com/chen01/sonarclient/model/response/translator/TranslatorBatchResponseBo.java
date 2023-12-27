package com.chen01.sonarclient.model.response.translator;

import lombok.Data;

import java.util.List;

@Data
public class TranslatorBatchResponseBo {
    private String errorCode;
    private List<Object> errorIndex;
    private List<TranslateResult> translateResults;
}
