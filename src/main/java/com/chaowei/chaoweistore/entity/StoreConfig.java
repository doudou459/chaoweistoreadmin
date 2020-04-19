package com.chaowei.chaoweistore.entity;

public class StoreConfig {

    private String phone;
    private  String maker;
    private  String wx_appid_mp;
    private  String wx_appsecret;
    private String wx_appid_min;
    private  String wx_appsecrey_min;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getWx_appid_mp() {
        return wx_appid_mp;
    }

    public void setWx_appid_mp(String wx_appid_mp) {
        this.wx_appid_mp = wx_appid_mp;
    }

    public String getWx_appsecret() {
        return wx_appsecret;
    }

    public void setWx_appsecret(String wx_appsecret) {
        this.wx_appsecret = wx_appsecret;
    }

    public String getWx_appid_min() {
        return wx_appid_min;
    }

    public void setWx_appid_min(String wx_appid_min) {
        this.wx_appid_min = wx_appid_min;
    }

    public String getWx_appsecrey_min() {
        return wx_appsecrey_min;
    }

    public void setWx_appsecrey_min(String wx_appsecrey_min) {
        this.wx_appsecrey_min = wx_appsecrey_min;
    }

    @Override
    public String toString() {
        return "StoreConfig{" +
                "phone='" + phone + '\'' +
                ", maker='" + maker + '\'' +
                ", wx_appid_mp='" + wx_appid_mp + '\'' +
                ", wx_appsecret='" + wx_appsecret + '\'' +
                ", wx_appid_min='" + wx_appid_min + '\'' +
                ", wx_appsecrey_min='" + wx_appsecrey_min + '\'' +
                '}';
    }
}
