package com.bank.irce.ltgj.entity.dto;

import com.bank.irce.ltgj.annotation.FieldValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@ApiModel(value = "人行征信追加指标")
@Data
public class CustCard2ResVo implements Serializable, ValidateConstant {
    /**
     *  张羽
     */
    @ApiModelProperty(value = "职业信息")
    private String occupation;
    @ApiModelProperty(value = "工作职务")
    private String duty;
    @ApiModelProperty(value = "行业稳定性")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_bs_industry_mat;
    @ApiModelProperty(value = "正常状态人民币账户贷记卡平均授信额度(所有正常状态账户平均)")
    @FieldValue(type = VALUE_TYPE_INT)
    private BigDecimal rh_lncd_nr_mn_cr_lmt;
    @ApiModelProperty(value = "正常状态人民币账户贷记卡最小授信额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_nr_min_cr_lmt;
    @ApiModelProperty(value = "正常状态人民币账户贷记卡最小共享额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_nr_min_sd_lmt;
    @ApiModelProperty(value = "未销户人民币账户贷记卡最小已用共享额度比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_min_ud_sd_lmt_pr;
    @ApiModelProperty(value = "正常状态人民币账户贷记卡最小已用共享额度比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_nr_min_ud_sd_lmt_pr;
    @ApiModelProperty(value = "人民币未销户贷记卡当前逾期金额均值")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_avg_curdef_amt;
    @ApiModelProperty(value = "人民币未销户贷记卡当前逾期金额最大值")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_lncd_max_curdef_amt;
    @ApiModelProperty(value = "贷记卡历史3-5年逾期月份数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_ovd_ct_3y_rp;
    @ApiModelProperty(value = "贷记卡近2年内最大逾期月份数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_m24_lncd_ovd_max_perd;
    @ApiModelProperty(value = "近6个月正常状态人民币账户贷记卡平均授信额度(所有正常状态账户平均)")
    @FieldValue(type = VALUE_TYPE_INT)
    private BigDecimal rh_lncd_nr_mn_cr_lmt_m6;
    @ApiModelProperty(value = "正常状态贷记卡机构数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_lim_org_ds_num;
    @ApiModelProperty(value = "评级为满意的贷记卡账户数目")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_per_num;
    @ApiModelProperty(value = "正常状态人民币账户准贷记卡总透支余额")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_stlncd_nr_sum_ud_cr_lmt;
    @ApiModelProperty(value = "正常状态人民币账户准贷记卡最小透支余额")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_stlncd_nr_min_ud_cr_lmt;
    @ApiModelProperty(value = "未销户信用卡开立距今最大时长")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_crc_uc_max_age;
    @ApiModelProperty(value = "信用卡历史3-5年逾期月份数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_crc_ovd_ct_3y_rp;
    @ApiModelProperty(value = "贷款笔数（全部）")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_ln_num;
    @ApiModelProperty(value = "特殊交易-提前还款（部分）次数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_ln_st_advp;
    @ApiModelProperty(value = "特殊交易-其他类型次数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_ln_st_oth;
    @ApiModelProperty(value = "未结清贷款开立距今最大时长")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_ln_uc_max_age;
    @ApiModelProperty(value = "是否有房贷")
    private String rh_if_houseln;
    @ApiModelProperty(value = "贷款五级分类低风险占比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_5state_good_pr;
    @ApiModelProperty(value = "贷款信息汇总当前逾期总额")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_ln_ovd_cur_amt_rp;
    @ApiModelProperty(value = "近2年内最大单账户贷款有逾期月份数")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_ln_ovd_max_2y_rp;
    @ApiModelProperty(value = "个人汽车未结清贷款总金额")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_carln_sum_amt;
    @ApiModelProperty(value = "个人汽车贷款特殊交易-提前还款（全部）次数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_carln_st_adva;
    @ApiModelProperty(value = "个人住房未结清贷款平均余额")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_hsln_avg_bal;
    @ApiModelProperty(value = "个人住房未结清贷款最小余额比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_hsln_min_bal_pr;
    @ApiModelProperty(value = "个人住房未结清贷款最大余额比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_hsln_max_bal_pr;
    @ApiModelProperty(value = "个人经营贷款正常笔数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_opln_nr_num;
    @ApiModelProperty(value = "个人经营未结清贷款最大金额")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_opln_max_amt;
    @ApiModelProperty(value = "个人经营未结清贷款最大余额")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_opln_max_bal;
    @ApiModelProperty(value = "个人经营未结清贷款平均余额")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_opln_avg_bal;
    @ApiModelProperty(value = "个人经营贷款近12个月特殊交易-提前还款（全部）次数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_opln_st_adva;
    @ApiModelProperty(value = "个人农户未结清贷款最大余额")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_agln_max_bal;
    @ApiModelProperty(value = "征信报告上光大银行住房贷款（含公积金贷款）笔数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_hsln_sum_num;
    @ApiModelProperty(value = "贷款逾期最长逾期月数")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_ln_ovd_dur;
    @ApiModelProperty(value = "贷款汇总_法人机构数")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_ln_corg_num;
    @ApiModelProperty(value = "未结清贷款发放机构个数")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_ln_org_num;
    @ApiModelProperty(value = "未销户贷记卡总使用额度")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_lncd_ud_amt;
    @ApiModelProperty(value = "未销户贷记卡汇总_最近6个月平均额度使用率")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_m6_lncd_ud_pro;
    @ApiModelProperty(value = "信贷产品_授信总额")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_cr_lim_amt;
    @ApiModelProperty(value = "担保总金额")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_gr_sum_amt;
    @ApiModelProperty(value = "担保余额")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_gr_tol_bal;
    @ApiModelProperty(value = "银行信贷汇总余额/授信金额（未销户）")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_cr_bal_pro;
    @ApiModelProperty(value = "信用卡汇总_透支余额/信用额度（未销户）")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_ud_pro;
    @ApiModelProperty(value = "贷款汇总_贷款余额/合同金额")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_ln_bal_pro;
    @ApiModelProperty(value = "过去6个月所有产品有过逾期的月数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_m6_cr_ovd_mon;
    @ApiModelProperty(value = "过去24个月所有产品有过逾期的月数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_m24_cr_ovd_mon;
    @ApiModelProperty(value = "过去12个月所有产品有过逾期的月数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_m12_cr_ovd_mon;
    @ApiModelProperty(value = "未结清所有产品开立距今最小时长")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_cr_uc_min_age;
    @ApiModelProperty(value = "近2年内贷款审批最晚查询时间距本次申请的时间间隔")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_ln_qy_lst_inte;
    @ApiModelProperty(value = "近2年内贷款审批最早查询时间距本次申请的时间间隔")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_ln_qy_fst_inte;
    @ApiModelProperty(value = "近2年内信用卡审批最早查询时间距本次申请的时间间隔")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_crc_qy_fst_inte;
    @ApiModelProperty(value = "近2年内信贷产品查询失败次数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_cr_y2_qyf_num;

    /**
     *  段守政
     */
    @ApiModelProperty(value = "人民币贷记卡账户数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_num;
    @ApiModelProperty(value = "未销户人民币贷记卡账户数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_uc_num;
    @ApiModelProperty(value = "正常人民币贷记卡账户数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_nr_num;
    @ApiModelProperty(value = "未激活人民币贷记卡账户数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_nopen_num;
    @ApiModelProperty(value = "已销户人民币贷记卡账户数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_cancel_num;

    @ApiModelProperty(value = "外币贷记卡账户数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_oc_num;

    @ApiModelProperty(value = "正常状态人民币账户贷记卡最大授信额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_max_nr_cr_lmt;

    @ApiModelProperty(value = "正常状态人民币账户贷记卡平均共享额度(有值正常状态账户平均)")
    @FieldValue(type = VALUE_TYPE_INT)
    private BigDecimal rh_lncd_nr_avg_sd_lmt;

    @ApiModelProperty(value = "正常状态人民币账户贷记卡平均共享额度(所有正常状态账户平均)")
    @FieldValue(type = VALUE_TYPE_INT)
    private BigDecimal rh_lncd_nr_mn_sd_lmt;

    @ApiModelProperty(value = "正常状态人民币账户贷记卡最大共享额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_max_nr_sd_lmt;

    @ApiModelProperty(value = "正常状态人民币账户贷记卡总已用额度")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_lncd_sum_nr_ud_cr_lmt;

    @ApiModelProperty(value = "正常状态人民币账户贷记卡平均已用额度(有值账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_nr_avg_ud_cr_lmt;

    @ApiModelProperty(value = "正常状态人民币账户贷记卡最大已用额度")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_lncd_max_nr_ud_cr_lmt;

    @ApiModelProperty(value = "正常状态人民币账户贷记卡最大已用额度比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_max_nr_ud_cr_lmt_pr;

    @ApiModelProperty(value = "正常状态人民币账户贷记卡平均已用额度比(有值账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_nr_avg_ud_cr_lmt_pr;

    @ApiModelProperty(value = "正常状态人民币账户贷记卡总已用额度比(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_sum_nr_ud_cr_lmt_pr;

    @ApiModelProperty(value = "正常状态人民币账户贷记卡最大已用共享额度比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_max_nr_ud_sd_lmt_pr;








    @ApiModelProperty(value = "正常状态人民币账户贷记卡总已用共享额度比(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal  rh_lncd_sum_nr_ud_sd_lmt_pr;




    @ApiModelProperty(value = "未销户人民币账户贷记卡总授信额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_sum_cr_lmt;



    @ApiModelProperty(value = "未销户人民币账户贷记卡平均授信额度(有值账户平均)")
    @FieldValue(type = VALUE_TYPE_INT)
    private BigDecimal rh_lncd_avg_cr_lmt;

    @ApiModelProperty(value = "未销户人民币账户贷记卡平均授信额度(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_INT)
    private BigDecimal rh_lncd_mn_cr_lmt;

    @ApiModelProperty(value = "未销户人民币账户贷记卡最小授信额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_uc_lmt_min;

    @ApiModelProperty(value = "未销户人民币账户贷记卡最大授信额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_uc_lmt_max;

    @ApiModelProperty(value = "未销户人民币账户贷记卡总共享额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_sum_sd_lmt;


    @ApiModelProperty(value = "未销户人民币账户贷记卡平均共享额度(有值账户平均)")
    @FieldValue(type = VALUE_TYPE_INT)
    private BigDecimal rh_lncd_avg_sd_lmt;


    @ApiModelProperty(value = "未销户人民币账户贷记卡平均共享额度(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_INT)
    private BigDecimal rh_lncd_mn_sd_lmt;


    @ApiModelProperty(value = "未销户人民币账户贷记卡最大共享额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_max_sd_lmt;

    @ApiModelProperty(value = "未销户人民币账户贷记卡最小共享额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_min_sd_lmt;

    @ApiModelProperty(value = "未销户人民币账户贷记卡总已用额度")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_lncd_sum_ud_cr_lmt;

    @ApiModelProperty(value = "未销户人民币账户贷记卡平均已用额度(有值账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_avg_ud_cr_lmt;


    @ApiModelProperty(value = "未销户人民币账户贷记卡最大已用额度")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_lncd_max_ud_cr_lmt;
    @ApiModelProperty(value = "未销户人民币账户贷记卡最小已用额度")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_lncd_min_ud_cr_lmt;






    @ApiModelProperty(value = "未销户人民币账户贷记卡最大已用额度比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_uc_max_amt_pro;





    @ApiModelProperty(value = "未销户人民币账户贷记卡平均已用额度比(有值账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_avg_ud_cr_lmt_pr;

    @ApiModelProperty(value = "未销户人民币账户贷记卡平均已用额度比(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_mn_ud_cr_lmt_pr;

    @ApiModelProperty(value = "未销户人民币账户贷记卡总已用额度比(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_sum_ud_cr_lmt_pr;

    @ApiModelProperty(value = "未销户人民币账户贷记卡最大已用共享额度比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_max_ud_sd_lmt_pr;








    @ApiModelProperty(value = "未销户人民币账户贷记卡平均已用共享额度比(有值账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_avg_ud_sd_lmt_pr;


    @ApiModelProperty(value = "未销户人民币账户贷记卡平均已用共享额度比(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_mn_ud_sd_lmt_pr;
    @ApiModelProperty(value = "未销户人民币账户贷记卡总已用共享额度比(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_sum_ud_sd_lmt_pr;

    @ApiModelProperty(value = "人民币未销户贷记卡最大使用额度均值")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_lncd_avg_max_ud_amt;

    @ApiModelProperty(value = "人民币未销户贷记卡最大使用额度之和")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_lncd_sum_max_ud_amt;

    @ApiModelProperty(value = "人民币未销户贷记卡最大使用额度最大值")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_lncd_max_max_ud_amt ;

    @ApiModelProperty(value = "贷记卡近2年内逾期月份数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_ovd_ct_2y_rp;

    @ApiModelProperty(value = "近6个月未销户人民币账户贷记卡最大共享额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_max_sd_lmt_m6;

    @ApiModelProperty(value = "近6个月正常状态人民币账户贷记卡总授信额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_sum_nr_cr_lmt_m6;

    @ApiModelProperty(value ="正常状态人民币账户贷记卡总授信额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_sum_nr_cr_lmt;

    @ApiModelProperty(value ="正常状态人民币账户贷记卡平均授信额度(有值正常状态账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_nr_avg_cr_lmt;

    @ApiModelProperty(value = "近12个月正常状态人民币账户贷记卡总授信额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_sum_nr_cr_lmt_m12;

    @ApiModelProperty(value = "近12个月正常人民币贷记卡账户数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer  rh_lncd_nr_num_m12;


    @ApiModelProperty(value = "近12个月正常状态人民币账户贷记卡平均授信额度(所有正常状态账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_nr_mn_cr_lmt_m12;

    @ApiModelProperty(value = "贷记卡逾期180天以上未归还贷款本金")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_lncd_od180amt_sum_amt;

    @ApiModelProperty(value = "评级为一般逾期的贷记卡账户数目")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_mid_ovd_num;

    @ApiModelProperty(value = "评级为严重逾期的贷记卡账户数目")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_lncd_high_ovd_num;


    @ApiModelProperty(value = "贷记卡账户最差状态")
    private String rh_lncd_bad_state;

    @ApiModelProperty(value = "最近贷记卡开立日期")
    private String rh_lncd_op_max_dt;

    @ApiModelProperty(value = "最老贷记卡开立日期")
    private String rh_lncd_op_old_dt;

    @ApiModelProperty(value = "最早贷记卡开户日距今月份数")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_lncd_old_age;

    @ApiModelProperty(value = "贷记卡最大账龄")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_lncd_detail_max_age;

    @ApiModelProperty(value = "首张贷记卡发卡月份（全部")
    private String rh_lncd_op_min_dt;



    @ApiModelProperty(value = "近2年内贷记卡是否有过逾期")
    private String rh_lncd_if_ovd_2y_rp;




    //信用卡"
    @ApiModelProperty(value = "人民币信用卡账户数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_crc_num;
    @ApiModelProperty(value = "未激活人民币信用卡账户数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_crc_nopen_num;
    @ApiModelProperty(value = "已销户人民币信用卡账户数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_crc_cancel_num;

    @ApiModelProperty(value = "未销户人民币信用卡账户数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_crc_uc_num;

    @ApiModelProperty(value = "未销户人民币账户信用卡总授信额度")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_crc_sum_cr_lmt;

    @ApiModelProperty(value = "未销户人民币账户信用卡平均授信额度(有值账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_avg_cr_lmt;

    @ApiModelProperty(value = "未销户人民币账户信用卡平均授信额度(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_mn_cr_lmt;

    @ApiModelProperty(value = "未销户人民币账户信用卡总共享额度")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_crc_sum_sd_lmt;
    @ApiModelProperty(value = "未销户人民币账户信用卡平均共享额度(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_mn_sd_lmt;

    @ApiModelProperty(value = "未销户人民币账户信用卡平均共享额度(有值账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_avg_sd_lmt;


    @ApiModelProperty(value = "正常状态人民币账户信用卡总授信额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_crc_sum_nr_cr_lmt;

    @ApiModelProperty(value = "正常人民币信用卡账户数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_crc_nr_num;

    @ApiModelProperty(value = "正常状态人民币账户信用卡平均授信额度(所有正常状态账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_nr_mn_cr_lmt;
    @ApiModelProperty(value = "正常状态人民币账户信用卡最大授信额度")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_crc_max_nr_cr_lmt;
    @ApiModelProperty(value = "未销户人民币账户信用卡总已用额度")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_crc_sum_ud_cr_lmt;
    @ApiModelProperty(value = " 未销户人民币账户信用卡平均已用额度(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_mn_ud_cr_lmt;

    @ApiModelProperty(value = "未销户人民币账户信用卡最大已用额度比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_uc_max_amt_pro;
    @ApiModelProperty(value = "未销户人民币账户信用卡最小已用额度比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_uc_min_amt_pro;
    @ApiModelProperty(value = "未销户人民币账户信用卡平均已用额度比(有值账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_avg_ud_cr_lmt_pr;

    @ApiModelProperty(value = "未销户人民币账户信用卡平均已用额度比(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_mn_ud_cr_lmt_pr;

    @ApiModelProperty(value = "未销户人民币账户信用卡最大已用共享额度比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_max_ud_sd_lmt_pr;

    @ApiModelProperty(value = "未销户人民币账户信用卡最小已用共享额度比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_min_ud_sd_lmt_pr;
    @ApiModelProperty(value = "未销户人民币账户信用卡总已用共享额度比(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_sum_ud_sd_lmt_pr;
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    @ApiModelProperty(value = "正常状态人民币账户信用卡最大已用额度比")
    private BigDecimal rh_crc_max_nr_ud_cr_lmt_pr;
    @ApiModelProperty(value = "正常状态人民币账户信用卡最小已用额度比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_nr_min_ud_cr_lmt_pr;
    @ApiModelProperty(value = "正常状态人民币账户信用卡平均已用额度比(有值账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_nr_avg_ud_cr_lmt_pr;
    @ApiModelProperty(value = "正常状态人民币账户信用卡平均已用额度比(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_nr_mn_ud_cr_lmt_pr;
    @ApiModelProperty(value = "正常状态人民币账户信用卡最大已用共享额度比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_max_nr_ud_sd_lmt_pr;
    @ApiModelProperty(value = "正常状态人民币账户信用卡最小已用共享额度比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_nr_min_ud_sd_lmt_pr;
    @ApiModelProperty(value = "正常状态人民币账户信用卡总已用共享额度比(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_sum_nr_ud_sd_lmt_pr;
    @ApiModelProperty(value = "人民币未销户信用卡最大使用额度最大值")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_crc_max_max_ud_amt;
    @ApiModelProperty(value = "信用卡近2年内逾期月份数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_crc_ovd_ct_2y_rp;
    @ApiModelProperty(value = "近6个月正常状态人民币账户信用卡总授信额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_crc_sum_nr_cr_lmt_m6;

    @ApiModelProperty(value = "近6个月正常状态人民币账户信用卡平均授信额度(有值正常状态账户平均)")
    @FieldValue(type = VALUE_TYPE_INT)
    private BigDecimal rh_crc_nr_avg_cr_lmt_m6;
    @ApiModelProperty(value = "近6个月正常人民币信用卡账户数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_crc_nr_num_m6;
    @ApiModelProperty(value = "近6个月正常状态人民币账户信用卡平均授信额度(所有正常状态账户平均)")
    @FieldValue(type = VALUE_TYPE_INT)
    private BigDecimal rh_crc_nr_mn_cr_lmt_m6;
    @ApiModelProperty(value = "近12个月正常人民币信用卡账户数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_crc_nr_num_m12;
    @ApiModelProperty(value = "近12个月正常状态人民币账户信用卡平均授信额度(所有正常状态账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_nr_mn_cr_lmt_m12;
    @ApiModelProperty(value = "信用卡逾期180天以上未归还贷款本金")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_crc_od180amt_sum_amt;
    @ApiModelProperty(value = "信用卡最大账龄")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_crc_max_age;
    @ApiModelProperty(value = "未销户人民币准贷记卡账户数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_stlncd_uc_num;
    @ApiModelProperty(value = "未激活人民币准贷记卡账户数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_stlncd_nopen_num;
    @ApiModelProperty(value = "已销户人民币准贷记卡账户数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_stlncd_cancel_num ;
    @ApiModelProperty(value = "外币准贷记卡账户数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_stlncd_oc_num;
    @ApiModelProperty(value = "未销户人民币账户准贷记卡总授信额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_stlncd_sum_cr_lmt;
    @ApiModelProperty(value = "未销户人民币账户准贷记卡平均授信额度(有值账户平均)")
    @FieldValue(type = VALUE_TYPE_INT)
    private BigDecimal rh_stlncd_avg_cr_lmt;
    @ApiModelProperty(value = "未销户人民币账户准贷记卡平均授信额度(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_INT)
    private BigDecimal rh_stlncd_mn_cr_lmt;
    @ApiModelProperty(value = "未销户人民币账户准贷记卡总共享额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_stlncd_sum_sd_lmt;
    @ApiModelProperty(value = "未销户人民币账户准贷记卡平均共享额度(有值账户平均)")
    @FieldValue(type = VALUE_TYPE_INT)
    private BigDecimal rh_stlncd_avg_sd_lmt;
    @ApiModelProperty(value = "未销户人民币账户准贷记卡平均共享额度(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_INT)
    private BigDecimal rh_stlncd_mn_sd_lmt;
    @ApiModelProperty(value = "正常状态人民币账户准贷记卡总授信额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_stlncd_nr_sum_cr_lmt;
    @ApiModelProperty(value = "正常人民币准贷记卡账户数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_stlncd_nr_num;
    @ApiModelProperty(value = "正常状态人民币账户准贷记卡平均授信额度(所有正常状态账户平均)")
    @FieldValue(type = VALUE_TYPE_INT)
    private BigDecimal rh_stlncd_nr_mn_cr_lmt;
    @ApiModelProperty(value = "正常状态人民币账户准贷记卡最大授信额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_stlncd_nr_max_cr_lmt;
    @ApiModelProperty(value = "正常状态人民币账户准贷记卡最小授信额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_stlncd_nr_min_cr_lmt;
    @ApiModelProperty(value = "正常状态人民币账户准贷记卡总共享额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_stlncd_nr_sum_sd_lmt;
    @ApiModelProperty(value = "正常状态人民币账户准贷记卡平均共享额度(有值正常状态账户平均)")
    @FieldValue(type = VALUE_TYPE_INT)
    private BigDecimal rh_stlncd_nr_avg_sd_lmt;
    @ApiModelProperty(value = "正常状态人民币账户准贷记卡平均共享额度(所有正常状态账户平均)")
    @FieldValue(type = VALUE_TYPE_INT)
    private BigDecimal rh_stlncd_nr_mn_sd_lmt;
    @ApiModelProperty(value = "正常状态人民币账户准贷记卡最大共享额度")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_stlncd_nr_max_sd_lmt;
    @ApiModelProperty(value = "正常状态人民币账户准贷记卡最大透支余额")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_stlncd_nr_max_ud_cr_lmt;
    @ApiModelProperty(value = "正常状态人民币账户准贷记卡最大透支余额比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_nr_max_ud_cr_lmt_pr;
    @ApiModelProperty(value = "/正常状态人民币账户准贷记卡总透支余额比(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_nr_sum_ud_cr_lmt_pr;
    @ApiModelProperty(value = "正常状态人民币账户准贷记卡最大透支共享额度比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_nr_max_ud_sd_lmt_pr;
    @ApiModelProperty(value = "正常状态人民币账户准贷记卡平均透支共享额度比(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_nr_mn_ud_sd_lmt_pr;
    @ApiModelProperty(value = "正常状态人民币账户准贷记卡总透支共享额度比(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_nr_sum_ud_sd_lmt_pr;
    @ApiModelProperty(value = "未销户人民币账户准贷记卡总透支余额")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_stlncd_sum_ud_cr_lmt;
    @ApiModelProperty(value = "未销户人民币账户准贷记卡平均透支余额(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_INT)
    private BigDecimal rh_stlncd_mn_ud_cr_lmt;
    @ApiModelProperty(value = "未销户人民币账户准贷记卡平均透支余额(有值账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_avg_ud_cr_lmt;
    @ApiModelProperty(value = "未销户人民币账户准贷记卡最大透支余额比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_uc_max_amt_pro;

    @ApiModelProperty(value = "未销户人民币账户准贷记卡平均透支余额比(有值账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_avg_ud_cr_lmt_pr;
    @ApiModelProperty(value = "未销户人民币账户准贷记卡平均透支余额比(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_mn_ud_cr_lmt_pr;

    @ApiModelProperty(value = "未销户人民币账户准贷记卡总透支余额比(所有账户)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_sum_ud_cr_lmt_pr;

    @ApiModelProperty(value = "未销户人民币账户准贷记卡最大透支共享额度比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_max_ud_sd_lmt_pr;

    @ApiModelProperty(value = "未销户人民币账户准贷记卡总透支共享额度比(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_sum_ud_sd_lmt_pr;

    @ApiModelProperty(value = "人民币未销户准贷记卡最大透支余额最大值")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_stlncd_max_max_ud_amt;

    @ApiModelProperty(value = "人民币未销户准贷记卡最大透支余额之和")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_stlncd_sum_max_ud_amt;




    @ApiModelProperty(value = "准贷记卡近2年内逾期月份数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_stlncd_ovd_ct_2y_rp;

    @ApiModelProperty(value = "准贷记卡历史3-5年逾期月份数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_stlncd_ovd_ct_3y_rp;


    @ApiModelProperty(value = " 准贷记卡近2年内逾期90天以上月份数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_stlncd_nonpmf_ct_2y_rp;
    @ApiModelProperty(value = "近3个月人民币准贷记卡账户数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_stlncd_num_m3;
    @ApiModelProperty(value = "近6个月正常状态人民币账户准贷记卡总授信额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_stlncd_nr_sum_cr_lmt_m6;
    @ApiModelProperty(value = "准贷记卡透支180天以上未付余额")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_stlncd_od180amt_sum_amt;
    @ApiModelProperty(value = "评级为严重逾期的准贷记卡账户数目")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_stlncd_high_ovd_num;
    @ApiModelProperty(value = "评级为一般逾期的准贷记卡账户数目")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_stlncd_mid_ovd_num;
    @ApiModelProperty(value = "评级为满意的准贷记卡账户数目")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_stlncd_per_num;
    @ApiModelProperty(value = "最近准贷记卡开立日期")
    private String rh_stlncd_op_max_dt;
    @ApiModelProperty(value = "最老准贷记卡账户开户日期")
    private String rh_stlncd_op_old_dt;
    @ApiModelProperty(value = "首张准贷记卡发卡月份（全部）")
    private String rh_stlncd_op_min_dt;
    @ApiModelProperty(value = "最近信用卡开立日期")
    private String rh_crc_op_max_dt;
    @ApiModelProperty(value = "最老信用卡账户开户日期")
    private String rh_crc_op_old_dt;
    //贷款
    @ApiModelProperty(value = "最近开立贷款日期")
    private String rh_ln_op_max_dt;
    @ApiModelProperty(value = "最老贷款账户开户日期")
    private String rh_ln_op_old_dt;
    @ApiModelProperty(value = "首笔贷款发放月份（全部）")
    private String rh_ln_op_min_dt ;
    @ApiModelProperty(value = "最近未结清贷款到期日")
    private String rh_ln_rct_paydt;

    @ApiModelProperty(value = "个人汽车贷款最近还款日期")
    private String rh_carln_rct_paydt;
    @ApiModelProperty(value = "最近开立个人汽车贷款日期")
    private String rh_carln_op_max_dt;
    @ApiModelProperty(value = "个人住房贷款最近还款日期")
    private String rh_hsln_rct_paydt;
    @ApiModelProperty(value = "最近开立住房贷款日期")
    private String rh_hsln_op_max_dt;
    @ApiModelProperty(value = "个人经营贷款最近还款日期")
    private String rh_opln_rct_paydt;
    @ApiModelProperty(value = "最近开立个人经营贷款日期")
    private String rh_oprln_op_max_dt;
    @ApiModelProperty(value = "最近开立个人农户贷款日期")
    private String rh_agln_op_max_dt;
    @ApiModelProperty(value = "最新的查询日期")
    private String rh_qy_max_dt;
    @ApiModelProperty(value = "报告DATE")
    private String report_date;

    @ApiModelProperty(value = "正常状态人民币账户信用卡平均共享额度(所有正常状态账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_nr_mn_sd_lmt;
    @ApiModelProperty(value = "正常状态人民币账户准贷记卡平均透支余额比(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_nr_mn_ud_cr_lmt_pr;
    @ApiModelProperty(value = "正常状态人民币账户贷记卡平均已用额度比(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_nr_mn_ud_cr_lmt_pr;
    @ApiModelProperty(value = "正常状态人民币账户信用卡平均已用共享额度比(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_nr_mn_ud_sd_lmt_pr;
    @ApiModelProperty(value = "正常状态人民币账户贷记卡平均已用共享额度比(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_nr_mn_ud_sd_lmt_pr;
    @ApiModelProperty(value = "未销户人民币账户准贷记卡平均透支共享额度比(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_mn_ud_sd_lmt_pr;
    @ApiModelProperty(value = "未销户人民币账户信用卡平均已用共享额度比(有值账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_avg_ud_sd_lmt_pr;
    @ApiModelProperty(value = "未销户人民币账户信用卡平均已用共享额度比(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_mn_ud_sd_lmt_pr;

    @ApiModelProperty(value = "评级为满意的信用卡账户数目")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_crc_per_num;

    @ApiModelProperty(value = "正常状态人民币账户信用卡平均已用额度(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_nr_mn_ud_cr_lmt;

    @ApiModelProperty(value = "近12个月正常状态人民币账户贷记卡平均共享额度(所有正常状态账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_nr_mn_sd_lmt_m12;

    @ApiModelProperty(value = "正常状态人民币账户贷记卡平均已用额度(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_nr_mn_ud_cr_lmt;

    @ApiModelProperty(value = "近12个月正常状态人民币账户贷记卡平均已用额度(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_nr_mn_ud_cr_lmt_m12;


    @ApiModelProperty(value = "近12个月未销户人民币账户信用卡平均授信额度(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_mn_cr_lmt_m12;
    @ApiModelProperty(value = "未销户人民币账户贷记卡平均已用额度(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_mn_ud_cr_lmt;
    @ApiModelProperty(value = "未销户贷记卡最小额度比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_uc_min_lmt_pro;

    @ApiModelProperty(value = "未销户贷记卡最大额度比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_uc_max_lmt_pro;

    @ApiModelProperty(value = "最近开立贷款日期距今月份数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_ln_min_age;


    //合并三个实体类的指标
    @ApiModelProperty(value = "查询原因")
    private String queryreason;
    @ApiModelProperty(value = "性别")
    private String gender;
    @ApiModelProperty(value = "婚姻状况")
    private String maritalstate;
    @ApiModelProperty(value = "学历")
    private String edulevel;
    @ApiModelProperty(value = "学位")
    private String edudegree;
    @ApiModelProperty(value = "居住状况")
    private String residencetype;
    @ApiModelProperty(value = "居住省份个数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer residence_province_num;
    @ApiModelProperty(value = "居住类型个数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer residence_type_num;
    @ApiModelProperty(value = "所在行业")
    private String industry;
    @ApiModelProperty(value = "公积金缴存状态")
    private String accfund_state;
    @ApiModelProperty(value = "公积金缴存金额")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer accfund_pay;
    @ApiModelProperty(value = "公积金个人缴存比例")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal ownprent;
    @ApiModelProperty(value = "公积金公司缴存比例")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal comprent;
    @ApiModelProperty(value = "查询当前公司住房公积金缴费月份数")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_bs_accf_cur_mon;
    @ApiModelProperty(value = "查询历史住房公积金缴费月份数")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_bs_accf_his_mon;
    @ApiModelProperty(value = "住房公积金缴费基数")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_bs_accf_base;
    @ApiModelProperty(value = "查询年龄")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer apply_age;
    @ApiModelProperty(value = "查询从事行业个数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer industry_num;
    @ApiModelProperty(value = "查询最近一份工作的稳定性")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_bs_work_last_sta;
    @ApiModelProperty(value = "正常状态人民币账户贷记卡总共享额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_lncd_sum_nr_sd_lmt;
    @ApiModelProperty(value = "正常状态人民币账户贷记卡最小已用额度")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_lncd_nr_min_ud_cr_lmt;
    @ApiModelProperty(value = "近12个月正常状态人民币账户贷记卡最小已用额度")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_lncd_nr_min_ud_cr_lmt_m12;
    @ApiModelProperty(value = "正常状态人民币账户贷记卡平均已用共享额度比(有值账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_nr_avg_ud_sd_lmt_pr;
    @ApiModelProperty(value = "人民币未销户贷记卡最近6个月平均使用额度均值")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_avg_m6avg_ud_amt;
    @ApiModelProperty(value = "人民币未销户贷记卡最近6个月平均使用额度最大值")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_lncd_max_m6avg_ud_amt;
    @ApiModelProperty(value = "近6个月正常状态人民币账户贷记卡平均授信额度(有值正常状态账户平均)")
    @FieldValue(type = VALUE_TYPE_INT)
    private BigDecimal rh_lncd_nr_avg_cr_lmt_m6;
    @ApiModelProperty(value = "近12个月未销户人民币账户贷记卡平均授信额度(所有账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_mn_cr_lmt_m12;
    @ApiModelProperty(value = "近12个月未销户人民币信用卡账户数")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_crc_uc_num_m12;
    @ApiModelProperty(value = "正常状态人民币账户准贷记卡平均透支余额比(有值账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_nr_avg_ud_cr_lmt_pr;
    @ApiModelProperty(value = "正常状态人民币账户准贷记卡平均透支共享额度比(有值账户平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_nr_avg_ud_sd_lmt_pr;
    @ApiModelProperty(value = "人民币未销户准贷记卡最大透支余额均值")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_avg_max_ud_amt;
    @ApiModelProperty(value = "最近信用卡开立距今月份数")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_crc_min_age;
    @ApiModelProperty(value = "人民币未销户信用卡最大使用额度均值")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_avg_max_ud_amt;
    @ApiModelProperty(value = "人民币未销户信用卡最大使用额度之和")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_crc_sum_max_ud_amt;
    @ApiModelProperty(value = "近6个月未销户人民币账户信用卡最大共享额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_crc_max_sd_lmt_m6;
    @ApiModelProperty(value = "近12个月正常状态人民币账户信用卡总授信额度")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_crc_sum_nr_cr_lmt_m12;
    @ApiModelProperty(value = "正常贷款笔数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_ln_nr_num;
    @ApiModelProperty(value = "结清贷款笔数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_ln_clear_num;
    @ApiModelProperty(value = "个人汽车贷款笔数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_carln_num;
    @ApiModelProperty(value = "客户贷款的类别数(如车贷、房贷等不同类别)")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_ln_type_num;
    @ApiModelProperty(value = "近6个月未结清贷款总余额比")
    @FieldValue(type = VALUE_TYPE_INT)
    private BigDecimal rh_ln_min_bal_pr_m6;
    @ApiModelProperty(value = " 近12个月未结清贷款平均金额")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_ln_avg_amt_m12;
    @ApiModelProperty(value = "贷款五级分类正常个数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_5state_nr_num;
    @ApiModelProperty(value = "近2年内贷款逾期90天以上总月份数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_ln_nonpmf_ct_2y_rp;
    @ApiModelProperty(value = "个人经营贷款笔数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_opln_num;
    @ApiModelProperty(value = "个人经营贷款结清笔数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_opln_clear_num;
    @ApiModelProperty(value = "个人经营未结清贷款最小余额比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal	rh_opln_min_bal_pr;
    @ApiModelProperty(value = "有贷款余额的账户数目")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_ln_bal_num;
    @ApiModelProperty(value = "征信近1年内贷款累计逾期次数")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_ln_m12_ovd_sum_num;
    @ApiModelProperty(value = "征信报告上其他月还款额(不含本次申请)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_ln_avg_pay_amt;
    @ApiModelProperty(value = "从最老贷款账户开户到本次查询的月份数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_ln_old_age;
    @ApiModelProperty(value = "从最老贷款账户开户到本次查询的月份数(代码)（1. Q No Investigation2. U No Specific Information3. R No Record4. 0.0-<12.05. 12.0-<24.06. 24.0-<36.07. 36.0-<48.08. 48.0-<High）")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_ln_max_old_cd;
    @ApiModelProperty(value = "商业住房贷款笔数（全部）")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_perbushslnct_rp;
    @ApiModelProperty(value = "个人住房贷款笔数（全部）")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_perhslnct_rp;
    @ApiModelProperty(value = "其他贷款笔数（全部）")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_otlnct_rp;
    @ApiModelProperty(value = "首笔贷款发放距今月份数")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_ln_max_age;
    @ApiModelProperty(value = "首张贷记卡发卡距今月份数")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_lncd_max_age;
    @ApiModelProperty(value = "是否发生过特殊交易")
    private String	rh_ln_st_flag;
    @ApiModelProperty(value = "特殊交易-提前还款（全部）次数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_ln_st_adva;
    @ApiModelProperty(value = "个人汽车贷款当前逾期金额总额")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_carln_curodamt;
    @ApiModelProperty(value = "个人住房贷款正常笔数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_hsln_nr_num;
    @ApiModelProperty(value = "征信局借款人长期债务的分期付款")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_longln_sum_pay_amt;
    @ApiModelProperty(value = "未结清贷款最大金额")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_ln_max_amt;
    @ApiModelProperty(value = "未结清贷款平均金额")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_ln_avg_amt;
    @ApiModelProperty(value = "未结清贷款最大余额")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_ln_max_bal;
    @ApiModelProperty(value = "未结清贷款平均余额")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_ln_avg_bal;
    @ApiModelProperty(value = "（未结清）客户所有未结清贷款余额和未结清贷款金额的比值的最小值")
    @FieldValue(type = VALUE_TYPE_INT)
    private BigDecimal	rh_ln_min_bal_pr;
    @ApiModelProperty(value = "（未结清）客户所有未结清贷款余额和未结清贷款金额的比值的最大值")
    @FieldValue(type = VALUE_TYPE_INT)
    private BigDecimal	rh_ln_max_bal_pr;
    @ApiModelProperty(value = "近6个月未结清贷款平均余额")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_ln_avg_bal_m6;
    @ApiModelProperty(value = "近12个月未结清贷款总金额")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_ln_sum_amt_m12;
    @ApiModelProperty(value = "近12个月未结清贷款最大金额")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_ln_max_amt_m12;
    @ApiModelProperty(value = "近12个月未结清贷款总余额")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_ln_sum_bal_m12;
    @ApiModelProperty(value = "近12个月未结清贷款最大余额")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_ln_max_bal_m12;
    @ApiModelProperty(value = "个人汽车未结清贷款平均金额")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_carln_avg_amt;
    @ApiModelProperty(value = "截止到申请日期客户申请所有个人汽车未结清贷款余额和个人汽车未结清贷款金额的比值（min(loan_balance/loan_amt)）")
    @FieldValue(type = VALUE_TYPE_INT)
    private BigDecimal	rh_carln_min_bal_pr;
    @ApiModelProperty(value = "个人住房未结清贷款总金额")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_hsln_sum_amt;
    @ApiModelProperty(value = "个人住房未结清贷款最大金额")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_hsln_max_amt;
    @ApiModelProperty(value = "个人住房未结清贷款平均金额")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_hsln_avg_amt;
    @ApiModelProperty(value = "个人住房未结清贷款总余额")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_hsln_sum_bal;
    @ApiModelProperty(value = "贷记卡逾期账户数")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_lncd_ovd_num;
    @ApiModelProperty(value = "所有类型总逾期笔数")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_sum_ovd_num;
    @ApiModelProperty(value = "贷款逾期月份数")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_ln_ovd_mon;
    @ApiModelProperty(value = "贷款逾期单月最高逾期总额")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_ln_ovd_hgst_amt;
    @ApiModelProperty(value = "贷记卡逾期月份数")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_lncd_ovd_mon;
    @ApiModelProperty(value = "贷记卡逾期单月最高逾期总额")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_lncd_ovd_hgst_amt;
    @ApiModelProperty(value = "贷记卡最长逾期月数")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_lncd_ovd_dur ;
    @ApiModelProperty(value = "所有类型逾期月份数汇总")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_sum_ovd_mon;
    @ApiModelProperty(value = "所有类型逾期月份数最大值")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_max_ovd_mon;
    @ApiModelProperty(value = "所有类型逾期月份数均值(有值类型平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_avg_ovd_mon;
    @ApiModelProperty(value = "所有类型单月最高逾期总额汇总")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_sum_ovd_hgst_amt;
    @ApiModelProperty(value = "所有类型单月最高逾期总额最大值")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_max_ovd_hgst_amt;
    @ApiModelProperty(value = "所有类型单月最高逾期总额最大值均值(有值类型平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_avg_ovd_hgst_amt;
    @ApiModelProperty(value = "所有类型单月最高逾期总额最大 值均值(有值类型平均)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_mn_ovd_hgst_amt;
    @ApiModelProperty(value = " 所有类型最长逾期月数汇总")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_sum_ovd_dur;
    @ApiModelProperty(value = "所有类型最长逾期月数的最大值")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_max_ovd_dur;
    @ApiModelProperty(value = "未结清贷款余额")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_uc_ln_bal;
    @ApiModelProperty(value = "未结清贷款金额")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer rh_uc_ln_amt;
    @ApiModelProperty(value = "未结清贷款近6个月平均使用额度")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_uc_ln_m6avg_amt;
    @ApiModelProperty(value = "未销户贷记卡已用额度比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_uc_ud_pro;
    @ApiModelProperty(value = "贷款余额与信用卡使用额度之和（未销户）")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_cr_sum_bal;
    @ApiModelProperty(value = "贷款余额占贷款余额与信用卡使用额度之和的比例（未销户）")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_ln_bal_pral;
    @ApiModelProperty(value = "信用卡使用额度占贷款余额与信用卡使用额度之和的比例（未销户）")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal	rh_cd_bal_pral;
    @ApiModelProperty(value = "贷款金额占贷款金额与信用卡额度之和的比例（未销户）")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal	rh_ln_amt_pral;
    @ApiModelProperty(value = "信用卡额度占贷款金额与信用卡额度之和的比例（未销户)")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_cd_amt_pral;
    @ApiModelProperty(value = "信贷产品账户数（包含已销户）")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_cr_num;
    @ApiModelProperty(value = "未销户贷记卡占总信贷产品账户数比例（未销户）")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal	rh_lncd_cr_uc_num_pro;
    @ApiModelProperty(value = "信贷产品单月逾期最高总额最大值")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_cr_ovd_max_amt;
    @ApiModelProperty(value = "信贷产品种类数(包含已结清)")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_cr_cate_num;
    @ApiModelProperty(value = "基础月负债金额1")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal	rh_ln_avg_bal_amt;
    @ApiModelProperty(value = "过去24个月产品逾期次数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_m24_cr_ovd_num;
    @ApiModelProperty(value = "近2年内贷款审批查询次数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_ln_y2_qy_num;
    @ApiModelProperty(value = "近2年内信用卡审批查询次数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_crc_y2_qy_num;
    @ApiModelProperty(value = "近2年内信用卡审批最晚查询时间距本次申请的时间间隔")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_crc_qy_lst_inte;
    @ApiModelProperty(value = "近2年内担保查询次数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_guar_y2_qy_num;
    @ApiModelProperty(value = "最近3个月查询数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_m3_qy_num;
    @ApiModelProperty(value = "近2年内信贷产品查询次数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_cr_y2_qy_num;
    @ApiModelProperty(value = "近2年内贷后管理查询次数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_pstln_y2_qy_num;
    @ApiModelProperty(value = "近2年内特约商户实名审查查询次数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_merch_y2_qy_num;
    @ApiModelProperty(value = "最近1个月本人查询次数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_self_m1_qy_num;
    @ApiModelProperty(value = "近12个月信贷产品查询机构数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_cr_m12_qy_org_num;
    @ApiModelProperty(value = "近2年内贷款占信贷产品查询次数比例")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal	rh_ln_cr_y2_qy_pro;
    @ApiModelProperty(value = "近2年内信用卡占信贷产品查询次数比例")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_cr_y2_qy_pro;
    @ApiModelProperty(value = "近2年内信用卡查询失败次数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_crc_y2_qyf_num;
    @ApiModelProperty(value = "近12个月信用卡查询失败次数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_crc_m12_qyf_num;
    @ApiModelProperty(value = "近2年内信贷产品查询失败次数占比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal	rh_cr_y2_qyf_pro;
    @ApiModelProperty(value = "近2年内贷款查询失败次数占比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal	rh_ln_y2_qyf_pro;
    @ApiModelProperty(value = "近2年内信用卡查询失败次数占比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal	rh_crc_y2_qyf_pro;
    @ApiModelProperty(value = "近2年内信用卡查询失败次数占信贷产品查询失败次数比例")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal	rh_crc_cr_y2_qyf_pro;
    @ApiModelProperty(value = "近6个月信用卡查询失败次数占信贷产品查询失败次数比例")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_cr_m6_qyf_pro;
    @ApiModelProperty(value = "近12个月信用卡查询失败次数占信贷产品查询失败次数比例")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal	rh_crc_cr_m12_qyf_pro;
    @ApiModelProperty(value = "近2年内贷款查询失败次数占信贷产品查询失败次数比例")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_ln_cr_y2_qyf_pro;
    @ApiModelProperty(value = "近12个月贷款查询失败次数占信贷产品查询失败次数比例")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal	rh_ln_cr_m12_qyf_pro;
    @ApiModelProperty(value = "近2年内贷款审批查询机构数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_ln_y2_qy_org_num;
    @ApiModelProperty(value = "近2年内信用卡审批查询机构数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_crc_y2_qy_org_num;
    @ApiModelProperty(value = "近2年内担保查询机构数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_guar_y2_qy_org_num;
    @ApiModelProperty(value = "近2年内信贷产品查询机构数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_cr_y2_qy_org_num;
    @ApiModelProperty(value = "近2年内贷款占信贷产品查询机构数比例")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal	rh_ln_cr_y2_qy_org_pro;
    @ApiModelProperty(value = "近2年内信用卡占信贷产品查询机构数比例")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal	rh_crc_cr_y2_qy_org_pro;
    @ApiModelProperty(value = "近12个月内贷款占信贷产品查询机构数比例")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal	rh_ln_cr_m12_qy_org_pro;
    @ApiModelProperty(value = "近2年内信贷产品查询失败机构数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_cr_y2_qyf_org_num;
    @ApiModelProperty(value = "近2年内贷款查询失败机构数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_ln_y2_qyf_org_num;
    @ApiModelProperty(value = "近2年内信用卡查询失败机构数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_crc_y2_qyf_org_num;
    @ApiModelProperty(value = "近2年内信贷产品查询失败机构数占比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal	rh_cr_y2_qyf_org_pro;
    @ApiModelProperty(value = "近2年内贷款查询失败机构数占比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal	rh_ln_y2_qyf_org_pro;
    @ApiModelProperty(value = "近2年内信用卡查询失败机构数占比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal	rh_crc_y2_qyf_org_pro;
    @ApiModelProperty(value = "近2年内信用卡查询失败机构数占信贷产品查询失败机构数比例")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal	rh_crc_cr_y2_qyf_org_pro;
    @ApiModelProperty(value = "近2年内贷款查询失败机构数占信贷产品查询失败机构数比例")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_ln_cr_y2_qyf_org_pro;
    @ApiModelProperty(value = "最近12个月信用卡审批查询数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_m12_crc_qy_num;
    @ApiModelProperty(value = "近2年内贷款查询失败次数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_ln_y2_qyf_num;
    @ApiModelProperty(value = "近6个月信用卡查询失败次数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_crc_m6_qyf_num;
    @ApiModelProperty(value = "最近12个月贷款审批查询数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_m12_ln_qy_num;
    @ApiModelProperty(value = "近6个月信贷产品查询失败次数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_cr_m6_qyf_num;
    @ApiModelProperty(value = "近12个月贷款查询失败次数占比")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal	rh_ln_m12_qyf_pro;
    @ApiModelProperty(value = "近12个月未销户人民币贷记卡账户数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_lncd_uc_num_m12;
    @ApiModelProperty(value = "近12个月未销户人民币账户贷记卡总授信额度")
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private Integer	rh_lncd_sum_cr_lmt_m12;
    @ApiModelProperty(value = "近12个月贷款审批查询机构数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_ln_m12_qy_org_num;
    @ApiModelProperty(value = "个人农户贷款最近还款日期")
    private String	rh_agln_rct_paydt;
    @ApiModelProperty(value = "信贷产品最早开立月份")
    private String	rh_cr_op_min_dt;
    @ApiModelProperty(value = "近6个月正常人民币贷记卡账户数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_lncd_nr_num_m6;
    @ApiModelProperty(value = "最近6个月信用卡审批查询数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer rh_m6_crc_qy_num;
    @ApiModelProperty(value = "近6个月贷款查询失败次数")
    @FieldValue(type = VALUE_TYPE_INT)
    private Integer	rh_ln_m6_qyf_num;
    /**
     *  潘宇
     */

    //todo rh_lncd_op_max_dt_timestamp
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_op_max_dt_timestamp;
    //todo rh_lncd_op_old_dt_timestamp
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_op_old_dt_timestamp;
    //todo rh_stlncd_op_max_dt_timestamp
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_op_max_dt_timestamp;
    //todo rh_stlncd_op_old_dt_timestamp
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_op_old_dt_timestamp;
    //todo rh_crc_op_max_dt_timestamp
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_op_max_dt_timestamp;
    //todo rh_ln_op_max_dt_timestamp
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_ln_op_max_dt_timestamp;
    //todo rh_ln_rct_paydt_timestamp
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_ln_rct_paydt_timestamp;
    //todo rh_carln_rct_paydt_timestamp
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_carln_rct_paydt_timestamp;
    //todo rh_carln_op_max_dt_timestamp
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_carln_op_max_dt_timestamp;
    //todo rh_hsln_rct_paydt_timestamp
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_hsln_rct_paydt_timestamp;
    //todo rh_hsln_op_max_dt_timestamp
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_hsln_op_max_dt_timestamp;
    //todo rh_opln_rct_paydt_timestamp
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_opln_rct_paydt_timestamp;
    //todo rh_oprln_op_max_dt_timestamp
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_oprln_op_max_dt_timestamp;
    //todo rh_agln_rct_paydt_timestamp
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_agln_rct_paydt_timestamp;
    //todo rh_agln_op_max_dt_timestamp
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_agln_op_max_dt_timestamp;
    //todo rh_ln_op_old_dt_timestamp
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_ln_op_old_dt_timestamp;
    //todo rh_ln_op_min_dt_timestamp
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_ln_op_min_dt_timestamp;
    //todo rh_lncd_op_min_dt_timestamp
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_op_min_dt_timestamp;
    //todo rh_stlncd_op_min_dt_timestamp
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_op_min_dt_timestamp;
    //todo rh_cr_op_min_dt_timestamp
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_cr_op_min_dt_timestamp;
    //todo rh_qy_max_dt_timestamp
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_qy_max_dt_timestamp;

    //todo rh_ln_op_max_dt_year
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_ln_op_max_dt_year;
    //todo rh_ln_rct_paydt_year
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_ln_rct_paydt_year;
    //todo rh_agln_op_max_dt_year
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_agln_op_max_dt_year;
    //todo rh_ln_op_old_dt_year
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_ln_op_old_dt_year;
    //todo rh_ln_op_min_dt_year
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_ln_op_min_dt_year;
    //todo rh_lncd_op_min_dt_year
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_op_min_dt_year;
    //todo rh_qy_max_dt_year
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_qy_max_dt_year;

    //todo rh_lncd_op_max_dt_month
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_op_max_dt_month;
    //todo rh_lncd_op_old_dt_month
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_op_old_dt_month;
    //todo rh_ln_rct_paydt_month
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_ln_rct_paydt_month;
    //todo rh_ln_op_min_dt_month
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_ln_op_min_dt_month;
    //todo rh_lncd_op_min_dt_month
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_op_min_dt_month;
    //todo rh_stlncd_op_min_dt_month
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_op_min_dt_month;
    //todo rh_qy_max_dt_month
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_qy_max_dt_month;

    //todo rh_lncd_op_max_dt_day
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_op_max_dt_day;
    //todo rh_lncd_op_old_dt_day
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_op_old_dt_day;
    //todo rh_lncd_op_old_dt_day
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_op_max_dt_day;
    //todo rh_stlncd_op_old_dt_day
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_op_old_dt_day;
    //todo rh_ln_op_max_dt_day
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_ln_op_max_dt_day;
    //todo rh_ln_rct_paydt_day
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_ln_rct_paydt_day;
    //todo rh_carln_op_max_dt_day
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_carln_op_max_dt_day;
    //todo rh_hsln_rct_paydt_day
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_hsln_rct_paydt_day;
    //todo rh_hsln_op_max_dt_day
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_hsln_op_max_dt_day;
    //todo rh_opln_rct_paydt_day
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_opln_rct_paydt_day;
    //todo rh_oprln_op_max_dt_day
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_oprln_op_max_dt_day;
    //todo rh_agln_op_max_dt_day
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_agln_op_max_dt_day;
    //todo rh_ln_op_old_dt_day
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_ln_op_old_dt_day;
    //todo rh_qy_max_dt_day
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_qy_max_dt_day;

    //todo rh_lncd_op_max_dt_week
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_op_max_dt_week;
    //todo rh_lncd_op_old_dt_week
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_op_old_dt_week;
    //todo rh_stlncd_op_max_dt_week
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_op_max_dt_week;
    //todo rh_ln_op_max_dt_week
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_ln_op_max_dt_week;
    //todo rh_ln_rct_paydt_week
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_ln_rct_paydt_week;
    //todo rh_carln_op_max_dt_week
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_carln_op_max_dt_week;
    //todo rh_hsln_rct_paydt_week
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_hsln_rct_paydt_week;
    //todo rh_oprln_op_max_dt_week
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_oprln_op_max_dt_week;
    //todo rh_agln_op_max_dt_week
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_agln_op_max_dt_week;
    //todo rh_ln_op_old_dt_week
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_ln_op_old_dt_week;
    //todo rh_qy_max_dt_week
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_qy_max_dt_week;

    //todo rh_lncd_op_max_dt_year
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_op_max_dt_year;
    //todo rh_lncd_op_old_dt_year
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_lncd_op_old_dt_year;
    //todo rh_stlncd_op_max_dt_year
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_op_max_dt_year;
    //todo rh_stlncd_op_min_dt_year
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_op_min_dt_year;
    //todo rh_stlncd_op_old_dt_year
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_op_old_dt_year;

    //todo rh_stlncd_op_max_dt_month
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_op_max_dt_month;
    //todo rh_stlncd_op_old_dt_month
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_stlncd_op_old_dt_month;

    //todo rh_crc_op_max_dt_year
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_op_max_dt_year;
    //todo rh_cr_op_min_dt_year
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_cr_op_min_dt_year;
    //todo rh_crc_op_max_dt_month
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_crc_op_max_dt_month;
    //todo rh_cr_op_min_dt_month
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_cr_op_min_dt_month;
    //todo rh_ln_op_max_dt_month
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_ln_op_max_dt_month;

    //todo rh_carln_rct_paydt_year
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_carln_rct_paydt_year;
    //todo rh_carln_op_max_dt_year
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_carln_op_max_dt_year;

    //todo rh_carln_rct_paydt_month
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_carln_rct_paydt_month;
    //todo rh_carln_op_max_dt_month
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_carln_op_max_dt_month;
    //todo rh_hsln_rct_paydt_year
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_hsln_rct_paydt_year;
    //todo rh_hsln_op_max_dt_year
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_hsln_op_max_dt_year;
    //todo rh_hsln_rct_paydt_month
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_hsln_rct_paydt_month;
    //todo rh_hsln_op_max_dt_month
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_hsln_op_max_dt_month;
    //todo rh_opln_rct_paydt_year
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_opln_rct_paydt_year;
    //todo rh_oprln_op_max_dt_year
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_oprln_op_max_dt_year;
    //todo rh_opln_rct_paydt_month
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_opln_rct_paydt_month;
    //todo rh_oprln_op_max_dt_month
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_oprln_op_max_dt_month;
    //todo rh_agln_rct_paydt_year
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_agln_rct_paydt_year;
    //todo rh_agln_rct_paydt_month
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_agln_rct_paydt_month;
    //todo rh_agln_op_max_dt_month
    @FieldValue(type = VALUE_TYPE_BIG_DECIMAL)
    private BigDecimal rh_agln_op_max_dt_month;

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public BigDecimal getRh_bs_industry_mat() {
        return rh_bs_industry_mat;
    }

    public void setRh_bs_industry_mat(BigDecimal rh_bs_industry_mat) {
        this.rh_bs_industry_mat = rh_bs_industry_mat;
    }

    public BigDecimal getRh_lncd_nr_mn_cr_lmt() {
        return rh_lncd_nr_mn_cr_lmt;
    }

    public void setRh_lncd_nr_mn_cr_lmt(BigDecimal rh_lncd_nr_mn_cr_lmt) {
        this.rh_lncd_nr_mn_cr_lmt = rh_lncd_nr_mn_cr_lmt;
    }

    public Integer getRh_lncd_nr_min_cr_lmt() {
        return rh_lncd_nr_min_cr_lmt;
    }

    public void setRh_lncd_nr_min_cr_lmt(Integer rh_lncd_nr_min_cr_lmt) {
        this.rh_lncd_nr_min_cr_lmt = rh_lncd_nr_min_cr_lmt;
    }

    public Integer getRh_lncd_nr_min_sd_lmt() {
        return rh_lncd_nr_min_sd_lmt;
    }

    public void setRh_lncd_nr_min_sd_lmt(Integer rh_lncd_nr_min_sd_lmt) {
        this.rh_lncd_nr_min_sd_lmt = rh_lncd_nr_min_sd_lmt;
    }

    public BigDecimal getRh_lncd_min_ud_sd_lmt_pr() {
        return rh_lncd_min_ud_sd_lmt_pr;
    }

    public void setRh_lncd_min_ud_sd_lmt_pr(BigDecimal rh_lncd_min_ud_sd_lmt_pr) {
        this.rh_lncd_min_ud_sd_lmt_pr = rh_lncd_min_ud_sd_lmt_pr;
    }

    public BigDecimal getRh_lncd_nr_min_ud_sd_lmt_pr() {
        return rh_lncd_nr_min_ud_sd_lmt_pr;
    }

    public void setRh_lncd_nr_min_ud_sd_lmt_pr(BigDecimal rh_lncd_nr_min_ud_sd_lmt_pr) {
        this.rh_lncd_nr_min_ud_sd_lmt_pr = rh_lncd_nr_min_ud_sd_lmt_pr;
    }

    public BigDecimal getRh_lncd_avg_curdef_amt() {
        return rh_lncd_avg_curdef_amt;
    }

    public void setRh_lncd_avg_curdef_amt(BigDecimal rh_lncd_avg_curdef_amt) {
        this.rh_lncd_avg_curdef_amt = rh_lncd_avg_curdef_amt;
    }

    public Integer getRh_lncd_max_curdef_amt() {
        return rh_lncd_max_curdef_amt;
    }

    public void setRh_lncd_max_curdef_amt(Integer rh_lncd_max_curdef_amt) {
        this.rh_lncd_max_curdef_amt = rh_lncd_max_curdef_amt;
    }

    public Integer getRh_lncd_ovd_ct_3y_rp() {
        return rh_lncd_ovd_ct_3y_rp;
    }

    public void setRh_lncd_ovd_ct_3y_rp(Integer rh_lncd_ovd_ct_3y_rp) {
        this.rh_lncd_ovd_ct_3y_rp = rh_lncd_ovd_ct_3y_rp;
    }

    public Integer getRh_m24_lncd_ovd_max_perd() {
        return rh_m24_lncd_ovd_max_perd;
    }

    public void setRh_m24_lncd_ovd_max_perd(Integer rh_m24_lncd_ovd_max_perd) {
        this.rh_m24_lncd_ovd_max_perd = rh_m24_lncd_ovd_max_perd;
    }

    public BigDecimal getRh_lncd_nr_mn_cr_lmt_m6() {
        return rh_lncd_nr_mn_cr_lmt_m6;
    }

    public void setRh_lncd_nr_mn_cr_lmt_m6(BigDecimal rh_lncd_nr_mn_cr_lmt_m6) {
        this.rh_lncd_nr_mn_cr_lmt_m6 = rh_lncd_nr_mn_cr_lmt_m6;
    }

    public Integer getRh_lncd_lim_org_ds_num() {
        return rh_lncd_lim_org_ds_num;
    }

    public void setRh_lncd_lim_org_ds_num(Integer rh_lncd_lim_org_ds_num) {
        this.rh_lncd_lim_org_ds_num = rh_lncd_lim_org_ds_num;
    }

    public Integer getRh_lncd_per_num() {
        return rh_lncd_per_num;
    }

    public void setRh_lncd_per_num(Integer rh_lncd_per_num) {
        this.rh_lncd_per_num = rh_lncd_per_num;
    }

    public Integer getRh_stlncd_nr_sum_ud_cr_lmt() {
        return rh_stlncd_nr_sum_ud_cr_lmt;
    }

    public void setRh_stlncd_nr_sum_ud_cr_lmt(Integer rh_stlncd_nr_sum_ud_cr_lmt) {
        this.rh_stlncd_nr_sum_ud_cr_lmt = rh_stlncd_nr_sum_ud_cr_lmt;
    }

    public Integer getRh_stlncd_nr_min_ud_cr_lmt() {
        return rh_stlncd_nr_min_ud_cr_lmt;
    }

    public void setRh_stlncd_nr_min_ud_cr_lmt(Integer rh_stlncd_nr_min_ud_cr_lmt) {
        this.rh_stlncd_nr_min_ud_cr_lmt = rh_stlncd_nr_min_ud_cr_lmt;
    }

    public Integer getRh_crc_uc_max_age() {
        return rh_crc_uc_max_age;
    }

    public void setRh_crc_uc_max_age(Integer rh_crc_uc_max_age) {
        this.rh_crc_uc_max_age = rh_crc_uc_max_age;
    }

    public Integer getRh_crc_ovd_ct_3y_rp() {
        return rh_crc_ovd_ct_3y_rp;
    }

    public void setRh_crc_ovd_ct_3y_rp(Integer rh_crc_ovd_ct_3y_rp) {
        this.rh_crc_ovd_ct_3y_rp = rh_crc_ovd_ct_3y_rp;
    }

    public Integer getRh_ln_num() {
        return rh_ln_num;
    }

    public void setRh_ln_num(Integer rh_ln_num) {
        this.rh_ln_num = rh_ln_num;
    }

    public Integer getRh_ln_st_advp() {
        return rh_ln_st_advp;
    }

    public void setRh_ln_st_advp(Integer rh_ln_st_advp) {
        this.rh_ln_st_advp = rh_ln_st_advp;
    }

    public Integer getRh_ln_st_oth() {
        return rh_ln_st_oth;
    }

    public void setRh_ln_st_oth(Integer rh_ln_st_oth) {
        this.rh_ln_st_oth = rh_ln_st_oth;
    }

    public Integer getRh_ln_uc_max_age() {
        return rh_ln_uc_max_age;
    }

    public void setRh_ln_uc_max_age(Integer rh_ln_uc_max_age) {
        this.rh_ln_uc_max_age = rh_ln_uc_max_age;
    }

    public String getRh_if_houseln() {
        return rh_if_houseln;
    }

    public void setRh_if_houseln(String rh_if_houseln) {
        this.rh_if_houseln = rh_if_houseln;
    }

    public BigDecimal getRh_5state_good_pr() {
        return rh_5state_good_pr;
    }

    public void setRh_5state_good_pr(BigDecimal rh_5state_good_pr) {
        this.rh_5state_good_pr = rh_5state_good_pr;
    }

    public Integer getRh_ln_ovd_cur_amt_rp() {
        return rh_ln_ovd_cur_amt_rp;
    }

    public void setRh_ln_ovd_cur_amt_rp(Integer rh_ln_ovd_cur_amt_rp) {
        this.rh_ln_ovd_cur_amt_rp = rh_ln_ovd_cur_amt_rp;
    }

    public Integer getRh_ln_ovd_max_2y_rp() {
        return rh_ln_ovd_max_2y_rp;
    }

    public void setRh_ln_ovd_max_2y_rp(Integer rh_ln_ovd_max_2y_rp) {
        this.rh_ln_ovd_max_2y_rp = rh_ln_ovd_max_2y_rp;
    }

    public Integer getRh_carln_sum_amt() {
        return rh_carln_sum_amt;
    }

    public void setRh_carln_sum_amt(Integer rh_carln_sum_amt) {
        this.rh_carln_sum_amt = rh_carln_sum_amt;
    }

    public Integer getRh_carln_st_adva() {
        return rh_carln_st_adva;
    }

    public void setRh_carln_st_adva(Integer rh_carln_st_adva) {
        this.rh_carln_st_adva = rh_carln_st_adva;
    }

    public Integer getRh_hsln_avg_bal() {
        return rh_hsln_avg_bal;
    }

    public void setRh_hsln_avg_bal(Integer rh_hsln_avg_bal) {
        this.rh_hsln_avg_bal = rh_hsln_avg_bal;
    }

    public BigDecimal getRh_hsln_min_bal_pr() {
        return rh_hsln_min_bal_pr;
    }

    public void setRh_hsln_min_bal_pr(BigDecimal rh_hsln_min_bal_pr) {
        this.rh_hsln_min_bal_pr = rh_hsln_min_bal_pr;
    }

    public BigDecimal getRh_hsln_max_bal_pr() {
        return rh_hsln_max_bal_pr;
    }

    public void setRh_hsln_max_bal_pr(BigDecimal rh_hsln_max_bal_pr) {
        this.rh_hsln_max_bal_pr = rh_hsln_max_bal_pr;
    }

    public Integer getRh_opln_nr_num() {
        return rh_opln_nr_num;
    }

    public void setRh_opln_nr_num(Integer rh_opln_nr_num) {
        this.rh_opln_nr_num = rh_opln_nr_num;
    }

    public Integer getRh_opln_max_amt() {
        return rh_opln_max_amt;
    }

    public void setRh_opln_max_amt(Integer rh_opln_max_amt) {
        this.rh_opln_max_amt = rh_opln_max_amt;
    }

    public Integer getRh_opln_max_bal() {
        return rh_opln_max_bal;
    }

    public void setRh_opln_max_bal(Integer rh_opln_max_bal) {
        this.rh_opln_max_bal = rh_opln_max_bal;
    }

    public Integer getRh_opln_avg_bal() {
        return rh_opln_avg_bal;
    }

    public void setRh_opln_avg_bal(Integer rh_opln_avg_bal) {
        this.rh_opln_avg_bal = rh_opln_avg_bal;
    }

    public Integer getRh_opln_st_adva() {
        return rh_opln_st_adva;
    }

    public void setRh_opln_st_adva(Integer rh_opln_st_adva) {
        this.rh_opln_st_adva = rh_opln_st_adva;
    }

    public Integer getRh_agln_max_bal() {
        return rh_agln_max_bal;
    }

    public void setRh_agln_max_bal(Integer rh_agln_max_bal) {
        this.rh_agln_max_bal = rh_agln_max_bal;
    }

    public Integer getRh_hsln_sum_num() {
        return rh_hsln_sum_num;
    }

    public void setRh_hsln_sum_num(Integer rh_hsln_sum_num) {
        this.rh_hsln_sum_num = rh_hsln_sum_num;
    }

    public Integer getRh_ln_ovd_dur() {
        return rh_ln_ovd_dur;
    }

    public void setRh_ln_ovd_dur(Integer rh_ln_ovd_dur) {
        this.rh_ln_ovd_dur = rh_ln_ovd_dur;
    }

    public Integer getRh_ln_corg_num() {
        return rh_ln_corg_num;
    }

    public void setRh_ln_corg_num(Integer rh_ln_corg_num) {
        this.rh_ln_corg_num = rh_ln_corg_num;
    }

    public Integer getRh_ln_org_num() {
        return rh_ln_org_num;
    }

    public void setRh_ln_org_num(Integer rh_ln_org_num) {
        this.rh_ln_org_num = rh_ln_org_num;
    }

    public Integer getRh_lncd_ud_amt() {
        return rh_lncd_ud_amt;
    }

    public void setRh_lncd_ud_amt(Integer rh_lncd_ud_amt) {
        this.rh_lncd_ud_amt = rh_lncd_ud_amt;
    }

    public BigDecimal getRh_m6_lncd_ud_pro() {
        return rh_m6_lncd_ud_pro;
    }

    public void setRh_m6_lncd_ud_pro(BigDecimal rh_m6_lncd_ud_pro) {
        this.rh_m6_lncd_ud_pro = rh_m6_lncd_ud_pro;
    }

    public Integer getRh_cr_lim_amt() {
        return rh_cr_lim_amt;
    }

    public void setRh_cr_lim_amt(Integer rh_cr_lim_amt) {
        this.rh_cr_lim_amt = rh_cr_lim_amt;
    }

    public Integer getRh_gr_sum_amt() {
        return rh_gr_sum_amt;
    }

    public void setRh_gr_sum_amt(Integer rh_gr_sum_amt) {
        this.rh_gr_sum_amt = rh_gr_sum_amt;
    }

    public Integer getRh_gr_tol_bal() {
        return rh_gr_tol_bal;
    }

    public void setRh_gr_tol_bal(Integer rh_gr_tol_bal) {
        this.rh_gr_tol_bal = rh_gr_tol_bal;
    }

    public BigDecimal getRh_cr_bal_pro() {
        return rh_cr_bal_pro;
    }

    public void setRh_cr_bal_pro(BigDecimal rh_cr_bal_pro) {
        this.rh_cr_bal_pro = rh_cr_bal_pro;
    }

    public BigDecimal getRh_crc_ud_pro() {
        return rh_crc_ud_pro;
    }

    public void setRh_crc_ud_pro(BigDecimal rh_crc_ud_pro) {
        this.rh_crc_ud_pro = rh_crc_ud_pro;
    }

    public BigDecimal getRh_ln_bal_pro() {
        return rh_ln_bal_pro;
    }

    public void setRh_ln_bal_pro(BigDecimal rh_ln_bal_pro) {
        this.rh_ln_bal_pro = rh_ln_bal_pro;
    }

    public Integer getRh_m6_cr_ovd_mon() {
        return rh_m6_cr_ovd_mon;
    }

    public void setRh_m6_cr_ovd_mon(Integer rh_m6_cr_ovd_mon) {
        this.rh_m6_cr_ovd_mon = rh_m6_cr_ovd_mon;
    }

    public Integer getRh_m24_cr_ovd_mon() {
        return rh_m24_cr_ovd_mon;
    }

    public void setRh_m24_cr_ovd_mon(Integer rh_m24_cr_ovd_mon) {
        this.rh_m24_cr_ovd_mon = rh_m24_cr_ovd_mon;
    }

    public Integer getRh_m12_cr_ovd_mon() {
        return rh_m12_cr_ovd_mon;
    }

    public void setRh_m12_cr_ovd_mon(Integer rh_m12_cr_ovd_mon) {
        this.rh_m12_cr_ovd_mon = rh_m12_cr_ovd_mon;
    }

    public Integer getRh_cr_uc_min_age() {
        return rh_cr_uc_min_age;
    }

    public void setRh_cr_uc_min_age(Integer rh_cr_uc_min_age) {
        this.rh_cr_uc_min_age = rh_cr_uc_min_age;
    }

    public Integer getRh_ln_qy_lst_inte() {
        return rh_ln_qy_lst_inte;
    }

    public void setRh_ln_qy_lst_inte(Integer rh_ln_qy_lst_inte) {
        this.rh_ln_qy_lst_inte = rh_ln_qy_lst_inte;
    }

    public Integer getRh_ln_qy_fst_inte() {
        return rh_ln_qy_fst_inte;
    }

    public void setRh_ln_qy_fst_inte(Integer rh_ln_qy_fst_inte) {
        this.rh_ln_qy_fst_inte = rh_ln_qy_fst_inte;
    }

    public Integer getRh_crc_qy_fst_inte() {
        return rh_crc_qy_fst_inte;
    }

    public void setRh_crc_qy_fst_inte(Integer rh_crc_qy_fst_inte) {
        this.rh_crc_qy_fst_inte = rh_crc_qy_fst_inte;
    }

    public Integer getRh_cr_y2_qyf_num() {
        return rh_cr_y2_qyf_num;
    }

    public void setRh_cr_y2_qyf_num(Integer rh_cr_y2_qyf_num) {
        this.rh_cr_y2_qyf_num = rh_cr_y2_qyf_num;
    }

    public Integer getRh_lncd_num() {
        return rh_lncd_num;
    }

    public void setRh_lncd_num(Integer rh_lncd_num) {
        this.rh_lncd_num = rh_lncd_num;
    }

    public Integer getRh_lncd_uc_num() {
        return rh_lncd_uc_num;
    }

    public void setRh_lncd_uc_num(Integer rh_lncd_uc_num) {
        this.rh_lncd_uc_num = rh_lncd_uc_num;
    }

    public Integer getRh_lncd_nr_num() {
        return rh_lncd_nr_num;
    }

    public void setRh_lncd_nr_num(Integer rh_lncd_nr_num) {
        this.rh_lncd_nr_num = rh_lncd_nr_num;
    }

    public Integer getRh_lncd_nopen_num() {
        return rh_lncd_nopen_num;
    }

    public void setRh_lncd_nopen_num(Integer rh_lncd_nopen_num) {
        this.rh_lncd_nopen_num = rh_lncd_nopen_num;
    }

    public Integer getRh_lncd_cancel_num() {
        return rh_lncd_cancel_num;
    }

    public void setRh_lncd_cancel_num(Integer rh_lncd_cancel_num) {
        this.rh_lncd_cancel_num = rh_lncd_cancel_num;
    }

    public Integer getRh_lncd_oc_num() {
        return rh_lncd_oc_num;
    }

    public void setRh_lncd_oc_num(Integer rh_lncd_oc_num) {
        this.rh_lncd_oc_num = rh_lncd_oc_num;
    }

    public Integer getRh_lncd_max_nr_cr_lmt() {
        return rh_lncd_max_nr_cr_lmt;
    }

    public void setRh_lncd_max_nr_cr_lmt(Integer rh_lncd_max_nr_cr_lmt) {
        this.rh_lncd_max_nr_cr_lmt = rh_lncd_max_nr_cr_lmt;
    }

    public BigDecimal getRh_lncd_nr_avg_sd_lmt() {
        return rh_lncd_nr_avg_sd_lmt;
    }

    public void setRh_lncd_nr_avg_sd_lmt(BigDecimal rh_lncd_nr_avg_sd_lmt) {
        this.rh_lncd_nr_avg_sd_lmt = rh_lncd_nr_avg_sd_lmt;
    }

    public BigDecimal getRh_lncd_nr_mn_sd_lmt() {
        return rh_lncd_nr_mn_sd_lmt;
    }

    public void setRh_lncd_nr_mn_sd_lmt(BigDecimal rh_lncd_nr_mn_sd_lmt) {
        this.rh_lncd_nr_mn_sd_lmt = rh_lncd_nr_mn_sd_lmt;
    }

    public Integer getRh_lncd_max_nr_sd_lmt() {
        return rh_lncd_max_nr_sd_lmt;
    }

    public void setRh_lncd_max_nr_sd_lmt(Integer rh_lncd_max_nr_sd_lmt) {
        this.rh_lncd_max_nr_sd_lmt = rh_lncd_max_nr_sd_lmt;
    }

    public Integer getRh_lncd_sum_nr_ud_cr_lmt() {
        return rh_lncd_sum_nr_ud_cr_lmt;
    }

    public void setRh_lncd_sum_nr_ud_cr_lmt(Integer rh_lncd_sum_nr_ud_cr_lmt) {
        this.rh_lncd_sum_nr_ud_cr_lmt = rh_lncd_sum_nr_ud_cr_lmt;
    }

    public BigDecimal getRh_lncd_nr_avg_ud_cr_lmt() {
        return rh_lncd_nr_avg_ud_cr_lmt;
    }

    public void setRh_lncd_nr_avg_ud_cr_lmt(BigDecimal rh_lncd_nr_avg_ud_cr_lmt) {
        this.rh_lncd_nr_avg_ud_cr_lmt = rh_lncd_nr_avg_ud_cr_lmt;
    }

    public Integer getRh_lncd_max_nr_ud_cr_lmt() {
        return rh_lncd_max_nr_ud_cr_lmt;
    }

    public void setRh_lncd_max_nr_ud_cr_lmt(Integer rh_lncd_max_nr_ud_cr_lmt) {
        this.rh_lncd_max_nr_ud_cr_lmt = rh_lncd_max_nr_ud_cr_lmt;
    }

    public BigDecimal getRh_lncd_max_nr_ud_cr_lmt_pr() {
        return rh_lncd_max_nr_ud_cr_lmt_pr;
    }

    public void setRh_lncd_max_nr_ud_cr_lmt_pr(BigDecimal rh_lncd_max_nr_ud_cr_lmt_pr) {
        this.rh_lncd_max_nr_ud_cr_lmt_pr = rh_lncd_max_nr_ud_cr_lmt_pr;
    }

    public BigDecimal getRh_lncd_nr_avg_ud_cr_lmt_pr() {
        return rh_lncd_nr_avg_ud_cr_lmt_pr;
    }

    public void setRh_lncd_nr_avg_ud_cr_lmt_pr(BigDecimal rh_lncd_nr_avg_ud_cr_lmt_pr) {
        this.rh_lncd_nr_avg_ud_cr_lmt_pr = rh_lncd_nr_avg_ud_cr_lmt_pr;
    }

    public BigDecimal getRh_lncd_sum_nr_ud_cr_lmt_pr() {
        return rh_lncd_sum_nr_ud_cr_lmt_pr;
    }

    public void setRh_lncd_sum_nr_ud_cr_lmt_pr(BigDecimal rh_lncd_sum_nr_ud_cr_lmt_pr) {
        this.rh_lncd_sum_nr_ud_cr_lmt_pr = rh_lncd_sum_nr_ud_cr_lmt_pr;
    }

    public BigDecimal getRh_lncd_max_nr_ud_sd_lmt_pr() {
        return rh_lncd_max_nr_ud_sd_lmt_pr;
    }

    public void setRh_lncd_max_nr_ud_sd_lmt_pr(BigDecimal rh_lncd_max_nr_ud_sd_lmt_pr) {
        this.rh_lncd_max_nr_ud_sd_lmt_pr = rh_lncd_max_nr_ud_sd_lmt_pr;
    }

    public BigDecimal getRh_lncd_sum_nr_ud_sd_lmt_pr() {
        return rh_lncd_sum_nr_ud_sd_lmt_pr;
    }

    public void setRh_lncd_sum_nr_ud_sd_lmt_pr(BigDecimal rh_lncd_sum_nr_ud_sd_lmt_pr) {
        this.rh_lncd_sum_nr_ud_sd_lmt_pr = rh_lncd_sum_nr_ud_sd_lmt_pr;
    }

    public Integer getRh_lncd_sum_cr_lmt() {
        return rh_lncd_sum_cr_lmt;
    }

    public void setRh_lncd_sum_cr_lmt(Integer rh_lncd_sum_cr_lmt) {
        this.rh_lncd_sum_cr_lmt = rh_lncd_sum_cr_lmt;
    }

    public BigDecimal getRh_lncd_avg_cr_lmt() {
        return rh_lncd_avg_cr_lmt;
    }

    public void setRh_lncd_avg_cr_lmt(BigDecimal rh_lncd_avg_cr_lmt) {
        this.rh_lncd_avg_cr_lmt = rh_lncd_avg_cr_lmt;
    }

    public BigDecimal getRh_lncd_mn_cr_lmt() {
        return rh_lncd_mn_cr_lmt;
    }

    public void setRh_lncd_mn_cr_lmt(BigDecimal rh_lncd_mn_cr_lmt) {
        this.rh_lncd_mn_cr_lmt = rh_lncd_mn_cr_lmt;
    }

    public Integer getRh_lncd_uc_lmt_min() {
        return rh_lncd_uc_lmt_min;
    }

    public void setRh_lncd_uc_lmt_min(Integer rh_lncd_uc_lmt_min) {
        this.rh_lncd_uc_lmt_min = rh_lncd_uc_lmt_min;
    }

    public Integer getRh_lncd_uc_lmt_max() {
        return rh_lncd_uc_lmt_max;
    }

    public void setRh_lncd_uc_lmt_max(Integer rh_lncd_uc_lmt_max) {
        this.rh_lncd_uc_lmt_max = rh_lncd_uc_lmt_max;
    }

    public Integer getRh_lncd_sum_sd_lmt() {
        return rh_lncd_sum_sd_lmt;
    }

    public void setRh_lncd_sum_sd_lmt(Integer rh_lncd_sum_sd_lmt) {
        this.rh_lncd_sum_sd_lmt = rh_lncd_sum_sd_lmt;
    }

    public BigDecimal getRh_lncd_avg_sd_lmt() {
        return rh_lncd_avg_sd_lmt;
    }

    public void setRh_lncd_avg_sd_lmt(BigDecimal rh_lncd_avg_sd_lmt) {
        this.rh_lncd_avg_sd_lmt = rh_lncd_avg_sd_lmt;
    }

    public BigDecimal getRh_lncd_mn_sd_lmt() {
        return rh_lncd_mn_sd_lmt;
    }

    public void setRh_lncd_mn_sd_lmt(BigDecimal rh_lncd_mn_sd_lmt) {
        this.rh_lncd_mn_sd_lmt = rh_lncd_mn_sd_lmt;
    }

    public Integer getRh_lncd_max_sd_lmt() {
        return rh_lncd_max_sd_lmt;
    }

    public void setRh_lncd_max_sd_lmt(Integer rh_lncd_max_sd_lmt) {
        this.rh_lncd_max_sd_lmt = rh_lncd_max_sd_lmt;
    }

    public Integer getRh_lncd_min_sd_lmt() {
        return rh_lncd_min_sd_lmt;
    }

    public void setRh_lncd_min_sd_lmt(Integer rh_lncd_min_sd_lmt) {
        this.rh_lncd_min_sd_lmt = rh_lncd_min_sd_lmt;
    }

    public Integer getRh_lncd_sum_ud_cr_lmt() {
        return rh_lncd_sum_ud_cr_lmt;
    }

    public void setRh_lncd_sum_ud_cr_lmt(Integer rh_lncd_sum_ud_cr_lmt) {
        this.rh_lncd_sum_ud_cr_lmt = rh_lncd_sum_ud_cr_lmt;
    }

    public BigDecimal getRh_lncd_avg_ud_cr_lmt() {
        return rh_lncd_avg_ud_cr_lmt;
    }

    public void setRh_lncd_avg_ud_cr_lmt(BigDecimal rh_lncd_avg_ud_cr_lmt) {
        this.rh_lncd_avg_ud_cr_lmt = rh_lncd_avg_ud_cr_lmt;
    }

    public Integer getRh_lncd_max_ud_cr_lmt() {
        return rh_lncd_max_ud_cr_lmt;
    }

    public void setRh_lncd_max_ud_cr_lmt(Integer rh_lncd_max_ud_cr_lmt) {
        this.rh_lncd_max_ud_cr_lmt = rh_lncd_max_ud_cr_lmt;
    }

    public Integer getRh_lncd_min_ud_cr_lmt() {
        return rh_lncd_min_ud_cr_lmt;
    }

    public void setRh_lncd_min_ud_cr_lmt(Integer rh_lncd_min_ud_cr_lmt) {
        this.rh_lncd_min_ud_cr_lmt = rh_lncd_min_ud_cr_lmt;
    }

    public BigDecimal getRh_lncd_uc_max_amt_pro() {
        return rh_lncd_uc_max_amt_pro;
    }

    public void setRh_lncd_uc_max_amt_pro(BigDecimal rh_lncd_uc_max_amt_pro) {
        this.rh_lncd_uc_max_amt_pro = rh_lncd_uc_max_amt_pro;
    }

    public BigDecimal getRh_lncd_avg_ud_cr_lmt_pr() {
        return rh_lncd_avg_ud_cr_lmt_pr;
    }

    public void setRh_lncd_avg_ud_cr_lmt_pr(BigDecimal rh_lncd_avg_ud_cr_lmt_pr) {
        this.rh_lncd_avg_ud_cr_lmt_pr = rh_lncd_avg_ud_cr_lmt_pr;
    }

    public BigDecimal getRh_lncd_mn_ud_cr_lmt_pr() {
        return rh_lncd_mn_ud_cr_lmt_pr;
    }

    public void setRh_lncd_mn_ud_cr_lmt_pr(BigDecimal rh_lncd_mn_ud_cr_lmt_pr) {
        this.rh_lncd_mn_ud_cr_lmt_pr = rh_lncd_mn_ud_cr_lmt_pr;
    }

    public BigDecimal getRh_lncd_sum_ud_cr_lmt_pr() {
        return rh_lncd_sum_ud_cr_lmt_pr;
    }

    public void setRh_lncd_sum_ud_cr_lmt_pr(BigDecimal rh_lncd_sum_ud_cr_lmt_pr) {
        this.rh_lncd_sum_ud_cr_lmt_pr = rh_lncd_sum_ud_cr_lmt_pr;
    }

    public BigDecimal getRh_lncd_max_ud_sd_lmt_pr() {
        return rh_lncd_max_ud_sd_lmt_pr;
    }

    public void setRh_lncd_max_ud_sd_lmt_pr(BigDecimal rh_lncd_max_ud_sd_lmt_pr) {
        this.rh_lncd_max_ud_sd_lmt_pr = rh_lncd_max_ud_sd_lmt_pr;
    }

    public BigDecimal getRh_lncd_avg_ud_sd_lmt_pr() {
        return rh_lncd_avg_ud_sd_lmt_pr;
    }

    public void setRh_lncd_avg_ud_sd_lmt_pr(BigDecimal rh_lncd_avg_ud_sd_lmt_pr) {
        this.rh_lncd_avg_ud_sd_lmt_pr = rh_lncd_avg_ud_sd_lmt_pr;
    }

    public BigDecimal getRh_lncd_mn_ud_sd_lmt_pr() {
        return rh_lncd_mn_ud_sd_lmt_pr;
    }

    public void setRh_lncd_mn_ud_sd_lmt_pr(BigDecimal rh_lncd_mn_ud_sd_lmt_pr) {
        this.rh_lncd_mn_ud_sd_lmt_pr = rh_lncd_mn_ud_sd_lmt_pr;
    }

    public BigDecimal getRh_lncd_sum_ud_sd_lmt_pr() {
        return rh_lncd_sum_ud_sd_lmt_pr;
    }

    public void setRh_lncd_sum_ud_sd_lmt_pr(BigDecimal rh_lncd_sum_ud_sd_lmt_pr) {
        this.rh_lncd_sum_ud_sd_lmt_pr = rh_lncd_sum_ud_sd_lmt_pr;
    }

    public Integer getRh_lncd_avg_max_ud_amt() {
        return rh_lncd_avg_max_ud_amt;
    }

    public void setRh_lncd_avg_max_ud_amt(Integer rh_lncd_avg_max_ud_amt) {
        this.rh_lncd_avg_max_ud_amt = rh_lncd_avg_max_ud_amt;
    }

    public Integer getRh_lncd_sum_max_ud_amt() {
        return rh_lncd_sum_max_ud_amt;
    }

    public void setRh_lncd_sum_max_ud_amt(Integer rh_lncd_sum_max_ud_amt) {
        this.rh_lncd_sum_max_ud_amt = rh_lncd_sum_max_ud_amt;
    }

    public Integer getRh_lncd_max_max_ud_amt() {
        return rh_lncd_max_max_ud_amt;
    }

    public void setRh_lncd_max_max_ud_amt(Integer rh_lncd_max_max_ud_amt) {
        this.rh_lncd_max_max_ud_amt = rh_lncd_max_max_ud_amt;
    }

    public Integer getRh_lncd_ovd_ct_2y_rp() {
        return rh_lncd_ovd_ct_2y_rp;
    }

    public void setRh_lncd_ovd_ct_2y_rp(Integer rh_lncd_ovd_ct_2y_rp) {
        this.rh_lncd_ovd_ct_2y_rp = rh_lncd_ovd_ct_2y_rp;
    }

    public Integer getRh_lncd_max_sd_lmt_m6() {
        return rh_lncd_max_sd_lmt_m6;
    }

    public void setRh_lncd_max_sd_lmt_m6(Integer rh_lncd_max_sd_lmt_m6) {
        this.rh_lncd_max_sd_lmt_m6 = rh_lncd_max_sd_lmt_m6;
    }

    public Integer getRh_lncd_sum_nr_cr_lmt_m6() {
        return rh_lncd_sum_nr_cr_lmt_m6;
    }

    public void setRh_lncd_sum_nr_cr_lmt_m6(Integer rh_lncd_sum_nr_cr_lmt_m6) {
        this.rh_lncd_sum_nr_cr_lmt_m6 = rh_lncd_sum_nr_cr_lmt_m6;
    }

    public Integer getRh_lncd_sum_nr_cr_lmt() {
        return rh_lncd_sum_nr_cr_lmt;
    }

    public void setRh_lncd_sum_nr_cr_lmt(Integer rh_lncd_sum_nr_cr_lmt) {
        this.rh_lncd_sum_nr_cr_lmt = rh_lncd_sum_nr_cr_lmt;
    }

    public BigDecimal getRh_lncd_nr_avg_cr_lmt() {
        return rh_lncd_nr_avg_cr_lmt;
    }

    public void setRh_lncd_nr_avg_cr_lmt(BigDecimal rh_lncd_nr_avg_cr_lmt) {
        this.rh_lncd_nr_avg_cr_lmt = rh_lncd_nr_avg_cr_lmt;
    }

    public Integer getRh_lncd_sum_nr_cr_lmt_m12() {
        return rh_lncd_sum_nr_cr_lmt_m12;
    }

    public void setRh_lncd_sum_nr_cr_lmt_m12(Integer rh_lncd_sum_nr_cr_lmt_m12) {
        this.rh_lncd_sum_nr_cr_lmt_m12 = rh_lncd_sum_nr_cr_lmt_m12;
    }

    public Integer getRh_lncd_nr_num_m12() {
        return rh_lncd_nr_num_m12;
    }

    public void setRh_lncd_nr_num_m12(Integer rh_lncd_nr_num_m12) {
        this.rh_lncd_nr_num_m12 = rh_lncd_nr_num_m12;
    }

    public BigDecimal getRh_lncd_nr_mn_cr_lmt_m12() {
        return rh_lncd_nr_mn_cr_lmt_m12;
    }

    public void setRh_lncd_nr_mn_cr_lmt_m12(BigDecimal rh_lncd_nr_mn_cr_lmt_m12) {
        this.rh_lncd_nr_mn_cr_lmt_m12 = rh_lncd_nr_mn_cr_lmt_m12;
    }

    public Integer getRh_lncd_od180amt_sum_amt() {
        return rh_lncd_od180amt_sum_amt;
    }

    public void setRh_lncd_od180amt_sum_amt(Integer rh_lncd_od180amt_sum_amt) {
        this.rh_lncd_od180amt_sum_amt = rh_lncd_od180amt_sum_amt;
    }

    public Integer getRh_lncd_mid_ovd_num() {
        return rh_lncd_mid_ovd_num;
    }

    public void setRh_lncd_mid_ovd_num(Integer rh_lncd_mid_ovd_num) {
        this.rh_lncd_mid_ovd_num = rh_lncd_mid_ovd_num;
    }

    public Integer getRh_lncd_high_ovd_num() {
        return rh_lncd_high_ovd_num;
    }

    public void setRh_lncd_high_ovd_num(Integer rh_lncd_high_ovd_num) {
        this.rh_lncd_high_ovd_num = rh_lncd_high_ovd_num;
    }

    public String getRh_lncd_bad_state() {
        return rh_lncd_bad_state;
    }

    public void setRh_lncd_bad_state(String rh_lncd_bad_state) {
        this.rh_lncd_bad_state = rh_lncd_bad_state;
    }

    public String getRh_lncd_op_max_dt() {
        return rh_lncd_op_max_dt;
    }

    public void setRh_lncd_op_max_dt(String rh_lncd_op_max_dt) {
        this.rh_lncd_op_max_dt = rh_lncd_op_max_dt;
    }

    public String getRh_lncd_op_old_dt() {
        return rh_lncd_op_old_dt;
    }

    public void setRh_lncd_op_old_dt(String rh_lncd_op_old_dt) {
        this.rh_lncd_op_old_dt = rh_lncd_op_old_dt;
    }

    public Integer getRh_lncd_old_age() {
        return rh_lncd_old_age;
    }

    public void setRh_lncd_old_age(Integer rh_lncd_old_age) {
        this.rh_lncd_old_age = rh_lncd_old_age;
    }

    public Integer getRh_lncd_detail_max_age() {
        return rh_lncd_detail_max_age;
    }

    public void setRh_lncd_detail_max_age(Integer rh_lncd_detail_max_age) {
        this.rh_lncd_detail_max_age = rh_lncd_detail_max_age;
    }

    public String getRh_lncd_op_min_dt() {
        return rh_lncd_op_min_dt;
    }

    public void setRh_lncd_op_min_dt(String rh_lncd_op_min_dt) {
        this.rh_lncd_op_min_dt = rh_lncd_op_min_dt;
    }

    public String getRh_lncd_if_ovd_2y_rp() {
        return rh_lncd_if_ovd_2y_rp;
    }

    public void setRh_lncd_if_ovd_2y_rp(String rh_lncd_if_ovd_2y_rp) {
        this.rh_lncd_if_ovd_2y_rp = rh_lncd_if_ovd_2y_rp;
    }

    public Integer getRh_crc_num() {
        return rh_crc_num;
    }

    public void setRh_crc_num(Integer rh_crc_num) {
        this.rh_crc_num = rh_crc_num;
    }

    public Integer getRh_crc_nopen_num() {
        return rh_crc_nopen_num;
    }

    public void setRh_crc_nopen_num(Integer rh_crc_nopen_num) {
        this.rh_crc_nopen_num = rh_crc_nopen_num;
    }

    public Integer getRh_crc_cancel_num() {
        return rh_crc_cancel_num;
    }

    public void setRh_crc_cancel_num(Integer rh_crc_cancel_num) {
        this.rh_crc_cancel_num = rh_crc_cancel_num;
    }

    public Integer getRh_crc_uc_num() {
        return rh_crc_uc_num;
    }

    public void setRh_crc_uc_num(Integer rh_crc_uc_num) {
        this.rh_crc_uc_num = rh_crc_uc_num;
    }

    public Integer getRh_crc_sum_cr_lmt() {
        return rh_crc_sum_cr_lmt;
    }

    public void setRh_crc_sum_cr_lmt(Integer rh_crc_sum_cr_lmt) {
        this.rh_crc_sum_cr_lmt = rh_crc_sum_cr_lmt;
    }

    public BigDecimal getRh_crc_avg_cr_lmt() {
        return rh_crc_avg_cr_lmt;
    }

    public void setRh_crc_avg_cr_lmt(BigDecimal rh_crc_avg_cr_lmt) {
        this.rh_crc_avg_cr_lmt = rh_crc_avg_cr_lmt;
    }

    public BigDecimal getRh_crc_mn_cr_lmt() {
        return rh_crc_mn_cr_lmt;
    }

    public void setRh_crc_mn_cr_lmt(BigDecimal rh_crc_mn_cr_lmt) {
        this.rh_crc_mn_cr_lmt = rh_crc_mn_cr_lmt;
    }

    public Integer getRh_crc_sum_sd_lmt() {
        return rh_crc_sum_sd_lmt;
    }

    public void setRh_crc_sum_sd_lmt(Integer rh_crc_sum_sd_lmt) {
        this.rh_crc_sum_sd_lmt = rh_crc_sum_sd_lmt;
    }

    public BigDecimal getRh_crc_mn_sd_lmt() {
        return rh_crc_mn_sd_lmt;
    }

    public void setRh_crc_mn_sd_lmt(BigDecimal rh_crc_mn_sd_lmt) {
        this.rh_crc_mn_sd_lmt = rh_crc_mn_sd_lmt;
    }

    public BigDecimal getRh_crc_avg_sd_lmt() {
        return rh_crc_avg_sd_lmt;
    }

    public void setRh_crc_avg_sd_lmt(BigDecimal rh_crc_avg_sd_lmt) {
        this.rh_crc_avg_sd_lmt = rh_crc_avg_sd_lmt;
    }

    public Integer getRh_crc_sum_nr_cr_lmt() {
        return rh_crc_sum_nr_cr_lmt;
    }

    public void setRh_crc_sum_nr_cr_lmt(Integer rh_crc_sum_nr_cr_lmt) {
        this.rh_crc_sum_nr_cr_lmt = rh_crc_sum_nr_cr_lmt;
    }

    public Integer getRh_crc_nr_num() {
        return rh_crc_nr_num;
    }

    public void setRh_crc_nr_num(Integer rh_crc_nr_num) {
        this.rh_crc_nr_num = rh_crc_nr_num;
    }

    public BigDecimal getRh_crc_nr_mn_cr_lmt() {
        return rh_crc_nr_mn_cr_lmt;
    }

    public void setRh_crc_nr_mn_cr_lmt(BigDecimal rh_crc_nr_mn_cr_lmt) {
        this.rh_crc_nr_mn_cr_lmt = rh_crc_nr_mn_cr_lmt;
    }

    public Integer getRh_crc_max_nr_cr_lmt() {
        return rh_crc_max_nr_cr_lmt;
    }

    public void setRh_crc_max_nr_cr_lmt(Integer rh_crc_max_nr_cr_lmt) {
        this.rh_crc_max_nr_cr_lmt = rh_crc_max_nr_cr_lmt;
    }

    public Integer getRh_crc_sum_ud_cr_lmt() {
        return rh_crc_sum_ud_cr_lmt;
    }

    public void setRh_crc_sum_ud_cr_lmt(Integer rh_crc_sum_ud_cr_lmt) {
        this.rh_crc_sum_ud_cr_lmt = rh_crc_sum_ud_cr_lmt;
    }

    public BigDecimal getRh_crc_mn_ud_cr_lmt() {
        return rh_crc_mn_ud_cr_lmt;
    }

    public void setRh_crc_mn_ud_cr_lmt(BigDecimal rh_crc_mn_ud_cr_lmt) {
        this.rh_crc_mn_ud_cr_lmt = rh_crc_mn_ud_cr_lmt;
    }

    public BigDecimal getRh_crc_uc_max_amt_pro() {
        return rh_crc_uc_max_amt_pro;
    }

    public void setRh_crc_uc_max_amt_pro(BigDecimal rh_crc_uc_max_amt_pro) {
        this.rh_crc_uc_max_amt_pro = rh_crc_uc_max_amt_pro;
    }

    public BigDecimal getRh_crc_uc_min_amt_pro() {
        return rh_crc_uc_min_amt_pro;
    }

    public void setRh_crc_uc_min_amt_pro(BigDecimal rh_crc_uc_min_amt_pro) {
        this.rh_crc_uc_min_amt_pro = rh_crc_uc_min_amt_pro;
    }

    public BigDecimal getRh_crc_avg_ud_cr_lmt_pr() {
        return rh_crc_avg_ud_cr_lmt_pr;
    }

    public void setRh_crc_avg_ud_cr_lmt_pr(BigDecimal rh_crc_avg_ud_cr_lmt_pr) {
        this.rh_crc_avg_ud_cr_lmt_pr = rh_crc_avg_ud_cr_lmt_pr;
    }

    public BigDecimal getRh_crc_mn_ud_cr_lmt_pr() {
        return rh_crc_mn_ud_cr_lmt_pr;
    }

    public void setRh_crc_mn_ud_cr_lmt_pr(BigDecimal rh_crc_mn_ud_cr_lmt_pr) {
        this.rh_crc_mn_ud_cr_lmt_pr = rh_crc_mn_ud_cr_lmt_pr;
    }

    public BigDecimal getRh_crc_max_ud_sd_lmt_pr() {
        return rh_crc_max_ud_sd_lmt_pr;
    }

    public void setRh_crc_max_ud_sd_lmt_pr(BigDecimal rh_crc_max_ud_sd_lmt_pr) {
        this.rh_crc_max_ud_sd_lmt_pr = rh_crc_max_ud_sd_lmt_pr;
    }

    public BigDecimal getRh_crc_min_ud_sd_lmt_pr() {
        return rh_crc_min_ud_sd_lmt_pr;
    }

    public void setRh_crc_min_ud_sd_lmt_pr(BigDecimal rh_crc_min_ud_sd_lmt_pr) {
        this.rh_crc_min_ud_sd_lmt_pr = rh_crc_min_ud_sd_lmt_pr;
    }

    public BigDecimal getRh_crc_sum_ud_sd_lmt_pr() {
        return rh_crc_sum_ud_sd_lmt_pr;
    }

    public void setRh_crc_sum_ud_sd_lmt_pr(BigDecimal rh_crc_sum_ud_sd_lmt_pr) {
        this.rh_crc_sum_ud_sd_lmt_pr = rh_crc_sum_ud_sd_lmt_pr;
    }

    public BigDecimal getRh_crc_max_nr_ud_cr_lmt_pr() {
        return rh_crc_max_nr_ud_cr_lmt_pr;
    }

    public void setRh_crc_max_nr_ud_cr_lmt_pr(BigDecimal rh_crc_max_nr_ud_cr_lmt_pr) {
        this.rh_crc_max_nr_ud_cr_lmt_pr = rh_crc_max_nr_ud_cr_lmt_pr;
    }

    public BigDecimal getRh_crc_nr_min_ud_cr_lmt_pr() {
        return rh_crc_nr_min_ud_cr_lmt_pr;
    }

    public void setRh_crc_nr_min_ud_cr_lmt_pr(BigDecimal rh_crc_nr_min_ud_cr_lmt_pr) {
        this.rh_crc_nr_min_ud_cr_lmt_pr = rh_crc_nr_min_ud_cr_lmt_pr;
    }

    public BigDecimal getRh_crc_nr_avg_ud_cr_lmt_pr() {
        return rh_crc_nr_avg_ud_cr_lmt_pr;
    }

    public void setRh_crc_nr_avg_ud_cr_lmt_pr(BigDecimal rh_crc_nr_avg_ud_cr_lmt_pr) {
        this.rh_crc_nr_avg_ud_cr_lmt_pr = rh_crc_nr_avg_ud_cr_lmt_pr;
    }

    public BigDecimal getRh_crc_nr_mn_ud_cr_lmt_pr() {
        return rh_crc_nr_mn_ud_cr_lmt_pr;
    }

    public void setRh_crc_nr_mn_ud_cr_lmt_pr(BigDecimal rh_crc_nr_mn_ud_cr_lmt_pr) {
        this.rh_crc_nr_mn_ud_cr_lmt_pr = rh_crc_nr_mn_ud_cr_lmt_pr;
    }

    public BigDecimal getRh_crc_max_nr_ud_sd_lmt_pr() {
        return rh_crc_max_nr_ud_sd_lmt_pr;
    }

    public void setRh_crc_max_nr_ud_sd_lmt_pr(BigDecimal rh_crc_max_nr_ud_sd_lmt_pr) {
        this.rh_crc_max_nr_ud_sd_lmt_pr = rh_crc_max_nr_ud_sd_lmt_pr;
    }

    public BigDecimal getRh_crc_nr_min_ud_sd_lmt_pr() {
        return rh_crc_nr_min_ud_sd_lmt_pr;
    }

    public void setRh_crc_nr_min_ud_sd_lmt_pr(BigDecimal rh_crc_nr_min_ud_sd_lmt_pr) {
        this.rh_crc_nr_min_ud_sd_lmt_pr = rh_crc_nr_min_ud_sd_lmt_pr;
    }

    public BigDecimal getRh_crc_sum_nr_ud_sd_lmt_pr() {
        return rh_crc_sum_nr_ud_sd_lmt_pr;
    }

    public void setRh_crc_sum_nr_ud_sd_lmt_pr(BigDecimal rh_crc_sum_nr_ud_sd_lmt_pr) {
        this.rh_crc_sum_nr_ud_sd_lmt_pr = rh_crc_sum_nr_ud_sd_lmt_pr;
    }

    public Integer getRh_crc_max_max_ud_amt() {
        return rh_crc_max_max_ud_amt;
    }

    public void setRh_crc_max_max_ud_amt(Integer rh_crc_max_max_ud_amt) {
        this.rh_crc_max_max_ud_amt = rh_crc_max_max_ud_amt;
    }

    public Integer getRh_crc_ovd_ct_2y_rp() {
        return rh_crc_ovd_ct_2y_rp;
    }

    public void setRh_crc_ovd_ct_2y_rp(Integer rh_crc_ovd_ct_2y_rp) {
        this.rh_crc_ovd_ct_2y_rp = rh_crc_ovd_ct_2y_rp;
    }

    public Integer getRh_crc_sum_nr_cr_lmt_m6() {
        return rh_crc_sum_nr_cr_lmt_m6;
    }

    public void setRh_crc_sum_nr_cr_lmt_m6(Integer rh_crc_sum_nr_cr_lmt_m6) {
        this.rh_crc_sum_nr_cr_lmt_m6 = rh_crc_sum_nr_cr_lmt_m6;
    }

    public BigDecimal getRh_crc_nr_avg_cr_lmt_m6() {
        return rh_crc_nr_avg_cr_lmt_m6;
    }

    public void setRh_crc_nr_avg_cr_lmt_m6(BigDecimal rh_crc_nr_avg_cr_lmt_m6) {
        this.rh_crc_nr_avg_cr_lmt_m6 = rh_crc_nr_avg_cr_lmt_m6;
    }

    public Integer getRh_crc_nr_num_m6() {
        return rh_crc_nr_num_m6;
    }

    public void setRh_crc_nr_num_m6(Integer rh_crc_nr_num_m6) {
        this.rh_crc_nr_num_m6 = rh_crc_nr_num_m6;
    }

    public BigDecimal getRh_crc_nr_mn_cr_lmt_m6() {
        return rh_crc_nr_mn_cr_lmt_m6;
    }

    public void setRh_crc_nr_mn_cr_lmt_m6(BigDecimal rh_crc_nr_mn_cr_lmt_m6) {
        this.rh_crc_nr_mn_cr_lmt_m6 = rh_crc_nr_mn_cr_lmt_m6;
    }

    public Integer getRh_crc_nr_num_m12() {
        return rh_crc_nr_num_m12;
    }

    public void setRh_crc_nr_num_m12(Integer rh_crc_nr_num_m12) {
        this.rh_crc_nr_num_m12 = rh_crc_nr_num_m12;
    }

    public BigDecimal getRh_crc_nr_mn_cr_lmt_m12() {
        return rh_crc_nr_mn_cr_lmt_m12;
    }

    public void setRh_crc_nr_mn_cr_lmt_m12(BigDecimal rh_crc_nr_mn_cr_lmt_m12) {
        this.rh_crc_nr_mn_cr_lmt_m12 = rh_crc_nr_mn_cr_lmt_m12;
    }

    public Integer getRh_crc_od180amt_sum_amt() {
        return rh_crc_od180amt_sum_amt;
    }

    public void setRh_crc_od180amt_sum_amt(Integer rh_crc_od180amt_sum_amt) {
        this.rh_crc_od180amt_sum_amt = rh_crc_od180amt_sum_amt;
    }

    public Integer getRh_crc_max_age() {
        return rh_crc_max_age;
    }

    public void setRh_crc_max_age(Integer rh_crc_max_age) {
        this.rh_crc_max_age = rh_crc_max_age;
    }

    public Integer getRh_stlncd_uc_num() {
        return rh_stlncd_uc_num;
    }

    public void setRh_stlncd_uc_num(Integer rh_stlncd_uc_num) {
        this.rh_stlncd_uc_num = rh_stlncd_uc_num;
    }

    public Integer getRh_stlncd_nopen_num() {
        return rh_stlncd_nopen_num;
    }

    public void setRh_stlncd_nopen_num(Integer rh_stlncd_nopen_num) {
        this.rh_stlncd_nopen_num = rh_stlncd_nopen_num;
    }

    public Integer getRh_stlncd_cancel_num() {
        return rh_stlncd_cancel_num;
    }

    public void setRh_stlncd_cancel_num(Integer rh_stlncd_cancel_num) {
        this.rh_stlncd_cancel_num = rh_stlncd_cancel_num;
    }

    public Integer getRh_stlncd_oc_num() {
        return rh_stlncd_oc_num;
    }

    public void setRh_stlncd_oc_num(Integer rh_stlncd_oc_num) {
        this.rh_stlncd_oc_num = rh_stlncd_oc_num;
    }

    public Integer getRh_stlncd_sum_cr_lmt() {
        return rh_stlncd_sum_cr_lmt;
    }

    public void setRh_stlncd_sum_cr_lmt(Integer rh_stlncd_sum_cr_lmt) {
        this.rh_stlncd_sum_cr_lmt = rh_stlncd_sum_cr_lmt;
    }

    public BigDecimal getRh_stlncd_avg_cr_lmt() {
        return rh_stlncd_avg_cr_lmt;
    }

    public void setRh_stlncd_avg_cr_lmt(BigDecimal rh_stlncd_avg_cr_lmt) {
        this.rh_stlncd_avg_cr_lmt = rh_stlncd_avg_cr_lmt;
    }

    public BigDecimal getRh_stlncd_mn_cr_lmt() {
        return rh_stlncd_mn_cr_lmt;
    }

    public void setRh_stlncd_mn_cr_lmt(BigDecimal rh_stlncd_mn_cr_lmt) {
        this.rh_stlncd_mn_cr_lmt = rh_stlncd_mn_cr_lmt;
    }

    public Integer getRh_stlncd_sum_sd_lmt() {
        return rh_stlncd_sum_sd_lmt;
    }

    public void setRh_stlncd_sum_sd_lmt(Integer rh_stlncd_sum_sd_lmt) {
        this.rh_stlncd_sum_sd_lmt = rh_stlncd_sum_sd_lmt;
    }

    public BigDecimal getRh_stlncd_avg_sd_lmt() {
        return rh_stlncd_avg_sd_lmt;
    }

    public void setRh_stlncd_avg_sd_lmt(BigDecimal rh_stlncd_avg_sd_lmt) {
        this.rh_stlncd_avg_sd_lmt = rh_stlncd_avg_sd_lmt;
    }

    public BigDecimal getRh_stlncd_mn_sd_lmt() {
        return rh_stlncd_mn_sd_lmt;
    }

    public void setRh_stlncd_mn_sd_lmt(BigDecimal rh_stlncd_mn_sd_lmt) {
        this.rh_stlncd_mn_sd_lmt = rh_stlncd_mn_sd_lmt;
    }

    public Integer getRh_stlncd_nr_sum_cr_lmt() {
        return rh_stlncd_nr_sum_cr_lmt;
    }

    public void setRh_stlncd_nr_sum_cr_lmt(Integer rh_stlncd_nr_sum_cr_lmt) {
        this.rh_stlncd_nr_sum_cr_lmt = rh_stlncd_nr_sum_cr_lmt;
    }

    public Integer getRh_stlncd_nr_num() {
        return rh_stlncd_nr_num;
    }

    public void setRh_stlncd_nr_num(Integer rh_stlncd_nr_num) {
        this.rh_stlncd_nr_num = rh_stlncd_nr_num;
    }

    public BigDecimal getRh_stlncd_nr_mn_cr_lmt() {
        return rh_stlncd_nr_mn_cr_lmt;
    }

    public void setRh_stlncd_nr_mn_cr_lmt(BigDecimal rh_stlncd_nr_mn_cr_lmt) {
        this.rh_stlncd_nr_mn_cr_lmt = rh_stlncd_nr_mn_cr_lmt;
    }

    public Integer getRh_stlncd_nr_max_cr_lmt() {
        return rh_stlncd_nr_max_cr_lmt;
    }

    public void setRh_stlncd_nr_max_cr_lmt(Integer rh_stlncd_nr_max_cr_lmt) {
        this.rh_stlncd_nr_max_cr_lmt = rh_stlncd_nr_max_cr_lmt;
    }

    public Integer getRh_stlncd_nr_min_cr_lmt() {
        return rh_stlncd_nr_min_cr_lmt;
    }

    public void setRh_stlncd_nr_min_cr_lmt(Integer rh_stlncd_nr_min_cr_lmt) {
        this.rh_stlncd_nr_min_cr_lmt = rh_stlncd_nr_min_cr_lmt;
    }

    public Integer getRh_stlncd_nr_sum_sd_lmt() {
        return rh_stlncd_nr_sum_sd_lmt;
    }

    public void setRh_stlncd_nr_sum_sd_lmt(Integer rh_stlncd_nr_sum_sd_lmt) {
        this.rh_stlncd_nr_sum_sd_lmt = rh_stlncd_nr_sum_sd_lmt;
    }

    public BigDecimal getRh_stlncd_nr_avg_sd_lmt() {
        return rh_stlncd_nr_avg_sd_lmt;
    }

    public void setRh_stlncd_nr_avg_sd_lmt(BigDecimal rh_stlncd_nr_avg_sd_lmt) {
        this.rh_stlncd_nr_avg_sd_lmt = rh_stlncd_nr_avg_sd_lmt;
    }

    public BigDecimal getRh_stlncd_nr_mn_sd_lmt() {
        return rh_stlncd_nr_mn_sd_lmt;
    }

    public void setRh_stlncd_nr_mn_sd_lmt(BigDecimal rh_stlncd_nr_mn_sd_lmt) {
        this.rh_stlncd_nr_mn_sd_lmt = rh_stlncd_nr_mn_sd_lmt;
    }

    public Integer getRh_stlncd_nr_max_sd_lmt() {
        return rh_stlncd_nr_max_sd_lmt;
    }

    public void setRh_stlncd_nr_max_sd_lmt(Integer rh_stlncd_nr_max_sd_lmt) {
        this.rh_stlncd_nr_max_sd_lmt = rh_stlncd_nr_max_sd_lmt;
    }

    public Integer getRh_stlncd_nr_max_ud_cr_lmt() {
        return rh_stlncd_nr_max_ud_cr_lmt;
    }

    public void setRh_stlncd_nr_max_ud_cr_lmt(Integer rh_stlncd_nr_max_ud_cr_lmt) {
        this.rh_stlncd_nr_max_ud_cr_lmt = rh_stlncd_nr_max_ud_cr_lmt;
    }

    public BigDecimal getRh_stlncd_nr_max_ud_cr_lmt_pr() {
        return rh_stlncd_nr_max_ud_cr_lmt_pr;
    }

    public void setRh_stlncd_nr_max_ud_cr_lmt_pr(BigDecimal rh_stlncd_nr_max_ud_cr_lmt_pr) {
        this.rh_stlncd_nr_max_ud_cr_lmt_pr = rh_stlncd_nr_max_ud_cr_lmt_pr;
    }

    public BigDecimal getRh_stlncd_nr_sum_ud_cr_lmt_pr() {
        return rh_stlncd_nr_sum_ud_cr_lmt_pr;
    }

    public void setRh_stlncd_nr_sum_ud_cr_lmt_pr(BigDecimal rh_stlncd_nr_sum_ud_cr_lmt_pr) {
        this.rh_stlncd_nr_sum_ud_cr_lmt_pr = rh_stlncd_nr_sum_ud_cr_lmt_pr;
    }

    public BigDecimal getRh_stlncd_nr_max_ud_sd_lmt_pr() {
        return rh_stlncd_nr_max_ud_sd_lmt_pr;
    }

    public void setRh_stlncd_nr_max_ud_sd_lmt_pr(BigDecimal rh_stlncd_nr_max_ud_sd_lmt_pr) {
        this.rh_stlncd_nr_max_ud_sd_lmt_pr = rh_stlncd_nr_max_ud_sd_lmt_pr;
    }

    public BigDecimal getRh_stlncd_nr_mn_ud_sd_lmt_pr() {
        return rh_stlncd_nr_mn_ud_sd_lmt_pr;
    }

    public void setRh_stlncd_nr_mn_ud_sd_lmt_pr(BigDecimal rh_stlncd_nr_mn_ud_sd_lmt_pr) {
        this.rh_stlncd_nr_mn_ud_sd_lmt_pr = rh_stlncd_nr_mn_ud_sd_lmt_pr;
    }

    public BigDecimal getRh_stlncd_nr_sum_ud_sd_lmt_pr() {
        return rh_stlncd_nr_sum_ud_sd_lmt_pr;
    }

    public void setRh_stlncd_nr_sum_ud_sd_lmt_pr(BigDecimal rh_stlncd_nr_sum_ud_sd_lmt_pr) {
        this.rh_stlncd_nr_sum_ud_sd_lmt_pr = rh_stlncd_nr_sum_ud_sd_lmt_pr;
    }

    public Integer getRh_stlncd_sum_ud_cr_lmt() {
        return rh_stlncd_sum_ud_cr_lmt;
    }

    public void setRh_stlncd_sum_ud_cr_lmt(Integer rh_stlncd_sum_ud_cr_lmt) {
        this.rh_stlncd_sum_ud_cr_lmt = rh_stlncd_sum_ud_cr_lmt;
    }

    public BigDecimal getRh_stlncd_mn_ud_cr_lmt() {
        return rh_stlncd_mn_ud_cr_lmt;
    }

    public void setRh_stlncd_mn_ud_cr_lmt(BigDecimal rh_stlncd_mn_ud_cr_lmt) {
        this.rh_stlncd_mn_ud_cr_lmt = rh_stlncd_mn_ud_cr_lmt;
    }

    public BigDecimal getRh_stlncd_avg_ud_cr_lmt() {
        return rh_stlncd_avg_ud_cr_lmt;
    }

    public void setRh_stlncd_avg_ud_cr_lmt(BigDecimal rh_stlncd_avg_ud_cr_lmt) {
        this.rh_stlncd_avg_ud_cr_lmt = rh_stlncd_avg_ud_cr_lmt;
    }

    public BigDecimal getRh_stlncd_uc_max_amt_pro() {
        return rh_stlncd_uc_max_amt_pro;
    }

    public void setRh_stlncd_uc_max_amt_pro(BigDecimal rh_stlncd_uc_max_amt_pro) {
        this.rh_stlncd_uc_max_amt_pro = rh_stlncd_uc_max_amt_pro;
    }

    public BigDecimal getRh_stlncd_avg_ud_cr_lmt_pr() {
        return rh_stlncd_avg_ud_cr_lmt_pr;
    }

    public void setRh_stlncd_avg_ud_cr_lmt_pr(BigDecimal rh_stlncd_avg_ud_cr_lmt_pr) {
        this.rh_stlncd_avg_ud_cr_lmt_pr = rh_stlncd_avg_ud_cr_lmt_pr;
    }

    public BigDecimal getRh_stlncd_mn_ud_cr_lmt_pr() {
        return rh_stlncd_mn_ud_cr_lmt_pr;
    }

    public void setRh_stlncd_mn_ud_cr_lmt_pr(BigDecimal rh_stlncd_mn_ud_cr_lmt_pr) {
        this.rh_stlncd_mn_ud_cr_lmt_pr = rh_stlncd_mn_ud_cr_lmt_pr;
    }

    public BigDecimal getRh_stlncd_sum_ud_cr_lmt_pr() {
        return rh_stlncd_sum_ud_cr_lmt_pr;
    }

    public void setRh_stlncd_sum_ud_cr_lmt_pr(BigDecimal rh_stlncd_sum_ud_cr_lmt_pr) {
        this.rh_stlncd_sum_ud_cr_lmt_pr = rh_stlncd_sum_ud_cr_lmt_pr;
    }

    public BigDecimal getRh_stlncd_max_ud_sd_lmt_pr() {
        return rh_stlncd_max_ud_sd_lmt_pr;
    }

    public void setRh_stlncd_max_ud_sd_lmt_pr(BigDecimal rh_stlncd_max_ud_sd_lmt_pr) {
        this.rh_stlncd_max_ud_sd_lmt_pr = rh_stlncd_max_ud_sd_lmt_pr;
    }

    public BigDecimal getRh_stlncd_sum_ud_sd_lmt_pr() {
        return rh_stlncd_sum_ud_sd_lmt_pr;
    }

    public void setRh_stlncd_sum_ud_sd_lmt_pr(BigDecimal rh_stlncd_sum_ud_sd_lmt_pr) {
        this.rh_stlncd_sum_ud_sd_lmt_pr = rh_stlncd_sum_ud_sd_lmt_pr;
    }

    public Integer getRh_stlncd_max_max_ud_amt() {
        return rh_stlncd_max_max_ud_amt;
    }

    public void setRh_stlncd_max_max_ud_amt(Integer rh_stlncd_max_max_ud_amt) {
        this.rh_stlncd_max_max_ud_amt = rh_stlncd_max_max_ud_amt;
    }

    public Integer getRh_stlncd_sum_max_ud_amt() {
        return rh_stlncd_sum_max_ud_amt;
    }

    public void setRh_stlncd_sum_max_ud_amt(Integer rh_stlncd_sum_max_ud_amt) {
        this.rh_stlncd_sum_max_ud_amt = rh_stlncd_sum_max_ud_amt;
    }

    public Integer getRh_stlncd_ovd_ct_2y_rp() {
        return rh_stlncd_ovd_ct_2y_rp;
    }

    public void setRh_stlncd_ovd_ct_2y_rp(Integer rh_stlncd_ovd_ct_2y_rp) {
        this.rh_stlncd_ovd_ct_2y_rp = rh_stlncd_ovd_ct_2y_rp;
    }

    public Integer getRh_stlncd_ovd_ct_3y_rp() {
        return rh_stlncd_ovd_ct_3y_rp;
    }

    public void setRh_stlncd_ovd_ct_3y_rp(Integer rh_stlncd_ovd_ct_3y_rp) {
        this.rh_stlncd_ovd_ct_3y_rp = rh_stlncd_ovd_ct_3y_rp;
    }

    public Integer getRh_stlncd_nonpmf_ct_2y_rp() {
        return rh_stlncd_nonpmf_ct_2y_rp;
    }

    public void setRh_stlncd_nonpmf_ct_2y_rp(Integer rh_stlncd_nonpmf_ct_2y_rp) {
        this.rh_stlncd_nonpmf_ct_2y_rp = rh_stlncd_nonpmf_ct_2y_rp;
    }

    public Integer getRh_stlncd_num_m3() {
        return rh_stlncd_num_m3;
    }

    public void setRh_stlncd_num_m3(Integer rh_stlncd_num_m3) {
        this.rh_stlncd_num_m3 = rh_stlncd_num_m3;
    }

    public Integer getRh_stlncd_nr_sum_cr_lmt_m6() {
        return rh_stlncd_nr_sum_cr_lmt_m6;
    }

    public void setRh_stlncd_nr_sum_cr_lmt_m6(Integer rh_stlncd_nr_sum_cr_lmt_m6) {
        this.rh_stlncd_nr_sum_cr_lmt_m6 = rh_stlncd_nr_sum_cr_lmt_m6;
    }

    public Integer getRh_stlncd_od180amt_sum_amt() {
        return rh_stlncd_od180amt_sum_amt;
    }

    public void setRh_stlncd_od180amt_sum_amt(Integer rh_stlncd_od180amt_sum_amt) {
        this.rh_stlncd_od180amt_sum_amt = rh_stlncd_od180amt_sum_amt;
    }

    public Integer getRh_stlncd_high_ovd_num() {
        return rh_stlncd_high_ovd_num;
    }

    public void setRh_stlncd_high_ovd_num(Integer rh_stlncd_high_ovd_num) {
        this.rh_stlncd_high_ovd_num = rh_stlncd_high_ovd_num;
    }

    public Integer getRh_stlncd_mid_ovd_num() {
        return rh_stlncd_mid_ovd_num;
    }

    public void setRh_stlncd_mid_ovd_num(Integer rh_stlncd_mid_ovd_num) {
        this.rh_stlncd_mid_ovd_num = rh_stlncd_mid_ovd_num;
    }

    public Integer getRh_stlncd_per_num() {
        return rh_stlncd_per_num;
    }

    public void setRh_stlncd_per_num(Integer rh_stlncd_per_num) {
        this.rh_stlncd_per_num = rh_stlncd_per_num;
    }

    public String getRh_stlncd_op_max_dt() {
        return rh_stlncd_op_max_dt;
    }

    public void setRh_stlncd_op_max_dt(String rh_stlncd_op_max_dt) {
        this.rh_stlncd_op_max_dt = rh_stlncd_op_max_dt;
    }

    public String getRh_stlncd_op_old_dt() {
        return rh_stlncd_op_old_dt;
    }

    public void setRh_stlncd_op_old_dt(String rh_stlncd_op_old_dt) {
        this.rh_stlncd_op_old_dt = rh_stlncd_op_old_dt;
    }

    public String getRh_stlncd_op_min_dt() {
        return rh_stlncd_op_min_dt;
    }

    public void setRh_stlncd_op_min_dt(String rh_stlncd_op_min_dt) {
        this.rh_stlncd_op_min_dt = rh_stlncd_op_min_dt;
    }

    public String getRh_crc_op_max_dt() {
        return rh_crc_op_max_dt;
    }

    public void setRh_crc_op_max_dt(String rh_crc_op_max_dt) {
        this.rh_crc_op_max_dt = rh_crc_op_max_dt;
    }

    public String getRh_crc_op_old_dt() {
        return rh_crc_op_old_dt;
    }

    public void setRh_crc_op_old_dt(String rh_crc_op_old_dt) {
        this.rh_crc_op_old_dt = rh_crc_op_old_dt;
    }

    public String getRh_ln_op_max_dt() {
        return rh_ln_op_max_dt;
    }

    public void setRh_ln_op_max_dt(String rh_ln_op_max_dt) {
        this.rh_ln_op_max_dt = rh_ln_op_max_dt;
    }

    public String getRh_ln_op_old_dt() {
        return rh_ln_op_old_dt;
    }

    public void setRh_ln_op_old_dt(String rh_ln_op_old_dt) {
        this.rh_ln_op_old_dt = rh_ln_op_old_dt;
    }

    public String getRh_ln_op_min_dt() {
        return rh_ln_op_min_dt;
    }

    public void setRh_ln_op_min_dt(String rh_ln_op_min_dt) {
        this.rh_ln_op_min_dt = rh_ln_op_min_dt;
    }

    public String getRh_ln_rct_paydt() {
        return rh_ln_rct_paydt;
    }

    public void setRh_ln_rct_paydt(String rh_ln_rct_paydt) {
        this.rh_ln_rct_paydt = rh_ln_rct_paydt;
    }

    public String getRh_carln_rct_paydt() {
        return rh_carln_rct_paydt;
    }

    public void setRh_carln_rct_paydt(String rh_carln_rct_paydt) {
        this.rh_carln_rct_paydt = rh_carln_rct_paydt;
    }

    public String getRh_carln_op_max_dt() {
        return rh_carln_op_max_dt;
    }

    public void setRh_carln_op_max_dt(String rh_carln_op_max_dt) {
        this.rh_carln_op_max_dt = rh_carln_op_max_dt;
    }

    public String getRh_hsln_rct_paydt() {
        return rh_hsln_rct_paydt;
    }

    public void setRh_hsln_rct_paydt(String rh_hsln_rct_paydt) {
        this.rh_hsln_rct_paydt = rh_hsln_rct_paydt;
    }

    public String getRh_hsln_op_max_dt() {
        return rh_hsln_op_max_dt;
    }

    public void setRh_hsln_op_max_dt(String rh_hsln_op_max_dt) {
        this.rh_hsln_op_max_dt = rh_hsln_op_max_dt;
    }

    public String getRh_opln_rct_paydt() {
        return rh_opln_rct_paydt;
    }

    public void setRh_opln_rct_paydt(String rh_opln_rct_paydt) {
        this.rh_opln_rct_paydt = rh_opln_rct_paydt;
    }

    public String getRh_oprln_op_max_dt() {
        return rh_oprln_op_max_dt;
    }

    public void setRh_oprln_op_max_dt(String rh_oprln_op_max_dt) {
        this.rh_oprln_op_max_dt = rh_oprln_op_max_dt;
    }

    public String getRh_agln_op_max_dt() {
        return rh_agln_op_max_dt;
    }

    public void setRh_agln_op_max_dt(String rh_agln_op_max_dt) {
        this.rh_agln_op_max_dt = rh_agln_op_max_dt;
    }

    public String getRh_qy_max_dt() {
        return rh_qy_max_dt;
    }

    public void setRh_qy_max_dt(String rh_qy_max_dt) {
        this.rh_qy_max_dt = rh_qy_max_dt;
    }

    public String getReport_date() {
        return report_date;
    }

    public void setReport_date(String report_date) {
        this.report_date = report_date;
    }

    public BigDecimal getRh_crc_nr_mn_sd_lmt() {
        return rh_crc_nr_mn_sd_lmt;
    }

    public void setRh_crc_nr_mn_sd_lmt(BigDecimal rh_crc_nr_mn_sd_lmt) {
        this.rh_crc_nr_mn_sd_lmt = rh_crc_nr_mn_sd_lmt;
    }

    public BigDecimal getRh_stlncd_nr_mn_ud_cr_lmt_pr() {
        return rh_stlncd_nr_mn_ud_cr_lmt_pr;
    }

    public void setRh_stlncd_nr_mn_ud_cr_lmt_pr(BigDecimal rh_stlncd_nr_mn_ud_cr_lmt_pr) {
        this.rh_stlncd_nr_mn_ud_cr_lmt_pr = rh_stlncd_nr_mn_ud_cr_lmt_pr;
    }

    public BigDecimal getRh_lncd_nr_mn_ud_cr_lmt_pr() {
        return rh_lncd_nr_mn_ud_cr_lmt_pr;
    }

    public void setRh_lncd_nr_mn_ud_cr_lmt_pr(BigDecimal rh_lncd_nr_mn_ud_cr_lmt_pr) {
        this.rh_lncd_nr_mn_ud_cr_lmt_pr = rh_lncd_nr_mn_ud_cr_lmt_pr;
    }

    public BigDecimal getRh_crc_nr_mn_ud_sd_lmt_pr() {
        return rh_crc_nr_mn_ud_sd_lmt_pr;
    }

    public void setRh_crc_nr_mn_ud_sd_lmt_pr(BigDecimal rh_crc_nr_mn_ud_sd_lmt_pr) {
        this.rh_crc_nr_mn_ud_sd_lmt_pr = rh_crc_nr_mn_ud_sd_lmt_pr;
    }

    public BigDecimal getRh_lncd_nr_mn_ud_sd_lmt_pr() {
        return rh_lncd_nr_mn_ud_sd_lmt_pr;
    }

    public void setRh_lncd_nr_mn_ud_sd_lmt_pr(BigDecimal rh_lncd_nr_mn_ud_sd_lmt_pr) {
        this.rh_lncd_nr_mn_ud_sd_lmt_pr = rh_lncd_nr_mn_ud_sd_lmt_pr;
    }

    public BigDecimal getRh_stlncd_mn_ud_sd_lmt_pr() {
        return rh_stlncd_mn_ud_sd_lmt_pr;
    }

    public void setRh_stlncd_mn_ud_sd_lmt_pr(BigDecimal rh_stlncd_mn_ud_sd_lmt_pr) {
        this.rh_stlncd_mn_ud_sd_lmt_pr = rh_stlncd_mn_ud_sd_lmt_pr;
    }

    public BigDecimal getRh_crc_avg_ud_sd_lmt_pr() {
        return rh_crc_avg_ud_sd_lmt_pr;
    }

    public void setRh_crc_avg_ud_sd_lmt_pr(BigDecimal rh_crc_avg_ud_sd_lmt_pr) {
        this.rh_crc_avg_ud_sd_lmt_pr = rh_crc_avg_ud_sd_lmt_pr;
    }

    public BigDecimal getRh_crc_mn_ud_sd_lmt_pr() {
        return rh_crc_mn_ud_sd_lmt_pr;
    }

    public void setRh_crc_mn_ud_sd_lmt_pr(BigDecimal rh_crc_mn_ud_sd_lmt_pr) {
        this.rh_crc_mn_ud_sd_lmt_pr = rh_crc_mn_ud_sd_lmt_pr;
    }

    public Integer getRh_crc_per_num() {
        return rh_crc_per_num;
    }

    public void setRh_crc_per_num(Integer rh_crc_per_num) {
        this.rh_crc_per_num = rh_crc_per_num;
    }

    public BigDecimal getRh_crc_nr_mn_ud_cr_lmt() {
        return rh_crc_nr_mn_ud_cr_lmt;
    }

    public void setRh_crc_nr_mn_ud_cr_lmt(BigDecimal rh_crc_nr_mn_ud_cr_lmt) {
        this.rh_crc_nr_mn_ud_cr_lmt = rh_crc_nr_mn_ud_cr_lmt;
    }

    public BigDecimal getRh_lncd_nr_mn_sd_lmt_m12() {
        return rh_lncd_nr_mn_sd_lmt_m12;
    }

    public void setRh_lncd_nr_mn_sd_lmt_m12(BigDecimal rh_lncd_nr_mn_sd_lmt_m12) {
        this.rh_lncd_nr_mn_sd_lmt_m12 = rh_lncd_nr_mn_sd_lmt_m12;
    }

    public BigDecimal getRh_lncd_nr_mn_ud_cr_lmt() {
        return rh_lncd_nr_mn_ud_cr_lmt;
    }

    public void setRh_lncd_nr_mn_ud_cr_lmt(BigDecimal rh_lncd_nr_mn_ud_cr_lmt) {
        this.rh_lncd_nr_mn_ud_cr_lmt = rh_lncd_nr_mn_ud_cr_lmt;
    }

    public BigDecimal getRh_lncd_nr_mn_ud_cr_lmt_m12() {
        return rh_lncd_nr_mn_ud_cr_lmt_m12;
    }

    public void setRh_lncd_nr_mn_ud_cr_lmt_m12(BigDecimal rh_lncd_nr_mn_ud_cr_lmt_m12) {
        this.rh_lncd_nr_mn_ud_cr_lmt_m12 = rh_lncd_nr_mn_ud_cr_lmt_m12;
    }

    public BigDecimal getRh_crc_mn_cr_lmt_m12() {
        return rh_crc_mn_cr_lmt_m12;
    }

    public void setRh_crc_mn_cr_lmt_m12(BigDecimal rh_crc_mn_cr_lmt_m12) {
        this.rh_crc_mn_cr_lmt_m12 = rh_crc_mn_cr_lmt_m12;
    }

    public BigDecimal getRh_lncd_mn_ud_cr_lmt() {
        return rh_lncd_mn_ud_cr_lmt;
    }

    public void setRh_lncd_mn_ud_cr_lmt(BigDecimal rh_lncd_mn_ud_cr_lmt) {
        this.rh_lncd_mn_ud_cr_lmt = rh_lncd_mn_ud_cr_lmt;
    }

    public BigDecimal getRh_lncd_uc_min_lmt_pro() {
        return rh_lncd_uc_min_lmt_pro;
    }

    public void setRh_lncd_uc_min_lmt_pro(BigDecimal rh_lncd_uc_min_lmt_pro) {
        this.rh_lncd_uc_min_lmt_pro = rh_lncd_uc_min_lmt_pro;
    }

    public BigDecimal getRh_lncd_uc_max_lmt_pro() {
        return rh_lncd_uc_max_lmt_pro;
    }

    public void setRh_lncd_uc_max_lmt_pro(BigDecimal rh_lncd_uc_max_lmt_pro) {
        this.rh_lncd_uc_max_lmt_pro = rh_lncd_uc_max_lmt_pro;
    }

    public Integer getRh_ln_min_age() {
        return rh_ln_min_age;
    }

    public void setRh_ln_min_age(Integer rh_ln_min_age) {
        this.rh_ln_min_age = rh_ln_min_age;
    }

    public String getQueryreason() {
        return queryreason;
    }

    public void setQueryreason(String queryreason) {
        this.queryreason = queryreason;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalstate() {
        return maritalstate;
    }

    public void setMaritalstate(String maritalstate) {
        this.maritalstate = maritalstate;
    }

    public String getEdulevel() {
        return edulevel;
    }

    public void setEdulevel(String edulevel) {
        this.edulevel = edulevel;
    }

    public String getEdudegree() {
        return edudegree;
    }

    public void setEdudegree(String edudegree) {
        this.edudegree = edudegree;
    }

    public String getResidencetype() {
        return residencetype;
    }

    public void setResidencetype(String residencetype) {
        this.residencetype = residencetype;
    }

    public Integer getResidence_province_num() {
        return residence_province_num;
    }

    public void setResidence_province_num(Integer residence_province_num) {
        this.residence_province_num = residence_province_num;
    }

    public Integer getResidence_type_num() {
        return residence_type_num;
    }

    public void setResidence_type_num(Integer residence_type_num) {
        this.residence_type_num = residence_type_num;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getAccfund_state() {
        return accfund_state;
    }

    public void setAccfund_state(String accfund_state) {
        this.accfund_state = accfund_state;
    }

    public Integer getAccfund_pay() {
        return accfund_pay;
    }

    public void setAccfund_pay(Integer accfund_pay) {
        this.accfund_pay = accfund_pay;
    }

    public BigDecimal getOwnprent() {
        return ownprent;
    }

    public void setOwnprent(BigDecimal ownprent) {
        this.ownprent = ownprent;
    }

    public BigDecimal getComprent() {
        return comprent;
    }

    public void setComprent(BigDecimal comprent) {
        this.comprent = comprent;
    }

    public Integer getRh_bs_accf_cur_mon() {
        return rh_bs_accf_cur_mon;
    }

    public void setRh_bs_accf_cur_mon(Integer rh_bs_accf_cur_mon) {
        this.rh_bs_accf_cur_mon = rh_bs_accf_cur_mon;
    }

    public Integer getRh_bs_accf_his_mon() {
        return rh_bs_accf_his_mon;
    }

    public void setRh_bs_accf_his_mon(Integer rh_bs_accf_his_mon) {
        this.rh_bs_accf_his_mon = rh_bs_accf_his_mon;
    }

    public Integer getRh_bs_accf_base() {
        return rh_bs_accf_base;
    }

    public void setRh_bs_accf_base(Integer rh_bs_accf_base) {
        this.rh_bs_accf_base = rh_bs_accf_base;
    }

    public Integer getApply_age() {
        return apply_age;
    }

    public void setApply_age(Integer apply_age) {
        this.apply_age = apply_age;
    }

    public Integer getIndustry_num() {
        return industry_num;
    }

    public void setIndustry_num(Integer industry_num) {
        this.industry_num = industry_num;
    }

    public BigDecimal getRh_bs_work_last_sta() {
        return rh_bs_work_last_sta;
    }

    public void setRh_bs_work_last_sta(BigDecimal rh_bs_work_last_sta) {
        this.rh_bs_work_last_sta = rh_bs_work_last_sta;
    }

    public Integer getRh_lncd_sum_nr_sd_lmt() {
        return rh_lncd_sum_nr_sd_lmt;
    }

    public void setRh_lncd_sum_nr_sd_lmt(Integer rh_lncd_sum_nr_sd_lmt) {
        this.rh_lncd_sum_nr_sd_lmt = rh_lncd_sum_nr_sd_lmt;
    }

    public Integer getRh_lncd_nr_min_ud_cr_lmt() {
        return rh_lncd_nr_min_ud_cr_lmt;
    }

    public void setRh_lncd_nr_min_ud_cr_lmt(Integer rh_lncd_nr_min_ud_cr_lmt) {
        this.rh_lncd_nr_min_ud_cr_lmt = rh_lncd_nr_min_ud_cr_lmt;
    }

    public Integer getRh_lncd_nr_min_ud_cr_lmt_m12() {
        return rh_lncd_nr_min_ud_cr_lmt_m12;
    }

    public void setRh_lncd_nr_min_ud_cr_lmt_m12(Integer rh_lncd_nr_min_ud_cr_lmt_m12) {
        this.rh_lncd_nr_min_ud_cr_lmt_m12 = rh_lncd_nr_min_ud_cr_lmt_m12;
    }

    public BigDecimal getRh_lncd_nr_avg_ud_sd_lmt_pr() {
        return rh_lncd_nr_avg_ud_sd_lmt_pr;
    }

    public void setRh_lncd_nr_avg_ud_sd_lmt_pr(BigDecimal rh_lncd_nr_avg_ud_sd_lmt_pr) {
        this.rh_lncd_nr_avg_ud_sd_lmt_pr = rh_lncd_nr_avg_ud_sd_lmt_pr;
    }

    public BigDecimal getRh_lncd_avg_m6avg_ud_amt() {
        return rh_lncd_avg_m6avg_ud_amt;
    }

    public void setRh_lncd_avg_m6avg_ud_amt(BigDecimal rh_lncd_avg_m6avg_ud_amt) {
        this.rh_lncd_avg_m6avg_ud_amt = rh_lncd_avg_m6avg_ud_amt;
    }

    public Integer getRh_lncd_max_m6avg_ud_amt() {
        return rh_lncd_max_m6avg_ud_amt;
    }

    public void setRh_lncd_max_m6avg_ud_amt(Integer rh_lncd_max_m6avg_ud_amt) {
        this.rh_lncd_max_m6avg_ud_amt = rh_lncd_max_m6avg_ud_amt;
    }

    public BigDecimal getRh_lncd_nr_avg_cr_lmt_m6() {
        return rh_lncd_nr_avg_cr_lmt_m6;
    }

    public void setRh_lncd_nr_avg_cr_lmt_m6(BigDecimal rh_lncd_nr_avg_cr_lmt_m6) {
        this.rh_lncd_nr_avg_cr_lmt_m6 = rh_lncd_nr_avg_cr_lmt_m6;
    }

    public BigDecimal getRh_lncd_mn_cr_lmt_m12() {
        return rh_lncd_mn_cr_lmt_m12;
    }

    public void setRh_lncd_mn_cr_lmt_m12(BigDecimal rh_lncd_mn_cr_lmt_m12) {
        this.rh_lncd_mn_cr_lmt_m12 = rh_lncd_mn_cr_lmt_m12;
    }

    public Integer getRh_crc_uc_num_m12() {
        return rh_crc_uc_num_m12;
    }

    public void setRh_crc_uc_num_m12(Integer rh_crc_uc_num_m12) {
        this.rh_crc_uc_num_m12 = rh_crc_uc_num_m12;
    }

    public BigDecimal getRh_stlncd_nr_avg_ud_cr_lmt_pr() {
        return rh_stlncd_nr_avg_ud_cr_lmt_pr;
    }

    public void setRh_stlncd_nr_avg_ud_cr_lmt_pr(BigDecimal rh_stlncd_nr_avg_ud_cr_lmt_pr) {
        this.rh_stlncd_nr_avg_ud_cr_lmt_pr = rh_stlncd_nr_avg_ud_cr_lmt_pr;
    }

    public BigDecimal getRh_stlncd_nr_avg_ud_sd_lmt_pr() {
        return rh_stlncd_nr_avg_ud_sd_lmt_pr;
    }

    public void setRh_stlncd_nr_avg_ud_sd_lmt_pr(BigDecimal rh_stlncd_nr_avg_ud_sd_lmt_pr) {
        this.rh_stlncd_nr_avg_ud_sd_lmt_pr = rh_stlncd_nr_avg_ud_sd_lmt_pr;
    }

    public BigDecimal getRh_stlncd_avg_max_ud_amt() {
        return rh_stlncd_avg_max_ud_amt;
    }

    public void setRh_stlncd_avg_max_ud_amt(BigDecimal rh_stlncd_avg_max_ud_amt) {
        this.rh_stlncd_avg_max_ud_amt = rh_stlncd_avg_max_ud_amt;
    }

    public Integer getRh_crc_min_age() {
        return rh_crc_min_age;
    }

    public void setRh_crc_min_age(Integer rh_crc_min_age) {
        this.rh_crc_min_age = rh_crc_min_age;
    }

    public BigDecimal getRh_crc_avg_max_ud_amt() {
        return rh_crc_avg_max_ud_amt;
    }

    public void setRh_crc_avg_max_ud_amt(BigDecimal rh_crc_avg_max_ud_amt) {
        this.rh_crc_avg_max_ud_amt = rh_crc_avg_max_ud_amt;
    }

    public Integer getRh_crc_sum_max_ud_amt() {
        return rh_crc_sum_max_ud_amt;
    }

    public void setRh_crc_sum_max_ud_amt(Integer rh_crc_sum_max_ud_amt) {
        this.rh_crc_sum_max_ud_amt = rh_crc_sum_max_ud_amt;
    }

    public Integer getRh_crc_max_sd_lmt_m6() {
        return rh_crc_max_sd_lmt_m6;
    }

    public void setRh_crc_max_sd_lmt_m6(Integer rh_crc_max_sd_lmt_m6) {
        this.rh_crc_max_sd_lmt_m6 = rh_crc_max_sd_lmt_m6;
    }

    public Integer getRh_crc_sum_nr_cr_lmt_m12() {
        return rh_crc_sum_nr_cr_lmt_m12;
    }

    public void setRh_crc_sum_nr_cr_lmt_m12(Integer rh_crc_sum_nr_cr_lmt_m12) {
        this.rh_crc_sum_nr_cr_lmt_m12 = rh_crc_sum_nr_cr_lmt_m12;
    }

    public Integer getRh_ln_nr_num() {
        return rh_ln_nr_num;
    }

    public void setRh_ln_nr_num(Integer rh_ln_nr_num) {
        this.rh_ln_nr_num = rh_ln_nr_num;
    }

    public Integer getRh_ln_clear_num() {
        return rh_ln_clear_num;
    }

    public void setRh_ln_clear_num(Integer rh_ln_clear_num) {
        this.rh_ln_clear_num = rh_ln_clear_num;
    }

    public Integer getRh_carln_num() {
        return rh_carln_num;
    }

    public void setRh_carln_num(Integer rh_carln_num) {
        this.rh_carln_num = rh_carln_num;
    }

    public Integer getRh_ln_type_num() {
        return rh_ln_type_num;
    }

    public void setRh_ln_type_num(Integer rh_ln_type_num) {
        this.rh_ln_type_num = rh_ln_type_num;
    }

    public BigDecimal getRh_ln_min_bal_pr_m6() {
        return rh_ln_min_bal_pr_m6;
    }

    public void setRh_ln_min_bal_pr_m6(BigDecimal rh_ln_min_bal_pr_m6) {
        this.rh_ln_min_bal_pr_m6 = rh_ln_min_bal_pr_m6;
    }

    public Integer getRh_ln_avg_amt_m12() {
        return rh_ln_avg_amt_m12;
    }

    public void setRh_ln_avg_amt_m12(Integer rh_ln_avg_amt_m12) {
        this.rh_ln_avg_amt_m12 = rh_ln_avg_amt_m12;
    }

    public Integer getRh_5state_nr_num() {
        return rh_5state_nr_num;
    }

    public void setRh_5state_nr_num(Integer rh_5state_nr_num) {
        this.rh_5state_nr_num = rh_5state_nr_num;
    }

    public Integer getRh_ln_nonpmf_ct_2y_rp() {
        return rh_ln_nonpmf_ct_2y_rp;
    }

    public void setRh_ln_nonpmf_ct_2y_rp(Integer rh_ln_nonpmf_ct_2y_rp) {
        this.rh_ln_nonpmf_ct_2y_rp = rh_ln_nonpmf_ct_2y_rp;
    }

    public Integer getRh_opln_num() {
        return rh_opln_num;
    }

    public void setRh_opln_num(Integer rh_opln_num) {
        this.rh_opln_num = rh_opln_num;
    }

    public Integer getRh_opln_clear_num() {
        return rh_opln_clear_num;
    }

    public void setRh_opln_clear_num(Integer rh_opln_clear_num) {
        this.rh_opln_clear_num = rh_opln_clear_num;
    }

    public BigDecimal getRh_opln_min_bal_pr() {
        return rh_opln_min_bal_pr;
    }

    public void setRh_opln_min_bal_pr(BigDecimal rh_opln_min_bal_pr) {
        this.rh_opln_min_bal_pr = rh_opln_min_bal_pr;
    }

    public Integer getRh_ln_bal_num() {
        return rh_ln_bal_num;
    }

    public void setRh_ln_bal_num(Integer rh_ln_bal_num) {
        this.rh_ln_bal_num = rh_ln_bal_num;
    }

    public Integer getRh_ln_m12_ovd_sum_num() {
        return rh_ln_m12_ovd_sum_num;
    }

    public void setRh_ln_m12_ovd_sum_num(Integer rh_ln_m12_ovd_sum_num) {
        this.rh_ln_m12_ovd_sum_num = rh_ln_m12_ovd_sum_num;
    }

    public Integer getRh_ln_avg_pay_amt() {
        return rh_ln_avg_pay_amt;
    }

    public void setRh_ln_avg_pay_amt(Integer rh_ln_avg_pay_amt) {
        this.rh_ln_avg_pay_amt = rh_ln_avg_pay_amt;
    }

    public Integer getRh_ln_old_age() {
        return rh_ln_old_age;
    }

    public void setRh_ln_old_age(Integer rh_ln_old_age) {
        this.rh_ln_old_age = rh_ln_old_age;
    }

    public Integer getRh_ln_max_old_cd() {
        return rh_ln_max_old_cd;
    }

    public void setRh_ln_max_old_cd(Integer rh_ln_max_old_cd) {
        this.rh_ln_max_old_cd = rh_ln_max_old_cd;
    }


    public Integer getRh_perbushslnct_rp() {
        return rh_perbushslnct_rp;
    }

    public void setRh_perbushslnct_rp(Integer rh_perbushslnct_rp) {
        this.rh_perbushslnct_rp = rh_perbushslnct_rp;
    }

    public Integer getRh_perhslnct_rp() {
        return rh_perhslnct_rp;
    }

    public void setRh_perhslnct_rp(Integer rh_perhslnct_rp) {
        this.rh_perhslnct_rp = rh_perhslnct_rp;
    }

    public Integer getRh_otlnct_rp() {
        return rh_otlnct_rp;
    }

    public void setRh_otlnct_rp(Integer rh_otlnct_rp) {
        this.rh_otlnct_rp = rh_otlnct_rp;
    }

    public Integer getRh_ln_max_age() {
        return rh_ln_max_age;
    }

    public void setRh_ln_max_age(Integer rh_ln_max_age) {
        this.rh_ln_max_age = rh_ln_max_age;
    }

    public Integer getRh_lncd_max_age() {
        return rh_lncd_max_age;
    }

    public void setRh_lncd_max_age(Integer rh_lncd_max_age) {
        this.rh_lncd_max_age = rh_lncd_max_age;
    }

    public String getRh_ln_st_flag() {
        return rh_ln_st_flag;
    }

    public void setRh_ln_st_flag(String rh_ln_st_flag) {
        this.rh_ln_st_flag = rh_ln_st_flag;
    }

    public Integer getRh_ln_st_adva() {
        return rh_ln_st_adva;
    }

    public void setRh_ln_st_adva(Integer rh_ln_st_adva) {
        this.rh_ln_st_adva = rh_ln_st_adva;
    }

    public Integer getRh_carln_curodamt() {
        return rh_carln_curodamt;
    }

    public void setRh_carln_curodamt(Integer rh_carln_curodamt) {
        this.rh_carln_curodamt = rh_carln_curodamt;
    }

    public Integer getRh_hsln_nr_num() {
        return rh_hsln_nr_num;
    }

    public void setRh_hsln_nr_num(Integer rh_hsln_nr_num) {
        this.rh_hsln_nr_num = rh_hsln_nr_num;
    }

    public Integer getRh_longln_sum_pay_amt() {
        return rh_longln_sum_pay_amt;
    }

    public void setRh_longln_sum_pay_amt(Integer rh_longln_sum_pay_amt) {
        this.rh_longln_sum_pay_amt = rh_longln_sum_pay_amt;
    }

    public Integer getRh_ln_max_amt() {
        return rh_ln_max_amt;
    }

    public void setRh_ln_max_amt(Integer rh_ln_max_amt) {
        this.rh_ln_max_amt = rh_ln_max_amt;
    }

    public Integer getRh_ln_avg_amt() {
        return rh_ln_avg_amt;
    }

    public void setRh_ln_avg_amt(Integer rh_ln_avg_amt) {
        this.rh_ln_avg_amt = rh_ln_avg_amt;
    }

    public Integer getRh_ln_max_bal() {
        return rh_ln_max_bal;
    }

    public void setRh_ln_max_bal(Integer rh_ln_max_bal) {
        this.rh_ln_max_bal = rh_ln_max_bal;
    }

    public Integer getRh_ln_avg_bal() {
        return rh_ln_avg_bal;
    }

    public void setRh_ln_avg_bal(Integer rh_ln_avg_bal) {
        this.rh_ln_avg_bal = rh_ln_avg_bal;
    }

    public BigDecimal getRh_ln_min_bal_pr() {
        return rh_ln_min_bal_pr;
    }

    public void setRh_ln_min_bal_pr(BigDecimal rh_ln_min_bal_pr) {
        this.rh_ln_min_bal_pr = rh_ln_min_bal_pr;
    }

    public BigDecimal getRh_ln_max_bal_pr() {
        return rh_ln_max_bal_pr;
    }

    public void setRh_ln_max_bal_pr(BigDecimal rh_ln_max_bal_pr) {
        this.rh_ln_max_bal_pr = rh_ln_max_bal_pr;
    }

    public Integer getRh_ln_avg_bal_m6() {
        return rh_ln_avg_bal_m6;
    }

    public void setRh_ln_avg_bal_m6(Integer rh_ln_avg_bal_m6) {
        this.rh_ln_avg_bal_m6 = rh_ln_avg_bal_m6;
    }

    public Integer getRh_ln_sum_amt_m12() {
        return rh_ln_sum_amt_m12;
    }

    public void setRh_ln_sum_amt_m12(Integer rh_ln_sum_amt_m12) {
        this.rh_ln_sum_amt_m12 = rh_ln_sum_amt_m12;
    }

    public Integer getRh_ln_max_amt_m12() {
        return rh_ln_max_amt_m12;
    }

    public void setRh_ln_max_amt_m12(Integer rh_ln_max_amt_m12) {
        this.rh_ln_max_amt_m12 = rh_ln_max_amt_m12;
    }

    public Integer getRh_ln_sum_bal_m12() {
        return rh_ln_sum_bal_m12;
    }

    public void setRh_ln_sum_bal_m12(Integer rh_ln_sum_bal_m12) {
        this.rh_ln_sum_bal_m12 = rh_ln_sum_bal_m12;
    }

    public Integer getRh_ln_max_bal_m12() {
        return rh_ln_max_bal_m12;
    }

    public void setRh_ln_max_bal_m12(Integer rh_ln_max_bal_m12) {
        this.rh_ln_max_bal_m12 = rh_ln_max_bal_m12;
    }

    public Integer getRh_carln_avg_amt() {
        return rh_carln_avg_amt;
    }

    public void setRh_carln_avg_amt(Integer rh_carln_avg_amt) {
        this.rh_carln_avg_amt = rh_carln_avg_amt;
    }

    public BigDecimal getRh_carln_min_bal_pr() {
        return rh_carln_min_bal_pr;
    }

    public void setRh_carln_min_bal_pr(BigDecimal rh_carln_min_bal_pr) {
        this.rh_carln_min_bal_pr = rh_carln_min_bal_pr;
    }

    public Integer getRh_hsln_sum_amt() {
        return rh_hsln_sum_amt;
    }

    public void setRh_hsln_sum_amt(Integer rh_hsln_sum_amt) {
        this.rh_hsln_sum_amt = rh_hsln_sum_amt;
    }

    public Integer getRh_hsln_max_amt() {
        return rh_hsln_max_amt;
    }

    public void setRh_hsln_max_amt(Integer rh_hsln_max_amt) {
        this.rh_hsln_max_amt = rh_hsln_max_amt;
    }

    public Integer getRh_hsln_avg_amt() {
        return rh_hsln_avg_amt;
    }

    public void setRh_hsln_avg_amt(Integer rh_hsln_avg_amt) {
        this.rh_hsln_avg_amt = rh_hsln_avg_amt;
    }

    public Integer getRh_hsln_sum_bal() {
        return rh_hsln_sum_bal;
    }

    public void setRh_hsln_sum_bal(Integer rh_hsln_sum_bal) {
        this.rh_hsln_sum_bal = rh_hsln_sum_bal;
    }

    public Integer getRh_lncd_ovd_num() {
        return rh_lncd_ovd_num;
    }

    public void setRh_lncd_ovd_num(Integer rh_lncd_ovd_num) {
        this.rh_lncd_ovd_num = rh_lncd_ovd_num;
    }

    public Integer getRh_sum_ovd_num() {
        return rh_sum_ovd_num;
    }

    public void setRh_sum_ovd_num(Integer rh_sum_ovd_num) {
        this.rh_sum_ovd_num = rh_sum_ovd_num;
    }

    public Integer getRh_ln_ovd_mon() {
        return rh_ln_ovd_mon;
    }

    public void setRh_ln_ovd_mon(Integer rh_ln_ovd_mon) {
        this.rh_ln_ovd_mon = rh_ln_ovd_mon;
    }

    public Integer getRh_ln_ovd_hgst_amt() {
        return rh_ln_ovd_hgst_amt;
    }

    public void setRh_ln_ovd_hgst_amt(Integer rh_ln_ovd_hgst_amt) {
        this.rh_ln_ovd_hgst_amt = rh_ln_ovd_hgst_amt;
    }

    public Integer getRh_lncd_ovd_mon() {
        return rh_lncd_ovd_mon;
    }

    public void setRh_lncd_ovd_mon(Integer rh_lncd_ovd_mon) {
        this.rh_lncd_ovd_mon = rh_lncd_ovd_mon;
    }

    public Integer getRh_lncd_ovd_hgst_amt() {
        return rh_lncd_ovd_hgst_amt;
    }

    public void setRh_lncd_ovd_hgst_amt(Integer rh_lncd_ovd_hgst_amt) {
        this.rh_lncd_ovd_hgst_amt = rh_lncd_ovd_hgst_amt;
    }

    public Integer getRh_lncd_ovd_dur() {
        return rh_lncd_ovd_dur;
    }

    public void setRh_lncd_ovd_dur(Integer rh_lncd_ovd_dur) {
        this.rh_lncd_ovd_dur = rh_lncd_ovd_dur;
    }

    public Integer getRh_sum_ovd_mon() {
        return rh_sum_ovd_mon;
    }

    public void setRh_sum_ovd_mon(Integer rh_sum_ovd_mon) {
        this.rh_sum_ovd_mon = rh_sum_ovd_mon;
    }

    public Integer getRh_max_ovd_mon() {
        return rh_max_ovd_mon;
    }

    public void setRh_max_ovd_mon(Integer rh_max_ovd_mon) {
        this.rh_max_ovd_mon = rh_max_ovd_mon;
    }

    public Integer getRh_avg_ovd_mon() {
        return rh_avg_ovd_mon;
    }

    public void setRh_avg_ovd_mon(Integer rh_avg_ovd_mon) {
        this.rh_avg_ovd_mon = rh_avg_ovd_mon;
    }

    public Integer getRh_sum_ovd_hgst_amt() {
        return rh_sum_ovd_hgst_amt;
    }

    public void setRh_sum_ovd_hgst_amt(Integer rh_sum_ovd_hgst_amt) {
        this.rh_sum_ovd_hgst_amt = rh_sum_ovd_hgst_amt;
    }

    public Integer getRh_max_ovd_hgst_amt() {
        return rh_max_ovd_hgst_amt;
    }

    public void setRh_max_ovd_hgst_amt(Integer rh_max_ovd_hgst_amt) {
        this.rh_max_ovd_hgst_amt = rh_max_ovd_hgst_amt;
    }

    public Integer getRh_avg_ovd_hgst_amt() {
        return rh_avg_ovd_hgst_amt;
    }

    public void setRh_avg_ovd_hgst_amt(Integer rh_avg_ovd_hgst_amt) {
        this.rh_avg_ovd_hgst_amt = rh_avg_ovd_hgst_amt;
    }

    public Integer getRh_mn_ovd_hgst_amt() {
        return rh_mn_ovd_hgst_amt;
    }

    public void setRh_mn_ovd_hgst_amt(Integer rh_mn_ovd_hgst_amt) {
        this.rh_mn_ovd_hgst_amt = rh_mn_ovd_hgst_amt;
    }

    public Integer getRh_sum_ovd_dur() {
        return rh_sum_ovd_dur;
    }

    public void setRh_sum_ovd_dur(Integer rh_sum_ovd_dur) {
        this.rh_sum_ovd_dur = rh_sum_ovd_dur;
    }

    public Integer getRh_max_ovd_dur() {
        return rh_max_ovd_dur;
    }

    public void setRh_max_ovd_dur(Integer rh_max_ovd_dur) {
        this.rh_max_ovd_dur = rh_max_ovd_dur;
    }

    public Integer getRh_uc_ln_bal() {
        return rh_uc_ln_bal;
    }

    public void setRh_uc_ln_bal(Integer rh_uc_ln_bal) {
        this.rh_uc_ln_bal = rh_uc_ln_bal;
    }

    public Integer getRh_uc_ln_amt() {
        return rh_uc_ln_amt;
    }

    public void setRh_uc_ln_amt(Integer rh_uc_ln_amt) {
        this.rh_uc_ln_amt = rh_uc_ln_amt;
    }

    public BigDecimal getRh_uc_ln_m6avg_amt() {
        return rh_uc_ln_m6avg_amt;
    }

    public void setRh_uc_ln_m6avg_amt(BigDecimal rh_uc_ln_m6avg_amt) {
        this.rh_uc_ln_m6avg_amt = rh_uc_ln_m6avg_amt;
    }

    public BigDecimal getRh_lncd_uc_ud_pro() {
        return rh_lncd_uc_ud_pro;
    }

    public void setRh_lncd_uc_ud_pro(BigDecimal rh_lncd_uc_ud_pro) {
        this.rh_lncd_uc_ud_pro = rh_lncd_uc_ud_pro;
    }

    public Integer getRh_cr_sum_bal() {
        return rh_cr_sum_bal;
    }

    public void setRh_cr_sum_bal(Integer rh_cr_sum_bal) {
        this.rh_cr_sum_bal = rh_cr_sum_bal;
    }

    public BigDecimal getRh_ln_bal_pral() {
        return rh_ln_bal_pral;
    }

    public void setRh_ln_bal_pral(BigDecimal rh_ln_bal_pral) {
        this.rh_ln_bal_pral = rh_ln_bal_pral;
    }

    public BigDecimal getRh_cd_bal_pral() {
        return rh_cd_bal_pral;
    }

    public void setRh_cd_bal_pral(BigDecimal rh_cd_bal_pral) {
        this.rh_cd_bal_pral = rh_cd_bal_pral;
    }

    public BigDecimal getRh_ln_amt_pral() {
        return rh_ln_amt_pral;
    }

    public void setRh_ln_amt_pral(BigDecimal rh_ln_amt_pral) {
        this.rh_ln_amt_pral = rh_ln_amt_pral;
    }

    public BigDecimal getRh_cd_amt_pral() {
        return rh_cd_amt_pral;
    }

    public void setRh_cd_amt_pral(BigDecimal rh_cd_amt_pral) {
        this.rh_cd_amt_pral = rh_cd_amt_pral;
    }

    public Integer getRh_cr_num() {
        return rh_cr_num;
    }

    public void setRh_cr_num(Integer rh_cr_num) {
        this.rh_cr_num = rh_cr_num;
    }

    public BigDecimal getRh_lncd_cr_uc_num_pro() {
        return rh_lncd_cr_uc_num_pro;
    }

    public void setRh_lncd_cr_uc_num_pro(BigDecimal rh_lncd_cr_uc_num_pro) {
        this.rh_lncd_cr_uc_num_pro = rh_lncd_cr_uc_num_pro;
    }

    public Integer getRh_cr_ovd_max_amt() {
        return rh_cr_ovd_max_amt;
    }

    public void setRh_cr_ovd_max_amt(Integer rh_cr_ovd_max_amt) {
        this.rh_cr_ovd_max_amt = rh_cr_ovd_max_amt;
    }

    public Integer getRh_cr_cate_num() {
        return rh_cr_cate_num;
    }

    public void setRh_cr_cate_num(Integer rh_cr_cate_num) {
        this.rh_cr_cate_num = rh_cr_cate_num;
    }

    public BigDecimal getRh_ln_avg_bal_amt() {
        return rh_ln_avg_bal_amt;
    }

    public void setRh_ln_avg_bal_amt(BigDecimal rh_ln_avg_bal_amt) {
        this.rh_ln_avg_bal_amt = rh_ln_avg_bal_amt;
    }

    public Integer getRh_m24_cr_ovd_num() {
        return rh_m24_cr_ovd_num;
    }

    public void setRh_m24_cr_ovd_num(Integer rh_m24_cr_ovd_num) {
        this.rh_m24_cr_ovd_num = rh_m24_cr_ovd_num;
    }

    public Integer getRh_ln_y2_qy_num() {
        return rh_ln_y2_qy_num;
    }

    public void setRh_ln_y2_qy_num(Integer rh_ln_y2_qy_num) {
        this.rh_ln_y2_qy_num = rh_ln_y2_qy_num;
    }

    public Integer getRh_crc_y2_qy_num() {
        return rh_crc_y2_qy_num;
    }

    public void setRh_crc_y2_qy_num(Integer rh_crc_y2_qy_num) {
        this.rh_crc_y2_qy_num = rh_crc_y2_qy_num;
    }

    public Integer getRh_crc_qy_lst_inte() {
        return rh_crc_qy_lst_inte;
    }

    public void setRh_crc_qy_lst_inte(Integer rh_crc_qy_lst_inte) {
        this.rh_crc_qy_lst_inte = rh_crc_qy_lst_inte;
    }

    public Integer getRh_guar_y2_qy_num() {
        return rh_guar_y2_qy_num;
    }

    public void setRh_guar_y2_qy_num(Integer rh_guar_y2_qy_num) {
        this.rh_guar_y2_qy_num = rh_guar_y2_qy_num;
    }

    public Integer getRh_m3_qy_num() {
        return rh_m3_qy_num;
    }

    public void setRh_m3_qy_num(Integer rh_m3_qy_num) {
        this.rh_m3_qy_num = rh_m3_qy_num;
    }

    public Integer getRh_cr_y2_qy_num() {
        return rh_cr_y2_qy_num;
    }

    public void setRh_cr_y2_qy_num(Integer rh_cr_y2_qy_num) {
        this.rh_cr_y2_qy_num = rh_cr_y2_qy_num;
    }

    public Integer getRh_pstln_y2_qy_num() {
        return rh_pstln_y2_qy_num;
    }

    public void setRh_pstln_y2_qy_num(Integer rh_pstln_y2_qy_num) {
        this.rh_pstln_y2_qy_num = rh_pstln_y2_qy_num;
    }

    public Integer getRh_merch_y2_qy_num() {
        return rh_merch_y2_qy_num;
    }

    public void setRh_merch_y2_qy_num(Integer rh_merch_y2_qy_num) {
        this.rh_merch_y2_qy_num = rh_merch_y2_qy_num;
    }

    public Integer getRh_self_m1_qy_num() {
        return rh_self_m1_qy_num;
    }

    public void setRh_self_m1_qy_num(Integer rh_self_m1_qy_num) {
        this.rh_self_m1_qy_num = rh_self_m1_qy_num;
    }

    public Integer getRh_cr_m12_qy_org_num() {
        return rh_cr_m12_qy_org_num;
    }

    public void setRh_cr_m12_qy_org_num(Integer rh_cr_m12_qy_org_num) {
        this.rh_cr_m12_qy_org_num = rh_cr_m12_qy_org_num;
    }

    public BigDecimal getRh_ln_cr_y2_qy_pro() {
        return rh_ln_cr_y2_qy_pro;
    }

    public void setRh_ln_cr_y2_qy_pro(BigDecimal rh_ln_cr_y2_qy_pro) {
        this.rh_ln_cr_y2_qy_pro = rh_ln_cr_y2_qy_pro;
    }

    public BigDecimal getRh_crc_cr_y2_qy_pro() {
        return rh_crc_cr_y2_qy_pro;
    }

    public void setRh_crc_cr_y2_qy_pro(BigDecimal rh_crc_cr_y2_qy_pro) {
        this.rh_crc_cr_y2_qy_pro = rh_crc_cr_y2_qy_pro;
    }

    public Integer getRh_crc_y2_qyf_num() {
        return rh_crc_y2_qyf_num;
    }

    public void setRh_crc_y2_qyf_num(Integer rh_crc_y2_qyf_num) {
        this.rh_crc_y2_qyf_num = rh_crc_y2_qyf_num;
    }

    public Integer getRh_crc_m12_qyf_num() {
        return rh_crc_m12_qyf_num;
    }

    public void setRh_crc_m12_qyf_num(Integer rh_crc_m12_qyf_num) {
        this.rh_crc_m12_qyf_num = rh_crc_m12_qyf_num;
    }

    public BigDecimal getRh_cr_y2_qyf_pro() {
        return rh_cr_y2_qyf_pro;
    }

    public void setRh_cr_y2_qyf_pro(BigDecimal rh_cr_y2_qyf_pro) {
        this.rh_cr_y2_qyf_pro = rh_cr_y2_qyf_pro;
    }

    public BigDecimal getRh_ln_y2_qyf_pro() {
        return rh_ln_y2_qyf_pro;
    }

    public void setRh_ln_y2_qyf_pro(BigDecimal rh_ln_y2_qyf_pro) {
        this.rh_ln_y2_qyf_pro = rh_ln_y2_qyf_pro;
    }

    public BigDecimal getRh_crc_y2_qyf_pro() {
        return rh_crc_y2_qyf_pro;
    }

    public void setRh_crc_y2_qyf_pro(BigDecimal rh_crc_y2_qyf_pro) {
        this.rh_crc_y2_qyf_pro = rh_crc_y2_qyf_pro;
    }

    public BigDecimal getRh_crc_cr_y2_qyf_pro() {
        return rh_crc_cr_y2_qyf_pro;
    }

    public void setRh_crc_cr_y2_qyf_pro(BigDecimal rh_crc_cr_y2_qyf_pro) {
        this.rh_crc_cr_y2_qyf_pro = rh_crc_cr_y2_qyf_pro;
    }

    public BigDecimal getRh_crc_cr_m6_qyf_pro() {
        return rh_crc_cr_m6_qyf_pro;
    }

    public void setRh_crc_cr_m6_qyf_pro(BigDecimal rh_crc_cr_m6_qyf_pro) {
        this.rh_crc_cr_m6_qyf_pro = rh_crc_cr_m6_qyf_pro;
    }

    public BigDecimal getRh_crc_cr_m12_qyf_pro() {
        return rh_crc_cr_m12_qyf_pro;
    }

    public void setRh_crc_cr_m12_qyf_pro(BigDecimal rh_crc_cr_m12_qyf_pro) {
        this.rh_crc_cr_m12_qyf_pro = rh_crc_cr_m12_qyf_pro;
    }

    public BigDecimal getRh_ln_cr_y2_qyf_pro() {
        return rh_ln_cr_y2_qyf_pro;
    }

    public void setRh_ln_cr_y2_qyf_pro(BigDecimal rh_ln_cr_y2_qyf_pro) {
        this.rh_ln_cr_y2_qyf_pro = rh_ln_cr_y2_qyf_pro;
    }

    public BigDecimal getRh_ln_cr_m12_qyf_pro() {
        return rh_ln_cr_m12_qyf_pro;
    }

    public void setRh_ln_cr_m12_qyf_pro(BigDecimal rh_ln_cr_m12_qyf_pro) {
        this.rh_ln_cr_m12_qyf_pro = rh_ln_cr_m12_qyf_pro;
    }

    public Integer getRh_ln_y2_qy_org_num() {
        return rh_ln_y2_qy_org_num;
    }

    public void setRh_ln_y2_qy_org_num(Integer rh_ln_y2_qy_org_num) {
        this.rh_ln_y2_qy_org_num = rh_ln_y2_qy_org_num;
    }

    public Integer getRh_crc_y2_qy_org_num() {
        return rh_crc_y2_qy_org_num;
    }

    public void setRh_crc_y2_qy_org_num(Integer rh_crc_y2_qy_org_num) {
        this.rh_crc_y2_qy_org_num = rh_crc_y2_qy_org_num;
    }

    public Integer getRh_guar_y2_qy_org_num() {
        return rh_guar_y2_qy_org_num;
    }

    public void setRh_guar_y2_qy_org_num(Integer rh_guar_y2_qy_org_num) {
        this.rh_guar_y2_qy_org_num = rh_guar_y2_qy_org_num;
    }

    public Integer getRh_cr_y2_qy_org_num() {
        return rh_cr_y2_qy_org_num;
    }

    public void setRh_cr_y2_qy_org_num(Integer rh_cr_y2_qy_org_num) {
        this.rh_cr_y2_qy_org_num = rh_cr_y2_qy_org_num;
    }

    public BigDecimal getRh_ln_cr_y2_qy_org_pro() {
        return rh_ln_cr_y2_qy_org_pro;
    }

    public void setRh_ln_cr_y2_qy_org_pro(BigDecimal rh_ln_cr_y2_qy_org_pro) {
        this.rh_ln_cr_y2_qy_org_pro = rh_ln_cr_y2_qy_org_pro;
    }

    public BigDecimal getRh_crc_cr_y2_qy_org_pro() {
        return rh_crc_cr_y2_qy_org_pro;
    }

    public void setRh_crc_cr_y2_qy_org_pro(BigDecimal rh_crc_cr_y2_qy_org_pro) {
        this.rh_crc_cr_y2_qy_org_pro = rh_crc_cr_y2_qy_org_pro;
    }

    public BigDecimal getRh_ln_cr_m12_qy_org_pro() {
        return rh_ln_cr_m12_qy_org_pro;
    }

    public void setRh_ln_cr_m12_qy_org_pro(BigDecimal rh_ln_cr_m12_qy_org_pro) {
        this.rh_ln_cr_m12_qy_org_pro = rh_ln_cr_m12_qy_org_pro;
    }

    public Integer getRh_cr_y2_qyf_org_num() {
        return rh_cr_y2_qyf_org_num;
    }

    public void setRh_cr_y2_qyf_org_num(Integer rh_cr_y2_qyf_org_num) {
        this.rh_cr_y2_qyf_org_num = rh_cr_y2_qyf_org_num;
    }

    public Integer getRh_ln_y2_qyf_org_num() {
        return rh_ln_y2_qyf_org_num;
    }

    public void setRh_ln_y2_qyf_org_num(Integer rh_ln_y2_qyf_org_num) {
        this.rh_ln_y2_qyf_org_num = rh_ln_y2_qyf_org_num;
    }

    public Integer getRh_crc_y2_qyf_org_num() {
        return rh_crc_y2_qyf_org_num;
    }

    public void setRh_crc_y2_qyf_org_num(Integer rh_crc_y2_qyf_org_num) {
        this.rh_crc_y2_qyf_org_num = rh_crc_y2_qyf_org_num;
    }

    public BigDecimal getRh_cr_y2_qyf_org_pro() {
        return rh_cr_y2_qyf_org_pro;
    }

    public void setRh_cr_y2_qyf_org_pro(BigDecimal rh_cr_y2_qyf_org_pro) {
        this.rh_cr_y2_qyf_org_pro = rh_cr_y2_qyf_org_pro;
    }

    public BigDecimal getRh_ln_y2_qyf_org_pro() {
        return rh_ln_y2_qyf_org_pro;
    }

    public void setRh_ln_y2_qyf_org_pro(BigDecimal rh_ln_y2_qyf_org_pro) {
        this.rh_ln_y2_qyf_org_pro = rh_ln_y2_qyf_org_pro;
    }

    public BigDecimal getRh_crc_y2_qyf_org_pro() {
        return rh_crc_y2_qyf_org_pro;
    }

    public void setRh_crc_y2_qyf_org_pro(BigDecimal rh_crc_y2_qyf_org_pro) {
        this.rh_crc_y2_qyf_org_pro = rh_crc_y2_qyf_org_pro;
    }

    public BigDecimal getRh_crc_cr_y2_qyf_org_pro() {
        return rh_crc_cr_y2_qyf_org_pro;
    }

    public void setRh_crc_cr_y2_qyf_org_pro(BigDecimal rh_crc_cr_y2_qyf_org_pro) {
        this.rh_crc_cr_y2_qyf_org_pro = rh_crc_cr_y2_qyf_org_pro;
    }

    public BigDecimal getRh_ln_cr_y2_qyf_org_pro() {
        return rh_ln_cr_y2_qyf_org_pro;
    }

    public void setRh_ln_cr_y2_qyf_org_pro(BigDecimal rh_ln_cr_y2_qyf_org_pro) {
        this.rh_ln_cr_y2_qyf_org_pro = rh_ln_cr_y2_qyf_org_pro;
    }

    public Integer getRh_m12_crc_qy_num() {
        return rh_m12_crc_qy_num;
    }

    public void setRh_m12_crc_qy_num(Integer rh_m12_crc_qy_num) {
        this.rh_m12_crc_qy_num = rh_m12_crc_qy_num;
    }

    public Integer getRh_ln_y2_qyf_num() {
        return rh_ln_y2_qyf_num;
    }

    public void setRh_ln_y2_qyf_num(Integer rh_ln_y2_qyf_num) {
        this.rh_ln_y2_qyf_num = rh_ln_y2_qyf_num;
    }

    public Integer getRh_crc_m6_qyf_num() {
        return rh_crc_m6_qyf_num;
    }

    public void setRh_crc_m6_qyf_num(Integer rh_crc_m6_qyf_num) {
        this.rh_crc_m6_qyf_num = rh_crc_m6_qyf_num;
    }

    public Integer getRh_m12_ln_qy_num() {
        return rh_m12_ln_qy_num;
    }

    public void setRh_m12_ln_qy_num(Integer rh_m12_ln_qy_num) {
        this.rh_m12_ln_qy_num = rh_m12_ln_qy_num;
    }

    public Integer getRh_cr_m6_qyf_num() {
        return rh_cr_m6_qyf_num;
    }

    public void setRh_cr_m6_qyf_num(Integer rh_cr_m6_qyf_num) {
        this.rh_cr_m6_qyf_num = rh_cr_m6_qyf_num;
    }

    public BigDecimal getRh_ln_m12_qyf_pro() {
        return rh_ln_m12_qyf_pro;
    }

    public void setRh_ln_m12_qyf_pro(BigDecimal rh_ln_m12_qyf_pro) {
        this.rh_ln_m12_qyf_pro = rh_ln_m12_qyf_pro;
    }

    public Integer getRh_lncd_uc_num_m12() {
        return rh_lncd_uc_num_m12;
    }

    public void setRh_lncd_uc_num_m12(Integer rh_lncd_uc_num_m12) {
        this.rh_lncd_uc_num_m12 = rh_lncd_uc_num_m12;
    }

    public Integer getRh_lncd_sum_cr_lmt_m12() {
        return rh_lncd_sum_cr_lmt_m12;
    }

    public void setRh_lncd_sum_cr_lmt_m12(Integer rh_lncd_sum_cr_lmt_m12) {
        this.rh_lncd_sum_cr_lmt_m12 = rh_lncd_sum_cr_lmt_m12;
    }

    public Integer getRh_ln_m12_qy_org_num() {
        return rh_ln_m12_qy_org_num;
    }

    public void setRh_ln_m12_qy_org_num(Integer rh_ln_m12_qy_org_num) {
        this.rh_ln_m12_qy_org_num = rh_ln_m12_qy_org_num;
    }

    public String getRh_agln_rct_paydt() {
        return rh_agln_rct_paydt;
    }

    public void setRh_agln_rct_paydt(String rh_agln_rct_paydt) {
        this.rh_agln_rct_paydt = rh_agln_rct_paydt;
    }

    public String getRh_cr_op_min_dt() {
        return rh_cr_op_min_dt;
    }

    public void setRh_cr_op_min_dt(String rh_cr_op_min_dt) {
        this.rh_cr_op_min_dt = rh_cr_op_min_dt;
    }

    public Integer getRh_lncd_nr_num_m6() {
        return rh_lncd_nr_num_m6;
    }

    public void setRh_lncd_nr_num_m6(Integer rh_lncd_nr_num_m6) {
        this.rh_lncd_nr_num_m6 = rh_lncd_nr_num_m6;
    }

    public Integer getRh_m6_crc_qy_num() {
        return rh_m6_crc_qy_num;
    }

    public void setRh_m6_crc_qy_num(Integer rh_m6_crc_qy_num) {
        this.rh_m6_crc_qy_num = rh_m6_crc_qy_num;
    }

    public Integer getRh_ln_m6_qyf_num() {
        return rh_ln_m6_qyf_num;
    }

    public void setRh_ln_m6_qyf_num(Integer rh_ln_m6_qyf_num) {
        this.rh_ln_m6_qyf_num = rh_ln_m6_qyf_num;
    }

    public BigDecimal getRh_lncd_op_max_dt_timestamp() {
        return rh_lncd_op_max_dt_timestamp;
    }

    public void setRh_lncd_op_max_dt_timestamp(BigDecimal rh_lncd_op_max_dt_timestamp) {
        this.rh_lncd_op_max_dt_timestamp = rh_lncd_op_max_dt_timestamp;
    }

    public BigDecimal getRh_lncd_op_old_dt_timestamp() {
        return rh_lncd_op_old_dt_timestamp;
    }

    public void setRh_lncd_op_old_dt_timestamp(BigDecimal rh_lncd_op_old_dt_timestamp) {
        this.rh_lncd_op_old_dt_timestamp = rh_lncd_op_old_dt_timestamp;
    }

    public BigDecimal getRh_stlncd_op_max_dt_timestamp() {
        return rh_stlncd_op_max_dt_timestamp;
    }

    public void setRh_stlncd_op_max_dt_timestamp(BigDecimal rh_stlncd_op_max_dt_timestamp) {
        this.rh_stlncd_op_max_dt_timestamp = rh_stlncd_op_max_dt_timestamp;
    }

    public BigDecimal getRh_stlncd_op_old_dt_timestamp() {
        return rh_stlncd_op_old_dt_timestamp;
    }

    public void setRh_stlncd_op_old_dt_timestamp(BigDecimal rh_stlncd_op_old_dt_timestamp) {
        this.rh_stlncd_op_old_dt_timestamp = rh_stlncd_op_old_dt_timestamp;
    }

    public BigDecimal getRh_crc_op_max_dt_timestamp() {
        return rh_crc_op_max_dt_timestamp;
    }

    public void setRh_crc_op_max_dt_timestamp(BigDecimal rh_crc_op_max_dt_timestamp) {
        this.rh_crc_op_max_dt_timestamp = rh_crc_op_max_dt_timestamp;
    }

    public BigDecimal getRh_ln_op_max_dt_timestamp() {
        return rh_ln_op_max_dt_timestamp;
    }

    public void setRh_ln_op_max_dt_timestamp(BigDecimal rh_ln_op_max_dt_timestamp) {
        this.rh_ln_op_max_dt_timestamp = rh_ln_op_max_dt_timestamp;
    }

    public BigDecimal getRh_ln_rct_paydt_timestamp() {
        return rh_ln_rct_paydt_timestamp;
    }

    public void setRh_ln_rct_paydt_timestamp(BigDecimal rh_ln_rct_paydt_timestamp) {
        this.rh_ln_rct_paydt_timestamp = rh_ln_rct_paydt_timestamp;
    }

    public BigDecimal getRh_carln_rct_paydt_timestamp() {
        return rh_carln_rct_paydt_timestamp;
    }

    public void setRh_carln_rct_paydt_timestamp(BigDecimal rh_carln_rct_paydt_timestamp) {
        this.rh_carln_rct_paydt_timestamp = rh_carln_rct_paydt_timestamp;
    }

    public BigDecimal getRh_carln_op_max_dt_timestamp() {
        return rh_carln_op_max_dt_timestamp;
    }

    public void setRh_carln_op_max_dt_timestamp(BigDecimal rh_carln_op_max_dt_timestamp) {
        this.rh_carln_op_max_dt_timestamp = rh_carln_op_max_dt_timestamp;
    }

    public BigDecimal getRh_hsln_rct_paydt_timestamp() {
        return rh_hsln_rct_paydt_timestamp;
    }

    public void setRh_hsln_rct_paydt_timestamp(BigDecimal rh_hsln_rct_paydt_timestamp) {
        this.rh_hsln_rct_paydt_timestamp = rh_hsln_rct_paydt_timestamp;
    }

    public BigDecimal getRh_hsln_op_max_dt_timestamp() {
        return rh_hsln_op_max_dt_timestamp;
    }

    public void setRh_hsln_op_max_dt_timestamp(BigDecimal rh_hsln_op_max_dt_timestamp) {
        this.rh_hsln_op_max_dt_timestamp = rh_hsln_op_max_dt_timestamp;
    }

    public BigDecimal getRh_opln_rct_paydt_timestamp() {
        return rh_opln_rct_paydt_timestamp;
    }

    public void setRh_opln_rct_paydt_timestamp(BigDecimal rh_opln_rct_paydt_timestamp) {
        this.rh_opln_rct_paydt_timestamp = rh_opln_rct_paydt_timestamp;
    }

    public BigDecimal getRh_oprln_op_max_dt_timestamp() {
        return rh_oprln_op_max_dt_timestamp;
    }

    public void setRh_oprln_op_max_dt_timestamp(BigDecimal rh_oprln_op_max_dt_timestamp) {
        this.rh_oprln_op_max_dt_timestamp = rh_oprln_op_max_dt_timestamp;
    }

    public BigDecimal getRh_agln_rct_paydt_timestamp() {
        return rh_agln_rct_paydt_timestamp;
    }

    public void setRh_agln_rct_paydt_timestamp(BigDecimal rh_agln_rct_paydt_timestamp) {
        this.rh_agln_rct_paydt_timestamp = rh_agln_rct_paydt_timestamp;
    }

    public BigDecimal getRh_agln_op_max_dt_timestamp() {
        return rh_agln_op_max_dt_timestamp;
    }

    public void setRh_agln_op_max_dt_timestamp(BigDecimal rh_agln_op_max_dt_timestamp) {
        this.rh_agln_op_max_dt_timestamp = rh_agln_op_max_dt_timestamp;
    }

    public BigDecimal getRh_ln_op_old_dt_timestamp() {
        return rh_ln_op_old_dt_timestamp;
    }

    public void setRh_ln_op_old_dt_timestamp(BigDecimal rh_ln_op_old_dt_timestamp) {
        this.rh_ln_op_old_dt_timestamp = rh_ln_op_old_dt_timestamp;
    }

    public BigDecimal getRh_ln_op_min_dt_timestamp() {
        return rh_ln_op_min_dt_timestamp;
    }

    public void setRh_ln_op_min_dt_timestamp(BigDecimal rh_ln_op_min_dt_timestamp) {
        this.rh_ln_op_min_dt_timestamp = rh_ln_op_min_dt_timestamp;
    }

    public BigDecimal getRh_lncd_op_min_dt_timestamp() {
        return rh_lncd_op_min_dt_timestamp;
    }

    public void setRh_lncd_op_min_dt_timestamp(BigDecimal rh_lncd_op_min_dt_timestamp) {
        this.rh_lncd_op_min_dt_timestamp = rh_lncd_op_min_dt_timestamp;
    }

    public BigDecimal getRh_stlncd_op_min_dt_timestamp() {
        return rh_stlncd_op_min_dt_timestamp;
    }

    public void setRh_stlncd_op_min_dt_timestamp(BigDecimal rh_stlncd_op_min_dt_timestamp) {
        this.rh_stlncd_op_min_dt_timestamp = rh_stlncd_op_min_dt_timestamp;
    }

    public BigDecimal getRh_cr_op_min_dt_timestamp() {
        return rh_cr_op_min_dt_timestamp;
    }

    public void setRh_cr_op_min_dt_timestamp(BigDecimal rh_cr_op_min_dt_timestamp) {
        this.rh_cr_op_min_dt_timestamp = rh_cr_op_min_dt_timestamp;
    }

    public BigDecimal getRh_qy_max_dt_timestamp() {
        return rh_qy_max_dt_timestamp;
    }

    public void setRh_qy_max_dt_timestamp(BigDecimal rh_qy_max_dt_timestamp) {
        this.rh_qy_max_dt_timestamp = rh_qy_max_dt_timestamp;
    }

    public BigDecimal getRh_ln_op_max_dt_year() {
        return rh_ln_op_max_dt_year;
    }

    public void setRh_ln_op_max_dt_year(BigDecimal rh_ln_op_max_dt_year) {
        this.rh_ln_op_max_dt_year = rh_ln_op_max_dt_year;
    }

    public BigDecimal getRh_ln_rct_paydt_year() {
        return rh_ln_rct_paydt_year;
    }

    public void setRh_ln_rct_paydt_year(BigDecimal rh_ln_rct_paydt_year) {
        this.rh_ln_rct_paydt_year = rh_ln_rct_paydt_year;
    }

    public BigDecimal getRh_agln_op_max_dt_year() {
        return rh_agln_op_max_dt_year;
    }

    public void setRh_agln_op_max_dt_year(BigDecimal rh_agln_op_max_dt_year) {
        this.rh_agln_op_max_dt_year = rh_agln_op_max_dt_year;
    }

    public BigDecimal getRh_ln_op_old_dt_year() {
        return rh_ln_op_old_dt_year;
    }

    public void setRh_ln_op_old_dt_year(BigDecimal rh_ln_op_old_dt_year) {
        this.rh_ln_op_old_dt_year = rh_ln_op_old_dt_year;
    }

    public BigDecimal getRh_ln_op_min_dt_year() {
        return rh_ln_op_min_dt_year;
    }

    public void setRh_ln_op_min_dt_year(BigDecimal rh_ln_op_min_dt_year) {
        this.rh_ln_op_min_dt_year = rh_ln_op_min_dt_year;
    }

    public BigDecimal getRh_lncd_op_min_dt_year() {
        return rh_lncd_op_min_dt_year;
    }

    public void setRh_lncd_op_min_dt_year(BigDecimal rh_lncd_op_min_dt_year) {
        this.rh_lncd_op_min_dt_year = rh_lncd_op_min_dt_year;
    }

    public BigDecimal getRh_qy_max_dt_year() {
        return rh_qy_max_dt_year;
    }

    public void setRh_qy_max_dt_year(BigDecimal rh_qy_max_dt_year) {
        this.rh_qy_max_dt_year = rh_qy_max_dt_year;
    }

    public BigDecimal getRh_lncd_op_max_dt_month() {
        return rh_lncd_op_max_dt_month;
    }

    public void setRh_lncd_op_max_dt_month(BigDecimal rh_lncd_op_max_dt_month) {
        this.rh_lncd_op_max_dt_month = rh_lncd_op_max_dt_month;
    }

    public BigDecimal getRh_lncd_op_old_dt_month() {
        return rh_lncd_op_old_dt_month;
    }

    public void setRh_lncd_op_old_dt_month(BigDecimal rh_lncd_op_old_dt_month) {
        this.rh_lncd_op_old_dt_month = rh_lncd_op_old_dt_month;
    }

    public BigDecimal getRh_ln_rct_paydt_month() {
        return rh_ln_rct_paydt_month;
    }

    public void setRh_ln_rct_paydt_month(BigDecimal rh_ln_rct_paydt_month) {
        this.rh_ln_rct_paydt_month = rh_ln_rct_paydt_month;
    }

    public BigDecimal getRh_ln_op_min_dt_month() {
        return rh_ln_op_min_dt_month;
    }

    public void setRh_ln_op_min_dt_month(BigDecimal rh_ln_op_min_dt_month) {
        this.rh_ln_op_min_dt_month = rh_ln_op_min_dt_month;
    }

    public BigDecimal getRh_lncd_op_min_dt_month() {
        return rh_lncd_op_min_dt_month;
    }

    public void setRh_lncd_op_min_dt_month(BigDecimal rh_lncd_op_min_dt_month) {
        this.rh_lncd_op_min_dt_month = rh_lncd_op_min_dt_month;
    }

    public BigDecimal getRh_stlncd_op_min_dt_month() {
        return rh_stlncd_op_min_dt_month;
    }

    public void setRh_stlncd_op_min_dt_month(BigDecimal rh_stlncd_op_min_dt_month) {
        this.rh_stlncd_op_min_dt_month = rh_stlncd_op_min_dt_month;
    }

    public BigDecimal getRh_qy_max_dt_month() {
        return rh_qy_max_dt_month;
    }

    public void setRh_qy_max_dt_month(BigDecimal rh_qy_max_dt_month) {
        this.rh_qy_max_dt_month = rh_qy_max_dt_month;
    }

    public BigDecimal getRh_lncd_op_max_dt_day() {
        return rh_lncd_op_max_dt_day;
    }

    public void setRh_lncd_op_max_dt_day(BigDecimal rh_lncd_op_max_dt_day) {
        this.rh_lncd_op_max_dt_day = rh_lncd_op_max_dt_day;
    }

    public BigDecimal getRh_lncd_op_old_dt_day() {
        return rh_lncd_op_old_dt_day;
    }

    public void setRh_lncd_op_old_dt_day(BigDecimal rh_lncd_op_old_dt_day) {
        this.rh_lncd_op_old_dt_day = rh_lncd_op_old_dt_day;
    }

    public BigDecimal getRh_stlncd_op_max_dt_day() {
        return rh_stlncd_op_max_dt_day;
    }

    public void setRh_stlncd_op_max_dt_day(BigDecimal rh_stlncd_op_max_dt_day) {
        this.rh_stlncd_op_max_dt_day = rh_stlncd_op_max_dt_day;
    }

    public BigDecimal getRh_stlncd_op_old_dt_day() {
        return rh_stlncd_op_old_dt_day;
    }

    public void setRh_stlncd_op_old_dt_day(BigDecimal rh_stlncd_op_old_dt_day) {
        this.rh_stlncd_op_old_dt_day = rh_stlncd_op_old_dt_day;
    }

    public BigDecimal getRh_ln_op_max_dt_day() {
        return rh_ln_op_max_dt_day;
    }

    public void setRh_ln_op_max_dt_day(BigDecimal rh_ln_op_max_dt_day) {
        this.rh_ln_op_max_dt_day = rh_ln_op_max_dt_day;
    }

    public BigDecimal getRh_ln_rct_paydt_day() {
        return rh_ln_rct_paydt_day;
    }

    public void setRh_ln_rct_paydt_day(BigDecimal rh_ln_rct_paydt_day) {
        this.rh_ln_rct_paydt_day = rh_ln_rct_paydt_day;
    }

    public BigDecimal getRh_carln_op_max_dt_day() {
        return rh_carln_op_max_dt_day;
    }

    public void setRh_carln_op_max_dt_day(BigDecimal rh_carln_op_max_dt_day) {
        this.rh_carln_op_max_dt_day = rh_carln_op_max_dt_day;
    }

    public BigDecimal getRh_hsln_rct_paydt_day() {
        return rh_hsln_rct_paydt_day;
    }

    public void setRh_hsln_rct_paydt_day(BigDecimal rh_hsln_rct_paydt_day) {
        this.rh_hsln_rct_paydt_day = rh_hsln_rct_paydt_day;
    }

    public BigDecimal getRh_hsln_op_max_dt_day() {
        return rh_hsln_op_max_dt_day;
    }

    public void setRh_hsln_op_max_dt_day(BigDecimal rh_hsln_op_max_dt_day) {
        this.rh_hsln_op_max_dt_day = rh_hsln_op_max_dt_day;
    }

    public BigDecimal getRh_opln_rct_paydt_day() {
        return rh_opln_rct_paydt_day;
    }

    public void setRh_opln_rct_paydt_day(BigDecimal rh_opln_rct_paydt_day) {
        this.rh_opln_rct_paydt_day = rh_opln_rct_paydt_day;
    }

    public BigDecimal getRh_oprln_op_max_dt_day() {
        return rh_oprln_op_max_dt_day;
    }

    public void setRh_oprln_op_max_dt_day(BigDecimal rh_oprln_op_max_dt_day) {
        this.rh_oprln_op_max_dt_day = rh_oprln_op_max_dt_day;
    }

    public BigDecimal getRh_agln_op_max_dt_day() {
        return rh_agln_op_max_dt_day;
    }

    public void setRh_agln_op_max_dt_day(BigDecimal rh_agln_op_max_dt_day) {
        this.rh_agln_op_max_dt_day = rh_agln_op_max_dt_day;
    }

    public BigDecimal getRh_ln_op_old_dt_day() {
        return rh_ln_op_old_dt_day;
    }

    public void setRh_ln_op_old_dt_day(BigDecimal rh_ln_op_old_dt_day) {
        this.rh_ln_op_old_dt_day = rh_ln_op_old_dt_day;
    }

    public BigDecimal getRh_qy_max_dt_day() {
        return rh_qy_max_dt_day;
    }

    public void setRh_qy_max_dt_day(BigDecimal rh_qy_max_dt_day) {
        this.rh_qy_max_dt_day = rh_qy_max_dt_day;
    }

    public BigDecimal getRh_lncd_op_max_dt_week() {
        return rh_lncd_op_max_dt_week;
    }

    public void setRh_lncd_op_max_dt_week(BigDecimal rh_lncd_op_max_dt_week) {
        this.rh_lncd_op_max_dt_week = rh_lncd_op_max_dt_week;
    }

    public BigDecimal getRh_lncd_op_old_dt_week() {
        return rh_lncd_op_old_dt_week;
    }

    public void setRh_lncd_op_old_dt_week(BigDecimal rh_lncd_op_old_dt_week) {
        this.rh_lncd_op_old_dt_week = rh_lncd_op_old_dt_week;
    }

    public BigDecimal getRh_stlncd_op_max_dt_week() {
        return rh_stlncd_op_max_dt_week;
    }

    public void setRh_stlncd_op_max_dt_week(BigDecimal rh_stlncd_op_max_dt_week) {
        this.rh_stlncd_op_max_dt_week = rh_stlncd_op_max_dt_week;
    }

    public BigDecimal getRh_ln_op_max_dt_week() {
        return rh_ln_op_max_dt_week;
    }

    public void setRh_ln_op_max_dt_week(BigDecimal rh_ln_op_max_dt_week) {
        this.rh_ln_op_max_dt_week = rh_ln_op_max_dt_week;
    }

    public BigDecimal getRh_ln_rct_paydt_week() {
        return rh_ln_rct_paydt_week;
    }

    public void setRh_ln_rct_paydt_week(BigDecimal rh_ln_rct_paydt_week) {
        this.rh_ln_rct_paydt_week = rh_ln_rct_paydt_week;
    }

    public BigDecimal getRh_carln_op_max_dt_week() {
        return rh_carln_op_max_dt_week;
    }

    public void setRh_carln_op_max_dt_week(BigDecimal rh_carln_op_max_dt_week) {
        this.rh_carln_op_max_dt_week = rh_carln_op_max_dt_week;
    }

    public BigDecimal getRh_hsln_rct_paydt_week() {
        return rh_hsln_rct_paydt_week;
    }

    public void setRh_hsln_rct_paydt_week(BigDecimal rh_hsln_rct_paydt_week) {
        this.rh_hsln_rct_paydt_week = rh_hsln_rct_paydt_week;
    }

    public BigDecimal getRh_oprln_op_max_dt_week() {
        return rh_oprln_op_max_dt_week;
    }

    public void setRh_oprln_op_max_dt_week(BigDecimal rh_oprln_op_max_dt_week) {
        this.rh_oprln_op_max_dt_week = rh_oprln_op_max_dt_week;
    }

    public BigDecimal getRh_agln_op_max_dt_week() {
        return rh_agln_op_max_dt_week;
    }

    public void setRh_agln_op_max_dt_week(BigDecimal rh_agln_op_max_dt_week) {
        this.rh_agln_op_max_dt_week = rh_agln_op_max_dt_week;
    }

    public BigDecimal getRh_ln_op_old_dt_week() {
        return rh_ln_op_old_dt_week;
    }

    public void setRh_ln_op_old_dt_week(BigDecimal rh_ln_op_old_dt_week) {
        this.rh_ln_op_old_dt_week = rh_ln_op_old_dt_week;
    }

    public BigDecimal getRh_qy_max_dt_week() {
        return rh_qy_max_dt_week;
    }

    public void setRh_qy_max_dt_week(BigDecimal rh_qy_max_dt_week) {
        this.rh_qy_max_dt_week = rh_qy_max_dt_week;
    }

    public BigDecimal getRh_lncd_op_max_dt_year() {
        return rh_lncd_op_max_dt_year;
    }

    public void setRh_lncd_op_max_dt_year(BigDecimal rh_lncd_op_max_dt_year) {
        this.rh_lncd_op_max_dt_year = rh_lncd_op_max_dt_year;
    }

    public BigDecimal getRh_lncd_op_old_dt_year() {
        return rh_lncd_op_old_dt_year;
    }

    public void setRh_lncd_op_old_dt_year(BigDecimal rh_lncd_op_old_dt_year) {
        this.rh_lncd_op_old_dt_year = rh_lncd_op_old_dt_year;
    }

    public BigDecimal getRh_stlncd_op_max_dt_year() {
        return rh_stlncd_op_max_dt_year;
    }

    public void setRh_stlncd_op_max_dt_year(BigDecimal rh_stlncd_op_max_dt_year) {
        this.rh_stlncd_op_max_dt_year = rh_stlncd_op_max_dt_year;
    }

    public BigDecimal getRh_stlncd_op_min_dt_year() {
        return rh_stlncd_op_min_dt_year;
    }

    public void setRh_stlncd_op_min_dt_year(BigDecimal rh_stlncd_op_min_dt_year) {
        this.rh_stlncd_op_min_dt_year = rh_stlncd_op_min_dt_year;
    }

    public BigDecimal getRh_stlncd_op_old_dt_year() {
        return rh_stlncd_op_old_dt_year;
    }

    public void setRh_stlncd_op_old_dt_year(BigDecimal rh_stlncd_op_old_dt_year) {
        this.rh_stlncd_op_old_dt_year = rh_stlncd_op_old_dt_year;
    }

    public BigDecimal getRh_stlncd_op_max_dt_month() {
        return rh_stlncd_op_max_dt_month;
    }

    public void setRh_stlncd_op_max_dt_month(BigDecimal rh_stlncd_op_max_dt_month) {
        this.rh_stlncd_op_max_dt_month = rh_stlncd_op_max_dt_month;
    }

    public BigDecimal getRh_stlncd_op_old_dt_month() {
        return rh_stlncd_op_old_dt_month;
    }

    public void setRh_stlncd_op_old_dt_month(BigDecimal rh_stlncd_op_old_dt_month) {
        this.rh_stlncd_op_old_dt_month = rh_stlncd_op_old_dt_month;
    }

    public BigDecimal getRh_crc_op_max_dt_year() {
        return rh_crc_op_max_dt_year;
    }

    public void setRh_crc_op_max_dt_year(BigDecimal rh_crc_op_max_dt_year) {
        this.rh_crc_op_max_dt_year = rh_crc_op_max_dt_year;
    }

    public BigDecimal getRh_cr_op_min_dt_year() {
        return rh_cr_op_min_dt_year;
    }

    public void setRh_cr_op_min_dt_year(BigDecimal rh_cr_op_min_dt_year) {
        this.rh_cr_op_min_dt_year = rh_cr_op_min_dt_year;
    }

    public BigDecimal getRh_crc_op_max_dt_month() {
        return rh_crc_op_max_dt_month;
    }

    public void setRh_crc_op_max_dt_month(BigDecimal rh_crc_op_max_dt_month) {
        this.rh_crc_op_max_dt_month = rh_crc_op_max_dt_month;
    }

    public BigDecimal getRh_cr_op_min_dt_month() {
        return rh_cr_op_min_dt_month;
    }

    public void setRh_cr_op_min_dt_month(BigDecimal rh_cr_op_min_dt_month) {
        this.rh_cr_op_min_dt_month = rh_cr_op_min_dt_month;
    }

    public BigDecimal getRh_ln_op_max_dt_month() {
        return rh_ln_op_max_dt_month;
    }

    public void setRh_ln_op_max_dt_month(BigDecimal rh_ln_op_max_dt_month) {
        this.rh_ln_op_max_dt_month = rh_ln_op_max_dt_month;
    }

    public BigDecimal getRh_carln_rct_paydt_year() {
        return rh_carln_rct_paydt_year;
    }

    public void setRh_carln_rct_paydt_year(BigDecimal rh_carln_rct_paydt_year) {
        this.rh_carln_rct_paydt_year = rh_carln_rct_paydt_year;
    }

    public BigDecimal getRh_carln_op_max_dt_year() {
        return rh_carln_op_max_dt_year;
    }

    public void setRh_carln_op_max_dt_year(BigDecimal rh_carln_op_max_dt_year) {
        this.rh_carln_op_max_dt_year = rh_carln_op_max_dt_year;
    }

    public BigDecimal getRh_carln_rct_paydt_month() {
        return rh_carln_rct_paydt_month;
    }

    public void setRh_carln_rct_paydt_month(BigDecimal rh_carln_rct_paydt_month) {
        this.rh_carln_rct_paydt_month = rh_carln_rct_paydt_month;
    }

    public BigDecimal getRh_carln_op_max_dt_month() {
        return rh_carln_op_max_dt_month;
    }

    public void setRh_carln_op_max_dt_month(BigDecimal rh_carln_op_max_dt_month) {
        this.rh_carln_op_max_dt_month = rh_carln_op_max_dt_month;
    }

    public BigDecimal getRh_hsln_rct_paydt_year() {
        return rh_hsln_rct_paydt_year;
    }

    public void setRh_hsln_rct_paydt_year(BigDecimal rh_hsln_rct_paydt_year) {
        this.rh_hsln_rct_paydt_year = rh_hsln_rct_paydt_year;
    }

    public BigDecimal getRh_hsln_op_max_dt_year() {
        return rh_hsln_op_max_dt_year;
    }

    public void setRh_hsln_op_max_dt_year(BigDecimal rh_hsln_op_max_dt_year) {
        this.rh_hsln_op_max_dt_year = rh_hsln_op_max_dt_year;
    }

    public BigDecimal getRh_hsln_rct_paydt_month() {
        return rh_hsln_rct_paydt_month;
    }

    public void setRh_hsln_rct_paydt_month(BigDecimal rh_hsln_rct_paydt_month) {
        this.rh_hsln_rct_paydt_month = rh_hsln_rct_paydt_month;
    }

    public BigDecimal getRh_hsln_op_max_dt_month() {
        return rh_hsln_op_max_dt_month;
    }

    public void setRh_hsln_op_max_dt_month(BigDecimal rh_hsln_op_max_dt_month) {
        this.rh_hsln_op_max_dt_month = rh_hsln_op_max_dt_month;
    }

    public BigDecimal getRh_opln_rct_paydt_year() {
        return rh_opln_rct_paydt_year;
    }

    public void setRh_opln_rct_paydt_year(BigDecimal rh_opln_rct_paydt_year) {
        this.rh_opln_rct_paydt_year = rh_opln_rct_paydt_year;
    }

    public BigDecimal getRh_oprln_op_max_dt_year() {
        return rh_oprln_op_max_dt_year;
    }

    public void setRh_oprln_op_max_dt_year(BigDecimal rh_oprln_op_max_dt_year) {
        this.rh_oprln_op_max_dt_year = rh_oprln_op_max_dt_year;
    }

    public BigDecimal getRh_opln_rct_paydt_month() {
        return rh_opln_rct_paydt_month;
    }

    public void setRh_opln_rct_paydt_month(BigDecimal rh_opln_rct_paydt_month) {
        this.rh_opln_rct_paydt_month = rh_opln_rct_paydt_month;
    }

    public BigDecimal getRh_oprln_op_max_dt_month() {
        return rh_oprln_op_max_dt_month;
    }

    public void setRh_oprln_op_max_dt_month(BigDecimal rh_oprln_op_max_dt_month) {
        this.rh_oprln_op_max_dt_month = rh_oprln_op_max_dt_month;
    }

    public BigDecimal getRh_agln_rct_paydt_year() {
        return rh_agln_rct_paydt_year;
    }

    public void setRh_agln_rct_paydt_year(BigDecimal rh_agln_rct_paydt_year) {
        this.rh_agln_rct_paydt_year = rh_agln_rct_paydt_year;
    }

    public BigDecimal getRh_agln_rct_paydt_month() {
        return rh_agln_rct_paydt_month;
    }

    public void setRh_agln_rct_paydt_month(BigDecimal rh_agln_rct_paydt_month) {
        this.rh_agln_rct_paydt_month = rh_agln_rct_paydt_month;
    }

    public BigDecimal getRh_agln_op_max_dt_month() {
        return rh_agln_op_max_dt_month;
    }

    public void setRh_agln_op_max_dt_month(BigDecimal rh_agln_op_max_dt_month) {
        this.rh_agln_op_max_dt_month = rh_agln_op_max_dt_month;
    }

    public CustCard2ResVo() {
        initDefaultCustomerCardModelVo();
    }

    public void initDefaultCustomerCardModelVo() {
        this.occupation = "NaN";
        this.duty = "NaN";
        this.rh_bs_industry_mat = new BigDecimal(-99988);
        this.rh_lncd_nr_mn_cr_lmt = new BigDecimal(-99988);
        this.rh_lncd_nr_min_cr_lmt = -99988;
        this.rh_lncd_nr_min_sd_lmt = -99988;
        this.rh_lncd_min_ud_sd_lmt_pr = new BigDecimal(-99988);
        this.rh_lncd_nr_min_ud_sd_lmt_pr = new BigDecimal(-99988);
        this.rh_lncd_avg_curdef_amt = new BigDecimal(-99988);
        this.rh_lncd_max_curdef_amt = -99988;
        this.rh_lncd_ovd_ct_3y_rp = -99988;
        this.rh_m24_lncd_ovd_max_perd = -99988;
        this.rh_lncd_nr_mn_cr_lmt_m6 = new BigDecimal(-99988);
        this.rh_lncd_lim_org_ds_num = -99988;
        this.rh_lncd_per_num = -99988;
        this.rh_stlncd_nr_sum_ud_cr_lmt = 0;
        this.rh_stlncd_nr_min_ud_cr_lmt = 0;
        this.rh_crc_uc_max_age = -99988;
        this.rh_crc_ovd_ct_3y_rp = -99988;
        this.rh_ln_num = -99988;
        this.rh_ln_st_advp = -99988;
        this.rh_ln_st_oth = -99988;
        this.rh_ln_uc_max_age = -99988;
        this.rh_if_houseln = "NaN";
        this.rh_5state_good_pr = new BigDecimal(-99988);
        this.rh_ln_ovd_cur_amt_rp = -99988;
        this.rh_ln_ovd_max_2y_rp = -99988;
        this.rh_carln_sum_amt = -99988;
        this.rh_carln_st_adva = -99988;
        this.rh_hsln_avg_bal = -99988;
        this.rh_hsln_min_bal_pr = new BigDecimal(-99988);
        this.rh_hsln_max_bal_pr = new BigDecimal(-99988);
        this.rh_opln_nr_num = -99988;
        this.rh_opln_max_amt = -99988;
        this.rh_opln_max_bal = -99988;
        this.rh_opln_avg_bal = -99988;
        this.rh_opln_st_adva = -99988;
        this.rh_agln_max_bal = -99988;
        this.rh_hsln_sum_num = -99988;
        this.rh_ln_ovd_dur = -99988;
        this.rh_ln_corg_num = -99988;
        this.rh_ln_org_num = -99988;
        this.rh_lncd_ud_amt = -99988;
        this.rh_m6_lncd_ud_pro = new BigDecimal(-99988);
        this.rh_cr_lim_amt = -99988;
        this.rh_gr_sum_amt = -99988;
        this.rh_gr_tol_bal = -99988;
        this.rh_cr_bal_pro = new BigDecimal(-99988);
        this.rh_crc_ud_pro = new BigDecimal(-99988);
        this.rh_ln_bal_pro = new BigDecimal(-99988);
        this.rh_m6_cr_ovd_mon = -99988;
        this.rh_m24_cr_ovd_mon = -99988;
        this.rh_m12_cr_ovd_mon = -99988;
        this.rh_cr_uc_min_age = -99988;
        this.rh_ln_qy_lst_inte = -99988;
        this.rh_ln_qy_fst_inte = -99988;
        this.rh_crc_qy_fst_inte = -99988;
        this.rh_cr_y2_qyf_num = 0;
        this.rh_lncd_num = 0;
        this.rh_lncd_uc_num = 0;
        this.rh_lncd_nr_num = 0;
        this.rh_lncd_nopen_num = 0;
        this.rh_lncd_cancel_num = 0;
        this.rh_lncd_oc_num = 0;
        this.rh_lncd_max_nr_cr_lmt = -99988;
        this.rh_lncd_nr_avg_sd_lmt = new BigDecimal(-99988);
        this.rh_lncd_nr_mn_sd_lmt = new BigDecimal(-99988);
        this.rh_lncd_max_nr_sd_lmt = -99988;
        this.rh_lncd_sum_nr_ud_cr_lmt = 0;
        this.rh_lncd_nr_avg_ud_cr_lmt = new BigDecimal(-99988);
        this.rh_lncd_max_nr_ud_cr_lmt = -99988;
        this.rh_lncd_max_nr_ud_cr_lmt_pr = new BigDecimal(-99988);
        this.rh_lncd_nr_avg_ud_cr_lmt_pr = new BigDecimal(-99988);
        this.rh_lncd_sum_nr_ud_cr_lmt_pr = new BigDecimal(-99988);
        this.rh_lncd_max_nr_ud_sd_lmt_pr = new BigDecimal(-99988);
        this.rh_lncd_sum_nr_ud_sd_lmt_pr = new BigDecimal(-99988);
        this.rh_lncd_sum_cr_lmt = 0;
        this.rh_lncd_avg_cr_lmt = new BigDecimal(-99988);
        this.rh_lncd_mn_cr_lmt = new BigDecimal(-99988);
        this.rh_lncd_uc_lmt_min = Integer.MAX_VALUE;
        this.rh_lncd_uc_lmt_max = -99988;
        this.rh_lncd_sum_sd_lmt = 0;
        this.rh_lncd_avg_sd_lmt = new BigDecimal(-99988);
        this.rh_lncd_mn_sd_lmt = new BigDecimal(-99988);
        this.rh_lncd_max_sd_lmt = -99988;
        this.rh_lncd_min_sd_lmt = Integer.MAX_VALUE;
        this.rh_lncd_sum_ud_cr_lmt = 0;
        this.rh_lncd_avg_ud_cr_lmt = new BigDecimal(0);
        this.rh_lncd_max_ud_cr_lmt = -99988;
        this.rh_lncd_min_ud_cr_lmt = Integer.MAX_VALUE;
        this.rh_lncd_uc_max_amt_pro = new BigDecimal(-99988);
        this.rh_lncd_avg_ud_cr_lmt_pr = new BigDecimal(-99988);
        this.rh_lncd_mn_ud_cr_lmt_pr = new BigDecimal(-99988);
        this.rh_lncd_sum_ud_cr_lmt_pr = new BigDecimal(-99988);
        this.rh_lncd_max_ud_sd_lmt_pr = new BigDecimal(-99988);
        this.rh_lncd_avg_ud_sd_lmt_pr = new BigDecimal(-99988);
        this.rh_lncd_mn_ud_sd_lmt_pr = new BigDecimal(-99988);
        this.rh_lncd_sum_ud_sd_lmt_pr = new BigDecimal(-99988);
        this.rh_lncd_avg_max_ud_amt = -99988;
        this.rh_lncd_sum_max_ud_amt = 0;
        this.rh_lncd_max_max_ud_amt = -99988;
        this.rh_lncd_ovd_ct_2y_rp = 0;
        this.rh_lncd_max_sd_lmt_m6 = -99988;
        this.rh_lncd_sum_nr_cr_lmt_m6 = 0;
        this.rh_lncd_sum_nr_cr_lmt = 0;
        this.rh_lncd_nr_avg_cr_lmt = new BigDecimal(-99988);
        this.rh_lncd_sum_nr_cr_lmt_m12 = 0;
        this.rh_lncd_nr_num_m12 = 0;
        this.rh_lncd_nr_mn_cr_lmt_m12 = new BigDecimal(-99988);
        this.rh_lncd_od180amt_sum_amt = -99988;
        this.rh_lncd_mid_ovd_num = 0;
        this.rh_lncd_high_ovd_num = 0;
        this.rh_lncd_bad_state = "NaN";
        this.rh_lncd_op_max_dt = "NaN";
        this.rh_lncd_op_old_dt = "NaN";
        this.rh_lncd_old_age = -99988;
        this.rh_lncd_detail_max_age = -99988;
        this.rh_lncd_op_min_dt = "NaN";
        this.rh_crc_num = 0;
        this.rh_crc_nopen_num = 0;
        this.rh_crc_cancel_num = 0;
        this.rh_crc_uc_num = 0;
        this.rh_crc_sum_cr_lmt = 0;
        this.rh_crc_avg_cr_lmt = new BigDecimal(0);
        this.rh_crc_mn_cr_lmt = new BigDecimal(0);
        this.rh_crc_sum_sd_lmt = 0;
        this.rh_crc_mn_sd_lmt = new BigDecimal(0);
        this.rh_crc_avg_sd_lmt = new BigDecimal(0);
        this.rh_crc_sum_nr_cr_lmt = 0;
        this.rh_crc_nr_num = 0;
        this.rh_crc_nr_mn_cr_lmt = new BigDecimal(-99988);
        this.rh_crc_max_nr_cr_lmt = 0;
        this.rh_crc_sum_ud_cr_lmt = 0;
        this.rh_crc_mn_ud_cr_lmt = new BigDecimal(-99988);
        this.rh_crc_uc_max_amt_pro = new BigDecimal(-99988);
        this.rh_crc_uc_min_amt_pro = new BigDecimal(-99988);
        this.rh_crc_avg_ud_cr_lmt_pr = new BigDecimal(-99988);
        this.rh_crc_mn_ud_cr_lmt_pr = new BigDecimal(-99988);
        this.rh_crc_max_ud_sd_lmt_pr = new BigDecimal(-99988);
        this.rh_crc_min_ud_sd_lmt_pr = new BigDecimal(-99988);
        this.rh_crc_sum_ud_sd_lmt_pr = new BigDecimal(0);
        this.rh_crc_max_nr_ud_cr_lmt_pr = new BigDecimal(-99988);
        this.rh_crc_nr_min_ud_cr_lmt_pr = new BigDecimal(-99988);
        this.rh_crc_nr_avg_ud_cr_lmt_pr = new BigDecimal(-99988);
        this.rh_crc_nr_mn_ud_cr_lmt_pr = new BigDecimal(-99988);
        this.rh_crc_max_nr_ud_sd_lmt_pr = new BigDecimal(-99988);
        this.rh_crc_nr_min_ud_sd_lmt_pr = new BigDecimal(-99988);
        this.rh_crc_sum_nr_ud_sd_lmt_pr = new BigDecimal(0);
        this.rh_crc_max_max_ud_amt = 0;
        this.rh_crc_ovd_ct_2y_rp = -99988;
        this.rh_crc_sum_nr_cr_lmt_m6 = 0;
        this.rh_crc_nr_avg_cr_lmt_m6 = new BigDecimal(-99988);
        this.rh_crc_nr_num_m6 = 0;
        this.rh_crc_nr_mn_cr_lmt_m6 = new BigDecimal(-99988);
        this.rh_crc_nr_num_m12 = 0;
        this.rh_crc_nr_mn_cr_lmt_m12 = new BigDecimal(0);
        this.rh_crc_od180amt_sum_amt = -99988;
        this.rh_crc_max_age = -99988;
        this.rh_stlncd_uc_num = 0;
        this.rh_stlncd_nopen_num = 0;
        this.rh_stlncd_cancel_num = 0;
        this.rh_stlncd_oc_num = 0;
        this.rh_stlncd_sum_cr_lmt = 0;
        this.rh_stlncd_avg_cr_lmt = new BigDecimal(-99988);
        this.rh_stlncd_mn_cr_lmt = new BigDecimal(-99988);
        this.rh_stlncd_sum_sd_lmt = 0;
        this.rh_stlncd_avg_sd_lmt = new BigDecimal(0);
        this.rh_stlncd_mn_sd_lmt = new BigDecimal(-99988);
        this.rh_stlncd_nr_sum_cr_lmt = 0;
        this.rh_stlncd_nr_num = 0;
        this.rh_stlncd_nr_mn_cr_lmt = new BigDecimal(-99988);
        this.rh_stlncd_nr_max_cr_lmt = 0;
        this.rh_stlncd_nr_min_cr_lmt = Integer.MAX_VALUE;
        this.rh_stlncd_nr_sum_sd_lmt = 0;
        this.rh_stlncd_nr_avg_sd_lmt = new BigDecimal(-99988);
        this.rh_stlncd_nr_mn_sd_lmt = new BigDecimal(-99988);
        this.rh_stlncd_nr_max_sd_lmt = -99988;
        this.rh_stlncd_nr_max_ud_cr_lmt = -99988;
        this.rh_stlncd_nr_max_ud_cr_lmt_pr = new BigDecimal(-99988);
        this.rh_stlncd_nr_sum_ud_cr_lmt_pr = new BigDecimal(-99988);
        this.rh_stlncd_nr_max_ud_sd_lmt_pr = new BigDecimal(-99988);
        this.rh_stlncd_nr_mn_ud_sd_lmt_pr = new BigDecimal(0);
        this.rh_stlncd_nr_sum_ud_sd_lmt_pr = new BigDecimal(-99988);
        this.rh_stlncd_sum_ud_cr_lmt = 0;
        this.rh_stlncd_mn_ud_cr_lmt = new BigDecimal(-99988);
        this.rh_stlncd_avg_ud_cr_lmt = new BigDecimal(0);
        this.rh_stlncd_uc_max_amt_pro = new BigDecimal(-99988);
        this.rh_stlncd_avg_ud_cr_lmt_pr = new BigDecimal(0);
        this.rh_stlncd_mn_ud_cr_lmt_pr = new BigDecimal(-99988);
        this.rh_stlncd_sum_ud_cr_lmt_pr = new BigDecimal(-99988);
        this.rh_stlncd_max_ud_sd_lmt_pr = new BigDecimal(0);
        this.rh_stlncd_sum_ud_sd_lmt_pr = new BigDecimal(-99988);
        this.rh_stlncd_max_max_ud_amt = -99988;
        this.rh_stlncd_sum_max_ud_amt = 0;
        this.rh_stlncd_ovd_ct_2y_rp = 0;
        this.rh_stlncd_ovd_ct_3y_rp = 0;
        this.rh_stlncd_nonpmf_ct_2y_rp = 0;
        this.rh_stlncd_num_m3 = 0;
        this.rh_stlncd_nr_sum_cr_lmt_m6 = 0;
        this.rh_stlncd_od180amt_sum_amt = 0;
        this.rh_stlncd_high_ovd_num = 0;
        this.rh_stlncd_mid_ovd_num = 0;
        this.rh_stlncd_per_num = 0;
        this.rh_stlncd_op_max_dt = "NaN";
        this.rh_stlncd_op_old_dt = "NaN";
        this.rh_stlncd_op_min_dt = "NaN";
        this.rh_crc_op_max_dt = "NaN";
        this.rh_crc_op_old_dt = "NaN";
        this.rh_ln_op_max_dt = "NaN";
        this.rh_ln_op_old_dt = "NaN";
        this.rh_ln_op_min_dt = "NaN";
        this.rh_ln_rct_paydt = "NaN";
        this.rh_carln_rct_paydt = "NaN";
        this.rh_carln_op_max_dt = "NaN";
        this.rh_hsln_rct_paydt = "NaN";
        this.rh_hsln_op_max_dt = "NaN";
        this.rh_opln_rct_paydt = "NaN";
        this.rh_oprln_op_max_dt = "NaN";
        this.rh_agln_op_max_dt = "NaN";
        this.rh_qy_max_dt = "NaN";
        this.report_date = "NaN";
        this.rh_crc_nr_mn_sd_lmt = new BigDecimal(0);
        this.rh_stlncd_nr_mn_ud_cr_lmt_pr = new BigDecimal(-99988);
        this.rh_lncd_nr_mn_ud_cr_lmt_pr = new BigDecimal(-99988);
        this.rh_crc_nr_mn_ud_sd_lmt_pr = new BigDecimal(-99988);
        this.rh_lncd_nr_mn_ud_sd_lmt_pr = new BigDecimal(-99988);
        this.rh_stlncd_mn_ud_sd_lmt_pr = new BigDecimal(0);
        this.rh_crc_avg_ud_sd_lmt_pr = new BigDecimal(0);
        this.rh_crc_mn_ud_sd_lmt_pr = new BigDecimal(0);
        this.rh_crc_per_num = 0;
        this.rh_crc_nr_mn_ud_cr_lmt = new BigDecimal(0);
        this.rh_lncd_nr_mn_sd_lmt_m12 = new BigDecimal(0);
        this.rh_lncd_nr_mn_ud_cr_lmt = new BigDecimal(-99988);
        this.rh_lncd_nr_mn_ud_cr_lmt_m12 = new BigDecimal(0);
        this.rh_crc_mn_cr_lmt_m12 = new BigDecimal(0);
        this.rh_lncd_mn_ud_cr_lmt = new BigDecimal(-99988);
        this.rh_lncd_uc_min_lmt_pro = new BigDecimal(0);
        this.rh_lncd_uc_max_lmt_pro = new BigDecimal(-99988);
        this.rh_ln_min_age = 0;
        this.queryreason = "NaN";
        this.gender = "NaN";
        this.maritalstate = "NaN";
        this.edulevel = "NaN";
        this.edudegree = "NaN";
        this.residencetype = "NaN";
        this.residence_province_num = -99988;
        this.residence_type_num = -99988;
        this.industry = "NaN";
        this.accfund_state = "NaN";
        this.accfund_pay = 0;
        this.ownprent = new BigDecimal(0);
        this.comprent = new BigDecimal(0);
        this.rh_bs_accf_cur_mon = -99988;
        this.rh_bs_accf_his_mon = -99988;
        this.rh_bs_accf_base = -99988;
        this.apply_age = -99988;
        this.industry_num = -99988;
        this.rh_bs_work_last_sta = new BigDecimal(-99988);
        this.rh_lncd_sum_nr_sd_lmt = 0;
        this.rh_lncd_nr_min_ud_cr_lmt = Integer.MAX_VALUE;
        this.rh_lncd_nr_min_ud_cr_lmt_m12 = 0;
        this.rh_lncd_nr_avg_ud_sd_lmt_pr = new BigDecimal(-99988);
        this.rh_lncd_avg_m6avg_ud_amt = new BigDecimal(-99988);
        this.rh_lncd_max_m6avg_ud_amt = -99988;
        this.rh_lncd_nr_avg_cr_lmt_m6 = new BigDecimal(-99988);
        this.rh_lncd_mn_cr_lmt_m12 = new BigDecimal(-99988);
        this.rh_crc_uc_num_m12 = 0;
        this.rh_stlncd_nr_avg_ud_cr_lmt_pr = new BigDecimal(-99988);
        this.rh_stlncd_nr_avg_ud_sd_lmt_pr = new BigDecimal(-99988);
        this.rh_stlncd_avg_max_ud_amt = new BigDecimal(-99988);
        this.rh_crc_min_age = -99988;
        this.rh_crc_avg_max_ud_amt = new BigDecimal(-99988);
        this.rh_crc_sum_max_ud_amt = -99988;
        this.rh_crc_max_sd_lmt_m6 = -99988;
        this.rh_crc_sum_nr_cr_lmt_m12 = -99988;
        this.rh_ln_nr_num = 0;
        this.rh_ln_clear_num = 0;
        this.rh_carln_num = 0;
        this.rh_ln_type_num = -99988;
        this.rh_ln_min_bal_pr_m6 = new BigDecimal(0);
        this.rh_ln_avg_amt_m12 = -99988;
        this.rh_5state_nr_num = 0;
        this.rh_ln_nonpmf_ct_2y_rp = -99988;
        this.rh_opln_num = 0;
        this.rh_opln_clear_num = 0;
        this.rh_opln_min_bal_pr = new BigDecimal(-99988);
        this.rh_ln_bal_num = 0;
        this.rh_ln_m12_ovd_sum_num = -99988;
        this.rh_ln_avg_pay_amt = -99988;
        this.rh_ln_old_age = 0;
        this.rh_ln_max_old_cd = 0;
        this.rh_perbushslnct_rp = -99988;
        this.rh_perhslnct_rp = -99988;
        this.rh_otlnct_rp = -99988;
        this.rh_ln_max_age = -99988;
        this.rh_lncd_max_age = -99988;
        this.rh_ln_st_flag = "0";
        this.rh_ln_st_adva = 0;
        this.rh_carln_curodamt = 0;
        this.rh_hsln_nr_num = 0;
        this.rh_longln_sum_pay_amt = 0;
        this.rh_ln_max_amt = -99988;
        this.rh_ln_avg_amt = -99988;
        this.rh_ln_max_bal = -99988;
        this.rh_ln_avg_bal = -99988;
        this.rh_ln_min_bal_pr = new BigDecimal(-99988);
        this.rh_ln_max_bal_pr = new BigDecimal(-99988);
        this.rh_ln_avg_bal_m6 = -99988;
        this.rh_ln_sum_amt_m12 = -99988;
        this.rh_ln_max_amt_m12 = -99988;
        this.rh_ln_sum_bal_m12 = -99988;
        this.rh_ln_max_bal_m12 = -99988;
        this.rh_carln_avg_amt = -99988;
        this.rh_carln_min_bal_pr = new BigDecimal(-99988);
        this.rh_hsln_sum_amt = -99988;
        this.rh_hsln_max_amt = -99988;
        this.rh_hsln_avg_amt = -99988;
        this.rh_hsln_sum_bal = -99988;
        this.rh_lncd_ovd_num = -99988;
        this.rh_sum_ovd_num = -99988;
        this.rh_ln_ovd_mon = 0;
        this.rh_ln_ovd_hgst_amt = -99988;
        this.rh_lncd_ovd_mon = 0;
        this.rh_lncd_ovd_hgst_amt = 0;
        this.rh_lncd_ovd_dur = 0;
        this.rh_sum_ovd_mon = 0;
        this.rh_max_ovd_mon = -99988;
        this.rh_avg_ovd_mon = -99988;
        this.rh_sum_ovd_hgst_amt = -99988;
        this.rh_max_ovd_hgst_amt = -99988;
        this.rh_avg_ovd_hgst_amt = -99988;
        this.rh_mn_ovd_hgst_amt = -99988;
        this.rh_sum_ovd_dur = -99988;
        this.rh_max_ovd_dur = -99988;
        this.rh_uc_ln_bal = -99988;
        this.rh_uc_ln_amt = 0;
        this.rh_uc_ln_m6avg_amt = new BigDecimal(-99988);
        this.rh_lncd_uc_ud_pro = new BigDecimal(-99988);
        this.rh_cr_sum_bal = -99988;
        this.rh_ln_bal_pral = new BigDecimal(-99988);
        this.rh_cd_bal_pral = new BigDecimal(-99988);
        this.rh_ln_amt_pral = new BigDecimal(-99988);
        this.rh_cd_amt_pral = new BigDecimal(-99988);
        this.rh_cr_num = -99988;
        this.rh_lncd_cr_uc_num_pro = new BigDecimal(-99988);
        this.rh_cr_ovd_max_amt = -99988;
        this.rh_cr_cate_num = 0;
        this.rh_ln_avg_bal_amt = new BigDecimal(-99988);
        this.rh_m24_cr_ovd_num = -99988;
        this.rh_ln_y2_qy_num = 0;
        this.rh_crc_y2_qy_num = 0;
        this.rh_crc_qy_lst_inte = -99988;
        this.rh_guar_y2_qy_num = 0;
        this.rh_m3_qy_num = 0;
        this.rh_cr_y2_qy_num = 0;
        this.rh_pstln_y2_qy_num = -99988;
        this.rh_merch_y2_qy_num = -99988;
        this.rh_self_m1_qy_num = -99988;
        this.rh_cr_m12_qy_org_num = 0;
        this.rh_ln_cr_y2_qy_pro = new BigDecimal(-99988);
        this.rh_crc_cr_y2_qy_pro = new BigDecimal(-99988);
        this.rh_crc_y2_qyf_num = 0;
        this.rh_crc_m12_qyf_num = 0;
        this.rh_cr_y2_qyf_pro = new BigDecimal(-99988);
        this.rh_ln_y2_qyf_pro = new BigDecimal(-99988);
        this.rh_crc_y2_qyf_pro = new BigDecimal(-99988);
        this.rh_crc_cr_y2_qyf_pro = new BigDecimal(-99988);
        this.rh_crc_cr_m6_qyf_pro = new BigDecimal(-99988);
        this.rh_crc_cr_m12_qyf_pro = new BigDecimal(-99988);
        this.rh_ln_cr_y2_qyf_pro = new BigDecimal(-99988);
        this.rh_ln_cr_m12_qyf_pro = new BigDecimal(-99988);
        this.rh_ln_y2_qy_org_num = 0;
        this.rh_crc_y2_qy_org_num = 0;
        this.rh_guar_y2_qy_org_num = -99988;
        this.rh_cr_y2_qy_org_num = 0;
        this.rh_ln_cr_y2_qy_org_pro = new BigDecimal(-99988);
        this.rh_crc_cr_y2_qy_org_pro = new BigDecimal(-99988);
        this.rh_ln_cr_m12_qy_org_pro = new BigDecimal(-99988);
        this.rh_cr_y2_qyf_org_num = 0;
        this.rh_ln_y2_qyf_org_num = 0;
        this.rh_crc_y2_qyf_org_num = 0;
        this.rh_cr_y2_qyf_org_pro = new BigDecimal(-99988);
        this.rh_ln_y2_qyf_org_pro = new BigDecimal(-99988);
        this.rh_crc_y2_qyf_org_pro = new BigDecimal(-99988);
        this.rh_crc_cr_y2_qyf_org_pro = new BigDecimal(-99988);
        this.rh_ln_cr_y2_qyf_org_pro = new BigDecimal(-99988);
        this.rh_m12_crc_qy_num = 0;
        this.rh_ln_y2_qyf_num = 0;
        this.rh_crc_m6_qyf_num = 0;
        this.rh_m12_ln_qy_num = 0;
        this.rh_cr_m6_qyf_num = 0;
        this.rh_ln_m12_qyf_pro = new BigDecimal(0);
        this.rh_lncd_uc_num_m12 = 0;
        this.rh_lncd_sum_cr_lmt_m12 = 0;
        this.rh_ln_m12_qy_org_num = 0;
        this.rh_agln_rct_paydt = "NaN";
        this.rh_cr_op_min_dt = "NaN";
        this.rh_lncd_nr_num_m6 = -99988;
        this.rh_m6_crc_qy_num = 0;
        this.rh_ln_m6_qyf_num = 0;
        this.rh_lncd_op_max_dt_timestamp = new BigDecimal(0);
        this.rh_lncd_op_old_dt_timestamp = new BigDecimal(0);
        this.rh_stlncd_op_max_dt_timestamp = new BigDecimal(0);
        this.rh_stlncd_op_old_dt_timestamp = new BigDecimal(0);
        this.rh_crc_op_max_dt_timestamp = new BigDecimal(0);
        this.rh_ln_op_max_dt_timestamp = new BigDecimal(0);
        this.rh_ln_rct_paydt_timestamp = new BigDecimal(0);
        this.rh_carln_rct_paydt_timestamp = new BigDecimal(0);
        this.rh_carln_op_max_dt_timestamp = new BigDecimal(0);
        this.rh_hsln_rct_paydt_timestamp = new BigDecimal(0);
        this.rh_hsln_op_max_dt_timestamp = new BigDecimal(0);
        this.rh_opln_rct_paydt_timestamp = new BigDecimal(0);
        this.rh_oprln_op_max_dt_timestamp = new BigDecimal(0);
        this.rh_agln_rct_paydt_timestamp = new BigDecimal(0);
        this.rh_agln_op_max_dt_timestamp = new BigDecimal(0);
        this.rh_ln_op_old_dt_timestamp = new BigDecimal(0);
        this.rh_ln_op_min_dt_timestamp = new BigDecimal(0);
        this.rh_lncd_op_min_dt_timestamp = new BigDecimal(0);
        this.rh_stlncd_op_min_dt_timestamp = new BigDecimal(0);
        this.rh_cr_op_min_dt_timestamp = new BigDecimal(0);
        this.rh_qy_max_dt_timestamp = new BigDecimal(0);
        this.rh_ln_op_max_dt_year = new BigDecimal(0);
        this.rh_ln_rct_paydt_year = new BigDecimal(0);
        this.rh_agln_op_max_dt_year = new BigDecimal(0);
        this.rh_ln_op_old_dt_year = new BigDecimal(0);
        this.rh_ln_op_min_dt_year = new BigDecimal(0);
        this.rh_lncd_op_min_dt_year = new BigDecimal(0);
        this.rh_qy_max_dt_year = new BigDecimal(0);
        this.rh_lncd_op_max_dt_month = new BigDecimal(0);
        this.rh_lncd_op_old_dt_month = new BigDecimal(0);
        this.rh_ln_rct_paydt_month = new BigDecimal(0);
        this.rh_ln_op_min_dt_month = new BigDecimal(0);
        this.rh_lncd_op_min_dt_month = new BigDecimal(0);
        this.rh_stlncd_op_min_dt_month = new BigDecimal(0);
        this.rh_qy_max_dt_month = new BigDecimal(0);
        this.rh_lncd_op_max_dt_day = new BigDecimal(0);
        this.rh_lncd_op_old_dt_day = new BigDecimal(0);
        this.rh_stlncd_op_max_dt_day = new BigDecimal(0);
        this.rh_stlncd_op_old_dt_day = new BigDecimal(0);
        this.rh_ln_op_max_dt_day = new BigDecimal(0);
        this.rh_ln_rct_paydt_day = new BigDecimal(0);
        this.rh_carln_op_max_dt_day = new BigDecimal(0);
        this.rh_hsln_rct_paydt_day = new BigDecimal(0);
        this.rh_hsln_op_max_dt_day = new BigDecimal(0);
        this.rh_opln_rct_paydt_day = new BigDecimal(0);
        this.rh_oprln_op_max_dt_day = new BigDecimal(0);
        this.rh_agln_op_max_dt_day = new BigDecimal(0);
        this.rh_ln_op_old_dt_day = new BigDecimal(0);
        this.rh_qy_max_dt_day = new BigDecimal(0);
        this.rh_lncd_op_max_dt_week = new BigDecimal(0);
        this.rh_lncd_op_old_dt_week = new BigDecimal(0);
        this.rh_stlncd_op_max_dt_week = new BigDecimal(0);
        this.rh_ln_op_max_dt_week = new BigDecimal(0);
        this.rh_ln_rct_paydt_week = new BigDecimal(0);
        this.rh_carln_op_max_dt_week = new BigDecimal(0);
        this.rh_hsln_rct_paydt_week = new BigDecimal(0);
        this.rh_oprln_op_max_dt_week = new BigDecimal(0);
        this.rh_agln_op_max_dt_week = new BigDecimal(0);
        this.rh_ln_op_old_dt_week = new BigDecimal(0);
        this.rh_qy_max_dt_week = new BigDecimal(0);
        this.rh_lncd_op_max_dt_year = new BigDecimal(0);
        this.rh_lncd_op_old_dt_year = new BigDecimal(0);
        this.rh_stlncd_op_max_dt_year = new BigDecimal(0);
        this.rh_stlncd_op_min_dt_year = new BigDecimal(0);
        this.rh_stlncd_op_old_dt_year = new BigDecimal(0);
        this.rh_stlncd_op_max_dt_month = new BigDecimal(0);
        this.rh_stlncd_op_old_dt_month = new BigDecimal(0);
        this.rh_crc_op_max_dt_year = new BigDecimal(0);
        this.rh_cr_op_min_dt_year = new BigDecimal(0);
        this.rh_crc_op_max_dt_month = new BigDecimal(0);
        this.rh_cr_op_min_dt_month = new BigDecimal(0);
        this.rh_ln_op_max_dt_month = new BigDecimal(0);
        this.rh_carln_rct_paydt_year = new BigDecimal(0);
        this.rh_carln_op_max_dt_year = new BigDecimal(0);
        this.rh_carln_rct_paydt_month = new BigDecimal(0);
        this.rh_carln_op_max_dt_month = new BigDecimal(0);
        this.rh_hsln_rct_paydt_year = new BigDecimal(0);
        this.rh_hsln_op_max_dt_year = new BigDecimal(0);
        this.rh_hsln_rct_paydt_month = new BigDecimal(0);
        this.rh_hsln_op_max_dt_month = new BigDecimal(0);
        this.rh_opln_rct_paydt_year = new BigDecimal(0);
        this.rh_oprln_op_max_dt_year = new BigDecimal(0);
        this.rh_opln_rct_paydt_month = new BigDecimal(0);
        this.rh_oprln_op_max_dt_month = new BigDecimal(0);
        this.rh_agln_rct_paydt_year = new BigDecimal(0);
        this.rh_agln_rct_paydt_month = new BigDecimal(0);
        this.rh_agln_op_max_dt_month = new BigDecimal(0);
    }

    /**
     * 属性赋值方法
     * 潘宇
     */
    public void initCustomerCardModelVo(BigDecimal rh_lncd_op_max_dt_timestamp, BigDecimal rh_lncd_op_old_dt_timestamp, BigDecimal rh_stlncd_op_max_dt_timestamp, BigDecimal rh_stlncd_op_old_dt_timestamp, BigDecimal rh_crc_op_max_dt_timestamp, BigDecimal rh_ln_op_max_dt_timestamp, BigDecimal rh_ln_rct_paydt_timestamp, BigDecimal rh_carln_rct_paydt_timestamp, BigDecimal rh_carln_op_max_dt_timestamp, BigDecimal rh_hsln_rct_paydt_timestamp, BigDecimal rh_hsln_op_max_dt_timestamp, BigDecimal rh_opln_rct_paydt_timestamp, BigDecimal rh_oprln_op_max_dt_timestamp, BigDecimal rh_agln_rct_paydt_timestamp, BigDecimal rh_agln_op_max_dt_timestamp, BigDecimal rh_ln_op_old_dt_timestamp, BigDecimal rh_ln_op_min_dt_timestamp, BigDecimal rh_lncd_op_min_dt_timestamp, BigDecimal rh_stlncd_op_min_dt_timestamp, BigDecimal rh_cr_op_min_dt_timestamp, BigDecimal rh_qy_max_dt_timestamp, BigDecimal rh_ln_op_max_dt_year, BigDecimal rh_ln_rct_paydt_year, BigDecimal rh_agln_op_max_dt_year, BigDecimal rh_ln_op_old_dt_year, BigDecimal rh_ln_op_min_dt_year, BigDecimal rh_lncd_op_min_dt_year, BigDecimal rh_qy_max_dt_year, BigDecimal rh_lncd_op_max_dt_month, BigDecimal rh_lncd_op_old_dt_month, BigDecimal rh_ln_rct_paydt_month, BigDecimal rh_ln_op_min_dt_month, BigDecimal rh_lncd_op_min_dt_month, BigDecimal rh_stlncd_op_min_dt_month, BigDecimal rh_qy_max_dt_month, BigDecimal rh_lncd_op_max_dt_day, BigDecimal rh_lncd_op_old_dt_day, BigDecimal rh_stlncd_op_max_dt_day, BigDecimal rh_stlncd_op_old_dt_day, BigDecimal rh_ln_op_max_dt_day, BigDecimal rh_ln_rct_paydt_day, BigDecimal rh_carln_op_max_dt_day, BigDecimal rh_hsln_rct_paydt_day, BigDecimal rh_hsln_op_max_dt_day, BigDecimal rh_opln_rct_paydt_day, BigDecimal rh_oprln_op_max_dt_day, BigDecimal rh_agln_op_max_dt_day, BigDecimal rh_ln_op_old_dt_day, BigDecimal rh_qy_max_dt_day, BigDecimal rh_lncd_op_max_dt_week, BigDecimal rh_lncd_op_old_dt_week, BigDecimal rh_stlncd_op_max_dt_week, BigDecimal rh_ln_op_max_dt_week, BigDecimal rh_ln_rct_paydt_week, BigDecimal rh_carln_op_max_dt_week, BigDecimal rh_hsln_rct_paydt_week, BigDecimal rh_oprln_op_max_dt_week, BigDecimal rh_agln_op_max_dt_week, BigDecimal rh_ln_op_old_dt_week, BigDecimal rh_qy_max_dt_week, BigDecimal rh_lncd_op_max_dt_year, BigDecimal rh_lncd_op_old_dt_year, BigDecimal rh_stlncd_op_max_dt_year, BigDecimal rh_stlncd_op_min_dt_year, BigDecimal rh_stlncd_op_old_dt_year, BigDecimal rh_stlncd_op_max_dt_month, BigDecimal rh_stlncd_op_old_dt_month, BigDecimal rh_crc_op_max_dt_year, BigDecimal rh_cr_op_min_dt_year, BigDecimal rh_crc_op_max_dt_month, BigDecimal rh_cr_op_min_dt_month, BigDecimal rh_ln_op_max_dt_month, BigDecimal rh_carln_rct_paydt_year, BigDecimal rh_carln_op_max_dt_year, BigDecimal rh_carln_rct_paydt_month, BigDecimal rh_carln_op_max_dt_month, BigDecimal rh_hsln_rct_paydt_year, BigDecimal rh_hsln_op_max_dt_year, BigDecimal rh_hsln_rct_paydt_month, BigDecimal rh_hsln_op_max_dt_month, BigDecimal rh_opln_rct_paydt_year, BigDecimal rh_oprln_op_max_dt_year, BigDecimal rh_opln_rct_paydt_month, BigDecimal rh_oprln_op_max_dt_month, BigDecimal rh_agln_rct_paydt_year, BigDecimal rh_agln_rct_paydt_month, BigDecimal rh_agln_op_max_dt_month) {
        this.rh_lncd_op_max_dt_timestamp = rh_lncd_op_max_dt_timestamp;
        this.rh_lncd_op_old_dt_timestamp = rh_lncd_op_old_dt_timestamp;
        this.rh_stlncd_op_max_dt_timestamp = rh_stlncd_op_max_dt_timestamp;
        this.rh_stlncd_op_old_dt_timestamp = rh_stlncd_op_old_dt_timestamp;
        this.rh_crc_op_max_dt_timestamp = rh_crc_op_max_dt_timestamp;
        this.rh_ln_op_max_dt_timestamp = rh_ln_op_max_dt_timestamp;
        this.rh_ln_rct_paydt_timestamp = rh_ln_rct_paydt_timestamp;
        this.rh_carln_rct_paydt_timestamp = rh_carln_rct_paydt_timestamp;
        this.rh_carln_op_max_dt_timestamp = rh_carln_op_max_dt_timestamp;
        this.rh_hsln_rct_paydt_timestamp = rh_hsln_rct_paydt_timestamp;
        this.rh_hsln_op_max_dt_timestamp = rh_hsln_op_max_dt_timestamp;
        this.rh_opln_rct_paydt_timestamp = rh_opln_rct_paydt_timestamp;
        this.rh_oprln_op_max_dt_timestamp = rh_oprln_op_max_dt_timestamp;
        this.rh_agln_rct_paydt_timestamp = rh_agln_rct_paydt_timestamp;
        this.rh_agln_op_max_dt_timestamp = rh_agln_op_max_dt_timestamp;
        this.rh_ln_op_old_dt_timestamp = rh_ln_op_old_dt_timestamp;
        this.rh_ln_op_min_dt_timestamp = rh_ln_op_min_dt_timestamp;
        this.rh_lncd_op_min_dt_timestamp = rh_lncd_op_min_dt_timestamp;
        this.rh_stlncd_op_min_dt_timestamp = rh_stlncd_op_min_dt_timestamp;
        this.rh_cr_op_min_dt_timestamp = rh_cr_op_min_dt_timestamp;
        this.rh_qy_max_dt_timestamp = rh_qy_max_dt_timestamp;
        this.rh_ln_op_max_dt_year = rh_ln_op_max_dt_year;
        this.rh_ln_rct_paydt_year = rh_ln_rct_paydt_year;
        this.rh_agln_op_max_dt_year = rh_agln_op_max_dt_year;
        this.rh_ln_op_old_dt_year = rh_ln_op_old_dt_year;
        this.rh_ln_op_min_dt_year = rh_ln_op_min_dt_year;
        this.rh_lncd_op_min_dt_year = rh_lncd_op_min_dt_year;
        this.rh_qy_max_dt_year = rh_qy_max_dt_year;
        this.rh_lncd_op_max_dt_month = rh_lncd_op_max_dt_month;
        this.rh_lncd_op_old_dt_month = rh_lncd_op_old_dt_month;
        this.rh_ln_rct_paydt_month = rh_ln_rct_paydt_month;
        this.rh_ln_op_min_dt_month = rh_ln_op_min_dt_month;
        this.rh_lncd_op_min_dt_month = rh_lncd_op_min_dt_month;
        this.rh_stlncd_op_min_dt_month = rh_stlncd_op_min_dt_month;
        this.rh_qy_max_dt_month = rh_qy_max_dt_month;
        this.rh_lncd_op_max_dt_day = rh_lncd_op_max_dt_day;
        this.rh_lncd_op_old_dt_day = rh_lncd_op_old_dt_day;
        this.rh_stlncd_op_max_dt_day = rh_stlncd_op_max_dt_day;
        this.rh_stlncd_op_old_dt_day = rh_stlncd_op_old_dt_day;
        this.rh_ln_op_max_dt_day = rh_ln_op_max_dt_day;
        this.rh_ln_rct_paydt_day = rh_ln_rct_paydt_day;
        this.rh_carln_op_max_dt_day = rh_carln_op_max_dt_day;
        this.rh_hsln_rct_paydt_day = rh_hsln_rct_paydt_day;
        this.rh_hsln_op_max_dt_day = rh_hsln_op_max_dt_day;
        this.rh_opln_rct_paydt_day = rh_opln_rct_paydt_day;
        this.rh_oprln_op_max_dt_day = rh_oprln_op_max_dt_day;
        this.rh_agln_op_max_dt_day = rh_agln_op_max_dt_day;
        this.rh_ln_op_old_dt_day = rh_ln_op_old_dt_day;
        this.rh_qy_max_dt_day = rh_qy_max_dt_day;
        this.rh_lncd_op_max_dt_week = rh_lncd_op_max_dt_week;
        this.rh_lncd_op_old_dt_week = rh_lncd_op_old_dt_week;
        this.rh_stlncd_op_max_dt_week = rh_stlncd_op_max_dt_week;
        this.rh_ln_op_max_dt_week = rh_ln_op_max_dt_week;
        this.rh_ln_rct_paydt_week = rh_ln_rct_paydt_week;
        this.rh_carln_op_max_dt_week = rh_carln_op_max_dt_week;
        this.rh_hsln_rct_paydt_week = rh_hsln_rct_paydt_week;
        this.rh_oprln_op_max_dt_week = rh_oprln_op_max_dt_week;
        this.rh_agln_op_max_dt_week = rh_agln_op_max_dt_week;
        this.rh_ln_op_old_dt_week = rh_ln_op_old_dt_week;
        this.rh_qy_max_dt_week = rh_qy_max_dt_week;
        this.rh_lncd_op_max_dt_year = rh_lncd_op_max_dt_year;
        this.rh_lncd_op_old_dt_year = rh_lncd_op_old_dt_year;
        this.rh_stlncd_op_max_dt_year = rh_stlncd_op_max_dt_year;
        this.rh_stlncd_op_min_dt_year = rh_stlncd_op_min_dt_year;
        this.rh_stlncd_op_old_dt_year = rh_stlncd_op_old_dt_year;
        this.rh_stlncd_op_max_dt_month = rh_stlncd_op_max_dt_month;
        this.rh_stlncd_op_old_dt_month = rh_stlncd_op_old_dt_month;
        this.rh_crc_op_max_dt_year = rh_crc_op_max_dt_year;
        this.rh_cr_op_min_dt_year = rh_cr_op_min_dt_year;
        this.rh_crc_op_max_dt_month = rh_crc_op_max_dt_month;
        this.rh_cr_op_min_dt_month = rh_cr_op_min_dt_month;
        this.rh_ln_op_max_dt_month = rh_ln_op_max_dt_month;
        this.rh_carln_rct_paydt_year = rh_carln_rct_paydt_year;
        this.rh_carln_op_max_dt_year = rh_carln_op_max_dt_year;
        this.rh_carln_rct_paydt_month = rh_carln_rct_paydt_month;
        this.rh_carln_op_max_dt_month = rh_carln_op_max_dt_month;
        this.rh_hsln_rct_paydt_year = rh_hsln_rct_paydt_year;
        this.rh_hsln_op_max_dt_year = rh_hsln_op_max_dt_year;
        this.rh_hsln_rct_paydt_month = rh_hsln_rct_paydt_month;
        this.rh_hsln_op_max_dt_month = rh_hsln_op_max_dt_month;
        this.rh_opln_rct_paydt_year = rh_opln_rct_paydt_year;
        this.rh_oprln_op_max_dt_year = rh_oprln_op_max_dt_year;
        this.rh_opln_rct_paydt_month = rh_opln_rct_paydt_month;
        this.rh_oprln_op_max_dt_month = rh_oprln_op_max_dt_month;
        this.rh_agln_rct_paydt_year = rh_agln_rct_paydt_year;
        this.rh_agln_rct_paydt_month = rh_agln_rct_paydt_month;
        this.rh_agln_op_max_dt_month = rh_agln_op_max_dt_month;
    }

    /**
     * 属性赋值方法
     * 张羽
     */
    public void initCustomerCardModelVo(String occupation, String duty, BigDecimal rh_bs_industry_mat, BigDecimal rh_lncd_nr_mn_cr_lmt, Integer rh_lncd_nr_min_cr_lmt, Integer rh_lncd_nr_min_sd_lmt, BigDecimal rh_lncd_min_ud_sd_lmt_pr, BigDecimal rh_lncd_nr_min_ud_sd_lmt_pr, BigDecimal rh_lncd_avg_curdef_amt,
                                        Integer rh_lncd_max_curdef_amt, Integer rh_lncd_ovd_ct_3y_rp, Integer rh_m24_lncd_ovd_max_perd, BigDecimal rh_lncd_nr_mn_cr_lmt_m6, Integer rh_lncd_lim_org_ds_num, Integer rh_stlncd_nr_sum_ud_cr_lmt, Integer rh_stlncd_nr_min_ud_cr_lmt, Integer rh_crc_uc_max_age, Integer rh_crc_ovd_ct_3y_rp,
                                        Integer rh_ln_num, Integer rh_ln_st_advp, Integer rh_ln_st_oth, Integer rh_ln_uc_max_age, String rh_if_houseln, BigDecimal rh_5state_good_pr, Integer rh_ln_ovd_cur_amt_rp, Integer rh_ln_ovd_max_2y_rp, Integer rh_carln_sum_amt, Integer rh_carln_st_adva, Integer rh_hsln_avg_bal, BigDecimal rh_hsln_min_bal_pr,
                                        BigDecimal rh_hsln_max_bal_pr, Integer rh_opln_nr_num, Integer rh_opln_max_amt, Integer rh_opln_max_bal, Integer rh_opln_avg_bal, Integer rh_opln_st_adva, Integer rh_agln_max_bal, Integer rh_hsln_sum_num, Integer rh_ln_ovd_dur, Integer rh_ln_corg_num, Integer rh_ln_org_num, Integer rh_lncd_ud_amt, BigDecimal rh_m6_lncd_ud_pro,
                                        Integer rh_cr_lim_amt, Integer rh_gr_sum_amt, Integer rh_gr_tol_bal, BigDecimal rh_cr_bal_pro, BigDecimal rh_crc_ud_pro, BigDecimal rh_ln_bal_pro, Integer rh_m6_cr_ovd_mon, Integer rh_m24_cr_ovd_mon, Integer rh_m12_cr_ovd_mon, Integer rh_cr_uc_min_age, Integer rh_ln_qy_lst_inte, Integer rh_ln_qy_fst_inte,
                                        Integer rh_crc_qy_fst_inte, Integer rh_cr_y2_qyf_num, Integer rh_ln_y2_qyf_num) {
        this.occupation = occupation;
        this.duty = duty;
        this.rh_bs_industry_mat = rh_bs_industry_mat;
        this.rh_lncd_nr_mn_cr_lmt = rh_lncd_nr_mn_cr_lmt;
        this.rh_lncd_nr_min_cr_lmt = rh_lncd_nr_min_cr_lmt;
        this.rh_lncd_nr_min_sd_lmt = rh_lncd_nr_min_sd_lmt;
        this.rh_lncd_min_ud_sd_lmt_pr = rh_lncd_min_ud_sd_lmt_pr;
        this.rh_lncd_nr_min_ud_sd_lmt_pr = rh_lncd_nr_min_ud_sd_lmt_pr;
        this.rh_lncd_avg_curdef_amt = rh_lncd_avg_curdef_amt;
        this.rh_lncd_max_curdef_amt = rh_lncd_max_curdef_amt;
        this.rh_lncd_ovd_ct_3y_rp = rh_lncd_ovd_ct_3y_rp;
        this.rh_m24_lncd_ovd_max_perd = rh_m24_lncd_ovd_max_perd;
        this.rh_lncd_nr_mn_cr_lmt_m6 = rh_lncd_nr_mn_cr_lmt_m6;
        this.rh_lncd_lim_org_ds_num = rh_lncd_lim_org_ds_num;
        this.rh_stlncd_nr_sum_ud_cr_lmt = rh_stlncd_nr_sum_ud_cr_lmt;
        this.rh_stlncd_nr_min_ud_cr_lmt = rh_stlncd_nr_min_ud_cr_lmt;
        this.rh_crc_uc_max_age = rh_crc_uc_max_age;
        this.rh_crc_ovd_ct_3y_rp = rh_crc_ovd_ct_3y_rp;
        this.rh_ln_num = rh_ln_num;
        this.rh_ln_st_advp = rh_ln_st_advp;
        this.rh_ln_st_oth = rh_ln_st_oth;
        this.rh_ln_uc_max_age = rh_ln_uc_max_age;
        this.rh_if_houseln = rh_if_houseln;
        this.rh_5state_good_pr = rh_5state_good_pr;
        this.rh_ln_ovd_cur_amt_rp = rh_ln_ovd_cur_amt_rp;
        this.rh_ln_ovd_max_2y_rp = rh_ln_ovd_max_2y_rp;
        this.rh_carln_sum_amt = rh_carln_sum_amt;
        this.rh_carln_st_adva = rh_carln_st_adva;
        this.rh_hsln_avg_bal = rh_hsln_avg_bal;
        this.rh_hsln_min_bal_pr = rh_hsln_min_bal_pr;
        this.rh_hsln_max_bal_pr = rh_hsln_max_bal_pr;
        this.rh_opln_nr_num = rh_opln_nr_num;
        this.rh_opln_max_amt = rh_opln_max_amt;
        this.rh_opln_max_bal = rh_opln_max_bal;
        this.rh_opln_avg_bal = rh_opln_avg_bal;
        this.rh_opln_st_adva = rh_opln_st_adva;
        this.rh_agln_max_bal = rh_agln_max_bal;
        this.rh_hsln_sum_num = rh_hsln_sum_num;
        this.rh_ln_ovd_dur = rh_ln_ovd_dur;
        this.rh_ln_corg_num = rh_ln_corg_num;
        this.rh_ln_org_num = rh_ln_org_num;
        this.rh_lncd_ud_amt = rh_lncd_ud_amt;
        this.rh_m6_lncd_ud_pro = rh_m6_lncd_ud_pro;
        this.rh_cr_lim_amt = rh_cr_lim_amt;
        this.rh_gr_sum_amt = rh_gr_sum_amt;
        this.rh_gr_tol_bal = rh_gr_tol_bal;
        this.rh_cr_bal_pro = rh_cr_bal_pro;
        this.rh_crc_ud_pro = rh_crc_ud_pro;
        this.rh_ln_bal_pro = rh_ln_bal_pro;
        this.rh_m6_cr_ovd_mon = rh_m6_cr_ovd_mon;
        this.rh_m24_cr_ovd_mon = rh_m24_cr_ovd_mon;
        this.rh_m12_cr_ovd_mon = rh_m12_cr_ovd_mon;
        this.rh_cr_uc_min_age = rh_cr_uc_min_age;
        this.rh_ln_qy_lst_inte = rh_ln_qy_lst_inte;
        this.rh_ln_qy_fst_inte = rh_ln_qy_fst_inte;
        this.rh_crc_qy_fst_inte = rh_crc_qy_fst_inte;
        this.rh_cr_y2_qyf_num = rh_cr_y2_qyf_num;
        this.rh_ln_y2_qyf_num = rh_ln_y2_qyf_num;
    }

}
