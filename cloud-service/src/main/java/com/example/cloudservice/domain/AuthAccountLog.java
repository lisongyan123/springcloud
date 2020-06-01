package com.example.cloudservice.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * auth_account_log
 * @author 
 */
@Data
public class AuthAccountLog implements Serializable {
    /**
     * 用户账户操作日志主键
     */
    private Integer id;

    /**
     * 日志名称(login,register,logout)
     */
    private String logName;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否执行成功(0失败1成功)
     */
    private Byte succeed;

    /**
     * 具体消息
     */
    private String message;

    /**
     * 登录ip
     */
    private String ip;

    private static final long serialVersionUID = 1L;
}