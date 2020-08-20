package com.bank.irce.ltgj.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoggerUtil {

    private static final Logger BUSINESS_FILE = LoggerUtil.logger(LogFileName.BUSINESS_FILE);

    public static <T> Logger logger(Class<T> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    /**
     * 打印到指定的文件下
     * @param desc 日志文件名称
     * @return
     */
    private static Logger logger(LogFileName desc) {
        return LoggerFactory.getLogger(desc.getLogFileName());
    }

    /**
     * 打印业务日志
     */
    public static void logBusinessFile(String info){
        BUSINESS_FILE.info(info);
    }
    public static void logBusinessErrorFile(String errorInfo){
        BUSINESS_FILE.error(errorInfo);
    }
    public static void logBusinessDebugFile(String debugInfo){
        BUSINESS_FILE.debug(debugInfo);
    }
    public static void logBusinessWarnFile(String warnInfo){
        BUSINESS_FILE.warn(warnInfo);
    }


    public static void logBusinessErrorFile(Exception e ,String sessionId){
        for (int i = 0;i < e.getStackTrace().length;i++){
            LoggerUtil.logBusinessErrorFile("sessionId:"+sessionId+";"+Thread.currentThread().getName()+";"+e.getStackTrace()[i].toString());
        }
    }
    public static void logBusinessErrorFile(String message, String sessionId) {
        logBusinessErrorFile("sessionId:" + sessionId + "; " + message);
    }


}
