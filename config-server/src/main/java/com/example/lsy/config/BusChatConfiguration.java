package com.example.lsy.config;

import com.example.lsy.event.ChatRemoteApplicationEvent;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(ChatListener.class)
@RemoteApplicationEventScan(basePackageClasses= ChatRemoteApplicationEvent.class)
public class BusChatConfiguration {

    @Bean
    public ChatListener ChatListener(){
        return new ChatListener();
    }
}