package com.chaowei.chaoweistore.mapper;

import com.chaowei.chaoweistore.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM store_users")
    List<User> getUserList();

    @Select("SELECT * FROM store_users WHERE id=#{id}")
    User getUserByid(int id);

    @Select("SELECT * FROM store_users WHERE wx_openid_min=#{openid_min}")
    User getUserByOpenid(String openid_min);

    @Select("SELECT * FROM store_users WHERE wx_unionid=#{Unionid}")
    User getUserByUnionid(String Unionid);

    @Insert("INSERT INTO store_users (nick_name,touxiang,sex,wx_openid_min,wx_openid_mp,wx_unionid,user_level) VALUE (" +
            "#{nick_name},#{touxiang},#{sex},#{wx_openid_min},#{wx_openid_mp},#{wx_unionid},#{user_level})")
    int addUser(@Param("nick_name") String nick_name, @Param("touxiang") String touxiang, @Param("sex") String sex,
                @Param("wx_openid_min") String wx_openid_min, @Param("wx_openid_mp") String wx_openid_mp,
                @Param("wx_unionid") String wx_unionid, @Param("user_level") int user_level);
    @Update("UPDATE store_users SET nick_name=#{nick_name},touxiang=#{touxiang},sex=#{sex},wx_openid_min=#{wx_openid_min}," +
            "wx_openid_mp=#{wx_openid_mp},wx_unionid=#{wx_unionid},user_level=#{user_level} WHERE id=#{id}")
    int editUser(@Param("id") int id,@Param("nick_name") String nick_name,@Param("touxiang") String touxiang,
                 @Param("sex") String sex,@Param("wx_openid_min") String wx_openid_min,
                 @Param("wx_openid_mp") String wx_openid_mp,@Param("wx_unionid") String wx_unionid,@Param("user_level") int user_level);
}
