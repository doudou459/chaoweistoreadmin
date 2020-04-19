package com.chaowei.chaoweistore.adminService;

import com.chaowei.chaoweistore.entity.ServerToUser;
import com.chaowei.chaoweistore.mapper.ServerToUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServerToUserServiceImpl implements ServerToUserService {
    @Autowired
    private ServerToUserMapper serverToUserMapper;
    @Override
    public String changeServer(String newServerid, String userid) {
         String result = "fail";
         int rowCount = serverToUserMapper.changeServer(newServerid,userid);
         if(rowCount==1){
             result = "success";
         }
        return result;
    }

    @Override
    public ServerToUser getMapByUserid(String userid) {
        return serverToUserMapper.getMapByUserId(userid);
    }

    @Override
    public List<ServerToUser> getMapListByServerid(String serverid) {
        return serverToUserMapper.getMapListByServerId(serverid);
    }

    @Override
    public String addMap(String serverid, String userid) {
        String result ="fail";
        int rowCount = serverToUserMapper.addMap(serverid,userid);
        if(rowCount==1){
            result="success";
        }
        return result;
    }
}
