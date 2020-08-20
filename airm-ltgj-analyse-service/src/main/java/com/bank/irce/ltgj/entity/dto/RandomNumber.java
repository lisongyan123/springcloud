package com.bank.irce.ltgj.entity.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

public class RandomNumber {
    //使用单模式不允许直接创建实例
    private RandomNumber(){
    }
    //创建一个空实例，类需要的时候才赋值
    private static RandomNumber instance = null;
    //单例模式
    public static synchronized RandomNumber getInstance(){
        if (instance==null){
            instance= new RandomNumber();
        }
        return instance;
    }
    //全局自增数
    private static int count = 1;
    //格式化的时间字符串
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    //获取当前时间毫秒值得字符串
    private static String getNowDataStr(){
        return sdf.format(new Date());
    }
    //记录上一次时间，用来判断是否需要递增全局数
    private static String now = null;

    //定义锁对象
    private final static ReentrantLock lock = new ReentrantLock();

    //调用的方法
    public static String getRandom(){
        String uuid = String.valueOf(UUID.randomUUID().hashCode()).substring(1,4);
        String ms = String.valueOf(System.currentTimeMillis()).substring(10,13);
        return Constant.SESSION_ID + getNowDataStr() + uuid + ms;
    }

}
