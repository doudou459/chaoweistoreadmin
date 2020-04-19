package com.chaowei.chaoweistore.adminService;

import com.chaowei.chaoweistore.entity.Admin;
import com.chaowei.chaoweistore.mapper.AdminMapper;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BindWxServiceImpl implements BindWxService {
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    WxMpService wxMpService;

    @Override
    public String bindWx(String loginID, String loginKey, String code) {
        String result = "fail";
        Admin admin = adminMapper.getAdminByLoginID(loginID);

        if(admin==null){
            result="wrongLoginID";
            return result;
        }
        if(admin.getLoginKey().equals(loginKey)){
            try {
                WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
                WxMpUser wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
                int rowCount = adminMapper.bindWx(loginID,wxMpUser.getOpenId(),"",wxMpUser.getUnionId(),wxMpUser.getNickname(),wxMpUser.getHeadImgUrl());
                if(rowCount==1){
                    result="success";
                }
            } catch (WxErrorException e) {
                result = e.getMessage();
                return result;
            }

        }else{
            result="wrongKey";
            return result;
        }
        return result;
    }
}
