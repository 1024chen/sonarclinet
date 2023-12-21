package com.chen01.sonarclient.service;

import com.chen01.sonarclient.model.request.rules.RulesSearch;
import com.chen01.sonarclient.model.request.rules.RulesShow;
import com.chen01.sonarclient.model.response.rules.Paging;
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

    @Test
    void pageTotal(){
        Paging paging = new Paging();
        paging.setPageIndex(1);
        paging.setPageSize(100);
        paging.setTotal(629);
        Assertions.assertEquals(7,ruleService.pageTotal(paging));
    }

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
                .ps("100")
                .p("1")
                .build();
        RulesSearchResponseBo rulesSearchResponseBo = ruleService.searchRules(rulesSearch);
        System.out.println(rulesSearchResponseBo);
        Assertions.assertEquals(1, rulesSearchResponseBo.getP());
    }
}