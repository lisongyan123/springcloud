package com.example.cloudservice.controller;


import com.example.cloudservice.domain.AuthAccountLog;
import com.example.cloudservice.domain.AuthOperationLog;
import com.example.cloudservice.domain.vo.Message;
import com.example.cloudservice.service.AccountLogService;
import com.example.cloudservice.service.OperationLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController extends BaseAction {

    @Autowired
    AccountLogService accountLogService;

    @Autowired
    OperationLogService operationLogService;


    @RequestMapping("/accountLog/{currentPage}/{pageSize}")
    public Message getAccountLogList(@PathVariable Integer currentPage, @PathVariable Integer pageSize ) {
        PageHelper.startPage(currentPage, pageSize);
        List<AuthAccountLog> accountLogs = accountLogService.getAccountLogList();
        PageInfo pageInfo = new PageInfo(accountLogs);
        return new Message().ok(6666, "return accountLogs success").addData("data",pageInfo);
    }

    @RequestMapping("/operationLog/{currentPage}/{pageSize}")
    public Message getOperationLogList(@PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<AuthOperationLog> authOperationLogs = operationLogService.getOperationList();
        PageInfo pageInfo = new PageInfo(authOperationLogs);
        return new Message().ok(6666, "return operationLogList success").addData("data", pageInfo);
    }
}
