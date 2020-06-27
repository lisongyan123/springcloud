package com.example.cloudservice.config.shiro.provider;

import com.example.cloudservice.domain.vo.Account;

/**
 *    数据库用户密码账户提供
 */
public interface AccountProvider {

    /**
     * description 数据库用户密码账户提供
     */
    Account loadAccount(String appId);

}
