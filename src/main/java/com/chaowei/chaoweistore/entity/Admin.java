package com.chaowei.chaoweistore.entity;

import java.util.Arrays;

public class Admin {
    private int id;
    private String loginID;
    private String loginKey;
    private String roles;
    private long loginTime;
    private int wrongTime;
    private long lastLongTime;
    private String wx_openid_mp;
    private String wx_openid_min;
    private String wx_unionid;
    private String nick_name;
    private String touxiang;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getLoginKey() {
        return loginKey;
    }

    public void setLoginKey(String loginKey) {
        this.loginKey = loginKey;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String  roles) {
        this.roles = roles;
    }

    public long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(long loginTime) {
        this.loginTime = loginTime;
    }

    public int getWrongTime() {
        return wrongTime;
    }

    public void setWrongTime(int wrongTime) {
        this.wrongTime = wrongTime;
    }

    public long getLastLongTime() {
        return lastLongTime;
    }

    public void setLastLongTime(long lastLongTime) {
        this.lastLongTime = lastLongTime;
    }

    public String getWx_openid_mp() {
        return wx_openid_mp;
    }

    public void setWx_openid_mp(String wx_openid_mp) {
        this.wx_openid_mp = wx_openid_mp;
    }

    public String getWx_openid_min() {
        return wx_openid_min;
    }

    public void setWx_openid_min(String wx_openid_min) {
        this.wx_openid_min = wx_openid_min;
    }

    public String getWx_unionid() {
        return wx_unionid;
    }

    public void setWx_unionid(String wx_unionid) {
        this.wx_unionid = wx_unionid;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getTouxiang() {
        return touxiang;
    }

    public void setTouxiang(String touxiang) {
        this.touxiang = touxiang;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", loginID='" + loginID + '\'' +
                ", loginKey='" + loginKey + '\'' +
                ", roles=" + roles +
                ", loginTime=" + loginTime +
                ", wrongTime=" + wrongTime +
                ", lastLongTime=" + lastLongTime +
                ", wx_openid_mp='" + wx_openid_mp + '\'' +
                ", wx_openid_min='" + wx_openid_min + '\'' +
                ", wx_unionid='" + wx_unionid + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", touxiang='" + touxiang + '\'' +
                '}';
    }
}
