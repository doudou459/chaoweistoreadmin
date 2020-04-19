package com.chaowei.chaoweistore.entity;

public class Promission {
    private int id;
    private String promission;
    private int roleid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPromission() {
        return promission;
    }

    public void setPromission(String promission) {
        this.promission = promission;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "Promission{" +
                "id=" + id +
                ", promission='" + promission + '\'' +
                ", roleid=" + roleid +
                '}';
    }
}
