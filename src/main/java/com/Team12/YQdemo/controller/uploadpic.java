package com.Team12.YQdemo.controller;

import com.Team12.YQdemo.service.serviceImpl.sceneryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
@CrossOrigin
@RestController
@RequestMapping("/uploadphoto")
public class uploadpic {

    @Autowired
    private sceneryServiceImpl sceneryserviceimpl;



    @PostMapping("/uploadppp")
    public String uploadpic(@RequestParam("file") MultipartFile file) throws Exception{
        //判断文件类型
        String pType=file.getContentType();
        pType=pType.substring(pType.indexOf("/")+1);

        if("jpeg".equals(pType)){
            pType="jpg";
        }
        long time=System.currentTimeMillis();
        //这里我采用绝对路径
        String path="/usr/images/"+time+"."+pType;

        try{
            file.transferTo(new File(path));
            //文件路径保存到数据库中从而读取
//            userService.addVatar("http://192.168.191.3:8081/"+path.substring(path.indexOf("images/")),user);
           String  picurlppp="http://119.91.217.141:8080/"+path.substring(path.indexOf("images/"));
//            String picurl= new String();
           uploadpic(picurlppp);
            return picurlppp;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "上传失败";
    }

    private void uploadpic(String picurl) {
        sceneryserviceimpl.uploadpicservice(picurl);
    }



}
