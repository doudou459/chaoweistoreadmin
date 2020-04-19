package com.chaowei.chaoweistore.adminService;

import com.chaowei.chaoweistore.entity.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAdminList();
    Admin getAdminByloginID(String loginID);
    Admin getAdminByid(int id);
    Admin getAdminBywx_openid_mp(String wx_openid_mp);
    Admin getAdminBywx_openid_min(String wx_openid_min);
    Admin getAdminBywe_unionid(String wx_unionid);
    String bindWx(String loginID,String wx_openid_mp,String wx_openid_min,String wx_unionid,String nickName,String touxiang);
    String setRoles(int id,String roles);
    String deleteAdmin(int id);
    String addAdmin(String LoginID,String LoginKey,String roles);
    String changeLoginKey(String LoginID,String newKey);
    String doLogin(String loginID);
    String updateWrongTime(String loginID,int wrongTime);
    String updataLoginTime(String loginID);
}
