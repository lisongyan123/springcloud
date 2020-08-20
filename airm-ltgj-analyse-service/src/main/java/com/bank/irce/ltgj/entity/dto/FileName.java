package com.bank.irce.ltgj.entity.dto;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

@Data
public class FileName implements Serializable {
    private String fileName;

    public FileName() {
    }

    public FileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this,true);
    }


}
