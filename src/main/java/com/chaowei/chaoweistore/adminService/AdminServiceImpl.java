package com.chaowei.chaoweistore.adminService;

import com.chaowei.chaoweistore.entity.Admin;
import com.chaowei.chaoweistore.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> getAdminList() {
        return  adminMapper.getAdminList();
    }

    @Override
    public Admin getAdminByloginID(String loginID) {
        return adminMapper.getAdminByLoginID(loginID);
    }

    @Override
    public Admin getAdminByid(int id) {
        return adminMapper.getAdminByid(id);
    }

    @Override
    public Admin getAdminBywx_openid_mp(String wx_openid_mp) {
        return adminMapper.getAdminByWx_openid_mp(wx_openid_mp);
    }

    @Override
    public Admin getAdminBywx_openid_min(String wx_openid_min) {
        return adminMapper.getAdminByWx_openid_min(wx_openid_min);
    }

    @Override
    public Admin getAdminBywe_unionid(String wx_unionid) {
        return adminMapper.getAdminByWx_unionid(wx_unionid);
    }

    @Override
    public String bindWx(String loginID, String wx_openid_mp, String wx_openid_min, String wx_unionid,String nickName,String touxiang) {
        String result="fail";
        int rowCount = adminMapper.bindWx(loginID,wx_openid_mp,wx_openid_min,wx_unionid,nickName,touxiang);
        if(rowCount==1){
            result="success";
        }
        return result;
    }

    @Override
    public String setRoles(int id, String roles) {
        String result="fail";
        int rowCount=adminMapper.updateRoles(id,roles);
        if(rowCount==1){
            result="success";
        }
        return result;
    }

    @Override
    public String deleteAdmin(int id) {
        String result="fail";
        int rowCount=adminMapper.deletAdmin(id);
        if(rowCount==1){
            result="success";
        }
        return result;
    }

    @Override
    public String addAdmin(String LoginID, String LoginKey,String roles) {
        String result="fail";
        int rowCount=adminMapper.addAdmin(LoginID,LoginKey,roles);
        if(rowCount==1){
            result="success";
        }
        return result;
    }

    @Override
    public String changeLoginKey(String LoginID, String newKey) {
        String result="fail";
        int rowCount=adminMapper.changeLoginKey(LoginID,newKey,0,System.currentTimeMillis());
        if(rowCount==1){
            result="success";
        }
        return result;
    }

    @Override
    public String doLogin(String loginID) {
        String result="fail";
        long currentTime = System.currentTimeMillis();
        int rowCount=adminMapper.doLogin(currentTime,0,currentTime,loginID);
        if(rowCount==1){
            result="success";
        }
        return result;
    }

    @Override
    public String updateWrongTime(String loginID, int wrongTime) {
        String result="fail";
        long currentTime = System.currentTimeMillis();
        int rowCount=adminMapper.updateWrongTime(wrongTime,currentTime,loginID);
        if(rowCount==1){
            result="success";
        }
        return result;
    }

    @Override
    public String updataLoginTime(String loginID) {
        String result="fail";
        long currentTime = System.currentTimeMillis();
        int rowCount=adminMapper.updateLogin(loginID,currentTime);
        if(rowCount==1){
            result="success";
        }
        return result;
    }
}
