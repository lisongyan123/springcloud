package com.bank.irce.ltgj.mapper;

import com.bank.irce.ltgj.entity.AirmLtgjModelLtzfInfo;
import com.bank.irce.ltgj.entity.AirmLtgjModelLtzfInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AirmLtgjModelLtzfInfoDao {
    long countByExample(AirmLtgjModelLtzfInfoExample example);

    int deleteByExample(AirmLtgjModelLtzfInfoExample example);

    int insert(AirmLtgjModelLtzfInfo record);

    int insertSelective(AirmLtgjModelLtzfInfo record);

    List<AirmLtgjModelLtzfInfo> selectByExampleWithBLOBs(AirmLtgjModelLtzfInfoExample example);

    List<AirmLtgjModelLtzfInfo> selectByExample(AirmLtgjModelLtzfInfoExample example);

    int updateByExampleSelective(@Param("record") AirmLtgjModelLtzfInfo record, @Param("example") AirmLtgjModelLtzfInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") AirmLtgjModelLtzfInfo record, @Param("example") AirmLtgjModelLtzfInfoExample example);

    int updateByExample(@Param("record") AirmLtgjModelLtzfInfo record, @Param("example") AirmLtgjModelLtzfInfoExample example);
}