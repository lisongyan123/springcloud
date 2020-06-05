package com.example.cloudservice.domain.vo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * log
 * @author 
 */
@Data
public class Log implements Serializable {
    private Long id;

    private Date createTime;

    private String description;

    private String exceptionDetail;

    private String logType;

    private String method;

    private String params;

    private String requestIp;

    private Long time;

    private String username;

    private String address;

    private String browser;

    private static final long serialVersionUID = 1L;

    public Log(String logType, Long time) {
        this.logType = logType;
        this.time = time;
    }
}