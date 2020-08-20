package com.bank.irce.ltgj.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description
 * @Author zhuolin
 * @Date 2020/3/20 18:25
 * @Version 1.0
 */
@ApiModel(value = "联合贷场景信息JSON对应实体")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScenarioInfoVo {

    @ApiModelProperty(value = "证件类型")
    private String idType;
    @ApiModelProperty(value = "证件号码")
    private String idNo;
    @ApiModelProperty(value = "证件有效期自")
    private String idValidStart;
    @ApiModelProperty(value = "证件有效期至")
    private String idValidEnd;
    @ApiModelProperty(value = "客户名称")
    private String custName;
    @ApiModelProperty(value = "客户英文名")
    private String custenName;
    @ApiModelProperty(value = "性别")
    private String sex;
    @ApiModelProperty(value = "出生日期")
    private String birth;
    @ApiModelProperty(value = "婚姻状况")
    private String maritalStatus;
    @ApiModelProperty(value = "学历")
    private String educationLevel;
    @ApiModelProperty(value = "个人月收入(15,2)")
    private BigDecimal monthlyIncome;
    @ApiModelProperty(value = "个人收入标识")
    private String monthlyIncomeFlag;
    @ApiModelProperty(value = "居住状况")
    private String familyStatus;
    @ApiModelProperty(value = "居住年限(3,0)")
    private BigDecimal familyYear;
    @ApiModelProperty(value = "居住地址")
    private String homeAddr;
    @ApiModelProperty(value = "家庭邮编")
    private String homeZIPCode;
    @ApiModelProperty(value = "单位性质")
    private String employerProp;
    @ApiModelProperty(value = "单位行业类型")
    private String industry;
    @ApiModelProperty(value = "工作单位")
    private String employer;
    @ApiModelProperty(value = "职务")
    private String position;
    @ApiModelProperty(value = "职业")
    private String job;
    @ApiModelProperty(value = "单位地址")
    private String employerAddr;
    @ApiModelProperty(value = "公司邮编")
    private String companyZIP;
    @ApiModelProperty(value = "手机号")
    private String mobPhoneNo;
    @ApiModelProperty(value = "预留手机号")
    private String mobPhoneNo1;
    @ApiModelProperty(value = "住宅电话区号")
    private String homePhoneArea;
    @ApiModelProperty(value = "住宅电话")
    private String homePhoneNo;
    @ApiModelProperty(value = "单位电话区号")
    private String workPhoneArea;
    @ApiModelProperty(value = "单位电话")
    private String workPhoneNo;
    @ApiModelProperty(value = "联系地址")
    private String addr;
    @ApiModelProperty(value = "联系地址/经营场所所在行政区域")
    private String regionalCode;
    @ApiModelProperty(value = "联系电话")
    private String phoneNo;
    @ApiModelProperty(value = "客户类型")
    private String mfindType;
    @ApiModelProperty(value = "申请币种")
    private String currency;
    @ApiModelProperty(value = "申请金额(15,2)")
    private BigDecimal applyAmt;
    @ApiModelProperty(value = "申请期限(3,0)")
    private BigDecimal applTerms;
    @ApiModelProperty(value = "申请日期")
    private String applDate;
    @ApiModelProperty(value = "申请地点")
    private String appladdr;
    @ApiModelProperty(value = "还款方式")
    private String repayMethod;
    @ApiModelProperty(value = "利率模式")
    private String rateMode;
    @ApiModelProperty(value = "执行利率(11,7)")
    private BigDecimal intPercent;
    @ApiModelProperty(value = "支付方式")
    private String payType;
    @ApiModelProperty(value = "担保费率(20,7)")
    private BigDecimal gurantRate;
    @ApiModelProperty(value = "担保服务费率(20,7)")
    private BigDecimal gurantServerRate;
    @ApiModelProperty(value = "保费率(20,7)")
    private BigDecimal insuranceRate;
    @ApiModelProperty(value = "是否风控拒绝")
    private String isReject;
    @ApiModelProperty(value = "具体的拒绝原因类别")
    private String rejectCode;
    @ApiModelProperty(value = "评分等级")
    private String finalCustLevel;
    @ApiModelProperty(value = "个税缴税工资")
    @JsonProperty("GsAmt")
    private String GsAmt;
    @ApiModelProperty(value = "核实收入")
    private String verifiedIncome;
    @ApiModelProperty(value = "认定负债（月度）")
    private String debtamt;
    @ApiModelProperty(value = "客户类型")
    private String custRnType;
    @ApiModelProperty(value = "增信模式标志")
    private String creditIncrCode;
    @ApiModelProperty(value = "客户渠道来源")
    private String custChannelSource;
    @ApiModelProperty(value = "手机号证件姓名是否一致")
    private String isOwner;
    @ApiModelProperty(value = "手机号在网时长")
    private String inUseTime;
    @ApiModelProperty(value = "设备操作系统类型")
    private String platform;
    @ApiModelProperty(value = "设备品牌")
    private String mobilebrand;
    @ApiModelProperty(value = "申请定位城市")
    private String cityName;
    @ApiModelProperty(value = "网络类型")
    private String connectionType;
    @ApiModelProperty(value = "申请时IP")
    private String ipThree;
    @ApiModelProperty(value = "申请地理定位坐标")
    private String gpsPosition;
    @ApiModelProperty(value = "申请人配偶电话不一致")
    private String spousePhoneIsSame;
    @ApiModelProperty(value = "联系人手机命中已理赔客户联系人手机")
    private String phoneNoIsClaim;
    @ApiModelProperty(value = "申请人手机180天内申请不同")
    private String phoneNoIsSame;
    @ApiModelProperty(value = "单名相同单电不同")
    private String companyPhoneIsSame;
    @ApiModelProperty(value = "单电同其他申请人宅电")
    private String companyPhoneisSameOther;
    @ApiModelProperty(value = "客户授信资质")
    private String custCreditQualify;
    @ApiModelProperty(value = "房产信息列表,为json转化成的字符串")
    private String houseInfoList;
    @ApiModelProperty(value = "寿险保单信息列表,为json转化成的字符串")
    private String lifeInsurePolicyList;
    @ApiModelProperty(value = "车辆信息列表,为json转化成的字符串")
    private String vehicleInfoList;
}
