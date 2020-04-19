package com.chaowei.chaoweistore.adminController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chaowei.chaoweistore.adminService.CarouselSevice;
import com.chaowei.chaoweistore.entity.Carousel;
import com.chaowei.chaoweistore.util.ResponseUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class StoreCarouselController {
    @Autowired
    CarouselSevice carouselSevice;
    @RequestMapping("/admin/getCarousel")
    @RequiresPermissions(value = {"root","admin","carousel"}, logical = Logical.OR)
    public Object getCarousel(){
        List<Carousel> list  = carouselSevice.getCarouselList();
        return ResponseUtil.success(list);
    }
    @RequestMapping("/admin/saveCarousel")
    @RequiresPermissions(value = {"root","admin","carousel"}, logical = Logical.OR)
    public Object saveCarousel(@RequestBody Map<String,String> jsonMap){
        JSONArray jsonArray = JSON.parseArray((String)jsonMap.get("carouselData"));
        int m = jsonArray.size();
        if(jsonArray==null||m==0){
            return  ResponseUtil.success();
        }else{
            for(int i=0;i<m;i++){
                JSONObject jsonObject =(JSONObject) jsonArray.getJSONObject(i).get("jsonData");
                if("stable".equals(jsonArray.getJSONObject(i).get("state"))){
                    continue;
                }else if("new".equals(jsonArray.getJSONObject(i).get("state"))){
                    carouselSevice.addCarousel(jsonObject.getString("img_name"),jsonObject.getString("detail"));
                    continue;
                }else if("delete".equals(jsonArray.getJSONObject(i).get("state"))){
                    carouselSevice.deleteCarousel(jsonObject.getInteger("id"));
                    continue;
                }else if("edit".equals(jsonArray.getJSONObject(i).get("state"))){
                    carouselSevice.setCarousel(jsonObject.getInteger("id"),jsonObject.getString("img_name"),jsonObject.getString("detail"));
                    continue;
                }
            }
            return  ResponseUtil.success();
        }
    }
}
