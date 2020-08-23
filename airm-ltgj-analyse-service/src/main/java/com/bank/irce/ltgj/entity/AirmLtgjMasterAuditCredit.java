package com.bank.irce.ltgj.entity;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;

import com.bank.irce.ltgj.entity.dto.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

/**
 * AIRM_LTGJ_MASTER_BODY
 * @author 
 */
@Data
public class AirmLtgjMasterAuditCredit implements Serializable {
    /**
     * 唯一流水号
     */
    private String sessionId;

    /**
     * 申请编号
     */
    private String appNo;

    /**
     * 业务品种代码
     */
    private String businessTypeCd;

    /**
     * 业务品牌名称
     */
    private String businessTypeName;

    /**
     * 申请时间
     */
    private BigDecimal applyTime;

    /**
     * 来源系统
     */
    private String custSource;

    /**
     * 来源渠道
     */
    private String channelSource;

    /**
     * 客户编号
     */
    private String custId;

    /**
     * 客户基本信息
     */
    private String custBasicInfo;

    /**
     * 客户其他信息
     */
    private String custOtherInfo;

    /**
     * 设备状态信息
     */
    private String deviceStatusInfo;

    /**
     * 联网核查信息
     */
    private String onlineCheckInfo;

    /**
     * 外部数据授权信息
     */
    private String authorizationInfo;

    /**
     * 百荣信用分信息
     */
    private String bairongScoreInfo;

    /**
     * 其他信息
     */
    private String otherInfo;

    /**
     * 授信编号
     */
    private String creditNo;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 证件号
     */
    private String certNo;

    /**
     * 证件类型
     */
    private String certType;

    /**
     * 申请编号
     */
    private BigDecimal creditTimestamp;

    /**
     * 响应状态码
     */
    private String stateCode;

    /**
     * 授信结果标识
     */
    private String creditCode;

    /**
     * 授信结果详情
     */
    private String creditResult;

    /**
     * 其他结果详情
     */
    private String otherResult;

    /**
     * 联通支付信息
     */
    private String ltzfInfo;

    /**
     * 联通大数据信息
     */
    private String ltdsjInfo;

    private static final long serialVersionUID = 1L;
}