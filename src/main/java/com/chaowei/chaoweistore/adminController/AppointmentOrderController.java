package com.chaowei.chaoweistore.adminController;

import com.alibaba.fastjson.JSONObject;
import com.chaowei.chaoweistore.adminService.AppointmentItemService;
import com.chaowei.chaoweistore.adminService.AppointmentOrderService;
import com.chaowei.chaoweistore.adminService.UserService;
import com.chaowei.chaoweistore.entity.AppointmentItem;
import com.chaowei.chaoweistore.entity.AppointmentOrder;
import com.chaowei.chaoweistore.entity.User;
import com.chaowei.chaoweistore.util.ResponseUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class AppointmentOrderController {
    @Autowired
    AppointmentOrderService appointmentOrderService;
    @Autowired
    UserService userService;
    @Autowired
    AppointmentItemService appointmentItemService;

    @RequiresPermissions(value = {"root","admin","scanAppointment"}, logical = Logical.OR)
    @RequestMapping("/admin/getAppointmentOrder")
    public Object getAppointmentOrder(@RequestBody Map<String,String> jsonMap){
        Long beginTime = Long.valueOf(jsonMap.get("beginTime"));
        Long endTime = Long.valueOf(jsonMap.get("endTime"));
        List<AppointmentOrder> list =appointmentOrderService.getOrderByTime(beginTime,endTime);
        return ResponseUtil.success(list);
    }

    @RequiresPermissions(value = {"root","admin","scanAppointment"}, logical = Logical.OR)
    @RequestMapping("/admin/addNewAppointmenOrder")
    public Object addNewAppointmenOrder(@RequestBody Map<String,String> jsonMap) throws ParseException {
        String phone =  jsonMap.get("phone");
        int customerId=952700;//表示为客服生成的未有绑定账号的用户
        String  openid_min="";
        int state =0;
        long id = System.currentTimeMillis();
        String customerName = jsonMap.get("customerName");
        String itemName = jsonMap.get("itemName");
        int itemId = Integer.parseInt(jsonMap.get("itemId"));
        long appointmentTime =  Long.valueOf(jsonMap.get("appointmentTime"));
        long now = System.currentTimeMillis();
        if(appointmentTime<now){
         return   ResponseUtil.fail(402,"预约时间已过");
        }
        AppointmentItem appointmentItem = appointmentItemService.getItemById(itemId);
        long advaceTime = getAdvanceTime(appointmentItem.getAdvanceDay());
        if(appointmentTime>advaceTime){
            return ResponseUtil.fail(402,"超过最大可预约时间");
        }
        List<AppointmentOrder> list = appointmentOrderService.checkAppointmenNum(itemId,appointmentTime);
        if(list.size()>appointmentItem.getMax_people()){
            return ResponseUtil.fail(402,"该时间段预约人数已满");
        }
        User user = userService.getUserByphone(phone);
        if(user!=null){
            customerId=user.getId();
            openid_min=user.getWx_openid_min();
        }
        String result = appointmentOrderService.addOrder(id,customerId,customerName,phone,itemId,itemName,appointmentTime,openid_min,state);
        if(result.equals("success")){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",id);
            jsonObject.put("customerId",customerId);
            jsonObject.put("customerName",customerName);
            jsonObject.put("phone",phone);
            jsonObject.put("itemName",itemName);
            jsonObject.put("itemId",itemId);
            jsonObject.put("appointmentTime",appointmentTime);
            jsonObject.put("openid_min",openid_min);
            jsonObject.put("state",state);
            return ResponseUtil.success(jsonObject);
        }else{
            return ResponseUtil.fail(503,"新增失败");
        }

    }


    private static long getAdvanceTime(int advanceDays) throws ParseException {
        Date date = new Date();
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, advanceDays);//计算30天后的时间
        String str2=s.format(c.getTime());
        String newDateTime = str2 + " " + "23:59:59";
        SimpleDateFormat s2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date newDate = s2.parse(newDateTime);
        return  newDate.getTime();
    }

}
