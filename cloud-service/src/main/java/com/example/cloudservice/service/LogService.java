package com.example.cloudservice.service;

import com.example.cloudservice.domain.dto.LogQueryCriteria;
import com.example.cloudservice.domain.vo.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;

import javax.servlet.http.HttpServletResponse;
import java.awt.print.Pageable;
import java.io.IOException;
import java.util.List;

public interface LogService {

    /**
     * 分页查询
     * @return /
     */
    Object queryAll(int pageNum, int size);

    /**
     * 查询全部数据
     */
    List<com.example.cloudservice.domain.vo.Log> queryAll();

//    /**
//     * 查询用户日志
//     * @param criteria 查询条件
//     * @param pageable 分页参数
//     * @return -
//     */
//    Object queryAllByUser(LogQueryCriteria criteria, Pageable pageable);

    /**
     * 保存日志数据
     * @param username 用户
     * @param browser 浏览器
     * @param ip 请求IP
     * @param joinPoint /
     * @param log 日志实体
     */
    @Async
    void save(String username, String browser, String ip, ProceedingJoinPoint joinPoint, Log log) throws Exception ;

    /**
     * 查询异常详情
     * @param id 日志ID
     * @return Object
     */
    Object findByErrDetail(Long id);

    /**
     * 导出日志
     * @param logs 待导出的数据
     * @param response /
     * @throws IOException /
     */
    void download(List<com.example.cloudservice.domain.vo.Log> logs, HttpServletResponse response) throws IOException;

    /**
     * 删除所有错误日志
     */
    void delAllByType(String type) throws Exception;

}

