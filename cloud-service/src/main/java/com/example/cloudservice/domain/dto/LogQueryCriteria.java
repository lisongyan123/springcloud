package com.example.cloudservice.domain.dto;

import com.example.cloudservice.common.annotion.Query;
import lombok.Data;
import java.sql.Timestamp;
import java.util.List;

@Data
public class LogQueryCriteria {

    @Query(blurry = "username,description,address,requestIp,method,params")
    private String blurry;

    @Query
    private String logType;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}
