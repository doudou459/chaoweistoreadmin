package com.chaowei.chaoweistore.mapper;

import com.chaowei.chaoweistore.entity.AppointmentItem;
import org.apache.ibatis.annotations.*;

import java.sql.Time;
import java.util.List;

public interface AppointmentItemMapper {
    @Select("SELECT * FROM store_appointment_item")
    List<AppointmentItem> getAppointmentList();

    @Insert("INSERT INTO store_appointment_item (itemName,startTime,closeTime,taktTime,advanceDay,max_people,openAppointment)" +
            " VALUE (#{itemName},#{startTime},#{closeTime},#{taktTime},#{advanceDay},#{max_people},'1')")
    int addAppointmentItem(@Param("itemName") String itemName, @Param("startTime") Time startTime, @Param("closeTime") Time closeTime,
                           @Param("taktTime") int taktTime, @Param("advanceDay") int advanceDay, @Param("max_people") int max_people);

    @Update("UPDATE store_appointment_item SET itemName=#{itemName},startTime=#{startTime},closeTime=#{closeTime},taktTime=#{taktTime}," +
            "advanceDay=#{advanceDay},max_people=#{max_people},openAppointment=#{openAppointment} WHERE id=#{id}")
    int upDateAppointmentItem(@Param("id") int id, @Param("itemName") String itemName, @Param("startTime") Time startTime, @Param("closeTime") Time closeTime,
                              @Param("taktTime") int taktTime, @Param("advanceDay") int advanceDay, @Param("max_people") int max_people,@Param("openAppointment") int openAppointment);
    @Delete("DELETE FROM store_appointment_item WHERE id=#{id}")
    int deleteAppointmentItem(int id);
    @Select("SELECT * FROM store_appointment_item WHERE openAppointment=1")
    List<AppointmentItem> getOpenAppointmentItemList();
}
