package com.example.cloudservice.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * auth_user
 * @author 
 */
@Data
public class AuthUser implements Serializable {
    /**
     * uid,用户账号,主键
     */
    private String uid;

    /**
     * 用户名(nick_name)
     */
    private String username;

    /**
     * 密码(MD5(密码+盐))
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 用户真名
     */
    private String realName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 电话号码(唯一)
     */
    private String phone;

    /**
     * 邮件地址(唯一)
     */
    private String email;

    /**
     * 性别(1.男 2.女)
     */
    private Byte sex;

    /**
     * 账户状态(1.正常 2.锁定 3.删除 4.非法)
     */
    private Byte status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建来源(1.web 2.android 3.ios 4.win 5.macos 6.ubuntu)
     */
    private Byte createWhere;

    private static final long serialVersionUID = 1L;
}