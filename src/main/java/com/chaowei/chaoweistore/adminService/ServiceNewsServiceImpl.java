package com.chaowei.chaoweistore.adminService;

import com.chaowei.chaoweistore.entity.ServiceNews;
import com.chaowei.chaoweistore.mapper.ServiceNewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceNewsServiceImpl implements ServiceNewsService {
    @Autowired
  private   ServiceNewsMapper serviceNewsMapper;

    @Override
    public List<ServiceNews> getNewsListByUserid(int userid) {
        return serviceNewsMapper.getServiceNewsByUserid(userid);
    }

    @Override
    public String addNews(int userid, int serverid, String msgType, String textContent, String pictureUrl, String msgId, int msgClass) {
        String result = "fail";
        int rowCount = serviceNewsMapper.addNews(userid, serverid, msgType, textContent, pictureUrl, msgId, msgClass);
        if(rowCount==1){
            result="success";
        }
        return result;
    }
}
