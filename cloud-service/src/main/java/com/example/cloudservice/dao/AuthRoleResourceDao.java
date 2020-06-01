package com.example.cloudservice.dao;

import com.example.cloudservice.domain.AuthRoleResource;
import com.example.cloudservice.domain.AuthRoleResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthRoleResourceDao {
    long countByExample(AuthRoleResourceExample example);

    int deleteByExample(AuthRoleResourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AuthRoleResource record);

    int insertSelective(AuthRoleResource record);

    List<AuthRoleResource> selectByExample(AuthRoleResourceExample example);

    AuthRoleResource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AuthRoleResource record, @Param("example") AuthRoleResourceExample example);

    int updateByExample(@Param("record") AuthRoleResource record, @Param("example") AuthRoleResourceExample example);

    int updateByPrimaryKeySelective(AuthRoleResource record);

    int updateByPrimaryKey(AuthRoleResource record);
}