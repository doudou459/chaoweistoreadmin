package com.chaowei.chaoweistore.adminService;

import com.chaowei.chaoweistore.entity.Profile;
import com.chaowei.chaoweistore.mapper.ProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileMapper profileMapper;


    @Override
    public String setProfile(String profile) {
        String result = "fail";
        int rowCount = profileMapper.setProfile(profile);
        if(rowCount==1){
            result="success";
        }
        return result;
    }

    @Override
    public Profile getProfile() {
        return profileMapper.getProfile();
    }
}
