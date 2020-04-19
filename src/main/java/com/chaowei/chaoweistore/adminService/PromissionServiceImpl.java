package com.chaowei.chaoweistore.adminService;

import com.chaowei.chaoweistore.entity.Promission;
import com.chaowei.chaoweistore.mapper.AdminPromissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PromissionServiceImpl implements PromissionService {
    @Autowired
   private AdminPromissionMapper adminPromissionMapper;

    @Override
    public List<Promission> getPromissionByRoleId(String roleid) {
        List<Promission> list =adminPromissionMapper.getPromissionByRoleid(roleid);
        return list;
    }

    @Override
    public String deletePromission(int id) {
        String result="fail";
        int rowCount=adminPromissionMapper.deletePromission(id);
        if(rowCount==1){
            result="success";
        }
        return result;
    }

    @Override
    public String addPromission(String promission, int roleid) {
        String result="fail";
        int rowCount=adminPromissionMapper.addPromission(roleid,promission);
        if(rowCount==1){
            result="success";
        }
        return result;
    }
}
