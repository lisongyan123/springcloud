package com.bank.irce.ltgj.common;


import lombok.Data;

/**
 * @author bluecrush
 * @project SmartWeb
 * @description 自定义交易异常
 * @create 2018-03-21 下午5:10
 **/
@Data
public class TradeException extends Exception {
    private String code;
    private String message;

    /**
     * 构造异常类
     *
     * @param code    状态码
     * @param message 状态信息描述
     */
    public TradeException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public TradeException(String message) {
        this.message = message;
    }

}
