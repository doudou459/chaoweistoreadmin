package com.chaowei.chaoweistore.entity;

public class ServiceNews {
    private long id;
    private int userid;
    private int serverid;
    private String msgType;
    private String textContent;
    private String pictureUrl;
    private String msgId;
    private int msgClass;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getServerid() {
        return serverid;
    }

    public void setServerid(int serverid) {
        this.serverid = serverid;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public int getMsgClass() {
        return msgClass;
    }

    public void setMsgClass(int msgClass) {
        this.msgClass = msgClass;
    }

    @Override
    public String toString() {
        return "ServiceNews{" +
                "id=" + id +
                ", userid=" + userid +
                ", serverid=" + serverid +
                ", msgType='" + msgType + '\'' +
                ", textContent='" + textContent + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", msgId='" + msgId + '\'' +
                ", msgClass=" + msgClass +
                '}';
    }
}
