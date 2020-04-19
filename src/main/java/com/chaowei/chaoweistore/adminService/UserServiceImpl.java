package com.chaowei.chaoweistore.adminService;

import com.chaowei.chaoweistore.entity.User;
import com.chaowei.chaoweistore.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public String addUser(String nick_name, String touxiang, String sex, String wx_openid_min, String wx_openid_mp, String wx_unionid, int user_level) {
        String result="fail";
        int rowCount= userMapper.addUser(nick_name, touxiang, sex, wx_openid_min, wx_openid_mp, wx_unionid, user_level);
        if(rowCount==1){
            result="success";
        }
        return result;
    }

    @Override
    public String editUser(int id, String nick_name, String touxiang, String sex, String wx_openid_min, String wx_openid_mp, String wx_unionid, int user_level) {
        String result="fail";
        int rowCount= userMapper.editUser(id, nick_name, touxiang, sex, wx_openid_min, wx_openid_mp, wx_unionid, user_level);
        if(rowCount==1){
            result="success";
        }
        return result;
    }

}
