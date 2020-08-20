package com.bank.irce.ltgj.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author 段守政
 * @Date 2020/4/26 18:38
 * @Version 1.0
 */
@ApiModel(value = "天御数据JSON实体")
@Data
public class TianyuInfo {

    @ApiModelProperty(value = "查询结果")
    @JsonProperty(value="RESULT")
    private String result;

    @ApiModelProperty(value = "传输类型")
    @JsonProperty(value="SEND_TYPE")
    private String sendType;

    @ApiModelProperty(value = "返回报文体")
    @JsonProperty(value="RETURN_BODY")
    private String returnBody;

    @ApiModelProperty(value = "文件名称")
    @JsonProperty(value="FILE_NAME")
    private String fileName;

    @ApiModelProperty(value = "错误代码")
    @JsonProperty(value="ERROR_CODE")
    private String errorCode;

}
