package com.bank.irce.ltgj.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Description
 * @Author zhuolin
 * @Date 2020/3/20 18:18
 * @Version 1.0
 */
@ApiModel(value = "客户其他信息请求实体")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustOtherInfoVo implements Serializable {

    @NotBlank(message = "MOBILE_NUM")
    @Pattern(regexp = ValidateConstant.PHONE_REGEXP,message = "MOBILE_NUM")
    @ApiModelProperty(value = "手机号码")
    @JsonProperty(value="MOBILE_NUM")
    private String mobileNum;

    @ApiModelProperty(value = "身份证地址")
    @JsonProperty(value="CERT_ADDR")
    private String certAddr;

    @ApiModelProperty(value = "手机号码所在地址")
    @JsonProperty(value="MOBILE_ADDR")
    private String mobileAddr;

    @ApiModelProperty(value = "gps定位地址")
    @JsonProperty(value="GPS_ADDR")
    private String gpsAddr;

    @ApiModelProperty(value = "客户当前信贷逾期天数")
    @JsonProperty(value="CURR_OVRD_DAYS")
    private String currOvrdDays;


}
