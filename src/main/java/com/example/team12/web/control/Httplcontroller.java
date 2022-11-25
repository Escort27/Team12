package com.example.team12.web.control;

import com.example.team12.bean.httpzhibo;
import com.example.team12.service.HttpService;
import com.example.team12.service.Impl.HttpServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Httplcontroller {
    @Autowired
    private HttpServicelmpl httpServicelmpl;

    @RequestMapping(value = "/zhibo",method = RequestMethod.GET)
    public Map<String,Object> getzhibo(){
        String httpzhibos = httpServicelmpl.httpquery();
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("code",200);
        hashMap.put("message","请求成功");
        hashMap.put("data",httpzhibos);
        return hashMap;
    }
    @RequestMapping(value = "httpquery")
    public Map<String,Object> httpquery(){
        List<httpzhibo> httpzhibos =httpServicelmpl.zhiboquery();
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("code",200);
        hashMap.put("message","请求成功");
        hashMap.put("data",httpzhibos);
        return hashMap;
    }


}
