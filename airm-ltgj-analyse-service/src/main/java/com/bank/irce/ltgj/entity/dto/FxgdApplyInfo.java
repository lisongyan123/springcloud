package com.bank.irce.ltgj.entity.dto;

import com.bank.irce.ltgj.entity.BairongScoreInfo;
import com.bank.irce.ltgj.entity.CustBasicInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.io.Serializable;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/7/14
 */
@ApiModel(value = "FxgdApplyInfo", description = "平安无抵押入参对象")
@Data
public class FxgdApplyInfo implements Serializable {

    private static final long serialVersionUID = 5878216666846643247L;

    public static ObjectMapper objectMapper = new ObjectMapper();

    @NotBlank
    @ApiModelProperty(value = "唯一流水号")
    @JsonProperty(value = "SESSION_ID")
    private String sessionId;
    @NotBlank
    @ApiModelProperty(value = "申请编号")
    @JsonProperty(value = "APP_NO")
    private String appNo;
    @NotBlank
    @ApiModelProperty(value = "业务品种代码")
    @JsonProperty(value = "BUSINESS_TYPE_CD")
    private String businessTypeCd;
    @NotBlank
    @ApiModelProperty(value = "业务品种名称")
    @JsonProperty(value = "BUSINESS_TYPE_NAME")
    private String businessTypeName;
    @NotNull
    @ApiModelProperty(value = "申请时间")
    @JsonProperty(value = "APPLY_TIME")
    private Long applyTime;
    @NotBlank
    @ApiModelProperty(value = "来源系统")
    @JsonProperty(value = "CUST_SOURCE")
    private String custSource;
    @NotBlank
    @ApiModelProperty(value = "来源渠道")
    @JsonProperty(value = "CHANNEL_SOURCE")
    private String channelSource;
    @NotBlank
    @ApiModelProperty(value = "客户编号")
    @JsonProperty(value = "CUST_ID")
    private String custId;
    @ApiModelProperty(value = "客户基本信息")
    @JsonProperty(value = "CUST_BASIC_INFO")
    private String custBasicInfo;
    @ApiModelProperty(value = "客户其它信息")
    @JsonProperty(value = "CUST_OTHER_INFO")
    private String custOtherInfo;
    @ApiModelProperty(value = "设备状态信息")
    @JsonProperty(value = "DEVICE_STATUS_INFO")
    private String deviceStatusInfo;
    @NotBlank
    @ApiModelProperty(value = "场景信息")
    @JsonProperty(value = "SCENARIO_INFO")
    private String scenarioInfo;
    @ApiModelProperty(value = "联网核查信息")
    @JsonProperty(value = "ONLINE_CHECK_INFO")
    private String onlineCheckInfo;
    @NotBlank
    @ApiModelProperty(value = "授权信息")
    @JsonProperty(value = "AUTHORIZATION_INFO")
    private String authorizationInfo;
    @ApiModelProperty(value = "其它信息")
    @JsonProperty(value = "OTHER_INFO")
    private String otherInfo;
    @NotBlank
    @ApiModelProperty(value = "外部数据文件名")
    @JsonProperty(value = "EXTERNAL_DATA_FILENAME")
    private String externalDataFilename;
    @NotNull
    @ApiModelProperty(value = "文件大小")
    @JsonProperty(value = "FILE_SIZE")
    private Long fileSize;
    @ApiModelProperty(value = "天御数据")
    @JsonProperty(value = "TIANYU_INFO")
    private String tianyuInfo;
    @ApiModelProperty(value = "百融反欺诈数据")
    @JsonProperty(value = "BAIRONG_INFO")
    private String bairongInfo;
    @ApiModelProperty(value = "百度数据")
    @JsonProperty(value = "BAIDU_INFO")
    private String baiduInfo;
    @ApiModelProperty(value = "百融信用分")
    @JsonProperty(value = "BAIRONG_SCORE_INFO")
    private String bairongScoreInfo;


    /**
     * 天御json字符串转对象
     * @return
     * @throws IOException
     */
    public TianyuInfo getTianyuInfoEntity() throws IOException {
        return  objectMapper.readValue(tianyuInfo, TianyuInfo.class);
    }

    /**
     * 百融反欺诈json字符串转对象
     * @return
     * @throws IOException
     */
    public BairongInfo getBairongInfoEntity() throws IOException {
        return  objectMapper.readValue(bairongInfo, BairongInfo.class);
    }

    /**
     * 百度json字符串转对象
     * @return
     * @throws IOException
     */
    public BaiduInfo getBaiduInfofoEntity() throws IOException {
        return  objectMapper.readValue(baiduInfo, BaiduInfo.class);
    }

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
     * 场景信息json字符串转对象
     * @return
     * @throws IOException
     */
    public ScenarioInfoVo getScenarioInfoVoEntity() throws IOException {
        return  objectMapper.readValue(scenarioInfo, ScenarioInfoVo.class);
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
