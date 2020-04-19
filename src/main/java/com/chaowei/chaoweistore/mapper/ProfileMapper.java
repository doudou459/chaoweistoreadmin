package com.chaowei.chaoweistore.mapper;

import com.chaowei.chaoweistore.entity.Profile;
import com.chaowei.chaoweistore.entity.StoreConfig;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ProfileMapper {
    @Update("UPDATE store_profile SET profile=#{profile} WHERE id=1")
    int setProfile(@Param("profile") String profile);

    @Select("SELECT id,profile FROM store_profile WHERE id=1")
    Profile getProfile();

    @Select(("SELECT id,phone,maker,wx_appid_mp,wx_appsecret,wx_appid_min,wx_appsecrey_min FROM store_profile WHERE id=1"))
    StoreConfig getStoreConfig();

    @Update("UPDATE store_profile SET phone=#{phone},maker=#{maker},wx_appid_mp=#{wx_appid_mp}," +
            "wx_appsecret=#{wx_appsecret},wx_appid_min=#{wx_appid_min},wx_appsecrey_min=#{wx_appsecrey_min} WHERE id=1")
    int setStoreConfig(@Param("phone") String phone, @Param("maker") String maker,
                   @Param("wx_appid_mp") String wx_appid_mp, @Param("wx_appsecret") String wx_appsecret,
                   @Param("wx_appid_min") String wx_appid_min, @Param("wx_appsecrey_min") String wx_appsecrey_min);


}
