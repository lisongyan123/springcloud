package com.bank.irce.ltgj.mapper;

import com.bank.irce.ltgj.entity.AirmLtgjMasterBody;
import com.bank.irce.ltgj.entity.AirmLtgjMasterBodyExample;
import com.bank.irce.ltgj.entity.AirmLtgjMasterBody;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AirmLtgjMasterBodyDao {
    long countByExample(AirmLtgjMasterBodyExample example);

    int deleteByExample(AirmLtgjMasterBodyExample example);

    int insert(AirmLtgjMasterBody record);

    int insertSelective(AirmLtgjMasterBody record);

    List<AirmLtgjMasterBody> selectByExampleWithBLOBs(AirmLtgjMasterBodyExample example);

    List<AirmLtgjMasterBody> selectByExample(AirmLtgjMasterBodyExample example);

    int updateByExampleSelective(@Param("record") AirmLtgjMasterBody record, @Param("example") AirmLtgjMasterBodyExample example);

    int updateByExampleWithBLOBs(@Param("record") AirmLtgjMasterBody record, @Param("example") AirmLtgjMasterBodyExample example);

    int updateByExample(@Param("record") AirmLtgjMasterBody record, @Param("example") AirmLtgjMasterBodyExample example);
}