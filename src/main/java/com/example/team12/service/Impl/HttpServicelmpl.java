package com.example.team12.service.Impl;

import com.example.team12.bean.httpzhibo;
import com.example.team12.dao.HttpMapper;
import com.example.team12.service.HttpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HttpServicelmpl implements HttpService {

    @Resource
    private HttpMapper httpMapper;


    @Override
    public String httpquery() {
        return httpMapper.query();
    }

    @Override
    public List<httpzhibo> zhiboquery(){
        return httpMapper.query2();
    }
}
