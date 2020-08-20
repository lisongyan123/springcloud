package com.bank.irce.ltgj.entity.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description
 * @Author zhuolin
 * @Date 2020/4/14 14:29
 * @Version 1.0
 */
@ApiModel(value = "授信反欺诈(征信)")
@Data
public class CreditAntiFraudDto implements Serializable {
    private String sessionid;
    private BigDecimal cd_amt;
    private String cd_stat;
    private Integer class5state;
    private String fraud_info;
    private String loan_stat;
    private BigDecimal pos_bal;
    private Integer pub_cnt;
    private BigDecimal pub_amt;
    private String repaymentduty_info;
    private float rh_crc_pro;
    private Integer rh_m12_crc_qy_num;
    private Integer rh_m12_ln_qy_num;
    private Integer rh_m12_qy_num;
    private Integer rh_m1_qy_num;
    private Integer rh_m24_acc_ovd_num;
    private Integer rh_m24_con_ovd_num;
    private Integer rh_m3_qy_num;
    private Integer rh_org_num;
    private String specialtrade_type;
    private Integer sum;
    private String unpaid_flag;
    private String casestate;

    public CreditAntiFraudDto() {
    }

    public CreditAntiFraudDto(String sessionid) {
        this.sessionid = sessionid;
        this.cd_amt = new BigDecimal(0);
        this.cd_stat = "0";
        this.class5state = 0;
        this.fraud_info = "1";
        this.loan_stat = "0";
        this.pos_bal = new BigDecimal(0);
        this.pub_cnt = 0;
        this.pub_amt =new BigDecimal(0);
        this.repaymentduty_info = "0";
        this.rh_crc_pro = (float)0.0;
        this.rh_m12_crc_qy_num = 0;
        this.rh_m12_ln_qy_num = 0;
        this.rh_m12_qy_num = 0;
        this.rh_m1_qy_num = 0;
        this.rh_m24_acc_ovd_num = 0;
        this.rh_m24_con_ovd_num = 0;
        this.rh_m3_qy_num = 0;
        this.rh_org_num = 0;
        this.specialtrade_type = "1";
        this.sum = 0;
        this.unpaid_flag = "1";
        this.casestate = "1";
    }

    public CreditAntiFraudDto(AntiFraudResVo antiFraudResVo, String sessionid) {
        this.sessionid = sessionid;
        this.specialtrade_type = antiFraudResVo.getSpecialtrade_type();
        this.sum = Integer.parseInt(antiFraudResVo.getSum().toString());
        this.class5state = antiFraudResVo.getClass5state();
        this.unpaid_flag = antiFraudResVo.getUnpaid_flag();
        this.loan_stat = antiFraudResVo.getLoan_stat();
        this.cd_stat = antiFraudResVo.getCd_stat();
        this.cd_amt =  antiFraudResVo.getCd_amt();
        this.rh_m24_acc_ovd_num = Integer.parseInt(antiFraudResVo.getRh_m24_acc_ovd_num().toString());
        this.rh_m24_con_ovd_num = Integer.parseInt(antiFraudResVo.getRh_m24_con_ovd_num().toString());
        this.rh_m12_crc_qy_num = Integer.parseInt(antiFraudResVo.getRh_m12_crc_qy_num().toString());
        this.rh_m12_ln_qy_num = Integer.parseInt(antiFraudResVo.getRh_m12_ln_qy_num().toString());
        this.rh_m12_qy_num = Integer.parseInt(antiFraudResVo.getRh_m12_qy_num().toString());
        this.rh_m3_qy_num = Integer.parseInt(antiFraudResVo.getRh_m3_qy_num().toString());
        this.rh_m1_qy_num =Integer.parseInt(antiFraudResVo.getRh_m1_qy_num().toString()) ;
        this.rh_org_num = Integer.parseInt(antiFraudResVo.getRh_org_num().toString());
        this.rh_crc_pro = antiFraudResVo.getRh_crc_pro();
        this.repaymentduty_info = antiFraudResVo.getRepaymentduty_info();
        this.fraud_info = antiFraudResVo.getFraud_info();
        this.pos_bal = antiFraudResVo.getPos_bal();
        this.pub_cnt = Integer.parseInt(antiFraudResVo.getPub_cnt().toString());
        this.pub_amt = antiFraudResVo.getPub_amt();
        this.casestate = antiFraudResVo.getCasestate();
    }
}
