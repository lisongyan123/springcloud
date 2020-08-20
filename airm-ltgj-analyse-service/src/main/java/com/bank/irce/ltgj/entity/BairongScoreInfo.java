package com.bank.irce.ltgj.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * BAIRONG_SCORE_INFO
 * @author 
 */
@Data
public class BairongScoreInfo implements Serializable {
    private String outCode;

    private String outDesc;

    private String sid;

    private String sendType;

    private String fileName;

    private String returnBody;

    private static final long serialVersionUID = 1L;
}