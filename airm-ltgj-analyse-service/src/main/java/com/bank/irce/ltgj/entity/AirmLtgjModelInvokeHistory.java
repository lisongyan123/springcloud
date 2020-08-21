package com.bank.irce.ltgj.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * AIRM_LTGJ_MODEL_INVOKE_HISTORY
 * @author 
 */
@Data
public class AirmLtgjModelInvokeHistory implements Serializable {
    private Long id;

    private String sessionId;

    private String modelName;

    private String modelNo;

    private String modelResult;

    private String requestTime;

    private String requestParams;

    private String responseParams;

    private static final long serialVersionUID = 1L;

    public AirmLtgjModelInvokeHistory(String sessionId, String requestTime,String responseParams) {
        this.sessionId = sessionId;
        this.requestTime = requestTime;
        this.responseParams = responseParams;
    }
}