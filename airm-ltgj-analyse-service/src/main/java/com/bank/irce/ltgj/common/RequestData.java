package com.bank.irce.ltgj.common;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@ApiModel(value = "统一请求接收实体类")
public class RequestData<T> implements Serializable {

    private static final long serialVersionUID = -2732877928093945386L;

    /**
     * 数据
     */
    @ApiModelProperty(value = "数据")
    private T data;
    /**
     * 请求时间
     */
    @ApiModelProperty(value = "请求时间")
    @JsonIgnore
    private Timestamp requestTime;

    public RequestData() {
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this,true);
    }

    public RequestData(T param) {
        this.data = param;
    }

}
