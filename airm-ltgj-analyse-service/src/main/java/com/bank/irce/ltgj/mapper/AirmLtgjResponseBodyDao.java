package com.bank.irce.ltgj.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AirmLtgjResponseBodyDao {
    long countByExample(AirmLtgjResponseBodyExample example);

    int deleteByExample(AirmLtgjResponseBodyExample example);

    int insert(AirmLtgjResponseBody record);

    int insertSelective(AirmLtgjResponseBody record);

    List<AirmLtgjResponseBody> selectByExample(AirmLtgjResponseBodyExample example);

    int updateByExampleSelective(@Param("record") AirmLtgjResponseBody record, @Param("example") AirmLtgjResponseBodyExample example);

    int updateByExample(@Param("record") AirmLtgjResponseBody record, @Param("example") AirmLtgjResponseBodyExample example);
}