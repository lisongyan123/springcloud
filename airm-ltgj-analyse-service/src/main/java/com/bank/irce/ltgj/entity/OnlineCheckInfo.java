package com.bank.irce.ltgj.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ONLINE_CHECK_INFO
 * @author 
 */
@Data
public class OnlineCheckInfo implements Serializable {
    private String resultFlag;

    private String tlrseq;

    private static final long serialVersionUID = 1L;
}