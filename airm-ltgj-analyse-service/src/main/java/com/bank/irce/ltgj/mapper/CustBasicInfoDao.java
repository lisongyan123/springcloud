package com.bank.irce.ltgj.mapper;

import com.bank.irce.ltgj.entity.CustBasicInfo;
import com.bank.irce.ltgj.entity.CustBasicInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustBasicInfoDao {
    long countByExample(CustBasicInfoExample example);

    int deleteByExample(CustBasicInfoExample example);

    int insert(CustBasicInfo record);

    int insertSelective(CustBasicInfo record);

    List<CustBasicInfo> selectByExample(CustBasicInfoExample example);

    int updateByExampleSelective(@Param("record") CustBasicInfo record, @Param("example") CustBasicInfoExample example);

    int updateByExample(@Param("record") CustBasicInfo record, @Param("example") CustBasicInfoExample example);
}