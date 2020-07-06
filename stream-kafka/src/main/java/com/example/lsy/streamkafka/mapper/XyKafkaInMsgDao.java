package com.example.lsy.streamkafka.mapper;

import com.example.lsy.streamkafka.bean.XyKafkaInMsg;
import com.example.lsy.streamkafka.bean.XyKafkaInMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XyKafkaInMsgDao {
    long countByExample(XyKafkaInMsgExample example);

    int deleteByExample(XyKafkaInMsgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(XyKafkaInMsg record);

    int insertSelective(XyKafkaInMsg record);

    List<XyKafkaInMsg> selectByExample(XyKafkaInMsgExample example);

    XyKafkaInMsg selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") XyKafkaInMsg record, @Param("example") XyKafkaInMsgExample example);

    int updateByExample(@Param("record") XyKafkaInMsg record, @Param("example") XyKafkaInMsgExample example);

    int updateByPrimaryKeySelective(XyKafkaInMsg record);

    int updateByPrimaryKey(XyKafkaInMsg record);

    XyKafkaInMsg selectByFuBh(Long fwBh);
}