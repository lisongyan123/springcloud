package com.bank.irce.ltgj.mapper;

import com.bank.irce.ltgj.entity.AirmLtgjRequestBody;
import com.bank.irce.ltgj.entity.AirmLtgjRequestBodyExample;
import com.bank.irce.ltgj.entity.AirmLtgjRequestBodyWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AirmLtgjRequestBodyDao {
    long countByExample(AirmLtgjRequestBodyExample example);

    int deleteByExample(AirmLtgjRequestBodyExample example);

    int insert(AirmLtgjRequestBodyWithBLOBs record);

    int insertSelective(AirmLtgjRequestBodyWithBLOBs record);

    List<AirmLtgjRequestBodyWithBLOBs> selectByExampleWithBLOBs(AirmLtgjRequestBodyExample example);

    List<AirmLtgjRequestBody> selectByExample(AirmLtgjRequestBodyExample example);

    int updateByExampleSelective(@Param("record") AirmLtgjRequestBodyWithBLOBs record, @Param("example") AirmLtgjRequestBodyExample example);

    int updateByExampleWithBLOBs(@Param("record") AirmLtgjRequestBodyWithBLOBs record, @Param("example") AirmLtgjRequestBodyExample example);

    int updateByExample(@Param("record") AirmLtgjRequestBody record, @Param("example") AirmLtgjRequestBodyExample example);
}