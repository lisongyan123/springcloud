package com.example.cloudservice.common.functions;

/**
 * 对象过滤接口
 *
 * @param <T>
 */
public interface ObjectFilter<T> {
    /**
     * 实现自定义过滤方法
     * @param t
     * @return
     */
    boolean filter(T t);
}
