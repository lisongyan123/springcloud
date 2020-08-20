package com.bank.irce.ltgj.entity;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;

import com.bank.irce.ltgj.entity.dto.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

/**
 * AIRM_LTGJ_REQUEST_BODY
 * @author 
 */
@Data
public class AirmLtgjRequestBody implements Serializable {
    private String sessionId;

    private String appNo;

    private String businessTypeCd;

    private String businessTypeName;

    private BigDecimal applyTime;

    private String custSource;

    private String channelSource;

    private String custId;

    private String custBasicInfo;

    private String custOtherInfo;

    private String deviceStatusInfo;

    private String onlineCheckInfo;

    private String authorizationInfo;

    private String bairongScoreInfo;

    private String otherInfo;

    private static final long serialVersionUID = 1L;

    public static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 百融信用分json字符串转对象
     * @return
     * @throws IOException
     */
    public BairongScoreInfo getBairongScoreInfoEntity() throws IOException {
        return  objectMapper.readValue(bairongScoreInfo, BairongScoreInfo.class);
    }

    /**
     * 客户基本信息json字符串转对象
     * @return
     * @throws IOException
     */
    public CustBasicInfo getCustBasicInfoEntity() throws IOException {
        return  objectMapper.readValue(custBasicInfo, CustBasicInfo.class);
    }

    /**
     * 客户其它信息json字符串转对象
     * @return
     * @throws IOException
     */
    public CustOtherInfoVo getCustOtherInfoVoEntity() throws IOException {
        return  objectMapper.readValue(custOtherInfo, CustOtherInfoVo.class);
    }

    /**
     * 设备状态信息json字符串转对象
     * @return
     * @throws IOException
     */
    public DeviceStatusInfoVo getDeviceStatusInfoVoEntity() throws IOException {
        return  objectMapper.readValue(deviceStatusInfo, DeviceStatusInfoVo.class);
    }

    /**
     * 联网核查信息json字符串转对象
     * @return
     * @throws IOException
     */
    public OnlineCheckInfoVo getOnlineCheckInfoVoEntity() throws IOException {
        return  objectMapper.readValue(onlineCheckInfo, OnlineCheckInfoVo.class);
    }

    /**
     * 授权信息json字符串转对象
     * @return
     * @throws IOException
     */
    public AuthorizationInfoVo getAuthorizationInfoVoEntity() throws IOException {
        return  objectMapper.readValue(authorizationInfo, AuthorizationInfoVo.class);
    }

    /**
     * 其它信息百融信用分json字符串转对象
     * @return
     * @throws IOException
     */
    public OtherInfoVo getOtherInfoVoInfoEntity() throws IOException {
        return  objectMapper.readValue(otherInfo, OtherInfoVo.class);
    }
}