package com.chaowei.chaoweistore.mapper;

import com.chaowei.chaoweistore.entity.PromissionList;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PromissionListMapper {

    @Select("SELECT * FROM store_promissionlist")
    List<PromissionList> getPromissionList();
}
