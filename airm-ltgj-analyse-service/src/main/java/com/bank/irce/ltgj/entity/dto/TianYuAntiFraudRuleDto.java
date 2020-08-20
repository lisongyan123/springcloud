package com.bank.irce.ltgj.entity.dto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ApiModel(value = "天御反欺诈规则入参")
@Data
public class TianYuAntiFraudRuleDto implements Serializable {

    private String sessionid;
    private Integer found;
    private BigDecimal riskScore;
    private Integer riskCode_length;
    private List riskCode;
    private List riskCodeValue;


    public TianYuAntiFraudRuleDto() {
    }

    public TianYuAntiFraudRuleDto(String sessionid) {
        this.sessionid = sessionid;
        this.found = 0;
        this.riskScore = new BigDecimal(0);
        this.riskCode_length = 0;
        this.riskCode = new ArrayList();
        this.riskCodeValue = new ArrayList();
    }

    public TianYuAntiFraudRuleDto(Map map, String sessionid) {
        this.sessionid = sessionid;
        this.riskCode_length = Integer.parseInt(JSONPath.eval(map,"$.riskInfo.size()").toString());
        this.riskCode = JSON.parseObject(JSON.toJSONString(JSONPath.eval(map,"$.riskInfo.riskCode")),List.class);
        this.riskCodeValue = JSON.parseObject(JSON.toJSONString(JSONPath.eval(map,"$.riskInfo.riskCodeValue")),List.class);
        this.found = Integer.parseInt(map.getOrDefault("found","-1").toString());
        this.riskScore = new BigDecimal(map.getOrDefault("riskScore","-1").toString());
    }
}
