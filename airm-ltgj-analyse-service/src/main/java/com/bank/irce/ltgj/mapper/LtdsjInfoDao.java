package com.bank.irce.ltgj.mapper;

import com.bank.irce.ltgj.entity.LtdsjInfo;
import com.bank.irce.ltgj.entity.LtdsjInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LtdsjInfoDao {
    long countByExample(LtdsjInfoExample example);

    int deleteByExample(LtdsjInfoExample example);

    int insert(LtdsjInfo record);

    int insertSelective(LtdsjInfo record);

    List<LtdsjInfo> selectByExample(LtdsjInfoExample example);

    int updateByExampleSelective(@Param("record") LtdsjInfo record, @Param("example") LtdsjInfoExample example);

    int updateByExample(@Param("record") LtdsjInfo record, @Param("example") LtdsjInfoExample example);
}