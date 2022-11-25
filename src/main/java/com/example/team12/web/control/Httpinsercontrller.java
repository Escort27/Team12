package com.example.team12.web.control;

import com.example.team12.bean.Bigevent;
import com.example.team12.bean.httpzhibo;
import com.example.team12.service.Impl.Httpinsertservicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Httpinsercontrller {
    @Resource
    Httpinsertservicelmpl httpinsertservicelmpl;

    @PostMapping(value = "/insertzhibo")//和ajax请求中url相对应
    public int updatezhibo(@RequestBody Map map){
        return httpinsertservicelmpl.addStreamline(map);
    }


}
