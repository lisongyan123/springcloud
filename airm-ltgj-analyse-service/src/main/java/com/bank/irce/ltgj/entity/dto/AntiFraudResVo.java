package com.bank.irce.ltgj.entity.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description
 * @Author zhuolin
 * @Date 2020/4/30 19:15
 * @Version 1.0
 */
@Data
public class AntiFraudResVo implements Serializable {
    @ApiModelProperty(value = "是否有担保人代偿")
    String specialtrade_type = "";

    @ApiModelProperty(value = "近一月信用卡+贷款审批查询机构数")
    Integer sum = 0;

    @ApiModelProperty(value = "担保贷款次级及以上贷款数")
    Integer class5state = 0;

    @ApiModelProperty(value = "存在人行标识剩余期限为0，但未结清的贷款")
    String unpaid_flag = "";

    @ApiModelProperty(value = "贷款状态（1为正常）")
    String loan_stat = "";

    @ApiModelProperty(value = "信用卡状态（1为正常）")
    String cd_stat = "";

    @ApiModelProperty(value = "信用卡状态“正常”时的信用卡欠款金额")
    BigDecimal cd_amt;

    @ApiModelProperty(value = "24个月内累计逾期次数")
    Integer rh_m24_acc_ovd_num = 0;

    @ApiModelProperty(value = "24个月内最长连续逾期次数")
    Integer rh_m24_con_ovd_num = 0;

    @ApiModelProperty(value = "最近12个月信用卡审批查询数")
    Integer rh_m12_crc_qy_num = 0;

    @ApiModelProperty(value = "最近12个月贷款审批查询数")
    Integer rh_m12_ln_qy_num = 0;

    @ApiModelProperty(value = "近12个月申请查询次数")
    Integer rh_m12_qy_num = 0;

    @ApiModelProperty(value = "3个月查询次数")
    Integer rh_m3_qy_num = 0;

    @ApiModelProperty(value = "1个月查询次数")
    Integer rh_m1_qy_num = 0;

    @ApiModelProperty(value = "“发放机构”的机构总数")
    Integer rh_org_num = 0;

    @ApiModelProperty(value = "信用卡余额/授信额度占比")
    float rh_crc_pro = (float) 0;

    @ApiModelProperty(value = "相关还款责任的规则是否通过(1为不通过)")
    String repaymentduty_info = "";

    @ApiModelProperty(value = "是否存在有效的防欺诈警示信息(1为存在)")
    String fraud_info = "";

    @ApiModelProperty(value = "后付费业务的欠款金额")
    BigDecimal pos_bal = new BigDecimal(0);

    @ApiModelProperty(value = "公共信息汇总的记录数汇总")
    Integer pub_cnt = 0;

    @ApiModelProperty(value = "公共信息涉及金额")
    BigDecimal pub_amt = new BigDecimal(0);

    @ApiModelProperty(value = "案件状态")
    String casestate = "";

    public AntiFraudResVo() {
        initDefaultAntiFraudVO();
    }

    public void initDefaultAntiFraudVO() {
        this.specialtrade_type = "1";
        this.sum = 0;
        this.unpaid_flag = "1";
        this.loan_stat = "0";
        this.cd_stat = "0";
        this.cd_amt=new BigDecimal(0);
        this.rh_m24_con_ovd_num = 0;
        this.rh_org_num = 0;
        this.rh_crc_pro = 0;
        this.repaymentduty_info = "0";
        this.fraud_info = "1";
        this.pos_bal = new BigDecimal(0);
        this.pub_cnt = 0;
        this.pub_amt = new BigDecimal(0);
        this.casestate = "1";
        this.class5state=0;
        this.rh_m24_acc_ovd_num=0;
    }

    public AntiFraudResVo(String sessionId){
        this.specialtrade_type = "1";
        this.sum = 0;
        this.class5state = 0;
        this.unpaid_flag = "1";
        this.loan_stat = "0";
        this.cd_stat = "0";
        this.cd_amt = new BigDecimal(0);
        this.rh_m24_acc_ovd_num = 0;
        this.rh_m24_con_ovd_num = 0;
        this.rh_m12_crc_qy_num = 0;
        this.rh_m12_ln_qy_num = 0;
        this.rh_m12_qy_num = 0;
        this.rh_m3_qy_num = 0;
        this.rh_m1_qy_num = 0;
        this.rh_org_num = 0;
        this.rh_crc_pro = 0;
        this.repaymentduty_info = "0";
        this.fraud_info = "1";
        this.pos_bal = new BigDecimal(0);
        this.pub_cnt = 0;
        this.pub_amt = new BigDecimal(0);
        this.casestate = "1";
    }

}
