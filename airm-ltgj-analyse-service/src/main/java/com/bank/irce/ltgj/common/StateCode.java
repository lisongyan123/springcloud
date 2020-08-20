package com.bank.irce.ltgj.common;

import java.io.Serializable;

/**
 * 响应数据
 *
 * @author bluecrush
 * @create 2018-03-09 下午12:57
 **/
public enum StateCode implements Serializable {
    /**
     * 响应成功
     */
    SUCCESS("0000", "响应成功")
    /**
     * 响应失败
     */
    , ER_VERIFY_ERROR("ER001", "响应失败")
    /**
     * 参数校验不通过
     */
    , ER_PARAM_NOT_ACCESS("ER002", "参数校验不通过")
    /**
     * 系统繁忙
     */
    , ER_UNKNOW("ER999", "系统繁忙")
    ;

    private String code;
    private String desc;

    StateCode() {
    }

    StateCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}


