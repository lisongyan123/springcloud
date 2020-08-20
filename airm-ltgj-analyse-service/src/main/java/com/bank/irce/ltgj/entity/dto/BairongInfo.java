package com.bank.irce.ltgj.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description
 * @Author 段守政
 * @Date 2020/4/26 18:38
 * @Version 1.0
 */
@ApiModel(value = "百融数据实体")
@Data
public class BairongInfo {

    @ApiModelProperty(value = "对象值")
    @JsonProperty(value="OBJ_VAL")
    private String objVal;

    @ApiModelProperty(value = "查询结果")
    @JsonProperty(value="RESULT")
    private String result;

    @ApiModelProperty(value = "传输类型")
    @JsonProperty(value="SEND_TYPE")
    private String sendType;

    @ApiModelProperty(value = "返回报文体")
    @JsonProperty(value="RETURN_BODY")
    private String returnBody;

    @ApiModelProperty(value = "查询日期")
    @JsonProperty(value="QUERY_DATE")
    private Date queryDate;

    @ApiModelProperty(value = "文件名称")
    @JsonProperty(value="FILE_NAME")
    private String fileName;

    @ApiModelProperty(value = "错误代码")
    @JsonProperty(value="ERROR_CODE")
    private String errorCode;

    @ApiModelProperty(value = "外部错误代码")
    @JsonProperty(value="OUT_CODE")
    private String outCode;

    @ApiModelProperty(value = "预留字段1")
    @JsonProperty(value="RESERVE1")
    private String reserve1;

    @ApiModelProperty(value = "预留字段2")
    @JsonProperty(value="RESERVE2")
    private String reserve2;

    @ApiModelProperty(value = "预留字段3")
    @JsonProperty(value="RESERVE3")
    private String reserve3;

    @ApiModelProperty(value = "预留字段4")
    @JsonProperty(value="RESERVE4")
    private String reserve4;

    @ApiModelProperty(value = "预留字段5")
    @JsonProperty(value="RESERVE5")
    private String reserve5;

    @ApiModelProperty(value = "预留字段6")
    @JsonProperty(value="RESERVE6")
    private String reserve6;


}
