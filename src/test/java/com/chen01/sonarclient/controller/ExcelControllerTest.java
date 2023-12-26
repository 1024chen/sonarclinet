package com.chen01.sonarclient.controller;

import com.chen01.sonarclient.model.request.rules.RulesSearch;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExcelControllerTest {

    @Resource
    private ExcelController excelController;

    @Value("${file.location}")
    private String location;
    @Value("${file.filename}")
    private String fileName;

    @Value("${file.sheet-name}")
    private String sheetName;

    @Test
    void searchRulesToExcel() {
        RulesSearch rulesSearch = RulesSearch.builder().languages("java").build();
        excelController.searchRulesToExcel(
                rulesSearch,
                location + rulesSearch.getLanguages() + fileName,
                sheetName);
    }

    @Test
    void searchToExcelByRules() {
        RulesSearch rulesSearch = RulesSearch.builder()
                .activation("true")
                .languages("java")
                .qprofile("AYyAyl_jyrjuJxKzWNBJ").build();
        excelController.searchToExcelByRules(
                rulesSearch,
                location + rulesSearch.getLanguages() + fileName,
                sheetName
        );
    }

    @Test
    void searchAllJavaRulesToExcel() {
        RulesSearch rulesSearch = RulesSearch.builder().languages("java").build();
        excelController.searchToExcelByRules(
                rulesSearch,
                location + rulesSearch.getLanguages() + fileName,
                sheetName
        );
    }
}