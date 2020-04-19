package com.chaowei.chaoweistore.adminService;

import com.chaowei.chaoweistore.entity.StoreConfig;
import com.chaowei.chaoweistore.mapper.ProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreConfigServiceImpl implements StoreConfigService {

    @Autowired
   private ProfileMapper profileMapper;


    @Override
    public String setStoreConfig(String phone, String maker, String wx_appid_mp, String wx_appsecret, String wx_appid_min, String wx_appsecrey_min) {
        String result = "fail";
        int rowCount = profileMapper.setStoreConfig(phone, maker, wx_appid_mp, wx_appsecret, wx_appid_min, wx_appsecrey_min);
        if(rowCount==1){
            result = "success";
        }
        return result;
    }

    @Override
    public StoreConfig getStoreConfig() {
        return profileMapper.getStoreConfig();
    }
}
