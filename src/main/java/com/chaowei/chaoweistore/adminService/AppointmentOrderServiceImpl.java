package com.chaowei.chaoweistore.adminService;

import com.chaowei.chaoweistore.entity.AppointmentOrder;
import com.chaowei.chaoweistore.mapper.AppointmentOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppointmentOrderServiceImpl implements AppointmentOrderService {
    @Autowired
    private AppointmentOrderMapper appointmentOrderMapper;

    @Override
    public List<AppointmentOrder> getOrderByCustomerID(int customerID) {
        return appointmentOrderMapper.getAppointmentOrderBycustomerID(customerID);
    }

    @Override
    public List<AppointmentOrder> getOrderByTime(long beginTime, long endTime) {
        return appointmentOrderMapper.getAppointmentOrderByTime(beginTime,endTime);
    }

    @Override
    public String changeTime(long newTime, long id) {
        String result ="fail";
        int rowCount =appointmentOrderMapper.changeAppointmentTime(newTime,id);
        if(rowCount==1){
            result = "success";
        }
        return result;
    }

    @Override
    public String cancelOrder(long id) {
        String result ="fail";
        int rowCount =appointmentOrderMapper.cancelOrder(id);
        if(rowCount==1){
            result = "success";
        }
        return result;
    }

    @Override
    public String addOrder(long id, int customerId, String customerName, String phone,int itemId, String itemName, long appointmentTime, String openid_min, int state) {
        String result ="fail";
        int rowCount =appointmentOrderMapper.addAppointmentOrder(id, customerId, customerName, phone,itemId, itemName, appointmentTime, openid_min, state);
        if(rowCount==1){
            result = "success";
        }
        return result;
    }

    @Override
    public String sureChange(long id) {
        String result ="fail";
        int rowCount =appointmentOrderMapper.sureChange(id);
        if(rowCount==1){
            result = "success";
        }
        return result;
    }



    @Override
    public List<AppointmentOrder> checkAppointmenNum(int itemId, long appointmentTime) {
        return appointmentOrderMapper.checkAppointmenNum(itemId,appointmentTime);
    }
}
