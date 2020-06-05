package com.example.cloudservice.service;

import com.example.cloudservice.domain.AuthUser;
import java.util.List;

public interface UserService {

    String loadAccountRole(String appId);

    List<AuthUser> getUserList();

    List<AuthUser> getUserListByRoleId(Integer roleId);

    boolean authorityUserRole(String appId, int roleId);

    boolean deleteAuthorityUserRole(String uid,int roleId);

    AuthUser getUserByAppId(String appId) throws Exception;

    List<AuthUser> getNotAuthorityUserListByRoleId(Integer roleId);
}
