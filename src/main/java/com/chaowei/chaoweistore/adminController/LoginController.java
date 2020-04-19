package com.chaowei.chaoweistore.adminController;

import com.chaowei.chaoweistore.adminService.AdminService;
import com.chaowei.chaoweistore.util.ResponseUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
public class LoginController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/admin/login")
    public Object doLogin(@RequestBody Map<String,String> jsonMap){
        HashMap hashMap = new HashMap();
        String loginID = jsonMap.get("loginID");
        String loginKey = jsonMap.get("loginKey");
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(new UsernamePasswordToken(loginID, loginKey));
            currentUser = SecurityUtils.getSubject();
            currentUser.hasRole("");
            hashMap.put("result","success");
            hashMap.put("chaoweiStoreToken",currentUser.getSession().getId());
            hashMap.put("permissions",currentUser.getSession().getAttribute("permissions").toString());
        }catch (UnknownAccountException e) {
            hashMap.put("result","error");
            hashMap.put("msg",e.getMessage());

        }catch (IncorrectCredentialsException e) {
            hashMap.put("result","fail");
            hashMap.put("msg",e.getMessage());

        } catch (LockedAccountException e) {
            hashMap.put("result","fail");
            hashMap.put("msg",e.getMessage());

        } catch (AuthenticationException e) {
            hashMap.put("result","error");
            hashMap.put("msg",e.getMessage());
        }
        return ResponseUtil.success(hashMap);
    };

    @RequestMapping("/admin/unlogin")
    public Object unlogin(){
        return ResponseUtil.unlogin() ;
    }

    @RequestMapping("/admin/502")
    public Object unauthz(){
        return ResponseUtil.unauthz() ;
    }
}
