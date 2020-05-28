package com.springcloud.lsy.service.impl;

import com.alibaba.fastjson.JSON;
import com.springcloud.lsy.bean.GatewayTable;
import com.springcloud.lsy.service.GatewayDefineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 定义MysqlRouteDefinitionRepository类，实现RouteDefinitionRepository接口的getRouteDefinitions方法，
 * 获取从数据库里面装载的路由配置，当然还有save和delete其他方法。
 */
@Component
public class MysqlRouteDefinitionRepository implements RouteDefinitionRepository {

    @Autowired
    private GatewayDefineService gatewayDefineService;

    @Autowired
    GatewayDefineServiceImpl gatewayDefineServiceImpl;

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        try {
            List<GatewayTable> gatewayTableList = gatewayDefineServiceImpl.findAll();
            Map<String, RouteDefinition> routes = new LinkedHashMap<String, RouteDefinition>();
            gatewayTableList.stream().forEach(v->{
                RouteDefinition definition = new RouteDefinition();
                definition.setId(v.getId());
                try {
                    definition.setUri(new URI(v.getUri()));
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                List<PredicateDefinition> predicateDefinitions = v.getPredicateDefinition();
                if(predicateDefinitions != null){
                    definition.setPredicates(predicateDefinitions);
                }
                List<FilterDefinition> filterDefinitions = v.getFilterDefinition();
                if(filterDefinitions != null){
                    definition.setFilters(filterDefinitions);
                }
                routes.put(definition.getId(), definition);
            });
            return Flux.fromIterable(routes.values());
        }catch (Exception e) {
            e.printStackTrace();
            return Flux.empty();
        }
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return route.flatMap(r -> {
            try {
                GatewayTable gatewayDefine = new GatewayTable();
                gatewayDefine.setId(r.getId());
                gatewayDefine.setUri(r.getUri().toString());
                gatewayDefine.setPredicate(JSON.toJSONString(r.getPredicates()));
                gatewayDefine.setFilter(JSON.toJSONString(r.getFilters()));
                gatewayDefineService.save(gatewayDefine);
                return Mono.empty();

            } catch (Exception e) {
                e.printStackTrace();
                return Mono.defer(() -> Mono.error(new NotFoundException("RouteDefinition save error: "+ r.getId())));
            }

        });
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return routeId.flatMap(id -> {
            try {
                gatewayDefineService.deleteById(id);
                return Mono.empty();

            } catch (Exception e) {
                e.printStackTrace();
                return Mono.defer(() -> Mono.error(new NotFoundException("RouteDefinition delete error: " + routeId)));
            }
        });
    }
}

