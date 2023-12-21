package com.chen01.sonarclient.controller;

import com.alibaba.excel.EasyExcel;
import com.chen01.sonarclient.model.request.rules.RulesSearch;
import com.chen01.sonarclient.model.response.rules.RulesSearchResponseBo;
import com.chen01.sonarclient.model.response.rules.SignalRule;
import com.chen01.sonarclient.service.RuleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller
public class ExcelController {
    @Resource
    private RuleService ruleService;

    /**
     * 搜索规则并转换为Excel
     */
    public void searchRulesToExcel(RulesSearch rulesSearch, String fileFullPath,String sheetName) {
        RulesSearchResponseBo rulesSearchResponseBo = ruleService.searchRules(rulesSearch);
        EasyExcel.write(fileFullPath, SignalRule.class)
                .sheet(sheetName)
                .doWrite(rulesSearchResponseBo.getRules());
    }

    /**
     * 搜索所有Java规则并转换为excel
     */
    public void searchAllJavaRulesToExcel(String fileFullPath,String sheetName){
        EasyExcel.write(fileFullPath, SignalRule.class)
                .sheet(sheetName)
                .doWrite(ruleService.searchAllRules(
                        RulesSearch.builder().languages("java").build()
                ).getRules());
    }
}
