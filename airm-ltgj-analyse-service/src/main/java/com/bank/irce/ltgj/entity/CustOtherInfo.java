package com.bank.irce.ltgj.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * CUST_OTHER_INFO
 * @author 
 */
@Data
public class CustOtherInfo implements Serializable {
    private String curMarriageStatusCd;

    private String addrDesc;

    private String addrUsagEcd;

    private String mobileNum;

    private String email;

    private String compName;

    private String workState;

    private String dutyCd;

    private String titleCd;

    private String occupationCd;

    private String educationLevelCd;

    private BigDecimal workYearNum;

    private String corpPropertyCd;

    private String compIndustryClassCd;

    private String currOvrdDays;

    private static final long serialVersionUID = 1L;
}