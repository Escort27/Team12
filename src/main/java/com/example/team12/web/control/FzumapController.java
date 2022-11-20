package com.example.team12.web.control;

import com.example.team12.bean.fzumap;
import com.example.team12.service.Impl.FzuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cr
 * &#064;date   2022/11/11
 */
@RestController
@RequestMapping("/test")
public class FzumapController {
    @Autowired
    private FzuServiceImpl fzuService;
    //表明这是一个get类型的请求
    @RequestMapping(value = "/user_show",method = RequestMethod.GET)
   // @GetMapping("/user_show")
    public String User_show(String address){
        return fzuService.user_show(address);
    }
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @GetMapping("/update")
    public int updatedate(String address,String activity_name)
    {
        return fzuService.updatedate(address,activity_name);
    }
}
