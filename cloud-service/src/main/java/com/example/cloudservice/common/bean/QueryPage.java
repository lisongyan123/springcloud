package com.example.cloudservice.common.bean;

import com.example.cloudservice.common.helper.StringHelper;
import lombok.Data;

/**
 * 分页查询
 */
@Data
public class QueryPage {
    /**
     * 当前记录起始索引
     */
    private Integer pageNum;
    /**
     * 每页显示记录数
     */
    private Integer pageSize;
    /**
     * 排序列
     */
    private String orderByColumn;
    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    private String isAsc;

    public String getOrderBy() {
        if (StringHelper.isEmpty(orderByColumn)) {
            return "";
        }
        return orderByColumn + " " + isAsc;
    }
}
