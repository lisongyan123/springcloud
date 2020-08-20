package com.bank.irce.ltgj.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * AIRM_LTGJ_MASTER_BODY
 * @author 
 */
@Data
public class AirmLtgjMasterBodyWithBLOBs extends AirmLtgjMasterBody implements Serializable {
    /**
     * 联通支付信息
     */
    private String ltzfInfo;

    /**
     * 联通大数据信息
     */
    private String ltdsjInfo;

    private static final long serialVersionUID = 1L;
}