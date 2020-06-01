package com.example.cloudservice.dao;

import com.example.cloudservice.domain.AuthOperationLog;
import com.example.cloudservice.domain.AuthOperationLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthOperationLogDao {
    long countByExample(AuthOperationLogExample example);

    int deleteByExample(AuthOperationLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AuthOperationLog record);

    int insertSelective(AuthOperationLog record);

    List<AuthOperationLog> selectByExample(AuthOperationLogExample example);

    AuthOperationLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AuthOperationLog record, @Param("example") AuthOperationLogExample example);

    int updateByExample(@Param("record") AuthOperationLog record, @Param("example") AuthOperationLogExample example);

    int updateByPrimaryKeySelective(AuthOperationLog record);

    int updateByPrimaryKey(AuthOperationLog record);
}