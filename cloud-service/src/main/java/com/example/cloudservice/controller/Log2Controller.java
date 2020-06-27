package com.example.cloudservice.controller;

import com.example.cloudservice.common.log.Log;
import com.example.cloudservice.domain.dto.LogQueryCriteria;
import com.example.cloudservice.service.LogService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Zheng Jie
 * @date 2018-11-24
 */
@RestController
@RequestMapping("/api/logs")
public class Log2Controller {

    private final LogService logService;

    public Log2Controller(LogService logService) {
        this.logService = logService;
    }

    @Log("导出数据")
    @GetMapping(value = "/download")
    public void download(HttpServletResponse response, LogQueryCriteria criteria) throws IOException {
        criteria.setLogType("INFO");
        logService.download(logService.queryAll(), response);
    }

    @Log("导出错误数据")
    @GetMapping(value = "/error/download")
    public void errorDownload(HttpServletResponse response) throws IOException {
        logService.download(logService.queryAll(), response);
    }

    @GetMapping
    public ResponseEntity<Object> getLogs(int pageNum, int size) {
        return new ResponseEntity<>(logService.queryAll(pageNum, size), HttpStatus.OK);
    }

    @GetMapping(value = "/user")
    public ResponseEntity<Object> getUserLogs(int pageNum, int size) {
        return new ResponseEntity<>(logService.queryAll(pageNum, size), HttpStatus.OK);
    }

    @GetMapping(value = "/error")
    public ResponseEntity<Object> getErrorLogs(int pageNum, int size) {
        return new ResponseEntity<>(logService.queryAll(pageNum, size), HttpStatus.OK);
    }

    @GetMapping(value = "/error/{id}")
    public ResponseEntity<Object> getErrorLogs(@PathVariable Long id) {
        return new ResponseEntity<>(logService.findByErrDetail(id), HttpStatus.OK);
    }

    @Log("删除所有ERROR日志")
    @DeleteMapping(value = "/del/type")
    public ResponseEntity<Object> delAllByError(String type) throws Exception {
        logService.delAllByType(type);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

