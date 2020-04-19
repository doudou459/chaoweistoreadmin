package com.chaowei.chaoweistore.entity;

public class ServerToUser {
    private int id;
    private int serverid;
    private int userid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getServerid() {
        return serverid;
    }

    public void setServerid(int serverid) {
        this.serverid = serverid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "ServerToUser{" +
                "id=" + id +
                ", serverid=" + serverid +
                ", userid=" + userid +
                '}';
    }
}
