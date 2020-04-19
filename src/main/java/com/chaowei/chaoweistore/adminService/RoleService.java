package com.chaowei.chaoweistore.adminService;

import com.chaowei.chaoweistore.entity.Role;

import java.util.List;

public interface RoleService {
    Role getRoleById(String id);
    List<Role> getRole();
    String addRole(String roleName,String decs);
    String deleteRole(int id);
}
