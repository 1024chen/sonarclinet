package com.chen01.sonarclient.service;

import com.chen01.sonarclient.model.request.rules.RulesSearch;
import com.chen01.sonarclient.model.request.rules.RulesShow;
import com.chen01.sonarclient.model.response.rules.RulesSearchResponseBo;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RuleServiceTest {

    @Resource
    private RuleService ruleService;

    @Value("${file.location}")
    private String location;
    @Value("${file.filename}")
    private String fileName;

    @Test
    void showRules() {
        RulesShow rulesShow = RulesShow.builder().actives("true").key("java:S1215").build();
        String rule = ruleService.showRules(rulesShow);
        Assertions.assertNotNull(rule);
        System.out.println(rule);
    }

    @Test
    void searchRules() {
        RulesSearch rulesSearch = RulesSearch.builder()
                .languages("java")
                .ps("500")
                .repositories("").build();
        RulesSearchResponseBo rulesSearchResponseBo = ruleService.searchRules(rulesSearch);
        System.out.println(rulesSearchResponseBo);
        Assertions.assertEquals(1, rulesSearchResponseBo.getP());
    }

    @Test
    void searchRulesAndTransExcel() {
        RulesSearch rulesSearch = RulesSearch.builder()
                .languages("java")
                .ps("500")
                .repositories("").build();
        String fileFullPath = location + rulesSearch.getLanguages() + fileName;
        ruleService.searchRulesAndTransExcel(rulesSearch, fileFullPath);
    }
}