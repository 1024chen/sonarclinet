package com.chen01.sonarclient.service;

import com.chen01.sonarclient.model.request.rules.RulesSearch;
import com.chen01.sonarclient.model.request.rules.RulesShow;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RuleServiceTest {

    @Resource
    private RuleService ruleService;

    @Test
    void showRules() {
        RulesShow rulesShow = RulesShow.builder().actives("false").key("javascript:EmptyBlock").build();
        System.out.println(ruleService.showRules(rulesShow));
    }

    @Test
    void searchRules(){
        RulesSearch rulesSearch = RulesSearch.builder().languages("java").build();
        Assertions.assertEquals(1,ruleService.searchRules(rulesSearch).getP());
    }
}