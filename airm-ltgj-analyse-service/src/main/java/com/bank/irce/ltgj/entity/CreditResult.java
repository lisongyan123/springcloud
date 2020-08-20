package com.bank.irce.ltgj.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * CREDIT_RESULT
 * @author 
 */
@Data
public class CreditResult implements Serializable {
    private BigDecimal creditLimit;

    private String refuseReason;

    private String queryType;

    private String reserve;

    private static final long serialVersionUID = 1L;
}