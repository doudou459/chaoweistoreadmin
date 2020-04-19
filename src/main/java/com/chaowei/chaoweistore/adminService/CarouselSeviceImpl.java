package com.chaowei.chaoweistore.adminService;

import com.chaowei.chaoweistore.entity.Carousel;
import com.chaowei.chaoweistore.mapper.CarouselMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarouselSeviceImpl implements CarouselSevice {
    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public List<Carousel> getCarouselList() {
        return carouselMapper.getCarouselList();
    }

    @Override
    public String setCarousel(int id, String img_name, String detail) {
        String result="fail";
        int rowCount = carouselMapper.setCarousel(id,img_name,detail);
        if(rowCount==1){
            result="success";
        }
        return result;
    }

    @Override
    public String addCarousel(String img_name, String detail) {
        String result="fail";
        int rowCount = carouselMapper.addCarousel(img_name,detail);
        if(rowCount==1){
            result="success";
        }
        return result;
    }

    @Override
    public String deleteCarousel(int id) {
        String result="fail";
        int rowCount = carouselMapper.deleteCarousel(id);
        if(rowCount==1){
            result="success";
        }
        return result;
    }
}
