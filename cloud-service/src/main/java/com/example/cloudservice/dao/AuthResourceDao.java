package com.example.cloudservice.dao;

import com.example.cloudservice.config.shiro.rule.RolePermRule;
import com.example.cloudservice.domain.AuthResource;
import com.example.cloudservice.domain.AuthResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

public interface AuthResourceDao {
    long countByExample(AuthResourceExample example);

    int deleteByExample(AuthResourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AuthResource record);

    int insertSelective(AuthResource record);

    List<AuthResource> selectByExample(AuthResourceExample example);

    AuthResource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AuthResource record, @Param("example") AuthResourceExample example);

    int updateByExample(@Param("record") AuthResource record, @Param("example") AuthResourceExample example);

    int updateByPrimaryKeySelective(AuthResource record);

    int updateByPrimaryKey(AuthResource record);

    List<RolePermRule> selectRoleRules()  throws DataAccessException;
}