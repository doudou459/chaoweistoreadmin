package com.chaowei.chaoweistore.userController;

import com.chaowei.chaoweistore.adminService.AppointmentItemService;
import com.chaowei.chaoweistore.entity.AppointmentItem;
import com.chaowei.chaoweistore.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserAppointmentItemController {
   @Autowired
    AppointmentItemService appointmentItemService;
   @RequestMapping("/getAppointmentList")
   public Object getAppointmentList(){
       List<AppointmentItem> list = appointmentItemService.getOpenAppointmentItemList();
       return ResponseUtil.success(list);
   }

}
