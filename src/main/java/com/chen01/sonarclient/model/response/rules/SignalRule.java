package com.chen01.sonarclient.model.response.rules;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.converters.booleanconverter.BooleanStringConverter;
import lombok.Data;

import java.util.List;

@ExcelIgnoreUnannotated
@Data
@ColumnWidth(20)
public class SignalRule {

    @ExcelProperty("规则键")
    private String key;
    @ExcelProperty("所在库")
    private String repo;
    @ExcelProperty("规则名称")
    private String name;
    @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
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
//    @ExcelProperty("是否模板")
    private boolean isTemplate;
//    @ExcelProperty("标签")
    private List<Object> tags;
//    @ExcelProperty("系统标签")
    private List<String> sysTags;
//    @ExcelProperty("语言")
    private String lang;
    @ExcelProperty("语言")
    private String langName;
//    @ExcelProperty("参数列表")
    private List<Object> params;
//    @ExcelProperty("defaultDebtRemFnType")
    private String defaultDebtRemFnType;
    @ExcelProperty("debtRemFnType")
    private String debtRemFnType;
    @ExcelProperty("类型")
    private String type;
//    @ExcelProperty("defaultRemFnType")
    private String defaultRemFnType;
//    @ExcelProperty("defaultRemFnBaseEffort")
    private String defaultRemFnBaseEffort;
//    @ExcelProperty("remFnType")
    private String remFnType;
    @ExcelProperty("影响时间")
    private String remFnBaseEffort;
//    @ExcelProperty("remFnOverloaded")
    private boolean remFnOverloaded;
    @ExcelProperty("作用范围")
    private String scope;
    @ExcelProperty(value = "是否自定义规则",converter = BooleanStringConverter.class)
    private boolean isExternal;
//    @ExcelProperty("描述部分")
    private List<DescriptionSection> descriptionSections;
//    @ExcelProperty("educationPrinciples")
    private List<Object> educationPrinciples;
    @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
    @ExcelProperty("更新时间")
    private String updatedAt;
//    @ExcelProperty("整洁代码属性")
    private String cleanCodeAttribute;
    @ColumnWidth(20)
    @ExcelProperty("整洁代码属性")
    private String cleanCodeAttributeCategory;
//    @ExcelProperty("影响")
    private List<Impact> impacts;
}
