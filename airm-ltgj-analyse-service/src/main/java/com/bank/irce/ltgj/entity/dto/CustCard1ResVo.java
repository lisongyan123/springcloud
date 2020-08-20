package com.bank.irce.ltgj.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value = "征信客户卡指标")
public class CustCard1ResVo implements Serializable {
    //    @ApiModelProperty(value = "最近12个月所有产品审批查询数")
//    Integer rh_m12_cr_qy_num = -999;
    @ApiModelProperty(value = "最近12个月信用卡审批查询数")
    Integer rh_m12_crc_qy_num = -999;
    @ApiModelProperty(value = "最近12个月贷款审批查询数")
    Integer rh_m12_ln_qy_num = -999;
    //    @ApiModelProperty(value = "最近6个月信用卡审批查询数")
//    Integer rh_m6_crc_qy_num = 0;
//    @ApiModelProperty(value = "最近6个月贷款审批查询数")
//    Integer rh_m6_ln_qy_num = 0;
//    @ApiModelProperty(value = "最近6个月所有产品审批查询数")
//    Integer rh_m6_cr_qy_num = 0;
//    @ApiModelProperty(value = "贷款汇总_法人机构数")
//    Integer rh_ln_corg_num = 0;
//    @ApiModelProperty(value = "所有产品 授信总额")
//    BigDecimal rh_cr_lim_amt = null;
//    @ApiModelProperty(value = "贷记卡汇总_最近6个月平均额度使用率")
//    BigDecimal rh_m6_lncd_ud_pro = new BigDecimal(0);
    @ApiModelProperty(value = "信用卡汇总_透支余额/信用额度")
    BigDecimal rh_crc_ud_pro = new BigDecimal(-999);
    //    @ApiModelProperty(value = "过去6个月所有产品有过逾期的月数")
//    Integer rh_m6_cr_ovd_mon = -999;
    @ApiModelProperty(value = "过去24个月所有产品有过逾期的月数")
    Integer rh_m24_cr_ovd_mon = -999;
    //    @ApiModelProperty(value = "所有产品开立距今最大时长")
//    Integer rh_cr_uc_max_age = 0;
    @ApiModelProperty(value = "信用卡开立距今最大时长")
    Integer rh_crc_uc_max_age = -999;
    @ApiModelProperty(value = "贷款开立距今最小时长")
    Integer rh_ln_uc_min_age = -999;
    //    @ApiModelProperty(value = "是否有房贷")
//    Integer rh_if_houseln = 0;
    @ApiModelProperty(value = "信用卡当前逾期金额")
    Integer rh_crc_ovd_amt = -999;
    @ApiModelProperty(value = "过去24个月信用卡最大逾期期数")
    Integer rh_m24_crc_ovd_max_perd = -999;
    //    @ApiModelProperty(value = "近12个月所有产品查询失败次数")
//    Integer rh_m12_cr_qyf_num = 0;
//    @ApiModelProperty(value = "近12个月所有产品查询失败机构数")
//    Integer rh_m12_cr_qyf_org_num = 0;

    public CustCard1ResVo() {
    }
    public CustCard1ResVo(Integer rh_m12_crc_qy_num, Integer rh_m12_ln_qy_num, BigDecimal rh_crc_ud_pro, Integer rh_m24_cr_ovd_mon, Integer rh_crc_uc_max_age, Integer rh_ln_uc_min_age, Integer rh_crc_ovd_amt, Integer rh_m24_crc_ovd_max_perd) {
        this.rh_m12_crc_qy_num = rh_m12_crc_qy_num;
        this.rh_m12_ln_qy_num = rh_m12_ln_qy_num;
        this.rh_crc_ud_pro = rh_crc_ud_pro;
        this.rh_m24_cr_ovd_mon = rh_m24_cr_ovd_mon;
        this.rh_crc_uc_max_age = rh_crc_uc_max_age;
        this.rh_ln_uc_min_age = rh_ln_uc_min_age;
        this.rh_crc_ovd_amt = rh_crc_ovd_amt;
        this.rh_m24_crc_ovd_max_perd = rh_m24_crc_ovd_max_perd;
    }
    public CustCard1ResVo(String sessionId) {
        this.rh_m12_crc_qy_num = -999;
        this.rh_m12_ln_qy_num = -999;
        this.rh_crc_ud_pro = new BigDecimal(-999);
        this.rh_m24_cr_ovd_mon = -999;
        this.rh_crc_uc_max_age = -999;
        this.rh_ln_uc_min_age = -999;
        this.rh_crc_ovd_amt = -999;
        this.rh_m24_crc_ovd_max_perd = -999;
    }
}
