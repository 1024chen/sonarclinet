package com.chen01.sonarclient.service;

import com.chen01.sonarclient.model.request.rules.RulesSearch;
import com.chen01.sonarclient.model.request.rules.RulesShow;
import com.chen01.sonarclient.model.response.rules.RulesSearchResponseBo;
import com.chen01.sonarclient.util.HttpUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RuleService {

    @Resource
    private HttpUtil httpUtil;

    public String showRules(RulesShow rulesShow) {
        String uri = "/api/rules/show?";
        return (String) httpUtil.createGetUrl(rulesShow, String.class,uri);
    }

    public RulesSearchResponseBo searchRules(RulesSearch rulesSearch) {
        String uri = "/api/rules/search?";
        return (RulesSearchResponseBo) httpUtil.createGetUrl(rulesSearch, RulesSearchResponseBo.class,uri);
    }

    /**
     * 搜索规则并转换为Excel
     * @return 是否转换完成
     */
    public boolean searchRulesAndTransExcel(RulesSearch rulesSearch){
        RulesSearchResponseBo rulesSearchResponseBo = searchRules(rulesSearch);
        //转换为excel
        return true;
    }
}
