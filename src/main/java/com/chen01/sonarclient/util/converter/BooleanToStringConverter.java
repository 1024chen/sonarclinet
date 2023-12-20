package com.chen01.sonarclient.util.converter;

import com.alibaba.excel.converters.Converter;

public class BooleanToStringConverter implements Converter<Boolean> {

    public String convertToExcelData(Boolean value) {
        return value ? "是" : "否";
    }

    public Boolean convertToJavaData(String value) {
        return "是".equals(value);
    }
}
