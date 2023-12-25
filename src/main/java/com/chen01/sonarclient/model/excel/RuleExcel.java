package com.chen01.sonarclient.model.excel;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.converters.booleanconverter.BooleanStringConverter;
import com.chen01.sonarclient.model.response.rules.DescriptionSection;
import com.chen01.sonarclient.model.response.rules.Impact;
import com.chen01.sonarclient.model.response.rules.SignalRule;
import lombok.Data;

import java.util.List;

@ExcelIgnoreUnannotated
@Data
@ColumnWidth(20)
public class RuleExcel {

    @ExcelProperty("规则键")
    private String key;
    @ExcelProperty("所在库")
    private String repo;
    @ExcelProperty("规则名称")
    private String name;
    @ExcelProperty("创建时间")
    private String createdAt;
    @ExcelProperty("HTML描述")
    private String htmlDesc;
    @ExcelProperty("markdown描述")
    private String mdDesc;
    @ExcelProperty("严重性")
    private String severity;
    @ExcelProperty("状态")
    private String status;
    @ExcelProperty("是否模板")
    private String isTemplate;
    //    @ExcelProperty("标签")
    private List<Object> tags;
    @ExcelProperty("系统标签")
    private String sysTags;
    //    @ExcelProperty("语言")
    private String lang;
    @ExcelProperty("语言")
    private String langName;
    @ExcelProperty("参数列表")
    private String params;
    @ExcelProperty("defaultDebtRemFnType")
    private String defaultDebtRemFnType;
    @ExcelProperty("debtRemFnType")
    private String debtRemFnType;
    @ExcelProperty("类型")
    private String type;
    @ExcelProperty("defaultRemFnType")
    private String defaultRemFnType;
    @ExcelProperty("defaultRemFnBaseEffort")
    private String defaultRemFnBaseEffort;
    @ExcelProperty("remFnType")
    private String remFnType;
    @ExcelProperty("影响时间")
    private String remFnBaseEffort;
    @ExcelProperty("remFnOverloaded")
    private String remFnOverloaded;
    @ExcelProperty("作用范围")
    private String scope;
    @ExcelProperty(value = "是否扩展规则")
    private String isExternal;
    @ExcelProperty("描述部分")
    private String descriptionSections;
    @ExcelProperty("educationPrinciples")
    private String educationPrinciples;
    @ExcelProperty("更新时间")
    private String updatedAt;
    @ExcelProperty("整洁代码标签")
    private String cleanCodeAttribute;
    @ExcelProperty("整洁代码属性")
    private String cleanCodeAttributeCategory;
    @ExcelProperty("软件质量")
    private String impactsSoftwareQuality;
    @ExcelProperty("严重性")
    private String impactsSeverity;

    public RuleExcel(SignalRule signalRule) {
        key = signalRule.getKey();
        repo = signalRule.getRepo();
        name = signalRule.getName();
        createdAt = signalRule.getCreatedAt();
        htmlDesc = signalRule.getHtmlDesc();
        mdDesc = signalRule.getMdDesc();
        severity = signalRule.getSeverity();
        status = signalRule.getStatus();
        isTemplate = String.valueOf(signalRule.isTemplate());
        tags = signalRule.getTags();
        StringBuilder stringBuilder = new StringBuilder();
        signalRule.getSysTags().forEach(a -> stringBuilder.append(a).append(","));
        if (!stringBuilder.isEmpty()) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        sysTags = stringBuilder.toString();
        lang = signalRule.getLang();
        langName = signalRule.getLangName();
        params = signalRule.getParams().toString();
        defaultDebtRemFnType = signalRule.getDefaultDebtRemFnType();
        debtRemFnType = signalRule.getDebtRemFnType();
        type = signalRule.getType();
        defaultRemFnType = signalRule.getDefaultRemFnType();
        defaultRemFnBaseEffort = signalRule.getDefaultRemFnBaseEffort();
        remFnType = signalRule.getRemFnType();
        remFnBaseEffort = signalRule.getRemFnBaseEffort();
        remFnOverloaded = String.valueOf(signalRule.isRemFnOverloaded());
        scope = signalRule.getScope();
        isExternal = String.valueOf(signalRule.isExternal());
        descriptionSections = signalRule.getDescriptionSections().toString();
        educationPrinciples = signalRule.getEducationPrinciples().toString();
        updatedAt = signalRule.getUpdatedAt();
        cleanCodeAttribute = signalRule.getCleanCodeAttribute();
        cleanCodeAttributeCategory = signalRule.getCleanCodeAttributeCategory();
        StringBuilder softwareBuilder = new StringBuilder();
        StringBuilder severityBuilder = new StringBuilder();
        signalRule.getImpacts().forEach(a -> {
            softwareBuilder.append(a.getSoftwareQuality()).append(",");
            severityBuilder.append(a.getSeverity()).append(",");
        });
        if (!softwareBuilder.isEmpty()) {
            softwareBuilder.deleteCharAt(softwareBuilder.length() - 1);
        }
        if (!severityBuilder.isEmpty()) {
            severityBuilder.deleteCharAt(severityBuilder.length() - 1);
        }
        impactsSoftwareQuality = softwareBuilder.toString();
        impactsSeverity = severityBuilder.toString();
    }
}
