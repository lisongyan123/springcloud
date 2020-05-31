//package com.springcloud.lsy.service.impl;
//
//import com.springcloud.lsy.bean.GatewayTable;
//import com.springcloud.lsy.bean.GatewayTableExample;
//import com.springcloud.lsy.dao.GatewayTableDao;
//import com.springcloud.lsy.service.GatewayDefineService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
//import org.springframework.cloud.gateway.filter.FilterDefinition;
//import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
//import org.springframework.cloud.gateway.route.RouteDefinition;
//import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.stereotype.Service;
//import reactor.core.publisher.Mono;
//
//import javax.annotation.Resource;
//import java.io.File;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.Date;
//import java.util.List;
//import java.util.logging.Filter;
//
///**
// * loadRouteDefinition是重点，它从数据库里获取动态定义的路由，
// * 最后封装成RouteDefinition 类实例，调用RouteDefinitionWriter
// * 的save方法保存。
// */
//@Slf4j
//@Service
//public class GatewayDefineServiceImpl implements GatewayDefineService {
//
//    @Autowired
//    private GatewayDefineService gatewayDefineService;
//
//    @Resource
//    private GatewayTableDao gatewayTableDao;
//
//    @Resource
//    private RouteDefinitionWriter routeDefinitionWriter;
//
//    private ApplicationEventPublisher publisher;
//
//    @Override
//    public List<GatewayTable> findAll() throws Exception {
//        GatewayTableExample gatewayTableExample = new GatewayTableExample();
//        return gatewayTableDao.selectByExample(gatewayTableExample);
//    }
//
//    @Override
//    public String loadRouteDefinition() {
//        try {
//            List<GatewayTable> gatewayTableList = findAll();
//            if (gatewayTableList == null) {
//                return "none route defined";
//            }
//            gatewayTableList.stream().forEach(v->{
//                RouteDefinition definition = new RouteDefinition();
//                definition.setId(v.getId());
//                try {
//                    definition.setUri(new URI(v.getUri()));
//                } catch (URISyntaxException e) {
//                    e.printStackTrace();
//                    log.info("uri异常");
//                }
//                List<PredicateDefinition> predicateDefinitions = v.getPredicateDefinition();
//                if(predicateDefinitions != null){
//                    definition.setPredicates(predicateDefinitions);
//                }
//                List<FilterDefinition> filterDefinitions = v.getFilterDefinition();
//                if(filterDefinitions != null){
//                    definition.setFilters(filterDefinitions);
//                }
//                //RouteDefinitionWriter是个接口，真正实现的是InMemoryRouteDefinitionRepository类，
//                //在InMemoryRouteDefinitionRepository定义了一个SynchronizedMap<K, V> 类，所有的设置都在这儿保存。
//                routeDefinitionWriter.save(Mono.just(definition)).subscribe();
//                this.publisher.publishEvent(new RefreshRoutesEvent(this));
//            });
//            return "success";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "failure";
//        }
//    }
//
//    @Override
//    public boolean save(GatewayTable gatewayDefine) throws Exception {
////        GatewayTable gatewayTable = new GatewayTable();
////        gatewayTable.setId(gatewayDefine.getId());
////        gatewayTable.setCreate_time(new Date());
////        gatewayTable.setFilter(gatewayDefine.getFilter());
////        gatewayTable.setOrder(gatewayDefine.getOrder());
////        gatewayTable.setPredicate(gatewayDefine.getPredicate());
////        gatewayTable.setStatus(gatewayDefine.getStatus());
////        gatewayTable.setUri(gatewayDefine.getUri());
////        gatewayTable.setUpdate_time(gatewayDefine.getUpdate_time());
//        int count = gatewayTableDao.insert(gatewayDefine);
//        if(count == 1) {
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public boolean deleteById(String id) throws Exception {
//        int count = gatewayTableDao.deleteByPrimaryKey(id);
//        if(count == 1){
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public GatewayTable existsById(String id) throws Exception {
//        return gatewayTableDao.selectByPrimaryKey(id);
//    }
//}