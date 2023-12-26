package com.chen01.sonarclient.controller;

import com.alibaba.excel.EasyExcel;
import com.chen01.sonarclient.model.excel.RuleExcel;
import com.chen01.sonarclient.model.request.rules.RulesSearch;
import com.chen01.sonarclient.model.response.rules.RulesSearchResponseBo;
import com.chen01.sonarclient.model.response.rules.SignalRule;
import com.chen01.sonarclient.model.response.translator.TranslateResult;
import com.chen01.sonarclient.model.response.translator.TranslatorBatchResponseBo;
import com.chen01.sonarclient.service.RuleService;
import com.chen01.sonarclient.service.TranslatorService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class ExcelController {
    @Resource
    private RuleService ruleService;

    @Resource
    private TranslatorService translatorService;

    /**
     * 搜索规则并转换为Excel
     */
    public void searchRulesToExcel(RulesSearch rulesSearch, String fileFullPath, String sheetName) {
        RulesSearchResponseBo rulesSearchResponseBo = ruleService.searchRules(rulesSearch);
        EasyExcel.write(fileFullPath, SignalRule.class)
                .sheet(sheetName)
                .doWrite(rulesSearchResponseBo.getRules());
    }

    /**
     * 搜索所有Java规则并转换为excel
     */
    public void searchToExcelByRules(RulesSearch rulesSearch, String fileFullPath, String sheetName) {
        List<RuleExcel> ruleExcelList = new ArrayList<>();
        ruleService.searchAllRules(rulesSearch)
                .getRules()
                .forEach(a -> ruleExcelList.add(new RuleExcel(a)));
        EasyExcel.write(fileFullPath, RuleExcel.class)
                .sheet(sheetName)
                .doWrite(ruleExcelList);
    }

    public void searchAndSignalTranslateToExcelByRules(RulesSearch rulesSearch, String fileFullPath, String sheetName) {
        List<RuleExcel> ruleExcelList = new ArrayList<>();
        ruleService.searchAllRules(rulesSearch)
                .getRules()
                .forEach(a -> ruleExcelList.add(new RuleExcel(a)));
        ruleExcelList.forEach(a -> {
            if (a.getName() != null) {
                Optional<String> optionalSplicing = translatorService.getSignalTransResult(a.getName())
                        .getTranslation()
                        .stream()
                        .reduce((sa, sb) -> sa + sb);
                optionalSplicing.ifPresent(a::setName);
            }
        });
        EasyExcel.write(fileFullPath, RuleExcel.class)
                .sheet(sheetName)
                .doWrite(ruleExcelList);
    }

    public void searchAndBatchTranslateToExcelByRules(RulesSearch rulesSearch, String fileFullPath, String sheetName) {
        List<RuleExcel> ruleExcelList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        ruleService.searchAllRules(rulesSearch)
                .getRules()
                .forEach(a -> {
                    ruleExcelList.add(new RuleExcel(a));
                    nameList.add(a.getName());
                });
        TranslatorBatchResponseBo translatorBatchResponseBo = translatorService.getBatchTransResult(nameList);
        List<TranslateResult> translateResults;
        if ("0".equals(translatorBatchResponseBo.getErrorCode())
                && nameList.size() == translatorBatchResponseBo.getTranslateResults().size()){
            translateResults = translatorBatchResponseBo.getTranslateResults();
            for (int i = 0; i < nameList.size(); i++) {
                TranslateResult translateResult = translateResults.get(i);
                if (translateResult.getQuery().equals(nameList.get(i))){
                    RuleExcel ruleExcel = ruleExcelList.get(i);
                    ruleExcel.setName(translateResult.getTranslation());
                    ruleExcelList.set(i,ruleExcel);
                }
            }
        }else {
            log.error("翻译失败:{}",translatorBatchResponseBo.getErrorCode());
        }
        EasyExcel.write(fileFullPath, RuleExcel.class)
                .sheet(sheetName)
                .doWrite(ruleExcelList);
    }
}
