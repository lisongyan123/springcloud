package com.bank.irce.ltgj.mapper;

import com.bank.irce.ltgj.entity.AuthorizationInfo;
import com.bank.irce.ltgj.entity.AuthorizationInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthorizationInfoDao {
    long countByExample(AuthorizationInfoExample example);

    int deleteByExample(AuthorizationInfoExample example);

    int insert(AuthorizationInfo record);

    int insertSelective(AuthorizationInfo record);

    List<AuthorizationInfo> selectByExample(AuthorizationInfoExample example);

    int updateByExampleSelective(@Param("record") AuthorizationInfo record, @Param("example") AuthorizationInfoExample example);

    int updateByExample(@Param("record") AuthorizationInfo record, @Param("example") AuthorizationInfoExample example);
}