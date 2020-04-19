package com.chaowei.chaoweistore.entity;

public class Carousel {
    private  int id;
    private  String img_name;
    private  String detail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg_name() {
        return img_name;
    }

    public void setImg_name(String img_name) {
        this.img_name = img_name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Carousel{" +
                "id=" + id +
                ", img_name='" + img_name + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
