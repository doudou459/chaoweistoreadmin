package com.chaowei.chaoweistore.shiro;


import com.chaowei.chaoweistore.adminService.AdminService;
import com.chaowei.chaoweistore.adminService.PromissionService;
import com.chaowei.chaoweistore.adminService.RoleService;
import com.chaowei.chaoweistore.entity.Admin;
import com.chaowei.chaoweistore.entity.Promission;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Myrealm extends AuthorizingRealm {
     @Autowired
     AdminService adminService;
     @Autowired
     RoleService roleService;
     @Autowired
     PromissionService promissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        if (principalCollection == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }
        Admin admin = (Admin) getAvailablePrincipal(principalCollection);
        String[] roleids = admin.getRoles().split(",");
        Set<String> roles = new LinkedHashSet<>();
        Set<String> permissions = new LinkedHashSet<>();
        for(int i=0;i<roleids.length;i++){
            roles.add(roleService.getRoleById(roleids[i]).getRoleName());
            List<Promission> promissionList = promissionService.getPromissionByRoleId(roleids[i]);
            promissionList.forEach(item ->{
                permissions.add(item.getPromission());
            });
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(permissions);
        SecurityUtils.getSubject().getSession().setAttribute("permissions", permissions);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String loginID = upToken.getUsername();
        String password = new String(upToken.getPassword());
        if (StringUtils.isEmpty(loginID)) {
            throw new UnknownAccountException("登录账号不能为空");
        }
        if (StringUtils.isEmpty(password)) {
            throw new UnknownAccountException("密码不能为空");
        }
        Admin admin = adminService.getAdminByloginID(loginID);
        if(admin==null){
            throw new UnknownAccountException("账号错误");
        }
        if(admin.getWrongTime()>=5&&admin.getLastLongTime()-System.currentTimeMillis()<86400l){
            throw new LockedAccountException("禁止登陆！密码连续错误5次");
        }else {
            if (admin.getLoginKey().equals(password)) {
              adminService.doLogin(loginID);
                return new SimpleAuthenticationInfo(admin, password, getName());
            } else {
                 int wrongTime=admin.getWrongTime()+1;
                 adminService.updateWrongTime(loginID,admin.getWrongTime()+1);
                throw new IncorrectCredentialsException("密码错误"+wrongTime+"次");
            }
        }
    }
}
