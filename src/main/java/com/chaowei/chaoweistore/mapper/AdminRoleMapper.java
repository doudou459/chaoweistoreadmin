package com.chaowei.chaoweistore.mapper;

import com.chaowei.chaoweistore.entity.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminRoleMapper {

    @Select("select * From store_role")
    List<Role> getRoleList();

    @Select("select * From store_role WHERE id=#{id}")
    Role getRoleByID(String id);

    @Insert("INSERT INTO store_role(roleName,desc) VALUE (#{roleName},#{desc})")
    int addRole(@Param("roleName") String roleName, @Param("desc") String desc);

    @Delete("delete From store_role WHERE id=#{id}")
    int deleteRole(int id);

}
