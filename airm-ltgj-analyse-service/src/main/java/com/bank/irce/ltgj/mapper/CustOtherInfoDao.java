package com.bank.irce.ltgj.mapper;

import com.bank.irce.ltgj.entity.CustOtherInfo;
import com.bank.irce.ltgj.entity.CustOtherInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustOtherInfoDao {
    long countByExample(CustOtherInfoExample example);

    int deleteByExample(CustOtherInfoExample example);

    int insert(CustOtherInfo record);

    int insertSelective(CustOtherInfo record);

    List<CustOtherInfo> selectByExample(CustOtherInfoExample example);

    int updateByExampleSelective(@Param("record") CustOtherInfo record, @Param("example") CustOtherInfoExample example);

    int updateByExample(@Param("record") CustOtherInfo record, @Param("example") CustOtherInfoExample example);
}