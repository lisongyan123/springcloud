package com.bank.irce.ltgj.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("统一响应实体类")
public class ResponseData<T> implements Serializable {

    private static final long serialVersionUID = 1763079252395550862L;

    @ApiModelProperty(value = "交易编码")
    private String tradeCode;

    @ApiModelProperty(value = "流水号")
    private String sessionId;

    @ApiModelProperty(value = "状态码")
    private State stateCode;

    @ApiModelProperty(value = "数据")
    private T data;

    public ResponseData() {
    }

    public ResponseData(String code, String standardMessage, T data) {
        this.setStateCode(new State(code,standardMessage));
        this.data = data;
    }
    public ResponseData(String code, String standardMessage, String sessionId,T data) {
        this.sessionId = sessionId;
        this.setStateCode(new State(code,standardMessage));
        this.data = data;
    }

    public static ResponseData ok() {
        return ok(null);
    }

    public static <T> ResponseData<T> ok(T data) {
        return new ResponseData<T>(StateCode.SUCCESS.getCode(), StateCode.SUCCESS.getDesc(), data);
    }

    public static ResponseData fail(StateCode status) {
        return new ResponseData<>(status.getCode(), status.getDesc(), null);
    }
    public static ResponseData fail(String code , String msg, String sessionId){
        return  new ResponseData<>(code, msg, sessionId,null);
    }

    public static ResponseData fail(String code , String msg){
        return  new ResponseData<>(code, msg, null);
    }


    public ResponseData byEnum(StateCode statusCode, T data) {
        this.setStateCode(new State(statusCode.getCode(),statusCode.getDesc()));
        this.setData(data);
        return this;
    }
}


