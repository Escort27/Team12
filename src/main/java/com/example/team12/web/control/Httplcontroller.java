package com.example.team12.web.control;

import com.example.team12.bean.httpzhibo;
import com.example.team12.service.HttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zhibo")
public class Httplcontroller {
    @Autowired
    private HttpService httpService;

    @GetMapping("/query")
    public List<httpzhibo> query(){
        return httpService.query();
    }

}
