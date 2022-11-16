package com.example.team12.web.control;

import com.example.team12.bean.back_photo;
import com.example.team12.service.Impl.photoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/watch")
public class photoController {

    @Autowired
    private static photoServiceImpl photoserviceimpl;

//    @RequestMapping(value = "/pic", method = RequestMethod.GET)
    @GetMapping("/pic")
    public static String photoshow(String user_name){
        return photoserviceimpl.getimg_path(user_name);
    }
}
