package com.chaowei.chaoweistore.adminService;

import com.chaowei.chaoweistore.entity.PromissionList;
import com.chaowei.chaoweistore.mapper.PromissionListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PromissionListServiceImpl implements PromissionListService {

    @Autowired
    PromissionListMapper promissionListMapper;


    @Override
    public List<PromissionList> getPromissionList() {
        return promissionListMapper.getPromissionList();
    }
}
