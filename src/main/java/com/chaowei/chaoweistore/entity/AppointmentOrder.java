package com.chaowei.chaoweistore.entity;

public class AppointmentOrder {
    private long id;
    private int customerId;
    private String customerName;
    private String phone;
    private String itemName;
    private long appointmentTime;
    private String openid_min;
    private String state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public long getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(long appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getOpenid_min() {
        return openid_min;
    }

    public void setOpenid_min(String openid_min) {
        this.openid_min = openid_min;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "AppointmentOrder{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", phone='" + phone + '\'' +
                ", itemNamel='" + itemName + '\'' +
                ", appointmentTime=" + appointmentTime +
                ", openid_min='" + openid_min + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
