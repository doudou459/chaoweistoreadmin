package com.chaowei.chaoweistore.adminController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chaowei.chaoweistore.adminService.AdminService;
import com.chaowei.chaoweistore.entity.Admin;
import com.chaowei.chaoweistore.util.ResponseUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;
import java.util.Map;


@RestController
public class AdminController {
    @Autowired
    AdminService adminService;
    @RequiresPermissions("root")
    @RequestMapping("/admin/getAdminList")
    public Object getAdminList(){
        List<Admin> list = adminService.getAdminList();
        return ResponseUtil.success(list);
    }
    @RequiresPermissions("root")
    @RequestMapping("/admin/saveAdmin")
    public  Object saveAdmin(@RequestBody Map<String, Object>jsonMap){
        JSONArray jsonArray = JSON.parseArray((String)jsonMap.get("adminData"));
        int m = jsonArray.size();
        if(jsonArray==null||m==0){
            return  ResponseUtil.success();
        }else{
            for(int i=0;i<m;i++){
                JSONObject jsonObject =(JSONObject) jsonArray.getJSONObject(i).get("jsonData");
                if("stable".equals(jsonArray.getJSONObject(i).get("state"))){
                    continue;
                }else if("new".equals(jsonArray.getJSONObject(i).get("state"))){
                    adminService.addAdmin(jsonObject.getString("loginID"),jsonObject.getString("loginKey"),jsonObject.getString("roles"));
                    continue;
                }else if("delete".equals(jsonArray.getJSONObject(i).get("state"))){
                    adminService.deleteAdmin(jsonObject.getInteger("id"));
                    continue;
                }else if("edit".equals(jsonArray.getJSONObject(i).get("state"))){
                    adminService.setRoles(jsonObject.getInteger("id"),jsonObject.getString("roles"));
                    continue;
                }
            }
            return  ResponseUtil.success();
        }

    }

}
