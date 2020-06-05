package com.example.cloudservice.service.impl;

import com.example.cloudservice.dao.AuthAccountLogDao;
import com.example.cloudservice.domain.AuthAccountLog;
import com.example.cloudservice.domain.AuthAccountLogExample;
import com.example.cloudservice.service.AccountLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author tomsun28
 * @date 9:32 2018/4/22
 */
@Service
public class AccountLogServiceImpl implements AccountLogService {

    @Autowired
    AuthAccountLogDao authAccountLogMapper;

    @Override
    public List<AuthAccountLog> getAccountLogList() {
        return authAccountLogMapper.selectByExample(new AuthAccountLogExample());
    }
}
