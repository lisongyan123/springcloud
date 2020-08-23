package com.bank.irce.ltgj.mapper;

import com.bank.irce.ltgj.entity.AirmLtgjModelLtdsjInfo;
import com.bank.irce.ltgj.entity.AirmLtgjModelLtdsjInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AirmLtgjModelLtdsjInfoDao {
    long countByExample(AirmLtgjModelLtdsjInfoExample example);

    int deleteByExample(AirmLtgjModelLtdsjInfoExample example);

    int insert(AirmLtgjModelLtdsjInfo record);

    int insertSelective(AirmLtgjModelLtdsjInfo record);

    List<AirmLtgjModelLtdsjInfo> selectByExample(AirmLtgjModelLtdsjInfoExample example);

    int updateByExampleSelective(@Param("record") AirmLtgjModelLtdsjInfo record, @Param("example") AirmLtgjModelLtdsjInfoExample example);

    int updateByExample(@Param("record") AirmLtgjModelLtdsjInfo record, @Param("example") AirmLtgjModelLtdsjInfoExample example);
}