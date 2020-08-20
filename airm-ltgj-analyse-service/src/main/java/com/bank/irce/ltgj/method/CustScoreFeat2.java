package com.bank.irce.ltgj.method;

import com.alibaba.fastjson.JSONObject;
import com.bank.irce.ltgj.common.*;
import com.bank.irce.ltgj.entity.dto.CustCard2ResVo;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.bank.irce.ltgj.common.SimpleEncapsulationUtil.iteratorAttrByType;
import static java.lang.Integer.parseInt;
import static com.bank.irce.ltgj.entity.dto.ValidateConstant.*;
import static java.lang.Integer.parseInt;

public class CustScoreFeat2 {
    public static CustCard2ResVo handleSupplementCustomerCardTraits(JSONObject params) throws NoSuchFieldException, IllegalAccessException, ParseException {
        JSONObject jsonObject = new JSONObject((HashMap)params.get("ReportMessage"));
        CustCard2ResVo custCard2ResVo = new CustCard2ResVo();
        try {
            /**
             * 开发人员：张羽
             * 时间：2020.2.24
             */
            //具体加工逻辑
            String queryTimeString = iteratorAttrByType(jsonObject, VALUE_TYPE_DATE, "Header", "MessageHeader", "ReportCreateTime").toString();
            Date formatDate = new Date();
            //信用报告生成时间
            if (!VALUE_TYPE_DATE_DEFAULT_VALUE.equals(queryTimeString)) {
                Date parseDate = DateUtil.parseDate(queryTimeString, "yyyy-MM-dd");
                if (parseDate != null) {
                    formatDate = parseDate;
                }
            }

            Long yearTime = 360 * 24 * 60 * 60 * 1000L;
            Long sixMonths = 180 * 24 * 60 * 60 * 1000L;
            Map<String, Object> creditDetai = MapUtil.returnMap(jsonObject, "CreditDetail");
            Map<String, Object> personalInfo = MapUtil.returnMap(jsonObject, "PersonalInfo");
            Map<String, Object> overdueSummary = MapUtil.returnMap(jsonObject, "InfoSummary", "OverdueAndFellback", "OverdueSummary");
            Map<String, Object> shareAndDebt = MapUtil.returnMap(jsonObject, "InfoSummary", "ShareAndDebt");
            Map<String, Object> queryRecord = MapUtil.returnMap(jsonObject, "QueryRecord");
            Map<String, Object> loanSum = MapUtil.returnMap(overdueSummary, "LoanSum");
            Map<String, Object> loancardSum = MapUtil.returnMap(overdueSummary, "LoancardSum");
            Map<String, Object> standardLoancardSum = MapUtil.returnMap(overdueSummary, "StandardLoancardSum");
            Map<String, Object> query_recordInfo = MapUtil.returnMap(queryRecord, "RecordInfo");
            Map<String, Object> professional = MapUtil.returnMap(personalInfo, "Professional");
            //贷记卡集合
            Map<String, Object> loanCardList = MapUtil.returnMap(creditDetai, "Loancard");
            //准贷记卡集合
            Map<String, Object> standardLoancardList = MapUtil.returnMap(creditDetai, "StandardLoancard");
            //贷款集合
            Map<String, Object> loanMap = MapUtil.returnMap(creditDetai, "Loan");
            //查询记录集合
            Map<String, Object> query_recordDetail = MapUtil.returnMap(query_recordInfo, "RecordDetail");

            // todo occupation 职业信息
            String occupation = "";
            //工作职务
            String duty = "";
            // todo rh_bs_industry_mat 行业稳定性
            BigDecimal rh_bs_industry_mat = new BigDecimal(-99988);
            //定义开放的最大时长
            Long maxDataTime = 0L;
            BigDecimal minStartYear = new BigDecimal(Integer.MAX_VALUE);
            //行业
            Set<String> industrySet = new HashSet<>();
            List<String> getTimes = MapUtil.returnList(professional, "GetTime");
            List<String> industrys = MapUtil.returnList(professional, "Industry");
            List<String> dutys = MapUtil.returnList(professional, "Duty");
            List<String> occupations = MapUtil.returnList(professional, "Occupation");
            List<String> startYears = MapUtil.returnList(professional, "StartYear");
            //todo duty 遍历获取最近工作职务
            for (int i = 0; i < getTimes.size(); i++) {
                try {
                    String getTime = getTimes.get(i);
                    Date getTimedate = DateUtil.parseDate(getTime, "yyyy-MM-dd");
                    String industry = industrys.get(i);
                    if (!"".equals(industry)) {
                        industrySet.add(industry);
                    }
                    if (getTimedate != null) {
                        if (maxDataTime < getTimedate.getTime() && !StringUtils.isEmpty(occupations.get(i)) && ! VALUE_TYPE_STRING_DEFAULT_VALUE.equals(occupations.get(i))) {
                            maxDataTime = getTimedate.getTime();
                            occupation = occupations.get(i);
                            duty = dutys.get(i);
                        }
                    }
                    if(StringUtils.isBlank(startYears.get(i))){
                        continue;
                    }
                    BigDecimal startYear = new BigDecimal(startYears.get(i));
                    if (startYear.compareTo(new BigDecimal(0)) != 0 && minStartYear.compareTo(startYear) > 0) {
                        minStartYear = startYear;
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            if (industrySet.size() != 0 && queryTimeString.length() > 4) {
                rh_bs_industry_mat = new BigDecimal(queryTimeString.substring(0, 4)).subtract(minStartYear).divide(new BigDecimal(industrySet.size()), 2, RoundingMode.HALF_UP);
            }
            occupation = "".equals(occupation) ? "NaN" : occupation;
            duty = "".equals(duty) ? "NaN" : duty;


            // rh_lncd_nr_mn_cr_lmt 正常状态人民币账户贷记卡平均授信额度(所有正常状态账户平均)
            BigDecimal rh_lncd_nr_mn_cr_lmt = new BigDecimal(-99988);
            // 正常状态人民币账户贷记卡总授信额度
            Integer rh_lncd_sum_nr_cr_lmt = 0;
            //正常人民币贷记卡账户数
            int rh_lncd_nr_num = 0;
            //近6个月内信用卡成功机构数
            Set rh_crc_m6_qy_num_success = new HashSet();
            //近6个月贷款查询成功机构数
            Set rh_ln_m6_qy_num_success = new HashSet();
            // rh_lncd_nr_min_cr_lmt 正常状态人民币账户贷记卡最小授信额度
            Integer rh_lncd_nr_min_cr_lmt = Integer.MAX_VALUE;
            // rh_lncd_nr_min_sd_lmt 正常状态人民币账户贷记卡最小共享额度
            Integer rh_lncd_nr_min_sd_lmt = Integer.MAX_VALUE;
            //未销户人民币账户贷记卡最小已用共享额度比
            BigDecimal rh_lncd_min_ud_sd_lmt_pr = new BigDecimal(Integer.MAX_VALUE);
            // rh_lncd_nr_min_ud_sd_lmt_pr 正常状态人民币账户贷记卡最小已用共享额度比
            BigDecimal rh_lncd_nr_min_ud_sd_lmt_pr = new BigDecimal(Integer.MAX_VALUE);
            // rh_lncd_avg_curdef_amt 人民币未销户贷记卡当前逾期金额均值
            BigDecimal rh_lncd_avg_curdef_amt = new BigDecimal(-99988);
            //人民币未销户贷记卡当前逾期金额总和
            Integer rh_lncd_avg_curdef_amt_sum = 0;
            //人民币未销户贷记卡当前逾期账户数
            Integer rh_lncd_avg_curdef_amt_count = 0;
            // rh_lncd_max_curdef_amt 人民币未销户贷记卡当前逾期金额最大值
            Integer rh_lncd_max_curdef_amt = -99988;
            // rh_lncd_ovd_ct_3y_rp 贷记卡历史3-5年逾期月份数
            Integer rh_lncd_ovd_ct_3y_rp = 0;
            //贷记卡逾期月份数
            Integer rh_lncd_ovd_mon = Integer.valueOf(loancardSum.getOrDefault("Months", "0").toString());
            //贷记卡近2年内逾期月份数
            Integer rh_lncd_ovd_ct_2y_rp = 0;
            // rh_m24_lncd_ovd_max_perd 贷记卡近2年内最大逾期月份数
            Integer rh_m24_lncd_ovd_max_perd = 0;
            // rh_lncd_nr_mn_cr_lmt_m6 近6个月正常状态人民币账户贷记卡平均授信额度(所有正常状态账户平均)
            BigDecimal rh_lncd_nr_mn_cr_lmt_m6 = null;
            //近6个月正常人民币贷记卡账户数
            Integer rh_lncd_nr_num_m6 = 0;
            //近12个月未销户人民币贷记卡账户数
            Integer rh_lncd_uc_num_m12 = 0;
            //近12个月未销户人民币账户贷记卡总授信额度
            Integer rh_lncd_sum_cr_lmt_m12 = 0;
            //rh_lncd_lim_org_ds_num 正常状态贷记卡机构数
            Integer rh_lncd_lim_org_ds_num = 0;
            //机构数
            Set<String> financeOrgSet = new HashSet<>();
            // rh_stlncd_nr_sum_ud_cr_lmt 正常状态人民币账户准贷记卡总透支余额
            Integer rh_stlncd_nr_sum_ud_cr_lmt = 0;
            // rh_stlncd_nr_min_ud_cr_lmt 正常状态人民币账户准贷记卡最小透支余额
            Integer rh_stlncd_nr_min_ud_cr_lmt = Integer.MAX_VALUE;
            //未销户信用卡开立距今最大时长
            Integer rh_crc_uc_max_age = 0;
            // rh_crc_ovd_ct_3y_rp 信用卡历史3-5年逾期月份数
            Integer rh_crc_ovd_ct_3y_rp = 0;
            //准贷记卡60天以上透支月份数
            Integer rh_stlncd_nr_60_ud_cr_lmt = Integer.valueOf(iteratorAttrByType(standardLoancardSum, VALUE_TYPE_INT, "Months").toString());
            //准贷记卡近2年内逾期月份数
            Integer rh_stlncd_ovd_ct_2y_rp = 0;
            //rh_ln_num 贷款笔数（全部）
            Integer rh_ln_num = 0;
            //rh_ln_st_advp 特殊交易-提前还款（部分）次数
            Integer rh_ln_st_advp = 0;
            // rh_ln_st_oth 特殊交易-其他类型次数
            Integer rh_ln_st_oth = 0;
            //rh_ln_uc_max_age 未结清贷款开立距今最大时长
            Integer rh_ln_uc_max_age = 0;
            //rh_if_houseln 是否有房贷
            String rh_if_houseln = "0";
            //rh_5state_good_pr 贷款五级分类低风险占比
            BigDecimal rh_5state_good_pr = null;
            //贷款五级分类正常个数
            Integer rh_5state_good_count = 0;
            // rh_ln_ovd_cur_amt_rp贷款信息汇总当前逾期总额
            Integer rh_ln_ovd_cur_amt_rp = 0;
            //rh_ln_ovd_max_2y_rp 近2年内最大单账户贷款有逾期月份数
            Integer rh_ln_ovd_max_2y_rp = 0;
            //rh_carln_sum_amt 个人汽车未结清贷款总金额
            Integer rh_carln_sum_amt = 0;
            //rh_carln_st_adva 个人汽车贷款特殊交易-提前还款（全部）次数
            Integer rh_carln_st_adva = 0;
            //rh_hsln_avg_bal 个人住房未结清贷款平均余额
            Integer rh_hsln_avg_bal = 0;
            //个人住房未结清贷款总余额
            Integer rh_hsln_avg_bal_sum = 0;
            //个人住房未结清贷款数
            Integer rh_hsln_avg_bal_count = 0;
            //rh_hsln_min_bal_pr 个人住房未结清贷款最小余额比
            BigDecimal rh_hsln_min_bal_pr = new BigDecimal(Integer.MAX_VALUE);
            //rh_hsln_max_bal_pr 个人住房未结清贷款最大余额比
            BigDecimal rh_hsln_max_bal_pr = new BigDecimal(0);
            // rh_opln_nr_num 个人经营贷款正常笔数
            Integer rh_opln_nr_num = 0;
            //个人经营未结清贷款最大金额
            Integer rh_opln_max_amt = 0;
            //个人经营未结清贷款最大余额
            Integer rh_opln_max_bal = 0;
            //个人经营未结清贷款平均余额
            Integer rh_opln_avg_bal = 0;
            //个人经营未结清贷款总余额
            Integer rh_opln_avg_bal_sum = 0;
            //个人经营未结清贷款数
            Integer rh_opln_avg_bal_count = 0;
            // todo rh_opln_st_adva 个人经营贷款近12个月特殊交易-提前还款（全部）次数
            Integer rh_opln_st_adva = 0;
            // todo rh_agln_max_bal 个人农户未结清贷款最大余额
            Integer rh_agln_max_bal = 0;
            // todo rh_hsln_sum_num 征信报告上光大银行住房贷款（含公积金贷款）笔数
            Integer rh_hsln_sum_num = 0;
            // todo rh_ln_ovd_dur 贷款逾期最长逾期月数
            Integer rh_ln_ovd_dur = Integer.valueOf(iteratorAttrByType(loanSum, VALUE_TYPE_INT, "MaxDuration").toString());

            // todo rh_m6_cr_ovd_mon 过去6个月所有产品有过逾期的月数
            Integer rh_m6_cr_ovd_mon = 0;
            // todo rh_m24_cr_ovd_mon 过去24个月所有产品有过逾期的月数
            Integer rh_m24_cr_ovd_mon = 0;
            // todo rh_m12_cr_ovd_mon 过去12个月所有产品有过逾期的月数
            Integer rh_m12_cr_ovd_mon = 0;
            // todo rh_cr_uc_min_age 未结清所有产品开立距今最小时长
            Integer rh_cr_uc_min_age = Integer.MAX_VALUE;

            //近两年内贷款机构数
            Set<String> loan_num = new HashSet<>();
            //近两年内贷记卡机构数
            Set<String> loanCard_num = new HashSet<>();
            //近两年内准贷记卡机构数
            Set<String> standardLoancard_num = new HashSet<>();

            //近12个月内信用卡成功机构数
            Set rh_crc_m12_qy_num_success = new HashSet();
            //近2年内信用卡成功机构数
            Set rh_crc_y2_qy_num_success = new HashSet();

            Map<String, Object> loanCard_latest24MonthPaymentState = MapUtil.returnMap(loanCardList, "Latest24MonthPaymentState");
            Map<String, Object> loanCard_currOverdue = MapUtil.returnMap(loanCardList, "CurrOverdue");
            Map<String, Object> loanCard_awardCreditInfo = MapUtil.returnMap(loanCardList, "AwardCreditInfo");
            Map<String, Object> loanCard_repayInfo = MapUtil.returnMap(loanCardList, "RepayInfo");
            List<String> loanCard_states = MapUtil.returnList(loanCardList, "State");
            List<String> loanCard_latest24States = MapUtil.returnList(loanCard_latest24MonthPaymentState, "Latest24State");
            List<String> loanCard_currOverdueAmounts = MapUtil.returnList(loanCard_currOverdue, "CurrOverdueAmount");
            List<String> loanCard_financeOrgs = MapUtil.returnList(loanCard_awardCreditInfo, "FinanceOrg");
            List<String> loanCard_creditLimitAmounts = MapUtil.returnList(loanCard_awardCreditInfo, "CreditLimitAmount");
            List<String> loanCard_openDates = MapUtil.returnList(loanCard_awardCreditInfo, "OpenDate");
            List<String> loanCard_currencys = MapUtil.returnList(loanCard_awardCreditInfo, "Currency");
            List<String> loanCard_shareCreditLimitAmounts = MapUtil.returnList(loanCard_repayInfo, "ShareCreditLimitAmount");
            List<String> loanCard_usedCreditLimitAmounts = MapUtil.returnList(loanCard_repayInfo, "UsedCreditLimitAmount");
            for (int i = 0; i < loanCard_states.size(); i++) {
                try {
                    //账户状态
                    String state = loanCard_states.get(i);
                    //币种
                    String currency = loanCard_currencys.get(i);
                    //授信额度
                    Integer creditLimitAmount = Integer.valueOf(loanCard_creditLimitAmounts.get(i).toString());
                    //共享额度
                    Integer shareCreditLimitAmount = Integer.valueOf(loanCard_shareCreditLimitAmounts.get(i).toString());
                    //已用额度
                    Integer usedCreditLimitAmount = Integer.valueOf(loanCard_usedCreditLimitAmounts.get(i).toString());
                    //当前逾期金额
                    Integer currOverdueAmount = Integer.valueOf(String.valueOf(loanCard_currOverdueAmounts.get(i)));
                    //发卡时间
                    String openDate = loanCard_openDates.get(i);
                    Date openDateTime = DateUtil.parseDate(openDate, "yyyy-MM-dd");
                    //机构
                    String financeOrg = loanCard_financeOrgs.get(i);
                    //还款状态
                    String latest24State = loanCard_latest24States.get(i);

                    if (DateUtil.getMothDiff(formatDate, openDateTime) <= 24) {
                        rh_crc_y2_qy_num_success.add(financeOrg);
                        if (!"".equals(financeOrg)) loanCard_num.add(financeOrg);
                    }
                    if (DateUtil.getMothDiff(formatDate, openDateTime) <= 12) {
                        rh_crc_m12_qy_num_success.add(financeOrg);
                    }
                    if (DateUtil.getMothDiff(formatDate, openDateTime) <= 6) {
                        rh_crc_m6_qy_num_success.add(financeOrg);
                    }
                    if ("1".equals(state)) {
                        if (creditLimitAmount > 1) {
                            financeOrgSet.add(financeOrg);
                        }
                        if ("CNY".equals(currency)) {
                            rh_lncd_nr_num++;
                            if (shareCreditLimitAmount != 0) {
                                BigDecimal min_rh_lncd_nr_min_ud_sd_lmt_pr = new BigDecimal(usedCreditLimitAmount).divide(new BigDecimal(shareCreditLimitAmount), 2, RoundingMode.HALF_UP);
                                if (rh_lncd_nr_min_ud_sd_lmt_pr.compareTo(min_rh_lncd_nr_min_ud_sd_lmt_pr) > 0)
                                    rh_lncd_nr_min_ud_sd_lmt_pr = min_rh_lncd_nr_min_ud_sd_lmt_pr;
                            }
                            if (formatDate.getTime() - openDateTime.getTime() < sixMonths) {
                                rh_lncd_sum_nr_cr_lmt += creditLimitAmount;
                                rh_lncd_nr_num_m6++;
                            }
                            if (rh_lncd_nr_min_cr_lmt > creditLimitAmount) {
                                rh_lncd_nr_min_cr_lmt = creditLimitAmount;
                            }
                            if (rh_lncd_nr_min_sd_lmt > shareCreditLimitAmount) {
                                rh_lncd_nr_min_sd_lmt = shareCreditLimitAmount;
                            }
                        }
                    }
                    if (!"4".equals(state)) {
                        if ("CNY".equals(currency)) {
                            if (shareCreditLimitAmount != 0) {
                                BigDecimal min_rh_lncd_min_ud_sd_lmt_pr = new BigDecimal(usedCreditLimitAmount).divide(new BigDecimal(shareCreditLimitAmount), 2, RoundingMode.HALF_UP);
                                if (rh_lncd_min_ud_sd_lmt_pr.compareTo(min_rh_lncd_min_ud_sd_lmt_pr) > 0)
                                    rh_lncd_min_ud_sd_lmt_pr = min_rh_lncd_min_ud_sd_lmt_pr;
                            }
                            if (formatDate.getTime() - openDateTime.getTime() < yearTime) {
                                rh_lncd_sum_cr_lmt_m12 += creditLimitAmount;
                                rh_lncd_uc_num_m12++;
                            }
                            rh_lncd_avg_curdef_amt_sum += currOverdueAmount;
                            rh_lncd_avg_curdef_amt_count++;
                            if (rh_lncd_max_curdef_amt < currOverdueAmount) {
                                rh_lncd_max_curdef_amt = currOverdueAmount;
                            }
                        }
                        if (!"6".equals(state)) {
                            if (latest24State != null && latest24State.length() == 24) {
                                for (int j = 0; j < latest24State.length(); j++) {
                                    if (latest24State.charAt(j) >= 49 && latest24State.charAt(j) <= 55) {
                                        rh_lncd_ovd_ct_2y_rp++;
                                        if (Integer.valueOf(String.valueOf(latest24State.charAt(j))) > rh_m24_lncd_ovd_max_perd) {
                                            rh_m24_lncd_ovd_max_perd = Integer.valueOf(String.valueOf(latest24State.charAt(j)));
                                        }
                                    }
                                }
                            }
                            if (DateUtil.getMothDiff(formatDate, openDateTime) > rh_crc_uc_max_age) {
                                rh_crc_uc_max_age = DateUtil.getMothDiff(formatDate, openDateTime);
                            }
                            if (!"3".equals(state)) {
                                if (latest24State != null && latest24State.length() == 24) {
                                    for (int j = 0; j < latest24State.length(); j++) {
                                        if (latest24State.charAt(j) >= 49 && latest24State.charAt(j) <= 55) {
                                            if (j >= 12) {
                                                rh_m12_cr_ovd_mon++;
                                            }
                                            if (j >= 18) {
                                                rh_m6_cr_ovd_mon++;
                                            }
                                            rh_m24_cr_ovd_mon++;
                                        }
                                    }
                                }
                                if (DateUtil.getMothDiff(formatDate, openDateTime) < rh_cr_uc_min_age) {
                                    rh_cr_uc_min_age = DateUtil.getMothDiff(formatDate, openDateTime);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            try {
                if (rh_lncd_nr_num != 0) {
                    rh_lncd_nr_mn_cr_lmt = new BigDecimal(rh_lncd_sum_nr_cr_lmt).divide(new BigDecimal(rh_lncd_nr_num), 2, RoundingMode.HALF_UP);
                }
                if (rh_lncd_avg_curdef_amt_count != 0) {
                    rh_lncd_avg_curdef_amt = new BigDecimal(rh_lncd_avg_curdef_amt_sum).divide(new BigDecimal(rh_lncd_avg_curdef_amt_count), 2, RoundingMode.HALF_UP);
                }
                if (rh_lncd_nr_num_m6 != 0) {
                    rh_lncd_nr_mn_cr_lmt_m6 = new BigDecimal(rh_lncd_sum_nr_cr_lmt).divide(new BigDecimal(rh_lncd_nr_num_m6), 2, RoundingMode.HALF_UP);
                } else {
                    rh_lncd_nr_mn_cr_lmt_m6 = new BigDecimal(0);
                }
                if (rh_lncd_ovd_mon == 0 || rh_lncd_ovd_mon < rh_lncd_ovd_ct_2y_rp) {
                    rh_lncd_ovd_ct_3y_rp = -99988;
                } else {
                    rh_lncd_ovd_ct_3y_rp = rh_lncd_ovd_mon - rh_lncd_ovd_ct_2y_rp;
                }
                rh_lncd_lim_org_ds_num = financeOrgSet.contains("") ? financeOrgSet.size() - 1 : financeOrgSet.size();
                rh_lncd_nr_min_cr_lmt = rh_lncd_nr_min_cr_lmt == Integer.MAX_VALUE ? -99988 : rh_lncd_nr_min_cr_lmt;
                rh_lncd_nr_min_sd_lmt = rh_lncd_nr_min_sd_lmt == Integer.MAX_VALUE ? -99988 : rh_lncd_nr_min_sd_lmt;
                rh_lncd_min_ud_sd_lmt_pr = rh_lncd_min_ud_sd_lmt_pr.compareTo(new BigDecimal(Integer.MAX_VALUE)) == 0 ? new BigDecimal(-99988) : rh_lncd_min_ud_sd_lmt_pr;
                rh_lncd_nr_min_ud_sd_lmt_pr = rh_lncd_nr_min_ud_sd_lmt_pr.compareTo(new BigDecimal(Integer.MAX_VALUE)) == 0 ? new BigDecimal(-99988) : rh_lncd_nr_min_ud_sd_lmt_pr;
                custCard2ResVo.setRh_lncd_uc_num_m12(rh_lncd_uc_num_m12);
                custCard2ResVo.setRh_lncd_sum_cr_lmt_m12(rh_lncd_sum_cr_lmt_m12);
            } catch (Exception e) {
                LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
            }
            Map<String, Object> standardLoancard_latest24MonthPaymentState = MapUtil.returnMap(standardLoancardList, "Latest24MonthPaymentState");
            Map<String, Object> standardLoancard_awardCreditInfo = MapUtil.returnMap(standardLoancardList, "AwardCreditInfo");
            Map<String, Object> standardLoancard_repayInfo = MapUtil.returnMap(standardLoancardList, "RepayInfo");
            List<String> standardLoancard_states = MapUtil.returnList(standardLoancardList, "State");
            List<String> standardLoancard_latest24States = MapUtil.returnList(standardLoancard_latest24MonthPaymentState, "Latest24State");
            List<String> standardLoancard_financeOrgs = MapUtil.returnList(standardLoancard_awardCreditInfo, "FinanceOrg");
            List<String> standardLoancard_openDates = MapUtil.returnList(standardLoancard_awardCreditInfo, "OpenDate");
            List<String> standardLoancard_currencys = MapUtil.returnList(standardLoancard_awardCreditInfo, "Currency");
            List<String> standardLoancard_usedCreditLimitAmounts = MapUtil.returnList(standardLoancard_repayInfo, "UsedCreditLimitAmount");
            for (int i = 0; i < standardLoancard_states.size(); i++) {
                try {
                    int between = DateUtil.getMothDiff(formatDate, DateUtil.parseDate(standardLoancard_openDates.get(i), "yyyy-MM-dd"));
                    //账户状态
                    String state = standardLoancard_states.get(i);
                    //币种
                    String currency = standardLoancard_currencys.get(i);
                    //透支余额
                    Integer usedCreditLimitAmount = Integer.valueOf(standardLoancard_usedCreditLimitAmounts.get(i).toString());
                    //发卡时间
                    String openDate = standardLoancard_openDates.get(i);
                    Date openDateTime = DateUtil.parseDate(openDate, "yyyy-MM-dd");

                    String latest24State = standardLoancard_latest24States.get(i);
                    //机构
                    String financeOrg = standardLoancard_financeOrgs.get(i);
                    if (DateUtil.getMothDiff(formatDate, openDateTime) <= 24) {
                        rh_crc_y2_qy_num_success.add(financeOrg);
                        if (!"".equals(financeOrg)) standardLoancard_num.add(financeOrg);
                    }
                    if (DateUtil.getMothDiff(formatDate, openDateTime) <= 12) {
                        rh_crc_m12_qy_num_success.add(financeOrg);
                    }
                    if (between <= sixMonths) {
                        rh_crc_m6_qy_num_success.add(financeOrg);
                    }
                    if ("1".equals(state) && "CNY".equals(currency)) {
                        rh_stlncd_nr_sum_ud_cr_lmt += usedCreditLimitAmount;
                        if (rh_stlncd_nr_min_ud_cr_lmt > usedCreditLimitAmount) {
                            rh_stlncd_nr_min_ud_cr_lmt = usedCreditLimitAmount;
                        }
                    }
                    if (!"4".equals(state)) {
                        if (!"6".equals(state)) {
                            if (latest24State != null && latest24State.length() == 24) {
                                for (int j = 0; j < latest24State.length(); j++) {
                                    if (latest24State.charAt(j) >= 49 && latest24State.charAt(j) <= 55) {
                                        rh_stlncd_ovd_ct_2y_rp++;
                                    }
                                }
                            }
                            if (DateUtil.getMothDiff(formatDate, openDateTime) > rh_crc_uc_max_age) {
                                rh_crc_uc_max_age = DateUtil.getMothDiff(formatDate, openDateTime);
                            }
                            if (!"3".equals(state)) {
                                if (latest24State != null && latest24State.length() == 24) {
                                    for (int j = 0; j < latest24State.length(); j++) {
                                        if (latest24State.charAt(j) >= 49 && latest24State.charAt(j) <= 55) {
                                            if (j >= 12) {
                                                rh_m12_cr_ovd_mon++;
                                            }
                                            if (j >= 18) {
                                                rh_m6_cr_ovd_mon++;
                                            }
                                            rh_m24_cr_ovd_mon++;
                                        }
                                    }
                                }
                                if (DateUtil.getMothDiff(formatDate, openDateTime) < rh_cr_uc_min_age) {
                                    rh_cr_uc_min_age = DateUtil.getMothDiff(formatDate, openDateTime);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());
                }
            }
            rh_crc_ovd_ct_3y_rp = rh_lncd_ovd_mon + rh_stlncd_nr_60_ud_cr_lmt - (rh_lncd_ovd_ct_2y_rp + rh_stlncd_ovd_ct_2y_rp);
            rh_stlncd_nr_min_ud_cr_lmt = rh_stlncd_nr_min_ud_cr_lmt == Integer.MAX_VALUE ? -99988 : rh_stlncd_nr_min_ud_cr_lmt;

            Map<String, Object> loan_contractInfo = MapUtil.returnMap(loanMap, "ContractInfo");
            Map<String, Object> loan_specialTrade = MapUtil.returnMap(loanMap, "SpecialTrade");
            Map<String, Object> loan_latest24MonthPaymentState = MapUtil.returnMap(loanMap, "Latest24MonthPaymentState");
            Map<String, Object> loan_currOverdue = MapUtil.returnMap(loanMap, "CurrOverdue");
            Map<String, Object> loan_currAccountInfo = MapUtil.returnMap(loanMap, "CurrAccountInfo");
            List<String> loan_states = MapUtil.returnList(loanMap, "State");
            List<String> loan_specialTradetypes = MapUtil.returnList(loan_specialTrade, "Type");
            List<String> loan_openDates = MapUtil.returnList(loan_contractInfo, "OpenDate");
            List<String> loan_endDates = MapUtil.returnList(loan_contractInfo, "EndDate");
            List<String> loan_paymentRatings = MapUtil.returnList(loan_contractInfo, "PaymentRating");
            List<String> loan_contractInfoTypes = MapUtil.returnList(loan_contractInfo, "Type");
            List<String> loan_creditLimitAmounts = MapUtil.returnList(loan_contractInfo, "CreditLimitAmount");
            List<String> loan_financeOrgs = MapUtil.returnList(loan_contractInfo, "FinanceOrg");
            List<String> recentPayDates = MapUtil.returnList(loan_currAccountInfo, "RecentPayDate");
            List<String> loan_class5States = MapUtil.returnList(loan_currAccountInfo, "Class5State");
            List<String> loan_remainPaymentCycs = MapUtil.returnList(loan_currAccountInfo, "RemainPaymentCyc");
            List<String> loan_scheduledPaymentAmounts = MapUtil.returnList(loan_currAccountInfo, "ScheduledPaymentAmount");
            List<String> loan_balances = MapUtil.returnList(loan_currAccountInfo, "Balance");
            List<String> loan_latest24States = MapUtil.returnList(loan_latest24MonthPaymentState, "Latest24State");
            List<String> loan_currOverdueAmounts = MapUtil.returnList(loan_currOverdue, "CurrOverdueAmount");
            rh_ln_num = loan_states.size();
            //五级分类在文档中的
            int class5typeCount = 0;
            //近12个月贷款查询成功机构数
            Set rh_ln_m12_qy_num_success = new HashSet();
            //近2年内贷款查询成功机构数
            Set rh_ln_y2_qy_num_success = new HashSet();
            for (int i = 0; i < loan_states.size(); i++) {
                try {
                    int between = DateUtil.getMothDiff(formatDate, DateUtil.parseDate(loan_openDates.get(i), "yyyy-MM-dd"));
                    String loanState = loan_states.get(i);
                    if (!"".equals(loan_specialTradetypes.get(i))) {
                        String[] specialTradetype = loan_specialTradetypes.get(i).split("-");
                        for (int j = 0; j < specialTradetype.length; j++) {
                            if ("4".equals(specialTradetype[j])) {
                                rh_ln_st_advp++;
                            } else if ("9".equals(specialTradetype[j])) {
                                rh_ln_st_oth++;
                            } else if ("5".equals(specialTradetype[j])) {
                                if ("21".equals(loan_contractInfoTypes.get(i))) {
                                    rh_carln_st_adva++;
                                } else if ("41".equals(loan_contractInfoTypes.get(i))) {
                                    rh_opln_st_adva++;
                                }
                            }
                        }
                    }
                    String openDate = loan_openDates.get(i);
                    Date openDateTime = DateUtil.parseDate(openDate, "yyyy-MM-dd");
                    String contractInfoType = loan_contractInfoTypes.get(i);
                    String class5State = loan_class5States.get(i);
                    Integer currOverdueAmount = Integer.valueOf(loan_currOverdueAmounts.get(i));
                    rh_ln_ovd_cur_amt_rp += currOverdueAmount;
                    String latest24State = loan_latest24States.get(i);
                    Integer creditLimitAmount = Integer.valueOf(loan_creditLimitAmounts.get(i));
                    //逾期月份数
                    Integer count = 0;
                    Integer balance = Integer.valueOf(loan_balances.get(i));
                    //本金余额/合同金额
                    BigDecimal creditBalancePr = new BigDecimal(0);
                    String financeOrg = loan_financeOrgs.get(i);
                    if (DateUtil.getMothDiff(formatDate, openDateTime) <= 24) {
                        if (!"".equals(financeOrg)) {
                            loan_num.add(financeOrg);
                        }
                    }
                    if (between <= 6) {
                        rh_ln_m6_qy_num_success.add(financeOrg);
                    }
                    if (between <= 12) {
                        rh_ln_m12_qy_num_success.add(financeOrg);
                    }
                    if (between <= 24) {
                        rh_ln_y2_qy_num_success.add(financeOrg);
                    }
                    if ("1".equals(loanState)) {
                        if ("41".equals(contractInfoType)) {
                            rh_opln_nr_num++;
                        }
                    }
                    if (!"3".equals(loanState)) {
                        if (DateUtil.getMothDiff(formatDate, openDateTime) > rh_ln_uc_max_age) {
                            rh_ln_uc_max_age = DateUtil.getMothDiff(formatDate, openDateTime);
                        }
                        if (!"5".equals(loanState)) {
                            if (!"4".equals(loanState)) {
                                if (latest24State != null && latest24State.length() == 24) {
                                    for (int j = 0; j < latest24State.length(); j++) {
                                        if (latest24State.charAt(j) >= 49 && latest24State.charAt(j) <= 55) {
                                            if ((latest24State.charAt(j) - 48) > count) {
                                                count = latest24State.charAt(j) - 48;
                                            }
                                        }
                                    }
                                    if (rh_ln_ovd_max_2y_rp < count) {
                                        rh_ln_ovd_max_2y_rp = count;
                                    }
                                }
                            }
                        }
                        if ("21".equals(contractInfoType)) {
                            rh_carln_sum_amt += creditLimitAmount;
                        } else if ("11".equals(contractInfoType) || "12".equals(contractInfoType) || "13".equals(contractInfoType)) {
                            rh_hsln_avg_bal_sum += balance;
                            rh_hsln_avg_bal_count++;
                            if (creditLimitAmount != 0) {
                                creditBalancePr = new BigDecimal(balance).divide(new BigDecimal(creditLimitAmount), 2, RoundingMode.HALF_UP);
                            }
                            if (creditBalancePr.compareTo(rh_hsln_min_bal_pr) < 0) {
                                rh_hsln_min_bal_pr = creditBalancePr;
                            }
                            if (creditBalancePr.compareTo(rh_hsln_max_bal_pr) > 0) {
                                rh_hsln_max_bal_pr = creditBalancePr;
                            }
                        } else if ("41".equals(contractInfoType)) {
                            if (creditLimitAmount > rh_opln_max_amt) {
                                rh_opln_max_amt = creditLimitAmount;
                            }
                            if (balance > rh_opln_max_bal) {
                                rh_opln_max_bal = balance;
                            }
                            rh_opln_avg_bal_sum += balance;
                            rh_opln_avg_bal_count++;
                        } else if ("51".equals(contractInfoType)) {
                            if (balance > rh_agln_max_bal) {
                                rh_agln_max_bal = balance;
                            }
                        }
                        if ("11".equals(contractInfoType) || "13".equals(contractInfoType)) {
                            if (financeOrg.contains("中国光大银行")) {
                                rh_hsln_sum_num++;
                            }
                        }
                        if (!"4".equals(loanState)) {
                            if (!"6".equals(loanState)) {
                                if (latest24State != null && latest24State.length() == 24) {
                                    for (int j = 0; j < latest24State.length(); j++) {
                                        if (latest24State.charAt(j) >= 49 && latest24State.charAt(j) <= 55) {
                                            if (j >= 12) {
                                                rh_m12_cr_ovd_mon++;
                                            }
                                            if (j >= 18) {
                                                rh_m6_cr_ovd_mon++;
                                            }
                                            rh_m24_cr_ovd_mon++;
                                        }
                                    }
                                }
                                if (DateUtil.getMothDiff(formatDate, openDateTime) < rh_cr_uc_min_age) {
                                    rh_cr_uc_min_age = DateUtil.getMothDiff(formatDate, openDateTime);
                                }
                            }
                        }
                    }
                    if (contractInfoType.length() >= 2) {
                        if ("11".equals(contractInfoType.substring(0, 2)) || "12".equals(contractInfoType.substring(0, 2)) || "13".equals(contractInfoType.substring(0, 2))) {
                            rh_if_houseln = "1";
                        }
                    }
                    if ("1".equals(class5State)) {
                        rh_5state_good_count++;
                    }
                    if (!"".equals(class5State) && "123459".contains(class5State)) {
                        class5typeCount++;
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            if (class5typeCount == 0) {
                rh_5state_good_pr = new BigDecimal(-99988);
            } else {
                rh_5state_good_pr = new BigDecimal(rh_5state_good_count).divide(new BigDecimal(class5typeCount), 2, RoundingMode.HALF_UP);
            }
            if (rh_hsln_avg_bal_count != 0) {
                rh_hsln_avg_bal = rh_hsln_avg_bal_sum / rh_hsln_avg_bal_count;
            }
            if (rh_opln_avg_bal_count != 0) {
                rh_opln_avg_bal = rh_opln_avg_bal_sum / rh_opln_avg_bal_count;
            }
            Map<String, Object> unpaidLoan = MapUtil.returnMap(shareAndDebt, "UnpaidLoan");
            Map<String, Object> undestoryLoancard = MapUtil.returnMap(shareAndDebt, "UndestoryLoancard");
            Map<String, Object> undestoryStandardLoancard = MapUtil.returnMap(shareAndDebt, "UndestoryStandardLoancard");
            Map<String, Object> guaranteeSummary = MapUtil.returnMap(shareAndDebt, "GuaranteeSummary");
            //todo rh_ln_corg_num 贷款汇总_法人机构数
            Integer rh_ln_corg_num = Integer.valueOf(unpaidLoan.getOrDefault("FinanceCorpCount", "-99988").toString());
            //todo rh_ln_org_num 未结清贷款发放机构个数
            Integer rh_ln_org_num = Integer.valueOf(unpaidLoan.getOrDefault("FinanceOrgCount", "-99988").toString());
            //todo rh_lncd_ud_amt 未销户贷记卡总使用额度
            Integer rh_lncd_ud_amt = Integer.valueOf(undestoryLoancard.getOrDefault("UsedCreditLimit", "-99988").toString());
            //todo rh_m6_lncd_ud_pro 未销户贷记卡汇总_最近6个月平均额度使用率
            BigDecimal rh_m6_lncd_ud_pro = new BigDecimal(-99988);
            //贷记卡最近6个月平均使用额度
            Integer latest6MonthUsedAvgAmount = Integer.valueOf(undestoryLoancard.getOrDefault("Latest6MonthUsedAvgAmount", "0").toString());
            //贷记卡授信总额
            Integer creditLimit = Integer.valueOf(undestoryLoancard.getOrDefault("CreditLimit", "0").toString());
            if (creditLimit > 0) {
                rh_m6_lncd_ud_pro = new BigDecimal(latest6MonthUsedAvgAmount).divide(new BigDecimal(creditLimit), 2, RoundingMode.HALF_UP);
            }
            //todo rh_cr_lim_amt 信贷产品_授信总额
            Integer rh_cr_lim_amt = Integer.valueOf(unpaidLoan.getOrDefault("CreditLimit", "0").toString()) + Integer.valueOf(undestoryLoancard.getOrDefault("CreditLimit", "0").toString()) + Integer.valueOf(undestoryStandardLoancard.getOrDefault("CreditLimit", "0").toString());
            //todo rh_gr_sum_amt 担保总金额
            Integer rh_gr_sum_amt = Integer.valueOf(guaranteeSummary.getOrDefault("Amount", "0").toString());
            //todo rh_gr_tol_bal 担保余额
            Integer rh_gr_tol_bal = Integer.valueOf(guaranteeSummary.getOrDefault("Balance", "0").toString());
            //todo rh_cr_bal_pro 银行信贷汇总余额/授信金额（未销户）
            BigDecimal rh_cr_bal_pro = new BigDecimal(-99988);
            //银行信贷汇总余额
            Integer bankBalance_sum = Integer.valueOf(undestoryLoancard.getOrDefault("UsedCreditLimit", "0").toString()) + Integer.valueOf(undestoryStandardLoancard.getOrDefault("UsedCreditLimit", "0").toString()) + Integer.valueOf(unpaidLoan.getOrDefault("Balance", "0").toString());
            if (rh_cr_lim_amt != 0) {
                rh_cr_bal_pro = new BigDecimal(bankBalance_sum).divide(new BigDecimal(rh_cr_lim_amt), 2, RoundingMode.HALF_UP);
            }
            //todo rh_crc_ud_pro 信用卡汇总_透支余额/信用额度（未销户）
            BigDecimal rh_crc_ud_pro = new BigDecimal(-99988);
            //信用卡汇总_透支余额
            Integer rh_crc_ud_pro_usedCreditLimit_sum = Integer.valueOf(undestoryLoancard.getOrDefault("UsedCreditLimit", "0").toString()) + Integer.valueOf(undestoryStandardLoancard.getOrDefault("UsedCreditLimit", "0").toString());
            //信用卡授信总额
            Integer rh_crc_ud_pro_card_sum = Integer.valueOf(undestoryLoancard.getOrDefault("CreditLimit", "0").toString()) + Integer.valueOf(undestoryStandardLoancard.getOrDefault("CreditLimit", "0").toString());
            if (rh_crc_ud_pro_card_sum != 0) {
                rh_crc_ud_pro = new BigDecimal(rh_crc_ud_pro_usedCreditLimit_sum).divide(new BigDecimal(rh_crc_ud_pro_card_sum), 2, RoundingMode.HALF_UP);
            }
            //todo rh_ln_bal_pro 贷款汇总_贷款余额/合同金额
            BigDecimal rh_ln_bal_pro = new BigDecimal(-99988);
            //合同金额
            Integer loan_creditLimit = Integer.valueOf(unpaidLoan.getOrDefault("CreditLimit", "0").toString());
            //贷款汇总_贷款余额
            Integer loan_balance = Integer.valueOf(unpaidLoan.getOrDefault("Balance", "0").toString());
            if (loan_creditLimit != 0) {
                rh_ln_bal_pro = new BigDecimal(loan_balance).divide(new BigDecimal(loan_creditLimit), 2, RoundingMode.HALF_UP);
            }
            //todo rh_ln_qy_lst_inte 近2年内贷款审批最晚查询时间距本次申请的时间间隔
            Integer rh_ln_qy_lst_inte = Integer.MAX_VALUE;
            //todo rh_ln_qy_fst_inte 近2年内贷款审批最早查询时间距本次申请的时间间隔
            Integer rh_ln_qy_fst_inte = 0;
            //todo rh_crc_qy_fst_inte 近2年内信用卡审批最早查询时间距本次申请的时间间隔
            Integer rh_crc_qy_fst_inte = 0;
            //todo rh_cr_y2_qyf_num 近2年内信贷产品查询失败次数
            Integer rh_cr_y2_qyf_num;
            //近2年内贷款查询失败次数
            Integer rh_ln_y2_qyf_num;
            //todo rh_crc_y2_qyf_num 近2年内信用卡查询失败次数
            Integer rh_crc_y2_qyf_num;
            //近2年内贷款审批查询次数
            Integer rh_ln_y2_qy_num = 0;
            //近2年内信用卡审批查询次数
            Integer rh_crc_y2_qy_num = 0;
            // 最近6个月贷款审批查询数
            int rh_m6_ln_qy_num = 0;
            List<String> queryDates = MapUtil.returnList(query_recordDetail, "QueryDate");
            List<String> queryReasons = MapUtil.returnList(query_recordDetail, "QueryReason");
            List<String> queriers = MapUtil.returnList(query_recordDetail, "Querier");
            for (int i = 0; i < queryDates.size(); i++) {
                try {
                    String queryDate = queryDates.get(i);
                    String queryReason = queryReasons.get(i);
                    Date queryDateTime = DateUtil.parseDate(queryDate, "yyyy-MM-dd");
                    Integer months = DateUtil.getMothDiff(formatDate, queryDateTime);
                    if ("2".equals(queryReason)) {
                        rh_ln_y2_qy_num++;
                        if (months < rh_ln_qy_lst_inte) {
                            rh_ln_qy_lst_inte = months;
                        }
                        if (months > rh_ln_qy_fst_inte) {
                            rh_ln_qy_fst_inte = months;
                        }
                        if (formatDate.getTime() - queryDateTime.getTime() < sixMonths) {
                            rh_m6_ln_qy_num++;
                        }
                        if (formatDate.getTime() - queryDateTime.getTime() < yearTime) {
                            custCard2ResVo.setRh_m12_ln_qy_num(custCard2ResVo.getRh_m12_ln_qy_num() + 1);
                        }
                    } else if ("3".equals(queryReason)) {
                        rh_crc_y2_qy_num++;
                        if (months > rh_crc_qy_fst_inte) {
                            rh_crc_qy_fst_inte = months;
                        }
                        if (formatDate.getTime() - queryDateTime.getTime() < sixMonths) {
                            custCard2ResVo.setRh_m6_crc_qy_num(custCard2ResVo.getRh_m6_crc_qy_num() + 1);
                        }
                        if (formatDate.getTime() - queryDateTime.getTime() < yearTime) {
                            custCard2ResVo.setRh_m12_crc_qy_num(custCard2ResVo.getRh_m12_crc_qy_num() + 1);
                        }
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            rh_ln_y2_qyf_num = rh_ln_y2_qy_num - loan_num.size();
            rh_crc_y2_qyf_num = rh_crc_y2_qy_num - (standardLoancard_num.size() + loanCard_num.size());
            rh_cr_y2_qyf_num = rh_ln_y2_qyf_num + rh_crc_y2_qyf_num;
            rh_ln_qy_lst_inte = rh_ln_qy_lst_inte == Integer.MAX_VALUE ? -99988 : rh_ln_qy_lst_inte;
            rh_hsln_min_bal_pr = rh_hsln_min_bal_pr.compareTo(new BigDecimal(Integer.MAX_VALUE)) == 0 ? new BigDecimal(-99988) : rh_hsln_min_bal_pr;
            custCard2ResVo.initCustomerCardModelVo(occupation, duty, rh_bs_industry_mat, rh_lncd_nr_mn_cr_lmt, rh_lncd_nr_min_cr_lmt, rh_lncd_nr_min_sd_lmt, rh_lncd_min_ud_sd_lmt_pr, rh_lncd_nr_min_ud_sd_lmt_pr, rh_lncd_avg_curdef_amt,
                    rh_lncd_max_curdef_amt, rh_lncd_ovd_ct_3y_rp, rh_m24_lncd_ovd_max_perd, rh_lncd_nr_mn_cr_lmt_m6, rh_lncd_lim_org_ds_num, rh_stlncd_nr_sum_ud_cr_lmt, rh_stlncd_nr_min_ud_cr_lmt, rh_crc_uc_max_age, rh_crc_ovd_ct_3y_rp,
                    rh_ln_num, rh_ln_st_advp, rh_ln_st_oth, rh_ln_uc_max_age, rh_if_houseln, rh_5state_good_pr, rh_ln_ovd_cur_amt_rp, rh_ln_ovd_max_2y_rp, rh_carln_sum_amt, rh_carln_st_adva, rh_hsln_avg_bal, rh_hsln_min_bal_pr,
                    rh_hsln_max_bal_pr, rh_opln_nr_num, rh_opln_max_amt, rh_opln_max_bal, rh_opln_avg_bal, rh_opln_st_adva, rh_agln_max_bal, rh_hsln_sum_num, rh_ln_ovd_dur, rh_ln_corg_num, rh_ln_org_num, rh_lncd_ud_amt, rh_m6_lncd_ud_pro,
                    rh_cr_lim_amt, rh_gr_sum_amt, rh_gr_tol_bal, rh_cr_bal_pro, rh_crc_ud_pro, rh_ln_bal_pro, rh_m6_cr_ovd_mon, rh_m24_cr_ovd_mon, rh_m12_cr_ovd_mon, rh_cr_uc_min_age, rh_ln_qy_lst_inte, rh_ln_qy_fst_inte,
                    rh_crc_qy_fst_inte, rh_cr_y2_qyf_num, rh_ln_y2_qyf_num);

            /**
             *  开发人员：段守政
             */

            Long threeMonths = 90 * 24 * 60 * 60 * 1000L;
            Long halfYearTime = 180 * 24 * 60 * 60 * 1000L;
            //todo queryreason 查询原因
            String queryreason = iteratorAttrByType(jsonObject, VALUE_TYPE_STRING,  "Header", "QueryReq", "QueryReason").toString();
            MapUtil.setValueToObject(custCard2ResVo, "queryreason", queryreason, new String[]{"01", "02", "03", "08", "19"}, new String[]{"1", "2", "3", "5", "6", queryreason});
            //todo gender 性别
            String gender = iteratorAttrByType(jsonObject, VALUE_TYPE_STRING,  "PersonalInfo", "Identity", "Gender").toString();
            custCard2ResVo.setGender(gender);
            //todo maritalstate 婚姻状况
            String maritalstate = iteratorAttrByType(jsonObject, VALUE_TYPE_STRING,  "PersonalInfo", "Identity", "MaritalState").toString();
            custCard2ResVo.setMaritalstate(maritalstate);
            //todo edulevel 学历
            String edulevel = iteratorAttrByType(jsonObject, VALUE_TYPE_STRING,  "PersonalInfo", "Identity", "EduLevel").toString();
            custCard2ResVo.setEdulevel(edulevel);
            //todo edudegree 学位
            String edudegree = iteratorAttrByType(jsonObject, VALUE_TYPE_STRING,  "PersonalInfo", "Identity", "EduDegree").toString();
            custCard2ResVo.setEdudegree(edudegree);

            Set<String> residenceTypeSet = new HashSet<>();
            Set<String> provinceSet = new HashSet<>();
            List<String> getTime = new ArrayList<>();
            List<String> getResidenceType = new ArrayList<>();
            String residenceType = "";
            Long residencemaxData = 0L;
            //Map<String, Object> residences = (Map<String, Object>) personalInfo.get("Residence");
            //获取居住状况集合
            List<String> residenceTypeList = (List<String>) iteratorAttrByType(personalInfo, VALUE_TYPE_LIST,  "Residence", "ResidenceType");
            if (residenceTypeList.size() > 0) {
                getResidenceType = residenceTypeList;
            }
            //获取居住状况信息更新日的最大时间
            List<String> getTimeList = (List<String>) iteratorAttrByType(personalInfo, VALUE_TYPE_LIST,  "Residence", "GetTime");
            if (getTimeList.size() > 0) {
                getTime = getTimeList;
            }
            // todo 遍历集合获取居住状况
            for (int i = 0; i < getTime.size(); i++) {
                try {
                    String getTimess = getTime.get(i);
                    if (StringUtils.isBlank(getTimess)) {
                        continue;
                    }
                    Date getTimedate = DateUtil.parseDate(getTimess, "yyyy-MM-dd");
                    if (residencemaxData < getTimedate.getTime() && !StringUtils.isEmpty(getResidenceType.get(i)) && !VALUE_TYPE_STRING_DEFAULT_VALUE.equals(getResidenceType.get(i))) {
                        residencemaxData = getTimedate.getTime();
                        residenceType = getResidenceType.get(i);
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            // todo residencetype 居住状况
            residenceType = residenceType.equals("") ? "NaN" : residenceType;
            custCard2ResVo.setResidencetype(residenceType);
            //1.6 居住类型个数
            for (int i = 0; i < getResidenceType.size(); i++) {
                residenceTypeSet.add(getResidenceType.get(i));
            }
            //1.7 居住省份个数
            List<String> addressList = new ArrayList<>();
            List<String> tempaddressList = (List<String>) iteratorAttrByType(personalInfo, VALUE_TYPE_LIST,  "Residence", "Address");
            if (tempaddressList.size() > 0) {
                addressList = tempaddressList;
            }
            for (int j = 0; j < addressList.size(); j++) {
                String address = addressList.get(j);
                if (StringUtils.isNotBlank(address) && address.length() >= 3) {
                    provinceSet.add(address.substring(0, 3));
                }
            }
            //todo residence_province_num 居住省份个数   ？
            custCard2ResVo.setResidence_province_num(provinceSet.size());
            //todo residence_type_num 居住类型个数   ？
            custCard2ResVo.setResidence_type_num(residenceTypeSet.size());
            //todo 所在行业
            //进入本单位年份
            Integer startYear = 0;
            //工作单位集合
            Map<String, Object> professionals = (Map<String, Object>) iteratorAttrByType(jsonObject, VALUE_TYPE_MAP,  "PersonalInfo", "Professional");
            List<String> employer = (List<String>) iteratorAttrByType(professionals, VALUE_TYPE_LIST,  "Employer");
            Set<String> industrysSet = new HashSet<>();
            //时间集合
            List<String> getTimea = (List<String>) iteratorAttrByType(professionals, VALUE_TYPE_LIST, "GetTime");
            //行业集合
            List<String> getIndustty = (List<String>) iteratorAttrByType(professionals, VALUE_TYPE_LIST, "Industry");
            //进入单位年份集合
            List<String> getStartYear = (List<String>) iteratorAttrByType(professionals, VALUE_TYPE_LIST, "StartYear");
            String prDutys = "";
            Long maxStartYear = 0L;
            //获取对应行业信息更新日的最大时间
            //获取行业集合
            //获取工作单位集合
            long industrymaxData = 0L;
            //todo industry 遍历集合获取所在行业
            for (int i = 0; i < getIndustty.size(); i++) {
                industrysSet.add(getIndustty.get(i));
            }
            for (int i = 0; i < getTimea.size(); i++) {
                try {
                    String getTimeas = getTimea.get(i);
                    if (StringUtils.isBlank(getTimeas)) {
                        continue;
                    }
                    Date getTimedate = DateUtil.parseDate(getTimeas, "yyyy-MM-dd");
                    if (getTimedate != null) {
                        if (industrymaxData < getTimedate.getTime() && !StringUtils.isEmpty(getIndustty.get(i)) && !VALUE_TYPE_STRING_DEFAULT_VALUE.equals(getIndustty.get(i))) {
                            industrymaxData = getTimedate.getTime();
                            prDutys = getIndustty.get(i);
                        }
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            prDutys = prDutys.equals("") ? "NaN" : prDutys;
            custCard2ResVo.setIndustry(prDutys);


            //3.2最近一份工作的稳定性
            for (int i = 0; i < getStartYear.size(); i++) {
                try {
                    String getStartYears = getStartYear.get(i);
                    Date StartYear = DateUtil.parseDate(getStartYears, "yyyy");
                    if (StartYear != null) {
                        if (maxStartYear < StartYear.getTime()) {
                            maxStartYear = StartYear.getTime();
                            startYear = parseInt(getStartYear.get(i).substring(0, 4));
                        }
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            //todo 公积金缴存状态
            Map<String, Object> accFunds = (Map<String, Object>) iteratorAttrByType(jsonObject, VALUE_TYPE_MAP, "PublicInfo", "AccFund");
            List<String> accFundsTime = (List<String>) iteratorAttrByType(accFunds, VALUE_TYPE_LIST, "GetTime");
            //公积金缴存状态
            List<String> accState = (List<String>) iteratorAttrByType(accFunds, VALUE_TYPE_LIST, "State");
            String accStates = "NaN";
            //公积金缴存金额
            List<Integer> accPay = (List<Integer>) iteratorAttrByType(accFunds, VALUE_TYPE_LIST, "Pay");
            Integer pay = -99988;
            //公积金个人缴存比例
            List<Integer> accOwnPercent = (List<Integer>) iteratorAttrByType(accFunds, VALUE_TYPE_LIST, "OwnPercent");
            BigDecimal ownPercent = new BigDecimal(-99988);
            //公积金公司缴存比例
            List<Integer> accComPercent = (List<Integer>) iteratorAttrByType(accFunds, VALUE_TYPE_LIST, "ComPercent");
            BigDecimal comPercent = new BigDecimal(-99988);
            //公积金缴至月份
            List<String> accToMonth = (List<String>) iteratorAttrByType(accFunds, VALUE_TYPE_LIST, "ToMonth");
            Date toMonth = new Date();
            //公积金初缴月份
            List<String> accFirstMonth = (List<String>) iteratorAttrByType(accFunds, VALUE_TYPE_LIST, "FirstMonth");
            Date firstMonth = new Date();

            long fundmaxData = 0L;
            for (int i = 0; i < accFundsTime.size(); i++) {
                try {
                    String getaccFundsTime = accFundsTime.get(i);
                    Date getTimedate = DateUtil.parseDate(getaccFundsTime, "yyyy-MM-dd");
                    if (getTimedate == null) {
                        continue;
                    }
                    if (fundmaxData < getTimedate.getTime() && !StringUtils.isEmpty(accState.get(i)) && !VALUE_TYPE_STRING_DEFAULT_VALUE.equals(accState.get(i))) {
                        if(accToMonth.get(i).equals("0000-00") || accFirstMonth.get(i).equals("0000-00")){
                            continue;
                        }
                        fundmaxData = getTimedate.getTime();
                        accStates = accState.get(i);
                        pay = accPay.get(i);
                        ownPercent = new BigDecimal(accOwnPercent.get(i));
                        comPercent = new BigDecimal(accComPercent.get(i));
                        toMonth = DateUtil.parseDate(accToMonth.get(i), "yyyy-MM");
                        firstMonth = DateUtil.parseDate(accFirstMonth.get(i), "yyyy-MM");
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            //todo accfund_state 遍历集合获取公积金缴存状态
            custCard2ResVo.setAccfund_state(accStates);

            //todo rh_bs_accf_cur_mon 当前公司住房公积金缴费月份数
            custCard2ResVo.setRh_bs_accf_cur_mon(DateUtil.getMothDiff(toMonth, firstMonth));
            //获取公积金缴存状态的信息更新日的最小时间
            for (int i = 0; i < accFundsTime.size(); i++) {
                try {
                    String getaccFundsTime = accFundsTime.get(i);
                    Date getTimedate = DateUtil.parseDate(getaccFundsTime, "yyyy-MM-dd");
                    if (getaccFundsTime == null) {
                        continue;
                    }
                    if (fundmaxData > getTimedate.getTime()) {
                        if(accToMonth.get(i).equals("0000-00") || accFirstMonth.get(i).equals("0000-00")){
                            continue;
                        }
                        fundmaxData = getTimedate.getTime();
                        toMonth = DateUtil.parseDate(accToMonth.get(i), "yyyy-MM");
                        firstMonth = DateUtil.parseDate(accFirstMonth.get(i), "yyyy-MM");
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            //todo accfund_pay 公积金缴存金额
            custCard2ResVo.setAccfund_pay(pay);
            //todo ownprent 公积金个人缴存比例
            custCard2ResVo.setOwnprent(ownPercent);
            //todo  ownprent 公积金公司缴存比例
            custCard2ResVo.setComprent(comPercent);
            //todo rh_bs_accf_his_mon 历史住房公积金缴费月份数
            custCard2ResVo.setRh_bs_accf_his_mon(DateUtil.getMothDiff(toMonth, firstMonth));
            //todo Rh_bs_accf_base 住房公积金缴费基数
            try {
                if (custCard2ResVo.getOwnprent().add(custCard2ResVo.getComprent()).compareTo(new BigDecimal(0)) != 0) {
                    custCard2ResVo.setRh_bs_accf_base((new BigDecimal(custCard2ResVo.getAccfund_pay().toString()).divide((custCard2ResVo.getOwnprent().add(custCard2ResVo.getComprent())), 2, BigDecimal.ROUND_HALF_UP)).intValue());
                }
            } catch (Exception e) {
                LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
            }
            //todo 年龄
            String reportCreateTime = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "NaN", "Header", "MessageHeader", "ReportCreateTime").toString();
            if (reportCreateTime.equals("NaN") || reportCreateTime.length() < 4) {
                reportCreateTime = "0000";
            }
            String birthdayString = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "NaN", "PersonalInfo", "Identity", "Birthday").toString();
            if (birthdayString.equals("NaN") || birthdayString.length() < 4) {
                birthdayString = "0000";
            }
            Integer birthday = parseInt(birthdayString.substring(0, 4));
            //todo apply_age 两个日期相减算出的年龄
            try {
                custCard2ResVo.setApply_age(parseInt(reportCreateTime.substring(0, 4)) - birthday);
            } catch (Exception e) {
                LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
            }
            //todo industry_num 从事行业个数
            custCard2ResVo.setIndustry_num(industrysSet.size());
            //todo rh_bs_work_last_sta 最近一份工作的稳定性
            if (employer.size() != 0) {
                try {
                    custCard2ResVo.setRh_bs_work_last_sta(new BigDecimal(parseInt(reportCreateTime.substring(0, 4)) - startYear).divide(new BigDecimal(employer.size()), 2, BigDecimal.ROUND_HALF_UP));
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }

        /*   183行已定义
        Map<String, Object> creditDetai = (Map<String, Object>) reportMessage.get("CreditDetail");
        Map<String, Object> queryRecord = (Map<String, Object>) reportMessage.get("QueryRecord");
        Map<String, Object> shareAndDebt = (Map<String, Object>) infoSummary.get("ShareAndDebt");
        Map<String, String> undestoryLoancard = (Map<String, String>) shareAndDebt.get("UndestoryLoancard");
        */

            //准贷记卡最大账龄")
            Integer rh_stlncd_detail_max_age = 0;
            //近6个月正常人民币贷记卡有值账户数")
            Integer rh_lncd_nr_hv_num_m6 = 0;
            //近6个月人民币准贷记卡有值账户数")
            Integer rh_stlncd_hv_num_m6 = 0;
            //正常状态人民币账户贷记卡已用共享额度比总和
            BigDecimal rh_lncd_nr_ud_sd_lmt_pr_sum = new BigDecimal(0);
            //正常状态人民币账户准贷记卡透支共享额度比总和"
            BigDecimal rh_stlncd_nr_mn_ud_sd_lmt_pr_sum = new BigDecimal(0);
            //正常状态人民币账户准贷记卡有值账户数
            Integer rh_stlncd_nr_mn_ud_sd_lmt_pr_count = 0;
            //正常状态人民币账户准贷记卡最小透支共享额度比")
            BigDecimal rh_stlncd_nr_min_ud_sd_lmt_pr = new BigDecimal(1);
            //正常状态人民币账户贷记卡最小已用额度比")
            BigDecimal rh_lncd_min_nr_ud_cr_lmt_pr = new BigDecimal(1);
            //正常状态人民币账户准贷记卡透支余额比总和
            BigDecimal rh_stlncd_nr_ud_cr_lmt_pr_sum = new BigDecimal(0);
            //正常状态人民币账户准贷记卡透有值账户数
            Integer rh_stlncd_nr_ud_cr_lmt_pr_count = 0;
            //正常状态人民币账户准贷记卡透支余额比有值账户数
            Integer rh_stlncd_nr_ud_cr_lmt_pr_num = 0;
            //正常状态人民币账户贷记卡已用额度比有值账户数")
            Integer rh_lncd_nr_ud_cr_lmt_pr_num = 0;
            //正常状态人民币账户准贷记卡最小透支余额比")
            BigDecimal rh_stlncd_nr_min_ud_cr_lmt_pr = new BigDecimal(1);
            //未销户人民币账户准贷记卡最小透支共享额度比")
            BigDecimal rh_stlncd_min_ud_sd_lmt_pr = new BigDecimal(1);
            //未销户人民币账户准贷记卡透支余额比总和
            BigDecimal rh_stlncd_uc_amt_pro_sum = new BigDecimal(0);
            //未销户人民币账户贷记卡已用额度比有值账户数")
            Integer rh_lncd_sum_ud_cr_lmt_pr_num = 0;
            //未销户人民币账户准贷记卡透支余额有值账户数")
            Integer rh_stlncd_ud_cr_lmt_sum = 0;
            //未销户人民币账户贷记卡最小已用额度比")
            BigDecimal rh_lncd_uc_min_amt_pro = new BigDecimal(1);
            //未销户人民币账户准贷记卡最小透支余额比")
            BigDecimal rh_stlncd_uc_min_amt_pro = new BigDecimal(1);
            //贷记卡最早的发卡日期
            Date opendate_min = new Date();
            //正常状态人民币账户贷记卡总共享额度")
            Integer rh_lncd_sum_nr_sd_lmt = 0;
            //正常状态人民币账户贷记卡个数")
            Integer rh_lncd_sum_nr_sd_lmt_num = 0;
            //正常状态人民币账户贷记卡已用额度比总和
            BigDecimal rh_lncd_nr_ud_cr_lmt_pr_sum = new BigDecimal(0);
            //未销户人民币账户贷记卡已用共享额度比总和"
            BigDecimal rh_lncd_ud_sd_lmt_pr_sum = new BigDecimal(0);
            //未销户人民币账户贷记卡已用共享额度比有值账户数")
            Integer rh_lncd_ud_sd_lmt_pr_num = 0;
            //未销户人民币账户贷记卡已用额度比总和")
            BigDecimal rh_lncd_uc_sum_amt_pro = new BigDecimal(0);
            //正常状态人民币账户贷记卡总已用额度
            Integer rh_lncd_sum_nr_ud_cr_lmt = 0;
            //未销户人民币账户贷记卡授信额度有值账户数")
            Integer rh_lncd_uc_cv_num = 0;
            //正常状态人民币账户准贷记卡共享额度有值账户数")
            Integer rh_stlncd_nr_sd_lmt_sum = 0;
            //未销户人民币账户准贷记卡授信额度有值账户数")
            Integer rh_stlncd_cr_lmt_sum = 0;
            //正常状态人民币账户准贷记卡透支共享额度比")
            BigDecimal rh_stlncd_nr_ud_sd_lmt_pr;
            //正常状态人民币账户准贷记卡透支余额比")
            BigDecimal rh_stlncd_nr_ud_cr_lmt_pr;
            //未销户人民币账户准贷记卡透支共享额度比")
            BigDecimal rh_stlncd_ud_sd_lmt_pr = new BigDecimal(0);
            //未销户人民币账户准贷记卡透支共享额度比有值账户数")
            Integer rh_stlncd_ud_sd_lmt_pr_num = 0;
            //未销户人民币账户准贷记卡透支共享额度比总和
            BigDecimal rh_stlncd_ud_sd_lmt_pr_sum = new BigDecimal(0);
            //未销户人民币账户准贷记卡透支余额比")
            BigDecimal rh_stlncd_uc_amt_pro = new BigDecimal(0);
            //未销户人民币账户贷记卡已用共享额度比")
            BigDecimal rh_lncd_ud_sd_lmt_pr = new BigDecimal(0);
            //当前未销户人民币账户贷记卡已用额度比
            BigDecimal rh_lncd_uc_amt_pro = new BigDecimal(0);
            //正常状态人民币账户贷记卡已用共享额度比")
            BigDecimal rh_lncd_nr_ud_sd_lmt_pr = new BigDecimal(0);
            //正常状态人民币账户贷记卡已用共享额度比有值账户数")
            Integer rh_lncd_nr_ud_sd_lmt_pr_num = 0;
            //正常状态人民币账户贷记卡已用额度比
            BigDecimal rh_lncd_nr_ud_cr_lmt_pr = new BigDecimal(0);
            //正常状态人民币账户贷记卡平均已用额度
            BigDecimal rh_lncd_nr_avg_ud_cr_lmt = new BigDecimal(0);
            //正常状态人民币账户信用卡最小已用共享额度比
            BigDecimal rh_crc_nr_min_ud_sd_lmt_pr = new BigDecimal(1);
            Map<String, Object> creditInfo = (Map<String, Object>) iteratorAttrByType(loanCardList, VALUE_TYPE_MAP, "AwardCreditInfo");
            List<String> loancardState = (List<String>) iteratorAttrByType(loanCardList, VALUE_TYPE_LIST, "State");
            Map<String, Object> repayInfo = (Map<String, Object>) iteratorAttrByType(loanCardList, VALUE_TYPE_MAP, "RepayInfo");
            //Map<String, Object> loanCardcurrOverdue = MapUtil.returnMap(loanCardList, "CurrOverdue");
            Map<String, Object> loanCardlatest24MonthPaymentState = (Map<String, Object>) iteratorAttrByType(loanCardList, VALUE_TYPE_MAP, "Latest24MonthPaymentState");
            //授信额度
            List<String> loancardCreditLimitAmount = (List<String>) iteratorAttrByType(creditInfo, VALUE_TYPE_LIST, "CreditLimitAmount");
            //共享额度
            List<String> shareCreditLimitAmount = (List<String>) iteratorAttrByType(repayInfo, VALUE_TYPE_LIST, "ShareCreditLimitAmount");
            //已用额度
            List<String> usedCreditLimitAmount = (List<String>) iteratorAttrByType(repayInfo, VALUE_TYPE_LIST, "UsedCreditLimitAmount");
            //最大使用额度
            List<String> usedHighestAmountList = (List<String>) iteratorAttrByType(repayInfo, VALUE_TYPE_LIST, "UsedHighestAmount");
            //近24个月还款状态
            List<String> loanCardlatest24State = (List<String>) iteratorAttrByType(loanCardlatest24MonthPaymentState, VALUE_TYPE_LIST, "Latest24State");
            //开卡日期
            List<String> openDates = (List<String>) iteratorAttrByType(creditInfo, VALUE_TYPE_LIST, "OpenDate");
            //人民币贷记卡账户数
            List<String> currency = (List<String>) iteratorAttrByType(creditInfo, VALUE_TYPE_LIST, "Currency");
            //近6个月平均使用额度
            List<BigDecimal> lates6MonthUsedAvgAmount = (List<BigDecimal>) iteratorAttrByType(repayInfo, VALUE_TYPE_LIST, "Latest6MonthUsedAvgAmount");
            //未销户有值共享额度账户数
            int shareCreditLimitAmountCount = 0;
            //正常有值共享额度账户数
            int shareCreditLimitAmountCount1 = 0;
            //正常有值已用额度账户数
            int usedCreditLimitAmountBeanCount1 = 0;
            //逾期180天为归还本金
            // HashMap<String, String> currOverdue = (HashMap<String, String>) loanCardInfo.get("CurrOverdue");
            //            currOverdue.get("OverdueOver180Amount")
            for (int i = 0; i < loancardState.size(); i++) {
                String state = loancardState.get(i);
                try {
                    String[] states = loanCardlatest24State.get(i).split("");
                    if (states.length == 24) {
                        if (states[23].equals("#")) {
                            custCard2ResVo.setRh_lncd_bad_state("Abnormal");
                        }
                    }
                    //todo rh_lncd_mid_ovd_num 评级为一般逾期的贷记卡账户数目
                    if (loanCardlatest24State.get(i).matches("^[8-9a-zA-Z_]*[1-7]{3}[8-9a-zA-Z_]*$")) {
                        custCard2ResVo.setRh_lncd_mid_ovd_num(custCard2ResVo.getRh_lncd_mid_ovd_num() + 1);
                    }
                    //todo rh_lncd_high_ovd_num 评级为严重逾期的贷记卡账户数目
                    if (loanCardlatest24State.get(i).matches("^[8-9a-zA-Z_]*[1-7]{4}[0-9a-zA-Z_]*$")) {
                        custCard2ResVo.setRh_lncd_high_ovd_num(custCard2ResVo.getRh_lncd_high_ovd_num() + 1);
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
                Integer loancardCreditLimitAmountBean = 0;
                Integer shareCreditLimitAmountBean = 0;
                Integer usedCreditLimitAmountBean = 0;
                Integer usedHighestAmount = 0;
                try {
                    loancardCreditLimitAmountBean = StringUtils.isBlank(loancardCreditLimitAmount.get(i)) ? 0 : Integer.valueOf(loancardCreditLimitAmount.get(i));
                    shareCreditLimitAmountBean = StringUtils.isBlank(shareCreditLimitAmount.get(i)) ? 0 : Integer.valueOf(shareCreditLimitAmount.get(i));
                    usedCreditLimitAmountBean = StringUtils.isBlank(usedCreditLimitAmount.get(i)) ? 0 : Integer.valueOf(usedCreditLimitAmount.get(i));
                    usedHighestAmount = StringUtils.isBlank(usedHighestAmountList.get(i)) ? 0 : Integer.valueOf(usedHighestAmountList.get(i));
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
                String openDate = openDates.get(i);
                Date opendate = DateUtil.parseDate(openDate, "yyyy-MM-dd");
                //todo 计算失败不走判断所以给个一定不通过的
                int rh_lncd_age = 99888;
                try {
                    //开卡日期
                    //todo rh_lncd_op_max_dt 最近贷记卡开立日期
                    if (custCard2ResVo.getRh_lncd_op_max_dt().equals("NaN")) {
                        custCard2ResVo.setRh_lncd_op_max_dt(openDate);
                    } else {
                        custCard2ResVo.setRh_lncd_op_max_dt(DateUtil.getBiggerDate1(openDate, custCard2ResVo.getRh_lncd_op_max_dt()));
                    }
                    //todo rh_lncd_op_old_dt 最老贷记卡开立日期
                    if (custCard2ResVo.getRh_lncd_op_old_dt().equals("NaN")) {
                        custCard2ResVo.setRh_lncd_op_old_dt(openDate);
                    } else {
                        custCard2ResVo.setRh_lncd_op_old_dt(DateUtil.getSmallerDate1(custCard2ResVo.getRh_lncd_op_old_dt(), openDate));
                    }
                    //贷记卡开卡距今月数
                    rh_lncd_age = DateUtil.monthBetween(formatDate, opendate);

                    //贷记卡最大账龄
                    if (custCard2ResVo.getRh_lncd_detail_max_age() < rh_lncd_age) {
                        custCard2ResVo.setRh_lncd_detail_max_age(rh_lncd_age);
                    }
                    if (opendate_min.getTime() > opendate.getTime()) {
                        opendate_min = opendate;
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
                //todo rh_lncd_num 计算人民币贷记卡账户数
                if (currency.get(i).equals("CNY")) {
                    try {
                        custCard2ResVo.setRh_lncd_num(custCard2ResVo.getRh_lncd_num() + 1);
                        //计算不同状态的人民币贷记卡账户数
                        switch (state) {
                            case "1": {
                                //todo rh_rh_crc_avg_ud_cr_lmt_prlncd_nr_num 正常人民币贷记卡账户数
                                custCard2ResVo.setRh_lncd_nr_num(custCard2ResVo.getRh_lncd_nr_num() + 1);
                                //12个月正常贷记卡数
                                if (formatDate.getTime() - opendate.getTime() < yearTime) {
                                    custCard2ResVo.setRh_lncd_nr_num_m12(custCard2ResVo.getRh_lncd_nr_num_m12() + 1);
                                }

                                if (rh_lncd_age <= 6) {
                                    rh_lncd_nr_hv_num_m6 += 1;
                                    //todo rh_lncd_sum_nr_cr_lmt_m6  近6个月正常状态人民币账户贷记卡总授信额度
                                    custCard2ResVo.setRh_lncd_sum_nr_cr_lmt_m6(custCard2ResVo.getRh_lncd_sum_nr_cr_lmt_m6() + loancardCreditLimitAmountBean);
                                }
                                if (rh_lncd_age <= 12) {
                                    custCard2ResVo.setRh_lncd_sum_nr_cr_lmt_m12(custCard2ResVo.getRh_lncd_sum_nr_cr_lmt_m12() + loancardCreditLimitAmountBean);
                                }

                                //todo rh_lncd_sum_nr_cr_lmt 正常账户授信总额度 正常状态人民币账户贷记卡总授信额度
                                custCard2ResVo.setRh_lncd_sum_nr_cr_lmt(custCard2ResVo.getRh_lncd_sum_nr_cr_lmt() + loancardCreditLimitAmountBean);

                                //todo rh_lncd_max_nr_cr_lmt 正常人民币账户最大授信额度 正常状态人民币账户贷记卡最大授信额度
                                if (custCard2ResVo.getRh_lncd_max_nr_cr_lmt() < loancardCreditLimitAmountBean) {
                                    custCard2ResVo.setRh_lncd_max_nr_cr_lmt(loancardCreditLimitAmountBean);
                                }
                                //正常共享总额度
                                rh_lncd_sum_nr_sd_lmt += shareCreditLimitAmountBean;
                                rh_lncd_sum_nr_sd_lmt_num += 1;
                                if (shareCreditLimitAmountBean != 0) {
                                    shareCreditLimitAmountCount1++;
                                }
                                //todo rh_lncd_max_nr_sd_lmt 正常最大共享 正常状态人民币账户贷记卡最大共享额度
                                if (custCard2ResVo.getRh_lncd_max_nr_sd_lmt() < shareCreditLimitAmountBean) {
                                    custCard2ResVo.setRh_lncd_max_nr_sd_lmt(shareCreditLimitAmountBean);
                                }

                                if (usedCreditLimitAmountBean != 0) {
                                    rh_lncd_sum_nr_ud_cr_lmt += usedCreditLimitAmountBean;
                                    //todo rh_lncd_sum_nr_ud_cr_lmt 正常已用总额 正常状态人民币账户贷记卡总已用额度
                                    custCard2ResVo.setRh_lncd_sum_nr_ud_cr_lmt(custCard2ResVo.getRh_lncd_sum_nr_ud_cr_lmt() + usedCreditLimitAmountBean);
                                }


                                //todo rh_lncd_max_nr_ud_cr_lmt 最大已用额度 正常状态人民币账户贷记卡最大已用额度
                                if (custCard2ResVo.getRh_lncd_max_nr_ud_cr_lmt() < usedCreditLimitAmountBean) {
                                    custCard2ResVo.setRh_lncd_max_nr_ud_cr_lmt(usedCreditLimitAmountBean);
                                }

                                //todo Rh_lncd_nr_min_ud_cr_lmt 最小已用额度 正常状态人民币账户贷记卡最小已用额度
                                if (custCard2ResVo.getRh_lncd_nr_min_ud_cr_lmt() > usedCreditLimitAmountBean) {
                                    custCard2ResVo.setRh_lncd_nr_min_ud_cr_lmt(usedCreditLimitAmountBean);
                                }

                                if (usedCreditLimitAmountBean != 0) {
                                    usedCreditLimitAmountBeanCount1++;
                                    if (loancardCreditLimitAmountBean != 0) {
                                        rh_lncd_nr_ud_cr_lmt_pr_num += 1;
                                        // 正常状态人民币账户贷记卡已用额度比
                                        rh_lncd_nr_ud_cr_lmt_pr = BigDecimalUtil
                                                .divide(new BigDecimal(usedCreditLimitAmountBean), new BigDecimal(loancardCreditLimitAmountBean), rh_lncd_nr_ud_cr_lmt_pr);
                                        //todo rh_lncd_max_nr_ud_cr_lmt_pr  正常状态人民币账户贷记卡最大已用额度比
                                        if (custCard2ResVo.getRh_lncd_max_nr_ud_cr_lmt_pr().compareTo(rh_lncd_nr_ud_cr_lmt_pr) < 0) {
                                            custCard2ResVo.setRh_lncd_max_nr_ud_cr_lmt_pr(rh_lncd_nr_ud_cr_lmt_pr);
                                        }

                                        if (rh_lncd_min_nr_ud_cr_lmt_pr.compareTo(rh_lncd_nr_ud_cr_lmt_pr) > 0) {
                                            rh_lncd_min_nr_ud_cr_lmt_pr = rh_lncd_nr_ud_cr_lmt_pr;

                                        }

                                        rh_lncd_nr_ud_cr_lmt_pr_sum = rh_lncd_nr_ud_cr_lmt_pr_sum
                                                .add(rh_lncd_nr_ud_cr_lmt_pr);
                                        rh_lncd_nr_avg_ud_cr_lmt = rh_lncd_nr_avg_ud_cr_lmt.add(new BigDecimal(usedCreditLimitAmountBean));
                                    }
                                    if (shareCreditLimitAmountBean != 0) {
                                        rh_lncd_nr_ud_sd_lmt_pr_num += 1;
                                        rh_lncd_nr_ud_sd_lmt_pr = BigDecimalUtil.
                                                divide(new BigDecimal(usedCreditLimitAmountBean), new BigDecimal(shareCreditLimitAmountBean), rh_lncd_nr_ud_sd_lmt_pr);
                                        rh_lncd_nr_ud_sd_lmt_pr_sum = rh_lncd_nr_ud_sd_lmt_pr_sum.add(rh_lncd_nr_ud_sd_lmt_pr);
                                        //todo rh_lncd_max_nr_ud_sd_lmt_pr 正常状态人民币账户贷记卡最大已用共享额度比
                                        if (custCard2ResVo.getRh_lncd_max_nr_ud_sd_lmt_pr().compareTo(rh_lncd_nr_ud_sd_lmt_pr) < 0) {
                                            custCard2ResVo.setRh_lncd_max_nr_ud_sd_lmt_pr(rh_lncd_nr_ud_sd_lmt_pr);
                                        }
                                        if (rh_crc_nr_min_ud_sd_lmt_pr.compareTo(rh_lncd_nr_ud_sd_lmt_pr) > 0) {
                                            rh_crc_nr_min_ud_sd_lmt_pr = rh_lncd_nr_ud_sd_lmt_pr;
                                        }
                                    }
                                }

                                break;
                            }
                            case "6":
                                //todo rh_lncd_nopen_num 未激活人民币贷记卡账户数
                                custCard2ResVo.setRh_lncd_nopen_num(custCard2ResVo.getRh_lncd_nopen_num() + 1);
                                break;
                            case "4":
                                //todo rh_lncd_cancel_num 已销户人民币贷记卡账户数
                                custCard2ResVo.setRh_lncd_cancel_num(custCard2ResVo.getRh_lncd_cancel_num() + 1);
                                break;
                        }

                        //计算未销户人民币账户贷记卡总授信额度
                        if (!state.equals("4")) {
                            custCard2ResVo.setRh_crc_uc_num(custCard2ResVo.getRh_crc_uc_num() + 1);
                            //todo rh_lncd_uc_num 未销户人民币贷记卡账户数
                            custCard2ResVo.setRh_lncd_uc_num(custCard2ResVo.getRh_lncd_uc_num() + 1);
                            //todo  rh_lncd_max_sd_lmt_m6 近6个月未销户人民币账户贷记卡最大共享额度
                            if (rh_lncd_age <= 6 && custCard2ResVo.getRh_lncd_max_sd_lmt_m6() < shareCreditLimitAmountBean) {
                                custCard2ResVo.setRh_lncd_max_sd_lmt_m6(shareCreditLimitAmountBean);
                            }

                            //todo rh_lncd_sum_cr_lmt 总授信额度 未销户人民币账户贷记卡总授信额度
                            custCard2ResVo.setRh_lncd_sum_cr_lmt(custCard2ResVo.getRh_lncd_sum_cr_lmt() + loancardCreditLimitAmountBean);

                            //todo rh_lncd_sum_max_ud_amt 最大使用额度总和 人民币未销户贷记卡最大使用额度之和
                            custCard2ResVo.setRh_lncd_sum_max_ud_amt(custCard2ResVo.getRh_lncd_sum_max_ud_amt() + usedHighestAmount);

                            // todo rh_lncd_uc_lmt_min 授信额度最小值
                            if (loancardCreditLimitAmountBean < custCard2ResVo.getRh_lncd_uc_lmt_min()) {
                                custCard2ResVo.setRh_lncd_uc_lmt_min(loancardCreditLimitAmountBean);

                            }
                            // todo rh_lncd_uc_lmt_max 授信额度最大值
                            if (loancardCreditLimitAmountBean > custCard2ResVo.getRh_lncd_uc_lmt_max()) {
                                custCard2ResVo.setRh_lncd_uc_lmt_max(loancardCreditLimitAmountBean);

                            }

                            if (usedCreditLimitAmountBean != 0) {
                                //todo rh_lncd_sum_ud_cr_lmt 已用总额度 未销户人民币账户贷记卡总已用额度
                                custCard2ResVo.setRh_lncd_sum_ud_cr_lmt(custCard2ResVo.getRh_lncd_sum_ud_cr_lmt() + usedCreditLimitAmountBean);
                            }

                            //todo rh_lncd_max_ud_cr_lmt 最大已用额度 未销户人民币账户贷记卡最大已用额度
                            if (custCard2ResVo.getRh_lncd_max_ud_cr_lmt() < usedCreditLimitAmountBean) {
                                custCard2ResVo.setRh_lncd_max_ud_cr_lmt(usedCreditLimitAmountBean);
                            }
                            //todo rh_lncd_min_ud_cr_lmt 最小已用额度 未销户人民币账户贷记卡最小已用额度
                            if (custCard2ResVo.getRh_lncd_min_ud_cr_lmt() > usedCreditLimitAmountBean) {
                                custCard2ResVo.setRh_lncd_min_ud_cr_lmt(usedCreditLimitAmountBean);
                            }

                            // todo rh_lncd_max_max_ud_amt 最大使用额度最大值
                            if (custCard2ResVo.getRh_lncd_max_max_ud_amt() < usedHighestAmount) {
                                custCard2ResVo.setRh_lncd_max_max_ud_amt(usedHighestAmount);
                            }

                            if (loancardCreditLimitAmountBean != 0) {
                                rh_lncd_uc_cv_num += 1;
                            }

                            // todo 未销户人民币账户贷记卡最大已用额度比
                            if (usedCreditLimitAmountBean != 0 && loancardCreditLimitAmountBean != 0) {
                                //已用额度比有值账户数
                                rh_lncd_sum_ud_cr_lmt_pr_num += 1;
                                rh_lncd_uc_amt_pro = BigDecimalUtil.
                                        divide(new BigDecimal(usedCreditLimitAmountBean), new BigDecimal(loancardCreditLimitAmountBean), rh_lncd_uc_amt_pro);
                                rh_lncd_uc_sum_amt_pro = rh_lncd_uc_sum_amt_pro.add(rh_lncd_uc_amt_pro);
                                //todo rh_lncd_uc_max_amt_pro 未销户人民币账户贷记卡最大已用额度比
                                if (custCard2ResVo.getRh_lncd_uc_max_amt_pro().compareTo(rh_lncd_uc_amt_pro) < 0) {
                                    custCard2ResVo.setRh_lncd_uc_max_amt_pro(rh_lncd_uc_amt_pro);
                                }
                                if (rh_lncd_uc_min_amt_pro.compareTo(rh_lncd_uc_amt_pro) > 0) {
                                    rh_lncd_uc_min_amt_pro = rh_lncd_uc_amt_pro;
                                }
                            }

                            if (usedCreditLimitAmountBean != 0 && shareCreditLimitAmountBean != 0) {
                                rh_lncd_ud_sd_lmt_pr_num += 1;
                                rh_lncd_ud_sd_lmt_pr = BigDecimalUtil.
                                        divide(new BigDecimal(usedCreditLimitAmountBean), new BigDecimal(shareCreditLimitAmountBean), rh_lncd_ud_sd_lmt_pr);
                                rh_lncd_ud_sd_lmt_pr_sum = rh_lncd_ud_sd_lmt_pr_sum.add(rh_lncd_ud_sd_lmt_pr);
                                //todo rh_lncd_max_ud_sd_lmt_pr 未销户人民币账户贷记卡最大已用共享额度比
                                if (custCard2ResVo.getRh_lncd_max_ud_sd_lmt_pr().compareTo(rh_lncd_ud_sd_lmt_pr) < 0) {
                                    custCard2ResVo.setRh_lncd_max_ud_sd_lmt_pr(rh_lncd_ud_sd_lmt_pr);
                                }
                            }

                            //todo rh_lncd_sum_sd_lmt 总共享额度 未销户人民币账户贷记卡总共享额度
                            if (shareCreditLimitAmountBean != 0) {
                                shareCreditLimitAmountCount++;
                                custCard2ResVo.setRh_lncd_sum_sd_lmt(custCard2ResVo.getRh_lncd_sum_sd_lmt() + shareCreditLimitAmountBean);
                            }
                            //todo rh_lncd_max_sd_lmt 最大共享额度 未销户人民币账户贷记卡最大共享额度
                            if (custCard2ResVo.getRh_lncd_max_sd_lmt() < shareCreditLimitAmountBean) {
                                custCard2ResVo.setRh_lncd_max_sd_lmt(shareCreditLimitAmountBean);
                            }
                            //todo rh_lncd_min_sd_lmt 最小共享额度 未销户人民币账户贷记卡最小共享额度
                            if (custCard2ResVo.getRh_lncd_min_sd_lmt() > shareCreditLimitAmountBean) {
                                custCard2ResVo.setRh_lncd_min_sd_lmt(shareCreditLimitAmountBean);
                            }


                            if (!state.equals("6")) {
                                String[] statess = loanCardlatest24State.get(i).split("");
                                //近24个月逾期次数
                                Integer ct_2y = 0;
                                for (String rePayState : statess) {
                                    if (rePayState.matches("[1-7]")) {
                                        ct_2y++;
                                    }
                                }
                                //todo rh_lncd_ovd_ct_2y_rp 贷记卡近2年内逾期月份数
                                custCard2ResVo.setRh_lncd_ovd_ct_2y_rp(custCard2ResVo.getRh_lncd_ovd_ct_2y_rp() + ct_2y);

                            }

                        }
                    } catch (Exception e) {
                        LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                    }
                } else {
                    //todo rh_lncd_oc_num 外币贷记卡账户数
                    custCard2ResVo.setRh_lncd_oc_num(custCard2ResVo.getRh_lncd_oc_num() + 1);
                }
            }
            // todo rh_lncd_nr_num_m6 近6个月正常人民币贷记卡账户数4
            custCard2ResVo.setRh_lncd_nr_num_m6(rh_lncd_nr_num_m6);
            if (custCard2ResVo.getRh_lncd_nr_min_ud_cr_lmt() == Integer.MAX_VALUE) {
                custCard2ResVo.setRh_lncd_nr_min_ud_cr_lmt(-99988);
            }
            Map<String, Object> sLoancard_creditInfo = (Map<String, Object>) iteratorAttrByType(standardLoancardList, VALUE_TYPE_MAP, "AwardCreditInfo");
            Map<String, Object> sLoancard_repayInfo = (Map<String, Object>) iteratorAttrByType(standardLoancardList, VALUE_TYPE_MAP, "RepayInfo");
            Map<String, Object> sLoancard_currOverdue = (Map<String, Object>) iteratorAttrByType(standardLoancardList, VALUE_TYPE_MAP, "CurrOverdue");
            Map<String, Object> sLoancard_latest24MonthPaymentState = (Map<String, Object>) iteratorAttrByType(standardLoancardList, VALUE_TYPE_MAP, "Latest24MonthPaymentState");
            List<String> sLoancard_state = (List<String>) iteratorAttrByType(standardLoancardList, VALUE_TYPE_LIST, "State");
            //todo 逾期180天为归还本金 修改 段
            List<String> overdueOver180Amount = (List<String>) iteratorAttrByType(sLoancard_currOverdue, VALUE_TYPE_LIST, "OverdueOver180Amount");
            //授信额度
            List<String> sLoancard_creditLimitAmount = (List<String>) iteratorAttrByType(sLoancard_creditInfo, VALUE_TYPE_LIST, "CreditLimitAmount");
            //共享额度
            List<String> sLoancard_shareCreditLimitAmount = (List<String>) iteratorAttrByType(sLoancard_repayInfo, VALUE_TYPE_LIST, "ShareCreditLimitAmount");
            //已用额度
            List<String> sLoancard_usedCreditLimitAmount = (List<String>) iteratorAttrByType(sLoancard_repayInfo, VALUE_TYPE_LIST, "UsedCreditLimitAmount");
            //最大使用额度
            List<String> sLoancard_usedHighestAmounts = (List<String>) iteratorAttrByType(sLoancard_repayInfo, VALUE_TYPE_LIST, "UsedHighestAmount");
            //近24个月还款状态
            List<String> sLoancard_latest24State = (List<String>) iteratorAttrByType(sLoancard_latest24MonthPaymentState, VALUE_TYPE_LIST, "Latest24State");
            //开卡日期
            List<String> sLoancard_openDateS = (List<String>) iteratorAttrByType(sLoancard_creditInfo, VALUE_TYPE_LIST, "OpenDate");
            //账户币种
            List<String> sLoancard_currency = (List<String>) iteratorAttrByType(sLoancard_creditInfo, VALUE_TYPE_LIST, "Currency");
            for (int i = 0; i < sLoancard_state.size(); i++) {
                try {
                    Integer s_usedHighestAmount = sLoancard_usedHighestAmounts.get(i).equals("") ? 0 : Integer.valueOf(sLoancard_usedHighestAmounts.get(i));
                    //todo rh_stlncd_od180amt_sum_amt 准贷记卡透支180天以上未付余额  修改
                    custCard2ResVo.setRh_stlncd_od180amt_sum_amt(custCard2ResVo.getRh_stlncd_od180amt_sum_amt() + Integer.valueOf(overdueOver180Amount.get(i)));

                    Date openDate = DateUtil.parseDate(sLoancard_openDateS.get(i), "yyyy-MM-dd");
                    //todo rh_stlncd_op_max_dt 最近准贷记卡开立日期
                    if (custCard2ResVo.getRh_stlncd_op_max_dt() == null) {
                        custCard2ResVo.setRh_stlncd_op_max_dt(sLoancard_openDateS.get(i));
                    } else {
                        custCard2ResVo.setRh_stlncd_op_max_dt(DateUtil.getBiggerDate1(sLoancard_openDateS.get(i), custCard2ResVo.getRh_stlncd_op_max_dt()));
                    }
                    //todo rh_stlncd_op_old_dt 最老准贷记卡账户开户日期
                    if (sLoancard_openDateS.get(i) != null && !sLoancard_openDateS.get(i).equals("")) {
                        custCard2ResVo.setRh_stlncd_op_old_dt(DateUtil.getSmallerDate1(sLoancard_openDateS.get(i), custCard2ResVo.getRh_stlncd_op_old_dt()));
                    }
                    //准贷记卡开卡距今月数
                    int rh_stlncd_age = DateUtil.monthBetween(formatDate, openDate);
                    //todo
                    if (rh_stlncd_detail_max_age < rh_stlncd_age) {
                        rh_stlncd_detail_max_age = rh_stlncd_age;
                    }

                    //账户币种
                    if (sLoancard_currency.get(i).equals("CNY")) {
                        if (!sLoancard_state.get(i).equals("4")) {
                            //账户数
                            custCard2ResVo.setRh_stlncd_uc_num(custCard2ResVo.getRh_stlncd_uc_num() + 1);
                            //授信额度
                            custCard2ResVo.setRh_stlncd_sum_cr_lmt(custCard2ResVo.getRh_stlncd_sum_cr_lmt() + Integer.valueOf(sLoancard_creditLimitAmount.get(i)));
                            //总共享额度
                            custCard2ResVo.setRh_stlncd_sum_sd_lmt(custCard2ResVo.getRh_stlncd_sum_sd_lmt() + Integer.valueOf(sLoancard_shareCreditLimitAmount.get(i)));
                            //总透支额度
                            custCard2ResVo.setRh_stlncd_sum_ud_cr_lmt(custCard2ResVo.getRh_stlncd_sum_ud_cr_lmt() + Integer.valueOf(sLoancard_usedCreditLimitAmount.get(i)));

                            //未销户人民币账户准贷记卡透支余额比
                            if (Integer.valueOf(sLoancard_creditLimitAmount.get(i)) != 0) {
                                //透支额度有值账户数
                                if (Integer.valueOf(sLoancard_usedCreditLimitAmount.get(i)) != 0) {
                                    rh_stlncd_ud_cr_lmt_sum += 1;
                                }
                                rh_stlncd_uc_amt_pro = BigDecimalUtil.divide(new BigDecimal(sLoancard_usedCreditLimitAmount.get(i)),
                                        new BigDecimal(sLoancard_creditLimitAmount.get(i)), rh_stlncd_uc_amt_pro);
                                rh_stlncd_uc_amt_pro_sum = rh_stlncd_uc_amt_pro_sum.add(rh_stlncd_uc_amt_pro);
                                //todo rh_stlncd_uc_max_amt_pro 最大 未销户人民币账户准贷记卡最大透支余额比
                                if (custCard2ResVo.getRh_stlncd_uc_max_amt_pro().compareTo(rh_stlncd_uc_amt_pro) < 0) {
                                    custCard2ResVo.setRh_stlncd_uc_max_amt_pro(rh_stlncd_uc_amt_pro);
                                }
                                //最小已用额度比
                                if (rh_stlncd_uc_min_amt_pro.compareTo(rh_stlncd_uc_amt_pro) > 0) {
                                    rh_stlncd_uc_min_amt_pro = rh_stlncd_uc_amt_pro;
                                }
                            }
                            //todo rh_stlncd_sum_max_ud_amt 人民币未销户准贷记卡最大透支余额之和
                            custCard2ResVo.setRh_stlncd_sum_max_ud_amt(custCard2ResVo.getRh_stlncd_sum_max_ud_amt() + s_usedHighestAmount);
                            if (Integer.valueOf(sLoancard_shareCreditLimitAmount.get(i)) != 0) {//修改
                                rh_stlncd_ud_sd_lmt_pr = BigDecimalUtil.divide(new BigDecimal(sLoancard_usedCreditLimitAmount.get(i)),
                                        new BigDecimal(sLoancard_shareCreditLimitAmount.get(i)), rh_stlncd_ud_sd_lmt_pr);

                                if (!rh_stlncd_ud_sd_lmt_pr.equals(new BigDecimal(0))) {
                                    rh_stlncd_ud_sd_lmt_pr_num += 1;
                                }
                                rh_stlncd_ud_sd_lmt_pr_sum = rh_stlncd_ud_sd_lmt_pr_sum.
                                        add(rh_stlncd_ud_sd_lmt_pr);
                                //最大共享比
                                if (custCard2ResVo.getRh_stlncd_max_ud_sd_lmt_pr().compareTo(rh_stlncd_ud_sd_lmt_pr) < 0) {
                                    custCard2ResVo.setRh_stlncd_max_ud_sd_lmt_pr(rh_stlncd_ud_sd_lmt_pr);
                                }
                                //最小共享比
                                if (rh_stlncd_min_ud_sd_lmt_pr.compareTo(rh_stlncd_ud_sd_lmt_pr) > 0) {
                                    rh_stlncd_min_ud_sd_lmt_pr = rh_stlncd_ud_sd_lmt_pr;
                                }

                            }


                            if (Integer.valueOf(sLoancard_creditLimitAmount.get(i)) != 0) {
                                rh_stlncd_cr_lmt_sum += 1;
                            }
                            //todo rh_stlncd_max_max_ud_amt 未销户最大最大使用额度 人民币未销户准贷记卡最大透支余额最大值
                            if (custCard2ResVo.getRh_stlncd_max_max_ud_amt() < s_usedHighestAmount) {
                                custCard2ResVo.setRh_stlncd_max_max_ud_amt(s_usedHighestAmount);
                            }
                            if (!sLoancard_state.get(i).equals("6") && !sLoancard_latest24State.get(i).equals("")) {
                                //单张卡逾期次数
                                int vd_ct_2y_rp = sLoancard_latest24State.get(i).length() - sLoancard_latest24State.get(i).replaceAll("[1-7]", "").length();
                                //todo rh_stlncd_ovd_ct_2y_rp 准贷记卡近2年内逾期月份数
                                custCard2ResVo.setRh_stlncd_ovd_ct_2y_rp(custCard2ResVo.getRh_stlncd_ovd_ct_2y_rp() + vd_ct_2y_rp);
                                //单张卡逾期90天以上次数
                                Integer nonpmf_ct_2y_rp = sLoancard_latest24State.get(i).length() - sLoancard_latest24State.get(i).replaceAll("[4-7]", "").length();
                                //todo rh_stlncd_nonpmf_ct_2y_rp 准贷记卡近2年内逾期90天以上月份数
                                custCard2ResVo.setRh_stlncd_nonpmf_ct_2y_rp(custCard2ResVo.getRh_stlncd_nonpmf_ct_2y_rp() + nonpmf_ct_2y_rp);
                            }


                        }
                        switch (sLoancard_state.get(i)) {

                            case "6": {
                                //todo rh_stlncd_nopen_num 未激活人民币准贷记卡账户数
                                custCard2ResVo.setRh_stlncd_nopen_num(custCard2ResVo.getRh_stlncd_nopen_num() + 1);
                                break;
                            }
                            case "4": {
                                //todo rh_stlncd_cancel_num 已销户人民币准贷记卡账户数
                                custCard2ResVo.setRh_stlncd_cancel_num(custCard2ResVo.getRh_stlncd_cancel_num() + 1);
                                break;
                            }

                            case "1": {
                                if (rh_stlncd_age <= 6) {
                                    rh_stlncd_hv_num_m6 += 1;
                                    //todo rh_stlncd_nr_sum_cr_lmt_m6 近6个月正常状态人民币账户准贷记卡总授信额度
                                    custCard2ResVo.setRh_stlncd_nr_sum_cr_lmt_m6(custCard2ResVo.getRh_stlncd_nr_sum_cr_lmt_m6() + Integer.valueOf(sLoancard_creditLimitAmount.get(i)));
                                }
                                //todo rh_stlncd_nr_num 正常人民币准贷记卡账户数
                                custCard2ResVo.setRh_stlncd_nr_num(custCard2ResVo.getRh_stlncd_nr_num() + 1);
                                //todo 正常状态人民币账户准贷记卡总授信额度
                                custCard2ResVo.setRh_stlncd_nr_sum_cr_lmt(custCard2ResVo.getRh_stlncd_nr_sum_cr_lmt() + Integer.valueOf(sLoancard_creditLimitAmount.get(i)));
                                //todo rh_stlncd_nr_sum_sd_lmt 总共享额度 正常状态人民币账户准贷记卡总共享额度
                                custCard2ResVo.setRh_stlncd_nr_sum_sd_lmt(custCard2ResVo.getRh_stlncd_nr_sum_sd_lmt() + Integer.valueOf(sLoancard_shareCreditLimitAmount.get(i)));

                                if (Integer.valueOf(sLoancard_shareCreditLimitAmount.get(i)) != 0) {
                                    rh_stlncd_nr_sd_lmt_sum += 1;
                                }

                                //todo  rh_stlncd_nr_max_cr_lmt 最大授信额度 正常状态人民币账户准贷记卡最大授信额度
                                if (custCard2ResVo.getRh_stlncd_nr_max_cr_lmt() < Integer.valueOf(sLoancard_creditLimitAmount.get(i))) {
                                    custCard2ResVo.setRh_stlncd_nr_max_cr_lmt(Integer.valueOf(sLoancard_creditLimitAmount.get(i)));
                                }


                                if (custCard2ResVo.getRh_stlncd_nr_min_cr_lmt() > Integer.valueOf(sLoancard_creditLimitAmount.get(i))) {
                                    custCard2ResVo.setRh_stlncd_nr_min_cr_lmt(Integer.valueOf(sLoancard_creditLimitAmount.get(i)));
                                }
                                if (custCard2ResVo.getRh_stlncd_nr_max_sd_lmt() < Integer.valueOf(sLoancard_shareCreditLimitAmount.get(i))) {
                                    custCard2ResVo.setRh_stlncd_nr_max_sd_lmt(Integer.valueOf(sLoancard_shareCreditLimitAmount.get(i)));
                                }

                                if (custCard2ResVo.getRh_stlncd_nr_max_ud_cr_lmt() < Integer.valueOf(sLoancard_usedCreditLimitAmount.get(i))) {
                                    custCard2ResVo.setRh_stlncd_nr_max_ud_cr_lmt(Integer.valueOf(sLoancard_usedCreditLimitAmount.get(i)));
                                }
                                if (Integer.valueOf(sLoancard_creditLimitAmount.get(i)) != 0) {
                                    rh_stlncd_nr_ud_cr_lmt_pr = new BigDecimal(sLoancard_usedCreditLimitAmount.get(i)).divide(new BigDecimal(sLoancard_creditLimitAmount.get(i)), 2, 4);
                                    if (Integer.valueOf(sLoancard_usedCreditLimitAmount.get(i)) != 0) {
                                        rh_stlncd_nr_ud_cr_lmt_pr_num += 1;
                                    }
                                    if (!"0".equals(sLoancard_usedCreditLimitAmount.get(i))) {
                                        ++rh_stlncd_nr_ud_cr_lmt_pr_count;
                                    }
                                    rh_stlncd_nr_ud_cr_lmt_pr_sum = rh_stlncd_nr_ud_cr_lmt_pr_sum.
                                            add(rh_stlncd_nr_ud_cr_lmt_pr);
                                    //todo rh_stlncd_nr_max_ud_cr_lmt_pr 正常状态人民币账户准贷记卡最大透支余额比
                                    if (custCard2ResVo.getRh_stlncd_nr_max_ud_cr_lmt_pr().compareTo(rh_stlncd_nr_ud_cr_lmt_pr) < 0) {
                                        custCard2ResVo.setRh_stlncd_nr_max_ud_cr_lmt_pr(rh_stlncd_nr_ud_cr_lmt_pr);
                                    }

                                    if (rh_stlncd_nr_min_ud_cr_lmt_pr.compareTo(rh_stlncd_nr_ud_cr_lmt_pr) > 0) {
                                        rh_stlncd_nr_min_ud_cr_lmt_pr = rh_stlncd_nr_ud_cr_lmt_pr;
                                    }
                                }
                                if (Integer.valueOf(sLoancard_shareCreditLimitAmount.get(i)) != 0) {
                                    if (Integer.valueOf(sLoancard_usedCreditLimitAmount.get(i)) != 0) {
                                        ++rh_stlncd_nr_mn_ud_sd_lmt_pr_count;
                                    }
                                    rh_stlncd_nr_ud_sd_lmt_pr = new BigDecimal(sLoancard_usedCreditLimitAmount.get(i)).
                                            divide(new BigDecimal(sLoancard_shareCreditLimitAmount.get(i)), 2, 4);
                                    rh_stlncd_nr_mn_ud_sd_lmt_pr_sum = rh_stlncd_nr_mn_ud_sd_lmt_pr_sum.
                                            add(rh_stlncd_nr_ud_sd_lmt_pr);
                                    //todo rh_stlncd_nr_max_ud_sd_lmt_pr 正常状态人民币账户准贷记卡最大透支共享额度比
                                    if (custCard2ResVo.getRh_stlncd_nr_max_ud_sd_lmt_pr().compareTo(rh_stlncd_nr_ud_sd_lmt_pr) < 0) {
                                        custCard2ResVo.setRh_stlncd_nr_max_ud_sd_lmt_pr(rh_stlncd_nr_ud_sd_lmt_pr);
                                    }

                                    if (rh_stlncd_nr_min_ud_sd_lmt_pr.compareTo(rh_stlncd_nr_ud_sd_lmt_pr) > 0) {
                                        rh_stlncd_nr_min_ud_sd_lmt_pr = rh_stlncd_nr_ud_sd_lmt_pr;
                                    }
                                }
                                break;
                            }
                        }
                    } else {
                        //todo rh_stlncd_oc_num 外币准贷记卡账户数
                        custCard2ResVo.setRh_stlncd_oc_num(custCard2ResVo.getRh_stlncd_oc_num() + 1);
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            //todo rh_stlncd_avg_cr_lmt 未销户人民币账户准贷记卡平均授信额度(有值账户平均)
            custCard2ResVo.setRh_stlncd_avg_cr_lmt(BigDecimalUtil.divide(new BigDecimal(custCard2ResVo.getRh_stlncd_sum_cr_lmt()),
                    new BigDecimal(rh_stlncd_cr_lmt_sum), custCard2ResVo.getRh_stlncd_avg_cr_lmt()));

            //todo rh_stlncd_mn_cr_lmt 未销户人民币账户准贷记卡平均授信额度(所有账户平均)
            custCard2ResVo.setRh_stlncd_mn_cr_lmt(BigDecimalUtil.divide(new BigDecimal(custCard2ResVo.getRh_stlncd_sum_cr_lmt()),
                    new BigDecimal(custCard2ResVo.getRh_stlncd_uc_num()), custCard2ResVo.getRh_stlncd_mn_cr_lmt()));
            //todo rh_stlncd_mn_sd_lmt 未销户人民币账户准贷记卡平均共享额度(所有账户平均)
            custCard2ResVo.setRh_stlncd_mn_sd_lmt(BigDecimalUtil.divide(new BigDecimal(custCard2ResVo.getRh_stlncd_sum_sd_lmt()),
                    new BigDecimal(custCard2ResVo.getRh_stlncd_uc_num()), custCard2ResVo.getRh_stlncd_mn_sd_lmt()));
            //todo rh_stlncd_mn_ud_cr_lmt 未销户人民币账户准贷记卡平均透支余额(所有账户平均)
            custCard2ResVo.setRh_stlncd_mn_ud_cr_lmt(BigDecimalUtil.divide(new BigDecimal(custCard2ResVo.getRh_stlncd_sum_ud_cr_lmt()),
                    new BigDecimal(custCard2ResVo.getRh_stlncd_uc_num()), custCard2ResVo.getRh_stlncd_mn_ud_cr_lmt()));
            //todo rh_stlncd_mn_ud_cr_lmt_pr 未销户人民币账户准贷记卡平均透支余额比(所有账户平均)
            custCard2ResVo.setRh_stlncd_mn_ud_cr_lmt_pr(BigDecimalUtil.divide(rh_stlncd_uc_amt_pro_sum,
                    new BigDecimal(custCard2ResVo.getRh_stlncd_uc_num()), custCard2ResVo.getRh_stlncd_mn_ud_cr_lmt_pr()));

            //todo rh_stlncd_nr_mn_cr_lmt 正常状态人民币账户准贷记卡平均授信额度(所有正常状态账户平均)
            custCard2ResVo.setRh_stlncd_nr_mn_cr_lmt(BigDecimalUtil.divide(new BigDecimal(custCard2ResVo.getRh_stlncd_nr_sum_cr_lmt()),
                    new BigDecimal(custCard2ResVo.getRh_stlncd_nr_num()), custCard2ResVo.getRh_stlncd_nr_mn_cr_lmt()));
            //todo rh_stlncd_nr_mn_sd_lmt 正常状态人民币账户准贷记卡平均共享额度(所有正常状态账户平均)
            custCard2ResVo.setRh_stlncd_nr_mn_sd_lmt(BigDecimalUtil.divide(new BigDecimal(custCard2ResVo.getRh_stlncd_nr_sum_sd_lmt()),
                    new BigDecimal(custCard2ResVo.getRh_stlncd_nr_num()), custCard2ResVo.getRh_stlncd_nr_mn_sd_lmt()));
            //todo rh_stlncd_nr_avg_sd_lmt 正常状态人民币账户准贷记卡平均共享额度(有值正常状态账户平均)
            custCard2ResVo.setRh_stlncd_nr_avg_sd_lmt(BigDecimalUtil.divide(new BigDecimal(custCard2ResVo.getRh_stlncd_nr_sum_sd_lmt()),
                    new BigDecimal(rh_stlncd_nr_sd_lmt_sum), custCard2ResVo.getRh_stlncd_nr_avg_sd_lmt()));

            //todo rh_stlncd_sum_ud_cr_lmt_pr 未销户人民币账户准贷记卡总透支余额比(所有账户)
            custCard2ResVo.setRh_stlncd_sum_ud_cr_lmt_pr(BigDecimalUtil.divide(new BigDecimal(custCard2ResVo.getRh_stlncd_sum_ud_cr_lmt()),
                    new BigDecimal(custCard2ResVo.getRh_stlncd_sum_cr_lmt()), custCard2ResVo.getRh_stlncd_sum_ud_cr_lmt_pr()));

            //todo rh_stlncd_sum_ud_sd_lmt_pr 未销户人民币账户准贷记卡总透支共享额度比(所有账户平均)
            custCard2ResVo.setRh_stlncd_sum_ud_sd_lmt_pr(BigDecimalUtil.divide(new BigDecimal(custCard2ResVo.getRh_stlncd_sum_ud_cr_lmt()),
                    new BigDecimal(custCard2ResVo.getRh_stlncd_sum_sd_lmt()), custCard2ResVo.getRh_stlncd_sum_ud_sd_lmt_pr()));


            //todo rh_stlncd_nr_sum_ud_cr_lmt_pr 正常状态人民币账户准贷记卡总透支余额比(所有账户平均)
            custCard2ResVo.setRh_stlncd_nr_sum_ud_cr_lmt_pr(BigDecimalUtil.divide(new BigDecimal(custCard2ResVo.getRh_stlncd_nr_sum_ud_cr_lmt()),
                    new BigDecimal(custCard2ResVo.getRh_stlncd_nr_sum_cr_lmt()), custCard2ResVo.getRh_stlncd_nr_sum_ud_cr_lmt_pr()));


            //todo 人民币贷记卡账户数（指标待加工）

            //todo 未销户人民币贷记卡账户数

            //定义默认值
            int tota_shard_qu = 0;
            int la_m6_ave_use = 0;
            int ave_age_m6_cre_of_cr = 0;
            int sem_cr_li_of_cr = 0;
            int sem_cr_sv_balance = 0;
            int ave_age_max_ove_li_cr = 0;
            int use_lim_of_un_max = custCard2ResVo.getRh_stlncd_sum_max_ud_amt() + custCard2ResVo.getRh_lncd_sum_max_ud_amt();
            int tota_qu_re_nor_sta = 0;
            int tota_ou_stand_Loan = 0;
            int total_balance = 0;

            List la_m6_ave_use_list = new ArrayList<>();
            List la_m6_use_max_ave_list = new ArrayList<>();
            List ave_age_m6_cr_cr_list = new ArrayList<>();
            List ave_age_max_ove_li_cr_list = new ArrayList<>();
            List open_date_max_list = new ArrayList<>();
            List<Integer> ou_sta_loan_ba_m12_list = new ArrayList<>();
            List max_sha_quo_mon_list = new ArrayList<>();

            //贷记卡总已用额度
            List no_qu_us_list = new ArrayList();

            //正常贷记卡有值账户数
            int loancardCreditLimitAmountCount = 0;

            for (int i = 0; i < loancardState.size(); i++) {
                try {
                    Date openDate = DateUtil.parseDate(openDates.get(i), "yyyy-MM-dd");
                    open_date_max_list.add(openDate);
                    if ("1".equals(loancardState.get(i)) && "CNY".equals(currency.get(i))) {
                        if (Integer.parseInt(loancardCreditLimitAmount.get(i)) != 0) {
                            loancardCreditLimitAmountCount++;
                        }
                        if (StringUtils.isNotBlank(shareCreditLimitAmount.get(i).toString())) {
                            //todo 正常状态人民币账户贷记卡总共享额度
                            tota_shard_qu += Integer.parseInt(shareCreditLimitAmount.get(i));
                        }
                        if (formatDate.getTime() - openDate.getTime() <= yearTime) {
                            // 近12个月正常人民币信用卡账户数
                            custCard2ResVo.setRh_crc_nr_num_m12(custCard2ResVo.getRh_crc_nr_num_m12() + 1);
                            if (Integer.parseInt(loancardCreditLimitAmount.get(i)) != 0) {
                                // 近12个月正常状态人民币账户信用卡总授信额度
                                tota_qu_re_nor_sta += Integer.parseInt(loancardCreditLimitAmount.get(i));
                            }
                        }
                        if (formatDate.getTime() - openDate.getTime() <= halfYearTime) {
                            //近6个月正常人民币信用卡账户数
                            custCard2ResVo.setRh_crc_nr_num_m6(custCard2ResVo.getRh_crc_nr_num_m6() + 1);
                            if (Integer.parseInt(loancardCreditLimitAmount.get(i)) != 0) {
                                // 近6个月正常状态人民币账户贷记卡平均授信额度(有值正常状态账户平均)
                                ave_age_m6_cr_cr_list.add(loancardCreditLimitAmount.get(i));
                            }
                        }
                    }
                    // 人民币未销户信用卡最大使用额度均值
                    if (!"4".equals(loancardState.get(i)) && "CNY".equals(currency.get(i))) {
                        // 人民币未销户贷记卡最近6个月平均使用额度最大值
                        la_m6_use_max_ave_list.add(lates6MonthUsedAvgAmount.get(i).intValue());

                        if (StringUtils.isNotBlank(lates6MonthUsedAvgAmount.get(i).toString())) {
                            // 人民币未销户贷记卡最近6个月平均使用额度均值
                            la_m6_ave_use_list.add(lates6MonthUsedAvgAmount.get(i).intValue());
                        }
                        // 近6个月未销户人民币账户信用卡最大共享额度
                        if (formatDate.getTime() - openDate.getTime() <= halfYearTime) {
                            max_sha_quo_mon_list.add(Integer.valueOf(shareCreditLimitAmount.get(i)));
                        }
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            //todo 正常人民币贷记卡账户数

            //todo 未激活人民币贷记卡账户数

            //todo 已销户人民币贷记卡账户数

            //todo 外币贷记卡账户数

            //todo 未销户人民币账户贷记卡总授信额度

            //todo rh_lncd_avg_cr_lmt 未销户人民币账户贷记卡平均授信额度(有值账户平均)
            custCard2ResVo.setRh_lncd_avg_cr_lmt(BigDecimalUtil.divide(new BigDecimal(
                    custCard2ResVo.getRh_lncd_sum_cr_lmt()), new BigDecimal(rh_lncd_uc_cv_num), custCard2ResVo.getRh_lncd_avg_cr_lmt()));

            //todo rh_lncd_mn_cr_lmt 未销户人民币账户贷记卡平均授信额度(所有账户平均)
            custCard2ResVo.setRh_lncd_mn_cr_lmt(BigDecimalUtil.divide(new BigDecimal(
                    custCard2ResVo.getRh_lncd_sum_cr_lmt()), new BigDecimal(custCard2ResVo.getRh_lncd_uc_num()), custCard2ResVo.getRh_lncd_mn_cr_lmt()));

            //todo 未销户人民币账户贷记卡总共享额度

            //todo rh_lncd_avg_sd_lmt 未销户人民币账户贷记卡平均共享额度(有值账户平均)
            custCard2ResVo.setRh_lncd_avg_sd_lmt(BigDecimalUtil.divide(new BigDecimal(custCard2ResVo.getRh_lncd_sum_sd_lmt()),
                    new BigDecimal(shareCreditLimitAmountCount), custCard2ResVo.getRh_lncd_avg_sd_lmt()));

            //todo rh_lncd_mn_sd_lmt 未销户人民币账户贷记卡平均共享额度(所有账户平均)
            custCard2ResVo.setRh_lncd_mn_sd_lmt(BigDecimalUtil.divide(new BigDecimal(custCard2ResVo.getRh_lncd_sum_sd_lmt()),
                    new BigDecimal(custCard2ResVo.getRh_lncd_uc_num()), custCard2ResVo.getRh_lncd_mn_sd_lmt()));

            //todo 未销户人民币账户贷记卡最大共享额度
            //todo 未销户人民币账户贷记卡最小共享额度

            //todo 正常状态人民币账户贷记卡总授信额度

            //todo 正常状态人民币账户贷记卡最大授信额度

            //todo rh_lncd_sum_nr_sd_lmt 正常状态人民币账户贷记卡总共享额度
            custCard2ResVo.setRh_lncd_sum_nr_sd_lmt(tota_shard_qu);

            //todo rh_lncd_nr_avg_sd_lmt 正常状态人民币账户贷记卡平均共享额度(有值正常状态账户平均)
            custCard2ResVo.setRh_lncd_nr_avg_sd_lmt(BigDecimalUtil.divide(new BigDecimal(tota_shard_qu)
                    , new BigDecimal(shareCreditLimitAmountCount1), custCard2ResVo.getRh_lncd_nr_avg_sd_lmt()));

            //todo rh_lncd_nr_mn_sd_lmt 正常状态人民币账户贷记卡平均共享额度(所有正常状态账户平均)
            custCard2ResVo.setRh_lncd_nr_mn_sd_lmt(BigDecimalUtil.divide(new BigDecimal(tota_shard_qu)
                    , new BigDecimal(custCard2ResVo.getRh_lncd_nr_num()), custCard2ResVo.getRh_lncd_nr_mn_sd_lmt()));

            //todo 正常状态人民币账户贷记卡最大共享额度

            //todo 未销户人民币账户贷记卡总已用额度
            //todo rh_lncd_mn_ud_cr_lmt 未销户人民币账户贷记卡平均已用额度(所有账户平均)    PBCCRLoanTraitsServiceImpl被注释了
            custCard2ResVo.setRh_lncd_mn_ud_cr_lmt(BigDecimalUtil.divide(new BigDecimal(custCard2ResVo.getRh_lncd_sum_ud_cr_lmt()),
                    new BigDecimal(custCard2ResVo.getRh_lncd_uc_num()), custCard2ResVo.getRh_lncd_mn_ud_cr_lmt()));
            //todo 未销户人民币账户贷记卡最大已用额度
            //todo 未销户人民币账户贷记卡最小已用额度
            //todo 正常状态人民币账户贷记卡总已用额度
            //todo rh_lncd_nr_mn_ud_cr_lmt 正常状态人民币账户贷记卡平均已用额度(所有账户平均)
            custCard2ResVo.setRh_lncd_nr_mn_ud_cr_lmt(BigDecimalUtil.divide(new BigDecimal(rh_lncd_sum_nr_ud_cr_lmt),
                    new BigDecimal(custCard2ResVo.getRh_lncd_nr_num()), custCard2ResVo.getRh_lncd_nr_mn_ud_cr_lmt()));
            //todo 正常状态人民币账户贷记卡最大已用额度
            //todo rh_lncd_nr_min_ud_cr_lmt_m12 近12个月正常状态人民币账户贷记卡最小已用额度
            custCard2ResVo.setRh_lncd_nr_min_ud_cr_lmt_m12(no_qu_us_list.size() == 0 ? 0 : parseInt(Collections.min(no_qu_us_list).toString()));
            //todo 未销户人民币账户贷记卡最大已用额度比

            //todo rh_lncd_avg_ud_cr_lmt_pr 未销户人民币账户贷记卡平均已用额度比(有值账户平均)
            custCard2ResVo.setRh_lncd_avg_ud_cr_lmt_pr(BigDecimalUtil.divide(rh_lncd_uc_sum_amt_pro,
                    new BigDecimal(rh_lncd_sum_ud_cr_lmt_pr_num), custCard2ResVo.getRh_lncd_avg_ud_cr_lmt_pr()));
            //todo rh_lncd_mn_ud_cr_lmt_pr 未销户人民币账户贷记卡平均已用额度比(所有账户平均)
            custCard2ResVo.setRh_lncd_mn_ud_cr_lmt_pr(BigDecimalUtil.divide(rh_lncd_uc_sum_amt_pro,
                    new BigDecimal(custCard2ResVo.getRh_lncd_uc_num()), custCard2ResVo.getRh_lncd_mn_ud_cr_lmt_pr()));
            //todo rh_lncd_sum_ud_cr_lmt_pr 未销户人民币账户贷记卡总已用额度比(所有账户平均)
            custCard2ResVo.setRh_lncd_sum_ud_cr_lmt_pr(BigDecimalUtil.divide(new BigDecimal(custCard2ResVo.getRh_lncd_sum_ud_cr_lmt()),
                    new BigDecimal(custCard2ResVo.getRh_lncd_sum_cr_lmt()), custCard2ResVo.getRh_lncd_sum_ud_cr_lmt_pr()));
            //todo 未销户人民币账户贷记卡最大已用共享额度比

            //todo rh_lncd_avg_ud_sd_lmt_pr 未销户人民币账户贷记卡平均已用共享额度比(有值账户平均)
            custCard2ResVo.setRh_lncd_avg_ud_sd_lmt_pr(BigDecimalUtil.divide(rh_lncd_ud_sd_lmt_pr_sum,
                    new BigDecimal(rh_lncd_ud_sd_lmt_pr_num), custCard2ResVo.getRh_lncd_avg_ud_sd_lmt_pr()));
            //todo rh_lncd_mn_ud_sd_lmt_pr 未销户人民币账户贷记卡平均已用共享额度比(所有账户平均)
            custCard2ResVo.setRh_lncd_mn_ud_sd_lmt_pr(BigDecimalUtil.divide(
                    rh_lncd_ud_sd_lmt_pr_sum, new BigDecimal(custCard2ResVo.getRh_lncd_uc_num()), custCard2ResVo.getRh_lncd_mn_ud_sd_lmt_pr()));
            //todo rh_lncd_sum_ud_sd_lmt_pr 未销户人民币账户贷记卡总已用共享额度比(所有账户平均)
            custCard2ResVo.setRh_lncd_sum_ud_sd_lmt_pr(BigDecimalUtil.divide(new BigDecimal(custCard2ResVo.getRh_lncd_sum_nr_ud_cr_lmt()),
                    new BigDecimal(custCard2ResVo.getRh_lncd_sum_sd_lmt()), custCard2ResVo.getRh_lncd_sum_ud_sd_lmt_pr()));
            //todo 正常状态人民币账户贷记卡最大已用额度比

            //todo rh_lncd_nr_avg_ud_cr_lmt 正常状态人民币账户贷记卡平均已用额度(有值账户平均)
            custCard2ResVo.setRh_lncd_nr_avg_ud_cr_lmt(BigDecimalUtil.divide(rh_lncd_nr_avg_ud_cr_lmt,
                    new BigDecimal(usedCreditLimitAmountBeanCount1), custCard2ResVo.getRh_lncd_nr_avg_ud_cr_lmt()));
            //todo rh_lncd_nr_avg_ud_cr_lmt_pr 正常状态人民币账户贷记卡平均已用额度比(有值账户平均)
            custCard2ResVo.setRh_lncd_nr_avg_ud_cr_lmt_pr(BigDecimalUtil.divide(rh_lncd_nr_ud_cr_lmt_pr_sum,
                    new BigDecimal(rh_lncd_nr_ud_cr_lmt_pr_num), custCard2ResVo.getRh_lncd_nr_avg_ud_cr_lmt_pr()));
            //todo rh_lncd_nr_mn_ud_cr_lmt_pr 正常状态人民币账户贷记卡平均已用额度比(所有账户平均)
            custCard2ResVo.setRh_lncd_nr_mn_ud_cr_lmt_pr(BigDecimalUtil.divide(rh_lncd_nr_ud_cr_lmt_pr_sum,
                    new BigDecimal(custCard2ResVo.getRh_lncd_nr_num()), custCard2ResVo.getRh_lncd_nr_mn_ud_cr_lmt_pr()));

            //todo rh_lncd_sum_nr_ud_cr_lmt_pr 正常状态人民币账户贷记卡总已用额度比(所有账户平均)
            custCard2ResVo.setRh_lncd_sum_nr_ud_cr_lmt_pr(BigDecimalUtil.divide(new BigDecimal(custCard2ResVo.getRh_lncd_sum_nr_ud_cr_lmt()),
                    new BigDecimal(custCard2ResVo.getRh_lncd_sum_nr_cr_lmt()), custCard2ResVo.getRh_lncd_sum_nr_ud_cr_lmt_pr()));

            //todo 正常状态人民币账户贷记卡最大已用共享额度比

            //todo rh_lncd_nr_avg_ud_sd_lmt_pr 正常状态人民币账户贷记卡平均已用共享额度比(有值账户平均)
            custCard2ResVo.setRh_lncd_nr_avg_ud_sd_lmt_pr(BigDecimalUtil.divide(rh_lncd_nr_ud_sd_lmt_pr_sum, new BigDecimal(rh_lncd_nr_ud_sd_lmt_pr_num),
                    custCard2ResVo.getRh_lncd_nr_avg_ud_sd_lmt_pr()));
            //todo rh_lncd_nr_mn_ud_sd_lmt_pr 正常状态人民币账户贷记卡平均已用共享额度比(所有账户平均)
            custCard2ResVo.setRh_lncd_nr_mn_ud_sd_lmt_pr(BigDecimalUtil.divide(rh_lncd_nr_ud_sd_lmt_pr_sum, new BigDecimal(custCard2ResVo.getRh_lncd_nr_num()),
                    custCard2ResVo.getRh_lncd_nr_mn_ud_sd_lmt_pr()));
            //todo rh_lncd_sum_nr_ud_sd_lmt_pr 正常状态人民币账户贷记卡总已用共享额度比(所有账户平均)
            custCard2ResVo.setRh_lncd_sum_nr_ud_sd_lmt_pr(BigDecimalUtil.divide(new BigDecimal(custCard2ResVo.getRh_lncd_sum_nr_ud_cr_lmt()),
                    new BigDecimal(custCard2ResVo.getRh_lncd_sum_nr_sd_lmt()), custCard2ResVo.getRh_lncd_sum_nr_ud_sd_lmt_pr()));
            //todo rh_lncd_avg_m6avg_ud_amt 人民币未销户贷记卡最近6个月平均使用额度均值
            for (int i = 0; i < la_m6_ave_use_list.size(); i++) {
                try {
                    la_m6_ave_use += parseInt(la_m6_ave_use_list.get(i).toString());
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            custCard2ResVo.setRh_lncd_avg_m6avg_ud_amt(new BigDecimal(la_m6_ave_use_list.size() != 0 ? la_m6_ave_use / la_m6_ave_use_list.size() : 0));

            //todo rh_lncd_max_m6avg_ud_amt 人民币未销户贷记卡最近6个月平均使用额度最大值
            custCard2ResVo.setRh_lncd_max_m6avg_ud_amt(la_m6_use_max_ave_list.size() != 0 ? parseInt(Collections.max(la_m6_use_max_ave_list).toString()) : 0);
            //todo rh_lncd_avg_max_ud_amt 人民币未销户贷记卡最大使用额度均值
            if (custCard2ResVo.getRh_lncd_uc_num() != 0) {
                custCard2ResVo.setRh_lncd_avg_max_ud_amt(custCard2ResVo.getRh_lncd_sum_max_ud_amt() / custCard2ResVo.getRh_lncd_uc_num());
            }

            //todo 人民币未销户贷记卡最大使用额度最大值
            custCard2ResVo.setRh_crc_max_max_ud_amt(Integer.max(custCard2ResVo.getRh_lncd_max_max_ud_amt(), custCard2ResVo.getRh_stlncd_max_max_ud_amt()));

            //todo 人民币未销户贷记卡最大使用额度之和

            //todo 贷记卡近2年内逾期月份数

            //todo 近6个月未销户人民币账户贷记卡最大共享额度

            //todo 近6个月正常状态人民币账户贷记卡总授信额度

            //todo  rh_lncd_nr_avg_cr_lmt_m6 近6个月正常状态人民币账户贷记卡平均授信额度(有值正常状态账户平均)
            for (int i = 0; i < ave_age_m6_cr_cr_list.size(); i++) {
                try {
                    ave_age_m6_cre_of_cr += parseInt(ave_age_m6_cr_cr_list.get(i).toString());
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            custCard2ResVo.setRh_lncd_nr_avg_cr_lmt_m6(new BigDecimal(ave_age_m6_cr_cr_list.size() != 0 ? ave_age_m6_cre_of_cr / ave_age_m6_cr_cr_list.size() : 0));

            //todo 近6个月正常人民币贷记卡账户数

            //todo  rh_lncd_nr_avg_cr_lmt 正常状态人民币账户贷记卡平均授信额度(有值正常状态账户平均)
            custCard2ResVo.setRh_lncd_nr_avg_cr_lmt(BigDecimalUtil.divide(new BigDecimal(custCard2ResVo.getRh_lncd_sum_nr_cr_lmt()), new BigDecimal(loancardCreditLimitAmountCount), custCard2ResVo.getRh_lncd_nr_avg_cr_lmt()));
            //todo  rh_lncd_mn_cr_lmt_m12 近12个月未销户人民币账户贷记卡平均授信额度(所有账户平均)
            custCard2ResVo.setRh_lncd_mn_cr_lmt_m12(custCard2ResVo.getRh_lncd_uc_num_m12() == 0 ? new BigDecimal(0) : new BigDecimal(custCard2ResVo.getRh_lncd_sum_cr_lmt_m12()).divide(new BigDecimal(custCard2ResVo.getRh_lncd_uc_num_m12()), 2, BigDecimal.ROUND_HALF_UP));
            //todo rh_lncd_nr_mn_cr_lmt_m12 近12个月正常状态人民币账户贷记卡平均授信额度(所有正常状态账户平均)
            custCard2ResVo.setRh_lncd_nr_mn_cr_lmt_m12(BigDecimalUtil.divide(new BigDecimal(custCard2ResVo.getRh_lncd_sum_nr_cr_lmt_m12()),
                    new BigDecimal(custCard2ResVo.getRh_lncd_nr_num_m12()), custCard2ResVo.getRh_lncd_nr_mn_cr_lmt_m12()));
            //todo 贷记卡逾期180天以上未归还贷款本金
            //custCard2ResVo.setRh_crc_od180amt_sum_amt(custCard2ResVo.getRh_lncd_od180amt_sum_amt());

            //todo 评级为一般逾期的贷记卡账户数目

            //todo rh_lncd_old_age 最早贷记卡开户日距今月份数
            custCard2ResVo.setRh_lncd_old_age(DateUtil.monthBetween(new Date(), opendate_min));
            //todo rh_crc_max_age 信用卡最大账龄
            custCard2ResVo.setRh_crc_max_age(custCard2ResVo.getRh_lncd_detail_max_age() > rh_stlncd_detail_max_age ?
                    custCard2ResVo.getRh_lncd_detail_max_age() : rh_stlncd_detail_max_age);
            //todo 正常人民币准贷记卡账户数

            //todo 未激活人民币准贷记卡账户数

            //todo 已销户人民币准贷记卡账户数

            //todo 外币准贷记卡账户数

            //todo 未销户人民币账户准贷记卡平均授信额度(有值账户平均)
            //todo 未销户人民币账户准贷记卡平均授信额度(所有账户平均)
            //todo 未销户人民币账户准贷记卡平均共享额度(所有账户平均)
            //todo 正常状态人民币账户准贷记卡平均授信额度(所有正常状态账户平均)
            //todo 正常状态人民币账户准贷记卡最大授信额度

            //todo 正常状态人民币账户准贷记卡总共享额度
            //todo 正常状态人民币账户准贷记卡平均共享额度(有值正常状态账户平均)
            //todo 正常状态人民币账户准贷记卡平均共享额度(所有正常状态账户平均)
            //todo 未销户人民币账户准贷记卡平均透支余额(所有账户平均)
            //todo 未销户人民币账户准贷记卡最大透支余额比
            //todo 未销户人民币账户准贷记卡平均透支余额比(所有账户平均)
            //todo 未销户人民币账户准贷记卡总透支余额比(所有账户平均)
            //todo 未销户人民币账户准贷记卡总透支共享额度比(所有账户平均)
            //todo 正常状态人民币账户准贷记卡最大透支余额比
//todo ----------------------------------------------一下都是没检验的-------------------------------------------------------
            for (int i = 0; i < sLoancard_state.size(); i++) {
                try {
                    // 发卡日期
                    Integer s_usedHighestAmount = sLoancard_usedHighestAmounts.get(i).equals("") ? 0 : Integer.valueOf(sLoancard_usedHighestAmounts.get(i));
                    Date openDate = DateUtil.parseDate(sLoancard_openDateS.get(i), "yyyy-MM-dd");
                    open_date_max_list.add(openDate);
                    String sLoancard_openDates = sLoancard_openDateS.get(i);

                    if (!"4".equals(sLoancard_state.get(i)) && "CNY".equals(sLoancard_currency.get(i))) {
                        if (StringUtils.isNotBlank(s_usedHighestAmount.toString())) {
                            // 人民币未销户准贷记卡最大透支余额均值
                            ave_age_max_ove_li_cr_list.add(s_usedHighestAmount);
                        }

                        if (formatDate.getTime() - openDate.getTime() <= halfYearTime && StringUtils.isNotBlank(sLoancard_shareCreditLimitAmount.get(i))) {
                            //近6个月未销户人民币账户信用卡最大共享额度
                            max_sha_quo_mon_list.add(Integer.valueOf(sLoancard_shareCreditLimitAmount.get(i)));
                        }
                        custCard2ResVo.setRh_crc_uc_num(custCard2ResVo.getRh_crc_uc_num() + 1);
                        if (formatDate.getTime() - openDate.getTime() <= yearTime) {
                            if (StringUtils.isNotBlank(sLoancard_shareCreditLimitAmount.get(i))) {
                                // 近12个月未销户人民币信用卡账户数
                                custCard2ResVo.setRh_crc_uc_num_m12(custCard2ResVo.getRh_crc_uc_num_m12() + 1);
                            }
                        }
                    }

                    if ("1".equals(sLoancard_state.get(i)) && "CNY".equals(sLoancard_currency.get(i))) {
                        if (StringUtils.isNotBlank(sLoancard_usedCreditLimitAmount.get(i))) {
                            // 正常状态人民币账户准贷记卡平均透支余额比(有值账户平均)
                            sem_cr_sv_balance += Integer.valueOf(sLoancard_usedCreditLimitAmount.get(i));
                        }
                        if (StringUtils.isNotBlank(sLoancard_shareCreditLimitAmount.get(i))) {
                            sem_cr_li_of_cr += Integer.valueOf(sLoancard_shareCreditLimitAmount.get(i));
                        }
                        if (formatDate.getTime() - openDate.getTime() <= yearTime) {
                            // 近12个月正常人民币信用卡账户数
                            custCard2ResVo.setRh_crc_nr_num_m12(custCard2ResVo.getRh_crc_nr_num_m12() + 1);
                            if (Integer.valueOf(sLoancard_creditLimitAmount.get(i)) != 0) {
                                // 近12个月正常状态人民币账户信用卡总授信额度
                                tota_qu_re_nor_sta += Integer.valueOf(sLoancard_creditLimitAmount.get(i));
                            }
                        }
                        if (formatDate.getTime() - openDate.getTime() <= halfYearTime) {
                            //近6个月正常人民币信用卡账户数
                            custCard2ResVo.setRh_crc_nr_num_m6(custCard2ResVo.getRh_crc_nr_num_m6() + 1);
                        }
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }

            //todo rh_stlncd_nr_avg_ud_cr_lmt_pr 正常状态人民币账户准贷记卡平均透支余额比(有值账户平均)
            custCard2ResVo.setRh_stlncd_nr_avg_ud_cr_lmt_pr(BigDecimalUtil.divide(rh_stlncd_nr_ud_cr_lmt_pr_sum, new BigDecimal(rh_stlncd_nr_ud_cr_lmt_pr_count), custCard2ResVo.getRh_stlncd_nr_avg_ud_cr_lmt_pr()));
            //todo rh_stlncd_nr_mn_ud_cr_lmt_pr 正常状态人民币账户准贷记卡平均透支余额比(所有账户平均)
            custCard2ResVo.setRh_stlncd_nr_mn_ud_cr_lmt_pr(BigDecimalUtil.divide(rh_stlncd_nr_ud_cr_lmt_pr_sum, new BigDecimal(
                    custCard2ResVo.getRh_stlncd_nr_num()), custCard2ResVo.getRh_stlncd_nr_mn_ud_cr_lmt_pr()));

            //todo 正常状态人民币账户准贷记卡总透支余额比(所有账户平均)

            //todo 正常状态人民币账户准贷记卡最大透支共享额度比
            //todo rh_stlncd_nr_avg_ud_sd_lmt_pr 正常状态人民币账户准贷记卡平均透支共享额度比(有值账户平均)
            custCard2ResVo.setRh_stlncd_nr_avg_ud_sd_lmt_pr(BigDecimalUtil.divide(rh_stlncd_nr_mn_ud_sd_lmt_pr_sum, new BigDecimal(rh_stlncd_nr_mn_ud_sd_lmt_pr_count), custCard2ResVo.getRh_stlncd_nr_avg_ud_sd_lmt_pr()));
            //todo rh_stlncd_nr_sum_ud_sd_lmt_pr 正常状态人民币账户准贷记卡总透支共享额度比(所有账户平均)
            custCard2ResVo.setRh_stlncd_nr_sum_ud_sd_lmt_pr(BigDecimalUtil.divide(new BigDecimal(sem_cr_sv_balance),
                    new BigDecimal(sem_cr_li_of_cr), custCard2ResVo.getRh_stlncd_nr_sum_ud_sd_lmt_pr()));
            //todo rh_stlncd_avg_max_ud_amt 人民币未销户准贷记卡最大透支余额均值
            for (int i = 0; i < ave_age_max_ove_li_cr_list.size(); i++) {
                try {
                    ave_age_max_ove_li_cr += parseInt(ave_age_max_ove_li_cr_list.get(i).toString());
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            custCard2ResVo.setRh_stlncd_avg_max_ud_amt(new BigDecimal(ave_age_max_ove_li_cr_list.size() != 0 ? ave_age_max_ove_li_cr / ave_age_max_ove_li_cr_list.size() : 0));

            //todo 人民币未销户准贷记卡最大透支余额最大值
            //todo 人民币未销户准贷记卡最大透支余额之和
            //todo 准贷记卡近2年内逾期月份数
            //todo 准贷记卡近2年内逾期90天以上月份数
            //todo 近6个月正常状态人民币账户准贷记卡总授信额度
            //todo 准贷记卡透支180天以上未付余额
            // 正常状态人民币账户信用卡总授信额度
            custCard2ResVo.setRh_crc_sum_nr_cr_lmt(custCard2ResVo.getRh_lncd_sum_nr_cr_lmt() + custCard2ResVo.getRh_stlncd_nr_sum_cr_lmt());
            // 正常状态人民币账户信用卡账户数
            custCard2ResVo.setRh_crc_nr_num(custCard2ResVo.getRh_lncd_nr_num() + custCard2ResVo.getRh_stlncd_nr_num());
            //todo rh_crc_nr_mn_cr_lmt 正常状态人民币账户信用卡平均授信额度(所有正常状态账户平均)
            custCard2ResVo.setRh_crc_nr_mn_cr_lmt(BigDecimalUtil.divide(new BigDecimal(custCard2ResVo.getRh_crc_sum_nr_cr_lmt()),
                    new BigDecimal(custCard2ResVo.getRh_crc_nr_num()), custCard2ResVo.getRh_crc_nr_mn_cr_lmt()));
            //todo rh_crc_mn_ud_cr_lmt 未销户人民币账户信用卡平均已用额度(所有账户平均)
            custCard2ResVo.setRh_crc_sum_ud_cr_lmt(custCard2ResVo.getRh_stlncd_sum_ud_cr_lmt() + custCard2ResVo.getRh_lncd_sum_ud_cr_lmt());
            custCard2ResVo.setRh_crc_mn_ud_cr_lmt(BigDecimalUtil.divide(new BigDecimal(custCard2ResVo.getRh_crc_sum_ud_cr_lmt()),
                    new BigDecimal(custCard2ResVo.getRh_crc_uc_num()), custCard2ResVo.getRh_crc_mn_ud_cr_lmt()));
            //todo rh_crc_uc_max_amt_pro 未销户人民币账户信用卡最大已用额度比
            custCard2ResVo.setRh_crc_uc_max_amt_pro(custCard2ResVo.getRh_lncd_uc_max_amt_pro().compareTo(custCard2ResVo.getRh_stlncd_uc_max_amt_pro())
                    > 0 ? custCard2ResVo.getRh_lncd_uc_max_amt_pro() : custCard2ResVo.getRh_stlncd_uc_max_amt_pro());
            //todo rh_crc_uc_min_amt_pro 未销户人民币账户信用卡最小已用额度比
            custCard2ResVo.setRh_crc_uc_min_amt_pro(rh_lncd_uc_min_amt_pro.compareTo(rh_stlncd_uc_min_amt_pro)
                    > 0 ? rh_stlncd_uc_min_amt_pro : rh_lncd_uc_min_amt_pro);
            //todo rh_crc_avg_ud_cr_lmt_pr 未销户人民币账户信用卡平均已用额度比(有值账户平均)
            custCard2ResVo.setRh_crc_avg_ud_cr_lmt_pr(BigDecimalUtil.divide(rh_stlncd_uc_amt_pro_sum.add(rh_lncd_uc_sum_amt_pro), new BigDecimal(
                            rh_stlncd_ud_cr_lmt_sum + rh_lncd_sum_ud_cr_lmt_pr_num),
                    custCard2ResVo.getRh_crc_avg_ud_cr_lmt_pr()));
            //todo rh_crc_mn_ud_cr_lmt_pr 未销户人民币账户信用卡平均已用额度比(所有账户平均)
            custCard2ResVo.setRh_crc_mn_ud_cr_lmt_pr(BigDecimalUtil.divide(rh_stlncd_uc_amt_pro_sum.add(rh_lncd_uc_sum_amt_pro),
                    new BigDecimal(custCard2ResVo.getRh_crc_uc_num()), custCard2ResVo.getRh_crc_mn_ud_cr_lmt_pr()));
            //todo rh_crc_max_ud_sd_lmt_pr 未销户人民币账户信用卡最大已用共享额度比
            custCard2ResVo.setRh_crc_max_ud_sd_lmt_pr(custCard2ResVo.getRh_lncd_max_ud_sd_lmt_pr().compareTo(custCard2ResVo.getRh_stlncd_max_ud_sd_lmt_pr()) > 0
                    ? custCard2ResVo.getRh_lncd_max_ud_sd_lmt_pr() : custCard2ResVo.getRh_stlncd_max_ud_sd_lmt_pr());
            //todo rh_crc_min_ud_sd_lmt_pr 未销户人民币账户信用卡最小已用共享额度比
            custCard2ResVo.setRh_crc_min_ud_sd_lmt_pr(rh_lncd_min_ud_sd_lmt_pr.compareTo(rh_stlncd_min_ud_sd_lmt_pr) > 0
                    ? rh_stlncd_min_ud_sd_lmt_pr : rh_lncd_min_ud_sd_lmt_pr);
            //todo rh_crc_max_nr_ud_cr_lmt_pr 正常状态人民币账户信用卡最大已用额度比
            custCard2ResVo.setRh_crc_max_nr_ud_cr_lmt_pr(custCard2ResVo.getRh_lncd_max_nr_ud_cr_lmt_pr().compareTo(custCard2ResVo.getRh_stlncd_nr_max_ud_cr_lmt_pr())
                    > 0 ? custCard2ResVo.getRh_lncd_max_nr_ud_cr_lmt_pr() : custCard2ResVo.getRh_stlncd_nr_max_ud_cr_lmt_pr());
            //todo rh_crc_nr_min_ud_cr_lmt_pr 正常状态人民币账户信用卡最小已用额度比
            custCard2ResVo.setRh_crc_nr_min_ud_cr_lmt_pr(rh_lncd_min_nr_ud_cr_lmt_pr.compareTo(rh_stlncd_nr_min_ud_cr_lmt_pr) > 0 ? rh_stlncd_nr_min_ud_cr_lmt_pr : rh_lncd_min_nr_ud_cr_lmt_pr);

            //todo rh_crc_nr_avg_ud_cr_lmt_pr 正常状态人民币账户信用卡平均已用额度比(有值账户平均)
            custCard2ResVo.setRh_crc_nr_avg_ud_cr_lmt_pr(BigDecimalUtil.divide(rh_stlncd_nr_ud_cr_lmt_pr_sum.add(rh_lncd_nr_ud_cr_lmt_pr_sum),
                    new BigDecimal(rh_lncd_nr_ud_cr_lmt_pr_num + rh_stlncd_nr_ud_cr_lmt_pr_num)
                    , custCard2ResVo.getRh_crc_nr_avg_ud_cr_lmt_pr()));
            //todo rh_crc_nr_mn_ud_cr_lmt_pr 正常状态人民币账户信用卡平均已用额度比(所有账户平均)
            custCard2ResVo.setRh_crc_nr_mn_ud_cr_lmt_pr(BigDecimalUtil.divide(rh_stlncd_nr_ud_cr_lmt_pr_sum.add(rh_lncd_nr_ud_cr_lmt_pr_sum),
                    new BigDecimal(custCard2ResVo.getRh_crc_nr_num()),
                    custCard2ResVo.getRh_crc_nr_mn_ud_cr_lmt_pr()));
            //todo rh_crc_max_nr_ud_sd_lmt_pr 正常状态人民币账户信用卡最大已用共享额度比
            custCard2ResVo.setRh_crc_max_nr_ud_sd_lmt_pr(custCard2ResVo.getRh_lncd_max_nr_ud_sd_lmt_pr().compareTo(
                    custCard2ResVo.getRh_stlncd_nr_max_ud_sd_lmt_pr()) > 0 ?
                    custCard2ResVo.getRh_lncd_max_nr_ud_sd_lmt_pr() : custCard2ResVo.getRh_stlncd_nr_max_ud_sd_lmt_pr());
            //todo rh_crc_nr_min_ud_sd_lmt_pr 正常状态人民币账户信用卡最小已用共享额度比
            custCard2ResVo.setRh_crc_nr_min_ud_sd_lmt_pr(rh_stlncd_nr_min_ud_sd_lmt_pr.compareTo(
                    rh_crc_nr_min_ud_sd_lmt_pr) > 0 ?
                    rh_crc_nr_min_ud_sd_lmt_pr : rh_stlncd_nr_min_ud_sd_lmt_pr);
            //todo rh_crc_nr_mn_ud_sd_lmt_pr 正常状态人民币账户信用卡平均已用共享额度比(所有账户平均)
            custCard2ResVo.setRh_crc_nr_mn_ud_sd_lmt_pr(BigDecimalUtil.divide(rh_lncd_nr_ud_sd_lmt_pr_sum.add(rh_stlncd_nr_mn_ud_sd_lmt_pr_sum),
                    new BigDecimal(custCard2ResVo.getRh_crc_nr_num()), custCard2ResVo.getRh_crc_nr_mn_ud_sd_lmt_pr()));
            //todo rh_crc_min_age 最近信用卡开立距今月份数
            if (open_date_max_list.size() > 0) {
                custCard2ResVo.setRh_crc_min_age(DateUtil.getMothDiff(formatDate, DateUtil.getMaxDate(open_date_max_list)));
            }
            //todo rh_crc_sum_max_ud_amt 人民币未销户信用卡最大使用额度之和
            custCard2ResVo.setRh_crc_sum_max_ud_amt(use_lim_of_un_max);
            //todo rh_crc_avg_max_ud_amt 人民币未销户信用卡最大使用额度均值
            custCard2ResVo.setRh_crc_avg_max_ud_amt(new BigDecimal(custCard2ResVo.getRh_crc_uc_num() != 0 ? use_lim_of_un_max / custCard2ResVo.getRh_crc_uc_num() : 0));
            //todo rh_crc_ovd_ct_2y_rp 信用卡近2年内逾期月份数
            custCard2ResVo.setRh_crc_ovd_ct_2y_rp(custCard2ResVo.getRh_lncd_ovd_ct_2y_rp() + custCard2ResVo.getRh_stlncd_ovd_ct_2y_rp());

            //todo rh_crc_max_sd_lmt_m6 近6个月未销户人民币账户信用卡最大共享额度
            custCard2ResVo.setRh_crc_max_sd_lmt_m6(max_sha_quo_mon_list.size() != 0 ? parseInt(Collections.max(max_sha_quo_mon_list).toString()) : 0);

            //todo rh_crc_sum_nr_cr_lmt_m6 近6个月正常状态人民币账户信用卡总授信额度
            custCard2ResVo.setRh_crc_sum_nr_cr_lmt_m6(custCard2ResVo.getRh_lncd_sum_nr_cr_lmt_m6() + custCard2ResVo.getRh_stlncd_nr_sum_cr_lmt_m6());

            //todo rh_crc_nr_avg_cr_lmt_m6 近6个月正常状态人民币账户信用卡平均授信额度(有值正常状态账户平均)
            custCard2ResVo.setRh_crc_nr_avg_cr_lmt_m6(BigDecimalUtil.divide(new BigDecimal(custCard2ResVo.getRh_crc_sum_nr_cr_lmt_m6()),
                    new BigDecimal(rh_stlncd_hv_num_m6 + rh_lncd_nr_hv_num_m6),
                    custCard2ResVo.getRh_crc_nr_avg_cr_lmt_m6()));
            //todo rh_crc_nr_mn_cr_lmt_m6 近6个月正常状态人民币账户信用卡平均授信额度(所有正常状态账户平均)
            custCard2ResVo.setRh_crc_nr_mn_cr_lmt_m6(BigDecimalUtil.divide(new BigDecimal(custCard2ResVo.getRh_crc_sum_nr_cr_lmt_m6()),
                    new BigDecimal(custCard2ResVo.getRh_crc_nr_num_m6()), custCard2ResVo.getRh_crc_nr_mn_cr_lmt_m6()));
            //todo rh_crc_sum_nr_cr_lmt_m12 近12个月正常状态人民币账户信用卡总授信额度
            custCard2ResVo.setRh_crc_sum_nr_cr_lmt_m12(tota_qu_re_nor_sta);


            //张卓林
            List outstan_loan_m6_list = new ArrayList();
            List con_amount_list = new ArrayList();
            Set leading_institu_m12_set = new HashSet();
            Map<String, Object> loan_contractInfo1 = MapUtil.returnMap(loanMap, "ContractInfo");
            List<String> loanState = MapUtil.returnList(loanMap, "State");
            List<Integer> loanBalance = MapUtil.returnList(loan_currAccountInfo, "Balance");
            List<String> loanOpenDates = MapUtil.returnList(loan_contractInfo1, "OpenDate");
            List<String> loanCreditLimitAmount = MapUtil.returnList(loan_contractInfo1, "CreditLimitAmount");
            List<String> loanFinanceOrg = MapUtil.returnList(loan_contractInfo1, "FinanceOrg");
            for (int i = 0; i < loanState.size(); i++) {
                try {
                    if (!"3".equals(loanState.get(i))) {
                        if (DateUtil.getMothDiff(DateUtil.parseDate(loanOpenDates.get(i), "yyyy-MM-dd"), formatDate) <= 6) {
                            outstan_loan_m6_list.add(loanBalance.get(i));
                        }
                    }
                    if (!"3".equals(loanState.get(i)) && DateUtil.getMothDiff(DateUtil.parseDate(loanOpenDates.get(i), "yyyy-MM-dd"), formatDate) <= 12) {
                        con_amount_list.add(loanCreditLimitAmount.get(i));
                    }
                    if (DateUtil.getMothDiff(DateUtil.parseDate(loanOpenDates.get(i), "yyyy-MM-dd"), formatDate) <= 12) {
                        leading_institu_m12_set.add(loanFinanceOrg.get(i));
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }

            //todo rh_crc_od180amt_sum_amt 信用卡逾期180天以上未归还贷款本金
            custCard2ResVo.setRh_crc_od180amt_sum_amt(custCard2ResVo.getRh_stlncd_od180amt_sum_amt());

            //取剩余期限（月）
            Integer remainPaymentCyc = 0;
            Integer balance = 0;
            int typeCreLimAmoTotal = 0;
            int housingCLATotal = 0;
            int housingBalTotal = 0;
            // 近6个月未结清贷款总余额
            Integer rh_ln_min_bal_pr_m6_balance = 0;
            // 近6个月未结清贷款总金额
            Integer rh_ln_min_bal_pr_m6_amount = 0;

            List cre_lim_amo_list = new ArrayList<>();
            List balance_list = new ArrayList<>();
            List<BigDecimal> divide_list = new ArrayList<>();
            Set<String> sset = new HashSet<>();
            List num_m2_List = new ArrayList<>();
            List type_cre_lim_amo_list = new ArrayList<>();
            List avg_bala_cre_list = new ArrayList<>();
            List hous_cla_list = new ArrayList<>();
            List hous_bal_list = new ArrayList<>();
            List num_m5_List = new ArrayList<>();
            List<Date> open_date_list = new ArrayList<Date>();

            Map<String, Object> creditSummaryCue = MapUtil.returnMap(jsonObject, "InfoSummary", "CreditCue", "CreditSummaryCue");
            BigDecimal rh_opln_min_bal_pr = new BigDecimal(1);
            for (int i = 0; i < loan_states.size(); i++) {
                try {
                    Integer creditLimitAmount = Integer.parseInt(loan_creditLimitAmounts.get(i).toString());
                    balance = Integer.parseInt(loan_balances.get(i).toString());
                    //发放时间
                    Date openDate = DateUtil.parseDate(loan_openDates.get(i).toString(), "yyyy-MM-dd");
                    // 首笔贷款发放月份
                    Date firstLoanOpenMonth = DateUtil.parseDate((String) creditSummaryCue.getOrDefault("FirstLoanOpenMonth", ""), "yyyy-MM");
                    // 首张贷记卡发卡月份
                    Date firstLoancardOpenMonth = DateUtil.parseDate((String) creditSummaryCue.getOrDefault("FirstLoancardOpenMonth", ""), "yyyy-MM");
                    if ("1".equals(loan_states.get(i))) {
                        //todo rh_ln_nr_num 查询出正常贷款笔数
                        custCard2ResVo.setRh_ln_nr_num(custCard2ResVo.getRh_ln_nr_num() + 1);
                    }
                    if ("3".equals(loan_states.get(i))) {
                        //todo rh_ln_clear_num 结清贷款笔数
                        custCard2ResVo.setRh_ln_clear_num(custCard2ResVo.getRh_ln_clear_num() + 1);
                    } else {
                        if (formatDate.getTime() - openDate.getTime() <= yearTime) {
                            tota_ou_stand_Loan += creditLimitAmount;
                            total_balance += balance;
                            ou_sta_loan_ba_m12_list.add(balance);
                        }
                        if ("21".equals(loan_contractInfoTypes.get(i))) {
                            Integer typrBalance = Integer.parseInt(loan_balances.get(i).toString());
                            Integer typecreLimAmo = Integer.parseInt(loan_creditLimitAmounts.get(i).toString());
                            type_cre_lim_amo_list.add(typecreLimAmo);
                            if (typrBalance != 0) {
                                BigDecimal typeDivide = (new BigDecimal(typecreLimAmo)).divide((new BigDecimal(typrBalance)), 2, BigDecimal.ROUND_HALF_UP);
                                avg_bala_cre_list.add(typeDivide);
                            }
                        }
                        cre_lim_amo_list.add(creditLimitAmount);
                        balance_list.add(balance);
                        //（未结清）客户所有未结清贷款余额和未结清贷款金额的比值的最小值
                        BigDecimal divide = new BigDecimal(0);
                        if (creditLimitAmount != 0) {
                            divide = new BigDecimal(balance).divide(new BigDecimal(creditLimitAmount), 2, BigDecimal.ROUND_HALF_UP);
                        }
                        divide_list.add(divide);
                    }
                    //todo rh_ln_type_num 客户贷款的类别数（如车贷、房贷等不同类别）
                    if (StringUtils.isNotBlank(loan_contractInfoTypes.get(i))) {
                        String type = loan_contractInfoTypes.get(i);
                        sset.add(type);
                    }
                    //todo rh_ln_min_bal_pr_m6 近6个月未结清贷款总余额比
                    if ((!"3".equals(loan_states.get(i)) && formatDate.getTime() - openDate.getTime() <= halfYearTime)) {
                        rh_ln_min_bal_pr_m6_balance += balance;
                        rh_ln_min_bal_pr_m6_amount += creditLimitAmount;
                    }

                    //todo rh_5state_nr_num 贷款五级分类正常个数
                    if (StringUtils.isNotBlank(loan_class5States.get(i).toString())) {
                        if ("1".equals(loan_class5States.get(i))) {
                            custCard2ResVo.setRh_5state_nr_num(custCard2ResVo.getRh_5state_nr_num() + 1);
                        }
                    }
                    //todo rh_ln_nonpmf_ct_2y_rp 近2年内贷款逾期90天以上总月份数
                    if (!"345".contains(loan_states.get(i))) {
                        String latest24State = loan_latest24States.get(i);
                        String[] m2_split = latest24State.split("");
                        for (String str : m2_split) {
                            if (Pattern.compile("[4-7]+").matcher(str).matches()) {
                                num_m2_List.add(Integer.parseInt(str));
                            }
                        }
                        custCard2ResVo.setRh_ln_nonpmf_ct_2y_rp(num_m2_List.size());
                    }
                    if ("21".equals(loan_contractInfoTypes.get(i))) {
                        //todo rh_carln_num 个人汽车贷款笔数
                        custCard2ResVo.setRh_carln_num(custCard2ResVo.getRh_carln_num() + 1);
                    }
                    //todo rh_opln_num 个人经营贷款笔数
                    if ("41".equals(loan_contractInfoTypes.get(i))) {
                        custCard2ResVo.setRh_opln_num(custCard2ResVo.getRh_opln_num() + 1);
                    }

                    //todo rh_opln_clear_num 个人经营贷款结清笔数
                    if ("41".equals(loan_contractInfoTypes.get(i)) && ("3".equals(loan_states.get(i)))) {
                        custCard2ResVo.setRh_opln_clear_num(custCard2ResVo.getRh_opln_clear_num() + 1);
                    }

                    //todo rh_opln_min_bal_pr 个人经营未结清贷款最小余额比
                    if (!"3".equals(loan_states.get(i)) && ("41".equals(loan_contractInfoTypes.get(i)))) {
                        BigDecimal rh_opln_min_bal_pr_tmp = creditLimitAmount == 0 ? new BigDecimal(0) : new BigDecimal((Integer.toString((balance)))).divide(new BigDecimal(Integer.toString(creditLimitAmount)), 2, BigDecimal.ROUND_HALF_UP);
                        if (rh_opln_min_bal_pr.compareTo(rh_opln_min_bal_pr_tmp) > 0) {
                            rh_opln_min_bal_pr = rh_opln_min_bal_pr_tmp;
                        }
                    }

                    //todo rh_ln_bal_num 有贷款余额的账户数目
                    if (Integer.parseInt(loan_balances.get(i).toString()) > 0) {
                        custCard2ResVo.setRh_ln_bal_num(custCard2ResVo.getRh_ln_bal_num() + 1);
                    }
                    //todo rh_ln_m12_ovd_sum_num 征信近1年内贷款累计逾期次数
                    Integer yearOverNumList = 0;
                    String latest12State = "";
                    if (loan_latest24States.get(i).length() >= 12) {
                        latest12State = loan_latest24States.get(i).toString().substring(loan_latest24States.get(i).length() - 12, loan_latest24States.get(i).length() - 1);
                    }
                    String[] yearOverNumSplit = latest12State.split("");
                    for (String str : yearOverNumSplit) {
                        if (Pattern.compile("^[0-9]$").matcher(str).matches()) {
                            yearOverNumList++;
                        }
                    }
                    custCard2ResVo.setRh_ln_m12_ovd_sum_num(Math.max(yearOverNumList, custCard2ResVo.getRh_ln_m12_ovd_sum_num()));
                    if (StringUtils.isNotBlank(loan_remainPaymentCycs.get(i).toString())) {
                        remainPaymentCyc = Integer.parseInt(loan_remainPaymentCycs.get(i).toString());
                    }


                    //todo rh_ln_avg_pay_amt "征信报告上其他，月还款额（不含本次申请）"
                    if (Integer.parseInt(loan_balances.get(i).toString()) > 0) {
                        Integer sumMonths = DateUtil.getMothDiff(DateUtil.parseDate(loan_endDates.get(i), "yyyy-MM-dd"), DateUtil.parseDate(loan_openDates.get(i), "yyyy-MM-dd"));
                        if (!loan_paymentRatings.get(i).contains("02") && !loan_paymentRatings.get(i).contains("03") && !loan_paymentRatings.get(i).contains("01")) {
                            if (StringUtils.isNotBlank(loan_creditLimitAmounts.get(i)) && StringUtils.isNotBlank(loan_openDates.get(i)) && StringUtils.isNotBlank(loan_endDates.get(i))) {
                                if (sumMonths != 0) {
                                    custCard2ResVo.setRh_ln_avg_pay_amt(balance / sumMonths);
                                }
                            }
                        }
                        if (loan_paymentRatings.get(i).contains("02") && loan_paymentRatings.get(i).contains("03") && loan_paymentRatings.get(i).contains("01")) {
                            if (StringUtils.isNotBlank(loan_creditLimitAmounts.get(i)) || StringUtils.isNotBlank(loan_openDates.get(i)) || StringUtils.isNotBlank(loan_endDates.get(i))) {
                                if (Integer.valueOf(loan_scheduledPaymentAmounts.get(i)) > 0) {
                                    custCard2ResVo.setRh_ln_avg_pay_amt(Integer.valueOf(loan_scheduledPaymentAmounts.get(i)));
                                }
                            }
                            if (StringUtils.isNotBlank(loan_creditLimitAmounts.get(i)) && StringUtils.isNotBlank(loan_openDates.get(i)) && StringUtils.isNotBlank(loan_endDates.get(i))) {
                                if (sumMonths != 0 && (balance / sumMonths) > Integer.valueOf(loan_scheduledPaymentAmounts.get(i))) {
                                    custCard2ResVo.setRh_ln_avg_pay_amt(balance / sumMonths);
                                } else {
                                    custCard2ResVo.setRh_ln_avg_pay_amt(Integer.valueOf(loan_scheduledPaymentAmounts.get(i)));
                                }
                            }
                        }
                    }
                    //从最老贷款账户开户到本次查询的月份数
                    open_date_list.add(openDate);
                    //min(『贷款发放日期』)
                    Date minDate = DateUtil.getMinDate(open_date_list);
                    custCard2ResVo.setRh_ln_old_age(DateUtil.getMothDiff(formatDate, minDate));
                    //从最老贷款账户开户到本次查询的月份数
                    if (custCard2ResVo.getRh_ln_old_age() == null || custCard2ResVo.getRh_ln_old_age().equals(null)) {
                        custCard2ResVo.setRh_ln_max_old_cd(3);
                    } else if (custCard2ResVo.getRh_ln_old_age() >= 0 && custCard2ResVo.getRh_ln_old_age() < 12) {
                        custCard2ResVo.setRh_ln_max_old_cd(4);
                    } else if (custCard2ResVo.getRh_ln_old_age() >= 12 && custCard2ResVo.getRh_ln_old_age() < 24) {
                        custCard2ResVo.setRh_ln_max_old_cd(5);
                    } else if (custCard2ResVo.getRh_ln_old_age() >= 24 && custCard2ResVo.getRh_ln_old_age() < 36) {
                        custCard2ResVo.setRh_ln_max_old_cd(6);
                    } else if (custCard2ResVo.getRh_ln_old_age() >= 36 && custCard2ResVo.getRh_ln_old_age() < 48) {
                        custCard2ResVo.setRh_ln_max_old_cd(7);
                    } else if (custCard2ResVo.getRh_ln_old_age() >= 48) {
                        custCard2ResVo.setRh_ln_max_old_cd(8);
                    }
                    //todo rh_perbushslnct_rp 商业住房贷款笔数（全部)
                    if (StringUtils.isNotBlank(creditSummaryCue.getOrDefault("PerBusinessHouseLoanCount", "").toString())) {
                        custCard2ResVo.setRh_perbushslnct_rp(Integer.parseInt(creditSummaryCue.getOrDefault("PerBusinessHouseLoanCount", "-99988").toString()));
                    }

                    //todo rh_perhslnct_rp 个人住房贷款笔数（全部）
                    if (StringUtils.isNotBlank(creditSummaryCue.getOrDefault("PerHouseLoanCount", "").toString())) {
                        custCard2ResVo.setRh_perhslnct_rp(Integer.parseInt(creditSummaryCue.getOrDefault("PerHouseLoanCount", "-99988").toString()));
                    }

                    //todo rh_otlnct_rp 其他贷款笔数（全部）
                    if (StringUtils.isNotBlank(creditSummaryCue.getOrDefault("OtherLoanCount", "").toString())) {
                        custCard2ResVo.setRh_otlnct_rp(Integer.parseInt(creditSummaryCue.getOrDefault("OtherLoanCount", "-99988").toString()));
                    }

                    //todo rh_ln_max_age 首笔贷款发放距今月份数
                    String stringFirstLoanOpenMonth = DateUtil.formatDate(firstLoanOpenMonth);
                    Date firstLoanOpenMonths = DateUtil.parseDate(stringFirstLoanOpenMonth, "yyyy-MM-dd");
                    custCard2ResVo.setRh_ln_max_age(DateUtil.getMothDiff(formatDate, firstLoanOpenMonths));

                    //todo rh_lncd_max_age 首张贷记卡发卡距今月份数
                    custCard2ResVo.setRh_lncd_max_age(DateUtil.getMothDiff(formatDate, firstLoancardOpenMonth));

                    //todo rh_ln_st_flag 是否发生过特殊交易
                    if (StringUtils.isNotBlank(loan_specialTradetypes.get(i).toString())) {
                        String type = loan_specialTradetypes.get(i).toString();
                        if (!"".equals(type)) {
                            custCard2ResVo.setRh_ln_st_flag("1");
                        }
                    }
                    //todo rh_ln_st_adva 特殊交易-提前还款（全部）次数
                    if ("5".equals(loan_specialTradetypes.get(i))) {
                        custCard2ResVo.setRh_ln_st_adva(custCard2ResVo.getRh_ln_st_adva() + 1);
                    }


                    if ("21".equals(loan_contractInfoTypes.get(i))) {
                        //todo rh_carln_curodamt 个人汽车贷款当前逾期金额总额
                        custCard2ResVo.setRh_carln_curodamt(custCard2ResVo.getRh_carln_curodamt() + Integer.parseInt(loan_currOverdueAmounts.get(i).toString()));
                    }
                    if ("11".equals(loan_contractInfoTypes.get(i).substring(0, 2)) || "12".equals(loan_contractInfoTypes.get(i).substring(0, 2)) || "13".equals(loan_contractInfoTypes.get(i).substring(0, 2))) {
                        if ("1".equals(loan_states.get(i))) {
                            //个人住房贷款正常笔数
                            custCard2ResVo.setRh_hsln_nr_num(custCard2ResVo.getRh_hsln_nr_num() + 1);
                        }
                        if (!"3".equals(loan_states.get(i))) {
                            //个人住房未结清贷款总金额
                            Integer housingCLA = Integer.parseInt(loan_creditLimitAmounts.get(i).toString());
                            hous_cla_list.add(housingCLA);
                            //个人住房未结清贷款总余额
                            Integer housingBal = Integer.parseInt(loan_balances.get(i).toString());
                            hous_bal_list.add(housingBal);
                        }
                    }
                    //todo rh_longln_sum_pay_amt 征信局借款人长期债务的分期付款
                    if (DateUtil.getMothDiff(DateUtil.parseDate(loan_endDates.get(i), "yyyy-MM-dd"), DateUtil.parseDate(loan_openDates.get(i), "yyyy-MM-dd")) > 12 && Integer.parseInt(loan_balances.get(i).toString()) > 0) {
                        if (StringUtils.isNotBlank(loan_scheduledPaymentAmounts.get(i))) {
                            custCard2ResVo.setRh_longln_sum_pay_amt(Integer.parseInt(loan_scheduledPaymentAmounts.get(i).toString()) + custCard2ResVo.getRh_longln_sum_pay_amt());
                        }
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            rh_opln_min_bal_pr = rh_opln_min_bal_pr.compareTo(new BigDecimal(1)) == 0 ? new BigDecimal(0) : rh_opln_min_bal_pr;
            custCard2ResVo.setRh_opln_min_bal_pr(rh_opln_min_bal_pr);
            custCard2ResVo.setRh_ln_type_num(sset.size());
            Integer guananteeMoney = 0;
            Map<String, Object> guaranteeInfos = MapUtil.returnMap(jsonObject, "CreditDetail", "GuaranteeInfo");
            Map<String, Object> guarantees = MapUtil.returnMap(guaranteeInfos, "Guarantee");
            List<Object> guaranteeBalances = MapUtil.returnList(guarantees, "GuaranteeBalance");
            List<String> endDates = MapUtil.returnList(guarantees, "EndDate");
            for (int i = 0; i < guaranteeBalances.size(); i++) {
                if (StringUtils.isNotBlank(endDates.get(i))) {
                    try {
                        guananteeMoney = (guananteeMoney + (DateUtil.getMothDiff(formatDate, DateUtil.parseDate(endDates.get(i).toString(), "yyyy-MM-dd")) == 0 ? 0 : Integer.parseInt(guaranteeBalances.get(i).toString()) / (DateUtil.getMothDiff(formatDate, DateUtil.parseDate(endDates.get(i).toString(), "yyyy-MM-dd")))));
                    } catch (Exception e) {
                        LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                    }
                }
            }
            // 近6个月未结清贷款总余额比
            if (rh_ln_min_bal_pr_m6_amount != 0) {
                BigDecimal rh_ln_min_bal_pr_m6 = new BigDecimal(rh_ln_min_bal_pr_m6_balance).divide(new BigDecimal(rh_ln_min_bal_pr_m6_amount), 2, BigDecimal.ROUND_HALF_UP);
                custCard2ResVo.setRh_ln_min_bal_pr_m6(custCard2ResVo.getRh_ln_min_bal_pr_m6().add(rh_ln_min_bal_pr_m6));
            }
            //todo 正常贷款笔数  上面代码
            //todo 结清贷款笔数  上面代码
            //todo rh_ln_max_amt 未结清贷款最大金额
            custCard2ResVo.setRh_ln_max_amt(cre_lim_amo_list.size() != 0 ? Integer.parseInt(Collections.max(cre_lim_amo_list).toString()) : 0);
            //todo rh_ln_avg_amt 未结清贷款平均金额
            int creLimAmoTotal = 0;
            for (int i = 0; i < cre_lim_amo_list.size(); i++) {
                try {
                    creLimAmoTotal += Integer.parseInt(cre_lim_amo_list.get(i).toString());
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            custCard2ResVo.setRh_ln_avg_amt(cre_lim_amo_list.size() != 0 ? creLimAmoTotal / cre_lim_amo_list.size() : 0);
            //todo rh_ln_max_bal 未结清贷款最大余额
            custCard2ResVo.setRh_ln_max_bal(balance_list.size() != 0 ? Integer.parseInt(Collections.max(balance_list).toString()) : 0);
            //todo rh_ln_avg_bal 未结清贷款平均余额
            int balanceTotal = 0;
            for (int i = 0; i < balance_list.size(); i++) {
                try {
                    balanceTotal += Integer.parseInt(balance_list.get(i).toString());
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            custCard2ResVo.setRh_ln_avg_bal(balance_list.size() != 0 ? balanceTotal / balance_list.size() : 0);
            //todo rh_ln_min_bal_pr 最小未结清贷款余额比
            List<BigDecimal> tempList = divide_list.stream().filter(temp -> temp.compareTo(new BigDecimal(0)) > 0).collect(Collectors.toList());
            custCard2ResVo.setRh_ln_min_bal_pr(tempList.size() != 0 ? new BigDecimal(Collections.min(tempList).toString()) : new BigDecimal(0));
            //todo rh_ln_max_bal_pr 最大未结清贷款余额比
            custCard2ResVo.setRh_ln_max_bal_pr(divide_list.size() != 0 ? new BigDecimal(Collections.max(divide_list).toString()) : new BigDecimal(0));
            //todo 贷款类别数 上边代码

            //todo 是否发生过特殊交易 上边代码

            //todo 特殊交易-提前还款（全部）次数 上边代码
            //todo rh_ln_avg_bal_m6  近6个月未结清贷款平均余额
            Integer outstan_loan_m6_blance = 0;
            for (int i = 0; i < outstan_loan_m6_list.size(); i++) {
                try {
                    outstan_loan_m6_blance += Integer.parseInt(outstan_loan_m6_list.get(i).toString());
                } catch (Exception e) {
                    e.getMessage();
                }
            }
            custCard2ResVo.setRh_ln_avg_bal_m6(outstan_loan_m6_list.size() == 0 ? 0 : outstan_loan_m6_blance / outstan_loan_m6_list.size());
            //todo 近6个月未结清贷款总余额比 上面代码

            //todo rh_ln_sum_amt_m12 近12个月未结清贷款总金额
            custCard2ResVo.setRh_ln_sum_amt_m12(tota_ou_stand_Loan);
            //todo rh_ln_max_amt_m12 近12个月未结清贷款最大金额
            custCard2ResVo.setRh_ln_max_amt_m12(con_amount_list.size() == 0 ? 0 : Integer.parseInt(Collections.max(con_amount_list).toString()));
            //todo rh_ln_avg_amt_m12 近12个月未结清贷款平均金额
            custCard2ResVo.setRh_ln_avg_amt_m12(con_amount_list.size() != 0 ? tota_ou_stand_Loan / con_amount_list.size() : 0);
            //todo rh_ln_sum_bal_m12 近12个月未结清贷款总余额
            custCard2ResVo.setRh_ln_sum_bal_m12(total_balance);
            //todo rh_ln_max_bal_m12 近12个月未结清贷款最大余额
            custCard2ResVo.setRh_ln_max_bal_m12(ou_sta_loan_ba_m12_list.size() != 0 ? Integer.parseInt(Collections.max(ou_sta_loan_ba_m12_list).toString()) : 0);

            //todo 贷款五级分类正常个数 上面代码

            //todo 近2年内贷款逾期90天以上总月份数 上面代码

            //todo 个人汽车贷款笔数 上面代码

            //todo rh_carln_avg_amt 个人汽车未结清贷款平均金额
            for (int i = 0; i < type_cre_lim_amo_list.size(); i++) {
                try {
                    typeCreLimAmoTotal += Integer.parseInt(type_cre_lim_amo_list.get(i).toString());
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            custCard2ResVo.setRh_carln_avg_amt(type_cre_lim_amo_list.size() != 0 ? typeCreLimAmoTotal / type_cre_lim_amo_list.size() : 0);
            //todo rh_carln_min_bal_pr 个人汽车未结清贷款最小余额比
            custCard2ResVo.setRh_carln_min_bal_pr(avg_bala_cre_list.size() != 0 ? new BigDecimal(Collections.min(avg_bala_cre_list).toString()) : new BigDecimal(0));
            //todo 个人汽车贷款当前逾期金额总额 上面代码

            //todo rh_hsln_sum_amt 个人住房未结清贷款总金额
            for (int i = 0; i < hous_cla_list.size(); i++) {
                try {
                    housingCLATotal += Integer.parseInt(hous_cla_list.get(i).toString());
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            custCard2ResVo.setRh_hsln_sum_amt(housingCLATotal);
            //todo rh_hsln_max_amt 个人住房未结清贷款最大金额
            custCard2ResVo.setRh_hsln_max_amt(hous_cla_list.size() != 0 ? Integer.parseInt(Collections.max(hous_cla_list).toString()) : 0);
            //todo rh_hsln_avg_amt 个人住房未结清贷款平均金额
            custCard2ResVo.setRh_hsln_avg_amt(hous_cla_list.size() != 0 ? housingCLATotal / hous_cla_list.size() : 0);
            //todo rh_hsln_sum_bal 个人住房未结清贷款总余额
            for (int i = 0; i < hous_bal_list.size(); i++) {
                try {
                    housingBalTotal += Integer.parseInt(hous_bal_list.get(i).toString());
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            custCard2ResVo.setRh_hsln_sum_bal(housingBalTotal);
            //todo 个人经营贷款笔数 上面代码

            //todo 个人经营贷款结清笔数 上面代码

            //todo 个人经营未结清贷款最小余额比 上面代码

            //todo 有贷款余额的账户数目 上面代码

            //todo 征信报告上其他，月还款额（不含本次申请） 上面代码

            //todo 征信局借款人长期债务的分期付款 上面代码

            //todo 征信近1年内贷款累计逾期次数 上面代码

            //todo 商业住房贷款笔数（全部） 上面代码

            //todo 个人住房贷款笔数（全部） 上面代码

            //todo 其他贷款笔数（全部） 上面代码

            //todo 首笔贷款发放距今月份数 上面代码

            //todo 首张贷记卡发卡距今月份数 上面代码

            //todo rh_lncd_ovd_num 贷记卡逾期账户数
            String rh_lncd_ovd_num = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "OverdueAndFellback", "OverdueSummary", "LoancardSum", "Count").toString();
            rh_lncd_ovd_num = rh_lncd_ovd_num.equals("") ? "0" : rh_lncd_ovd_num;
            custCard2ResVo.setRh_lncd_ovd_num(Integer.valueOf(rh_lncd_ovd_num));
            //todo rh_sum_ovd_num 所有类型总逾期笔数
            Integer overCount = Integer.parseInt(loanSum.getOrDefault("Count", "0").toString());
            Integer loancardSumCount = Integer.parseInt(loancardSum.getOrDefault("Count", "0").toString());
            Integer standardLoancardSumCount = Integer.parseInt(standardLoancardSum.getOrDefault("Count", "0").toString());
            custCard2ResVo.setRh_sum_ovd_num(overCount + loancardSumCount + standardLoancardSumCount);
            //todo rh_ln_ovd_mon 贷款逾期月份数
            String rh_ln_ovd_mon = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "OverdueAndFellback", "OverdueSummary", "LoanSum", "Months").toString();
            rh_ln_ovd_mon = rh_ln_ovd_mon.equals("") ? "0" : rh_ln_ovd_mon;
            custCard2ResVo.setRh_ln_ovd_mon(Integer.parseInt(rh_ln_ovd_mon));
            //todo rh_ln_ovd_hgst_amt 贷款逾期单月最高逾期总额
            String rh_ln_ovd_hgst_amt = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "OverdueAndFellback", "OverdueSummary", "LoanSum", "HighestOverdueAmountPerMon").toString();
            rh_ln_ovd_hgst_amt = rh_ln_ovd_hgst_amt.equals("") ? "0" : rh_ln_ovd_hgst_amt;
            custCard2ResVo.setRh_ln_ovd_hgst_amt(Integer.parseInt(rh_ln_ovd_hgst_amt));
            //todo rh_lncd_ovd_mon 贷记卡逾期月份数
            custCard2ResVo.setRh_lncd_ovd_mon(rh_lncd_ovd_mon);
            //todo rh_lncd_ovd_hgst_amt 贷记卡逾期单月最高逾期总额
            String rh_lncd_ovd_hgst_amt = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "OverdueAndFellback", "OverdueSummary", "LoancardSum", "HighestOverdueAmountPerMon").toString();
            rh_lncd_ovd_hgst_amt = rh_lncd_ovd_hgst_amt.equals("") ? "0" : rh_lncd_ovd_hgst_amt;
            custCard2ResVo.setRh_lncd_ovd_hgst_amt(Integer.parseInt(rh_lncd_ovd_hgst_amt));
            //todo rh_lncd_ovd_dur 贷记卡最长逾期月数
            String rh_lncd_ovd_dur = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "OverdueAndFellback", "OverdueSummary", "LoancardSum", "MaxDuration").toString();
            rh_lncd_ovd_dur = rh_lncd_ovd_dur.equals("") ? "0" : rh_lncd_ovd_dur;
            custCard2ResVo.setRh_lncd_ovd_dur(Integer.parseInt(rh_lncd_ovd_dur));
            //todo rh_sum_ovd_mon 所有类型逾期月份数汇总
            //准贷记卡60天以上透支月份数
            String quasiCreditString = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "OverdueAndFellback", "OverdueSummary", "StandardLoancardSum", "Months").toString();
            quasiCreditString = quasiCreditString.equals("") ? "0" : quasiCreditString;
            Integer quasiCredit = Integer.parseInt(quasiCreditString);
            custCard2ResVo.setRh_sum_ovd_mon(custCard2ResVo.getRh_lncd_ovd_mon() + quasiCredit + custCard2ResVo.getRh_ln_ovd_mon());
            //todo rh_max_ovd_mon 所有类型逾期月份数最大值
            custCard2ResVo.setRh_max_ovd_mon(
                    (quasiCredit > custCard2ResVo.getRh_lncd_ovd_mon() ? quasiCredit : custCard2ResVo.getRh_lncd_ovd_mon()) > custCard2ResVo.getRh_ln_ovd_mon() ? (quasiCredit > custCard2ResVo.getRh_lncd_ovd_mon() ? quasiCredit : custCard2ResVo.getRh_lncd_ovd_mon()) : custCard2ResVo.getRh_lncd_ovd_mon());
            //todo rh_avg_ovd_mon 所有类型逾期月份数均值(有值类型平均)
            int count = 0;
            if (custCard2ResVo.getRh_lncd_ovd_mon() != 0) count++;
            if (quasiCredit != 0) count++;
            if (quasiCredit + custCard2ResVo.getRh_ln_ovd_mon() != 0) count++;
            custCard2ResVo.setRh_avg_ovd_mon(count == 0 ? 0 : custCard2ResVo.getRh_sum_ovd_mon() / count);
            //todo 所有类型单月最高逾期总额汇总
            //todo rh_max_ovd_hgst_amt 所有类型单月最高逾期总额最大值
            //贷记卡逾期单月最高逾期总额/单月最高透支总额
            String debitCardOneString = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "OverdueAndFellback", "OverdueSummary", "LoancardSum", "HighestOverdueAmountPerMon").toString();
            debitCardOneString = debitCardOneString.equals("") ? "0" : debitCardOneString;
            Integer debitCardOne = Integer.parseInt(debitCardOneString);
            //准贷记卡60天以上透支单月最高逾期总额/单月最高透支总额
            String quasiCreditOneString = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "OverdueAndFellback", "OverdueSummary", "StandardLoancardSum", "HighestOverdueAmountPerMon").toString();
            quasiCreditOneString = quasiCreditOneString.equals("") ? "0" : quasiCreditOneString;
            Integer quasiCreditOne = Integer.parseInt(quasiCreditOneString);
            //贷款逾期单月最高逾期总额/单月最高透支总额
            String overdueLoanOneString = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "OverdueAndFellback", "OverdueSummary", "LoanSum", "HighestOverdueAmountPerMon").toString();
            overdueLoanOneString = overdueLoanOneString.equals("") ? "0" : overdueLoanOneString;
            Integer overdueLoanOne = Integer.parseInt(overdueLoanOneString);
            custCard2ResVo.setRh_max_ovd_hgst_amt((debitCardOne > quasiCreditOne ? debitCardOne : quasiCredit) > overdueLoanOne ? (debitCardOne > quasiCreditOne ? debitCardOne : quasiCredit) : overdueLoanOne);
            // todo rh_sum_ovd_hgst_amt 所有类型单月最高逾期总额汇总
            custCard2ResVo.setRh_sum_ovd_hgst_amt(debitCardOne + quasiCreditOne + overdueLoanOne);
            //todo rh_avg_ovd_hgst_amt 所有类型单月最高逾期总额最大值均值(有值类型平均)
            int overdueCount = 0;
            if (debitCardOne != 0) overdueCount++;
            if (quasiCreditOne != 0) overdueCount++;
            if (overdueLoanOne != 0) overdueCount++;
            custCard2ResVo.setRh_avg_ovd_hgst_amt(overdueCount == 0 ? 0 : (debitCardOne + quasiCreditOne + overdueLoanOne) / overdueCount);
            //todo rh_mn_ovd_hgst_amt 所有类型单月最高逾期总额最大值均值(有值类型平均)
            custCard2ResVo.setRh_mn_ovd_hgst_amt((debitCardOne + quasiCreditOne + overdueLoanOne) / 3);
            //todo 所有类型最长逾期月数汇总
            //贷款逾期最长逾期月数
            String loanMaxDurString = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "OverdueAndFellback", "OverdueSummary", "LoanSum", "MaxDuration").toString();
            loanMaxDurString = loanMaxDurString.equals("") || loanMaxDurString.equals("NaN") ? "0" : loanMaxDurString;
            Integer loanMaxDur = Integer.parseInt(loanMaxDurString);
            //todo rh_sum_ovd_dur 准贷记卡60天以上透支最长逾期月数/最长透支月数OverdueSummary.StandardLoancardSum.MaxDuration
            String staLonSumMaxDurString = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "OverdueAndFellback", "OverdueSummary", "StandardLoancardSum", "MaxDuration").toString();
            staLonSumMaxDurString = staLonSumMaxDurString.equals("") || staLonSumMaxDurString.equals("NaN") ? "0" : staLonSumMaxDurString;
            Integer staLonSumMaxDur = Integer.parseInt(staLonSumMaxDurString);
            custCard2ResVo.setRh_sum_ovd_dur(loanMaxDur + staLonSumMaxDur + custCard2ResVo.getRh_lncd_ovd_dur());
            //todo rh_max_ovd_dur 所有类型最长逾期月数的最大值
            custCard2ResVo.setRh_max_ovd_dur((loanMaxDur > staLonSumMaxDur ? loanMaxDur : staLonSumMaxDur) > custCard2ResVo.getRh_lncd_ovd_dur() ? (loanMaxDur > staLonSumMaxDur ? loanMaxDur : staLonSumMaxDur) : custCard2ResVo.getRh_lncd_ovd_dur());
            //todo rh_uc_ln_bal 未结清贷款余额
            String rh_uc_ln_bal = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "ShareAndDebt", "UnpaidLoan", "Balance").toString();
            rh_uc_ln_bal = rh_uc_ln_bal.equals("") || rh_uc_ln_bal.equals("NaN") ? "0" : rh_uc_ln_bal;
            custCard2ResVo.setRh_uc_ln_bal(Integer.parseInt(rh_uc_ln_bal));
            //todo rh_uc_ln_amt 未结清贷款金额
            String rh_uc_ln_amt = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "ShareAndDebt", "UnpaidLoan", "CreditLimit").toString();
            rh_uc_ln_amt = rh_uc_ln_amt.equals("") || rh_uc_ln_amt.equals("NaN") ? "0" : rh_uc_ln_amt;
            custCard2ResVo.setRh_uc_ln_amt(Integer.parseInt(rh_uc_ln_amt));
            //todo rh_uc_ln_m6avg_amt 未结清贷款近6个月平均使用额度
            String rh_uc_ln_m6avg_amt = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "ShareAndDebt", "UnpaidLoan", "Latest6MonthUsedAvgAmount").toString();
            rh_uc_ln_m6avg_amt = rh_uc_ln_m6avg_amt.equals("") ? "0" : rh_uc_ln_m6avg_amt;
            custCard2ResVo.setRh_uc_ln_m6avg_amt(new BigDecimal(rh_uc_ln_m6avg_amt));
            //todo 未销户贷记卡已用额度比
            //贷记卡已用额度
            String shaUndLoanUseCreLimString = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "ShareAndDebt", "UndestoryLoancard", "UsedCreditLimit").toString();
            Integer shaUndLoanUseCreLim = Integer.parseInt(shaUndLoanUseCreLimString);
            //todo rh_lncd_uc_ud_pro 贷记卡授信额度
            String shaUndLoanCreLimString = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "ShareAndDebt", "UndestoryLoancard", "CreditLimit").toString();
            Integer shaUndLoanCreLim = Integer.parseInt(shaUndLoanCreLimString);
            custCard2ResVo.setRh_lncd_uc_ud_pro(shaUndLoanCreLim == 0 ? new BigDecimal(0) : new BigDecimal(shaUndLoanUseCreLim).divide(new BigDecimal(shaUndLoanCreLim), 2, BigDecimal.ROUND_HALF_UP));
            //todo rh_lncd_uc_max_lmt_pro 未销户贷记卡最大额度比
            Integer maxCreditLimitPerOrg = Integer.parseInt(undestoryLoancard.getOrDefault("MaxCreditLimitPerOrg", "0").toString());
            creditLimit = Integer.parseInt(undestoryLoancard.getOrDefault("CreditLimit", "0").toString());
            custCard2ResVo.setRh_lncd_uc_max_lmt_pro(BigDecimalUtil.divide(new BigDecimal(maxCreditLimitPerOrg), new BigDecimal(creditLimit),
                    custCard2ResVo.getRh_lncd_uc_max_lmt_pro()));
            //todo rh_cr_sum_bal 贷款余额与信用卡使用额度之和（未销户）
            String UsedCreditLimit1 = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "ShareAndDebt", "UndestoryLoancard", "UsedCreditLimit").toString();
            UsedCreditLimit1 = UsedCreditLimit1.equals("") ? "0" : UsedCreditLimit1;
            String UsedCreditLimit2 = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "ShareAndDebt", "UndestoryStandardLoancard", "UsedCreditLimit").toString();
            UsedCreditLimit2 = UsedCreditLimit2.equals("") ? "0" : UsedCreditLimit2;
            String UsedCreditLimit3 = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "ShareAndDebt", "UnpaidLoan", "Balance").toString();
            UsedCreditLimit3 = UsedCreditLimit3.equals("") ? "0" : UsedCreditLimit3;
            custCard2ResVo.setRh_cr_sum_bal(Integer.parseInt(UsedCreditLimit1) + Integer.parseInt(UsedCreditLimit2) + Integer.parseInt(UsedCreditLimit3));
            //todo 贷款余额占贷款余额与信用卡使用额度之和的比例（未销户）
            //贷款余额
            Integer shaUnpBalance = Integer.parseInt(UsedCreditLimit3);
            //todo rh_ln_bal_pral 准贷记卡透支余额
            Integer shaUndStaLoanUseCreLim = Integer.parseInt(UsedCreditLimit2);
            custCard2ResVo.setRh_ln_bal_pral(shaUnpBalance + shaUndLoanUseCreLim + shaUndStaLoanUseCreLim == 0 ? new BigDecimal(0) : new BigDecimal(shaUnpBalance.toString()).divide(new BigDecimal((shaUnpBalance + shaUndLoanUseCreLim + shaUndStaLoanUseCreLim)), 2, BigDecimal.ROUND_HALF_UP));
            //todo 信用卡使用额度占贷款余额与信用卡使用额度之和的比例（未销户）
            //贷记卡已用额度
            BigDecimal undeLoanUCL = new BigDecimal(UsedCreditLimit1);
            //准贷记卡透支余额
            BigDecimal undeStaLoanUCL = new BigDecimal(UsedCreditLimit2);
            //todo rh_cd_bal_pral贷款余额
            BigDecimal unpLoanBalance = new BigDecimal(UsedCreditLimit3);
            if ((unpLoanBalance.add(undeStaLoanUCL).add(undeLoanUCL)).compareTo(new BigDecimal(0)) != 0) {
                custCard2ResVo.setRh_cd_bal_pral((undeLoanUCL.add(undeStaLoanUCL)).divide(unpLoanBalance.add(undeStaLoanUCL).add(undeLoanUCL), 2, BigDecimal.ROUND_HALF_UP));
            }
            //todo 贷款金额占贷款金额与信用卡额度之和的比例（未销户）
            //贷记卡授信总额
            String undeLoanCreLimString = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "ShareAndDebt", "UndestoryLoancard", "CreditLimit").toString();
            undeLoanCreLimString = undeLoanCreLimString.equals("") ? "0" : undeLoanCreLimString;
            BigDecimal undeLoanCreLim = new BigDecimal(undeLoanCreLimString);
            //todo rh_ln_amt_pral 准贷记卡授信总额
            String undeStaLoanCreLimString = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "ShareAndDebt", "UndestoryStandardLoancard", "CreditLimit").toString();
            undeStaLoanCreLimString = undeStaLoanCreLimString.equals("") ? "0" : undeStaLoanCreLimString;
            BigDecimal undeStaLoanCreLim = new BigDecimal(undeStaLoanCreLimString);
            if ((new BigDecimal(custCard2ResVo.getRh_uc_ln_amt()).add(undeLoanCreLim).add(undeStaLoanCreLim).compareTo(new BigDecimal(0))) != 0) {
                custCard2ResVo.setRh_ln_amt_pral((new BigDecimal(custCard2ResVo.getRh_uc_ln_amt().toString())).divide(((new BigDecimal(custCard2ResVo.getRh_uc_ln_amt().toString())).add(undeLoanCreLim).add(undeStaLoanCreLim)), 2, BigDecimal.ROUND_HALF_UP));
            }
            //todo rh_cd_amt_pral 信用卡额度占贷款金额与信用卡额度之和的比例（未销户）
            //贷款合同金额
            String sad_ul_cr_liString = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "ShareAndDebt", "UnpaidLoan", "CreditLimit").toString();
            sad_ul_cr_liString = sad_ul_cr_liString.equals("") ? "0" : sad_ul_cr_liString;
            BigDecimal sad_ul_cr_li = new BigDecimal(sad_ul_cr_liString);
            //贷记卡授信总额
            BigDecimal sad_ud_ld_cr_li = new BigDecimal(undeLoanCreLimString);
            //todo 准贷记卡授信总额
            BigDecimal sad_ud_sd_ld_cr_li = new BigDecimal(undeStaLoanCreLimString);
            if (sad_ul_cr_li.add(sad_ud_ld_cr_li).add(sad_ud_sd_ld_cr_li).compareTo(new BigDecimal(0)) != 0) {
                custCard2ResVo.setRh_cd_amt_pral(sad_ul_cr_li.add(sad_ud_ld_cr_li).add(sad_ud_sd_ld_cr_li) == null ? new BigDecimal(0) : sad_ud_ld_cr_li.add(sad_ud_sd_ld_cr_li).divide((sad_ul_cr_li.add(sad_ud_ld_cr_li).add(sad_ud_sd_ld_cr_li)), 2, BigDecimal.ROUND_HALF_UP));
            }

            //todo 信贷产品账户数（包含已销户）
            //"个人住房贷款笔数
            String creSumPerHouLoaCountString = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "CreditCue", "CreditSummaryCue", "PerHouseLoanCount").toString();
            creSumPerHouLoaCountString = creSumPerHouLoaCountString.equals("") ? "0" : creSumPerHouLoaCountString;
            Integer creSumPerHouLoaCount = Integer.parseInt(creSumPerHouLoaCountString);
            //个人商用房（包括商住两用）贷款笔数
            String creSumPerBusHouLoaCountString = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "CreditCue", "CreditSummaryCue", "PerBusinessHouseLoanCount").toString();
            creSumPerBusHouLoaCountString = creSumPerBusHouLoaCountString.equals("") ? "0" : creSumPerBusHouLoaCountString;
            Integer creSumPerBusHouLoaCount = Integer.parseInt(creSumPerBusHouLoaCountString);
            //其他贷款笔数
            String creSumCueOthLoaCountString = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "CreditCue", "CreditSummaryCue", "OtherLoanCount").toString();
            creSumCueOthLoaCountString = creSumCueOthLoaCountString.equals("") ? "0" : creSumCueOthLoaCountString;
            Integer creSumCueOthLoaCount = Integer.parseInt(creSumCueOthLoaCountString);
            //贷记卡账户数
            String creSumCueLoaCountString = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "CreditCue", "CreditSummaryCue", "LoancardCount").toString();
            creSumCueLoaCountString = creSumCueLoaCountString.equals("") ? "0" : creSumCueLoaCountString;
            Integer creSumCueLoaCount = Integer.parseInt(creSumCueLoaCountString);
            //准贷记卡账户数CreditCue.CreditSummaryCue.StandardLoancardCount"
            String creSumCueStaLoaCountString = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "CreditCue", "CreditSummaryCue", "StandardLoancardCount").toString();
            creSumCueStaLoaCountString = creSumCueStaLoaCountString.equals("") ? "0" : creSumCueStaLoaCountString;
            Integer creSumCueStaLoaCount = Integer.parseInt(creSumCueStaLoaCountString);
            //todo rh_cr_num 信贷产品账户数（包含已销户）
            custCard2ResVo.setRh_cr_num(creSumPerHouLoaCount + creSumPerBusHouLoaCount + creSumCueOthLoaCount + creSumCueLoaCount + creSumCueStaLoaCount);
            //todo 未销户贷记卡占总信贷产品账户数比例（未销户）
            //"未销户贷记卡账户数
            String undLoaCrLiAccCountString = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "ShareAndDebt", "UndestoryLoancard", "AccountCount").toString();
            undLoaCrLiAccCountString = undLoaCrLiAccCountString.equals("") ? "0" : undLoaCrLiAccCountString;
            Integer undLoaCrLiAccCount = Integer.parseInt(undLoaCrLiAccCountString);
            //未销户准贷记卡账户数
            String undStaLoaCrLiAccCountString = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "ShareAndDebt", "UndestoryStandardLoancard", "AccountCount").toString();
            undStaLoaCrLiAccCountString = undStaLoaCrLiAccCountString.equals("") ? "0" : undStaLoaCrLiAccCountString;
            Integer undStaLoaCrLiAccCount = Integer.parseInt(undStaLoaCrLiAccCountString);
            //todo rh_lncd_cr_uc_num_pro 未结清贷款笔数
            String unpLoanAccCountString = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "ShareAndDebt", "UnpaidLoan", "AccountCount").toString();
            unpLoanAccCountString = unpLoanAccCountString.equals("") ? "0" : unpLoanAccCountString;
            Integer unpLoanAccCount = Integer.parseInt(unpLoanAccCountString);
            if ((undLoaCrLiAccCount + undStaLoaCrLiAccCount + unpLoanAccCount) != 0) {
                custCard2ResVo.setRh_lncd_cr_uc_num_pro((new BigDecimal(undLoaCrLiAccCount.toString())).divide((new BigDecimal(undLoaCrLiAccCount + undStaLoaCrLiAccCount + unpLoanAccCount)), 2, BigDecimal.ROUND_HALF_UP));
            }
            //todo rh_cr_ovd_max_amt 信贷产品单月逾期最高总额最大值
            custCard2ResVo.setRh_cr_ovd_max_amt((overdueLoanOne > quasiCreditOne ? overdueLoanOne : quasiCreditOne) > custCard2ResVo.getRh_lncd_ovd_hgst_amt() ? (overdueLoanOne > quasiCreditOne ? overdueLoanOne : quasiCreditOne) : custCard2ResVo.getRh_lncd_ovd_hgst_amt());
            //todo rh_cr_cate_num 信贷产品种类数(包含已结清)
            if ((creSumPerBusHouLoaCount + creSumPerHouLoaCount + creSumCueOthLoaCount) > 0) {
                custCard2ResVo.setRh_cr_cate_num(custCard2ResVo.getRh_cr_cate_num() + 1);
            }
            if (creSumCueLoaCount > 0) {
                custCard2ResVo.setRh_cr_cate_num(custCard2ResVo.getRh_cr_cate_num() + 1);
            }
            if (creSumCueStaLoaCount > 0) {
                custCard2ResVo.setRh_cr_cate_num(custCard2ResVo.getRh_cr_cate_num() + 1);
            }
            //todo rh_ln_avg_bal_amt 基础月负债金额1
            String unpaidLoan_latest6MonthUsedAvgAmountString = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "InfoSummary", "ShareAndDebt", "UnpaidLoan", "Latest6MonthUsedAvgAmount").toString();
            unpaidLoan_latest6MonthUsedAvgAmountString = unpaidLoan_latest6MonthUsedAvgAmountString.equals("") ? "0" : unpaidLoan_latest6MonthUsedAvgAmountString;
            BigDecimal unpaidLoan_latest6MonthUsedAvgAmount = new BigDecimal(unpaidLoan_latest6MonthUsedAvgAmountString);
            if (remainPaymentCyc != 0) {
                custCard2ResVo.setRh_ln_avg_bal_amt(unpaidLoan_latest6MonthUsedAvgAmount.compareTo(new BigDecimal(balance / remainPaymentCyc).add(new BigDecimal(guananteeMoney))) > 0 ? unpaidLoan_latest6MonthUsedAvgAmount : new BigDecimal(balance / remainPaymentCyc).add(new BigDecimal(guananteeMoney)));
            }
            //todo 过去24个月产品逾期次数

            // todo rh_lncd_per_num 评级为满意的贷记卡账户数目
            custCard2ResVo.setRh_lncd_per_num(creSumCueLoaCount - custCard2ResVo.getRh_lncd_mid_ovd_num() - custCard2ResVo.getRh_lncd_high_ovd_num());
            /**
             * 信用卡-贷记卡
             */


            for (int i = 0; i < loanCard_states.size(); i++) {
                try {
                    String openDate = loanCard_openDates.get(i);
                    int between = DateUtil.getMothDiff(formatDate, DateUtil.parseDate(openDate, "yyyy-MM-dd"));
                    String latest24State = loanCard_latest24States.get(i);
                    String[] m7_split = latest24State.split("");
                    for (String str : m7_split) {
                        if (Pattern.compile("^[1-7]$").matcher(str).matches()) {
                            num_m5_List.add(Integer.parseInt(str));
                        }
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }

            /**
             * 信用卡-准贷记卡
             */
            for (int i = 0; i < standardLoancard_states.size(); i++) {
                try {
                    String latest24State = standardLoancard_latest24States.get(i);
                    String[] m7_split = latest24State.split("");
                    for (String str : m7_split) {
                        if (Pattern.compile("^[1-7]$").matcher(str).matches()) {
                            num_m5_List.add(Integer.parseInt(str));
                        }
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            /**
             * todo rh_m24_cr_ovd_num 贷款信息
             */
            for (int i = 0; i < loan_states.size(); i++) {
                try {
                    String latest24State = loan_latest24States.get(i);
                    String[] m7_split = latest24State.split("");
                    for (String str : m7_split) {
                        if (Pattern.compile("^[1-7]$").matcher(str).matches()) {
                            num_m5_List.add(Integer.parseInt(str));
                        }
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            custCard2ResVo.setRh_m24_cr_ovd_num(num_m5_List.size());
//todo -------------------------------------29

            for (int i = 0; i < queryDates.size(); i++) {
                try {
                    String queryDate = queryDates.get(i);
                    Date queryTime = DateUtil.parseDate(queryDate, "yyyy-MM-dd");
                    if ("3".equals(queryReasons.get(i))) {
                        String queryDateMax = queryDates.stream().map(queryDateBean -> queryDateBean.toString()).max(String::compareTo).get();
                        //todo rh_crc_qy_lst_inte 近2年内信用卡审批最晚查询时间距本次申请的时间间隔
                        custCard2ResVo.setRh_crc_qy_lst_inte(DateUtil.getMothDiff(DateUtil.parseDate(queryDateMax, "yyyy-MM-dd"), formatDate));
                    }
                    if ("5".equals(queryReasons.get(i))) {
                        //todo rh_guar_y2_qy_num近2年内担保查询次数
                        custCard2ResVo.setRh_guar_y2_qy_num(custCard2ResVo.getRh_guar_y2_qy_num() + 1);
                    }
                    //todo rh_m3_qy_num 最近3个月查询数
                    if (formatDate.getTime() - queryTime.getTime() <= threeMonths) {
                        custCard2ResVo.setRh_m3_qy_num(custCard2ResVo.getRh_m3_qy_num() + 1);
                    }
                    if ("2".equals(queryReasons.get(i)) || "3".equals(queryReasons.get(i))) {
                        //todo 近2年内信贷产品查询次数
                        custCard2ResVo.setRh_cr_y2_qy_num(custCard2ResVo.getRh_cr_y2_qy_num() + 1);
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }

            //todo rh_ln_y2_qy_num 近2年内贷款审批查询次数
            custCard2ResVo.setRh_ln_y2_qy_num(rh_ln_y2_qy_num);
            //todo rh_pstln_y2_qy_num 近2年内贷后管理查询次数
            custCard2ResVo.setRh_pstln_y2_qy_num(Integer.valueOf(SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "QueryRecord", "RecordSummary", "TwoyearQueryrecordSum", "Sum2").toString()));
            //todo rh_merch_y2_qy_num 近2年内特约商户实名审查查询次数
            custCard2ResVo.setRh_merch_y2_qy_num(Integer.valueOf(SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "QueryRecord", "RecordSummary", "TwoyearQueryrecordSum", "Sum1").toString()));
            //todo rh_self_m1_qy_num 最近1个月本人查询次数
            custCard2ResVo.setRh_self_m1_qy_num(Integer.valueOf(SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "QueryRecord", "RecordSummary", "LatestMonthQueryrecordSum", "Sum").toString()));

            //近12个月信贷产品查询机构数
            Set creditProductsSet = new HashSet();
            //近12个月贷款审批查询机构数
            Set loanProductsSet = new HashSet();
            for (int i = 0; i < queryDates.size(); i++) {
                try {
                    if (DateUtil.getMothDiff(formatDate, DateUtil.parseDate(queryDates.get(i).toString(), "yyyy-MM-dd")) <= 12 && ("2".equals(queryReasons.get(i)) || "3".equals(queryReasons.get(i)))) {
                        creditProductsSet.add(queriers.get(i));
                    }
                    if (DateUtil.getMothDiff(formatDate, DateUtil.parseDate(queryDates.get(i).toString(), "yyyy-MM-dd")) <= 12 && ("2".equals(queryReasons.get(i)))) {
                        loanProductsSet.add(queriers.get(i));
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            //近12个月信贷产品查询机构数
            custCard2ResVo.setRh_cr_m12_qy_org_num(creditProductsSet.size());
            //近12个月贷款审批查询机构数
            custCard2ResVo.setRh_ln_m12_qy_org_num(loanProductsSet.size());

            //todo rh_crc_y2_qy_num 近2年内信用卡审批查询次数
            custCard2ResVo.setRh_crc_y2_qy_num(rh_crc_y2_qy_num);
            //todo rh_ln_cr_y2_qy_pro  近2年内贷款占信贷产品查询次数比例
            custCard2ResVo.setRh_ln_cr_y2_qy_pro(custCard2ResVo.getRh_cr_y2_qy_num() == 0 ? new BigDecimal(0) : new BigDecimal(custCard2ResVo.getRh_ln_y2_qy_num().toString()).divide(new BigDecimal(custCard2ResVo.getRh_cr_y2_qy_num().toString()), 2, BigDecimal.ROUND_HALF_UP));
            //todo rh_crc_cr_y2_qy_pro 近2年内信用卡占信贷产品查询次数比例
            custCard2ResVo.setRh_crc_cr_y2_qy_pro(custCard2ResVo.getRh_cr_y2_qy_num() == 0 ? new BigDecimal(0) : new BigDecimal(custCard2ResVo.getRh_crc_y2_qy_num()).divide(new BigDecimal(custCard2ResVo.getRh_cr_y2_qy_num()), 2, BigDecimal.ROUND_HALF_UP));
            //todo rh_crc_y2_qyf_num 近2个年信用卡查询失败次数
            custCard2ResVo.setRh_crc_y2_qyf_num(rh_crc_y2_qyf_num);
            //todo rh_crc_m12_qyf_num 近12个月信用卡查询失败次数
            custCard2ResVo.setRh_crc_m12_qyf_num(custCard2ResVo.getRh_m12_crc_qy_num() - rh_crc_m12_qy_num_success.size());
            //todo rh_cr_y2_qyf_pro 近2年内信贷产品查询失败次数占比
            custCard2ResVo.setRh_cr_y2_qyf_pro(custCard2ResVo.getRh_cr_y2_qy_num() == 0 ? new BigDecimal(0) : (new BigDecimal(custCard2ResVo.getRh_ln_y2_qyf_num().toString()).add(new BigDecimal(custCard2ResVo.getRh_crc_y2_qyf_num().toString()))).divide(new BigDecimal(custCard2ResVo.getRh_cr_y2_qy_num().toString()), 2, BigDecimal.ROUND_HALF_UP));
            //todo rh_ln_y2_qyf_pro 近2年内贷款查询失败次数占比
            custCard2ResVo.setRh_ln_y2_qyf_pro(custCard2ResVo.getRh_ln_y2_qy_num() == 0 ? new BigDecimal(0) : new BigDecimal(custCard2ResVo.getRh_ln_y2_qyf_num()).divide(new BigDecimal(custCard2ResVo.getRh_ln_y2_qy_num().toString()), 2, BigDecimal.ROUND_HALF_UP));
            //todo rh_crc_y2_qyf_pro 近2年内信用卡查询失败次数占比
            custCard2ResVo.setRh_crc_y2_qyf_pro(custCard2ResVo.getRh_crc_y2_qy_num() == 0 ? new BigDecimal(0) : new BigDecimal(custCard2ResVo.getRh_crc_y2_qyf_num().toString()).divide(new BigDecimal(custCard2ResVo.getRh_crc_y2_qy_num().toString()), 2, BigDecimal.ROUND_HALF_UP));
            //todo Rh_crc_m6_qyf_num 近6个月内信用卡查询失败次数
            custCard2ResVo.setRh_crc_m6_qyf_num(custCard2ResVo.getRh_m6_crc_qy_num() - rh_crc_m6_qy_num_success.size());
            //todo Rh_ln_m6_qyf_num 近6个月贷款查询失败次数
            custCard2ResVo.setRh_ln_m6_qyf_num(rh_m6_ln_qy_num - rh_ln_m6_qy_num_success.size());
            //todo Rh_cr_m6_qyf_num 近6个月信贷产品查询失败次数
            custCard2ResVo.setRh_cr_m6_qyf_num(custCard2ResVo.getRh_crc_m6_qyf_num() + custCard2ResVo.getRh_ln_m6_qyf_num());
            //todo 近12个月贷款查询失败次数占比
            int rh_ln_m12_qyf_num = custCard2ResVo.getRh_m12_ln_qy_num() - rh_ln_m12_qy_num_success.size();
            custCard2ResVo.setRh_ln_m12_qyf_pro(rh_ln_m12_qyf_num == 0 || custCard2ResVo.getRh_m12_ln_qy_num() == 0 ? new BigDecimal(0) : new BigDecimal(rh_ln_m12_qyf_num).divide(new BigDecimal(custCard2ResVo.getRh_m12_ln_qy_num()), 2, BigDecimal.ROUND_HALF_UP));
            //todo rh_crc_cr_y2_qyf_pro  近2年内信用卡查询失败次数占信贷产品查询失败次数比例
            custCard2ResVo.setRh_crc_cr_y2_qyf_pro(custCard2ResVo.getRh_cr_y2_qyf_num().intValue() == 0 ? new BigDecimal(0) : (new BigDecimal(custCard2ResVo.getRh_crc_y2_qyf_num().toString())).divide(new BigDecimal(custCard2ResVo.getRh_cr_y2_qyf_num()), 2, BigDecimal.ROUND_HALF_UP));

            //todo rh_crc_cr_m6_qyf_pro 近6月内信用卡查询失败次数占信贷产品查询失败次数比例
            custCard2ResVo.setRh_crc_cr_m6_qyf_pro(custCard2ResVo.getRh_cr_m6_qyf_num() == 0 ? new BigDecimal(0) : new BigDecimal(custCard2ResVo.getRh_crc_m6_qyf_num()).divide(new BigDecimal(custCard2ResVo.getRh_cr_m6_qyf_num()), 2, BigDecimal.ROUND_HALF_UP));

            //todo rh_crc_cr_m12_qyf_pro 近12月内信用卡查询失败次数占信贷产品查询失败次数比例
            custCard2ResVo.setRh_crc_cr_m12_qyf_pro((custCard2ResVo.getRh_crc_m12_qyf_num() + rh_ln_m12_qyf_num) == 0 ? new BigDecimal(0) : new BigDecimal(custCard2ResVo.getRh_crc_m12_qyf_num()).divide((new BigDecimal(rh_ln_m12_qyf_num).add(new BigDecimal(custCard2ResVo.getRh_crc_m12_qyf_num().toString()))), 2, BigDecimal.ROUND_HALF_UP));

            //todo rh_ln_cr_y2_qyf_pro 近2年贷款查询失败次数占信贷产品查询失败次数比例
            custCard2ResVo.setRh_ln_cr_y2_qyf_pro(custCard2ResVo.getRh_ln_y2_qyf_num() + custCard2ResVo.getRh_crc_y2_qyf_num() == 0 ? new BigDecimal(0) : new BigDecimal(custCard2ResVo.getRh_ln_y2_qyf_num().toString()).divide(new BigDecimal(custCard2ResVo.getRh_ln_y2_qyf_num() + custCard2ResVo.getRh_crc_y2_qyf_num()), 2, BigDecimal.ROUND_HALF_UP));

            //todo Rh_ln_cr_m12_qyf_pro 近12个月贷款查询失败次数占信贷产品查询失败次数比例
            custCard2ResVo.setRh_ln_cr_m12_qyf_pro((custCard2ResVo.getRh_crc_m12_qyf_num() + rh_ln_m12_qyf_num) == 0 ? new BigDecimal(0) : new BigDecimal(rh_ln_m12_qyf_num).divide(new BigDecimal(custCard2ResVo.getRh_crc_m12_qyf_num() + rh_ln_m12_qyf_num), 2, BigDecimal.ROUND_HALF_UP));


            //近2年内贷款审批查询机构数
            Set rh_ln_y2_qy_org_num_set = new HashSet();
            //近2年内信用卡审批查询机构数
            Set rh_crc_y2_qy_org_num_set = new HashSet();
            //近2年内担保查询机构数
            Set rh_guar_y2_qy_org_num_set = new HashSet();
            //近2年内信贷产品查询机构数
            Set rh_cr_y2_qy_org_num_set = new HashSet();
            for (int i = 0; i < queryDates.size(); i++) {
                try {
                    String queryReason = queryReasons.get(i);
                    String querier = queriers.get(i);
                    String queryDate = queryDates.get(i);
                    int between = DateUtil.getMothDiff(formatDate, DateUtil.parseDate(queryDate, "yyyy-MM-dd"));
                    //对查询操作员进行去重
                    if ("2".equals(queryReason)) {
                        rh_ln_y2_qy_org_num_set.add(querier);
                    }
                    if ("3".equals(queryReason)) {
                        rh_crc_y2_qy_org_num_set.add(querier);
                    }
                    if ("5".equals(queryReason)) {
                        rh_guar_y2_qy_org_num_set.add(querier);
                    }
                    if ("2".equals(queryReason) || "3".equals(queryReason)) {
                        if (between <= 24) {
                            rh_cr_y2_qy_org_num_set.add(querier);
                        }
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            //todo rh_ln_y2_qy_org_num 近2年内贷款审批查询机构数
            custCard2ResVo.setRh_ln_y2_qy_org_num(rh_ln_y2_qy_org_num_set.size());
            //todo rh_crc_y2_qy_org_num 近2年内信用卡审批查询机构数
            custCard2ResVo.setRh_crc_y2_qy_org_num(rh_crc_y2_qy_org_num_set.size());
            //todo rh_guar_y2_qy_org_num 近2年内担保查询机构数
            custCard2ResVo.setRh_guar_y2_qy_org_num(rh_guar_y2_qy_org_num_set.size());
            //todo rh_cr_y2_qy_org_num 近2年内信贷产品查询机构数
            custCard2ResVo.setRh_cr_y2_qy_org_num(rh_cr_y2_qy_org_num_set.size());
            //todo rh_ln_cr_y2_qy_org_pro 近2年内贷款占信贷产品查询机构数比例
            custCard2ResVo.setRh_ln_cr_y2_qy_org_pro(custCard2ResVo.getRh_ln_y2_qy_org_num() == 0 || custCard2ResVo.getRh_cr_y2_qy_org_num() == 0 ? new BigDecimal(0) : new BigDecimal(custCard2ResVo.getRh_ln_y2_qy_org_num()).divide(new BigDecimal(custCard2ResVo.getRh_cr_y2_qy_org_num()), 2, BigDecimal.ROUND_HALF_UP));
            //todo rh_crc_cr_y2_qy_org_pro 近2年内信用卡占信贷产品查询机构数比例
            custCard2ResVo.setRh_crc_cr_y2_qy_org_pro(custCard2ResVo.getRh_crc_y2_qy_org_num() == 0 || custCard2ResVo.getRh_cr_y2_qy_org_num() == 0 ? new BigDecimal(0) : new BigDecimal(custCard2ResVo.getRh_crc_y2_qy_org_num()).divide(new BigDecimal(custCard2ResVo.getRh_cr_y2_qy_org_num()), 2, BigDecimal.ROUND_HALF_UP));
            //todo rh_ln_cr_m12_qy_org_pro 近12个月内贷款占信贷产品查询机构数比例
            if (custCard2ResVo.getRh_cr_m12_qy_org_num() != 0) {
                custCard2ResVo.setRh_ln_cr_m12_qy_org_pro(new BigDecimal(custCard2ResVo.getRh_ln_m12_qy_org_num().toString()).divide(new BigDecimal(custCard2ResVo.getRh_cr_m12_qy_org_num().toString()), 2, BigDecimal.ROUND_HALF_UP));
            }
            //todo rh_crc_y2_qyf_org_num 近2年内信用卡查询失败机构数
            custCard2ResVo.setRh_crc_y2_qyf_org_num(custCard2ResVo.getRh_crc_y2_qy_org_num() - rh_crc_y2_qy_num_success.size());
            //todo rh_ln_y2_qyf_org_num 近2年内贷款查询失败机构数
            custCard2ResVo.setRh_ln_y2_qyf_org_num(custCard2ResVo.getRh_ln_y2_qy_org_num() - rh_ln_y2_qy_num_success.size());
            //todo rh_cr_y2_qyf_org_num 近2年内信贷产品查询失败机构数
            custCard2ResVo.setRh_cr_y2_qyf_org_num(custCard2ResVo.getRh_crc_y2_qyf_org_num() + custCard2ResVo.getRh_ln_y2_qyf_org_num());

            //todo rh_cr_y2_qyf_org_pro 近2年内信贷产品查询失败机构数占比
            custCard2ResVo.setRh_cr_y2_qyf_org_pro(custCard2ResVo.getRh_cr_y2_qyf_org_num() == 0 || custCard2ResVo.getRh_cr_y2_qy_org_num() == 0 ? new BigDecimal(0) : new BigDecimal(custCard2ResVo.getRh_cr_y2_qyf_org_num()).divide(new BigDecimal(custCard2ResVo.getRh_cr_y2_qy_org_num()), 2, BigDecimal.ROUND_HALF_UP));
            //todo rh_ln_y2_qyf_org_pro 近2年内贷款查询失败机构数占比
            custCard2ResVo.setRh_ln_y2_qyf_org_pro(custCard2ResVo.getRh_ln_y2_qyf_org_num() == 0 || custCard2ResVo.getRh_ln_y2_qy_org_num() == 0 ? new BigDecimal(0) : new BigDecimal(custCard2ResVo.getRh_ln_y2_qyf_org_num()).divide(new BigDecimal(custCard2ResVo.getRh_ln_y2_qy_org_num()), 2, BigDecimal.ROUND_HALF_UP));
            //todo rh_crc_y2_qyf_org_pro 近2年内信用卡查询失败机构数占比
            custCard2ResVo.setRh_crc_y2_qyf_org_pro(custCard2ResVo.getRh_crc_y2_qyf_org_num() == 0 || custCard2ResVo.getRh_crc_y2_qy_org_num() == 0 ? new BigDecimal(0) : new BigDecimal(custCard2ResVo.getRh_crc_y2_qyf_org_num()).divide(new BigDecimal(custCard2ResVo.getRh_crc_y2_qy_org_num()), 2, BigDecimal.ROUND_HALF_UP));
            //todo rh_crc_cr_y2_qyf_org_pro 近2年内信用卡查询失败机构数占信贷产品查询失败机构数比例
            custCard2ResVo.setRh_crc_cr_y2_qyf_org_pro(custCard2ResVo.getRh_crc_y2_qyf_org_num() == 0 || custCard2ResVo.getRh_cr_y2_qyf_org_num() == 0 ? new BigDecimal(0) : new BigDecimal(custCard2ResVo.getRh_crc_y2_qyf_org_num()).divide(new BigDecimal(custCard2ResVo.getRh_cr_y2_qyf_org_num()), 2, BigDecimal.ROUND_HALF_UP));
            //todo rh_ln_cr_y2_qyf_org_pro 近2年内贷款查询失败机构数占信贷产品查询失败机构数比例
            custCard2ResVo.setRh_ln_cr_y2_qyf_org_pro(custCard2ResVo.getRh_cr_y2_qyf_org_num() == 0 ? new BigDecimal(0) : new BigDecimal(custCard2ResVo.getRh_ln_y2_qyf_org_num()).divide(new BigDecimal(custCard2ResVo.getRh_cr_y2_qyf_org_num()), 2, BigDecimal.ROUND_HALF_UP));

            //todo 最近3个月查询数 上面代码

            //todo rh_qy_max_dt 最新的查询日期
            for (int i = 0; i < queryDates.size(); i++) {
                try {
                    String queryDate = queryDates.get(i);
                    custCard2ResVo.setRh_qy_max_dt(DateUtil.getBiggerDate1(custCard2ResVo.getRh_qy_max_dt(), queryDate));
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            //todo rh_ln_op_min_dt 首笔贷款发放月份（全部）
            custCard2ResVo.setRh_ln_op_min_dt(creditSummaryCue == null || StringUtils.isBlank(creditSummaryCue.get("FirstLoanOpenMonth").toString()) ? "NaN" : creditSummaryCue.get("FirstLoanOpenMonth").toString());
            //todo 首张贷记卡发卡月份（全部）
            custCard2ResVo.setRh_lncd_op_min_dt(creditSummaryCue == null || StringUtils.isBlank(creditSummaryCue.get("FirstLoancardOpenMonth").toString())  ? "NaN" : creditSummaryCue.get("FirstLoancardOpenMonth").toString());
            //todo rh_stlncd_op_min_dt 首张准贷记卡发卡月份（全部）
            custCard2ResVo.setRh_stlncd_op_min_dt(creditSummaryCue == null || StringUtils.isBlank(creditSummaryCue.get("FirstStandardLoancardOpenMonth").toString()) ? "NaN" : creditSummaryCue.get("FirstStandardLoancardOpenMonth").toString());
            // todo rh_cr_op_min_dt 信贷产品最早开立月份
            custCard2ResVo.setRh_cr_op_min_dt(DateUtil.getSmallerDate2(DateUtil.getSmallerDate2(custCard2ResVo.getRh_ln_op_min_dt(), custCard2ResVo.getRh_lncd_op_min_dt()), custCard2ResVo.getRh_stlncd_op_min_dt()));

            //todo 最近开立贷款日期

            //住房贷款种类
            ArrayList<String> houseLoan = new ArrayList<String>() {{
                add("11");
                add("12");
                add("13");
            }};
            for (int i = 0; i < loan_states.size(); i++) {
                try {
                    String state = loan_states.get(i);
                    String openDate = loan_openDates.get(i);
                    String endDate = loan_endDates.get(i);
                    String recentPayDate = recentPayDates.get(i);
                    String type = loan_contractInfoTypes.get(i);

                    //todo rh_ln_op_max_dt 最近开立日期 最近开立贷款日期
                    custCard2ResVo.setRh_ln_op_max_dt(DateUtil.getBiggerDate1(custCard2ResVo.getRh_ln_op_max_dt(), openDate));
                    //todo rh_ln_op_old_dt 最老贷款账户开户日期
                    custCard2ResVo.setRh_ln_op_old_dt(DateUtil.getSmallerDate1(custCard2ResVo.getRh_ln_op_old_dt(), openDate));

                    if (!"3".equals(state)) {
                        //todo rh_ln_rct_paydt 最近未结清贷款到期日
                        custCard2ResVo.setRh_ln_rct_paydt(DateUtil.getSmallerDate1(custCard2ResVo.getRh_ln_rct_paydt(), endDate));
                    }
                    if ("21".equals(type)) {
                        //todo rh_carln_rct_paydt 个人汽车贷款最近还款日期
                        custCard2ResVo.setRh_carln_rct_paydt(DateUtil.getBiggerDate1(custCard2ResVo.getRh_carln_rct_paydt(), recentPayDate));
                        //todo rh_carln_op_max_dt 最近开立个人汽车贷款日期
                        custCard2ResVo.setRh_carln_op_max_dt(DateUtil.getBiggerDate1(custCard2ResVo.getRh_carln_op_max_dt(), openDate));

                    }
                    if (houseLoan.contains(type)) {
                        //todo rh_hsln_rct_paydt个人住房贷款最近还款日期
                        custCard2ResVo.setRh_hsln_rct_paydt(DateUtil.getBiggerDate1(recentPayDate, custCard2ResVo.getRh_hsln_rct_paydt()));
                        //todo rh_hsln_op_max_dt 最近开立住房贷款日期
                        custCard2ResVo.setRh_hsln_op_max_dt(DateUtil.getBiggerDate1(custCard2ResVo.getRh_hsln_op_max_dt(), openDate));
                    }
                    if ("41".equals(type)) {
                        //todo rh_opln_rct_paydt 个人经营贷款最近还款日期
                        custCard2ResVo.setRh_opln_rct_paydt(DateUtil.getBiggerDate1(custCard2ResVo.getRh_opln_rct_paydt(), recentPayDate));
                        //todo rh_oprln_op_max_dt 最近开立个人经营贷款日期
                        custCard2ResVo.setRh_oprln_op_max_dt(DateUtil.getBiggerDate1(custCard2ResVo.getRh_oprln_op_max_dt(), openDate));
                    }
                    if ("51".equals(type)) {
                        //todo rh_agln_op_max_dt 最近开立个人农户贷款日期
                        custCard2ResVo.setRh_agln_op_max_dt(DateUtil.getBiggerDate1(custCard2ResVo.getRh_agln_op_max_dt(), openDate));
                        //todo rh_agln_rct_paydt 个人农户贷款最近还款日期
                        custCard2ResVo.setRh_agln_rct_paydt(DateUtil.getBiggerDate1(custCard2ResVo.getRh_agln_rct_paydt(), recentPayDate));
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
                }
            }
            //todo 最近未结清贷款到期日
            //todo 个人汽车贷款最近还款日期
            //todo 最近开立个人汽车贷款日期
            //todo 个人住房贷款最近还款日期
            //todo 最近开立住房贷款日期
            //todo 个人经营贷款最近还款日期
            //todo 最近开立个人经营贷款日期
            //todo 最近开立个人农户贷款日期
            //todo 最老贷款账户开户日期
            //todo 最近贷记卡开立日期
            //todo 最老贷记卡账户开户日期
            //todo 最近准贷记卡开立日期
            //todo 最老准贷记卡账户开户日期
            //todo rh_crc_op_max_dt 最近信用卡开立日期
            custCard2ResVo.setRh_crc_op_max_dt(DateUtil.getBiggerDate1(custCard2ResVo.getRh_lncd_op_max_dt(), custCard2ResVo.getRh_stlncd_op_max_dt()));

            /**
             *  开发人员：潘宇
             *  时间：2020.2.24
             */
            custCard2ResVo.initCustomerCardModelVo(
                    filter(custCard2ResVo.getRh_lncd_op_max_dt(), ""), filter(custCard2ResVo.getRh_lncd_op_old_dt(), ""), filter(custCard2ResVo.getRh_stlncd_op_max_dt(), ""), filter(custCard2ResVo.getRh_stlncd_op_old_dt(), ""), filter(custCard2ResVo.getRh_crc_op_max_dt(), ""), filter(custCard2ResVo.getRh_ln_op_max_dt(), ""), filter(custCard2ResVo.getRh_ln_rct_paydt(), ""), filter(custCard2ResVo.getRh_carln_rct_paydt(), ""), filter(custCard2ResVo.getRh_carln_op_max_dt(), ""), filter(custCard2ResVo.getRh_hsln_rct_paydt(), ""), filter(custCard2ResVo.getRh_hsln_op_max_dt(), ""), filter(custCard2ResVo.getRh_opln_rct_paydt(), ""), filter(custCard2ResVo.getRh_oprln_op_max_dt(), ""), filter(custCard2ResVo.getRh_agln_rct_paydt(), ""), filter(custCard2ResVo.getRh_agln_op_max_dt(), ""), filter(custCard2ResVo.getRh_ln_op_old_dt(), ""), filter(custCard2ResVo.getRh_ln_op_min_dt(), ""), filter(custCard2ResVo.getRh_lncd_op_min_dt(), ""), filter(custCard2ResVo.getRh_stlncd_op_min_dt(), ""), filter(custCard2ResVo.getRh_cr_op_min_dt(), ""), filter(custCard2ResVo.getRh_qy_max_dt(), ""),
                    filter(custCard2ResVo.getRh_ln_op_max_dt(), "y"), filter(custCard2ResVo.getRh_ln_rct_paydt(), "y"), filter(custCard2ResVo.getRh_agln_op_max_dt(), "y"), filter(custCard2ResVo.getRh_ln_op_old_dt(), "y"), filter(custCard2ResVo.getRh_ln_op_min_dt(), "y"), filter(custCard2ResVo.getRh_lncd_op_min_dt(), "y"), filter(custCard2ResVo.getRh_qy_max_dt(), "y"),
                    filter(custCard2ResVo.getRh_lncd_op_max_dt(), "m"), filter(custCard2ResVo.getRh_lncd_op_old_dt(), "m"), filter(custCard2ResVo.getRh_ln_rct_paydt(), "m"), filter(custCard2ResVo.getRh_ln_op_min_dt(), "m"), filter(custCard2ResVo.getRh_lncd_op_min_dt(), "m"), filter(custCard2ResVo.getRh_stlncd_op_min_dt(), "m"), filter(custCard2ResVo.getRh_qy_max_dt(), "m"),
                    filter(custCard2ResVo.getRh_lncd_op_max_dt(), "d"), filter(custCard2ResVo.getRh_lncd_op_old_dt(), "d"), filter(custCard2ResVo.getRh_stlncd_op_max_dt(), "d"), filter(custCard2ResVo.getRh_stlncd_op_old_dt(), "d"), filter(custCard2ResVo.getRh_ln_op_max_dt(), "d"), filter(custCard2ResVo.getRh_ln_rct_paydt(), "d"), filter(custCard2ResVo.getRh_carln_op_max_dt(), "d"), filter(custCard2ResVo.getRh_hsln_rct_paydt(), "d"), filter(custCard2ResVo.getRh_hsln_op_max_dt(), "d"), filter(custCard2ResVo.getRh_opln_rct_paydt(), "d"), filter(custCard2ResVo.getRh_oprln_op_max_dt(), "d"), filter(custCard2ResVo.getRh_agln_op_max_dt(), "d"), filter(custCard2ResVo.getRh_ln_op_old_dt(), "d"), filter(custCard2ResVo.getRh_qy_max_dt(), "d"),
                    filter(custCard2ResVo.getRh_lncd_op_max_dt(), "w"), filter(custCard2ResVo.getRh_lncd_op_old_dt(), "w"), filter(custCard2ResVo.getRh_stlncd_op_max_dt(), "w"), filter(custCard2ResVo.getRh_ln_op_max_dt(), "w"), filter(custCard2ResVo.getRh_ln_rct_paydt(), "w"), filter(custCard2ResVo.getRh_carln_op_max_dt(), "w"), filter(custCard2ResVo.getRh_hsln_rct_paydt(), "w"), filter(custCard2ResVo.getRh_oprln_op_max_dt(), "w"), filter(custCard2ResVo.getRh_agln_op_max_dt(), "w"), filter(custCard2ResVo.getRh_ln_op_old_dt(), "w"), filter(custCard2ResVo.getRh_qy_max_dt(), "w"),
                    filter(custCard2ResVo.getRh_lncd_op_max_dt(), "y"), filter(custCard2ResVo.getRh_lncd_op_old_dt(), "y"), filter(custCard2ResVo.getRh_stlncd_op_max_dt(), "y"), filter(custCard2ResVo.getRh_stlncd_op_min_dt(), "y"), filter(custCard2ResVo.getRh_stlncd_op_old_dt(), "y"),
                    filter(custCard2ResVo.getRh_stlncd_op_max_dt(), "m"), filter(custCard2ResVo.getRh_stlncd_op_old_dt(), "m"),
                    filter(custCard2ResVo.getRh_crc_op_max_dt(), "y"), filter(custCard2ResVo.getRh_cr_op_min_dt(), "y"),
                    filter(custCard2ResVo.getRh_crc_op_max_dt(), "m"), filter(custCard2ResVo.getRh_cr_op_min_dt(), "m"), filter(custCard2ResVo.getRh_ln_op_max_dt(), "m"),
                    filter(custCard2ResVo.getRh_carln_rct_paydt(), "y"), filter(custCard2ResVo.getRh_carln_op_max_dt(), "y"),
                    filter(custCard2ResVo.getRh_carln_rct_paydt(), "m"), filter(custCard2ResVo.getRh_carln_op_max_dt(), "m"),
                    filter(custCard2ResVo.getRh_hsln_rct_paydt(), "y"), filter(custCard2ResVo.getRh_hsln_op_max_dt(), "y"),
                    filter(custCard2ResVo.getRh_hsln_rct_paydt(), "m"), filter(custCard2ResVo.getRh_hsln_op_max_dt(), "m"),
                    filter(custCard2ResVo.getRh_opln_rct_paydt(), "y"), filter(custCard2ResVo.getRh_oprln_op_max_dt(), "y"),
                    filter(custCard2ResVo.getRh_opln_rct_paydt(), "m"), filter(custCard2ResVo.getRh_oprln_op_max_dt(), "m"),
                    filter(custCard2ResVo.getRh_agln_rct_paydt(), "y"),
                    filter(custCard2ResVo.getRh_agln_rct_paydt(), "m"), filter(custCard2ResVo.getRh_agln_op_max_dt(), "m")
            );
            /**
             * 负责内容：83-117
             */
        } catch (Exception e) {
            LoggerUtil.logBusinessErrorFile("客户卡2指标"+e.getMessage());;
        }
        MapUtil.setNullAttributeToDefaultValue(custCard2ResVo);
        /**
         *  结束
         */
        return custCard2ResVo;
    }

    public static BigDecimal filter(String date, String logo) throws ParseException {
        try {
            Calendar now = Calendar.getInstance();
            date = date.replaceAll("\\.|\\-", "");
            Date time = DateUtil.stampToDate(date.length() == 6 ? date.concat("01") : date, DateUtil.FORMAT_DATE_2);
            now.setTime(time);
            date = DateUtil.format(time, DateUtil.FORMAT_DATE_2);
            switch (logo) {
                case "":
                    return new BigDecimal(String.valueOf(now.getTimeInMillis()).substring(0, 10));
                case "y":
                    return new BigDecimal(now.get(Calendar.YEAR));
                case "m":
                    return new BigDecimal((now.get(Calendar.MONTH) + 1));
                case "d":
                    return new BigDecimal(now.get(Calendar.DAY_OF_MONTH));
                case "w":
                    return new BigDecimal(now.get(Calendar.WEEK_OF_YEAR));
            }
        } catch (Exception e) {
            return new BigDecimal(0);
        }
        return new BigDecimal(0);
    }

}
