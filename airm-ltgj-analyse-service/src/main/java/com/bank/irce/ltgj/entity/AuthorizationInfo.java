package com.bank.irce.ltgj.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * AUTHORIZATION_INFO
 * @author 
 */
@Data
public class AuthorizationInfo implements Serializable {
    private String authSign;

    private String custAuthed;

    private String loginId;

    private String pbccAddr;

    private BigDecimal custScore;

    private static final long serialVersionUID = 1L;
}