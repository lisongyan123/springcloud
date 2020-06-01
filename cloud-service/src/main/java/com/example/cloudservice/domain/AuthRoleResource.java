package com.example.cloudservice.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * auth_role_resource
 * @author 
 */
@Data
public class AuthRoleResource implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 资源ID
     */
    private Integer resourceId;

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