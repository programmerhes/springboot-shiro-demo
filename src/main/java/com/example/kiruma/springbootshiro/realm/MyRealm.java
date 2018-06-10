package com.example.kiruma.springbootshiro.realm;

import com.example.kiruma.springbootshiro.bean.User;
import com.example.kiruma.springbootshiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("myRealm")
public class MyRealm extends AuthorizingRealm {


    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username =(String)principalCollection.getPrimaryPrincipal();
        List<String> permissions=userService.getUserPermissionByUserName(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username=(String)authenticationToken.getPrincipal();
       // System.out.println("this is do get"+userService.get());
        User user = userService.selectUserByUsername(username);

        //System.out.println("this is index"+user.getUsername()+" asd "+user.getPassword());
        String password=user.getPassword();
        //String password="123";
        SimpleAuthenticationInfo simpleAuthenticationInfo=
                                    new SimpleAuthenticationInfo(username,password,"myRealm");

        return simpleAuthenticationInfo;
    }



}
