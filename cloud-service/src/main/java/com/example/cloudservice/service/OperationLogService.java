package com.example.cloudservice.service;


import com.example.cloudservice.domain.AuthOperationLog;

import java.util.List;

/**
 * @author tomsun28
 * @date 9:30 2018/4/22
 */
public interface OperationLogService {

    List<AuthOperationLog> getOperationList();
}
