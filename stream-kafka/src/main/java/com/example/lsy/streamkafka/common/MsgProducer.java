package com.example.lsy.streamkafka.common;

import com.example.lsy.streamkafka.bean.XyKafkaInMsg;
import com.example.lsy.streamkafka.mapper.XyKafkaInMsgDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@Slf4j
@Component
@EnableScheduling
public class MsgProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;
    @Resource
    private XyKafkaInMsgDao inMsgMapper;
    @Scheduled(cron = "0/10 * * * * ?")
    public void send() {
        String message = UUID.randomUUID().toString();
        ListenableFuture listenableFuture = kafkaTemplate.send(Topic.SIMPLE,message);
        listenableFuture.addCallback(
                o -> log.info("消息发送成功,{}", o.toString()),
                throwable -> log.info("消息发送失败,{}" + throwable.getMessage())
        );
        XyKafkaInMsg build = new XyKafkaInMsg();
        build.setFwBh(System.currentTimeMillis());
        build.setGmtCreate(new Date());
        XyKafkaInMsg inMsg = inMsgMapper.selectByFuBh(build.getFwBh());
        if (inMsg == null){
            int saveMsgResult = inMsgMapper.insertSelective(build);
            log.info("消息插入结果：{}",saveMsgResult == 1 ? "成功" : "失败");
        }
    }
}