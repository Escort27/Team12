package com.example.team12.web.control;

import com.example.team12.service.Impl.sceneryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/scenery")
public class sceneryController {

    @Autowired
    private sceneryServiceImpl sceneryserviceimpl;

    @PostMapping("/refresh")
    public List<String> shuaxin()//返回五条图片url
    {
        return sceneryserviceimpl.refresh_five();
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
