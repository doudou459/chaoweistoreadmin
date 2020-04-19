package com.chaowei.chaoweistore.adminService;

import com.chaowei.chaoweistore.entity.ServiceNews;

import java.util.List;

public interface ServiceNewsService {

    List<ServiceNews> getNewsListByUserid(int userid);
    String addNews(int userid,int serverid,String msgType,String textContent,String pictureUrl,String msgId,int msgClass);

}
