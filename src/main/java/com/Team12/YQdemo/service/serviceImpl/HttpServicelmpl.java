package com.Team12.YQdemo.service.serviceImpl;

import com.Team12.YQdemo.dao.HttpMapper;
import com.Team12.YQdemo.bean.httpzhibo;
import com.Team12.YQdemo.service.HttpService;
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
