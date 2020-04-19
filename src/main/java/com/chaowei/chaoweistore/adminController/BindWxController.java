package com.chaowei.chaoweistore.adminController;

import com.chaowei.chaoweistore.adminService.BindWxService;
import com.chaowei.chaoweistore.util.ResponseUtil;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
public class BindWxController {

    @Autowired
    private BindWxService bindWxService;

    @RequestMapping("/admin/bindwx")
    public Object  bindWx(@RequestBody Map<String,String> jsonMap){
        HashMap hashMap = new HashMap();
        String loginID = jsonMap.get("loginID");
        String loginKey = jsonMap.get("loginKey");
        String code = jsonMap.get("code");
        if(code==null||code.isEmpty()){
            return ResponseUtil.lackArgument();
        }else{
            try {
                String result =bindWxService.bindWx(loginID,loginKey,code);
                if("success".equals(result)){
                    hashMap.put("result","success");
                }else{
                    hashMap.put("result","fail");
                    hashMap.put("msg",result);
                }
            } catch (WxErrorException e) {
                hashMap.put("result","fail");
                hashMap.put("msg",e.getMessage());
            }
        }
        return ResponseUtil.success(hashMap);
    }
}
