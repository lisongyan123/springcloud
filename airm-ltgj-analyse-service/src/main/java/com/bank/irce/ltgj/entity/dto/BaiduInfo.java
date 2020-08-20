package com.bank.irce.ltgj.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/7/15
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaiduInfo implements Serializable {

    private static final long serialVersionUID = -109840758127409384L;
    @ApiModelProperty(value = "风险名单查询")
    @JsonProperty("OSFX11")
    private String OSFX11;
    @ApiModelProperty(value = "黑产信息查询")
    @JsonProperty("OSHC11")
    private String OSHC11;
    @ApiModelProperty(value = "多头信息查询")
    @JsonProperty("OSDT11")
    private String OSDT11;
    @JsonProperty("OSXY11")
    @ApiModelProperty(value = "PREA信用分")
    private String OSXY11;

}
