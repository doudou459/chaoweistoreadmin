package com.chaowei.chaoweistore.adminController;

import com.chaowei.chaoweistore.adminService.RoleService;
import com.chaowei.chaoweistore.entity.Role;
import com.chaowei.chaoweistore.util.ResponseUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RolesController {
    @Autowired
    RoleService roleService;
    @RequiresPermissions("root")
    @RequestMapping("/admin/getRoleList")
    public Object getRolesList(){
        List<Role> list = roleService.getRole();
        return ResponseUtil.success(list);
    }

}
