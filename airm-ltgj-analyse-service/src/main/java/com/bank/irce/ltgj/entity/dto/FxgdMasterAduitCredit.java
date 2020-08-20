package com.bank.irce.ltgj.entity.dto;

import com.bank.irce.ltgj.entity.BairongScoreInfo;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/7/14
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("AIRM_FXGD_MASTER_ADUIT_CREDIT")
@KeySequence(value = "MASTER_ADUIT_CREDIT_ID_SEQ")
public class FxgdMasterAduitCredit implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.INPUT)
    private Integer id;

    @TableField("SESSION_ID")
    private String sessionId;

    @TableField("APP_NO")
    private String appNo;

    @TableField("BUSINESS_TYPE_CD")
    private String businessTypeCd;

    @TableField("BUSINESS_TYPE_NAME")
    private String businessTypeName;

    @TableField("APPLY_TIME")
    private Long applyTime;

    @TableField("CUST_SOURCE")
    private String custSource;

    @TableField("CHANNEL_SOURCE")
    private String channelSource;

    @TableField("CUST_ID")
    private String custId;

    @TableField("CUST_BASIC_INFO")
    private String custBasicInfo;

    @TableField("CUST_OTHER_INFO")
    private String custOtherInfo;

    @TableField("DEVICE_STATUS_INFO")
    private String deviceStatusInfo;

    @TableField("ONLINE_CHECK_INFO")
    private String onlineCheckInfo;

    @TableField("OTHER_INFO")
    private String otherInfo;

    @TableField("EXTERNAL_DATA_FILENAME")
    private String externalDataFilename;

    @TableField("FILE_SIZE")
    private Long fileSize;

    @TableField("ID_TYPE")
    private String idType;

    @TableField("ID_NO")
    private String idNo;

    @TableField("ID_VALID_START")
    private String idValidStart;

    @TableField("ID_VALID_END")
    private String idValidEnd;

    @TableField("CUST_NAME")
    private String custName;

    @TableField("CUSTEN_NAME")
    private String custenName;

    @TableField("SEX")
    private String sex;

    @TableField("BIRTH")
    private String birth;

    @TableField("MARITAL_STATUS")
    private String maritalStatus;

    @TableField("EDUCATION_LEVEL")
    private String educationLevel;

    @TableField("MONTHLY_INCOME")
    private BigDecimal monthlyIncome;

    @TableField("MONTHLY_INCOME_FLAG")
    private String monthlyIncomeFlag;

    @TableField("FAMILY_STATUS")
    private String familyStatus;

    @TableField("FAMILY_YEAR")
    private Integer familyYear;

    @TableField("HOME_ADDR")
    private String homeAddr;

    @TableField("HOME_ZIP_CODE")
    private String homeZIPCode;

    @TableField("EMPLOYER_PROP")
    private String employerProp;

    @TableField("INDUSTRY")
    private String industry;

    @TableField("EMPLOYER")
    private String employer;

    @TableField("POSITION")
    private String position;

    @TableField("JOB")
    private String job;

    @TableField("EMPLOYER_ADDR")
    private String employerAddr;

    @TableField("COMPANY_ZIP")
    private String companyZIP;

    @TableField("MOB_PHONE_NO")
    private String mobPhoneNo;

    @TableField("MOB_PHONE_NO1")
    private String mobPhoneNo1;

    @TableField("HOME_PHONE_AREA")
    private String homePhoneArea;

    @TableField("HOME_PHONE_NO")
    private String homePhoneNo;

    @TableField("WORK_PHONE_AREA")
    private String workPhoneArea;

    @TableField("WORK_PHONE_NO")
    private String workPhoneNo;

    @TableField("ADDR")
    private String addr;

    @TableField("REGIONAL_CODE")
    private String regionalCode;

    @TableField("PHONE_NO")
    private String phoneNo;

    @TableField("MFIND_TYPE")
    private String mfindType;

    @TableField("CURRENCY")
    private String currency;

    @TableField("APPLY_AMT")
    private BigDecimal applyAmt;

    @TableField("APPL_TERMS")
    private Integer applTerms;

    @TableField("APPL_DATE")
    private String applDate;

    @TableField("APPLADDR")
    private String appladdr;

    @TableField("REPAY_METHOD")
    private String repayMethod;

    @TableField("RATE_MODE")
    private String rateMode;

    @TableField("INT_PERCENT")
    private BigDecimal intPercent;

    @TableField("PAY_TYPE")
    private String payType;

    @TableField("GURANT_RATE")
    private BigDecimal gurantRate;

    @TableField("GURANT_SERVER_RATE")
    private BigDecimal gurantServerRate;

    @TableField("INSURANCE_RATE")
    private BigDecimal insuranceRate;

    @TableField("IS_REJECT")
    private String isReject;

    @TableField("REJECT_CODE")
    private String rejectCode;

    @TableField("FINAL_CUST_LEVEL")
    private String finalCustLevel;

    @TableField("GS_AMT")
    private String gsAmt;

    @TableField("VERIFIED_INCOME")
    private String verifiedIncome;

    @TableField("DEBTAMT")
    private String debtamt;

    @TableField("CUST_RN_TYPE")
    private String custRnType;

    @TableField("CREDIT_INCR_CODE")
    private String creditIncrCode;

    @TableField("CUST_CHANNEL_SOURCE")
    private String custChannelSource;

    @TableField("IS_OWNER")
    private String isOwner;

    @TableField("IN_USE_TIME")
    private String inUseTime;

    @TableField("PLATFORM")
    private String platform;

    @TableField("MOBILEBRAND")
    private String mobilebrand;

    @TableField("CITY_NAME")
    private String cityName;

    @TableField("CONNECTION_TYPE")
    private String connectionType;

    @TableField("IP_THREE")
    private String ipThree;

    @TableField("GPS_POSITION")
    private String gpsPosition;

    @TableField("SPOUSE_PHONE_IS_SAME")
    private String spousePhoneIsSame;

    @TableField("PHONE_NO_IS_CLAIM")
    private String phoneNoIsClaim;

    @TableField("PHONE_NO_IS_SAME")
    private String phoneNoIsSame;

    @TableField("COMPANY_PHONE_IS_SAME")
    private String companyPhoneIsSame;

    @TableField("COMPANY_PHONEIS_SAME_OTHER")
    private String companyPhoneisSameOther;

    @TableField("CUST_CREDIT_QUALIFY")
    private String custCreditQualify;

    @TableField("HOUSE_INFO_LIST")
    private String houseInfoList;

    @TableField("LIFE_INSURE_POLICY_LIST")
    private String lifeInsurePolicyList;

    @TableField("VEHICLE_INFO_LIST")
    private String vehicleInfoList;

    @TableField("AUTH_SIGN")
    private String authSign;

    @TableField("CUST_AUTHED")
    private String custAuthed;

    @TableField("PBCC_ADDR")
    private String pbccAddr;

    @TableField("TIANYU_RESULT")
    private String tianyuResult;

    @TableField("TIANYU_SEND_TYPE")
    private String tianyuSendType;

    @TableField("TIANYU_RETURN_BODY")
    private String tianyuReturnBody;

    @TableField("TIANYU_FILE_NAME")
    private String tianyuFileName;

    @TableField("TIANYU_ERROR_CODE")
    private String tianyuErrorCode;

    @TableField("BAIRONG_OBJ_VAL")
    private String bairongObjVal;

    @TableField("BAIRONG_RESULT")
    private String bairongResult;

    @TableField("BAIRONG_SEND_TYPE")
    private String bairongSendType;

    @TableField("BAIRONG_RETURN_BODY")
    private String bairongReturnBody;

    @TableField("BAIRONG_QUERY_DATE")
    private Date bairongQueryDate;

    @TableField("BAIRONG_FILE_NAME")
    private String bairongFileName;

    @TableField("BAIRONG_ERROR_CODE")
    private String bairongErrorCode;

    @TableField("BAIRONG_OUT_CODE")
    private String bairongOutCode;

    @TableField("BAIRONG_RESERVE1")
    private String bairongReserve1;

    @TableField("BAIRONG_RESERVE2")
    private String bairongReserve2;

    @TableField("BAIRONG_RESERVE3")
    private String bairongReserve3;

    @TableField("BAIRONG_RESERVE4")
    private String bairongReserve4;

    @TableField("BAIRONG_RESERVE5")
    private String bairongReserve5;

    @TableField("BAIRONG_RESERVE6")
    private String bairongReserve6;

    @TableField("BAIDU_OSFX11")
    private String baiduOsfx11;

    @TableField("BAIDU_OSHC11")
    private String baiduOshc11;

    @TableField("BAIDU_OSDT11")
    private String baiduOsdt11;

    @TableField("BAIDU_OSXY11")
    private String baiduOsxy11;

    @TableField("BAIRONG_SCORE_OUT_CODE")
    private String bairongScoreOutCode;

    @TableField("BAIRONG_SCORE_OUT_DESC")
    private String bairongScoreOutDesc;

    @TableField("BAIRONG_SCORE_SID")
    private String bairongScoreSid;

    @TableField("BAIRONG_SCORE_SEND_TYPE")
    private String bairongScoreSendType;

    @TableField("BAIRONG_SCORE_RETURN_BODY")
    private String bairongScoreReturnBody;

    @TableField("BAIRONG_SCORE_FILE_NAME")
    private String bairongScoreFileName;

    @TableField("BAIRONG_SCORE_RESERVE1")
    private String bairongScoreReserve1;

    @TableField("BAIRONG_SCORE_RESERVE2")
    private String bairongScoreReserve2;

    @TableField("BAIRONG_SCORE_RESERVE3")
    private String bairongScoreReserve3;

    @TableField("BAIRONG_SCORE_RESERVE4")
    private String bairongScoreReserve4;

    @TableField("BAIRONG_SCORE_RESERVE5")
    private String bairongScoreReserve5;

    @TableField("BAIRONG_SCORE_RESERVE6")
    private String bairongScoreReserve6;

    @TableField("BAIRONG_SCORE_ERR_OBJ")
    private String bairongScoreErrObj;

    @TableField("BAIRONG_SCORE_ERR_NUMBER")
    private String bairongScoreErrNumber;

    @TableField("BAIRONG_SCORE_ERR_CODE")
    private String bairongScoreErrCode;

    @TableField("BAIRONG_SCORE_ERR_MSG")
    private String bairongScoreErrMsg;

    @TableField("CREDIT_NO")
    private String creditNo;

    @TableField("CERT_NO")
    private String certNo;

    @TableField("CERT_TYPE")
    private String certType;

    @TableField("CREDIT_TIMESTAMP")
    private Long creditTimestamp;

    @TableField("STATE_CODE")
    private String stateCode;

    @TableField("CREDIT_CODE")
    private String creditCode;

    @TableField("CREDIT_RESULT")
    private String creditResult;

    @TableField("OTHER_RESULT")
    private String otherResult;

    @TableField("CUST_SEG")
    private String custSeg;

    @TableField("REFUSE_REASON")
    private String refuseReason;

    @TableField("RESERVE")
    private String reserve;

    @TableField("REFUSECODE")
    private Integer refusecode;
    @TableField("CUSTSCORE1")
    private Integer custscore1;
    @TableField("CUSTSCORE2")
    private Integer custscore2;
    @TableField("PRODSCORE")
    private Integer prodscore;

    public FxgdMasterAduitCredit(FxgdApplyInfo fxgdApplyInfo, String creditNo, String refuseReason, CreditApprovalResVo creditApprovalResVo, Integer refusecode) throws IOException {

        this.creditNo = creditNo;
        if (Objects.nonNull(refuseReason)) {
            this.refuseReason = refuseReason;
        }
        if (Objects.nonNull(refusecode)) {
            this.refusecode = refusecode;
        }

        // 响应实体映射
        if (Objects.nonNull(creditApprovalResVo)) {
            BeanUtils.copyProperties(creditApprovalResVo, this);
        }

        // 请求实体映射
        if (Objects.nonNull(fxgdApplyInfo)) {
            BeanUtils.copyProperties(fxgdApplyInfo, this);

            if (Objects.nonNull(fxgdApplyInfo.getAuthorizationInfo()) && !"".equals(fxgdApplyInfo.getAuthorizationInfo())) {
                BeanUtils.copyProperties(fxgdApplyInfo.getAuthorizationInfoVoEntity(), this);
            }
            if (Objects.nonNull(fxgdApplyInfo.getCustBasicInfo()) && !"".equals(fxgdApplyInfo.getCustBasicInfo())) {
                BeanUtils.copyProperties(fxgdApplyInfo.getCustBasicInfoEntity(), this);
            }
            if (Objects.nonNull(fxgdApplyInfo.getCustOtherInfo()) && !"".equals(fxgdApplyInfo.getCustOtherInfo())) {
                BeanUtils.copyProperties(fxgdApplyInfo.getCustOtherInfoVoEntity(), this);
            }

            if (Objects.nonNull(fxgdApplyInfo.getScenarioInfo()) && !"".equals(fxgdApplyInfo.getScenarioInfo())) {
                BeanUtils.copyProperties(fxgdApplyInfo.getScenarioInfoVoEntity(), this);
            }
            if (Objects.nonNull(fxgdApplyInfo.getOtherInfo()) && !"".equals(fxgdApplyInfo.getOtherInfo())) {
                BeanUtils.copyProperties(fxgdApplyInfo.getOtherInfoVoInfoEntity(), this);
            }
            if (Objects.nonNull(fxgdApplyInfo.getOnlineCheckInfo()) && !"".equals(fxgdApplyInfo.getOnlineCheckInfo())) {
                BeanUtils.copyProperties(fxgdApplyInfo.getOnlineCheckInfoVoEntity(), this);
            }
            if (Objects.nonNull(fxgdApplyInfo.getDeviceStatusInfo()) && !"".equals(fxgdApplyInfo.getDeviceStatusInfo())) {
                BeanUtils.copyProperties(fxgdApplyInfo.getDeviceStatusInfoVoEntity(), this);
            }

            if (Objects.nonNull(fxgdApplyInfo.getBaiduInfo()) && !"".equals(fxgdApplyInfo.getBaiduInfo())) {
                BaiduInfo baiduInfo = fxgdApplyInfo.getBaiduInfofoEntity();
                this.baiduOsfx11 = baiduInfo.getOSFX11();
                this.baiduOshc11 = baiduInfo.getOSHC11();
                this.baiduOsdt11 = baiduInfo.getOSDT11();
                this.baiduOsxy11 = baiduInfo.getOSXY11();
            }
            if (Objects.nonNull(fxgdApplyInfo.getBairongInfo()) && !"".equals(fxgdApplyInfo.getBairongInfo())) {
                BairongInfo bairongInfo = fxgdApplyInfo.getBairongInfoEntity();
                this.bairongObjVal = bairongInfo.getObjVal();
                this.bairongResult = bairongInfo.getResult();
                this.bairongSendType = bairongInfo.getSendType();
                this.bairongReturnBody = bairongInfo.getReturnBody();
                this.bairongQueryDate = bairongInfo.getQueryDate();
                this.bairongFileName = bairongInfo.getFileName();
                this.bairongErrorCode = bairongInfo.getErrorCode();
                this.bairongOutCode = bairongInfo.getOutCode();
                this.bairongReserve1 = bairongInfo.getReserve1();
                this.bairongReserve2 = bairongInfo.getReserve2();
                this.bairongReserve3 = bairongInfo.getReserve3();
                this.bairongReserve4 = bairongInfo.getReserve4();
                this.bairongReserve5 = bairongInfo.getReserve5();
                this.bairongReserve6 = bairongInfo.getReserve6();
            }
            if (Objects.nonNull(fxgdApplyInfo.getBairongScoreInfo()) && !"".equals(fxgdApplyInfo.getBairongScoreInfo())) {
                BairongScoreInfo bairongScoreInfo = fxgdApplyInfo.getBairongScoreInfoEntity();
                this.bairongScoreOutCode = bairongScoreInfo.getOutCode();
                this.bairongScoreOutDesc = bairongScoreInfo.getOutDesc();
                this.bairongScoreSid = bairongScoreInfo.getSid();
                this.bairongScoreSendType = bairongScoreInfo.getSendType();
                this.bairongScoreReturnBody = bairongScoreInfo.getReturnBody();
                this.bairongScoreFileName = bairongScoreInfo.getFileName();
                this.bairongScoreReserve1 = bairongScoreInfo.getReserve1();
                this.bairongScoreReserve2 = bairongScoreInfo.getReserve2();
                this.bairongScoreReserve3 = bairongScoreInfo.getReserve3();
                this.bairongScoreReserve4 = bairongScoreInfo.getReserve4();
                this.bairongScoreReserve5 = bairongScoreInfo.getReserve5();
                this.bairongScoreReserve6 = bairongScoreInfo.getReserve6();
                this.bairongScoreErrNumber = bairongScoreInfo.getErrNumber();
                this.bairongScoreErrCode = bairongScoreInfo.getErrCode();
                this.bairongScoreErrMsg = bairongScoreInfo.getErrMsg();
            }
            if (Objects.nonNull(fxgdApplyInfo.getTianyuInfo()) && !"".equals(fxgdApplyInfo.getTianyuInfo())) {
                TianyuInfo tianyuInfo = fxgdApplyInfo.getTianyuInfoEntity();
                this.tianyuResult = tianyuInfo.getResult();
                this.tianyuSendType = tianyuInfo.getSendType();
                this.tianyuReturnBody = tianyuInfo.getReturnBody();
                this.tianyuFileName = tianyuInfo.getFileName();
                this.tianyuErrorCode = tianyuInfo.getErrorCode();
            }
        }


    }
}
