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
 * @Date 2020/3/20 18:29
 * @Version 1.0
 */
@ApiModel(value = "授权信息请求实体")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorizationInfoVo implements Serializable {

    @NotBlank(message = "AUTH_SIGN")
    @Pattern(regexp = ValidateConstant.CUST_AUTH,message = "AUTH_SIGN")
    @ApiModelProperty(value = "用户是否授权查询征信")
    @JsonProperty(value="AUTH_SIGN")
    private String authSign;

    @NotBlank(message = "CUST_AUTHED")
    @Pattern(regexp = ValidateConstant.CUST_AUTH,message = "CUST_AUTHED")
    @ApiModelProperty(value = "客户是否授权查询外部数据")
    @JsonProperty(value="CUST_AUTHED")
    private String custAuthed;

    @ApiModelProperty(value = "征信报文地址")
    @JsonProperty(value="PBCC_ADDR")
    private String pbccAddr;



}
