package com.zthack.drip.shiro;

import com.zthack.drip.model.User;
import com.zthack.drip.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hucker on 2019/6/4.
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //给当前用户授权的权限（功能权限、角色）
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //xslde用户拥有user角色
        User user = (User) principalCollection.getPrimaryPrincipal();
        //真实开发中，角色权限从数据库获取
        if (user.getUsername().equals("xslde")){
            //设置该用户拥有user角色
            authorizationInfo.addRole("user");
            //设置该用户拥有delete权限
            authorizationInfo.addStringPermission("user:query");
        }
        //admin用户拥有admin角色
        if (user.getUsername().equals("admin")){
            //设置该用户拥有user角色
            authorizationInfo.addRole("admin");
            //设置该用户拥有delete权限
            authorizationInfo.addStringPermission("admin:delete");
        }


        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户名
        String username = (String) authenticationToken.getPrincipal();
        //根据用户名查询用户信息
        User user = userService.findByUsername(username);
        if (user != null) {
            if (user.getAvailable() == 1){
                return  new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
            } else {
                throw  new LockedAccountException("账户已被锁定");
            }
        } else {
            throw new UnknownAccountException("用户不存在！");
        }
    }

    //生成一个加盐密码
    public static void main(String[] args) {
        String hashAlgorithmName = "md5";//加密类型
        Integer iteration = 2;//迭代次数
        String password = "123456";
        String salt = "abcd";
        String s = new SimpleHash(hashAlgorithmName,password,salt,iteration).toHex();
        System.out.println(s);
        //加密后的密码
        //0caf568dbf30f5c33a13c56b869259fc

    }
}
