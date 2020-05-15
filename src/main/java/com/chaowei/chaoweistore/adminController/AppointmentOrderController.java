package com.chaowei.chaoweistore.adminController;

import com.alibaba.fastjson.JSONObject;
import com.chaowei.chaoweistore.adminService.AppointmentOrderService;
import com.chaowei.chaoweistore.entity.AppointmentOrder;
import com.chaowei.chaoweistore.util.ResponseUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AppointmentOrderController {
    @Autowired
    AppointmentOrderService appointmentOrderService;

    @RequiresPermissions(value = {"root","admin","scanAppointment"}, logical = Logical.OR)
    @RequestMapping("/admin/getAppointmentOrder")
    public Object getAppointmentOrder(@RequestBody Map<String,String> jsonMap){
        Long beginTime = Long.valueOf(jsonMap.get("beginTime"));
        Long endTime = Long.valueOf(jsonMap.get("endTime"));
        List<AppointmentOrder> list =appointmentOrderService.getOrderByTime(beginTime,endTime);
        return ResponseUtil.success(list);
    }

}
