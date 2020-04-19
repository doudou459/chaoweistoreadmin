package com.chaowei.chaoweistore.adminController;

import com.chaowei.chaoweistore.adminService.PromissionListService;
import com.chaowei.chaoweistore.entity.PromissionList;
import com.chaowei.chaoweistore.util.ResponseUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class PromissionListController {
    @Autowired
    PromissionListService promissionListService;
    @RequiresPermissions("root")
    @RequestMapping("/admin/getPromissionList")
    public Object getPromissionList(){
        List<PromissionList> list = promissionListService.getPromissionList();
        return  ResponseUtil.success(list);
    }

}
