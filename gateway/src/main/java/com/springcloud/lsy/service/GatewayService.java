package com.springcloud.lsy.service;

import com.springcloud.lsy.bean.GatewayTable;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface GatewayService {

    List<GatewayTable> findAll();

    GatewayTable add(GatewayTable gatewayDefine);

    boolean deleteById(String id);

    boolean existsById(String id);
}

