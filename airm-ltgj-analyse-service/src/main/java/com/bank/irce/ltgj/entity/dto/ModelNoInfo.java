package com.bank.irce.ltgj.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Properties;

@Data
public class ModelNoInfo implements Serializable {

    private String custScore1No;

    private String custScore2No;

    private String antiFraudBRRuleNo;

    private String antiFraudTYRuleNo;

    private String incomeResultNo;

    private String debtResultNo;

    private String rateResultNo;

    private String optProgrammingNo;

    private String firstAccessRuleNo;

    private String finalAccessRuleNo;

    private  String antiFraudCreditNo;

    private String loanZhengxinNo;

    private String custScore1Name;

    private String custScore2Name;

    private String antiFraudBRRuleName;

    private String antiFraudTYRuleName;

    private String incomeResultName;

    private String debtResultName;

    private String rateResultName;

    private String optProgrammingName;

    private String firstAccessRuleName;

    private String finalAccessRuleName;

    private  String antiFraudCreditName;

    private String loanZhengxinName;

    private String antiFraudBDRuleName;
    private String antiFraudBDRuleNo;

    private String qualificationModelName;
    private String qualificationModelNo;

    private String customStrategyModelName;
    private String customStrategyModelNo;

    private String brScoreModelName;
    private String brScoreModelNo;

    public ModelNoInfo(Properties properties) {
        this.custScore1No = properties.getProperty("custScore1No");
        this.custScore2No = properties.getProperty("custScore2No");
        this.antiFraudBRRuleNo = properties.getProperty("antiFraudBRRuleNo");
        this.antiFraudTYRuleNo = properties.getProperty("antiFraudTYRuleNo");
        this.incomeResultNo = properties.getProperty("incomeResultNo");
        this.debtResultNo = properties.getProperty("debtResultNo");
        this.rateResultNo = properties.getProperty("rateResultNo");
        this.optProgrammingNo = properties.getProperty("optProgrammingNo");
        this.firstAccessRuleNo = properties.getProperty("firstAccessRuleNo");
        this.finalAccessRuleNo = properties.getProperty("finalAccessRuleNo");
        this.antiFraudCreditNo = properties.getProperty("antiFraudCreditNo");
        this.loanZhengxinNo = properties.getProperty("loanZhengxinNo");
        this.custScore1Name = properties.getProperty("custScore1Name");
        this.custScore2Name = properties.getProperty("custScore2Name");
        this.antiFraudBRRuleName = properties.getProperty("antiFraudBRRuleName");
        this.antiFraudTYRuleName = properties.getProperty("antiFraudTYRuleName");
        this.incomeResultName = properties.getProperty("incomeResultName");
        this.debtResultName = properties.getProperty("debtResultName");
        this.rateResultName = properties.getProperty("rateResultName");
        this.optProgrammingName = properties.getProperty("optProgrammingName");
        this.firstAccessRuleName = properties.getProperty("firstAccessRuleName");
        this.finalAccessRuleName = properties.getProperty("finalAccessRuleName");
        this.antiFraudCreditName = properties.getProperty("antiFraudCreditName");
        this.loanZhengxinName = properties.getProperty("loanZhengxinName");
        this.antiFraudBDRuleName = properties.getProperty("antiFraudBDRuleName");
        this.antiFraudBDRuleNo = properties.getProperty("antiFraudBDRuleNo");
        this.qualificationModelName = properties.getProperty("qualificationModelName");
        this.qualificationModelNo = properties.getProperty("qualificationModelNo");
        this.customStrategyModelName = properties.getProperty("customStrategyModelName");
        this.customStrategyModelNo = properties.getProperty("customStrategyModelNo");
        this.brScoreModelName = properties.getProperty("brScoreModelName");
        this.brScoreModelNo = properties.getProperty("brScoreModelNo");
    }

}
