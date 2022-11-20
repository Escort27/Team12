package com.example.team12.web.control;

import com.example.team12.bean.fzumap;
import com.example.team12.service.Impl.FzuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @RequestMapping(value = "/user_show",method = RequestMethod.GET)//返回地图所有的信息
   // @GetMapping("/user_show")
    public List<fzumap> User_show(){
        return fzuService.user_show();
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)//管理员端修改地址对应活动信息
    //@GetMapping("/update")
    public void updatedate(@RequestBody Map map)//用requestbody防止400错误
    {
         fzuService.updatedate(map);
    }
}
