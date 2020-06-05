package com.example.cloudservice.service.impl;

import com.example.cloudservice.dao.AuthOperationLogDao;
import com.example.cloudservice.domain.AuthOperationLog;
import com.example.cloudservice.domain.AuthOperationLogExample;
import com.example.cloudservice.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tomsun28
 * @date 9:34 2018/4/22
 */
@Service
public class OperationLogServiceImpl implements OperationLogService {

    @Autowired
    AuthOperationLogDao authOperationLogMapper;

    @Override
    public List<AuthOperationLog> getOperationList() {
        return authOperationLogMapper.selectByExample(new AuthOperationLogExample());
    }
}
