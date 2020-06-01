package com.example.cloudservice.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * auth_user_role
 * @author 
 */
@Data
public class AuthUserRole implements Serializable {
    /**
     * 用户角色关联表主键
     */
    private Integer id;

    /**
     * 用户UID
     */
    private String userId;

    /**
     * 角色ID
     */
    private Integer roleId;

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