package com.chaowei.chaoweistore.mapper;

import com.chaowei.chaoweistore.entity.Carousel;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CarouselMapper {
    @Select("SELECT * FROM store_carousel")
    List<Carousel>getCarouselList();
    @Update("UPDATE store_carousel SET img_name=#{img_name},detail=#{detail} WHERE id=#{id}")
    int setCarousel(@Param("id") int id, @Param("img_name") String img_name , @Param("detail") String detail);
    @Insert("INSERT INTO store_carousel (img_name,detail) VALUE (#{img_name},#{detail})")
    int addCarousel(@Param("img_name") String img_name,@Param("detail") String detail);
    @Delete("DELETE FROM store_carousel WHERE id=#{id}")
    int deleteCarousel(int id);

}
