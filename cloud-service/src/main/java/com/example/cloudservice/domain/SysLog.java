package com.example.cloudservice.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class SysLog implements Serializable {
    /**
     * 唯一ID
     */
    private Integer id;

    /**
     * 操作用户id
     */
    private Integer optId;

    /**
     * 操作用户名
     */
    private String optName;

    /**
     * 日志类型
     */
    private String logType;

    /**
     * 日志信息（具体方法名）
     */
    private String logMessage;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}