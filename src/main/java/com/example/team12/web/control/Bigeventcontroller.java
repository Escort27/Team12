package com.example.team12.web.control;

import com.example.team12.bean.Bigevent;
import com.example.team12.service.Impl.BigeventmapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Bigeventcontroller {
    @Resource
    public BigeventmapperImpl bigeventmapper;

    @RequestMapping(value = "/bigevent",method = RequestMethod.POST)
    public Map<String,Object> getbigevent(@RequestParam("x") int x){
        x=(x-1)*10;
        bigeventmapper.bigeventselect(x);
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("code",200);
        hashMap.put("message","请求成功");
        return hashMap;
    }
}
