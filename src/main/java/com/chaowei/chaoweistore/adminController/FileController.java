package com.chaowei.chaoweistore.adminController;

import com.chaowei.chaoweistore.adminService.StoreFile;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
public class FileController {
    @Autowired
    StoreFile storeFile;
    @RequiresPermissions(value = {"root","admin","profile","carousel","setAppointment"}, logical = Logical.OR)
    @RequestMapping("/admin/uploadImg")
    public String uploadImg(@RequestParam("pictureImg") MultipartFile file){
        String result = storeFile.storeFile(file);
        return result;
    }

}
