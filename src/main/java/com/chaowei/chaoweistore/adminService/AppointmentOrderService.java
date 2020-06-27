package com.chaowei.chaoweistore.adminService;

import com.chaowei.chaoweistore.entity.AppointmentOrder;

import java.util.List;

public interface AppointmentOrderService {
    List<AppointmentOrder> getOrderByCustomerID(int customerID);
    List<AppointmentOrder> getOrderByTime(long beginTime,long endTime);
    String changeTime(long newTime,long id);
    String cancelOrder(long id);
    String sureChange(long id);
    String addOrder( long id,  int customerId, String customerName, String phone,int itemId , String itemName,long appointmentTime,
                     String openid_min,  int state);
    List<AppointmentOrder> checkAppointmenNum(int itemId,long appointmentTime);

}
