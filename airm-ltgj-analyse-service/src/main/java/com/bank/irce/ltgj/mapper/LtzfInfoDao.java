package com.bank.irce.ltgj.mapper;

import com.bank.irce.ltgj.entity.LtzfInfo;
import com.bank.irce.ltgj.entity.LtzfInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LtzfInfoDao {
    long countByExample(LtzfInfoExample example);

    int deleteByExample(LtzfInfoExample example);

    int insert(LtzfInfo record);

    int insertSelective(LtzfInfo record);

    List<LtzfInfo> selectByExampleWithBLOBs(LtzfInfoExample example);

    List<LtzfInfo> selectByExample(LtzfInfoExample example);

    int updateByExampleSelective(@Param("record") LtzfInfo record, @Param("example") LtzfInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") LtzfInfo record, @Param("example") LtzfInfoExample example);

    int updateByExample(@Param("record") LtzfInfo record, @Param("example") LtzfInfoExample example);
}