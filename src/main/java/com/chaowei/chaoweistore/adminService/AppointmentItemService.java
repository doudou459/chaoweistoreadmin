package com.chaowei.chaoweistore.adminService;

import com.chaowei.chaoweistore.entity.AppointmentItem;

import java.sql.Time;
import java.util.List;

public interface AppointmentItemService {
    List<AppointmentItem> getAppointmentItemList();
    String addAppointmentItem(String itemName, Time startTime,Time closeTime,int taktTime,int advanceDay, int max_people);
    String editAppointmentItem(int id,String itemName, Time startTime,Time closeTime,int taktTime,int advanceDay, int max_people,int openAppointment);
    String deleteApponitmentItem(int id);
}
