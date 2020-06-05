package com.example.cloudservice.extra.algorithm.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
public class AsyncTaskExecutePool implements AsyncConfigurer {

    /** 注入配置类 */
    private final AsyncTaskProperties config;

    public AsyncTaskExecutePool(AsyncTaskProperties config) {
        this.config = config;
    }

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程池大小
        executor.setCorePoolSize(config.getCorePoolSize());
        //最大线程数
        executor.setMaxPoolSize(config.getMaxPoolSize());
        //队列容量
        executor.setQueueCapacity(config.getQueueCapacity());
        //活跃时间
        executor.setKeepAliveSeconds(config.getKeepAliveSeconds());
        //线程名字前缀
        executor.setThreadNamePrefix("el-async-");
        // setRejectedExecutionHandler：当pool已经达到max size的时候，如何处理新任务
        // CallerRunsPolicy：不在新线程中执行任务，而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (throwable, method, objects) -> {
            log.error("===="+throwable.getMessage()+"====", throwable);
            log.error("exception method:"+method.getName());
        };
    }

    /**
     * 打印线程池状态
     * @param executor
     */
    public void printThreadPoolStatus(ThreadPoolExecutor executor) {
        int poolSize = executor.getPoolSize();
        int corePoolSize = executor.getCorePoolSize();
        int activeCount = executor.getActiveCount();
        long completedTaskCount = executor.getCompletedTaskCount();
        long taskCount = executor.getTaskCount();
        int queueCount = executor.getQueue().size();
        int largestPoolSize = executor.getLargestPoolSize();
        int maximumPoolSize = executor.getMaximumPoolSize();
        long time = executor.getKeepAliveTime(TimeUnit.MILLISECONDS);
        boolean isShutDown = executor.isShutdown();
        boolean isTerminated = executor.isTerminated();
        String info = String.format("初始线程数：%s、核心线程数：%s、正在执行的任务数量：%s、已完成任务数量：%s、任务总数：%s、" +
                        "队列里缓存的任务数量：%s、池中存在的最大线程数：%s、最大允许的线程数：%s、线程空闲时间：%s、线程池是否关闭：%s、" +
                        "线程池是否终止：%s", poolSize, corePoolSize, activeCount, completedTaskCount, taskCount, queueCount,
                largestPoolSize, maximumPoolSize, time, isShutDown, isTerminated);
        log.info(info);
    }

    public void printThreadPoolStatus(ThreadPoolExecutor... executors) {
        for (int i=0; i< executors.length; i++) {
            printThreadPoolStatus(executors[i]);
        }
    }
}
