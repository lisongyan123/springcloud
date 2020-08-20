package com.bank.irce.ltgj.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "调取征信报文的入参")
public class ConfirmReadDto implements Serializable {

    private String channelCode;
    private String callerCode;
    private String businessId;
    private String callerName;
    @JsonProperty(value = "sessionId")
    private String sessionid;
    private String channelDesc;
    private FileName data;

    public ConfirmReadDto() {
    }

    public ConfirmReadDto(String sessionId , String str) {
        this.channelCode = "PLCREDITREPORT";
        this.callerCode = "airm-fxgd-credit-service";
        this.businessId = sessionId;
        this.callerName = "平安无抵押授信用信";
        this.sessionid = RandomNumber.getRandom();
        this.channelDesc = "通过TFT拉取二代征信文件";
        this.data = new FileName(str);
    }
    public ConfirmReadDto(String sessionId,String str,String channelCode,String channelDesc) {
        this.channelCode = channelCode;
        this.callerCode = "airm-fxgd-credit-service";
        this.businessId = sessionId;
        this.callerName = "平安无抵押授信用信";
        this.sessionid = RandomNumber.getRandom();
        this.channelDesc = channelDesc;
        this.data = new FileName(str);
    }

    @Override
    public String toString() {
        return "{" +
                "\"channelCode\":\"" + channelCode + '\"' +
                ",\"callerCode\":\"" + callerCode + '\"' +
                ",\"businessId\":\"" + businessId + '\"' +
                ",\"callerName\":\""+ callerName + '\"' +
                ",\"sessionId\":\""+ sessionid + '\"' +
                ",\"channelDesc\":\"" + channelDesc + '\"' +
                ",\"data\":" + data +
                '}';
    }
}
