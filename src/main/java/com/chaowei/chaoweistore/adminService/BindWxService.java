package com.chaowei.chaoweistore.adminService;

import me.chanjar.weixin.common.error.WxErrorException;

public interface BindWxService {

    String bindWx(String loginID,String loginKey,String code) throws WxErrorException;
}
