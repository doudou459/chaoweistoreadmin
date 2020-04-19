package com.chaowei.chaoweistore.adminService;

import com.chaowei.chaoweistore.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserService {

    List<User> getUserList();

    String addUser(String nick_name,String touxiang ,String sex,String wx_openid_min,String wx_openid_mp,String wx_unionid,int user_level);

    String editUser(int id,String nick_name,String touxiang ,String sex,String wx_openid_min,String wx_openid_mp,String wx_unionid,int user_level);
}
