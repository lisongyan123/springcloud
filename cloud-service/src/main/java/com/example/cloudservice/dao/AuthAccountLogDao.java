package com.example.cloudservice.dao;

import com.example.cloudservice.domain.AuthAccountLog;
import com.example.cloudservice.domain.AuthAccountLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthAccountLogDao {
    long countByExample(AuthAccountLogExample example);

    int deleteByExample(AuthAccountLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AuthAccountLog record);

    int insertSelective(AuthAccountLog record);

    List<AuthAccountLog> selectByExample(AuthAccountLogExample example);

    AuthAccountLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AuthAccountLog record, @Param("example") AuthAccountLogExample example);

    int updateByExample(@Param("record") AuthAccountLog record, @Param("example") AuthAccountLogExample example);

    int updateByPrimaryKeySelective(AuthAccountLog record);

    int updateByPrimaryKey(AuthAccountLog record);
}