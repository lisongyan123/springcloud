package com.example.cloudservice.config.shiro.realm;

import com.example.cloudservice.config.shiro.provider.AccountProvider;
import com.example.cloudservice.config.shiro.token.PasswordToken;

import com.example.cloudservice.domain.vo.Account;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import static com.example.cloudservice.common.helper.CryptoHelper.md5;

/**
 *   这里是登录认证realm
 */
public class PasswordRealm extends AuthorizingRealm {


    private AccountProvider accountProvider;

    /**
     * description 此Realm只支持PasswordToken
     */
    @Override
    public Class<?> getAuthenticationTokenClass() {
        return PasswordToken.class;
    }

    /**
     * description 这里只需要认证登录，成功之后派发 json web token 授权在那里进行
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (!(authenticationToken instanceof PasswordToken)) {
            return null;
        }
        if(null==authenticationToken.getPrincipal()||null==authenticationToken.getCredentials()){
            throw new UnknownAccountException();
        }
        String appId = (String)authenticationToken.getPrincipal();
        Account account = accountProvider.loadAccount(appId);
        if (account != null) {
            // 用盐对密码进行MD5加密
            ((PasswordToken) authenticationToken).setPassword(md5(((PasswordToken) authenticationToken).getPassword()+account.getSalt()));
            return new SimpleAuthenticationInfo(appId,account.getPassword(),getName());
        } else {
            return new SimpleAuthenticationInfo(appId,"",getName());
        }
    }

    public void setAccountProvider(AccountProvider accountProvider) {
        this.accountProvider = accountProvider;
    }
}