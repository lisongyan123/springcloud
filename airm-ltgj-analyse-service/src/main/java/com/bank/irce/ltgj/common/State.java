package com.bank.irce.ltgj.common;

import java.io.Serializable;

public class State implements Serializable {
    private static final long serialVersionUID = 4012254270671007406L;

    /**
     * 状态码
     */
    private String code;
    /**
     * 状态描述
     */
    private String desc;

    public State() {
    }

    public State(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public String getCode() {
        return code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "State{" +
                "code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
