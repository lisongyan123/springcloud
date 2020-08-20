package com.bank.irce.ltgj.entity.dto;

public class ModelConstant {

    //客户卡1.0指标加工异常
    public static final String ER_AIRM_CUSTOMER_1 = "客户卡1.0指标加工异常";
    //客户卡2.0指标加工异常
    public static final String ER_AIRM_CUSTOMER_2 ="客户卡2.0指标加工异常";
    //反欺诈指标加工异常
    public static final String ER_AIRM_EXTERNAL_FEARPRO ="反欺诈指标加工异常";
    //推断模型指标加工异常
    public static final String ER_AIRM_INGERENTIAL = "推断模型指标加工异常";

    //查询客户卡1.0失败
    public static final String ER_CUST_SCORE_1 ="查询客户卡1.0失败";
    //查询客户卡2.0失败
    public static final String ER_CUST_SCORE_2 ="查询客户卡2.0失败";

    //查询授信反欺诈模型异常
    public static final String ER_CREDIT_ANTIFRAUD ="查询授信反欺诈模型异常";
    //查询授信反欺诈模型异常
    public static final String ER_USE_ANTIFRAUD ="查询授信反欺诈模型异常";
    //查询百融反欺诈模型异常
    public static final String ER_BR_RULE ="查询百融反欺诈模型异常";
    //查询天御反欺诈模型异常
    public static final String ER_TY_RULE ="查询天御反欺诈模型异常";

    //反欺诈前置规则模型失败
    public static final String ER_ANTIFRAUD = "反欺诈前置规则模型失败";

    //查询利率推断模型失败
    public static final String ER_RATE = "查询利率推断模型失败";
    //查询负债推断模型失败
    public static final String ER_DEBT = "查询负债推断模型失败";
    //查询收入推断模型失败
    public static final String ER_INCOME = "查询收入推断模型失败";

    //查询最优定价模型失败
    public static final String ER_IOPT = "查询最优定价模型失败";

    //初审准入策略处理异常
    public static final String ER_FIRSTSTRATEGY = "初审准入策略处理异常";
    //终审准入策略处理异常
    public static final String ER_FINALSTRATEGY = "终审准入策略处理异常";

    //查询科技部接口异常
    public static final String ER_IRCE_DATA ="查询科技部接口异常";
    //数据整合异常
    public static final String ER_MEGREDATA  ="数据整合异常";

    /**
     * 查询贷款要素为null
     * duansz 2020.05.14
     */

    public static final String ER_DROPPING = "落表失败";

    public static final String MESSAGE_QUERY = "查询贷款要素为null";

    //反欺诈模型汇总异常
    public static final String ER_MODEL_SUM ="反欺诈模型汇总异常";

    //查询静态宽表为空
    public static final String ER_STATIC_QUErY ="查询静态宽表为 null";

}
