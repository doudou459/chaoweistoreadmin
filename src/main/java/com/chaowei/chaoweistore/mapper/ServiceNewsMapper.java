package com.chaowei.chaoweistore.mapper;

import com.chaowei.chaoweistore.entity.ServiceNews;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ServiceNewsMapper {
    @Insert("INSERT INTO store_service_news(userid,serverid,msgType,textContent,pictureUrl,msgId,msgClass) VALUE (" +
            "#{userid},#{serverid},#{msgType},#{textContent},#{pictureUrl},#{msgId},#{msgClass})")
    int addNews(@Param("userid") int userid, @Param("serverid") int serverid,
                @Param("msgType") String msgType, @Param("textContent") String textContent,
                @Param("pictureUrl") String pictureUrl, @Param("msgId") String msgId , @Param("msgClass") int msgClass);

    @Select("SELECT * FROM store_service_news WHERE userid =#{userid}")
    List<ServiceNews> getServiceNewsByUserid(int userid);



}
