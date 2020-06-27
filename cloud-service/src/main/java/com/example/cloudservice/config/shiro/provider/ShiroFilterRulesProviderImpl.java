package com.example.cloudservice.config.shiro.provider;

import com.example.cloudservice.config.shiro.rule.RolePermRule;
import com.example.cloudservice.dao.AuthResourceDao;
import com.example.cloudservice.dao.AuthRoleDao;
import com.example.cloudservice.dao.AuthRoleResourceDao;
import com.example.cloudservice.service.impl.ResourceServiceImpl;
import com.example.cloudservice.service.impl.RoleServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ShiroFilterRulesProviderImpl implements ShiroFilterRulesProvider {

    @Resource
    private AuthResourceDao authResourceMapper;

    @Override
    public List<RolePermRule> loadRolePermRules() {
        return authResourceMapper.selectRoleRules();
    }

}