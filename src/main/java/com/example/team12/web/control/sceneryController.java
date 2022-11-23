package com.example.team12.web.control;

import com.example.team12.bean.campus_scenery;
import com.example.team12.service.Impl.sceneryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/scenery")
public class sceneryController {

    @Autowired
    private sceneryServiceImpl sceneryserviceimpl;

    @GetMapping("/five")
    public List<campus_scenery> shuaxin()//返回五条图片url
    {
        return sceneryserviceimpl.refresh_five();
    }
    @GetMapping("/all")
    public List<campus_scenery> refresh_all(){
        return sceneryserviceimpl.refresh_all();
    }
    @PostMapping("/upload")
    public int shangchuang(@RequestBody Map map)//接受图片即插入url
    {
        return sceneryserviceimpl.upload_pic(map);
    }
    @PostMapping("/like")
    public int dianzan(@RequestBody Map map){//点赞即给点赞数加一
        return sceneryserviceimpl.give_a_like(map);
    }
    @PostMapping("/deny")
    public int jujue(@RequestBody Map map){//拒绝图片即删除
        return sceneryserviceimpl.deny(map);
    }
}
