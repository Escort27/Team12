package com.example.team12.web.control;

import com.example.team12.bean.httpzhibo;
import com.example.team12.service.Impl.Httpinsertservicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Httpinsercontrller {
    @Autowired
    Httpinsertservicelmpl httpinsertservicelmpl;
    @RequestMapping(value = "/insertzhibo")//和ajax请求中url相对应
    public String json(httpzhibo zhibo){
        System.out.println(zhibo);
        int f=httpinsertservicelmpl.addStreamline(zhibo.getWebsite(), zhibo.getSite());
        return "插入成功";
    }

}
