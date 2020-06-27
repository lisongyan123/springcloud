package com.example.cloudservice.service.impl;

import com.example.cloudservice.common.helper.CollectionHelper;
import com.example.cloudservice.dao.AuthUserDao;
import com.example.cloudservice.dao.AuthUserRoleDao;
import com.example.cloudservice.domain.*;
import com.example.cloudservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Resource
    private AuthUserDao userMapper;

    @Resource
    private AuthUserRoleDao authUserRoleMapper;

    @Override
    public String loadAccountRole(String appId) throws DataAccessException {
        return userMapper.selectUserRoles(appId);
    }

    @Override
    public List<AuthUser> getUserList() throws DataAccessException {
        return userMapper.selectByExample(new AuthUserExample());
    }

    @Override
    public List<AuthUser> getUserListByRoleId(Integer roleId) throws DataAccessException {
        List<String> userIds = listAuthUserRole().stream()
                .filter(t->t.getRoleId().equals(roleId))
                .map(v->v.getUserId()).collect(Collectors.toList());
        return getUserList().stream().filter(v->userIds.contains(v.getUid())).collect(Collectors.toList());
    }

    @Override
    public boolean authorityUserRole(String uid, int roleId) throws DataAccessException {
        AuthUserRole authUserRole = new AuthUserRole();
        authUserRole.setRoleId(roleId);
        authUserRole.setUserId(uid);
        authUserRole.setCreateTime(new Date());
        authUserRole.setUpdateTime(new Date());
        return authUserRoleMapper.insert(authUserRole) == 1? Boolean.TRUE :Boolean.FALSE;
    }

    @Override
    public boolean deleteAuthorityUserRole(String uid, int roleId) throws DataAccessException {
        AuthUserRoleExample authUserRoleExample = new AuthUserRoleExample();
        authUserRoleExample.createCriteria().andRoleIdEqualTo(roleId).andUserIdEqualTo(uid);
        return authUserRoleMapper.deleteByExample(authUserRoleExample) == 1 ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public AuthUser getUserByAppId(String appId) throws Exception {
        AuthUserExample authUserExample = new AuthUserExample();
        authUserExample.createCriteria().andPhoneEqualTo(appId);
        List<AuthUser> authUsers = userMapper.selectByExample(authUserExample);
        if(authUsers.size() == 0 || authUsers == null) throw new Exception("不存在此appId");
        return userMapper.selectByExample(authUserExample).get(0);
    }

    @Override
    public List<AuthUser> getNotAuthorityUserListByRoleId(Integer roleId) throws DataAccessException {
        AuthUserRoleExample authUserRoleExample = new AuthUserRoleExample();
        authUserRoleExample.createCriteria().andRoleIdEqualTo(roleId);
        List<String> userIds = authUserRoleMapper.selectByExample(authUserRoleExample).stream().map(t->t.getUserId()).collect(Collectors.toList());
        return getUserList().stream().filter(v-> !userIds.contains(v.getUid())).collect(Collectors.toList());
    }

    public List<AuthUserRole> listAuthUserRole(){
        return authUserRoleMapper.selectByExample(new AuthUserRoleExample());
    }
}
