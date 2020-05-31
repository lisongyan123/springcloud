//package com.springcloud.lsy.dao;
//
//import com.springcloud.lsy.bean.GatewayTable;
//import com.springcloud.lsy.bean.GatewayTableExample;
//import java.util.List;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.stereotype.Repository;
//
//public interface GatewayTableDao {
//    long countByExample(GatewayTableExample example);
//
//    int deleteByExample(GatewayTableExample example);
//
//    int deleteByPrimaryKey(String id);
//
//    int insert(GatewayTable record);
//
//    int insertSelective(GatewayTable record);
//
//    List<GatewayTable> selectByExample(GatewayTableExample example);
//
//    GatewayTable selectByPrimaryKey(String id);
//
//    int updateByExampleSelective(@Param("record") GatewayTable record, @Param("example") GatewayTableExample example);
//
//    int updateByExample(@Param("record") GatewayTable record, @Param("example") GatewayTableExample example);
//
//    int updateByPrimaryKeySelective(GatewayTable record);
//
//    int updateByPrimaryKey(GatewayTable record);
//}