package com.chen01.sonarclient.service;

import com.chen01.sonarclient.model.request.rules.RulesSearch;
import com.chen01.sonarclient.model.request.rules.RulesShow;
import com.chen01.sonarclient.model.response.rules.Paging;
import com.chen01.sonarclient.model.response.rules.RulesSearchResponseBo;
import com.chen01.sonarclient.model.response.rules.SignalRule;
import com.chen01.sonarclient.util.HttpRequestUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RuleService {

    @Resource
    private HttpRequestUtil httpRequestUtil;

    public int pageTotal(Paging paging) {
        return 1 + paging.getTotal() / paging.getPageSize();
    }

    public String showRules(RulesShow rulesShow) {
        String uri = "/api/rules/show";
        return (String) httpRequestUtil.getTheSonarGetResponse(rulesShow, String.class, uri);
    }

    public RulesSearchResponseBo searchRules(RulesSearch rulesSearch) {
        String uri = "/api/rules/search";
        return (RulesSearchResponseBo) httpRequestUtil.getTheSonarGetResponse(rulesSearch, RulesSearchResponseBo.class, uri);
    }

    public RulesSearchResponseBo searchAllRules(RulesSearch rulesSearch) {
        RulesSearchResponseBo rulesSearchResponseBo = searchRules(rulesSearch);
        Paging paging = rulesSearchResponseBo.getPaging();
        int pageTotal = pageTotal(paging);
        if (pageTotal > 1) {
            List<SignalRule> rules = rulesSearchResponseBo.getRules();
            for (int i = 1; i <= pageTotal; i++) {
                rulesSearch.setP(String.valueOf(i));
                rules.addAll(searchRules(rulesSearch).getRules());
            }
            rulesSearchResponseBo.setPs(paging.getTotal());
            paging.setPageSize(paging.getTotal());
            rulesSearchResponseBo.setRules(
                    rules.stream().distinct().collect(Collectors.toList())
            );
            rulesSearchResponseBo.setPaging(paging);
        }
        return rulesSearchResponseBo;
    }
}
