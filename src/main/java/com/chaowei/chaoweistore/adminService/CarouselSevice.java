package com.chaowei.chaoweistore.adminService;

import com.chaowei.chaoweistore.entity.Carousel;

import java.util.List;

public interface CarouselSevice {
    List<Carousel> getCarouselList();
    String setCarousel(int id,String img_name,String detail);
    String addCarousel(String img_name,String detail);
    String deleteCarousel(int id);

}
