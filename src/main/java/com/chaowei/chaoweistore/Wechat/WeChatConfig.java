package com.chaowei.chaoweistore.Wechat;

import com.chaowei.chaoweistore.adminService.StoreConfigService;
import com.chaowei.chaoweistore.entity.Profile;

import com.chaowei.chaoweistore.adminService.ProfileService;
import com.chaowei.chaoweistore.entity.StoreConfig;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;

import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class WeChatConfig {
      @Autowired
    StoreConfigService storeConfigService;
     @Bean
     public WxMpService wxMpService(){
         WxMpService wxMpService = new WxMpServiceImpl();
         wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
         return wxMpService;
     }
     @Bean
     public WxMpDefaultConfigImpl wxMpConfigStorage(){
         WxMpDefaultConfigImpl wxMpConfigStorage =new WxMpDefaultConfigImpl();
         StoreConfig storeConfig = storeConfigService.getStoreConfig();
         wxMpConfigStorage.setAppId(storeConfig.getWx_appid_mp());
         wxMpConfigStorage.setSecret(storeConfig.getWx_appsecret());
         return wxMpConfigStorage;
     }

}
