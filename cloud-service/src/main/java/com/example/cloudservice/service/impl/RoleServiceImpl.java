package com.example.cloudservice.service.impl;

import com.example.cloudservice.dao.AuthRoleDao;
import com.example.cloudservice.dao.AuthRoleResourceDao;
import com.example.cloudservice.domain.*;
import com.example.cloudservice.service.RoleService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private AuthRoleResourceDao authRoleResourceMapper;

    @Resource
    private AuthRoleDao authRoleMapper;

    @Override
    public boolean authorityRoleResource(int roleId, int resourceId) throws DataAccessException {
        AuthRoleResource authRoleResource = new AuthRoleResource();
        authRoleResource.setRoleId(roleId);
        authRoleResource.setResourceId(resourceId);
        authRoleResource.setCreateTime(new Date());
        authRoleResource.setUpdateTime(new Date());
        return authRoleResourceMapper.insert(authRoleResource) == 1? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public boolean addRole(AuthRole role) throws DataAccessException {
        int num = authRoleMapper.insertSelective(role);
        return num == 1? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public boolean updateRole(AuthRole role) throws DataAccessException {
        int num = authRoleMapper.updateByPrimaryKeySelective(role);
        return num == 1? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public boolean deleteRoleByRoleId(Integer roleId) throws DataAccessException {
        int num = authRoleMapper.deleteByPrimaryKey(roleId);
        return num == 1? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public boolean deleteAuthorityRoleResource(Integer roleId, Integer resourceId) throws DataAccessException {
        AuthRoleResourceExample authRoleResourceExample = new AuthRoleResourceExample();
        authRoleResourceExample.createCriteria().andRoleIdEqualTo(roleId).andResourceIdEqualTo(resourceId);
        int num = authRoleResourceMapper.deleteByExample(authRoleResourceExample);
        return num == 1? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public List<AuthRole> getRoleList() throws DataAccessException {
        return authRoleMapper.selectByExample(new AuthRoleExample());
    }

    public List<AuthRoleResource> listAuthUserRole() {
        return authRoleResourceMapper.selectByExample(new AuthRoleResourceExample());
    }
}
