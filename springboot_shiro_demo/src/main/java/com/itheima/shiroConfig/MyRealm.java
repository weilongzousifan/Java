package com.itheima.shiroConfig;

import com.itheima.pojo.Administrator;
import com.itheima.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * 和数据库交互 看看用户信息 权限信息
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;

    //获取权限信息的方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("走了权限查询方法");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //获取用户名
        Administrator administrator = (Administrator)principals.getPrimaryPrincipal();//此Principal就是彼Principal（认证时构造的）
        String username = administrator.getUsername();
        //从数据库查询用户的权限和角色
        Set<String> roles = adminService.findRolesByUsername(username);
        if(roles != null && roles.size() > 0){
            simpleAuthorizationInfo.addRoles(roles);
        }
        Set<String> permissions = adminService.findPermissionsByUsername(username);
        if(permissions != null && permissions.size() > 0){
            simpleAuthorizationInfo.addStringPermissions(permissions);
        }
        return simpleAuthorizationInfo;
    }

    //获取认证信息的方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //token是封装好的  用户提交的用户名和密码  这里获取的才是用户输入的username
        String username = ((UsernamePasswordToken) token).getUsername();
        //获取用户
        Administrator administrator = adminService.findUserByUsername(username);
        if(administrator == null){
            return null;
        }else{
            //封装AuthenticationInfo
            ByteSource bsSalt = new SimpleByteSource(administrator.getPrivateSalt());
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(administrator,administrator.getPassword(),bsSalt,getName());
            return authenticationInfo;
        }
    }
}
