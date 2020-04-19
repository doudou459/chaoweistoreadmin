package com.chaowei.chaoweistore.adminService;

import com.chaowei.chaoweistore.entity.Promission;

import java.util.List;

public interface PromissionService {
    List<Promission>  getPromissionByRoleId(String roleid);

    String deletePromission(int id);

    String addPromission(String promission,int roleid);
}
