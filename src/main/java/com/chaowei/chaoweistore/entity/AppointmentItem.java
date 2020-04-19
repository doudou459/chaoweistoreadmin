package com.chaowei.chaoweistore.entity;

import java.sql.Time;

public class AppointmentItem {
   private int id;
   private String itemName;
   private Time startTime;
   private Time closeTime;
   private int taktTime;
   private int advanceDay;
   private int max_people;
   private int openAppointment;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Time closeTime) {
        this.closeTime = closeTime;
    }

    public int getTaktTime() {
        return taktTime;
    }

    public void setTaktTime(int taktTime) {
        this.taktTime = taktTime;
    }

    public int getAdvanceDay() {
        return advanceDay;
    }

    public void setAdvanceDay(int advanceDay) {
        this.advanceDay = advanceDay;
    }

    public int getMax_people() {
        return max_people;
    }

    public void setMax_people(int max_people) {
        this.max_people = max_people;
    }

    public int getOpenAppointment() {
        return openAppointment;
    }

    public void setOpenAppointment(int openAppointment) {
        this.openAppointment = openAppointment;
    }

    @Override
    public String toString() {
        return "AppointmentItem{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", startTime=" + startTime +
                ", closeTime=" + closeTime +
                ", taktTime=" + taktTime +
                ", advanceDay=" + advanceDay +
                ", max_people=" + max_people +
                ", openAppointment=" + openAppointment +
                '}';
    }
}
