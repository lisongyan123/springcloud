package com.bank.irce.ltgj.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * CUST_BASIC_INFO
 * @author 
 */
@Data
public class CustBasicInfo implements Serializable {
    private String certType;

    private String certNo;

    private String idenValidDt;

    private String custName;

    private String genderCd;

    private String birthDt;

    private BigDecimal age;

    private static final long serialVersionUID = 1L;
}