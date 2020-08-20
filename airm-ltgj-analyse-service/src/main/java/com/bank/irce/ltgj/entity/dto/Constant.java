package com.bank.irce.ltgj.entity.dto;


public class Constant {
    /**
     *SessionId 前缀
     */
    public static final String SESSION_ID = "GSD2";
    /**
     *数字常量
     */
    public static final Integer NUMBER_ZERO = 0;
    public static final Integer NUMBER_ONE = 1;
    public static final Integer NUMBER_TWO = 2;
    /**
     *入参默认值 null
     */
    public static final String DEFAULT_PARAMS = "-999";
    public static final String DEFAULT_ARGS = "{}";
    public static final String DEFAULT_EMPTY = "";
    /**
     *响应状态
     */
    public static final String RESP_SUSECC = "0000";

    // 一年的毫秒值
    public static final Long YEAT_TIME=360 * 24 * 60 * 60 * 1000L;
    // 三个月的毫秒值
    public static final Long THREE_TIME = 90 * 24 * 60 * 60 * 1000L;
    // 一个月的毫秒值
    public static final Long ONE_TIME = 30 * 24 * 60 * 60 * 1000L;
    /**
     * 30天的毫秒值
     */
    public static final Long THIRTY_DAYS_MILLIS = 30 * 24 * 60 * 60 * 1000L;
    /**
     * 30天的毫秒值
     */
    public static final Long NINETY_DAYS_MILLIS = 90 * 24 * 60 * 60 * 1000L;
    //拉去百融报文常量
    public static final String BAIRONG_CHANNELCODE = "bairong";
//    public static final String BAIRONG_SCORE_CHANNELCODE = "bairongScore";
    public static final String BAIRONG_CHANNELDESC = "通过TFT拉取百融文件";
//    public static final String BAIRONG_SCORE_CHANNELDESC = "通过TFT拉取百融信用分文件";

    /**
     * 判断是否是数字
     */
    public static final String IS_INT="^[0-9]*$";

    /**
     * 判断时间
     */
    public static final String IS_DATE="^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1][0-9])|([2][0-4]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";


    /**
     * 客户端等级E
     */
    public static final String CUST_SEG_E = "E";

    public static final String BUSINESS_NAME = "平安无抵押风险共担";

}
