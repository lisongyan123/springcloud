package com.example.cloudservice.service.impl;

import com.example.cloudservice.dao.AuthUserDao;
import com.example.cloudservice.domain.AuthUser;
import com.example.cloudservice.domain.vo.Account;
import com.example.cloudservice.service.AccountService;
import com.example.cloudservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AuthUserDao userMapper;

    @Autowired
    private UserService userService;

    @Override
    public Account loadAccount(String appId) throws DataAccessException {
        AuthUser user = userMapper.selectByPrimaryKey(appId);
        return user != null ? new Account(user.getUsername(),user.getPassword(),user.getSalt()) : null;
    }

    @Override
    public boolean isAccountExistByUid(String uid) {
        AuthUser user = userMapper.selectByPrimaryKey(uid);
        return user != null ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public boolean registerAccount(AuthUser account) throws DataAccessException {
        // 给新用户授权访客角色
        userService.authorityUserRole(account.getUid(),103);
        return userMapper.insertSelective(account) ==1 ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public String loadAccountRole(String appId) throws DataAccessException {
        return userMapper.selectUserRoles(appId);
    }


}
