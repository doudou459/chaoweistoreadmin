package com.chaowei.chaoweistore.entity;

public class User {
    private int id;
    private String nick_name;
    private String touxiang;
    private String sex;
    private String wx_openid_min;
    private String wx_openid_mp;
    private String wx_unionid;
    private int user_level;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getWx_openid_min() {
        return wx_openid_min;
    }

    public void setWx_openid_min(String wx_openid_min) {
        this.wx_openid_min = wx_openid_min;
    }

    public String getWx_openid_mp() {
        return wx_openid_mp;
    }

    public void setWx_openid_mp(String wx_openid_mp) {
        this.wx_openid_mp = wx_openid_mp;
    }

    public String getWx_unionid() {
        return wx_unionid;
    }

    public void setWx_unionid(String wx_unionid) {
        this.wx_unionid = wx_unionid;
    }

    public int getUser_level() {
        return user_level;
    }

    public void setUser_level(int user_level) {
        this.user_level = user_level;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nick_name='" + nick_name + '\'' +
                ", touxiang='" + touxiang + '\'' +
                ", sex='" + sex + '\'' +
                ", wx_openid_min='" + wx_openid_min + '\'' +
                ", wx_openid_mp='" + wx_openid_mp + '\'' +
                ", wx_unionid='" + wx_unionid + '\'' +
                ", user_level=" + user_level +
                ", phone='" + phone + '\'' +
                '}';
    }
}
