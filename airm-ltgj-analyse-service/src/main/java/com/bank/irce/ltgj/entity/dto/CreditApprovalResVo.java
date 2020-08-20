package com.bank.irce.ltgj.entity.dto;

import com.alibaba.fastjson.JSON;
import com.bank.irce.ltgj.common.StateCode;
import com.bank.irce.ltgj.common.TradeException;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Calendar;

/**
 * @Description
 * @Author zhuolin
 * @Date 2020/3/21 14:19
 * @Version 1.0
 */
@ApiModel(value = "授信申请审批响应")
@Data
public class CreditApprovalResVo {

    @ApiModelProperty(value = "唯一流水号")
    @JsonProperty(value = "SESSION_ID")
    private String sessionId;

    @ApiModelProperty(value = "授信编号")
    @JsonProperty(value = "CREDIT_NO")
    private String creditNo;

    @ApiModelProperty(value = "客户姓名")
    @JsonProperty(value = "CUST_NAME")
    private String custName;

    @ApiModelProperty(value = "证件号")
    @JsonProperty(value = "CERT_NO")
    private String certNo;

    @ApiModelProperty(value = "证件类型")
    @JsonProperty(value = "CERT_TYPE")
    private String certType;

    @ApiModelProperty(value = "申请编号")
    @JsonProperty(value = "APP_NO")
    private String appNo;

    @ApiModelProperty(value = "客户编号")
    @JsonProperty(value = "CUST_ID")
    private String custId;

    @ApiModelProperty(value = "授信审批时间戳")
    @JsonProperty(value = "CREDIT_TIMESTAMP")
    private Long creditTimestamp;

    @ApiModelProperty(value = "响应状态码")
    @JsonProperty(value = "STATE_CODE")
    private String stateCode;

    @ApiModelProperty(value = "审批结果标识")
    @JsonProperty(value = "CREDIT_CODE")
    private String creditCode;

    @ApiModelProperty(value = "审批结果详情")
    @JsonProperty(value = "CREDIT_RESULT")
    private String creditResult;

    @ApiModelProperty(value = "其他结果详情")
    @JsonProperty(value = "OTHER_RESULT")
    private String otherResult;

    public CreditApprovalResVo() {
    }

    /**
     * 参数校验失败返回结果
     * @param fxgdApplyInfo
     * @param creditNo
     * @param refuseReason
     */
    public CreditApprovalResVo(FxgdApplyInfo fxgdApplyInfo, String creditNo,String refuseReason){
        this.sessionId = fxgdApplyInfo.getSessionId();
        this.creditNo = creditNo;
        this.custName ="";
        this.certNo = "";
        this.certType = "";
        this.appNo = fxgdApplyInfo.getAppNo();
        this.custId = fxgdApplyInfo.getCustId();
        this.creditTimestamp = Calendar.getInstance().getTimeInMillis();
        this.stateCode = StateCode.ER_PARAM_NOT_ACCESS.getCode();
        this.creditCode = "1";
        this.creditResult = JSON.toJSONString(new CreditResult().setRefuseReason(refuseReason));
    }

    /**
     *
     * @param fxgdApplyInfo
     * @param creditNo
     * @param custSeg
     */
    public CreditApprovalResVo(String custSeg, String creditNo,  FxgdApplyInfo fxgdApplyInfo){
        this.sessionId = fxgdApplyInfo.getSessionId();
        this.creditNo = creditNo;
        try {
            this.custName =fxgdApplyInfo.getScenarioInfoVoEntity().getCustName();
            this.certNo = fxgdApplyInfo.getScenarioInfoVoEntity().getIdNo();
            this.certType = fxgdApplyInfo.getScenarioInfoVoEntity().getIdType();
        }catch (Exception ex){
            this.custName = "";
            this.certNo = "";
            this.certType = "";
        }
        this.appNo = fxgdApplyInfo.getAppNo();
        this.custId = fxgdApplyInfo.getCustId();
        this.creditTimestamp = Calendar.getInstance().getTimeInMillis();
        this.stateCode = StateCode.SUCCESS.getCode();
        this.creditCode = "1";
        this.creditResult = JSON.toJSONString(new CreditResult().setCustSeg(custSeg));
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this,true);
    }

    public CreditApprovalResVo(FxgdApplyInfo creditApprovalVo, String creditNo, TradeException e) {
        this.sessionId = creditApprovalVo.getSessionId();
        try {
            this.custName =creditApprovalVo.getScenarioInfoVoEntity().getCustName();
            this.certNo = creditApprovalVo.getScenarioInfoVoEntity().getIdNo();
            this.certType = creditApprovalVo.getScenarioInfoVoEntity().getIdType();
        }catch (Exception ex){
            this.custName = "";
            this.certNo = "";
            this.certType = "";
        }
        this.appNo = creditApprovalVo.getAppNo();
        this.custId = creditApprovalVo.getCustId();
        this.creditTimestamp = Calendar.getInstance().getTimeInMillis();
        this.stateCode = e.getCode();
        this.creditCode = "1";
        this.creditResult = JSON.toJSONString(new CreditResult().setRefuseReason(e.getMessage()));
        this.otherResult = "";
    }

    public CreditApprovalResVo(FxgdApplyInfo creditApprovalVo,String creditNo,Exception e) {
        this.sessionId = creditApprovalVo.getSessionId();
        this.creditNo = creditNo;
        try {
            this.custName =creditApprovalVo.getScenarioInfoVoEntity().getCustName();
            this.certNo = creditApprovalVo.getScenarioInfoVoEntity().getIdNo();
            this.certType = creditApprovalVo.getScenarioInfoVoEntity().getIdType();
        }catch (Exception ex){
            this.custName = "";
            this.certNo = "";
            this.certType = "";
        }
        this.appNo = creditApprovalVo.getAppNo();
        this.custId = creditApprovalVo.getCustId();
        this.creditTimestamp = Calendar.getInstance().getTimeInMillis();
        this.stateCode = StateCode.ER_VERIFY_ERROR.getCode();
        this.creditCode = "1";
        this.creditResult = JSON.toJSONString(new CreditResult().setRefuseReason(StateCode.ER_VERIFY_ERROR.getDesc()));
        this.otherResult = "";
    }

    public CreditApprovalResVo(FxgdApplyInfo creditApprovalVo,String creditNo) {
        this.sessionId = creditApprovalVo.getSessionId();
        this.creditNo = creditNo;
        try {
            this.custName =creditApprovalVo.getScenarioInfoVoEntity().getCustName();
            this.certNo = creditApprovalVo.getScenarioInfoVoEntity().getIdNo();
            this.certType = creditApprovalVo.getScenarioInfoVoEntity().getIdType();
        }catch (Exception ex){
            this.custName = "";
            this.certNo = "";
            this.certType = "";
        }
        this.appNo = creditApprovalVo.getAppNo();
        this.custId = creditApprovalVo.getCustId();
        this.creditTimestamp = Calendar.getInstance().getTimeInMillis();
        this.stateCode = StateCode.ER_UNKNOW.getCode();
        this.creditCode = "1";
        this.creditResult = JSON.toJSONString(new CreditResult().setRefuseReason(StateCode.ER_UNKNOW.getDesc()));
        this.otherResult = "";
    }

    public CreditApprovalResVo(String creditNo, FxgdApplyInfo creditApprovalVo, StateCode stateCode, String creditCode, String creditResult) {
        this.sessionId = creditApprovalVo.getSessionId();
        this.creditNo = creditNo;
        try {
            this.custName =creditApprovalVo.getScenarioInfoVoEntity().getCustName();
            this.certNo = creditApprovalVo.getScenarioInfoVoEntity().getIdNo();
            this.certType = creditApprovalVo.getScenarioInfoVoEntity().getIdType();
        }catch (Exception ex){
            this.custName = "";
            this.certNo = "";
            this.certType = "";
        }
        this.appNo = creditApprovalVo.getAppNo();
        this.custId = creditApprovalVo.getCustId();
        this.creditTimestamp = Calendar.getInstance().getTimeInMillis();
        this.stateCode = stateCode.getCode();
        this.creditCode = creditCode;
        this.creditResult = creditResult;
        this.otherResult = "";
    }

    public CreditApprovalResVo(FxgdApplyInfo creditApprovalVo,String creditNo,String str,String otherResult) {
        this.sessionId = creditApprovalVo.getSessionId();
        this.creditNo = creditNo;
        try {
            this.custName =creditApprovalVo.getScenarioInfoVoEntity().getCustName();
            this.certNo = creditApprovalVo.getScenarioInfoVoEntity().getIdNo();
            this.certType = creditApprovalVo.getScenarioInfoVoEntity().getIdType();
        }catch (Exception ex){
            this.custName = "";
            this.certNo = "";
            this.certType = "";
        }
        this.appNo = creditApprovalVo.getAppNo();
        this.custId = creditApprovalVo.getCustId();
        this.creditTimestamp = Calendar.getInstance().getTimeInMillis();
        this.stateCode = StateCode.ER_UNKNOW.getCode();
        this.creditCode = "1";
        this.creditResult = JSON.toJSONString(new CreditResult().setRefuseReason(str));
        this.otherResult = otherResult;
    }
}
