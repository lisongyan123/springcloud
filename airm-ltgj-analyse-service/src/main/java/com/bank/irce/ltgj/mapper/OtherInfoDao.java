package com.bank.irce.ltgj.mapper;

import com.bank.irce.ltgj.entity.OtherInfo;
import com.bank.irce.ltgj.entity.OtherInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OtherInfoDao {
    long countByExample(OtherInfoExample example);

    int deleteByExample(OtherInfoExample example);

    int insert(OtherInfo record);

    int insertSelective(OtherInfo record);

    List<OtherInfo> selectByExample(OtherInfoExample example);

    int updateByExampleSelective(@Param("record") OtherInfo record, @Param("example") OtherInfoExample example);

    int updateByExample(@Param("record") OtherInfo record, @Param("example") OtherInfoExample example);
}