package com.chaowei.chaoweistore.mapper;

import com.chaowei.chaoweistore.entity.AppointmentOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AppointmentOrderMapper {
    @Select("SELECT * FROM store_appointment_order WHERE customerId=#{customerID}")
    List<AppointmentOrder> getAppointmentOrderBycustomerID(int customerID);

    @Select("SELECT * FROM store_appointment_order WHERE id BETWEEN #{beginTime} AND #{endTime}")
    List<AppointmentOrder> getAppointmentOrderByTime(long beginTime,long endTime);

     @Insert("INSERT INTO store_appointment_order (id,customerId,customerName,phone,itemName,appointmentTime,openid_min,state) VALUE" +
             " (#{id},#{customerId},#{customerName},#{phone},#{itemName},#{appointmentTime},#{openid_min},#{state})")
    int addAppointmentOrder(@Param("id") long id, @Param("customerId") int customerId, @Param("customerName") String customerName,
                               @Param("phone") String phone, @Param("itemName") String itemName, @Param("appointmentTime") long appointmentTime,
                               @Param("openid_min") String openid_min, @Param("state") int state);
     @Update("UPDATE store_appointment_order SET appointmentTime=#{newTime},state='1' WHERE id=#{id}")
     int changeAppointmentTime(@Param("newTime") long newTime ,@Param("id") long id);

     @Update("UPDATE store_appointment_order SET state='0' WHERE id=#{id}")
     int sureChange(@Param("id") long id);
    @Update("UPDATE store_appointment_order SET state='2' WHERE id=#{id}")
     int cancelOrder(@Param("id") long id);
}
