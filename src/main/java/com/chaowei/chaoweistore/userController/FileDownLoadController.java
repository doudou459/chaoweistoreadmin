package com.chaowei.chaoweistore.userController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
@RestController
public class FileDownLoadController {
    @Value("${file.uploadFolder}")
    private String uploadFolder;
    //实现Spring Boot 的文件下载功能，映射网址为/download
    @RequestMapping("/downloadFile")
    public String downloadFile(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        // 获取指定目录下的第一个文件
        String path =uploadFolder ;
        String fileName = request.getParameter("fileName");
        // 如果文件名不为空，则进行下载
        if (fileName != null) {
            File file = new File(path + "/" + fileName);
            // 如果文件名存在，则进行下载
            if (file.exists()) {

                // 配置文件下载
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                // 下载文件能正常显示中文
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

                // 实现文件下载
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }


}
