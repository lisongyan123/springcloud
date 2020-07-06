package com.example.elasticsearch.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@ConfigurationProperties(prefix = "esconfig")
@Slf4j
public class ESConfig {
    @Value("${esconfig.host}")
    private String hostName;
    @Value("${esconfig.port}")
    private int port;
    @Value("${esconfig.cluster}")
    private String clusterName;

    @Bean
    public TransportClient client() throws Exception {
        // 9300是es的tcp服务端口
        TransportAddress node = null;
        try{
            node = new TransportAddress(
                    InetAddress.getByName(hostName),
                    9300);
        }catch(UnknownHostException e){
            // 打印错误信息，并且抛出错误异常
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
        // 设置es节点的配置信息
        Settings settings = Settings.builder()
                .put("cluster.name", clusterName)
                .build();

        // 实例化es的客户端对象
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(node);
        return client;
    }


}