package com.chen01.sonarclient.model.response.translator;

import lombok.Data;

import java.util.List;

@Data
public class TranslatorSignalResponseBo {
    private String errorCode;
    private String query;
    private String isDomainSupport;
    private List<String> translation;
    private Object basic;
    private List<Object> web;
    private Object dict;
    private Object webdict;
    private String l;
    private String tSpeakUrl;
    private String speakUrl;
    private List<Object> returnPhrase;
}
