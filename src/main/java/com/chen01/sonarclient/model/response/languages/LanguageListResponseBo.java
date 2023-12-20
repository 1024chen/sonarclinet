package com.chen01.sonarclient.model.response.languages;

import lombok.Data;

import java.util.List;

@Data
public class LanguageListResponseBo {
    private List<SignalLanguage> languages;
}
