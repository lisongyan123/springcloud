package com.bank.irce.ltgj.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * AIRM_LTGJ_REQUEST_BODY
 * @author 
 */
@Data
public class AirmLtgjRequestBodyWithBLOBs extends AirmLtgjRequestBody implements Serializable {
    private String ltzfInfo;

    private String ltdsjInfo;

    private static final long serialVersionUID = 1L;
}