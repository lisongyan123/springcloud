package com.bank.irce.ltgj.common;

import org.apache.commons.lang3.StringUtils;

public enum LogFileName {
    // 与logback.xml的logger name 相同
    BUSINESS_FILE("businessFile"),
    BATCH_FILE("batchFile");

    private String logFileName;

    LogFileName(String fileName) {
        this.logFileName = fileName;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public void setLogFileName(String logFileName) {
        this.logFileName = logFileName;
    }

    public static LogFileName getAwardTypeEnum(String value) {
        LogFileName[] arr = values();
        for(LogFileName item : arr) {
            if(null != item && StringUtils.isNotBlank(item.logFileName)) {
                return item;
            }
        }
        return null;
    }
}
