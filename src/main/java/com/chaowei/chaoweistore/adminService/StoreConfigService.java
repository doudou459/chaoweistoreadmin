package com.chaowei.chaoweistore.adminService;

import com.chaowei.chaoweistore.entity.StoreConfig;

public interface StoreConfigService {

    String setStoreConfig(String phone,String maker,String wx_appid_mp,String wx_appsecret,String wx_appid_min,String wx_appsecrey_min);
    StoreConfig getStoreConfig();

}
