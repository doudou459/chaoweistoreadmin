package com.chaowei.chaoweistore.mapper;

import com.chaowei.chaoweistore.entity.Promission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminPromissionMapper {
    @Select("select * From store_promission WHERE roleid=#{roleid}")
    List<Promission> getPromissionByRoleid(String roleid);

    @Insert("INSERT INTO store_promission (roleid,promission) VALUE (#{roleid},#{promission})")
    int addPromission(@Param("roleid") int roleid, @Param("promission") String promission);

    @Delete("delete From store_promission WHERE id=#{id}")
    int deletePromission(int id);
}
