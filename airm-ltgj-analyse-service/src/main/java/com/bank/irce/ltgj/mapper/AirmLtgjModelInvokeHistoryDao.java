package com.bank.irce.ltgj.mapper;

import com.bank.irce.ltgj.entity.AirmLtgjModelInvokeHistory;
import com.bank.irce.ltgj.entity.AirmLtgjModelInvokeHistoryExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AirmLtgjModelInvokeHistoryDao {
    long countByExample(AirmLtgjModelInvokeHistoryExample example);

    int deleteByExample(AirmLtgjModelInvokeHistoryExample example);

    int insert(AirmLtgjModelInvokeHistory record);

    int insertSelective(AirmLtgjModelInvokeHistory record);

    List<AirmLtgjModelInvokeHistory> selectByExampleWithBLOBs(AirmLtgjModelInvokeHistoryExample example);

    List<AirmLtgjModelInvokeHistory> selectByExample(AirmLtgjModelInvokeHistoryExample example);

    int updateByExampleSelective(@Param("record") AirmLtgjModelInvokeHistory record, @Param("example") AirmLtgjModelInvokeHistoryExample example);

    int updateByExampleWithBLOBs(@Param("record") AirmLtgjModelInvokeHistory record, @Param("example") AirmLtgjModelInvokeHistoryExample example);

    int updateByExample(@Param("record") AirmLtgjModelInvokeHistory record, @Param("example") AirmLtgjModelInvokeHistoryExample example);
}