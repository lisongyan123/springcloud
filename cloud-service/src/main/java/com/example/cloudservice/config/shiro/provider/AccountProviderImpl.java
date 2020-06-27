package com.example.cloudservice.config.shiro.provider;

import com.example.cloudservice.domain.vo.Account;
import com.example.cloudservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AccountProviderImpl implements AccountProvider {

    @Autowired
    private AccountService accountService;

    @Override
    public Account loadAccount(String appId) {
        return accountService.loadAccount(appId);
    }
}