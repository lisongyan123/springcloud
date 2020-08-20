package com.bank.irce.ltgj.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/7/14
 */
@Data
@NoArgsConstructor
public class QualificationsCardModelDTO {

    /**
     * 唯一流水号
     */
    private String sessionid;
    /**
     * 负债（保留两位）
     */
    private Double debt;
    /**
     * 征信计算负债（保留两位）
     */
    private Double debt_zx;
    /**
     * 房贷月供（保留两位）
     */
    private Double house_inst_amt;
    /**
     * 征信计算房贷月供（保留两位）
     */
    private Double house_inst_amt_zx;
    /**
     * 认定收入（保留两位）
     */
    private Double varifieldincome_val;
    /**
     * 寿险最长mob（保留两位）
     */
    private Integer insur_mob;
    /**
     * 最终评级
     */
    private String finalcustlevel;
    /**
     * 月缴保费（保留两位）
     */
    private Double inst_premium;
    /**
     * 车辆价值（保留两位）
     */
    private Double veh_price;
    /**
     * 税收月收入（保留两位）
     */
    private Double salaryincome;
    /**
     * 申请金额（保留两位）
     */
    private Double applyAmt;

    public QualificationsCardModelDTO(String sessionid) {
        this.sessionid = sessionid;
        this.debt = Double.valueOf(-1);
        this.debt_zx = Double.valueOf(-1);
        this.house_inst_amt = Double.valueOf(-1);
        this.house_inst_amt_zx = Double.valueOf(-1);
        this.varifieldincome_val = Double.valueOf(-1);
        this.insur_mob = -1;
        this.finalcustlevel = "-1";
        this.inst_premium = Double.valueOf(-1);
        this.veh_price = Double.valueOf(-1);
        this.salaryincome = Double.valueOf(-1);
        this.applyAmt = Double.valueOf(-1);
    }
}
