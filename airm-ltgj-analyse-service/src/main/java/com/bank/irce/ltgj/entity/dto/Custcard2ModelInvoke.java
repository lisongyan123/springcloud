package com.bank.irce.ltgj.entity.dto;

import com.bank.irce.ltgj.common.DateUtil;
import com.bank.irce.ltgj.common.ResponseData;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/7/21
 */
@Data
@TableName(value = "AIRM_FXGD_MODEL_INVOKE_CUST2")
@KeySequence(value = "MODEL_INVOKE_HISTORY_ID_SEQ")
public class Custcard2ModelInvoke {
    @TableId(value = "ID", type = IdType.INPUT)
    private Integer id;
    private String appNo;
    private String sessionId;
    private String custId;

    @TableField("queryreason")
    private BigDecimal queryreason;
    @TableField("gender")
    private BigDecimal gender;
    @TableField("maritalstate")
    private BigDecimal maritalstate;
    @TableField("edulevel")
    private BigDecimal edulevel;
    @TableField("edudegree")
    private BigDecimal edudegree;
    @TableField("residencetype")
    private BigDecimal residencetype;
    @TableField("occupation")
    private BigDecimal occupation;
    @TableField("industry")
    private BigDecimal industry;
    @TableField("duty")
    private BigDecimal duty;
    @TableField("accfund_state")
    private BigDecimal accfund_state;
    @TableField("accfund_pay")
    private BigDecimal accfund_pay;
    @TableField("ownprent")
    private BigDecimal ownprent;
    @TableField("comprent")
    private BigDecimal comprent;
    @TableField("apply_age")
    private BigDecimal apply_age;
    @TableField("residence_province_num")
    private BigDecimal residence_province_num;
    @TableField("residence_type_num")
    private BigDecimal residence_type_num;
    @TableField("industry_num")
    private BigDecimal industry_num;
    @TableField("rh_bs_accf_cur_mon")
    private BigDecimal rh_bs_accf_cur_mon;
    @TableField("rh_bs_accf_his_mon")
    private BigDecimal rh_bs_accf_his_mon;
    @TableField("rh_bs_accf_base")
    private BigDecimal rh_bs_accf_base;
    @TableField("rh_bs_industry_mat")
    private BigDecimal rh_bs_industry_mat;
    @TableField("rh_bs_work_last_sta")
    private BigDecimal rh_bs_work_last_sta;
    @TableField("rh_lncd_num")
    private BigDecimal rh_lncd_num;
    @TableField("rh_lncd_uc_num")
    private BigDecimal rh_lncd_uc_num;
    @TableField("rh_lncd_nr_num")
    private BigDecimal rh_lncd_nr_num;
    @TableField("rh_lncd_nopen_num")
    private BigDecimal rh_lncd_nopen_num;
    @TableField("rh_lncd_cancel_num")
    private BigDecimal rh_lncd_cancel_num;
    @TableField("rh_lncd_oc_num")
    private BigDecimal rh_lncd_oc_num;
    @TableField("rh_lncd_sum_cr_lmt")
    private BigDecimal rh_lncd_sum_cr_lmt;
    @TableField("rh_lncd_avg_cr_lmt")
    private BigDecimal rh_lncd_avg_cr_lmt;
    @TableField("rh_lncd_mn_cr_lmt")
    private BigDecimal rh_lncd_mn_cr_lmt;
    @TableField("rh_lncd_uc_lmt_max")
    private BigDecimal rh_lncd_uc_lmt_max;
    @TableField("rh_lncd_uc_lmt_min")
    private BigDecimal rh_lncd_uc_lmt_min;
    @TableField("rh_lncd_sum_sd_lmt")
    private BigDecimal rh_lncd_sum_sd_lmt;
    @TableField("rh_lncd_avg_sd_lmt")
    private BigDecimal rh_lncd_avg_sd_lmt;
    @TableField("rh_lncd_mn_sd_lmt")
    private BigDecimal rh_lncd_mn_sd_lmt;
    @TableField("rh_lncd_max_sd_lmt")
    private BigDecimal rh_lncd_max_sd_lmt;
    @TableField("rh_lncd_min_sd_lmt")
    private BigDecimal rh_lncd_min_sd_lmt;
    @TableField("rh_lncd_sum_nr_cr_lmt")
    private BigDecimal rh_lncd_sum_nr_cr_lmt;
    @TableField("rh_lncd_nr_avg_cr_lmt")
    private BigDecimal rh_lncd_nr_avg_cr_lmt;
    @TableField("rh_lncd_nr_mn_cr_lmt")
    private BigDecimal rh_lncd_nr_mn_cr_lmt;
    @TableField("rh_lncd_max_nr_cr_lmt")
    private BigDecimal rh_lncd_max_nr_cr_lmt;
    @TableField("rh_lncd_nr_min_cr_lmt")
    private BigDecimal rh_lncd_nr_min_cr_lmt;
    @TableField("rh_lncd_sum_nr_sd_lmt")
    private BigDecimal rh_lncd_sum_nr_sd_lmt;
    @TableField("rh_lncd_nr_avg_sd_lmt")
    private BigDecimal rh_lncd_nr_avg_sd_lmt;
    @TableField("rh_lncd_nr_mn_sd_lmt")
    private BigDecimal rh_lncd_nr_mn_sd_lmt;
    @TableField("rh_lncd_max_nr_sd_lmt")
    private BigDecimal rh_lncd_max_nr_sd_lmt;
    @TableField("rh_lncd_nr_min_sd_lmt")
    private BigDecimal rh_lncd_nr_min_sd_lmt;
    @TableField("rh_lncd_sum_ud_cr_lmt")
    private BigDecimal rh_lncd_sum_ud_cr_lmt;
    @TableField("rh_lncd_mn_ud_cr_lmt")
    private BigDecimal rh_lncd_mn_ud_cr_lmt;
    @TableField("rh_lncd_max_ud_cr_lmt")
    private BigDecimal rh_lncd_max_ud_cr_lmt;
    @TableField("rh_lncd_min_ud_cr_lmt")
    private BigDecimal rh_lncd_min_ud_cr_lmt;
    @TableField("rh_lncd_sum_nr_ud_cr_lmt")
    private BigDecimal rh_lncd_sum_nr_ud_cr_lmt;
    @TableField("rh_lncd_nr_avg_ud_cr_lmt")
    private BigDecimal rh_lncd_nr_avg_ud_cr_lmt;
    @TableField("rh_lncd_nr_mn_ud_cr_lmt")
    private BigDecimal rh_lncd_nr_mn_ud_cr_lmt;
    @TableField("rh_lncd_max_nr_ud_cr_lmt")
    private BigDecimal rh_lncd_max_nr_ud_cr_lmt;
    @TableField("rh_lncd_nr_min_ud_cr_lmt")
    private BigDecimal rh_lncd_nr_min_ud_cr_lmt;
    @TableField("rh_lncd_uc_max_amt_pro")
    private BigDecimal rh_lncd_uc_max_amt_pro;
    @TableField("rh_lncd_avg_ud_cr_lmt_pr")
    private BigDecimal rh_lncd_avg_ud_cr_lmt_pr;
    @TableField("rh_lncd_mn_ud_cr_lmt_pr")
    private BigDecimal rh_lncd_mn_ud_cr_lmt_pr;
    @TableField("rh_lncd_sum_ud_cr_lmt_pr")
    private BigDecimal rh_lncd_sum_ud_cr_lmt_pr;
    @TableField("rh_lncd_max_ud_sd_lmt_pr")
    private BigDecimal rh_lncd_max_ud_sd_lmt_pr;
    @TableField("rh_lncd_min_ud_sd_lmt_pr")
    private BigDecimal rh_lncd_min_ud_sd_lmt_pr;
    @TableField("rh_lncd_avg_ud_sd_lmt_pr")
    private BigDecimal rh_lncd_avg_ud_sd_lmt_pr;
    @TableField("rh_lncd_mn_ud_sd_lmt_pr")
    private BigDecimal rh_lncd_mn_ud_sd_lmt_pr;
    @TableField("rh_lncd_sum_ud_sd_lmt_pr")
    private BigDecimal rh_lncd_sum_ud_sd_lmt_pr;
    @TableField("rh_lncd_max_nr_ud_cr_lmt_pr")
    private BigDecimal rh_lncd_max_nr_ud_cr_lmt_pr;
    @TableField("rh_lncd_nr_avg_ud_cr_lmt_pr")
    private BigDecimal rh_lncd_nr_avg_ud_cr_lmt_pr;
    @TableField("rh_lncd_nr_mn_ud_cr_lmt_pr")
    private BigDecimal rh_lncd_nr_mn_ud_cr_lmt_pr;
    @TableField("rh_lncd_sum_nr_ud_cr_lmt_pr")
    private BigDecimal rh_lncd_sum_nr_ud_cr_lmt_pr;
    @TableField("rh_lncd_max_nr_ud_sd_lmt_pr")
    private BigDecimal rh_lncd_max_nr_ud_sd_lmt_pr;
    @TableField("rh_lncd_nr_min_ud_sd_lmt_pr")
    private BigDecimal rh_lncd_nr_min_ud_sd_lmt_pr;
    @TableField("rh_lncd_nr_avg_ud_sd_lmt_pr")
    private BigDecimal rh_lncd_nr_avg_ud_sd_lmt_pr;
    @TableField("rh_lncd_nr_mn_ud_sd_lmt_pr")
    private BigDecimal rh_lncd_nr_mn_ud_sd_lmt_pr;
    @TableField("rh_lncd_sum_nr_ud_sd_lmt_pr")
    private BigDecimal rh_lncd_sum_nr_ud_sd_lmt_pr;
    @TableField("rh_lncd_avg_m6avg_ud_amt")
    private BigDecimal rh_lncd_avg_m6avg_ud_amt;
    @TableField("rh_lncd_max_m6avg_ud_amt")
    private BigDecimal rh_lncd_max_m6avg_ud_amt;
    @TableField("rh_lncd_avg_max_ud_amt")
    private BigDecimal rh_lncd_avg_max_ud_amt;
    @TableField("rh_lncd_max_max_ud_amt")
    private BigDecimal rh_lncd_max_max_ud_amt;
    @TableField("rh_lncd_sum_max_ud_amt")
    private BigDecimal rh_lncd_sum_max_ud_amt;
    @TableField("rh_lncd_avg_curdef_amt")
    private BigDecimal rh_lncd_avg_curdef_amt;
    @TableField("rh_lncd_max_curdef_amt")
    private BigDecimal rh_lncd_max_curdef_amt;
    @TableField("rh_lncd_ovd_ct_2y_rp")
    private BigDecimal rh_lncd_ovd_ct_2y_rp;
    @TableField("rh_lncd_ovd_ct_3y_rp")
    private BigDecimal rh_lncd_ovd_ct_3y_rp;
    @TableField("rh_m24_lncd_ovd_max_perd")
    private BigDecimal rh_m24_lncd_ovd_max_perd;
    @TableField("rh_lncd_max_sd_lmt_m6")
    private BigDecimal rh_lncd_max_sd_lmt_m6;
    @TableField("rh_lncd_sum_nr_cr_lmt_m6")
    private BigDecimal rh_lncd_sum_nr_cr_lmt_m6;
    @TableField("rh_lncd_nr_avg_cr_lmt_m6")
    private BigDecimal rh_lncd_nr_avg_cr_lmt_m6;
    @TableField("rh_lncd_nr_mn_cr_lmt_m6")
    private BigDecimal rh_lncd_nr_mn_cr_lmt_m6;
    @TableField("rh_lncd_mn_cr_lmt_m12")
    private BigDecimal rh_lncd_mn_cr_lmt_m12;
    @TableField("rh_lncd_nr_mn_cr_lmt_m12")
    private BigDecimal rh_lncd_nr_mn_cr_lmt_m12;
    @TableField("rh_lncd_lim_org_ds_num")
    private BigDecimal rh_lncd_lim_org_ds_num;
    @TableField("rh_lncd_od180amt_sum_amt")
    private BigDecimal rh_lncd_od180amt_sum_amt;
    @TableField("rh_lncd_mid_ovd_num")
    private BigDecimal rh_lncd_mid_ovd_num;
    @TableField("rh_lncd_per_num")
    private BigDecimal rh_lncd_per_num;
    @TableField("rh_lncd_old_age")
    private BigDecimal rh_lncd_old_age;
    @TableField("rh_lncd_detail_max_age")
    private BigDecimal rh_lncd_detail_max_age;
    @TableField("rh_stlncd_nr_num")
    private BigDecimal rh_stlncd_nr_num;
    @TableField("rh_stlncd_nopen_num")
    private BigDecimal rh_stlncd_nopen_num;
    @TableField("rh_stlncd_cancel_num")
    private BigDecimal rh_stlncd_cancel_num;
    @TableField("rh_stlncd_oc_num")
    private BigDecimal rh_stlncd_oc_num;
    @TableField("rh_stlncd_avg_cr_lmt")
    private BigDecimal rh_stlncd_avg_cr_lmt;
    @TableField("rh_stlncd_mn_cr_lmt")
    private BigDecimal rh_stlncd_mn_cr_lmt;
    @TableField("rh_stlncd_mn_sd_lmt")
    private BigDecimal rh_stlncd_mn_sd_lmt;
    @TableField("rh_stlncd_nr_mn_cr_lmt")
    private BigDecimal rh_stlncd_nr_mn_cr_lmt;
    @TableField("rh_stlncd_nr_max_cr_lmt")
    private BigDecimal rh_stlncd_nr_max_cr_lmt;
    @TableField("rh_stlncd_nr_sum_sd_lmt")
    private BigDecimal rh_stlncd_nr_sum_sd_lmt;
    @TableField("rh_stlncd_nr_avg_sd_lmt")
    private BigDecimal rh_stlncd_nr_avg_sd_lmt;
    @TableField("rh_stlncd_nr_mn_sd_lmt")
    private BigDecimal rh_stlncd_nr_mn_sd_lmt;
    @TableField("rh_stlncd_mn_ud_cr_lmt")
    private BigDecimal rh_stlncd_mn_ud_cr_lmt;
    @TableField("rh_stlncd_nr_sum_ud_cr_lmt")
    private BigDecimal rh_stlncd_nr_sum_ud_cr_lmt;
    @TableField("rh_stlncd_nr_min_ud_cr_lmt")
    private BigDecimal rh_stlncd_nr_min_ud_cr_lmt;
    @TableField("rh_stlncd_uc_max_amt_pro")
    private BigDecimal rh_stlncd_uc_max_amt_pro;
    @TableField("rh_stlncd_mn_ud_cr_lmt_pr")
    private BigDecimal rh_stlncd_mn_ud_cr_lmt_pr;
    @TableField("rh_stlncd_sum_ud_cr_lmt_pr")
    private BigDecimal rh_stlncd_sum_ud_cr_lmt_pr;
    @TableField("rh_stlncd_sum_ud_sd_lmt_pr")
    private BigDecimal rh_stlncd_sum_ud_sd_lmt_pr;
    @TableField("rh_stlncd_nr_max_ud_cr_lmt_pr")
    private BigDecimal rh_stlncd_nr_max_ud_cr_lmt_pr;
    @TableField("rh_stlncd_nr_avg_ud_cr_lmt_pr")
    private BigDecimal rh_stlncd_nr_avg_ud_cr_lmt_pr;
    @TableField("rh_stlncd_nr_mn_ud_cr_lmt_pr")
    private BigDecimal rh_stlncd_nr_mn_ud_cr_lmt_pr;
    @TableField("rh_stlncd_nr_sum_ud_cr_lmt_pr")
    private BigDecimal rh_stlncd_nr_sum_ud_cr_lmt_pr;
    @TableField("rh_stlncd_nr_max_ud_sd_lmt_pr")
    private BigDecimal rh_stlncd_nr_max_ud_sd_lmt_pr;
    @TableField("rh_stlncd_nr_avg_ud_sd_lmt_pr")
    private BigDecimal rh_stlncd_nr_avg_ud_sd_lmt_pr;
    @TableField("rh_stlncd_nr_sum_ud_sd_lmt_pr")
    private BigDecimal rh_stlncd_nr_sum_ud_sd_lmt_pr;
    @TableField("rh_stlncd_avg_max_ud_amt")
    private BigDecimal rh_stlncd_avg_max_ud_amt;
    @TableField("rh_stlncd_max_max_ud_amt")
    private BigDecimal rh_stlncd_max_max_ud_amt;
    @TableField("rh_stlncd_sum_max_ud_amt")
    private BigDecimal rh_stlncd_sum_max_ud_amt;
    @TableField("rh_stlncd_ovd_ct_2y_rp")
    private BigDecimal rh_stlncd_ovd_ct_2y_rp;
    @TableField("rh_stlncd_nonpmf_ct_2y_rp")
    private BigDecimal rh_stlncd_nonpmf_ct_2y_rp;
    @TableField("rh_stlncd_nr_sum_cr_lmt_m6")
    private BigDecimal rh_stlncd_nr_sum_cr_lmt_m6;
    @TableField("rh_stlncd_od180amt_sum_amt")
    private BigDecimal rh_stlncd_od180amt_sum_amt;
    @TableField("rh_crc_nr_mn_cr_lmt")
    private BigDecimal rh_crc_nr_mn_cr_lmt;
    @TableField("rh_crc_mn_ud_cr_lmt")
    private BigDecimal rh_crc_mn_ud_cr_lmt;
    @TableField("rh_crc_uc_max_amt_pro")
    private BigDecimal rh_crc_uc_max_amt_pro;
    @TableField("rh_crc_uc_min_amt_pro")
    private BigDecimal rh_crc_uc_min_amt_pro;
    @TableField("rh_crc_avg_ud_cr_lmt_pr")
    private BigDecimal rh_crc_avg_ud_cr_lmt_pr;
    @TableField("rh_crc_mn_ud_cr_lmt_pr")
    private BigDecimal rh_crc_mn_ud_cr_lmt_pr;
    @TableField("rh_crc_max_ud_sd_lmt_pr")
    private BigDecimal rh_crc_max_ud_sd_lmt_pr;
    @TableField("rh_crc_min_ud_sd_lmt_pr")
    private BigDecimal rh_crc_min_ud_sd_lmt_pr;
    @TableField("rh_crc_max_nr_ud_cr_lmt_pr")
    private BigDecimal rh_crc_max_nr_ud_cr_lmt_pr;
    @TableField("rh_crc_nr_min_ud_cr_lmt_pr")
    private BigDecimal rh_crc_nr_min_ud_cr_lmt_pr;
    @TableField("rh_crc_nr_avg_ud_cr_lmt_pr")
    private BigDecimal rh_crc_nr_avg_ud_cr_lmt_pr;
    @TableField("rh_crc_nr_mn_ud_cr_lmt_pr")
    private BigDecimal rh_crc_nr_mn_ud_cr_lmt_pr;
    @TableField("rh_crc_max_nr_ud_sd_lmt_pr")
    private BigDecimal rh_crc_max_nr_ud_sd_lmt_pr;
    @TableField("rh_crc_nr_min_ud_sd_lmt_pr")
    private BigDecimal rh_crc_nr_min_ud_sd_lmt_pr;
    @TableField("rh_crc_nr_mn_ud_sd_lmt_pr")
    private BigDecimal rh_crc_nr_mn_ud_sd_lmt_pr;
    @TableField("rh_crc_min_age")
    private BigDecimal rh_crc_min_age;
    @TableField("rh_crc_uc_max_age")
    private BigDecimal rh_crc_uc_max_age;
    @TableField("rh_crc_avg_max_ud_amt")
    private BigDecimal rh_crc_avg_max_ud_amt;
    @TableField("rh_crc_sum_max_ud_amt")
    private BigDecimal rh_crc_sum_max_ud_amt;
    @TableField("rh_crc_ovd_ct_2y_rp")
    private BigDecimal rh_crc_ovd_ct_2y_rp;
    @TableField("rh_crc_ovd_ct_3y_rp")
    private BigDecimal rh_crc_ovd_ct_3y_rp;
    @TableField("rh_crc_max_sd_lmt_m6")
    private BigDecimal rh_crc_max_sd_lmt_m6;
    @TableField("rh_crc_sum_nr_cr_lmt_m6")
    private BigDecimal rh_crc_sum_nr_cr_lmt_m6;
    @TableField("rh_crc_nr_avg_cr_lmt_m6")
    private BigDecimal rh_crc_nr_avg_cr_lmt_m6;
    @TableField("rh_crc_nr_mn_cr_lmt_m6")
    private BigDecimal rh_crc_nr_mn_cr_lmt_m6;
    @TableField("rh_crc_sum_nr_cr_lmt_m12")
    private BigDecimal rh_crc_sum_nr_cr_lmt_m12;
    @TableField("rh_crc_od180amt_sum_amt")
    private BigDecimal rh_crc_od180amt_sum_amt;
    @TableField("rh_crc_max_age")
    private BigDecimal rh_crc_max_age;
    @TableField("rh_ln_num")
    private BigDecimal rh_ln_num;
    @TableField("rh_ln_nr_num")
    private BigDecimal rh_ln_nr_num;
    @TableField("rh_ln_clear_num")
    private BigDecimal rh_ln_clear_num;
    @TableField("rh_ln_max_amt")
    private BigDecimal rh_ln_max_amt;
    @TableField("rh_ln_avg_amt")
    private BigDecimal rh_ln_avg_amt;
    @TableField("rh_ln_max_bal")
    private BigDecimal rh_ln_max_bal;
    @TableField("rh_ln_avg_bal")
    private BigDecimal rh_ln_avg_bal;
    @TableField("rh_ln_min_bal_pr")
    private BigDecimal rh_ln_min_bal_pr;
    @TableField("rh_ln_max_bal_pr")
    private BigDecimal rh_ln_max_bal_pr;
    @TableField("rh_ln_type_num")
    private BigDecimal rh_ln_type_num;
    @TableField("rh_ln_st_flag")
    private BigDecimal rh_ln_st_flag;
    @TableField("rh_ln_st_adva")
    private BigDecimal rh_ln_st_adva;
    @TableField("rh_ln_st_advp")
    private BigDecimal rh_ln_st_advp;
    @TableField("rh_ln_st_oth")
    private BigDecimal rh_ln_st_oth;
    @TableField("rh_ln_uc_max_age")
    private BigDecimal rh_ln_uc_max_age;
    @TableField("rh_if_houseln")
    private BigDecimal rh_if_houseln;
    @TableField("rh_ln_avg_bal_m6")
    private BigDecimal rh_ln_avg_bal_m6;
    @TableField("rh_ln_min_bal_pr_m6")
    private BigDecimal rh_ln_min_bal_pr_m6;
    @TableField("rh_ln_sum_amt_m12")
    private BigDecimal rh_ln_sum_amt_m12;
    @TableField("rh_ln_max_amt_m12")
    private BigDecimal rh_ln_max_amt_m12;
    @TableField("rh_ln_avg_amt_m12")
    private BigDecimal rh_ln_avg_amt_m12;
    @TableField("rh_ln_sum_bal_m12")
    private BigDecimal rh_ln_sum_bal_m12;
    @TableField("rh_ln_max_bal_m12")
    private BigDecimal rh_ln_max_bal_m12;
    @TableField("rh_5state_nr_num")
    private BigDecimal rh_5state_nr_num;
    @TableField("rh_5state_good_pr")
    private BigDecimal rh_5state_good_pr;
    @TableField("rh_ln_ovd_cur_amt_rp")
    private BigDecimal rh_ln_ovd_cur_amt_rp;
    @TableField("rh_ln_ovd_max_2y_rp")
    private BigDecimal rh_ln_ovd_max_2y_rp;
    @TableField("rh_ln_nonpmf_ct_2y_rp")
    private BigDecimal rh_ln_nonpmf_ct_2y_rp;
    @TableField("rh_carln_num")
    private BigDecimal rh_carln_num;
    @TableField("rh_carln_sum_amt")
    private BigDecimal rh_carln_sum_amt;
    @TableField("rh_carln_avg_amt")
    private BigDecimal rh_carln_avg_amt;
    @TableField("rh_carln_min_bal_pr")
    private BigDecimal rh_carln_min_bal_pr;
    @TableField("rh_carln_st_adva")
    private BigDecimal rh_carln_st_adva;
    @TableField("rh_carln_curodamt")
    private BigDecimal rh_carln_curodamt;
    @TableField("rh_hsln_sum_amt")
    private BigDecimal rh_hsln_sum_amt;
    @TableField("rh_hsln_max_amt")
    private BigDecimal rh_hsln_max_amt;
    @TableField("rh_hsln_avg_amt")
    private BigDecimal rh_hsln_avg_amt;
    @TableField("rh_hsln_sum_bal")
    private BigDecimal rh_hsln_sum_bal;
    @TableField("rh_hsln_avg_bal")
    private BigDecimal rh_hsln_avg_bal;
    @TableField("rh_hsln_min_bal_pr")
    private BigDecimal rh_hsln_min_bal_pr;
    @TableField("rh_hsln_max_bal_pr")
    private BigDecimal rh_hsln_max_bal_pr;
    @TableField("rh_opln_num")
    private BigDecimal rh_opln_num;
    @TableField("rh_opln_nr_num")
    private BigDecimal rh_opln_nr_num;
    @TableField("rh_opln_clear_num")
    private BigDecimal rh_opln_clear_num;
    @TableField("rh_opln_max_amt")
    private BigDecimal rh_opln_max_amt;
    @TableField("rh_opln_max_bal")
    private BigDecimal rh_opln_max_bal;
    @TableField("rh_opln_avg_bal")
    private BigDecimal rh_opln_avg_bal;
    @TableField("rh_opln_min_bal_pr")
    private BigDecimal rh_opln_min_bal_pr;
    @TableField("rh_opln_st_adva")
    private BigDecimal rh_opln_st_adva;
    @TableField("rh_agln_max_bal")
    private BigDecimal rh_agln_max_bal;
    @TableField("rh_ln_bal_num")
    private BigDecimal rh_ln_bal_num;
    @TableField("rh_ln_avg_pay_amt")
    private BigDecimal rh_ln_avg_pay_amt;
    @TableField("rh_longln_sum_pay_amt")
    private BigDecimal rh_longln_sum_pay_amt;
    @TableField("rh_hsln_sum_num")
    private BigDecimal rh_hsln_sum_num;
    @TableField("rh_ln_m12_ovd_sum_num")
    private BigDecimal rh_ln_m12_ovd_sum_num;
    @TableField("rh_perbushslnct_rp")
    private BigDecimal rh_perbushslnct_rp;
    @TableField("rh_perhslnct_rp")
    private BigDecimal rh_perhslnct_rp;
    @TableField("rh_otlnct_rp")
    private BigDecimal rh_otlnct_rp;
    @TableField("rh_ln_max_age")
    private BigDecimal rh_ln_max_age;
    @TableField("rh_lncd_max_age")
    private BigDecimal rh_lncd_max_age;
    @TableField("rh_lncd_ovd_num")
    private BigDecimal rh_lncd_ovd_num;
    @TableField("rh_sum_ovd_num")
    private BigDecimal rh_sum_ovd_num;
    @TableField("rh_ln_ovd_mon")
    private BigDecimal rh_ln_ovd_mon;
    @TableField("rh_ln_ovd_hgst_amt")
    private BigDecimal rh_ln_ovd_hgst_amt;
    @TableField("rh_ln_ovd_dur")
    private BigDecimal rh_ln_ovd_dur;
    @TableField("rh_lncd_ovd_mon")
    private BigDecimal rh_lncd_ovd_mon;
    @TableField("rh_lncd_ovd_hgst_amt")
    private BigDecimal rh_lncd_ovd_hgst_amt;
    @TableField("rh_lncd_ovd_dur")
    private BigDecimal rh_lncd_ovd_dur;
    @TableField("rh_sum_ovd_mon")
    private BigDecimal rh_sum_ovd_mon;
    @TableField("rh_max_ovd_mon")
    private BigDecimal rh_max_ovd_mon;
    @TableField("rh_avg_ovd_mon")
    private BigDecimal rh_avg_ovd_mon;
    @TableField("rh_sum_ovd_hgst_amt")
    private BigDecimal rh_sum_ovd_hgst_amt;
    @TableField("rh_max_ovd_hgst_amt")
    private BigDecimal rh_max_ovd_hgst_amt;
    @TableField("rh_avg_ovd_hgst_amt")
    private BigDecimal rh_avg_ovd_hgst_amt;
    @TableField("rh_mn_ovd_hgst_amt")
    private BigDecimal rh_mn_ovd_hgst_amt;
    @TableField("rh_sum_ovd_dur")
    private BigDecimal rh_sum_ovd_dur;
    @TableField("rh_max_ovd_dur")
    private BigDecimal rh_max_ovd_dur;
    @TableField("rh_uc_ln_bal")
    private BigDecimal rh_uc_ln_bal;
    @TableField("rh_uc_ln_amt")
    private BigDecimal rh_uc_ln_amt;
    @TableField("rh_uc_ln_m6avg_amt")
    private BigDecimal rh_uc_ln_m6avg_amt;
    @TableField("rh_ln_corg_num")
    private BigDecimal rh_ln_corg_num;
    @TableField("rh_ln_org_num")
    private BigDecimal rh_ln_org_num;
    @TableField("rh_lncd_ud_amt")
    private BigDecimal rh_lncd_ud_amt;
    @TableField("rh_lncd_uc_ud_pro")
    private BigDecimal rh_lncd_uc_ud_pro;
    @TableField("rh_m6_lncd_ud_pro")
    private BigDecimal rh_m6_lncd_ud_pro;
    @TableField("rh_lncd_uc_max_lmt_pro")
    private BigDecimal rh_lncd_uc_max_lmt_pro;
    @TableField("rh_cr_sum_bal")
    private BigDecimal rh_cr_sum_bal;
    @TableField("rh_ln_bal_pral")
    private BigDecimal rh_ln_bal_pral;
    @TableField("rh_cd_bal_pral")
    private BigDecimal rh_cd_bal_pral;
    @TableField("rh_cr_lim_amt")
    private BigDecimal rh_cr_lim_amt;
    @TableField("rh_ln_amt_pral")
    private BigDecimal rh_ln_amt_pral;
    @TableField("rh_cd_amt_pral")
    private BigDecimal rh_cd_amt_pral;
    @TableField("rh_gr_sum_amt")
    private BigDecimal rh_gr_sum_amt;
    @TableField("rh_gr_tol_bal")
    private BigDecimal rh_gr_tol_bal;
    @TableField("rh_cr_num")
    private BigDecimal rh_cr_num;
    @TableField("rh_lncd_cr_uc_num_pro")
    private BigDecimal rh_lncd_cr_uc_num_pro;
    @TableField("rh_cr_bal_pro")
    private BigDecimal rh_cr_bal_pro;
    @TableField("rh_crc_ud_pro")
    private BigDecimal rh_crc_ud_pro;
    @TableField("rh_cr_ovd_max_amt")
    private BigDecimal rh_cr_ovd_max_amt;
    @TableField("rh_cr_cate_num")
    private BigDecimal rh_cr_cate_num;
    @TableField("rh_ln_bal_pro")
    private BigDecimal rh_ln_bal_pro;
    @TableField("rh_m6_cr_ovd_mon")
    private BigDecimal rh_m6_cr_ovd_mon;
    @TableField("rh_m24_cr_ovd_mon")
    private BigDecimal rh_m24_cr_ovd_mon;
    @TableField("rh_m12_cr_ovd_mon")
    private BigDecimal rh_m12_cr_ovd_mon;
    @TableField("rh_cr_uc_min_age")
    private BigDecimal rh_cr_uc_min_age;
    @TableField("rh_ln_avg_bal_amt")
    private BigDecimal rh_ln_avg_bal_amt;
    @TableField("rh_m24_cr_ovd_num")
    private BigDecimal rh_m24_cr_ovd_num;
    @TableField("rh_ln_y2_qy_num")
    private BigDecimal rh_ln_y2_qy_num;
    @TableField("rh_crc_y2_qy_num")
    private BigDecimal rh_crc_y2_qy_num;
    @TableField("rh_guar_y2_qy_num")
    private BigDecimal rh_guar_y2_qy_num;
    @TableField("rh_ln_qy_lst_inte")
    private BigDecimal rh_ln_qy_lst_inte;
    @TableField("rh_crc_qy_lst_inte")
    private BigDecimal rh_crc_qy_lst_inte;
    @TableField("rh_ln_qy_fst_inte")
    private BigDecimal rh_ln_qy_fst_inte;
    @TableField("rh_crc_qy_fst_inte")
    private BigDecimal rh_crc_qy_fst_inte;
    @TableField("rh_pstln_y2_qy_num")
    private BigDecimal rh_pstln_y2_qy_num;
    @TableField("rh_merch_y2_qy_num")
    private BigDecimal rh_merch_y2_qy_num;
    @TableField("rh_self_m1_qy_num")
    private BigDecimal rh_self_m1_qy_num;
    @TableField("rh_cr_y2_qy_num")
    private BigDecimal rh_cr_y2_qy_num;
    @TableField("rh_ln_cr_y2_qy_pro")
    private BigDecimal rh_ln_cr_y2_qy_pro;
    @TableField("rh_crc_cr_y2_qy_pro")
    private BigDecimal rh_crc_cr_y2_qy_pro;
    @TableField("rh_cr_y2_qyf_num")
    private BigDecimal rh_cr_y2_qyf_num;
    @TableField("rh_crc_y2_qyf_num")
    private BigDecimal rh_crc_y2_qyf_num;
    @TableField("rh_crc_m12_qyf_num")
    private BigDecimal rh_crc_m12_qyf_num;
    @TableField("rh_cr_y2_qyf_pro")
    private BigDecimal rh_cr_y2_qyf_pro;
    @TableField("rh_ln_y2_qyf_pro")
    private BigDecimal rh_ln_y2_qyf_pro;
    @TableField("rh_crc_y2_qyf_pro")
    private BigDecimal rh_crc_y2_qyf_pro;
    @TableField("rh_crc_cr_y2_qyf_pro")
    private BigDecimal rh_crc_cr_y2_qyf_pro;
    @TableField("rh_crc_cr_m6_qyf_pro")
    private BigDecimal rh_crc_cr_m6_qyf_pro;
    @TableField("rh_crc_cr_m12_qyf_pro")
    private BigDecimal rh_crc_cr_m12_qyf_pro;
    @TableField("rh_ln_cr_y2_qyf_pro")
    private BigDecimal rh_ln_cr_y2_qyf_pro;
    @TableField("rh_ln_cr_m12_qyf_pro")
    private BigDecimal rh_ln_cr_m12_qyf_pro;
    @TableField("rh_ln_y2_qy_org_num")
    private BigDecimal rh_ln_y2_qy_org_num;
    @TableField("rh_crc_y2_qy_org_num")
    private BigDecimal rh_crc_y2_qy_org_num;
    @TableField("rh_guar_y2_qy_org_num")
    private BigDecimal rh_guar_y2_qy_org_num;
    @TableField("rh_cr_y2_qy_org_num")
    private BigDecimal rh_cr_y2_qy_org_num;
    @TableField("rh_ln_cr_y2_qy_org_pro")
    private BigDecimal rh_ln_cr_y2_qy_org_pro;
    @TableField("rh_crc_cr_y2_qy_org_pro")
    private BigDecimal rh_crc_cr_y2_qy_org_pro;
    @TableField("rh_ln_cr_m12_qy_org_pro")
    private BigDecimal rh_ln_cr_m12_qy_org_pro;
    @TableField("rh_cr_y2_qyf_org_num")
    private BigDecimal rh_cr_y2_qyf_org_num;
    @TableField("rh_ln_y2_qyf_org_num")
    private BigDecimal rh_ln_y2_qyf_org_num;
    @TableField("rh_crc_y2_qyf_org_num")
    private BigDecimal rh_crc_y2_qyf_org_num;
    @TableField("rh_cr_y2_qyf_org_pro")
    private BigDecimal rh_cr_y2_qyf_org_pro;
    @TableField("rh_ln_y2_qyf_org_pro")
    private BigDecimal rh_ln_y2_qyf_org_pro;
    @TableField("rh_crc_y2_qyf_org_pro")
    private BigDecimal rh_crc_y2_qyf_org_pro;
    @TableField("rh_crc_cr_y2_qyf_org_pro")
    private BigDecimal rh_crc_cr_y2_qyf_org_pro;
    @TableField("rh_ln_cr_y2_qyf_org_pro")
    private BigDecimal rh_ln_cr_y2_qyf_org_pro;
    @TableField("rh_m3_qy_num")
    private BigDecimal rh_m3_qy_num;
    @TableField("rh_lncd_op_max_dt_timestamp")
    private BigDecimal rh_lncd_op_max_dt_timestamp;
    @TableField("rh_lncd_op_old_dt_timestamp")
    private BigDecimal rh_lncd_op_old_dt_timestamp;
    @TableField("rh_stlncd_op_max_dt_timestamp")
    private BigDecimal rh_stlncd_op_max_dt_timestamp;
    @TableField("rh_stlncd_op_old_dt_timestamp")
    private BigDecimal rh_stlncd_op_old_dt_timestamp;
    @TableField("rh_crc_op_max_dt_timestamp")
    private BigDecimal rh_crc_op_max_dt_timestamp;
    @TableField("rh_ln_op_max_dt_timestamp")
    private BigDecimal rh_ln_op_max_dt_timestamp;
    @TableField("rh_ln_rct_paydt_timestamp")
    private BigDecimal rh_ln_rct_paydt_timestamp;
    @TableField("rh_carln_rct_paydt_timestamp")
    private BigDecimal rh_carln_rct_paydt_timestamp;
    @TableField("rh_carln_op_max_dt_timestamp")
    private BigDecimal rh_carln_op_max_dt_timestamp;
    @TableField("rh_hsln_rct_paydt_timestamp")
    private BigDecimal rh_hsln_rct_paydt_timestamp;
    @TableField("rh_hsln_op_max_dt_timestamp")
    private BigDecimal rh_hsln_op_max_dt_timestamp;
    @TableField("rh_opln_rct_paydt_timestamp")
    private BigDecimal rh_opln_rct_paydt_timestamp;
    @TableField("rh_oprln_op_max_dt_timestamp")
    private BigDecimal rh_oprln_op_max_dt_timestamp;
    @TableField("rh_agln_rct_paydt_timestamp")
    private BigDecimal rh_agln_rct_paydt_timestamp;
    @TableField("rh_agln_op_max_dt_timestamp")
    private BigDecimal rh_agln_op_max_dt_timestamp;
    @TableField("rh_ln_op_old_dt_timestamp")
    private BigDecimal rh_ln_op_old_dt_timestamp;
    @TableField("rh_ln_op_min_dt_timestamp")
    private BigDecimal rh_ln_op_min_dt_timestamp;
    @TableField("rh_lncd_op_min_dt_timestamp")
    private BigDecimal rh_lncd_op_min_dt_timestamp;
    @TableField("rh_stlncd_op_min_dt_timestamp")
    private BigDecimal rh_stlncd_op_min_dt_timestamp;
    @TableField("rh_cr_op_min_dt_timestamp")
    private BigDecimal rh_cr_op_min_dt_timestamp;
    @TableField("rh_qy_max_dt_timestamp")
    private BigDecimal rh_qy_max_dt_timestamp;
    @TableField("rh_ln_op_max_dt_year")
    private BigDecimal rh_ln_op_max_dt_year;
    @TableField("rh_ln_rct_paydt_year")
    private BigDecimal rh_ln_rct_paydt_year;
    @TableField("rh_agln_op_max_dt_year")
    private BigDecimal rh_agln_op_max_dt_year;
    @TableField("rh_ln_op_old_dt_year")
    private BigDecimal rh_ln_op_old_dt_year;
    @TableField("rh_ln_op_min_dt_year")
    private BigDecimal rh_ln_op_min_dt_year;
    @TableField("rh_lncd_op_min_dt_year")
    private BigDecimal rh_lncd_op_min_dt_year;
    @TableField("rh_qy_max_dt_year")
    private BigDecimal rh_qy_max_dt_year;
    @TableField("rh_lncd_op_max_dt_month")
    private BigDecimal rh_lncd_op_max_dt_month;
    @TableField("rh_lncd_op_old_dt_month")
    private BigDecimal rh_lncd_op_old_dt_month;
    @TableField("rh_ln_rct_paydt_month")
    private BigDecimal rh_ln_rct_paydt_month;
    @TableField("rh_ln_op_min_dt_month")
    private BigDecimal rh_ln_op_min_dt_month;
    @TableField("rh_lncd_op_min_dt_month")
    private BigDecimal rh_lncd_op_min_dt_month;
    @TableField("rh_stlncd_op_min_dt_month")
    private BigDecimal rh_stlncd_op_min_dt_month;
    @TableField("rh_qy_max_dt_month")
    private BigDecimal rh_qy_max_dt_month;
    @TableField("rh_lncd_op_max_dt_day")
    private BigDecimal rh_lncd_op_max_dt_day;
    @TableField("rh_lncd_op_old_dt_day")
    private BigDecimal rh_lncd_op_old_dt_day;
    @TableField("rh_stlncd_op_max_dt_day")
    private BigDecimal rh_stlncd_op_max_dt_day;
    @TableField("rh_stlncd_op_old_dt_day")
    private BigDecimal rh_stlncd_op_old_dt_day;
    @TableField("rh_ln_op_max_dt_day")
    private BigDecimal rh_ln_op_max_dt_day;
    @TableField("rh_ln_rct_paydt_day")
    private BigDecimal rh_ln_rct_paydt_day;
    @TableField("rh_carln_op_max_dt_day")
    private BigDecimal rh_carln_op_max_dt_day;
    @TableField("rh_hsln_rct_paydt_day")
    private BigDecimal rh_hsln_rct_paydt_day;
    @TableField("rh_hsln_op_max_dt_day")
    private BigDecimal rh_hsln_op_max_dt_day;
    @TableField("rh_opln_rct_paydt_day")
    private BigDecimal rh_opln_rct_paydt_day;
    @TableField("rh_oprln_op_max_dt_day")
    private BigDecimal rh_oprln_op_max_dt_day;
    @TableField("rh_agln_op_max_dt_day")
    private BigDecimal rh_agln_op_max_dt_day;
    @TableField("rh_ln_op_old_dt_day")
    private BigDecimal rh_ln_op_old_dt_day;
    @TableField("rh_qy_max_dt_day")
    private BigDecimal rh_qy_max_dt_day;
    @TableField("rh_lncd_op_max_dt_week")
    private BigDecimal rh_lncd_op_max_dt_week;
    @TableField("rh_lncd_op_old_dt_week")
    private BigDecimal rh_lncd_op_old_dt_week;
    @TableField("rh_stlncd_op_max_dt_week")
    private BigDecimal rh_stlncd_op_max_dt_week;
    @TableField("rh_ln_op_max_dt_week")
    private BigDecimal rh_ln_op_max_dt_week;
    @TableField("rh_ln_rct_paydt_week")
    private BigDecimal rh_ln_rct_paydt_week;
    @TableField("rh_carln_op_max_dt_week")
    private BigDecimal rh_carln_op_max_dt_week;
    @TableField("rh_hsln_rct_paydt_week")
    private BigDecimal rh_hsln_rct_paydt_week;
    @TableField("rh_oprln_op_max_dt_week")
    private BigDecimal rh_oprln_op_max_dt_week;
    @TableField("rh_agln_op_max_dt_week")
    private BigDecimal rh_agln_op_max_dt_week;
    @TableField("rh_ln_op_old_dt_week")
    private BigDecimal rh_ln_op_old_dt_week;
    @TableField("rh_qy_max_dt_week")
    private BigDecimal rh_qy_max_dt_week;
    @TableField("sub_time_feature_1")
    private BigDecimal sub_time_feature_1;
    @TableField("sub_time_feature_2")
    private BigDecimal sub_time_feature_2;
    @TableField("sub_time_feature_3")
    private BigDecimal sub_time_feature_3;
    @TableField("sub_time_feature_4")
    private BigDecimal sub_time_feature_4;
    @TableField("sub_time_feature_5")
    private BigDecimal sub_time_feature_5;
    @TableField("sub_time_feature_6")
    private BigDecimal sub_time_feature_6;
    @TableField("sub_time_feature_7")
    private BigDecimal sub_time_feature_7;
    @TableField("sub_time_feature_8")
    private BigDecimal sub_time_feature_8;
    @TableField("sub_time_feature_9")
    private BigDecimal sub_time_feature_9;
    @TableField("sub_time_feature_10")
    private BigDecimal sub_time_feature_10;

    @TableField("SCORE")
    private Integer custScore2;

    private String modelResult;
    private String createTime;

    public Custcard2ModelInvoke() {
    }

    public Custcard2ModelInvoke(String custId,String sessionId, String modelResult, String appNo, CustScore2Dto params, ResponseData<Integer> mapResponseData) {
        this.sessionId = sessionId;
        this.modelResult = modelResult;
        this.createTime = DateUtil.getNowyyyy_MM_dd_HH_mm_ss();
        this.appNo = appNo;
        this.custId = custId;
        if(Objects.nonNull(params)){
            BeanUtils.copyProperties(params, this);
        }
        if (Objects.nonNull(mapResponseData)){
            this.custScore2 = Integer.parseInt(mapResponseData.getData().toString());
        }
    }
}
