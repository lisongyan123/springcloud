package com.example.cloudservice.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class AuthRole implements Serializable {
    /**
     * 角色ID
     */
    private Integer id;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 状态   1:正常、9：禁用
     */
    private Short status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}