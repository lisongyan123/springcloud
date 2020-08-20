package com.bank.irce.ltgj.entity.dto;

import lombok.Data;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/7/14
 */
@Data
public class CustomerStrategyDTO {

    /**
     *唯一流水号
     */
    private String sessionid;
    /**
     * 来源：客户卡模型
     */
    private Integer cust_score;
    /**
     * 来源：资质卡模型
     */
    private Integer prodscore;
    /**
     * 来源：资质卡特征加工
     */
    private Double varifieldincome_val;
    /**
     * 来源：资质卡特征加工
     */
    private String finalcustlevel;
    /**
     * 来源：资质卡特征加工
     */
    private Double applyAmt;
    /**
     * 来源：授信接口的百融信用分部分
     */
    private Double scorerevoloan;

}
