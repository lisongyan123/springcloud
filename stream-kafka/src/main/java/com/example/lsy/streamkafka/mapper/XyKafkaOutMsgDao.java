package com.example.lsy.streamkafka.mapper;

import com.example.lsy.streamkafka.bean.XyKafkaOutMsg;
import com.example.lsy.streamkafka.bean.XyKafkaOutMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XyKafkaOutMsgDao {
    long countByExample(XyKafkaOutMsgExample example);

    int deleteByExample(XyKafkaOutMsgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(XyKafkaOutMsg record);

    int insertSelective(XyKafkaOutMsg record);

    List<XyKafkaOutMsg> selectByExample(XyKafkaOutMsgExample example);

    XyKafkaOutMsg selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") XyKafkaOutMsg record, @Param("example") XyKafkaOutMsgExample example);

    int updateByExample(@Param("record") XyKafkaOutMsg record, @Param("example") XyKafkaOutMsgExample example);

    int updateByPrimaryKeySelective(XyKafkaOutMsg record);

    int updateByPrimaryKey(XyKafkaOutMsg record);

    int updateByFwBh(@Param("outMsg") XyKafkaOutMsg outMsg);
}