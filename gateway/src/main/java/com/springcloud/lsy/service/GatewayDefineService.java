package com.springcloud.lsy.service;

import com.springcloud.lsy.bean.GatewayTable;

import java.util.List;

public interface GatewayDefineService {
    List<GatewayTable> findAll() throws Exception;
    String loadRouteDefinition() throws Exception;
    boolean save(GatewayTable gatewayDefine) throws Exception;
    boolean deleteById(String id) throws Exception;
    GatewayTable existsById(String id)throws Exception;
}
