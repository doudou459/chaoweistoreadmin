package com.chaowei.chaoweistore.adminController;

import com.chaowei.chaoweistore.adminService.ProfileService;
import com.chaowei.chaoweistore.entity.Profile;
import com.chaowei.chaoweistore.util.ResponseUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class StoreProfileController {
    @Autowired
    ProfileService profileService;

    @RequestMapping("/admin/getProfile")
    @RequiresPermissions(value = {"root","admin","profile"}, logical = Logical.OR)
    public Object getProfile(){
        Profile profile = profileService.getProfile();
        return ResponseUtil.success(profile.getProfile());
    }
    @RequestMapping("/admin/setProfile")
    @RequiresPermissions(value = {"root","admin","profile"}, logical = Logical.OR)
    public Object setProfile(@RequestBody Map<String,String> jsonMap){
        String profile = jsonMap.get("profile");
        String result = profileService.setProfile(profile);
       return ResponseUtil.success(result);
    }



}
