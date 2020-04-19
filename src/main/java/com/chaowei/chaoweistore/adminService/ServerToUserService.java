package com.chaowei.chaoweistore.adminService;

import com.chaowei.chaoweistore.entity.ServerToUser;

import java.util.List;

public interface ServerToUserService {
    String changeServer(String newServerid,String userid);
    ServerToUser getMapByUserid(String userid);
    List<ServerToUser>getMapListByServerid(String serverid);
    String addMap(String serverid,String userid);
}
