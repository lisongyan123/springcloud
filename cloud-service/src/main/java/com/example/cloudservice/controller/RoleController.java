package com.example.cloudservice.controller;

import com.example.cloudservice.config.shiro.filter.ShiroFilterChainManager;
import com.example.cloudservice.domain.AuthResource;
import com.example.cloudservice.domain.AuthRole;
import com.example.cloudservice.domain.AuthUser;
import com.example.cloudservice.domain.vo.Message;
import com.example.cloudservice.service.ResourceService;
import com.example.cloudservice.service.RoleService;
import com.example.cloudservice.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RequestMapping("/role")
@RestController
public class RoleController extends BaseAction {

    private static final short TYPE1 = 1;
    private static final short TYPE2 = 2;
    private static final short TYPE3 = 3;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private ShiroFilterChainManager shiroFilterChainManager;

    @SuppressWarnings("unchecked")
//    @ApiOperation(value = "获取角色关联的(roleId)对应用户列表",httpMethod = "GET")
    @GetMapping("user/{roleId}/{currentPage}/{pageSize}")
    public Message getUserListByRoleId(@PathVariable Integer roleId, @PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<AuthUser> users = userService.getUserListByRoleId(roleId);
        users.forEach(user->user.setPassword(null));
        PageInfo pageInfo = new PageInfo(users);
        return new Message().ok(6666,"return users success").addData("data",pageInfo);
    }

    @SuppressWarnings("unchecked")
//    @ApiOperation(value = "获取角色未关联的用户列表", httpMethod = "GET")
    @GetMapping("user/-/{roleId}/{currentPage}/{pageSize}")
    public Message getUserListExtendByRoleId(@PathVariable Integer roleId, @PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<AuthUser> users = userService.getNotAuthorityUserListByRoleId(roleId);
        users.forEach(user -> user.setPassword(null));
        PageInfo pageInfo = new PageInfo(users);
        return new Message().ok(6666, "return users success").addData("data", pageInfo);
    }


    @SuppressWarnings("unchecked")
//    @ApiOperation(value = "获取角色(roleId)所被授权的API资源")
    @GetMapping("api/{roleId}/{currentPage}/{pageSize}")
    public Message getRestApiExtendByRoleId(@PathVariable Integer roleId, @PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<AuthResource> authResources = resourceService.getAuthorityApisByRoleId(roleId,TYPE2);
        PageInfo pageInfo = new PageInfo(authResources);
        return new Message().ok(6666, "return api success").addData("data", pageInfo);
    }

    @SuppressWarnings("unchecked")
//    @ApiOperation(value = "获取角色(roleId)未被授权的API资源")
    @GetMapping("api/-/{roleId}/{currentPage}/{pageSize}")
    public Message getRestApiByRoleId(@PathVariable Integer roleId, @PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<AuthResource> authResources = resourceService.getAuthorityApisByRoleId(roleId,TYPE2);
        PageInfo pageInfo = new PageInfo(authResources);
        return new Message().ok(6666, "return api success").addData("data", pageInfo);
    }

    @SuppressWarnings("unchecked")
//    @ApiOperation(value = "获取角色(roleId)所被授权的menu资源")
    @GetMapping("menu/{roleId}/{currentPage}/{pageSize}")
    public Message getMenusByRoleId(@PathVariable Integer roleId, @PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<AuthResource> authResources = resourceService.getAuthorityApisByRoleId(roleId,TYPE1);
        PageInfo pageInfo = new PageInfo(authResources);
        return new Message().ok(6666, "return api success").addData("data", pageInfo);
    }

    @SuppressWarnings("unchecked")
//    @ApiOperation(value = "获取角色(roleId)未被授权的menu资源")
    @GetMapping("menu/-/{roleId}/{currentPage}/{pageSize}")
    public Message getMenusExtendByRoleId(@PathVariable Integer roleId, @PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<AuthResource> authResources = resourceService.getNotAuthorityByRoleId(TYPE1,roleId);
        PageInfo pageInfo = new PageInfo(authResources);
        return new Message().ok(6666, "return api success").addData("data", pageInfo);
    }

//    @ApiOperation(value = "授权资源给角色",httpMethod = "POST")
    @PostMapping("/authority/resource")
    public Message authorityRoleResource(HttpServletRequest request) {
        Map<String,String> map = getRequestBody(request);
        int roleId = Integer.parseInt(map.get("roleId"));
        int resourceId = Integer.parseInt(map.get("resourceId"));
        boolean flag = roleService.authorityRoleResource(roleId,resourceId);
        shiroFilterChainManager.reloadFilterChain();
        return flag ? new Message().ok(6666,"authority success") : new Message().error(1111,"authority error");
    }

//    @ApiOperation(value = "删除对应的角色的授权资源",httpMethod = "DELETE")
    @DeleteMapping("/authority/resource/{roleId}/{resourceId}")
    public Message deleteAuthorityRoleResource(@PathVariable Integer roleId, @PathVariable Integer resourceId ) {
        boolean flag = roleService.deleteAuthorityRoleResource(roleId,resourceId);
        shiroFilterChainManager.reloadFilterChain();
        return flag ? new Message().ok(6666,"authority success") : new Message().error(1111,"authority error");
    }


//    @ApiOperation(value = "获取角色LIST", httpMethod = "GET")
    @GetMapping("{currentPage}/{pageSize}")
    public Message getRoles(@PathVariable Integer currentPage, @PathVariable Integer pageSize) {

        PageHelper.startPage(currentPage, pageSize);
        List<AuthRole> roles = roleService.getRoleList();
        PageInfo pageInfo = new PageInfo(roles);
        return new Message().ok(6666, "return roles success").addData("data", pageInfo);
    }

//    @ApiOperation(value = "添加角色", httpMethod = "POST")
    @PostMapping("")
    public Message addRole(@RequestBody AuthRole role) {

        boolean flag = roleService.addRole(role);
        if (flag) {
            return new Message().ok(6666, "add role success");
        } else {
            return new Message().error(111, "add role fail");
        }
    }

//    @ApiOperation(value = "更新角色", httpMethod = "PUT")
    @PutMapping("")
    public Message updateRole(@RequestBody AuthRole role) {

        boolean flag = roleService.updateRole(role);
        if (flag) {
            return new Message().ok(6666, "update success");
        } else {
            return new Message().error(1111, "update fail");
        }
    }

//    @ApiOperation(value = "根据角色ID删除角色", httpMethod = "DELETE")
    @DeleteMapping("{roleId}")
    public Message deleteRoleByRoleId(@PathVariable Integer roleId) {

        boolean flag = roleService.deleteRoleByRoleId(roleId);
        if (flag) {
            return new Message().ok(6666, "delete success");
        } else {
            return new Message().error(1111, "delete fail");
        }
    }


}
