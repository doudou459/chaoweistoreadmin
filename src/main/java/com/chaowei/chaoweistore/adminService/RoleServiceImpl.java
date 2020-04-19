package com.chaowei.chaoweistore.adminService;

import com.chaowei.chaoweistore.entity.Role;
import com.chaowei.chaoweistore.mapper.AdminRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
   private AdminRoleMapper adminRoleMapper;

    @Override
    public Role getRoleById(String id) {
        return adminRoleMapper.getRoleByID(id);
    }

    @Override
    public List<Role> getRole() {
        return adminRoleMapper.getRoleList();
    }

    @Override
    public String addRole(String roleName, String decs) {
        String result="fail";
        int rowCount=adminRoleMapper.addRole(roleName,decs);
        if(rowCount==1){
            result="success";
        }
        return result;
    }

    @Override
    public String deleteRole(int id) {
        String result="fail";
        int rowCount=adminRoleMapper.deleteRole(id);
        if(rowCount==1){
            result="success";
        }
        return result;
    }
}
