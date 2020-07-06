package com.example.lsy.streamkafka.service.impl;

import com.example.lsy.streamkafka.service.ShopChannel;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ShopService {

    @Resource(name = ShopChannel.SHOP_OUTPUT)
    private MessageChannel sendShopMessageChannel;

    @GetMapping("/sendMsg")
    public String sendShopMessage(String content) {
        boolean isSendSuccess = sendShopMessageChannel.send(MessageBuilder.withPayload(content).build());
        return isSendSuccess ? "发送成功" : "发送失败";
    }

    @StreamListener(ShopChannel.SHOP_INPUT)
    public void receive(Message<String> message) {
        System.out.println(message.getPayload());
    }
}
