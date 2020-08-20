package com.bank.irce.ltgj.entity.dto;

import com.bank.irce.ltgj.common.DateUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.StringReader;

@Data
@TableName(value = "AIRM_FXDG_EDMP_ACCESS_LOG")
@KeySequence(value = "EDMP_ACCESS_LOG_ID_SEQ",clazz = Integer.class)
public class EdmpAccessLog {

    @TableId(value = "ID", type = IdType.INPUT)
    private Integer id;

    private String name;

    private String reqTime;

    private String reqResult;

    private String reqParams;

    private String resParams;

    private String productNo;

    private String productName;

    private String sessionId;

    private String creditTime;

    private String updateTime;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    public EdmpAccessLog() {
    }

    public EdmpAccessLog(String reqResult, String reqParams, String resParams, String sessionId,
                         String name) {
        this.reqResult = reqResult;
        this.reqParams = reqParams;
        this.resParams = resParams;
        this.sessionId = sessionId;
        this.name = name;
        this.productName = "平安无抵押风险共担";
        this.productNo = "P0003";
        this.reqTime = DateUtil.getNowyyyy_MM_dd_HH_mm_ss();
        this.creditTime = DateUtil.getNowyyyy_MM_dd_HH_mm_ss();
    }

    public EdmpAccessLog(String dataName, String reqResult, String reqParams, String resParams, String productNo, String productName, String sessionId) {
        this.name = dataName;
        this.reqResult = reqResult;
        this.reqParams = reqParams;
        this.resParams = resParams;
        this.productNo = productNo;
        this.productName = productName;
        this.sessionId = sessionId;
        this.reqTime = DateUtil.getNowyyyy_MM_dd_HH_mm_ss();
        this.creditTime = DateUtil.getNowyyyy_MM_dd_HH_mm_ss();
    }

}
