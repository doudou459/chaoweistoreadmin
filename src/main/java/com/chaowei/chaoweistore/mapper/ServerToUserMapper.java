package com.chaowei.chaoweistore.mapper;

import com.chaowei.chaoweistore.entity.ServerToUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ServerToUserMapper {
    @Insert("INSERT INTO store_server_to_user (serverid,userid) VALUE (#{serverid},#{userid})")
    int addMap(@Param("serverid") String serverid,@Param("userid") String userid);
    @Update("UPDATE store_server_to_user SET serverid=#{newServerid} WHERE userid=#{userid}")
    int changeServer(@Param("newServerid") String newServerid, @Param("userid") String userid);
    @Select("SELECT * FROM store_server_to_user WHERE userid=#{userid}")
    ServerToUser getMapByUserId(String userid);
    @Select("SELECT * FROM store_server_to_user WHERE serverid=#{serverid}")
    List<ServerToUser> getMapListByServerId(String serverid);



}
