package com.chaowei.chaoweistore.util;

import java.util.HashMap;

import java.util.Map;


/**
 * 响应操作结果
 *
 *  {
 *      errno： 错误码，
 *      errmsg：错误消息，
 *      data：  响应数据
 *  }
 *
 *
 *
 * 错误码：
 *
 *  200，成功；
 *  4xx，前端错误：
 *
 * 401，参数缺失，前端没有传递后端需要的参数；
 * 402，参数类型错误，前端传递的参数值不符合。
 *
 *  5xx，后端错误：
 *
 *  501，未登陆，即要求用户登录；
 *  502，权限不足，即没有相关操作权限；
 *  503，程序错误，后端未知错误；
 *  504，更新数据失败，数据库增删改失败。
 *
 *
 */


public class ResponseUtil {

    public static Object success() {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", 200);
        obj.put("errmsg", "成功");
        return obj;
    }

    public static Object success(Object data) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", 200);
        obj.put("errmsg", "成功");
        obj.put("data", data);
        return obj;
    }

    public static Object fail() {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", 503);
        obj.put("errmsg", "程序错误");
        return obj;
    }

    public static Object fail(int errno, String errmsg) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", errno);
        obj.put("errmsg", errmsg);
        return obj;
    }

    public static Object lackArgument() {
        return fail(401, "参数缺失");
    }

    public static Object badArgument() {
        return fail(402, "参数类型错误");
    }

    public static Object unlogin() {
        return fail(501, "请登录");
    }

    public static Object unauthz() {
        return fail(502, "权限不足");
    }

    public static Object updatedDataFailed() {
        return fail(504, "更新数据失败");
    }



}
