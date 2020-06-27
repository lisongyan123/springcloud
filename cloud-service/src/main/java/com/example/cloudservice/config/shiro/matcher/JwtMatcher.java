package com.example.cloudservice.config.shiro.matcher;

import com.example.cloudservice.domain.vo.JwtAccount;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.springframework.stereotype.Component;

import static com.example.cloudservice.common.helper.TokenHelper.parseJwt;

@Component
public class JwtMatcher implements CredentialsMatcher {

    public static final String SECRET_KEY = "?::4343fdf4fdf6cvf):";

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        String jwt = (String) authenticationInfo.getCredentials();
        JwtAccount jwtAccount = null;
        try{
            jwtAccount = parseJwt(jwt,SECRET_KEY);
        } catch(SignatureException | UnsupportedJwtException | MalformedJwtException | IllegalArgumentException e){
            // 令牌错误
            throw new AuthenticationException("errJwt");
        } catch(ExpiredJwtException e){
            // 令牌过期
            throw new AuthenticationException("expiredJwt");
        } catch(Exception e){
            throw new AuthenticationException("errJwt");
        }
        if(null == jwtAccount){
            throw new AuthenticationException("errJwt");
        }
        return true;
    }
}

