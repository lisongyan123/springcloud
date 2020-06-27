package com.example.cloudservice.config.shiro.support.factory;

import com.example.cloudservice.config.shiro.support.SpringContextHolder;
import com.example.cloudservice.dao.AuthAccountLogDao;
import com.example.cloudservice.dao.AuthOperationLogDao;
import com.example.cloudservice.domain.AuthAccountLog;
import com.example.cloudservice.domain.AuthOperationLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

/**
 *  日志操作任务工厂
 */
public class LogTaskFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogTaskFactory.class);
    private static AuthOperationLogDao operationLogMapper = SpringContextHolder.getBean(AuthOperationLogDao.class);
    private static AuthAccountLogDao accountLogMapper = SpringContextHolder.getBean(AuthAccountLogDao.class);

    private LogTaskFactory() {

    }

    public static TimerTask loginLog(String userId, String ip, Short succeed, String message) {
        return new TimerTask() {
            @Override
            public void run() {
                try {
                    AuthAccountLog accountLog = LogFactory.createAccountLog(userId, "用户登录日志", ip, succeed, message);
                    accountLogMapper.insertSelective(accountLog);
                } catch (Exception e) {
                    LOGGER.error("写入用户登录日志异常", e.getCause().getMessage());
                }
            }
        };
    }

    public static TimerTask exitLog(String userId, String ip, Short succeed, String message) {
        return new TimerTask() {
            @Override
            public void run() {
                try {
                    AuthAccountLog accountLog = LogFactory.createAccountLog(userId, "用户退出日志", ip, succeed, message);
                    accountLogMapper.insertSelective(accountLog);
                } catch (Exception e) {
                    LOGGER.error("写入用户退出日志异常", e.getCause().getMessage());
                }
            }
        };
    }

    public static TimerTask registerLog(String userId, String ip, Short succeed, String message) {
        return new TimerTask() {
            @Override
            public void run() {
                try {
                    AuthAccountLog accountLog = LogFactory.createAccountLog(userId, "用户注册日志", ip, succeed, message);
                    accountLogMapper.insertSelective(accountLog);
                } catch (Exception e) {
                    LOGGER.error("写入用户注册日志异常", e.getCause().getMessage());
                }
            }
        };
    }

    public static TimerTask bussinssLog(String userId, String api, String method, Short succeed, String message) {
        return new TimerTask() {
            @Override
            public void run() {
                try {
                    AuthOperationLog operationLog = LogFactory.createOperationLog(userId, "业务操作日志", api, method, succeed, message);
                    operationLogMapper.insertSelective(operationLog);
                } catch (Exception e) {
                    LOGGER.error("写入业务操作日志异常", e.getCause().getMessage());
                }
            }
        };
    }

    public static TimerTask exceptionLog(String userId, String api, String method, Short succeed, String message) {
        return new TimerTask() {
            @Override
            public void run() {
                try {
                    AuthOperationLog exceptionLog = LogFactory.createOperationLog(userId, "业务异常日志", api, method, succeed, message);
                    operationLogMapper.insertSelective(exceptionLog);
                } catch (Exception e) {
                    LOGGER.error("写入业务异常日志异常", e.getCause().getMessage());
                }
            }
        };
    }


}
