package com.example.team12.web.control;

import com.example.team12.bean.Bigevent;
import com.example.team12.service.Impl.BigeventmapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Bigeventcontroller {
    @Resource
    public BigeventmapperImpl bigeventmapper;

    @RequestMapping(value = "/bigevent")
    public Map<String,Object> getbigevent(@RequestParam("x") int x){
        x=(x-1)*10;
        List<Bigevent>bigevents = bigeventmapper.bigeventselect(x);
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("code",200);
        hashMap.put("message","请求成功");
        hashMap.put("data",bigevents);
        return hashMap;
    }


}
