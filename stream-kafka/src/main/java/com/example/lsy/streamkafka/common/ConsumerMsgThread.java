package com.example.lsy.streamkafka.common;

import com.example.lsy.streamkafka.service.SendMsgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

@Slf4j
@Component
public class ConsumerMsgThread implements Callable {

    @Resource
    private SendMsgService sendMsgService;

    public ConsumerMsgThread(SendMsgService sendMsgService){
        this.sendMsgService = sendMsgService;
    }

    public ConsumerMsgThread() {
    }

    @Override
    public Object call() throws Exception {
        log.info("当前线程{}",Thread.currentThread().getName());
        String msg2 = sendMsgService.getMsg2();
        System.err.println("本条线程 =  "+Thread.currentThread().getName()+"消息= "+msg2);
        log.info("线程返回消息 = {}",msg2);
        return msg2;
    }


//    @Override
//    public void run() {
//        log.info("当前线程{}",Thread.currentThread().getName());
//        String msg2 = sendMsgService.getMsg2();
//        System.err.println("本条线程 =  "+Thread.currentThread().getName()+"消息= "+msg2);
//        log.info("线程返回消息 = {}",msg2);
//    }

}
