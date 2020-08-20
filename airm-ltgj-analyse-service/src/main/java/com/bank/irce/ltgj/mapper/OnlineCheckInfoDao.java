package com.bank.irce.ltgj.mapper;

import com.bank.irce.ltgj.entity.OnlineCheckInfo;
import com.bank.irce.ltgj.entity.OnlineCheckInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OnlineCheckInfoDao {
    long countByExample(OnlineCheckInfoExample example);

    int deleteByExample(OnlineCheckInfoExample example);

    int insert(OnlineCheckInfo record);

    int insertSelective(OnlineCheckInfo record);

    List<OnlineCheckInfo> selectByExample(OnlineCheckInfoExample example);

    int updateByExampleSelective(@Param("record") OnlineCheckInfo record, @Param("example") OnlineCheckInfoExample example);

    int updateByExample(@Param("record") OnlineCheckInfo record, @Param("example") OnlineCheckInfoExample example);
}