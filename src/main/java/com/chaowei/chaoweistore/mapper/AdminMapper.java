package com.chaowei.chaoweistore.mapper;

import com.chaowei.chaoweistore.entity.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AdminMapper {

    @Select("select * From store_admin")
    List<Admin> getAdminList();

    @Select("select * From store_admin WHERE loginID=#{loginID}")
    Admin getAdminByLoginID(String loginID);

    @Select("select * From store_admin WHERE wx_openid_mp=#{wx_openid_mp}")
    Admin getAdminByWx_openid_mp(String wx_openid_mp);

    @Select("select * From store_admin WHERE wx_openid_min=#{wx_openid_min}")
    Admin getAdminByWx_openid_min(String wx_openid_min);

    @Select("select * From store_admin WHERE wx_unionid=#{wx_unionid}")
    Admin getAdminByWx_unionid(String wx_unionid);

    @Select("select * From store_admin WHERE id=#{id}")
    Admin getAdminByid(int id);

    @Update("UPDATE store_admin SET loginKey=#{newKey},wrongTime=#{wrongTime},lastLoginTime=#{lastLoginTime} WHERE loginID=#{loginID}")
    int changeLoginKey(@Param("loginID") String loginID, @Param("newKey") String newKey, @Param("wrongTime") int wrongTime, @Param("lastLoginTime") long lastLoginTime);

    @Update("UPDATE store_admin SET  loginTime=#{loginTime},wrongTime=#{wrongTime},lastLoginTime=#{lastLoginTime} WHERE loginID=#{loginID}")
    int doLogin(@Param("loginTime") long loginTime, @Param("wrongTime") int wrongTime, @Param("lastLoginTime") long lastLoginTime, @Param("loginID") String loginID);

    @Update("UPDATE store_admin SET wrongTime=#{wrongTime},lastLoginTime=#{lastLoginTime} WHERE loginID=#{loginID}")
    int updateWrongTime(@Param("wrongTime") int wrongTime,@Param("lastLoginTime") long lastLoginTime,@Param("loginID") String loginID);

    @Update("UPDATE store_admin SET loginTime=#{loginTime} WHERE loginID=#{loginID}")
    int updateLogin(@Param("loginID") String loginID,@Param("loginTime") long loginTime);

    @Update("UPDATE store_admin SET roles=#{roles} WHERE id=#{id}")
    int updateRoles(@Param("id") int id,@Param("roles") String roles);

    @Insert("INSERT INTO store_admin (loginID,loginKey,roles) VALUE (#{loginID},#{loginKey},#{roles})")
    int addAdmin(@Param("loginID") String loginID, @Param("loginKey") String loginKey,@Param("roles") String roles);

    @Update("UPDATE store_admin SET wx_openid_mp=#{wx_openid_mp},wx_openid_min=#{wx_openid_min},wx_unionid=#{wx_unionid},nick_name=#{nick_name},touxiang=#{touxiang} WHERE loginID=#{loginID}")
    int bindWx(@Param("loginID") String loginID,@Param("wx_openid_mp") String wx_openid_mp,@Param("wx_openid_min") String wx_openid_min,@Param("wx_unionid") String wx_unionid,@Param("nick_name") String nick_name,@Param("touxiang") String touxiang);

    @Delete("DELETE FROM store_admin WHERE id=#{id}")
    int deletAdmin(@Param("id") int id);
}
