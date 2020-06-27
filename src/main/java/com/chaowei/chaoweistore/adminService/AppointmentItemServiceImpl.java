package com.chaowei.chaoweistore.adminService;

import com.chaowei.chaoweistore.entity.AppointmentItem;
import com.chaowei.chaoweistore.mapper.AppointmentItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
@Service
public class AppointmentItemServiceImpl implements AppointmentItemService {
    @Autowired
   private AppointmentItemMapper appointmentItemMapper;


    @Override
    public List<AppointmentItem> getAppointmentItemList() {
        return appointmentItemMapper.getAppointmentList();
    }

    @Override
    public String addAppointmentItem(String itemName, Time startTime, Time closeTime, int taktTime, int advanceDay, int max_people) {
        String result = "fail";
        int rowCount = appointmentItemMapper.addAppointmentItem(itemName,startTime,closeTime,taktTime,advanceDay,max_people);
        if(rowCount==1){
            result ="success";
        }
        return result;
    }

    @Override
    public String editAppointmentItem(int id, String itemName, Time startTime, Time closeTime, int taktTime, int advanceDay, int max_people, int openAppointment) {
        String result = "fail";
        int rowCount = appointmentItemMapper.upDateAppointmentItem(id, itemName, startTime, closeTime, taktTime, advanceDay, max_people,openAppointment);
        if(rowCount==1){
            result="success";
        }
        return result;
    }

    @Override
    public String deleteApponitmentItem(int id) {
        String result="fail";
        int rowCount = appointmentItemMapper.deleteAppointmentItem(id);
        if(rowCount==1){
            result="success";
        }
        return result;
    }

    @Override
    public List<AppointmentItem> getOpenAppointmentItemList() {
        return appointmentItemMapper.getOpenAppointmentItemList();
    }

    @Override
    public AppointmentItem getItemById(int id) {
        return appointmentItemMapper.getItemById(id);
    }
}
