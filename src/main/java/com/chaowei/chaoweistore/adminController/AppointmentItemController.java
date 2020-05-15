package com.chaowei.chaoweistore.adminController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.chaowei.chaoweistore.adminService.AppointmentItemService;
import com.chaowei.chaoweistore.entity.AppointmentItem;
import com.chaowei.chaoweistore.util.ResponseUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.List;
import java.util.Map;

@RestController
public class AppointmentItemController {
    @Autowired
    AppointmentItemService appointmentItemService;
    @RequiresPermissions(value = {"root","admin","setAppointment"}, logical = Logical.OR)
    @RequestMapping("/admin/getAppointmentItemList")
    public Object getAppointmentItemList(){
       List<AppointmentItem> list = appointmentItemService.getAppointmentItemList();
       return ResponseUtil.success(list);
    }

    private String TimeForm(String s){
        if(s==null){
           return "00:00:00";
        }
        int firstColon;
        int secondColon;
        firstColon = s.indexOf(':');
        secondColon = s.indexOf(':', firstColon+1);
        if(secondColon<0){
            s=s+":00";
        }
        return  s;
    };

    @RequiresPermissions(value = {"root","admin","setAppointment"}, logical = Logical.OR)
    @RequestMapping("/admin/saveAppointmentItemList")
    public Object saveAppointmentItem(@RequestBody Map<String,String> jsonMap){
        JSONArray jsonArray = JSON.parseArray((String)jsonMap.get("appointmentData"));
        int m = jsonArray.size();
        if(jsonArray==null||m==0){
            return  ResponseUtil.success();
        }else{
            for(int i=0;i<m;i++){
                JSONObject jsonObject =(JSONObject) jsonArray.getJSONObject(i).get("jsonData");
                if("stable".equals(jsonArray.getJSONObject(i).get("state"))){
                    continue;
                }else if("new".equals(jsonArray.getJSONObject(i).get("state"))){
                    System.out.println(jsonObject.toString());
                    System.out.println(jsonObject.getString("startTime"));
                     appointmentItemService.addAppointmentItem(jsonObject.getString("itemName"),Time.valueOf(TimeForm(jsonObject.getString("startTime"))),
                             Time.valueOf( TimeForm(jsonObject.getString("closeTime"))),jsonObject.getInteger("taktTime"),jsonObject.getInteger("advanceDay"),jsonObject.getInteger("max_people"));
                    continue;
                }else if("delete".equals(jsonArray.getJSONObject(i).get("state"))){
                     appointmentItemService.deleteApponitmentItem(jsonObject.getInteger("id"));
                    continue;
                }else if("edit".equals(jsonArray.getJSONObject(i).get("state"))){
                     appointmentItemService.editAppointmentItem(jsonObject.getInteger("id"),jsonObject.getString("itemName"),Time.valueOf(TimeForm(jsonObject.getString("startTime"))),
                             Time.valueOf( TimeForm(jsonObject.getString("closeTime"))),jsonObject.getInteger("taktTime"),jsonObject.getInteger("advanceDay"),
                             jsonObject.getInteger("max_people"),jsonObject.getInteger("openAppointment"));
                    continue;
                }
            }
            return  ResponseUtil.success();
        }
    }




}
