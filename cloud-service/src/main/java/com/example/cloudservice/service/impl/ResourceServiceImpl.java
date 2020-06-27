package com.example.cloudservice.service.impl;

import com.example.cloudservice.dao.AuthResourceDao;
import com.example.cloudservice.dao.AuthRoleResourceDao;
import com.example.cloudservice.domain.*;
import com.example.cloudservice.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tomsun28
 * @date 10:59 2018/3/26
 */
@Service("ResourceService")
public class ResourceServiceImpl implements ResourceService {

    private static final short TYPE1 = 1;
    private static final short TYPE2 = 2;
    private static final short TYPE3 = 3;

    @Resource
    private AuthResourceDao authResourceMapper;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private RoleServiceImpl roleServiceImpl;

    @Resource
    private AuthRoleResourceDao authRoleResourceMapper;

    @Override
    public List<AuthResource> getAuthorityMenusByUid(String appId) throws Exception {
        AuthUser authUser = userServiceImpl.getUserList().stream().filter(v -> v.getUid().equals(appId)).findFirst().orElse(null);
        if (authUser == null) throw new Exception("AuthUser中不存在此appId");
        AuthUserRole authUserRole = userServiceImpl.listAuthUserRole().stream().filter(v -> v.getUserId().equals(authUser.getUid())).findAny().orElse(null);
        if (authUserRole == null) throw new Exception("AuthUserRole 中不存在和 AuthUser映射的字段");
        AuthRoleResource authRoleResource = roleServiceImpl.listAuthUserRole().stream().filter(v->v.getRoleId().equals(authUserRole.getRoleId())).findAny().orElse(null);
        if(authRoleResource == null) throw new Exception("AuthRoleResource 和 AuthUserRole关联的RoleId不存在");
        return listAuthResource().stream().filter(v->v.getId().equals(authRoleResource.getResourceId())).collect(Collectors.toList());
    }

    @Override
    public List<AuthResource> getMenus() throws DataAccessException {
        AuthResourceExample authResourceExample = new AuthResourceExample();
        authResourceExample.createCriteria().andTypeEqualTo(TYPE1);
        return authResourceMapper.selectByExample(authResourceExample);
    }

    @Override
    public Boolean addMenu(AuthResource menu) throws DataAccessException {
        int num = authResourceMapper.insertSelective(menu);
        return num == 1 ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public Boolean modifyMenu(AuthResource menu) throws DataAccessException {
        int num = authResourceMapper.updateByPrimaryKeySelective(menu);
        return num == 1 ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public Boolean deleteMenuByMenuId(Integer menuId) throws DataAccessException {
        int num = authResourceMapper.deleteByPrimaryKey(menuId);
        return num == 1 ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public List<AuthResource> getApiTeamList(Short type) throws DataAccessException {
        AuthResourceExample authResourceExample = new AuthResourceExample();
        if(type == null) return authResourceMapper.selectByExample(authResourceExample);
        authResourceExample.createCriteria().andTypeEqualTo(type);
        return authResourceMapper.selectByExample(authResourceExample);
    }

    @Override
    public List<AuthResource> getApiListByTeamId(Integer teamId) throws DataAccessException {
        AuthResourceExample authResourceExample = new AuthResourceExample();
        authResourceExample.createCriteria().andTypeBetween(TYPE2,TYPE3).andParentIdEqualTo(teamId);
        return authResourceMapper.selectByExample(authResourceExample);
    }

    @Override
    public List<AuthResource> getAuthorityApisByRoleId(Integer roleId,Short type) throws DataAccessException {
        final List<AuthResource>[] authResources = new List[]{new ArrayList<>()};
        getAuthRoleResourceByRoleId(roleId).stream().map(v->{
            authResources[0] = getApiTeamList(type).stream().filter(t->t.getId().equals(v.getResourceId())).collect(Collectors.toList());
            return authResources[0];
        });
        return authResources[0];
    }

    @Override
    public List<AuthResource> getNotAuthorityByRoleId(Short type,Integer roleId) throws DataAccessException {
        List<Integer> resources = getAuthRoleResourceByRoleId(roleId).stream().map(v->v.getResourceId()).collect(Collectors.toList());
        return getApiTeamList(type).stream().filter(v->!resources.contains(v.getId())).collect(Collectors.toList());
    }

    public List<AuthResource> listAuthResource(){
        return authResourceMapper.selectByExample(new AuthResourceExample());
    }

    public List<AuthRoleResource> getAuthRoleResourceByRoleId(Integer roleId){
        AuthRoleResourceExample authRoleResourceExample = new AuthRoleResourceExample();
        authRoleResourceExample.createCriteria().andRoleIdEqualTo(roleId);
        return authRoleResourceMapper.selectByExample(authRoleResourceExample);
    }
}
