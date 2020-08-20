package com.bank.irce.ltgj.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * AIRM_LTGJ_RESPONSE_BODY
 * @author 
 */
@Data
public class AirmLtgjResponseBody implements Serializable {
    private String sessionId;

    private String creditNo;

    private String custName;

    private String certNo;

    private String certType;

    private String appNo;

    private String custId;

    private BigDecimal creditTimestamp;

    private String stateCode;

    private String creditCode;

    private String creditResult;

    private String otherResult;

    private static final long serialVersionUID = 1L;
}