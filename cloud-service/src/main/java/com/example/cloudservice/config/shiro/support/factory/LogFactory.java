package com.example.cloudservice.config.shiro.support.factory;

import com.example.cloudservice.domain.AuthAccountLog;
import com.example.cloudservice.domain.AuthOperationLog;
import java.util.Date;

/**
 *   日志对象工厂
 */
public class LogFactory {

    private LogFactory() {

    }

    public static AuthAccountLog createAccountLog(String userId, String logName, String ip, Short succeed, String message) {
        AuthAccountLog accountLog = new AuthAccountLog();
        accountLog.setUserId(userId);
        accountLog.setLogName(logName);
        accountLog.setIp(ip);
        accountLog.setSucceed(succeed);
        accountLog.setMessage(message);
        accountLog.setCreateTime(new Date());
        return accountLog;
    }

    public static AuthOperationLog createOperationLog(String userId, String logName, String api, String method, Short succeed, String message) {
        AuthOperationLog operationLog = new AuthOperationLog();
        operationLog.setUserId(userId);
        operationLog.setLogName(logName);
        operationLog.setApi(api);
        operationLog.setMethod(method);
        operationLog.setSucceed(succeed);
        operationLog.setMessage(message);
        operationLog.setCreateTime(new Date());
        return operationLog;
    }
}
