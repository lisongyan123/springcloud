package com.example.cloudservice.service;

import com.example.cloudservice.domain.AuthResource;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ResourceService {

    /**
     * description TODO
     *
     * @param appId 1
     * @return java.util.List<com.usthe.bootshiro.domain.bo.AuthResource>
     */
    List<AuthResource> getAuthorityMenusByUid(String appId) throws Exception;

    /**
     * description TODO
     *
     * @return java.util.List<com.usthe.bootshiro.domain.bo.AuthResource>
     */
    List<AuthResource> getMenus();

    /**
     * description TODO
     *
     * @param menu 1
     * @return java.lang.Boolean
     */
    Boolean addMenu(AuthResource menu);

    /**
     * description TODO
     *
     * @param menu 1
     * @return java.lang.Boolean
     */
    Boolean modifyMenu(AuthResource menu);

    /**
     * description TODO
     *
     * @param menuId 1
     * @return java.lang.Boolean
     */
    Boolean deleteMenuByMenuId(Integer menuId);


    /**
     * description TODO
     *
     * @return java.util.List<com.usthe.bootshiro.domain.bo.AuthResource>
     */
    List<AuthResource> getApiTeamList(Short type);


    /**
     * description TODO
     *
     * @param teamId 1
     * @return java.util.List<com.usthe.bootshiro.domain.bo.AuthResource>
     */
    List<AuthResource> getApiListByTeamId(Integer teamId);

    /**
     * description TODO
     *
     * @param roleId 1
     * @return java.util.List<com.usthe.bootshiro.domain.bo.AuthResource>
     */
    List<AuthResource> getAuthorityApisByRoleId(Integer roleId,Short type) throws DataAccessException;


    List<AuthResource> getNotAuthorityByRoleId(Short type, Integer roleId) throws DataAccessException;
}
