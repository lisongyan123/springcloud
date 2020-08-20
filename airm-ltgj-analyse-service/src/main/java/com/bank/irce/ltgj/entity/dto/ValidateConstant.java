package com.bank.irce.ltgj.entity.dto;

/**
 * 正则校验常量类
 */
public interface ValidateConstant {
    //流水号正则校验
//    String SESSION_ID = "^[a-zA-Z0-9]{32}$";
    //身份证号正则校验
    String CERT_NO = "^\\d{6}(18|19|20)?\\d{2}(0[1-9]|1[012])(0[1-9]|[12]\\d|3[01])\\d{3}(\\d|[xX])$";
    //证件类型正则校验
    String CERT_TYPE = "^[1-9a-c]{1}$";
    //证件日期（20200520）
    String DATE_REGEXP = "^[1-9]\\d{3}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$";
    //客户名称
    String CUSTOMER_NAME= "^([\\u4e00-\\u9fa5]{1,40}|[a-zA-Z\\.\\s]{1,40})$";
    //扣款状态 0 失败 1成功 2
    String CHN_GENDER = "[0,1,2,3]";
    //年龄
    String AGE_OLD= "^([1-9]|[1-9]\\d|1\\d{2}|200)$";
    //手机号
    String PHONE_REGEXP = "^(13[0-9]|14[5-9]|15[0-3,5-9]|16[2,5,6,7]|17[0-8]|18[0-9]|19[0-3,5-9])\\d{8}$";
    //贷款用途
    String LOAN_PURPOSE  = "0[1-5]";
    //用户是否授
    String CUST_AUTH = "[0-1]";
    /**
     * int类型
     */
    String VALUE_TYPE_INT="1";
    /**
     * int类型 默认值
     */
    String VALUE_TYPE_INT_DEFAULT_VALUE="0";
    /**
     * string类型
     */
    String VALUE_TYPE_STRING="2";
    /**
     * string类型 默认值
     */
    String VALUE_TYPE_STRING_DEFAULT_VALUE="NAN";
    /**
     * date类型
     */
    String VALUE_TYPE_DATE="3";
    /**
     * date类型 默认值
     */
    String VALUE_TYPE_DATE_DEFAULT_VALUE="";
    /**
     * map类型
     */
    String VALUE_TYPE_MAP="4";
    /**
     * list类型
     */
    String VALUE_TYPE_LIST="5";
    /**
     * bigDecimal类型
     */
    String VALUE_TYPE_BIG_DECIMAL="6";
    /**
     * bigDecimal类型
     */
    String VALUE_TYPE_BIG_DECIMAL_DEFAULT_VALUE="-99988";
    /**
     * 信用卡审批贷款审批
     */
    String QUERY_REASON_CREDIT_CARD_AND_LOANS ="信用卡审批贷款审批";

    /**
     * 信用卡审批
     */
    String QUERY_REASON_CREDIT_CARD ="信用卡审批";

    /**
     * 贷款审批
     */
    String QUERY_REASON_LOANS ="贷款审批";


}
