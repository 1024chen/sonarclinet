package com.chen01.sonarclient.model.response.rules;

import lombok.Data;

@Data
public class Paging {
    private int pageIndex;
    private int pageSize;
    private int total;
}
