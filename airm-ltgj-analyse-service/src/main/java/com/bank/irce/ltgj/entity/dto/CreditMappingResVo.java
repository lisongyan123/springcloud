package com.bank.irce.ltgj.entity.dto;

import com.bank.irce.ltgj.annotation.Mapping2One;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author zhuolin
 * @Date 2020/2/17 15:04
 * @Version 1.0
 */
@Data
@ApiModel(value = "征信2.0到1.0映射")
public class CreditMappingResVo {
    @ApiModelProperty(value = "查询原因")
    @Mapping2One(value = "ReportMessage.Header.QueryReq.QueryReason",defaultValue = ValidateConstant.VALUE_TYPE_STRING)
    private String queryReason ;
    @ApiModelProperty(value = "信用报告生成时间")
    @Mapping2One(value = "ReportMessage.Header.MessageHeader.ReportCreateTime",defaultValue=ValidateConstant.VALUE_TYPE_DATE,regex = Constant.IS_DATE)
    private String reportCreateTime ;
    @Mapping2One(value="ReportMessage.PersonalInfo.Identity.Birthday",defaultValue =ValidateConstant.VALUE_TYPE_DATE,regex = Constant.IS_DATE)
    @ApiModelProperty(value = "出生日期")
    private String birthday ;
    @Mapping2One(value="ReportMessage.PersonalInfo.Identity.EduDegree",defaultValue = ValidateConstant.VALUE_TYPE_STRING)
    @ApiModelProperty(value = "学位")
    private String eduderee ;
    @Mapping2One(value="ReportMessage.PersonalInfo.Identity.EduLevel",defaultValue = ValidateConstant.VALUE_TYPE_STRING)
    @ApiModelProperty(value = "学历")
    private String eduLevel ;
    @Mapping2One(value="ReportMessage.PersonalInfo.Identity.Gender",defaultValue = ValidateConstant.VALUE_TYPE_STRING)
    @ApiModelProperty(value = "性别")
    private String gender ;
    @Mapping2One(value="ReportMessage.PersonalInfo.Identity.MaritalState",defaultValue = ValidateConstant.VALUE_TYPE_STRING)
    @ApiModelProperty(value = "婚姻状况")
    private String maritalState ;
    @Mapping2One(value="ReportMessage.PersonalInfo.Professional.Employer",defaultValue = ValidateConstant.VALUE_TYPE_STRING)
    @ApiModelProperty(value = "工作单位")
    private List<String> employer ;
    @Mapping2One(value="ReportMessage.PersonalInfo.Professional.Duty",defaultValue = ValidateConstant.VALUE_TYPE_STRING)
    @ApiModelProperty(value = "职务")
    private List<String> duty ;
    @Mapping2One(value="ReportMessage.PersonalInfo.Professional.Industry",defaultValue = ValidateConstant.VALUE_TYPE_STRING)
    @ApiModelProperty(value = "行业")
    private List<String> industry ;
    @Mapping2One(value="ReportMessage.PersonalInfo.Professional.Occupation",defaultValue = ValidateConstant.VALUE_TYPE_STRING)
    @ApiModelProperty(value = "职业")
    List<String> occupation ;
    @Mapping2One(value="ReportMessage.PersonalInfo.Professional.StartYear",defaultValue = ValidateConstant.VALUE_TYPE_DATE)
    @ApiModelProperty(value = "进入本单位年份")
    List<String> startYear ;
    @Mapping2One(value="ReportMessage.PublicInfo.AccFund.State",defaultValue = ValidateConstant.VALUE_TYPE_STRING)
    @ApiModelProperty(value = "缴费状态")
    List<String> accfundState ;
    @Mapping2One(value="ReportMessage.PublicInfo.AccFund.ComPercent",defaultValue = "")
    @ApiModelProperty(value = "单位缴存比列")
    List<Integer> compercent ;
    @Mapping2One(value="ReportMessage.PublicInfo.AccFund.FirstMonth",defaultValue = "")
    @ApiModelProperty(value = "初缴月份")
    List<String> firstmonth ;
    @Mapping2One(value="ReportMessage.PublicInfo.AccFund.OwnPercent",defaultValue = "")
    @ApiModelProperty(value = "个人缴存比例")
    List<Integer> ownpercent ;
    @Mapping2One(value="ReportMessage.PublicInfo.AccFund.Pay",defaultValue = "")
    @ApiModelProperty(value = "月缴存额")
    List<Integer> pay ;
    @Mapping2One(value="ReportMessage.PublicInfo.AccFund.ToMonth",defaultValue = "")
    @ApiModelProperty(value = "缴至月份")
    List<String> tomonth ;
    @Mapping2One(value="ReportMessage.PublicInfo.AccFund.GetTime",defaultValue = "")
    @ApiModelProperty(value = "信息更新日期")
    List<String> gettime ;
    @Mapping2One(value="ReportMessage.PersonalInfo.Residence.Address",defaultValue = "NaN")
    @ApiModelProperty(value = "居住地址")
    List<String> address ;
    @Mapping2One(value="ReportMessage.PersonalInfo.Residence.ResidenceType",defaultValue = "NaN")
    @ApiModelProperty(value = "居住状况")
    List<String> residencetype ;
    @Mapping2One(value="ReportMessage.InfoSummary.CreditCue.CreditScore.Score",defaultValue = "")
    @ApiModelProperty(value = "数字解读")
    Integer score = 0;
    @Mapping2One(value="ReportMessage.InfoSummary.CreditCue.CreditScore.ScoreLevel",defaultValue = "")
    @ApiModelProperty(value = "相对位置")
    Integer scoreLevel = 0;
    @Mapping2One(value="ReportMessage.InfoSummary.CreditCue.CreditSummaryCue.FirstLoanOpenMonth",defaultValue = "")
    @ApiModelProperty(value = "首笔贷款发放月份")
    String firstloanopenmonth ;
    @Mapping2One(value="ReportMessage.InfoSummary.CreditCue.CreditSummaryCue.FirstLoancardOpenMonth",defaultValue = "")
    @ApiModelProperty(value = "首张贷记卡发卡月份")
    String firstlopenmonth ;
    @Mapping2One(value="ReportMessage.InfoSummary.CreditCue.CreditSummaryCue.FirstStandardLoancardOpenMonth",defaultValue = "")
    @ApiModelProperty(value = "首张准贷记卡发卡月份")
    String firstslopenmonth ;
    @Mapping2One(value="ReportMessage.InfoSummary.CreditCue.CreditSummaryCue.LoancardCount",defaultValue = "0")
    @ApiModelProperty(value = "贷记卡账户数")
    Integer loancardcount = 0;
    @Mapping2One(value="ReportMessage.InfoSummary.CreditCue.CreditSummaryCue.OtherLoanCount",defaultValue = "")
    @ApiModelProperty(value = "其他贷款笔数")
    Integer otherloancount = 0;
    @Mapping2One(value="ReportMessage.InfoSummary.CreditCue.CreditSummaryCue.PerBusinessHouseLoanCount",defaultValue = "")
    @ApiModelProperty(value = "个人商用房（包括商住两用）贷款笔数")
    Integer perbusinesshouseloancount = 0;
    @Mapping2One(value="ReportMessage.InfoSummary.CreditCue.CreditSummaryCue.PerHouseLoanCount",defaultValue = "")
    @ApiModelProperty(value = "个人住房贷款笔数")
    Integer perhouseloancount = 0;
    @Mapping2One(value="ReportMessage.InfoSummary.CreditCue.CreditSummaryCue.StandardLoancardCount",defaultValue = "")
    @ApiModelProperty(value = "准贷记卡账户数")
    Integer slcount = 0;
    @Mapping2One(value="ReportMessage.InfoSummary.ShareAndDebt.GuaranteeSummary.Amount",defaultValue = "")
    @ApiModelProperty(value = "担保金额")
    BigDecimal guaransumamount ;
    @Mapping2One(value="ReportMessage.InfoSummary.ShareAndDebt.GuaranteeSummary.Balance",defaultValue = "")
    @ApiModelProperty(value = "担保本金余额")
    BigDecimal guaransumbalance ;
    @Mapping2One(value="ReportMessage.InfoSummary.ShareAndDebt.UnpaidLoan.Latest6MonthUsedAvgAmount",defaultValue = "")
    @ApiModelProperty(value = "最近6个月平均使用额度（贷款）")
    BigDecimal ul6musedavgamount ;
    @Mapping2One(value="ReportMessage.InfoSummary.ShareAndDebt.UnpaidLoan.AccountCount",defaultValue = "")
    @ApiModelProperty(value = "笔数/账户数")
    Integer ulaccountcount = 0;
    @Mapping2One(value="ReportMessage.InfoSummary.ShareAndDebt.UnpaidLoan.Balance",defaultValue = "")
    @ApiModelProperty(value = "余额")
    BigDecimal ulbalance ;
    @Mapping2One(value="ReportMessage.InfoSummary.ShareAndDebt.UnpaidLoan.CreditLimit",defaultValue = "")
    @ApiModelProperty(value = "授信总额")
    BigDecimal ulcreditlimit ;
    @Mapping2One(value="ReportMessage.InfoSummary.ShareAndDebt.UnpaidLoan.FinanceCorpCount",defaultValue = "")
    @ApiModelProperty(value = "贷款法人机构数")
    Integer ulfinancecorpcount ;
    @Mapping2One(value="ReportMessage.InfoSummary.ShareAndDebt.UndestoryLoancard.Latest6MonthUsedAvgAmount",defaultValue = "")
    @ApiModelProperty(value = "最近6个月平均使用额度（贷记卡）")
    BigDecimal ulc6musedavgamount ;
    @Mapping2One(value="ReportMessage.InfoSummary.ShareAndDebt.UndestoryLoancard.AccountCount",defaultValue = "")
    @ApiModelProperty(value = "账户数")
    Integer ulcaccountcount;
    @Mapping2One(value="ReportMessage.InfoSummary.ShareAndDebt.UndestoryLoancard.CreditLimit",defaultValue = "")
    @ApiModelProperty(value = "授信总额")
    BigDecimal ulccreditlimit ;
    @Mapping2One(value="ReportMessage.InfoSummary.ShareAndDebt.UndestoryLoancard.MaxCreditLimitPerOrg",defaultValue = "")
    @ApiModelProperty(value = "单家行最高授信额度")
    BigDecimal ulcmaxcreperorg ;
    @Mapping2One(value="ReportMessage.InfoSummary.ShareAndDebt.UndestoryLoancard.UsedCreditLimit",defaultValue = "")
    @ApiModelProperty(value = "已用额度")
    BigDecimal ulcusedcre ;
    @Mapping2One(value="ReportMessage.InfoSummary.ShareAndDebt.UndestoryStandardLoancard.AccountCount",defaultValue = "")
    @ApiModelProperty(value = "准贷记卡账户数")
    Integer uslcaccountcount ;
    @Mapping2One(value="ReportMessage.InfoSummary.ShareAndDebt.UndestoryStandardLoancard.CreditLimit",defaultValue = "")
    @ApiModelProperty(value = "准贷记卡授信总额")
    BigDecimal uslccreditlimit ;
    @Mapping2One(value="ReportMessage.InfoSummary.ShareAndDebt.UndestoryStandardLoancard.UsedCreditLimit",defaultValue = "")
    @ApiModelProperty(value = "透支余额")
    BigDecimal uslcusedcre ;
    @Mapping2One(value="ReportMessage.InfoSummary.OverdueAndFellback.OverdueSummary.LoanSum.Count",defaultValue = "")
    @ApiModelProperty(value = "贷款逾期笔数/账户数")
    Integer lscount ;
    @Mapping2One(value="ReportMessage.InfoSummary.OverdueAndFellback.OverdueSummary.LoancardSum.Count",defaultValue = "")
    @ApiModelProperty(value = "贷记卡逾期笔数/账户数")
    Integer lcscount ;
    @Mapping2One(value="ReportMessage.InfoSummary.OverdueAndFellback.OverdueSummary.StandardLoancardSum.Count",defaultValue = "")
    @ApiModelProperty(value = "准贷记卡60天以上透支 笔数/账户数")
    Integer slscount ;
    @Mapping2One(value="ReportMessage.InfoSummary.OverdueAndFellback.OverdueSummary.LoanSum.HighestOverdueAmountPerMon",defaultValue = "")
    @ApiModelProperty(value = "贷款逾期单月最高逾期总额/单月最高透支总额")
    BigDecimal lshighestoverdueamountpermon ;
    @Mapping2One(value="ReportMessage.InfoSummary.OverdueAndFellback.OverdueSummary.LoancardSum.HighestOverdueAmountPerMon",defaultValue = "")
    @ApiModelProperty(value = "贷记卡逾期单月最高逾期总额/单月最高透支总额")
    BigDecimal lcshighestoverdueamountpermon ;
    @Mapping2One(value="ReportMessage.InfoSummary.OverdueAndFellback.OverdueSummary.StandardLoancardSum.HighestOverdueAmountPerMon",defaultValue = "")
    @ApiModelProperty(value = "准贷记卡60天以上透支单月最高逾期总额/单月最高透支总额")
    BigDecimal slshighestoverdueamountpermon ;
    @Mapping2One(value="ReportMessage.InfoSummary.OverdueAndFellback.OverdueSummary.LoanSum.MaxDuration",defaultValue = "")
    @ApiModelProperty(value = "贷款逾期最长逾期月数/最长透支月数")
    Integer lsmaxduration ;
    @Mapping2One(value="ReportMessage.InfoSummary.OverdueAndFellback.OverdueSummary.LoancardSum.MaxDuration",defaultValue = "")
    @ApiModelProperty(value = "贷记卡逾期 最长逾期月数/最长透支月数")
    Integer lcsmaxduration ;
    @Mapping2One(value="ReportMessage.InfoSummary.OverdueAndFellback.OverdueSummary.StandardLoancardSum.MaxDuration",defaultValue = "")
    @ApiModelProperty(value = "准贷记卡60天以上透支最长逾期月数/最长透支月数")
    Integer slsmaxduration ;
    @Mapping2One(value="ReportMessage.InfoSummary.OverdueAndFellback.OverdueSummary.LoanSum.Months",defaultValue = "")
    @ApiModelProperty(value = "贷款逾期月份数")
    Integer lsmonths ;
    @Mapping2One(value="ReportMessage.InfoSummary.OverdueAndFellback.OverdueSummary.LoancardSum.Months",defaultValue = "")
    @ApiModelProperty(value = "贷记卡逾期月份数")
    Integer lcsmonths ;
    @Mapping2One(value="ReportMessage.InfoSummary.OverdueAndFellback.OverdueSummary.StandardLoancardSum.Months",defaultValue = "")
    @ApiModelProperty(value = "准贷记卡60天以上透支月份数")
    Integer slsmonths ;
    @Mapping2One(value="ReportMessage.CreditDetail.GuaranteeInfo.Guarantee.EndDate",defaultValue = "", regex = Constant.IS_DATE)
    @ApiModelProperty(value = "担保贷款到期日期")
    List<String> dnxx_enddateList ;
    @Mapping2One(value="ReportMessage.CreditDetail.GuaranteeInfo.Guarantee.GuaranteeBalance",defaultValue = "0")
    @ApiModelProperty(value = "担保贷款本金余额")
    List<BigDecimal> guaranteebalanceList ;
    @Mapping2One(value="ReportMessage.CreditDetail.Loancard.AwardCreditInfo.CreditLimitAmount",defaultValue = "0")
    @ApiModelProperty(value = "贷记卡授信额度")
    List<String> loancard_credit_amtList ;
    @Mapping2One(value="ReportMessage.CreditDetail.StandardLoancard.AwardCreditInfo.CreditLimitAmount",defaultValue = "0")
    @ApiModelProperty(value = "准贷记卡授信额度")
    List<String> standardLoancard_credit_amtList ;
    @Mapping2One(value="ReportMessage.CreditDetail.Loancard.AwardCreditInfo.Currency",defaultValue = "NaN")
    @ApiModelProperty(value = "贷记卡币种")
    List<String> loancard_xxkmx_currencyList ;
    @Mapping2One(value="ReportMessage.CreditDetail.StandardLoancard.AwardCreditInfo.Currency",defaultValue = "NaN")
    @ApiModelProperty(value = "准贷记卡币种")
    List<String> standardLoancard_xxkmx_currencyList ;
    @Mapping2One(value="ReportMessage.CreditDetail.Loancard.CurrOverdue.CurrOverdueAmount",defaultValue = "")
    @ApiModelProperty(value = "贷记卡当前逾期金额")
    List<BigDecimal> loancard_xxkmx_curroverdueamountList ;
    @Mapping2One(value="ReportMessage.CreditDetail.Loancard.AwardCreditInfo.FinanceOrg",defaultValue = "NaN")
    @ApiModelProperty(value = "贷记卡发卡机构")
    List<String> loancard_xxkmx_financeorgList ;
    @Mapping2One(value="ReportMessage.CreditDetail.StandardLoancard.AwardCreditInfo.FinanceOrg",defaultValue = "NaN")
    @ApiModelProperty(value = "准贷记卡发卡机构")
    List<String> standardLoancard_xxkmx_financeorgList ;
    @Mapping2One(value="ReportMessage.CreditDetail.Loancard.Latest24MonthPaymentState.Latest24State",defaultValue = "")
    @ApiModelProperty(value = "贷记卡24个月还款状态")
    List<String> loancard_xxkmx_latest24state = new ArrayList<>();
    @Mapping2One(value="ReportMessage.CreditDetail.StandardLoancard.Latest24MonthPaymentState.Latest24State",defaultValue = "")
    @ApiModelProperty(value = "准贷记卡24个月还款状态")
    List<String> standardLoancard_xxkmx_latest24state = new ArrayList<>();
    @Mapping2One(value="ReportMessage.CreditDetail.Loancard.RepayInfo.Latest6MonthUsedAvgAmount",defaultValue = "")
    @ApiModelProperty(value = "贷记卡最近6个月平均使用额度/最近6个月平均透支余额")
    List<BigDecimal> latest6monthusedavgamountList ;
    @Mapping2One(value="ReportMessage.CreditDetail.StandardLoancard.RepayInfo.Latest6MonthUsedAvgAmount",defaultValue = "0")
    @ApiModelProperty(value = "准贷记卡最近6个月平均使用额度/最近6个月平均透支余额")
    List<BigDecimal> latest6_month_used_avg_amountList ;
    @Mapping2One(value="ReportMessage.CreditDetail.Loancard.State",defaultValue = "")
    @ApiModelProperty(value = "账户状态")
    List<String> loancard_state = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.StandardLoancard.State",defaultValue = "")
    @ApiModelProperty(value = "账户状态")
    List<String> standardLoancard_state = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.Loancard.AwardCreditInfo.OpenDate",defaultValue = "", regex = Constant.IS_DATE)
    @ApiModelProperty(value = "发卡日期")
    List<String> awardCreditInfo_opendate = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.StandardLoancard.AwardCreditInfo.OpenDate",defaultValue = "", regex = Constant.IS_DATE)
    @ApiModelProperty(value = "发卡日期")
    List<String> sl_awardCreditInfo_opendate = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.StandardLoancard.CurrOverdue.OverdueOver180Amount",defaultValue = "")
    @ApiModelProperty(value = "逾期180天以上未归还贷款本金")
    List<String> overdueover180amount = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.Loancard.RepayInfo.ShareCreditLimitAmount",defaultValue = "")
    @ApiModelProperty(value = "共享额度")
    List<String> lr_sharecreditlimitamount = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.StandardLoancard.RepayInfo.ShareCreditLimitAmount",defaultValue = "")
    @ApiModelProperty(value = "共享额度")
    List<String> sr_sharecreditlimitamount = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.StandardLoancard.RepayInfo.UsedCreditLimitAmount",defaultValue = "")
    @ApiModelProperty(value = "已用额度/透支余额")
    List<String> lr_usedcreditlimitamount = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.Loancard.RepayInfo.UsedCreditLimitAmount",defaultValue = "")
    @ApiModelProperty(value = "已用额度/透支余额")
    List<String> sr_usedcreditlimitamount = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.Loancard.RepayInfo.UsedHighestAmount",defaultValue = "")
    @ApiModelProperty(value = "贷记卡最大使用额度/最大透支余额")
    List<String> usedhighestamount_88 = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.StandardLoancard.RepayInfo.UsedHighestAmount",defaultValue = "")
    @ApiModelProperty(value = "准贷记卡最大使用额度/最大透支余额")
    List<String> usedhighestamount_89 = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.Loan.CurrAccountInfo.Balance",defaultValue = "")
    @ApiModelProperty(value = "本金余额（贷款明细）")
    List<String> loanid = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.Loan.CurrAccountInfo.Class5State",defaultValue = "")
    @ApiModelProperty(value = "五级分类（贷款明细）")
    List<String> class5state = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.Loan.ContractInfo.CreditLimitAmount",defaultValue = "")
    @ApiModelProperty(value = "合同金额（贷款明细）")
    List<BigDecimal> creditlimitamount = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.Loan.ContractInfo.Currency",defaultValue = "NaN")
    @ApiModelProperty(value = "币种（贷款明细）")
    List<String> currency = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.Loan.CurrOverdue.CurrOverdueAmount",defaultValue = "")
    @ApiModelProperty(value = "当前逾期金额（贷款明细）")
    List<String> curroverdueamount = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.Loan.ContractInfo.EndDate",defaultValue = "", regex = Constant.IS_DATE)
    @ApiModelProperty(value = "到期日期（贷款明细）")
    List<String> enddate = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.Loan.ContractInfo.FinanceOrg",defaultValue = "NAN")
    @ApiModelProperty(value = "贷款机构（贷款明细）")
    List<String> financeorg = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.Loan.Latest24MonthPaymentState.Latest24State",defaultValue = "")
    @ApiModelProperty(value = "24个月还款状态（贷款明细）")
    List<String> latest24state = new ArrayList<>();
    @Mapping2One(value="ReportMessage.CreditDetail.Loan.State",defaultValue = "")
    @ApiModelProperty(value = "账户状态（贷款明细）")
    List<String> loaninfo_state = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.Loan.ContractInfo.Type",defaultValue = "")
    @ApiModelProperty(value = "贷款种类细分（贷款明细）")
    List<String> loaninfo_type = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.Loan.ContractInfo.OpenDate",defaultValue = "", regex = Constant.IS_DATE)
    @ApiModelProperty(value = "发放日期（贷款明细）")
    List<String> opendate = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.Loan.ContractInfo.PaymentRating",defaultValue = "")
    @ApiModelProperty(value = "还款频率（贷款明细）")
    List<String> paymentrating = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.Loan.CurrAccountInfo.RecentPayDate",defaultValue = "", regex = Constant.IS_DATE)
    @ApiModelProperty(value = "最近一次还款日期（贷款明细）")
    List<String> recentpaydate = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.Loan.CurrAccountInfo.RemainPaymentCyc",defaultValue = "")
    @ApiModelProperty(value = "剩余还款期数（贷款明细）")
    List<String> remainpaymentcyc = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.Loan.CurrAccountInfo.ScheduledPaymentAmount",defaultValue = "")
    @ApiModelProperty(value = "本月应还款（贷款明细）")
    List<String> scheduledpaymentamount = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.Loan.ContractInfo.GuaranteeType",defaultValue = "")
    @ApiModelProperty(value = "担保方式（贷款明细）")
    List<String> guaranteetype = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.Loan.ContractInfo.PaymentCyc",defaultValue = "")
    @ApiModelProperty(value = "还款期数（贷款明细）")
    List<String> paymentcyc = new ArrayList();
    @Mapping2One(value="ReportMessage.CreditDetail.Loan.SpecialTrade.Type",defaultValue = "")
    @ApiModelProperty(value = "类型")
    List<String> specialtrade_type = new ArrayList();
    @Mapping2One(value="ReportMessage.QueryRecord.RecordSummary.LatestMonthQueryrecordSum.Sum",defaultValue = "")
    @ApiModelProperty(value = "最近1个月本人查询次数")
    Integer last1m_self_query_cnt ;
    //文档中路径与最近2年贷后管理查询次数重复，加以数字区别
    @Mapping2One(value="ReportMessage.QueryRecord.RecordSummary.TwoyearQueryrecordSum.Sum1",defaultValue = "")
    @ApiModelProperty(value = "最近2年特约商户实名审查查询次数")
    Integer last2y_merc_realname_query_cnt ;
    //文档中路径与最近2年特约商户实名审查查询次数重复，加以数字区别
    @Mapping2One(value="ReportMessage.QueryRecord.RecordSummary.TwoyearQueryrecordSum.Sum2",defaultValue = "")
    @ApiModelProperty(value = "最近2年贷后管理查询次数")
    Integer last2y_post_loan_mag_query_cnt ;
    @Mapping2One(value="ReportMessage.QueryRecord.RecordInfo.RecordDetail.Querier",defaultValue = "NaN")
    @ApiModelProperty(value = "查询操作员")
    List<String> rdquerier = new ArrayList();
    @Mapping2One(value="ReportMessage.QueryRecord.RecordInfo.RecordDetail.QueryDate",defaultValue = "", regex = Constant.IS_DATE)
    @ApiModelProperty(value = "查询时间")
    List<String> rdquerydate = new ArrayList();
    @Mapping2One(value="ReportMessage.QueryRecord.RecordInfo.RecordDetail.QueryReason",defaultValue = "")
    @ApiModelProperty(value = "查询原因")
    List<String> rdqueryreason = new ArrayList();
    @Mapping2One(value="ReportMessage.PersonalInfo.Residence.GetTime",defaultValue = "", regex = Constant.IS_DATE)
    @ApiModelProperty(value = "居住状况中的信息更新日期")
    List<String> residencetime = new ArrayList();
    @Mapping2One(value="ReportMessage.PersonalInfo.Professional.GetTime",defaultValue = "", regex = Constant.IS_DATE)
    @ApiModelProperty(value = "职业中的信息更新日期")
    List<String> professionalTime = new ArrayList();


    public void  init(){
        //工作单位
        employer = new ArrayList<>();
        //职务
        duty = new ArrayList<>();
        //行业
        industry = new ArrayList<>();
        //职业
        occupation = new ArrayList<>();
        //
        startYear = new ArrayList<>();
        //
        professionalTime = new ArrayList();
        //
        accfundState = new ArrayList<>();
        //
        compercent = new ArrayList<>();
        //
        firstmonth = new ArrayList<>();
        //
        ownpercent = new ArrayList<>();
        //
        pay = new ArrayList<>();
        //
        tomonth = new ArrayList<>();
        //
        gettime = new ArrayList<>();
        //
        address = new ArrayList<>();
        //
        residencetype = new ArrayList();
        //
        residencetime = new ArrayList();
        //
        loancard_state = new ArrayList();
        //
        standardLoancard_state = new ArrayList();
        //
        awardCreditInfo_opendate = new ArrayList();
        //
        sl_awardCreditInfo_opendate = new ArrayList();
        //
        overdueover180amount = new ArrayList();
        //
        lr_sharecreditlimitamount = new ArrayList();
        //
        sr_sharecreditlimitamount = new ArrayList();
        //
        lr_usedcreditlimitamount = new ArrayList();
        //
        sr_usedcreditlimitamount = new ArrayList();
        //
        loanid = new ArrayList();
        //
        class5state = new ArrayList();
        //
        currency = new ArrayList();
        //
        creditlimitamount = new ArrayList();
        //
        curroverdueamount = new ArrayList();
        //
        enddate = new ArrayList();
        //
        financeorg = new ArrayList();
        //
        loaninfo_state = new ArrayList();
        //
        loaninfo_type = new ArrayList();
        //
        opendate = new ArrayList();
        //
        paymentrating = new ArrayList();
        //
        recentpaydate = new ArrayList();
        //
        remainpaymentcyc = new ArrayList();
        //
        scheduledpaymentamount = new ArrayList();
        //
        guaranteetype = new ArrayList();
        //
        paymentcyc = new ArrayList();
        //
        specialtrade_type = new ArrayList();
        //
        rdquerier = new ArrayList();
        //
        rdquerydate = new ArrayList();
        //
        rdqueryreason = new ArrayList();
    }


    public void initCreditMappingPoSecond(int lscount, int lcscount, int slscount, BigDecimal lshighestoverdueamountpermon, BigDecimal lcshighestoverdueamountpermon,
                                          BigDecimal slshighestoverdueamountpermon, int lsmaxduration, int lcsmaxduration, int slsmaxduration, int lsmonths, int lcsmonths,
                                          int slsmonths, List<String> dnxx_enddateList, List<BigDecimal> guaranteebalanceList, List<String> loancard_credit_amtList, List<String> standardLoancard_credit_amtList, List<String> loancard_xxkmx_currencyList,
                                          List<String> standardLoancard_xxkmx_currencyList, List<BigDecimal> loancard_xxkmx_curroverdueamountList,
                                          List<String> loancard_xxkmx_financeorgList, List<String> standardLoancard_xxkmx_financeorgList, List<String> loancard_xxkmx_latest24state, List<String> standardLoancard_xxkmx_latest24state, List<BigDecimal> latest6monthusedavgamountList, List<BigDecimal> latest6_month_used_avg_amountList) {
        this.setLscount(lscount);
        this.setLcscount(lcscount);
        this.setSlscount(slscount);
        this.setLshighestoverdueamountpermon(lshighestoverdueamountpermon);
        this.setLcshighestoverdueamountpermon(lcshighestoverdueamountpermon);
        this.setSlshighestoverdueamountpermon(slshighestoverdueamountpermon);
        this.setLsmaxduration(lsmaxduration);
        this.setLcsmaxduration(lcsmaxduration);
        this.setSlsmaxduration(slsmaxduration);
        this.setLsmonths(lsmonths);
        this.setLcsmonths(lcsmonths);
        this.setSlsmonths(slsmonths);
        this.setDnxx_enddateList(dnxx_enddateList);
        this.setGuaranteebalanceList(guaranteebalanceList);
        this.setLoancard_credit_amtList(loancard_credit_amtList);
        this.setStandardLoancard_credit_amtList(standardLoancard_credit_amtList);
        this.setLoancard_xxkmx_currencyList(loancard_xxkmx_currencyList);
        this.setStandardLoancard_xxkmx_currencyList(standardLoancard_xxkmx_currencyList);
        this.setLoancard_xxkmx_curroverdueamountList(loancard_xxkmx_curroverdueamountList);
        this.setLoancard_xxkmx_financeorgList(loancard_xxkmx_financeorgList);
        this.setStandardLoancard_xxkmx_financeorgList(standardLoancard_xxkmx_financeorgList);
        this.setLoancard_xxkmx_latest24state(loancard_xxkmx_latest24state);
        this.setStandardLoancard_xxkmx_latest24state(standardLoancard_xxkmx_latest24state);
        this.setLatest6monthusedavgamountList(latest6monthusedavgamountList);
        this.setLatest6_month_used_avg_amountList(latest6_month_used_avg_amountList);
    }


}
