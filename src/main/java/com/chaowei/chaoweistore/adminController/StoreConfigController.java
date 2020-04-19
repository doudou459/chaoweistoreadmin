package com.chaowei.chaoweistore.adminController;

import com.chaowei.chaoweistore.adminService.StoreConfigService;
import com.chaowei.chaoweistore.entity.StoreConfig;
import com.chaowei.chaoweistore.util.ResponseUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
public class StoreConfigController {

    @Autowired
    private StoreConfigService storeConfigService;
    @RequiresPermissions("root")
    @RequestMapping("/admin/getStoreConfig")
    public Object getStoreConfig(){
        HashMap hashMap = new HashMap();
        StoreConfig storeConfig =storeConfigService.getStoreConfig();
        hashMap.put("phone",storeConfig.getPhone());
        hashMap.put("maker",storeConfig.getMaker());
        hashMap.put("wxAppidMp",storeConfig.getWx_appid_mp());
        hashMap.put("wxAppsecret",storeConfig.getWx_appsecret());
        hashMap.put("wxAppidMin",storeConfig.getWx_appid_min());
        hashMap.put("wxAppsecreyMin",storeConfig.getWx_appsecrey_min());
        return ResponseUtil.success(hashMap);
    }
    @RequiresPermissions("root")
    @RequestMapping("/admin/setStoreConfig")
    public Object setStoreConfig(@RequestBody Map<String,String> jsonMap){
        HashMap hashMap = new HashMap();
        String phone = jsonMap.get("phone");
        String maker = jsonMap.get("maker");
        String wx_appid_mp = jsonMap.get("wxAppidMp");
        String wx_appsecret = jsonMap.get("wxAppsecret");
        String wx_appid_min = jsonMap.get("wxAppidMin");
        String wx_appsecrey_min = jsonMap.get("wxAppsecreyMin");
        String result = storeConfigService.setStoreConfig(phone,maker,wx_appid_mp,wx_appsecret,wx_appid_min,wx_appsecrey_min);
        hashMap.put("result",result);
        return ResponseUtil.success(hashMap);
    }
}
